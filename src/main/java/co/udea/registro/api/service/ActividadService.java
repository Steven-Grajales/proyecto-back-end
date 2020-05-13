package co.udea.registro.api.service;

import co.udea.registro.api.exception.DataNotFoundException;
import co.udea.registro.api.exception.InvalidDateException;
import co.udea.registro.api.exception.MissDataException;
import co.udea.registro.api.model.Actividad;
import co.udea.registro.api.repository.ActividadRepository;
import co.udea.registro.api.model.ActividadWrapper;
import co.udea.registro.api.repository.CursoRepository;
import co.udea.registro.api.repository.DocenteRepository;
import co.udea.registro.api.util.Messages;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class ActividadService {

    private Messages messages;
    private ActividadRepository actividadRepository;
    private DocenteRepository docenteRepository;
    private CursoRepository cursoRepository;

    public ActividadService(Messages messages, ActividadRepository actividadRepository, DocenteRepository docenteRepository, CursoRepository cursoRepository){
        this.messages = messages;
        this.actividadRepository = actividadRepository;
        this.docenteRepository = docenteRepository;
        this.cursoRepository = cursoRepository;
    }

    public List<ActividadWrapper> getActividades(){
        List<ActividadWrapper> actividades = new ArrayList<ActividadWrapper>();
        for(Actividad actividad: actividadRepository.findAllByEstado("activa")){
            actividades.add(new ActividadWrapper(actividad));
        }
        return actividades;
    }

    public ActividadWrapper registrarActividad(ActividadWrapper actividad) throws ParseException {
        validarCampos(actividad);

        try{
            actividad.setCodigo(actividadRepository.encontrarIdMayor()+1);
        }catch(Exception e){
           actividad.setCodigo(1);
        }
        actividad.setEstado("activa");

        return new ActividadWrapper(actividadRepository.save(parseActividad(actividad)));
    }

    public List<ActividadWrapper> actividadesDeCurso(String id){
        List<ActividadWrapper> actividades = new ArrayList<ActividadWrapper>();
        for(Actividad actividad: actividadRepository.actividadesDeCurso(id)){
            actividades.add(new ActividadWrapper(actividad));
        }
        return actividades;
    }

    public ActividadWrapper eliminarActividad(int id) {
        Optional<Actividad> actividad = actividadRepository.findById(id);
        if(!actividad.isPresent()){
            throw new DataNotFoundException(messages.get("exception.not_found.activity"));
        }

        actividad.get().setEstado("inactiva");
        return new ActividadWrapper(actividadRepository.save(actividad.get()));
    }

    public ActividadWrapper actulizarActividad(ActividadWrapper actividad) throws ParseException {
        Optional<Actividad> actividadTemp = actividadRepository.findById(actividad.getCodigo());
        if(!actividadTemp.isPresent()){
            throw new DataNotFoundException(messages.get("exception.not_found.activity"));
        }

        return new ActividadWrapper(actividadRepository.save(parseActividad(actividad)));
    }

    private void validarCampos(ActividadWrapper actividad) throws ParseException {
        if(actividad.getSemestre().isEmpty() || actividad.getDuracion() == 0 || actividad.getCurso().isEmpty() ||
            actividad.getDescripcion().isEmpty() || actividad.getDocente().isEmpty() || actividad.getTipo().isEmpty()){
            throw new MissDataException(messages.get("exception.miss_data.activity"));
        }

        Date fecha = new SimpleDateFormat("yyyy-MM-dd").parse(actividad.getFecha());
        Date hoy = new Date();

        if(fecha.before(hoy)){
            throw new InvalidDateException(messages.get("exception.invalid_date.activity"));
        }
    }

    private Actividad parseActividad(ActividadWrapper actividad) throws ParseException {
        return new Actividad(actividad.getCodigo(), actividad.getSemestre(), actividad.getDuracion(),
                    new SimpleDateFormat("yyyy-MM-dd").parse(actividad.getFecha()), actividad.getDescripcion(),
                    actividad.getTipo(), actividad.getEstado(), docenteRepository.getOne(actividad.getDocente()),
                    cursoRepository.getOne(actividad.getCurso()));
    }
}

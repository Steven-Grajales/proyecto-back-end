package co.udea.registro.api.service;

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
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

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
        for(Actividad actividad: actividadRepository.findAll()){
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

        return new ActividadWrapper(actividadRepository.save(new Actividad(actividad.getCodigo(), actividad.getSemestre(), actividad.getDuracion(),
                new SimpleDateFormat("yyyy-MM-dd").parse(actividad.getFecha()), actividad.getDescripcion(), actividad.getTipo(), actividad.getEstado(),
                docenteRepository.getOne(actividad.getDocente()), cursoRepository.getOne(actividad.getCurso()))));
    }

    public List<ActividadWrapper> actividadesDeCurso(String id){
        List<ActividadWrapper> actividades = new ArrayList<ActividadWrapper>();
        for(Actividad actividad: actividadRepository.actividadesDeCurso(id)){
            actividades.add(new ActividadWrapper(actividad));
        }
        return actividades;
    }

    private void validarCampos(ActividadWrapper actividad) throws ParseException {
        if(actividad.getSemestre().isEmpty() || actividad.getDuracion() == 0 || actividad.getCurso().isEmpty() ||
            actividad.getDescripcion().isEmpty() || actividad.getDocente().isEmpty() || actividad.getTipo().isEmpty() ||
            actividad.getEstado().isEmpty()){
            throw new MissDataException(messages.get("exception.miss_data.activity"));
        }

        Date fecha = new SimpleDateFormat("yyyy-MM-dd").parse(actividad.getFecha());
        Date hoy = new Date();

        if(fecha.before(hoy)){
            throw new InvalidDateException(messages.get("exception.invalid_date.activity"));
        }
    }

}

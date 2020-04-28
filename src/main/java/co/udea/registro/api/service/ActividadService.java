package co.udea.registro.api.service;

import co.udea.registro.api.model.Actividad;
import co.udea.registro.api.repository.ActividadRepository;
import co.udea.registro.api.util.ActividadWrapper;
import co.udea.registro.api.util.Messages;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ActividadService {

    private Messages messages;
    private ActividadRepository actividadRepository;

    public ActividadService(Messages messages, ActividadRepository actividadRepository){
        this.messages = messages;
        this.actividadRepository = actividadRepository;
    }

    public List<ActividadWrapper> getActividades(){
        List<ActividadWrapper> actividades = new ArrayList<ActividadWrapper>();
        for(Actividad actividad: actividadRepository.findAll()){
            actividades.add(new ActividadWrapper(actividad));
        }
        return actividades;
    }

}

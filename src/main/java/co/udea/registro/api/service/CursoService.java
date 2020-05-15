package co.udea.registro.api.service;

import co.udea.registro.api.exception.DataNotFoundException;
import co.udea.registro.api.model.Curso;
import co.udea.registro.api.repository.CursoRepository;
import co.udea.registro.api.model.CursoWrapper;
import co.udea.registro.api.util.Messages;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CursoService {

    private Messages messages;
    private CursoRepository cursoRepository;

    public CursoService(Messages messages, CursoRepository cursoRepository){
        this.messages = messages;
        this.cursoRepository = cursoRepository;
    }

    public List<CursoWrapper> getCursos() {
        List<CursoWrapper> cursos = new ArrayList<CursoWrapper>();
        for(Curso curso: cursoRepository.findAllByEstado("activo")){
            cursos.add(new CursoWrapper(curso));
        }
        return cursos;
    }

    public CursoWrapper consultarCurso(String codigo) {
        Optional<Curso> curso = cursoRepository.findById(codigo);
        if(!curso.isPresent()){
            throw new DataNotFoundException(messages.get("exception.not_found.course"));
        }

        return new CursoWrapper(curso.get());
    }
}

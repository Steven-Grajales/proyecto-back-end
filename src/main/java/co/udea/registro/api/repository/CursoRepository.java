package co.udea.registro.api.repository;

import co.udea.registro.api.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CursoRepository extends JpaRepository<Curso, String> {

    List<Curso> findAllByEstado(String estado);

}

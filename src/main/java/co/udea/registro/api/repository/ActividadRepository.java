package co.udea.registro.api.repository;

import co.udea.registro.api.model.Actividad;
import co.udea.registro.api.model.ActividadWrapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActividadRepository extends JpaRepository<Actividad, Integer> {

    @Query("SELECT MAX(a.id) from Actividad a")
    int encontrarIdMayor();

    @Query("select a from Actividad a where a.curso.codigo = ?1")
    List<Actividad> actividadesDeCurso(String id);

    List<Actividad> findAllByEstado(String estado);

}

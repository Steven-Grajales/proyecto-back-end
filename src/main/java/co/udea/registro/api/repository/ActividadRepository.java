package co.udea.registro.api.repository;

import co.udea.registro.api.model.Actividad;
import co.udea.registro.api.model.ActividadWrapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ActividadRepository extends JpaRepository<Actividad, Integer> {

    @Query("SELECT MAX(a.id) from Actividad a")
    int encontrarIdMayor();

}

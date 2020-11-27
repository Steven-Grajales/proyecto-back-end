package co.udea.registro.api.service;

import co.udea.registro.api.RegistroApiApplication;
import co.udea.registro.api.model.*;

import co.udea.registro.api.repository.ActividadRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ActividadServiceTest {

    @Mock
    private ActividadRepository actividadRepository;

    @InjectMocks
    private ActividadService actividadService;

    @BeforeEach
    public void setup(){

    }

    @Test
    public void testConsultarActividad() throws ParseException {
        Actividad actividad = new Actividad();
        actividad.setId(2);
        actividad.setEstado("inactiva");
        actividad.setCurso(new Curso());
        actividad.getCurso().setCodigo("2");
        actividad.getCurso().setNombre("Álgebra");
        actividad.setDocente(new Docente());
        actividad.getDocente().setId("1");
        actividad.getDocente().setNombre("Rigoberto");
        actividad.setDuracion(2);
        actividad.setSemestre("2020-1");
        actividad.setDescripcion("Examen de 2 horas");
        actividad.setTipo("clase examen");
        actividad.setFecha(new SimpleDateFormat("yyyy-MM-dd").parse("2020-05-20"));


        ActividadWrapper esperado = new ActividadWrapper(actividad);
        when(actividadRepository.findById(2)).thenReturn(Optional.of(actividad));

        ActividadWrapper actual = actividadService.consultarActividad(2);

        assertThat(actual.getCodigo()).isEqualTo(esperado.getCodigo());

    }

}
package co.udea.registro.api.service;

import co.udea.registro.api.RegistroApiApplication;
import co.udea.registro.api.model.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.TestPropertySource;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.mockito.Mockito.mock;

@SpringBootTest
@ContextConfiguration(classes = {RegistroApiApplication.class})
//@TestPropertySource("classpath:test.properties")
public class ActividadServiceTest {

    @Autowired
    private ActividadService actividadService;

    @Autowired
    public ActividadServiceTest() {
        this.actividadService = actividadService;
    }

    @Before
    public void init(){
        this.actividadService = mock(ActividadService.class);
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
        ActividadWrapper actual = actividadService.consultarActividad(2);

        Assert.assertEquals(esperado,actual);
    }

}
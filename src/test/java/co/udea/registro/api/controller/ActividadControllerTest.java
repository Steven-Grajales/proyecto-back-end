package co.udea.registro.api.controller;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;


@SpringBootTest
public class ActividadControllerTest {

    private int port = 8080;

    TestRestTemplate restTemplate = new TestRestTemplate();

    HttpHeaders headers = new HttpHeaders();

    @Test
    public void testConsultarActividad (){
        HttpEntity<String> entity = new HttpEntity<>(null, headers);

        ResponseEntity<String> actual = restTemplate.exchange(
                createURLWithPort("registro-api/actividades/2"),
                HttpMethod.GET, entity, String.class);

        String expected = "{\"codigo\":2,\"estado\":\"inactiva\",\"curso\":\"2 - Álgebra\",\"docente\":\"1 - Rigoberto\",\"fecha\":\"20/5/2020\",\"duracion\":2,\"semestre\":\"2020-1\",\"descripcion\":\"Examen de 2 horas\",\"tipo\":\"clase examen\"}";

        Assert.assertEquals(expected, actual.getBody());
    }

    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }

}

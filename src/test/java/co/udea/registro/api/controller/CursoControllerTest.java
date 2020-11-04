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
public class CursoControllerTest {

    private int port = 8080;

    TestRestTemplate restTemplate = new TestRestTemplate();

    HttpHeaders headers = new HttpHeaders();

    @Test
    public void testConsultarCurso (){
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);

        ResponseEntity<String> actual = restTemplate.exchange(
                createURLWithPort("registro-api/cursos/1"),
                HttpMethod.GET, entity, String.class);

        String expected = "{\"codigo\":\"1\",\"nombre\":\"Química\",\"horario\":\"MJ 14-16\",\"totalEstudiantes\":1}";

        Assert.assertEquals(expected, actual.getBody());
    }

    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }

}
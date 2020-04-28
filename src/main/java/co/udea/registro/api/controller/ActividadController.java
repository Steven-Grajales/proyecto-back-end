package co.udea.registro.api.controller;

import co.udea.registro.api.service.ActividadService;
import co.udea.registro.api.service.CursoService;
import co.udea.registro.api.util.ActividadWrapper;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/actividades")
public class ActividadController {

    private final Logger log = LoggerFactory.getLogger(CursoController.class);

    private ActividadService actividadService;

    public ActividadController(ActividadService actividadService){
        this.actividadService = actividadService;
    }

    @GetMapping("")
    @ApiOperation(value = "Buscar todos las actividades", response = Page.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Las actividades fueron encontradas", response = Page.class),
            @ApiResponse(code = 404, message = "No se encontraron las actividades"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
    public ResponseEntity<List<ActividadWrapper>> consultarActividades(){
        log.info("RESTapi: Buscar todos las actividades");
        return ResponseEntity.ok(actividadService.getActividades());
    }

}

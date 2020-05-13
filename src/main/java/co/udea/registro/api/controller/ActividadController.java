package co.udea.registro.api.controller;

import co.udea.registro.api.model.Actividad;
import co.udea.registro.api.service.ActividadService;
import co.udea.registro.api.model.ActividadWrapper;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
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

    @GetMapping("/{id}")
    @ApiOperation(value = "Buscar actividades de un curso", response = Page.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Las actividades fueron encontradas", response = Page.class),
            @ApiResponse(code = 404, message = "No se encontraron las actividades"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
    public ResponseEntity<List<ActividadWrapper>> actividadesDeCurso(@PathVariable String id){
        log.info("RESTapi: Buscar actividades de un curso");
        return ResponseEntity.ok(actividadService.actividadesDeCurso(id));
    }

    @PostMapping
    @ApiOperation(value = "Registrar una actividad", response = Page.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La actividad fue registrada", response = Page.class),
            @ApiResponse(code = 404, message = "No se pudo registrar la actividad"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
    public ResponseEntity<ActividadWrapper> registrarActividad(@RequestBody ActividadWrapper actividad) throws ParseException {
        log.info("RESTapi: Registrar una actividad");
        return ResponseEntity.ok(actividadService.registrarActividad(actividad));
    }

    @DeleteMapping("{id}")
    @ApiOperation(value = "Eliminar una actividad (estado inactiva)", response = Page.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La actividad fue eliminada", response = Page.class),
            @ApiResponse(code = 404, message = "No se pudo eliminar la actividad"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
    public ResponseEntity<ActividadWrapper> eliminarActividad(@PathVariable int id) {
        log.info("RESTapi: Eliminar una actividad");
        return ResponseEntity.ok(actividadService.eliminarActividad(id));
    }
}

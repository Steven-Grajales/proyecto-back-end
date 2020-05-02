package co.udea.registro.api.controller;

import co.udea.registro.api.service.CursoService;
import co.udea.registro.api.model.CursoWrapper;
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
@RequestMapping("/cursos")
public class CursoController {

    private final Logger log = LoggerFactory.getLogger(CursoController.class);

    private CursoService cursoService;

    public CursoController(CursoService cursoService){
        this.cursoService = cursoService;
    }

    @GetMapping("")
    @ApiOperation(value = "Buscar todos los cursos", response = Page.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Los cursos fueron encontrados", response = Page.class),
            @ApiResponse(code = 404, message = "No se encontraron los cursos"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
    public ResponseEntity<List<CursoWrapper>> consultarCursos(){
        log.info("RESTapi: Buscar todos los cursos");
        return ResponseEntity.ok(cursoService.getCursos());
    }

}

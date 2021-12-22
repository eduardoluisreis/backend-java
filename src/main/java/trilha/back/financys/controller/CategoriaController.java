package trilha.back.financys.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import trilha.back.financys.DTO.CategoriaDTO;
import trilha.back.financys.Entity.CategoriaEntity;
import trilha.back.financys.service.CategoriaServiceImpl;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/categorias")
@Api("FinancysApplication")
public class CategoriaController {

    @Autowired
    private CategoriaServiceImpl service;

    @PostMapping(path = "/salvar")
    @ApiOperation(value = "Salva a lista de Categorias")
    public ResponseEntity<CategoriaEntity> createNewCategoria(@RequestBody CategoriaDTO categoriaDTO) {
        return ResponseEntity.ok().body(service.createNewCategoria(categoriaDTO)).getBody();
    }


    @GetMapping(path = "/listar")
    @ApiOperation(value = "Retornar a lista de categorias")
    public ResponseEntity<List<CategoriaDTO>> getLista() {

        return ResponseEntity.ok().body(service.getAllCategoria());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<CategoriaEntity> getId(@PathVariable Long id) {
        return ResponseEntity.ok(service.getId(id));
    }

    @ApiOperation(value = "Altera itens na lista de categorias")
    @PutMapping(path = "/updateby/{id}")
    @ResponseStatus( value= HttpStatus.ACCEPTED)
    public ResponseEntity<CategoriaEntity> updateCategoria(@PathVariable("id") Long id, @RequestBody CategoriaEntity entity) {
        service.update(id,entity);

        return ResponseEntity.ok().body(service.update(id,entity));
    }

    @DeleteMapping(value = "/deletar/{id}")
    public void categoriaDeletar(@PathVariable("id") Long id) {
        service.deleteCategoryById(id);
        ResponseEntity.status(HttpStatus.OK);
    }
}







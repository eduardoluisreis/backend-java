package trilha.back.financys.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javassist.tools.rmi.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import trilha.back.financys.DTO.CategoriaDTO;
import trilha.back.financys.Entity.CategoriaEntity;
import trilha.back.financys.service.CategoriaService;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/categorias")
@Api("FinancysApplication")
public class CategoriaController {

    @Autowired
    private CategoriaService service;

    @PostMapping(path = "/salvar")
    @ApiOperation(value = "Salva a lista de Categorias")
    @ResponseStatus(HttpStatus.OK)
    public CategoriaEntity salvar(@RequestBody CategoriaEntity entity) {
        return service.salvar(entity);
    }


    @GetMapping(path = "/listar")
    @ApiOperation(value = "Retornar a lista de categorias")
    public List<CategoriaEntity> getAllCategoria() {
        return ResponseEntity.ok().body(service.getAllCategoria()).getBody();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<CategoriaEntity> getId(@PathVariable Long id) {
        return ResponseEntity.ok(service.getId(id));
    }

    @ApiOperation(value = "Altera itens na lista de categorias")
    @PutMapping(path = "/updateby/{id}")
    @ResponseStatus( value= HttpStatus.ACCEPTED)
    public CategoriaEntity update( @RequestBody CategoriaEntity entity) throws ObjectNotFoundException {
        return ResponseEntity.ok().body(service.update(entity)).getBody();
    }

    @DeleteMapping(value = "/deletar/{id}")
    public void categoriaDeletar(@PathVariable("id") Long id) {
        service.deleteCategoryById(id);
        ResponseEntity.status(HttpStatus.OK);
    }
}







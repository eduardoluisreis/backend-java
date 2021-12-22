package trilha.back.financys.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import trilha.back.financys.Entity.CategoriaEntity;
import trilha.back.financys.service.CategoriaServiceImpl;

@RestController
@RequestMapping(value = "/v1/categorias")
@Api("FinancysApplication")
public class CategoriaController {

    @Autowired
    private CategoriaServiceImpl service;

    @PostMapping(path = "/salvar")
    @ApiOperation(value = "Salva a lista de Categorias")
    public ResponseEntity<CategoriaEntity> createNewCategoria(@RequestBody CategoriaEntity categoriaEntity) {
        return service.createNewCategoria(categoriaEntity);
    }


    @GetMapping(path = "/listar")
    @ApiOperation(value = "Retornar a lista de categorias")
    public ResponseEntity<CategoriaEntity> getLista() {

        return ResponseEntity.ok(CategoriaEntityservice.getAllCategoria());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Object> getCategoria(@PathVariable Long id) {
        return ResponseEntity.ok(service.getCategoriaById(id));
    }

    @ApiOperation(value = "Altera itens na lista de categorias")
    @PatchMapping(value = "/updateby{id}")
    public ResponseEntity<Object> updateid(@PathVariable("id") Long id, @RequestBody CategoriaEntity categoriaEntityBody) {
        service.updateCategoria(id, categoriaEntityBody);
        return ResponseEntity.ok(categoriaEntityBody);

    }

    @DeleteMapping(value = "/deletar/{id}")
    public ResponseEntity<Object> categoriaDeletar(@PathVariable("id") Long id) {
        service.deleteCategoryById(id);
        return ResponseEntity.noContent().build();
    }
}







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
    private CategoriaService categoriaService;


    @GetMapping(path = "/listar")
    @ResponseStatus(HttpStatus.OK)
    public List<CategoriaEntity> getAll() {
        return ResponseEntity.ok().body(categoriaService.getAllCategoria()).getBody();
    }

    @GetMapping(path = "/buscar/{id}")
    public ResponseEntity<CategoriaEntity> getId(@PathVariable("id") Long id) {
        return ResponseEntity.ok(categoriaService.getId(id));
    }

    @PostMapping(path = "/salvar")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<CategoriaEntity> salvar(@RequestBody CategoriaDTO categoriaDTO) {
        return ResponseEntity.ok().body(categoriaService.salvar(categoriaDTO));
    }

    @DeleteMapping(path = "/deletar/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deletar(@PathVariable("id") Long id) {
        categoriaService.deletar(id);

    }

    @PutMapping(path = "/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void atualizar(@PathVariable("id") Long id, @RequestBody CategoriaEntity categoria) {
        categoriaService.atualizar(categoria, id);

    }
}
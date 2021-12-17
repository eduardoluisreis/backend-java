package trilha.back.financys.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import trilha.back.financys.Entity.LancamentoEntity;
import trilha.back.financys.LancamentoDTO.LancamentoDTO;
import trilha.back.financys.service.CategoriaService;
import trilha.back.financys.service.LancamentoService;

@RestController
@RequestMapping(value = "/lancamentos")
@Api("FinancysApplication")
public class LancamentoController {

    @Autowired
    public CategoriaService categoriaService;

    @Autowired
    public LancamentoService lancamentoService;

    @PostMapping("/salvar")
    @ApiOperation(value = "Salva a lista de Lancamentos")
    public ResponseEntity<LancamentoEntity> save(@RequestBody LancamentoEntity lancamentoEntityBody) {
        return lancamentoService.createNewLancamento(lancamentoEntityBody);

    }

    @GetMapping(path = "/listar")
    @ApiOperation(value = "Retornar a lista de Lancamentos")
    public ResponseEntity<LancamentoEntity> getLista() {

        return ResponseEntity.ok().body(lancamentoService.getAllLancamento(LancamentoEntity));
    }

//    @GetMapping(path = "/{id}")
//    public ResponseEntity<Object> getLancamento(@PathVariable Long id) {
//        return ResponseEntity.ok(lancamentoService.getLancamentoById(id));
//    }

    @GetMapping(path = "categoria/{id}")
    public ResponseEntity<Object> validateCategoryById(@PathVariable Long id) {
        return ResponseEntity.ok(categoriaService.getCategoriaById(id));
    }

    @ApiOperation(value = "Altera na lista de Lancamentos")
    @PatchMapping(value = "/updateby{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<LancamentoEntity> updateid(@PathVariable("id") Long id, @RequestBody LancamentoDTO lancamentoDTO) {
     return ResponseEntity.ok().body(lancamentoService.updateLancamento(id, lancamentoDTO));
    }


    @DeleteMapping(value = "/deletar/{id}")
    public ResponseEntity<Object> lancamentoDeletar(@PathVariable("id") Long id) {
        lancamentoService.deleteEntryById(id);

        return ResponseEntity.noContent().build();
    }

}

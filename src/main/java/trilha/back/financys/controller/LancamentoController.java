package trilha.back.financys.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import trilha.back.financys.Entity.LancamentoEntity;
import trilha.back.financys.DTO.LancamentoDTO;
import trilha.back.financys.service.LancamentoService;

import java.util.List;

@RestController
@RequestMapping(value = "/lancamentos")
@Api("FinancysApplication")
public class LancamentoController {

 @Autowired
 private LancamentoService service;

    @PostMapping("/salvar")
    @ApiOperation(value = "Salva a lista de Lancamentos")
    @ResponseStatus(HttpStatus.OK)
    public void createNewLancamento(@RequestBody LancamentoEntity lancamentoEntity) {
       service.createNewLancamento(lancamentoEntity);

    }

    @GetMapping(path = "/listar")
    @ApiOperation(value = "Retornar a lista de Lancamentos")
    public ResponseEntity<List<LancamentoEntity>> getAllLancamento( ){
        return ResponseEntity.ok().body(service.getAllLancamento());
    }

    @GetMapping(path = "/{id}")
   public ResponseEntity<LancamentoEntity> getId(@PathVariable Long id) {
       return ResponseEntity.ok(service.getId(id));
   }

//    @GetMapping(path = "lancamento/{id}")
//    public ResponseEntity<Object> validateCategoryById(@PathVariable Long id) {
//        return ResponseEntity.ok(service.getLancamentoById(id));
//    }

    @ApiOperation(value = "Altera na lista de Lancamentos")
    @PutMapping(value = "/updateby{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<LancamentoEntity> updateid(@PathVariable("id") Long id, @RequestBody LancamentoEntity entity) {
     return ResponseEntity.ok().body(service.updateid(id, entity));
    }


    @DeleteMapping(value = "/deletar/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public void lancamentoDeletar(@PathVariable("id") Long id) {
            service.deleteEntryById(id);
    }

}

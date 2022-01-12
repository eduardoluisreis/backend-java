package trilha.back.financys.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javassist.tools.rmi.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import trilha.back.financys.DTO.LancamentoResponseDTO;
import trilha.back.financys.Entity.CategoriaEntity;
import trilha.back.financys.Entity.LancamentoEntity;
import trilha.back.financys.DTO.LancamentoDTO;
import trilha.back.financys.repository.LancamentoRepository;
import trilha.back.financys.service.CategoriaService;
import trilha.back.financys.service.LancamentoService;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/lancamentos")
@Api("FinancysApplication")
public class LancamentoController {

    @Autowired
    private LancamentoService lancamentoService;

    @GetMapping(value = "/listar")
    @ResponseStatus(HttpStatus.OK)
    public List<LancamentoEntity> Listar() {
        return ResponseEntity.ok().body(lancamentoService.getAll()).getBody();
    }

    @GetMapping(path = "/buscar/{id}")
    public ResponseEntity<LancamentoEntity> buscarId(@PathVariable("id") Long id) {
        return ResponseEntity.ok(lancamentoService.getId(id));
    }

    @PostMapping (path = "/salvar")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<LancamentoEntity>salvar(@RequestBody LancamentoDTO lancamentoDTO) {
        return ResponseEntity.ok().body(lancamentoService.salvar(lancamentoDTO));
    }
    @DeleteMapping(path = "/deletar/{id}")
    public void deletar(@PathVariable("id") Long id) {
        lancamentoService.Deletar(id);
    }

    @PutMapping(path = "/update/{id}")
    public void update(@PathVariable("id") Long id, @RequestBody LancamentoEntity lancamento) {
        lancamentoService.atualizaLancamento(lancamento, id);
    }
}

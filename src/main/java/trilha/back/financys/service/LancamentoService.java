package trilha.back.financys.service;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import trilha.back.financys.LancamentoDTO.LancamentoDTO;
import trilha.back.financys.exceptions.LancamentoNotFoundException;
import trilha.back.financys.Entity.CategoriaEntity;
import trilha.back.financys.Entity.LancamentoEntity;
import trilha.back.financys.repository.CategoriaRepository;
import trilha.back.financys.repository.LancamentoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class LancamentoService {
    @Autowired
    private LancamentoRepository lancamentoRepository;
    @Autowired
    private CategoriaRepository categoriaRepository;

    private ModelMapper mapper;

    public ResponseEntity<LancamentoEntity> createNewLancamento(LancamentoEntity lancamentoEntity) {
        if (validateEntryById(lancamentoEntity.getCategoryid())) {
            return ResponseEntity.ok(lancamentoRepository.save(lancamentoEntity));
        } else {
            System.out.println("Não existe categoria para este lancamento");
            return ResponseEntity.badRequest().build();
        }
    }

    public List<LancamentoEntity> getAllLancamento() {

        return lancamentoRepository.findAll();
    }

    public LancamentoEntity getLancamentoById(Long id) {
        Optional<LancamentoEntity> requestedLancamento = lancamentoRepository.findById(id);
        if (requestedLancamento.isEmpty()) {
            throw new LancamentoNotFoundException(String.format("Lancamento with id: '%s' not found", id), id);
        }
        return requestedLancamento.get();
    }

    public LancamentoEntity updateLancamento(Long id, LancamentoDTO lancamentoDTO) throws LancamentoNotFoundException {
        Optional<LancamentoEntity> lancamentoFromDatabase = lancamentoRepository.findById(id);
        try {
            if (lancamentoFromDatabase.isPresent()) {
                lancamentoRepository.save(mapToDTO(lancamentoDTO));

            } else {
                throw new LancamentoNotFoundException("Lancamento with id: '%s' not found", id);
            }

        } catch (LancamentoNotFoundException e) {
            e.printStackTrace();
        }
        return lancamentoRepository.save(mapToDTO(lancamentoDTO));
    }


    private LancamentoEntity mapToDTO(LancamentoDTO lancamentoDTO){
        return mapper.map(lancamentoDTO, LancamentoEntity.class);
    }



    public void deleteEntryById(Long id) {
        lancamentoRepository.deleteById(id);
    }

    public boolean validateEntryById(CategoriaEntity categoriaEntityId) {

        Optional<CategoriaEntity> categoryId = categoriaRepository.findById(categoriaEntityId.getId());
        if (categoryId.isPresent()) {
            return true;
        } else

            return false;
    }
}

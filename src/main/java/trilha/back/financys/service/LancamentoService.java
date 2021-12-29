package trilha.back.financys.service;

import org.jetbrains.annotations.NotNull;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import trilha.back.financys.DTO.LancamentoDTO;
import trilha.back.financys.DTO.LancamentoResponseDTO;
import trilha.back.financys.Entity.LancamentoEntity;
import trilha.back.financys.exceptions.LancamentoNotFoundException;
import trilha.back.financys.repository.LancamentoRepository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class LancamentoService {
    @Autowired
    private LancamentoRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    public LancamentoService(LancamentoRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    public LancamentoEntity save(LancamentoEntity lancamentoEntity){

        return  repository.save(lancamentoEntity);
    }

    public List<LancamentoEntity> getAllLancamento() {
        return ResponseEntity.ok().body(repository.findAll()).getBody();
    }

    public LancamentoEntity getId(Long id) {
        Optional<LancamentoEntity> requestedLancamento = repository.findById(id);
        if (requestedLancamento.isPresent()) {
            repository.getById(id);
        } else {
            System.out.println("id nao encontrado");
        }
        return repository.getById(id);
    }
    public LancamentoEntity updateid(Long id, @NotNull LancamentoEntity entity) throws LancamentoNotFoundException {
        try {
            if (Objects.equals(entity.getId(), repository.getById(id))) {
                repository.save(entity);
            } else {
                throw new LancamentoNotFoundException("id ja existe");
            }

        } catch (LancamentoNotFoundException e) {
            e.printStackTrace();
        }
        return repository.save(entity);
    }


    public void deleteEntryById(Long id) {
        repository.deleteById(id);
    }

    private LancamentoDTO mapToDto(LancamentoEntity entity) {
        return modelMapper.map(entity, LancamentoDTO.class);
    }

    private LancamentoEntity mapToEntity(LancamentoResponseDTO dto) {
        return modelMapper.map(dto, LancamentoEntity.class);
    }


}

package trilha.back.financys.service;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import trilha.back.financys.DTO.LancamentoDTO;
import trilha.back.financys.exceptions.LancamentoNotFoundException;
import trilha.back.financys.Entity.CategoriaEntity;
import trilha.back.financys.Entity.LancamentoEntity;
import trilha.back.financys.repository.CategoriaRepository;
import trilha.back.financys.repository.LancamentoRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LancamentoServiceImpl implements LancamentoService {

    @Autowired
    private LancamentoRepository lancamentoRepository;
    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public LancamentoEntity createNewLancamento(Long id, LancamentoDTO lancamentoDTO) throws LancamentoNotFoundException {
        Optional<LancamentoEntity> lancamento = lancamentoRepository.findAllById(id);
        try{
            if(lancamento.isEmpty()){
                lancamentoRepository.save(mapToDto(lancamentoDTO));
            }else{
                throw new LancamentoNotFoundException("lancamento ja existe",id);
            }

        } catch (LancamentoNotFoundException e) {
            e.printStackTrace();
        }
        return lancamentoRepository.save(mapToDto(lancamentoDTO));
    }

    public List<LancamentoEntity> getAllLancamento(LancamentoEntity lancamento) {
        List<LancamentoEntity> list = lancamentoRepository.findAll();
        list.add(mapToEntity(lancamento));

        return list.stream().map(this::mapToEntity).collect(Collectors.toList());
    }

    @Override
    public LancamentoEntity getLancamentoById(Long id)  {
        Optional<LancamentoEntity
        if(id.)



    }

    @Override
    public LancamentoEntity updateLancamento(Long id, LancamentoDTO lancamentoDTO) throws LancamentoNotFoundException {
        return null;
    }

    @Override
    public void deleteEntryById(Long id) {

    }

    @Override
    public boolean validateEntryById(CategoriaEntity categoriaEntityId) {
        return false;
    }

    private LancamentoEntity mapToDto (LancamentoDTO  dto){

        return mapper.map(dto,LancamentoEntity.class );
    }

    private LancamentoEntity mapToEntity (LancamentoEntity entity){

        return mapper.map(entity,LancamentoDTO.class );
    }


//
//    public ResponseEntity<LancamentoEntity> createNewLancamento(LancamentoEntity lancamentoEntity) {
//        if (validateEntryById(lancamentoEntity.getCategoryid())) {
//            return ResponseEntity.ok(lancamentoRepository.save(lancamentoEntity));
//        } else {
//            System.out.println("Não existe categoria para este lancamento");
//            return ResponseEntity.badRequest().build();
//        }
//    }
//
//    public List<LancamentoEntity> getAllLancamento() {
//
//        return lancamentoRepository.findAll();
//    }
//
//    public LancamentoEntity getLancamentoById(Long id) {
//        Optional<LancamentoEntity> requestedLancamento = lancamentoRepository.findById(id);
//        if (requestedLancamento.isEmpty()) {
//            throw new LancamentoNotFoundException(String.format("Lancamento with id: '%s' not found", id), id);
//        }
//        return requestedLancamento.get();
//    }
//
//    public LancamentoEntity updateLancamento(Long id, LancamentoDTO lancamentoDTO) throws LancamentoNotFoundException {
//        Optional<LancamentoEntity> lancamentoFromDatabase = lancamentoRepository.findById(id);
//        try {
//            if (lancamentoFromDatabase.isPresent()) {
//                lancamentoRepository.save(mapToDTO(lancamentoDTO));
//
//            } else {
//                throw new LancamentoNotFoundException("Lancamento with id: '%s' not found", id);
//            }
//
//        } catch (LancamentoNotFoundException e) {
//            e.printStackTrace();
//        }
//        return lancamentoRepository.save(mapToDTO(lancamentoDTO));
//    }
//
//
//    private LancamentoEntity mapToDTO(LancamentoDTO lancamentoDTO){
//        return mapper.map(lancamentoDTO, LancamentoEntity.class);
//    }
//
//
//
//    public void deleteEntryById(Long id) {
//        lancamentoRepository.deleteById(id);
//    }
//
//    public boolean validateEntryById(CategoriaEntity categoriaEntityId) {
//
//        Optional<CategoriaEntity> categoryId = categoriaRepository.findById(categoriaEntityId.getId());
//        if (categoryId.isPresent()) {
//            return true;
//        } else
//
//            return false;
//    }
}

package trilha.back.financys.service;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import trilha.back.financys.Entity.CategoriaEntity;
import trilha.back.financys.DTO.CategoriaDTO;
import trilha.back.financys.exceptions.CategoriaNotFoundException;
import trilha.back.financys.repository.CategoriaRepository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoriaServiceImpl {
    @Autowired
    private CategoriaRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    public ResponseEntity<CategoriaEntity> createNewCategoria(CategoriaDTO categoriaDTO) {

        return ResponseEntity.ok().body(repository.save(mapToEntity(categoriaDTO)));
    }

    public List<CategoriaDTO> getAllCategoria() {
        return repository.findAll()
                .stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());

    }

    public CategoriaEntity getId(Long id) {
        Optional<CategoriaEntity> requestedCategoria = repository.findById(id);
        if (requestedCategoria.isPresent()) {
            repository.getById(id);
        }else{
           System.out.println("id nao encontrado");
        }
       return  repository.getById(id);
    }

    public CategoriaEntity update(Long id, CategoriaEntity entity) throws CategoriaNotFoundException {
        try {
            if (Objects.equals(entity.getId(), repository.getById(id))) {
                repository.save(entity);
            } else {
                throw new CategoriaNotFoundException("id ja existe");
            }

        } catch (CategoriaNotFoundException e) {
            e.printStackTrace();
        }
        return repository.save(entity);
    }
  /*  public String idCategoriaByName(Long idCategory) {
        CategoriaEntity categoriaEntity = repository.findById(idCategory).orElseThrow();

        return categoriaEntity.getName();
    }*/

    public void deleteCategoryById(Long id) {
        repository.deleteById(id);
    }

    private CategoriaDTO mapToDto(CategoriaEntity entity) {
        return modelMapper.map(entity, CategoriaDTO.class);
    }

    private CategoriaEntity mapToEntity(CategoriaDTO dto) {
      return  modelMapper.map(dto, CategoriaEntity.class );
    }
}

package trilha.back.financys.service;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import trilha.back.financys.LancamentoDTO.CategoriaDTO;
import trilha.back.financys.repository.CategoriaRepository;
import trilha.back.financys.exceptions.CategoriaNotFoundException;
import trilha.back.financys.Entity.CategoriaEntity;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository repository;
    @Autowired
    private ModelMapper modelMapper;

    public ResponseEntity<CategoriaEntity> createNewCategoria(CategoriaEntity categoriaEntity) {
        repository.save(categoriaEntity);
        return ResponseEntity.ok().body(categoriaEntity);
    }

    public List<CategoriaEntity> getAllCategoria() {
        return repository.findAll();
    }

    public CategoriaEntity getCategoriaById(Long id) {
        Optional<CategoriaEntity> requestedCategoria = repository.findById(id);
        if (requestedCategoria.isEmpty()) {
            throw new CategoriaNotFoundException(String.format("Categoria with id: '%s' not found", id));
        }
        return requestedCategoria.get();
    }

    public CategoriaEntity updateCategoria(Long id, CategoriaEntity categoryToUpdateRequest) {
        Optional<CategoriaEntity> categoryFromDatabase = repository.findById(id);
        if (categoryFromDatabase.isEmpty()) {
            throw new CategoriaNotFoundException(String.format("Category with id: '%s' not found", id));
        }

        CategoriaEntity categoryToUpdate = categoryFromDatabase.get();

        categoryToUpdate.setName(categoryToUpdateRequest.getName());
        categoryToUpdate.setDescription(categoryToUpdateRequest.getDescription());
        repository.save(categoryToUpdate);

        return categoryToUpdate;


    }

    public String idCategoriaByName(Long idCategory) {
        CategoriaEntity categoriaEntity = repository.findById(idCategory).orElseThrow();

        return categoriaEntity.getName();

    }

    public void deleteCategoryById(Long id) {
        repository.deleteById(id);
    }
}

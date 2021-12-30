package trilha.back.financys.service;


import javassist.tools.rmi.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import trilha.back.financys.DTO.CategoriaDTO;
import trilha.back.financys.Entity.CategoriaEntity;
import trilha.back.financys.repository.CategoriaRepository;
import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository repository;

    @Autowired
    private ModelMapper modelMapper;


    public CategoriaService(CategoriaRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    public CategoriaEntity salvar(CategoriaEntity categoriaEntity) {

        return repository.save(categoriaEntity);
    }

    public List<CategoriaEntity> getAllCategoria() {
        return ResponseEntity.ok().body(repository.findAll()).getBody();


    }

    public CategoriaEntity getId(Long id) {
        Optional<CategoriaEntity> requestedCategoria = repository.findById(id);
        if (requestedCategoria.isPresent()) {
            repository.getById(id);
        } else {
            System.out.println("id nao encontrado");
        }
        return repository.getById(id);
    }

    public void atualizar(CategoriaEntity categoria, Long id) {

        CategoriaEntity categoriaEdita = repository.findById(id)
                .orElseThrow();
        categoriaEdita.setName(categoria.getName());
        categoriaEdita.setDescription(categoria.getDescription());
        ResponseEntity.ok().body(repository.save(categoriaEdita));

    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }

    private CategoriaDTO mapToDto(CategoriaEntity entity) {
        return modelMapper.map(entity, CategoriaDTO.class);
    }

    private CategoriaEntity mapToEntity(CategoriaDTO dto) {
        return modelMapper.map(dto, CategoriaEntity.class);
    }
}

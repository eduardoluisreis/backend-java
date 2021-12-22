package trilha.back.financys.service;


import org.springframework.http.ResponseEntity;
import trilha.back.financys.Entity.CategoriaEntity;

import java.util.List;

public interface CategoriaService {

    ResponseEntity<CategoriaEntity> createNewCategoria(CategoriaEntity categoriaEntity);
    List<CategoriaEntity> getAllCategoria();
    CategoriaEntity getCategoriaById(Long id);
}

package trilha.back.financys.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import trilha.back.financys.Entity.CategoriaEntity;

@Repository
public interface CategoriaRepository extends JpaRepository <CategoriaEntity, Long>{

}

package trilha.back.financys.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import trilha.back.financys.Entity.LancamentoEntity;

@Repository
public interface LancamentoRepository extends JpaRepository<LancamentoEntity, Long>{


}

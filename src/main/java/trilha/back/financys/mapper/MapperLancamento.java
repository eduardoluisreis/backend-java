package trilha.back.financys.mapper;

import org.mapstruct.Mapper;
import trilha.back.financys.LancamentoDTO.LancamentoDTO;
import trilha.back.financys.Entity.LancamentoEntity;

@Mapper(componentModel = "spring")
public interface MapperLancamento {

    LancamentoEntity toModel(LancamentoDTO lancamentoDTO);

    LancamentoDTO toDTO(LancamentoEntity lancamentoEntity);
}

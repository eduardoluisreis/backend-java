package trilha.back.financys.LancamentoDTO;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import trilha.back.financys.Entity.CategoriaEntity;
import trilha.back.financys.Entity.LancamentoEntity;

import java.io.Serial;
import java.io.Serializable;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LancamentoDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private String type;
    private String amount;
    private CategoriaEntity categoriaEntity;


    }




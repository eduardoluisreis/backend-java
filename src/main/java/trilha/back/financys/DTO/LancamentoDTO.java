package trilha.back.financys.DTO;


import lombok.*;
import trilha.back.financys.Entity.CategoriaEntity;

import java.io.Serial;
import java.io.Serializable;
@Data
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




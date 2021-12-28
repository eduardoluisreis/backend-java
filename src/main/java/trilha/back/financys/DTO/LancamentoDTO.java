package trilha.back.financys.DTO;


import lombok.*;
import trilha.back.financys.Entity.CategoriaEntity;
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LancamentoDTO  {


    private String name;
    private String type;
    private String amount;
    private CategoriaEntity categoriaEntity;


    }




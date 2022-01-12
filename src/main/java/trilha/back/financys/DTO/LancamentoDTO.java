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
    private Double amount;
    private String data;
    private Boolean paid;
    private String description;
    private CategoriaEntity categoryId;
}




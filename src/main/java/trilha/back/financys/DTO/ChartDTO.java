package trilha.back.financys.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;




@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ChartDTO {


    private String name;
    private String type;
    private Double amount;
}

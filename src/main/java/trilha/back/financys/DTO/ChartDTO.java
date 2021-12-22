package trilha.back.financys.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ChartDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;
    private String type;
    private String amount;
}

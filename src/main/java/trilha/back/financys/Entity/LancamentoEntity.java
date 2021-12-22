package trilha.back.financys.Entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "lancamentos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LancamentoEntity implements Serializable {
    @Serial
    private static final long serialVersionUID= 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotEmpty(message = " Campo nome não pode ser vazio ou nulo")
    @NotNull(message = " Campo nome não pode ser vazio ou nulo")
    @Size(min = 3, max = 45, message = "min 3 a 45 caracteres")
    private String name;

    @NotEmpty(message = "Campo de descrição não pode ser vazia ou nula")
    @NotNull(message = "Campo de descrição não pode ser vazia ou nula")
    @Size(min = 15, max = 150, message = "min 15 a 150 caracteres")
    private String description;

    @NotEmpty(message = "Campo tipo não pode ser nula ou vazia")
    @NotNull(message = "Campo tipo não pode ser nula ou vazia")
    @Size(min = 3, max = 10, message = "min 3 a 10 caracteres")
    private String type;

    @NotEmpty(message = "Valor montante não pode ser nulo ou vazio")
    @NotNull(message = "Valor  montante não pode ser nulo ou vazio")
    @Min(value = 0, message = "Valor mínimo permitido é 0")
    private String amount;

    @NotEmpty(message = "Campo data não pode ser nula ou vazia")
    @NotNull(message = "Campo data não pode ser nula ou vazia")
    private String date;

    @NotEmpty(message = "O campo pago não pode ser nulo ou vazio, aceita apenas sim ou não")
    @NotNull(message = "O campo pago não pode ser nulo ou vazio, aceita apenas sim ou não")
    private boolean paid;

    @ManyToOne
    @JoinColumn(name = "categoryid", referencedColumnName = "id")
   private CategoriaEntity categoryid;


}

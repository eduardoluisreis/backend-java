package trilha.back.financys.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "lancamentos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class LancamentoEntity implements Serializable {

    private static final Long serialVersionUID= 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;

    @NotEmpty(message = " Campo nome não pode ser vazio ou nulo")
    @NotNull(message = " Campo nome não pode ser vazio ou nulo")
    @Size(min = 3, max = 45, message = "min 3 a 45 caracteres")
    private String name;

    @NotEmpty(message = "Campo de descrição não pode ser vazia ou nula")
    @NotNull(message = "Campo de descrição não pode ser vazia ou nula")
    @Size(min = 5, max = 150, message = "min 15 a 150 caracteres")
    private String description;

    @NotEmpty(message = "Campo tipo não pode ser nula ou vazia")
    @NotNull(message = "Campo tipo não pode ser nula ou vazia")
    @Size(min = 3, max = 15, message = "min 3 a 10 caracteres")
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
    @JoinColumn(name = "categoryId", referencedColumnName = "id")
    //@JsonIgnore
    private  CategoriaEntity categoryId;

}

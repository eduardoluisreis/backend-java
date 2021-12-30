package trilha.back.financys.Entity;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;

@Entity
@Table(name = "lancamentos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class LancamentoEntity implements Serializable {

    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @Size(min = 3, max = 45, message = "min 3 a 45 caracteres")
    @Column(name = "name", nullable = false)
    private String name;

    @Size(min = 5, max = 150, message = "min 15 a 150 caracteres")
    @Column(name = "description", nullable = false)
    private String description;

    @Size(min = 3, max = 15, message = "min 3 a 10 caracteres")
    @Column(name = "type", nullable = false)
    private String type;

    @Size(min = 0, message = "Valor mínimo permitido é 0")
    @Column(name = "amount", nullable = false)
    private String amount;


    @Size(min = 0, message = "Valor mínimo permitido é 0")
    @Column(name = "data", nullable = false)
    private String data;

    @Column(name = "paid", nullable = false)
    private boolean paid;

    @ManyToOne
    @JoinColumn(name = "categoryId", referencedColumnName ="id_categoria", nullable = false)
    @JsonProperty
    private CategoriaEntity categoryId;

}

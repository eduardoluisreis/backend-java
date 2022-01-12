package trilha.back.financys.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jdk.jfr.BooleanFlag;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

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
    @Column(name = "id")
    private Long id;


    @Size(min = 3, max = 45, message = "min 3 a 45 caracteres")
    @Column(name = "name", nullable = false)
    private String name;

    @Size(min = 5, max = 150, message = "min 15 a 150 caracteres")
    @Column(name = "description", nullable = false)
    private String description;


    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private Type type;

    @Min(value = 0, message = "Valor mínimo permitido é 0")
    @Column(name = "amount", nullable = false)
    private Double amount;

    @NotBlank(message = "A data náo pode ser vazia")
    private String data;


    @Column(name = "paid", nullable = false)
    private boolean paid;

    @JoinColumn(name = "categoryId", referencedColumnName = "id_categoria", nullable = false)
    @JsonIgnore
    private CategoriaEntity categoryId;

//    public boolean getPaid() {
//        return paid;
//    }
//
//    public void isPaid(Boolean paid) {
//        this.paid = paid;
//    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        LancamentoEntity lancamentoEntity = (LancamentoEntity) o;
//        return paid == lancamentoEntity.paid && Objects.equals(id, lancamentoEntity.id) && Objects.equals(name, lancamentoEntity)
//                && Objects.equals(description, lancamentoEntity.description) && Objects.equals(type, lancamentoEntity.type)
//                && Objects.equals(amount, lancamentoEntity.amount) && Objects.equals(data, lancamentoEntity.data)
//                && Objects.equals(categoryId, lancamentoEntity.categoryId);
//    }

//    @Override
//    public int hashCode(){
//        return Objects.hash(id,name,description,type,amount,data,paid,categoryId);
//    }
//
//    public boolean isPaid() {
//        return true;
//    }

}

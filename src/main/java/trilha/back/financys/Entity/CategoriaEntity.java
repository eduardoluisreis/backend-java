package trilha.back.financys.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "categoria")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class CategoriaEntity implements Serializable {

    private static final Long serialVersionUID= 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_Categoria")
    private Long id;

    @Size(min = 3, max = 15, message = "min 3 a 15 caracteres"+ "não pode ser nulo ou vazio")
    @Column(name = "name", nullable =false )
    private String name;

    @Size(min = 15, max = 50, message = "min 15 a 50 caracteres")
    @Column(name= "description", nullable = false)
    private String description;


    @OneToMany(mappedBy="categoryId")
    //@JsonIgnore
    private List<LancamentoEntity> lancamentoEntities;


}


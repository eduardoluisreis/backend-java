package trilha.back.financys.Entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "categoria")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CategoriaEntity implements Serializable {
    @Serial
    private static final long serialVersionUID= 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    @NotNull
    @NotEmpty
    private String name;

    @Column(name = "description")
    @NotNull
    @NotEmpty
    private String description;

    @OneToMany(mappedBy = "categoryid")
    @NotNull
    @NotEmpty
     private List<LancamentoEntity> lancamentoEntities;

    }


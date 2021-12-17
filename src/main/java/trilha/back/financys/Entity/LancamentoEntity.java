package trilha.back.financys.Entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
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

    @Column(name = "type")
    @NotNull
    @NotEmpty
    private String type;

    @Column(name = "amount")
    @NotNull
    @NotEmpty
    private String amount;

    @Column(name = "date")
    @JsonFormat( shape = JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    private Date date;

    @ManyToOne
    @JoinColumn(name = "categoryid", referencedColumnName = "id")
   private CategoriaEntity categoryid;

    @Column(nullable = false)
    @NotNull
    @NotEmpty
    private boolean paid;

}

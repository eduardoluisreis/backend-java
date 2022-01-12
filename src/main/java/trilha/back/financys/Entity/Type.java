package trilha.back.financys.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Type {

    RECEITA("Receita"),
    DESPESA("Despesa"),
    PAGO("Pago"),
    PENDENTE("Pendente");

    private final String description;
}

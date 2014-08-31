package com.rsaraiva.labs.agendamentos.strategy;

import com.rsaraiva.labs.agendamentos.model.Transferencia;
import java.math.BigDecimal;

public interface Taxa {

    BigDecimal calcula(Transferencia transferencia);
}

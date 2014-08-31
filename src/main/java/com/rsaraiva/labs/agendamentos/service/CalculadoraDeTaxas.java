package com.rsaraiva.labs.agendamentos.service;

import com.rsaraiva.labs.agendamentos.model.Transferencia;
import com.rsaraiva.labs.agendamentos.strategy.Taxa;
import java.math.BigDecimal;

public class CalculadoraDeTaxas {

    public BigDecimal calcula(Transferencia transferencia, Taxa taxa) {
        return taxa.calcula(transferencia);
    }
}

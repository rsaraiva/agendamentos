package com.rsaraiva.labs.agendamentos.strategy;

import com.rsaraiva.labs.agendamentos.model.Transferencia;
import java.math.BigDecimal;

public class TaxaOperacaoTipoA implements Taxa {

    @Override
    public BigDecimal calcula(Transferencia transferencia) {
        
        BigDecimal dois = BigDecimal.valueOf(2.00);
        BigDecimal tresPorCento = transferencia.getValor().multiply(BigDecimal.valueOf(0.03));
        
        return dois.add(tresPorCento);
    }
}

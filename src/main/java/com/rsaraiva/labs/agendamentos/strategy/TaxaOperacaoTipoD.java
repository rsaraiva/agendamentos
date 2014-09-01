package com.rsaraiva.labs.agendamentos.strategy;

import com.rsaraiva.labs.agendamentos.model.Transferencia;
import java.math.BigDecimal;

public class TaxaOperacaoTipoD implements Taxa {

    @Override
    public BigDecimal calcula(Transferencia transferencia) {
        
        if (transferencia.getValor().doubleValue() <= 25000.0)
            return new TaxaOperacaoTipoA().calcula(transferencia);
        
        if (transferencia.getValor().doubleValue() <= 120000.0) 
            return new TaxaOperacaoTipoB().calcula(transferencia);
        
        return new TaxaOperacaoTipoC().calcula(transferencia);
    }
}

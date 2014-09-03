package com.rsaraiva.labs.agendamentos.strategy;

import com.rsaraiva.labs.agendamentos.model.TipoOperacao;
import com.rsaraiva.labs.agendamentos.model.Transferencia;
import java.math.BigDecimal;

public class TaxaOperacaoTipoD implements Taxa {

    @Override
    public BigDecimal calcula(Transferencia transferencia) {
        
        if (!transferencia.getTipoOperacao().equals(TipoOperacao.D))
            return BigDecimal.ZERO;
        
        if (transferencia.getValor().doubleValue() <= 25000.0) {
            transferencia.setTipoOperacao(TipoOperacao.A);
            return new TaxaOperacaoTipoA().calcula(transferencia);
        }
        
        if (transferencia.getValor().doubleValue() <= 120000.0) {
            transferencia.setTipoOperacao(TipoOperacao.B);
            return new TaxaOperacaoTipoB().calcula(transferencia);
        }
        
        transferencia.setTipoOperacao(TipoOperacao.C);
        return new TaxaOperacaoTipoC().calcula(transferencia);
    }
}

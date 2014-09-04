package com.rsaraiva.labs.agendamentos.strategy;

import com.rsaraiva.labs.agendamentos.model.TipoOperacao;
import com.rsaraiva.labs.agendamentos.model.Transferencia;
import com.rsaraiva.labs.agendamentos.model.TransferenciaBuilder;
import java.math.BigDecimal;

public class TaxaOperacaoTipoD implements Taxa {

    @Override
    public BigDecimal calcula(Transferencia t) {
        
        if (!t.getTipoOperacao().equals(TipoOperacao.D))
            return BigDecimal.ZERO;
        
        if (t.getValor().doubleValue() <= 25000.0) {
            return new TaxaOperacaoTipoA().calcula(new TransferenciaBuilder().daConta(t.getContaOrigem()).paraConta(t.getContaDestino())
                .em(t.getDataAgendamento()).deValor(t.getValor()).doTipo(TipoOperacao.A).build());
        }
        
        if (t.getValor().doubleValue() <= 120000.0) {
            return new TaxaOperacaoTipoB().calcula(new TransferenciaBuilder().daConta(t.getContaOrigem()).paraConta(t.getContaDestino())
                .em(t.getDataAgendamento()).deValor(t.getValor()).doTipo(TipoOperacao.B).build());
        }
        
        return new TaxaOperacaoTipoC().calcula(new TransferenciaBuilder().daConta(t.getContaOrigem()).paraConta(t.getContaDestino())
                .em(t.getDataAgendamento()).deValor(t.getValor()).doTipo(TipoOperacao.C).build());
    }
}

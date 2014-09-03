package com.rsaraiva.labs.agendamentos.strategy;

import com.rsaraiva.labs.agendamentos.model.TipoOperacao;
import com.rsaraiva.labs.agendamentos.model.Transferencia;
import java.math.BigDecimal;
import java.time.temporal.ChronoUnit;

public class TaxaOperacaoTipoC implements Taxa {

    @Override
    public BigDecimal calcula(Transferencia transferencia) {
        
        if (!transferencia.getTipoOperacao().equals(TipoOperacao.C))
            return BigDecimal.ZERO;
        
        long qtdeDiasAteAgendamento = ChronoUnit.DAYS.between(transferencia.getDataCadastro(), transferencia.getDataAgendamento());
        
        if (qtdeDiasAteAgendamento <= 5)
            return transferencia.getValor().multiply(BigDecimal.valueOf(0.083));
        
        if (qtdeDiasAteAgendamento <= 10)
            return transferencia.getValor().multiply(BigDecimal.valueOf(0.074));
        
        if (qtdeDiasAteAgendamento <= 15)
            return transferencia.getValor().multiply(BigDecimal.valueOf(0.067));
        
        if (qtdeDiasAteAgendamento <= 20)
            return transferencia.getValor().multiply(BigDecimal.valueOf(0.054));
        
        if (qtdeDiasAteAgendamento <= 25)
            return transferencia.getValor().multiply(BigDecimal.valueOf(0.043));
        
        if (qtdeDiasAteAgendamento <= 30)
            return transferencia.getValor().multiply(BigDecimal.valueOf(0.021));
        
        return transferencia.getValor().multiply(BigDecimal.valueOf(0.012));
    }
}

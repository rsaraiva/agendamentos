package com.rsaraiva.labs.agendamentos.strategy;

import com.rsaraiva.labs.agendamentos.model.Transferencia;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class TaxaOperacaoTipoB implements Taxa {

    @Override
    public BigDecimal calcula(Transferencia transferencia) {
        
        if (agendadaParaMaisQue30Dias(transferencia)) {
            return BigDecimal.valueOf(8.0);
        }
        
        return BigDecimal.valueOf(10.0);
    }
    
    private boolean agendadaParaMaisQue30Dias(Transferencia transferencia) {
        long qtdeDiasAteAgendamento = ChronoUnit.DAYS.between(transferencia.getDataCadastro(), transferencia.getDataAgendamento());
        return qtdeDiasAteAgendamento > 30;
    }
}

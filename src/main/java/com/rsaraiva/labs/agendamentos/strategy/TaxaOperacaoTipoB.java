package com.rsaraiva.labs.agendamentos.strategy;

import com.rsaraiva.labs.agendamentos.model.Transferencia;
import java.math.BigDecimal;
import java.time.LocalDate;

public class TaxaOperacaoTipoB implements Taxa {

    @Override
    public BigDecimal calcula(Transferencia transferencia) {
        
        if (agendadaApos30Dias(transferencia)) {
            return BigDecimal.valueOf(8.0);
        }
        
        return BigDecimal.valueOf(10.0);
    }
    
    private boolean agendadaApos30Dias(Transferencia transferencia) {
        
        LocalDate trintaDiasAposCadastro = transferencia.getDataCadastro().plusDays(30);
        
        return transferencia.getDataAgendamento().isAfter(trintaDiasAposCadastro);
    }
}

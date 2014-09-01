package com.rsaraiva.labs.agendamentos.test;

import com.rsaraiva.labs.agendamentos.model.TipoOperacao;
import com.rsaraiva.labs.agendamentos.model.Transferencia;
import com.rsaraiva.labs.agendamentos.service.CalculadoraDeTaxas;
import com.rsaraiva.labs.agendamentos.service.TransferenciaBuilder;
import com.rsaraiva.labs.agendamentos.strategy.TaxaOperacaoTipoA;
import com.rsaraiva.labs.agendamentos.strategy.TaxaOperacaoTipoB;
import java.math.BigDecimal;
import java.time.LocalDate;
import static org.junit.Assert.*;
import org.junit.Test;

public class TesteDeCalculoDeTaxas {

    @Test
    public void testaCalculoTipoA() {
        Transferencia transferencia = new TransferenciaBuilder()
                .daConta("12345-6").paraConta("98765-4")
                .em(LocalDate.now()).doTipo(TipoOperacao.A).deValor(BigDecimal.valueOf(100.0))
                .build();
        BigDecimal taxa = new CalculadoraDeTaxas().calcula(transferencia, new TaxaOperacaoTipoA());
        assertTrue(taxa.doubleValue() == 5.0);
    }
    
    @Test
    public void testaCalculoTipoBAte30Dias() {
        Transferencia transferencia = new TransferenciaBuilder()
                .daConta("12345-6").paraConta("98765-4")
                .em(LocalDate.now().plusDays(30))
                .doTipo(TipoOperacao.B).deValor(BigDecimal.valueOf(100.0))
                .build();
        BigDecimal taxa = new CalculadoraDeTaxas().calcula(transferencia, new TaxaOperacaoTipoB());
        assertTrue(taxa.doubleValue() == 10.0);
    }
    
    @Test
    public void testaCalculoTipoBApos30Dias() {
        Transferencia transferencia = new TransferenciaBuilder()
                .daConta("12345-6").paraConta("98765-4")
                .em(LocalDate.now().plusDays(35))
                .doTipo(TipoOperacao.B).deValor(BigDecimal.valueOf(100.0))
                .build();
        BigDecimal taxa = new CalculadoraDeTaxas().calcula(transferencia, new TaxaOperacaoTipoB());
        assertTrue(taxa.doubleValue() == 8.0);
    }
}

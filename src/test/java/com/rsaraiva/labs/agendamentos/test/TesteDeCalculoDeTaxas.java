package com.rsaraiva.labs.agendamentos.test;

import com.rsaraiva.labs.agendamentos.model.TipoOperacao;
import com.rsaraiva.labs.agendamentos.model.Transferencia;
import com.rsaraiva.labs.agendamentos.service.CalculadoraDeTaxas;
import com.rsaraiva.labs.agendamentos.service.TransferenciaBuilder;
import com.rsaraiva.labs.agendamentos.strategy.TaxaOperacaoTipoA;
import com.rsaraiva.labs.agendamentos.strategy.TaxaOperacaoTipoB;
import com.rsaraiva.labs.agendamentos.strategy.TaxaOperacaoTipoC;
import com.rsaraiva.labs.agendamentos.strategy.TaxaOperacaoTipoD;
import java.math.BigDecimal;
import java.time.LocalDate;
import static org.junit.Assert.*;
import org.junit.Test;

public class TesteDeCalculoDeTaxas {

    @Test
    public void testaCalculoTipoA() {
        Transferencia transferencia = new TransferenciaBuilder()
                .daConta("12345-6").paraConta("98765-4").em(LocalDate.now().plusDays(10))
                .doTipo(TipoOperacao.A).deValor(BigDecimal.valueOf(100.0))
                .build();
        BigDecimal taxa = new CalculadoraDeTaxas().calcula(transferencia, new TaxaOperacaoTipoA());
        assertTrue(taxa.doubleValue() == 5.0);
    }

    @Test
    public void testaCalculoTipoBAte30Dias() {
        Transferencia transferencia = new TransferenciaBuilder().em(LocalDate.now().plusDays(30))
                .doTipo(TipoOperacao.B).deValor(BigDecimal.valueOf(100.0))
                .build();
        BigDecimal taxa = new CalculadoraDeTaxas().calcula(transferencia, new TaxaOperacaoTipoB());
        assertTrue(taxa.doubleValue() == 10.0);
    }

    @Test
    public void testaCalculoTipoBApos30Dias() {
        Transferencia transferencia = new TransferenciaBuilder().em(LocalDate.now().plusDays(35))
                .doTipo(TipoOperacao.B).deValor(BigDecimal.valueOf(100.0))
                .build();
        BigDecimal taxa = new CalculadoraDeTaxas().calcula(transferencia, new TaxaOperacaoTipoB());
        assertTrue(taxa.doubleValue() == 8.0);
    }

    @Test
    public void testaCalculoTipoCApos30Dias() {
        Transferencia transferencia = new TransferenciaBuilder().em(LocalDate.now().plusDays(35))
                .doTipo(TipoOperacao.C).deValor(BigDecimal.valueOf(100.0))
                .build();
        BigDecimal taxa = new CalculadoraDeTaxas().calcula(transferencia, new TaxaOperacaoTipoC());
        assertTrue(taxa.doubleValue() == 1.2);
    }

    @Test
    public void testaCalculoTipoCAte30Dias() {
        Transferencia transferencia = new TransferenciaBuilder().em(LocalDate.now().plusDays(30))
                .doTipo(TipoOperacao.C).deValor(BigDecimal.valueOf(100.0))
                .build();
        BigDecimal taxa = new CalculadoraDeTaxas().calcula(transferencia, new TaxaOperacaoTipoC());
        assertTrue(taxa.doubleValue() == 2.1);
    }

    @Test
    public void testaCalculoTipoCAte25Dias() {
        Transferencia transferencia = new TransferenciaBuilder().em(LocalDate.now().plusDays(25))
                .doTipo(TipoOperacao.C).deValor(BigDecimal.valueOf(100.0))
                .build();
        BigDecimal taxa = new CalculadoraDeTaxas().calcula(transferencia, new TaxaOperacaoTipoC());
        assertTrue(taxa.doubleValue() == 4.3);
    }

    @Test
    public void testaCalculoTipoCAte20Dias() {
        Transferencia transferencia = new TransferenciaBuilder().em(LocalDate.now().plusDays(20))
                .doTipo(TipoOperacao.C).deValor(BigDecimal.valueOf(100.0))
                .build();
        BigDecimal taxa = new CalculadoraDeTaxas().calcula(transferencia, new TaxaOperacaoTipoC());
        assertTrue(taxa.doubleValue() == 5.4);
    }

    @Test
    public void testaCalculoTipoCAte15Dias() {
        Transferencia transferencia = new TransferenciaBuilder().em(LocalDate.now().plusDays(15))
                .doTipo(TipoOperacao.C).deValor(BigDecimal.valueOf(100.0))
                .build();
        BigDecimal taxa = new CalculadoraDeTaxas().calcula(transferencia, new TaxaOperacaoTipoC());
        assertTrue(taxa.doubleValue() == 6.7);
    }

    @Test
    public void testaCalculoTipoCAte10Dias() {
        Transferencia transferencia = new TransferenciaBuilder().em(LocalDate.now().plusDays(10))
                .doTipo(TipoOperacao.C).deValor(BigDecimal.valueOf(100.0))
                .build();
        BigDecimal taxa = new CalculadoraDeTaxas().calcula(transferencia, new TaxaOperacaoTipoC());
        assertTrue(taxa.doubleValue() == 7.4);
    }

    @Test
    public void testaCalculoTipoCAte5Dias() {
        Transferencia transferencia = new TransferenciaBuilder().em(LocalDate.now().plusDays(5))
                .doTipo(TipoOperacao.C).deValor(BigDecimal.valueOf(100.0))
                .build();
        BigDecimal taxa = new CalculadoraDeTaxas().calcula(transferencia, new TaxaOperacaoTipoC());
        assertTrue(taxa.doubleValue() == 8.3);
    }

    @Test
    public void testaCalculoTipoDAte25000() {
        Transferencia transferencia = new TransferenciaBuilder().em(LocalDate.now().plusDays(10))
                .doTipo(TipoOperacao.D).deValor(BigDecimal.valueOf(25000.0))
                .build();
        BigDecimal taxa = new CalculadoraDeTaxas().calcula(transferencia, new TaxaOperacaoTipoD());
        assertTrue(taxa.doubleValue() == 752.0);
    }
    
    @Test
    public void testaCalculoTipoDDe25001() {
        Transferencia transferencia = new TransferenciaBuilder().em(LocalDate.now().plusDays(10))
                .doTipo(TipoOperacao.D).deValor(BigDecimal.valueOf(25001.0))
                .build();
        BigDecimal taxa = new CalculadoraDeTaxas().calcula(transferencia, new TaxaOperacaoTipoD());
        assertTrue(taxa.doubleValue() == 10.0);
    }

    @Test
    public void testaCalculoTipoDAte120000() {
        Transferencia transferencia = new TransferenciaBuilder().em(LocalDate.now().plusDays(10))
                .doTipo(TipoOperacao.D).deValor(BigDecimal.valueOf(120000.0))
                .build();
        BigDecimal taxa = new CalculadoraDeTaxas().calcula(transferencia, new TaxaOperacaoTipoD());
        assertTrue(taxa.doubleValue() == 10.0);
    }

    @Test
    public void testaCalculoTipoDMaiorQue120000() {
        Transferencia transferencia = new TransferenciaBuilder().em(LocalDate.now().plusDays(20))
                .doTipo(TipoOperacao.D).deValor(BigDecimal.valueOf(130000.0))
                .build();
        BigDecimal taxa = new CalculadoraDeTaxas().calcula(transferencia, new TaxaOperacaoTipoD());
        assertTrue(taxa.doubleValue() == 7020.0);
    }
}

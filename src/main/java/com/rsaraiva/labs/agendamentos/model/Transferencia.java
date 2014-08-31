package com.rsaraiva.labs.agendamentos.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Transferencia {

    private final String contaOrigem;
    
    private final String contaDestino;
    
    private final BigDecimal valor;
    
    private BigDecimal taxa;
    
    private final LocalDate dataAgendamento;
    
    private final LocalDate dataCadastro;
    
    private final TipoOperacao tipoOperacao;

    public Transferencia(String contaOrigem, String contaDestino, BigDecimal valor, LocalDate dataAgendamento, TipoOperacao tipoOperacao) {
        this.contaOrigem = contaOrigem;
        this.contaDestino = contaDestino;
        this.valor = valor;
        this.dataAgendamento = dataAgendamento;
        this.tipoOperacao = tipoOperacao;
        this.dataCadastro = LocalDate.now();
    }

    public String getContaOrigem() {
        return contaOrigem;
    }

    public String getContaDestino() {
        return contaDestino;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public BigDecimal getTaxa() {
        return taxa;
    }

    public LocalDate getDataAgendamento() {
        return dataAgendamento;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public TipoOperacao getTipoOperacao() {
        return tipoOperacao;
    }

    public void setTaxa(BigDecimal taxa) {
        this.taxa = taxa;
    }
}

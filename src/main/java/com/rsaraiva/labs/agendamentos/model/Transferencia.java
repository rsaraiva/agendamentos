package com.rsaraiva.labs.agendamentos.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class Transferencia implements java.io.Serializable {
    
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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 61 * hash + Objects.hashCode(this.contaOrigem);
        hash = 61 * hash + Objects.hashCode(this.contaDestino);
        hash = 61 * hash + Objects.hashCode(this.dataAgendamento);
        hash = 61 * hash + Objects.hashCode(this.tipoOperacao);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Transferencia other = (Transferencia) obj;
        if (!Objects.equals(this.contaOrigem, other.contaOrigem)) {
            return false;
        }
        if (!Objects.equals(this.contaDestino, other.contaDestino)) {
            return false;
        }
        if (!Objects.equals(this.dataAgendamento, other.dataAgendamento)) {
            return false;
        }
        if (this.tipoOperacao != other.tipoOperacao) {
            return false;
        }
        return true;
    }
}

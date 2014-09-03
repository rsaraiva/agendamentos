package com.rsaraiva.labs.agendamentos.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Transferencia implements java.io.Serializable {
    
    @Id
    @GeneratedValue
    private Long id;

    private String contaOrigem;
    
    private String contaDestino;
    
    private BigDecimal valor;
    
    private BigDecimal taxa;
    
    private LocalDate dataAgendamento;
    
    private LocalDate dataCadastro;
    
    @Enumerated(EnumType.STRING)
    private TipoOperacao tipoOperacao;

    protected Transferencia() {
    }

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

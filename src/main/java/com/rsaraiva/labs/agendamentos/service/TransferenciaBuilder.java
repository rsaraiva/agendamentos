package com.rsaraiva.labs.agendamentos.service;

import com.rsaraiva.labs.agendamentos.model.TipoOperacao;
import com.rsaraiva.labs.agendamentos.model.Transferencia;
import java.math.BigDecimal;
import java.time.LocalDate;

public class TransferenciaBuilder {
    
    private String contaOrigem;
    private String contaDestino;
    private LocalDate dataAgendamento;
    private TipoOperacao tipoOperacao;
    private BigDecimal valor;

    public TransferenciaBuilder daConta(String contaOrigem) {
        this.contaOrigem = contaOrigem;
        return this;
    }

    public TransferenciaBuilder paraConta(String contaDestino) {
        this.contaDestino = contaDestino;
        return this;
    }

    public TransferenciaBuilder em(LocalDate dataAgendamento) {
        this.dataAgendamento = dataAgendamento;
        return this;
    }

    public TransferenciaBuilder doTipo(TipoOperacao tipoOperacao) {
        this.tipoOperacao = tipoOperacao;
        return this;
    }

    public TransferenciaBuilder deValor(BigDecimal valor) {
        this.valor = valor;
        return this;
    }

    public Transferencia build() {
        return new Transferencia(contaOrigem, contaDestino, valor, dataAgendamento, tipoOperacao);
    }
}

package com.rsaraiva.labs.agendamentos.service;

import com.rsaraiva.labs.agendamentos.model.Transferencia;
import com.rsaraiva.labs.agendamentos.repository.TransferenciasRepository;
import com.rsaraiva.labs.agendamentos.strategy.Taxa;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;

public class AgendamentosService {
    
    @Inject
    private TransferenciasRepository repository;
    
    @Inject @Any
    private Instance<Taxa> estrategiasCalculoTaxas;

    public void salva(Transferencia transferencia) {
        transferencia.setTaxa(calculaTaxa(transferencia));
        repository.adiciona(transferencia);
    }

    public List<Transferencia> listaTodas() {
        return repository.lista();
    }

    public void exclui(String contaOrigem, String contaDestino, LocalDate dataAgendamento, String tipoOperacao) {
        repository.remove(contaOrigem, contaDestino, dataAgendamento, tipoOperacao);
    }
    
    // TODO: melhorar isso. usar stream.
    private BigDecimal calculaTaxa(Transferencia transferencia) {
        
        BigDecimal resultado = BigDecimal.ZERO;
        
        Iterator<Taxa> taxas = estrategiasCalculoTaxas.iterator();
        while(taxas.hasNext()) {
            Taxa instanciaCalculoTaxa = taxas.next();
            resultado = resultado.add(instanciaCalculoTaxa.calcula(transferencia));
        }
        return resultado;
    }
}

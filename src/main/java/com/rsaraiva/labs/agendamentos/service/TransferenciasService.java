package com.rsaraiva.labs.agendamentos.service;

import com.rsaraiva.labs.agendamentos.model.Transferencia;
import com.rsaraiva.labs.agendamentos.repository.TransferenciasRepository;
import com.rsaraiva.labs.agendamentos.strategy.Taxa;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;

public class TransferenciasService {
    
    @Inject
    private TransferenciasRepository repository;
    
    @Inject @Any
    private Instance<Taxa> estrategiasCalculoTaxas;

    public void salva(Transferencia transferencia) {
    	Iterator<Taxa> iterator = estrategiasCalculoTaxas.iterator();
    	while(iterator.hasNext()) {
    		Taxa taxa = iterator.next();
    		transferencia.adicionaTaxa(taxa.calcula(transferencia));
    	}
        repository.adiciona(transferencia);
    }

    public List<Transferencia> listaTodas() {
        return repository.lista();
    }

    public void exclui(String contaOrigem, String contaDestino, LocalDate dataAgendamento, String tipoOperacao) {
        repository.remove(contaOrigem, contaDestino, dataAgendamento, tipoOperacao);
    }
}

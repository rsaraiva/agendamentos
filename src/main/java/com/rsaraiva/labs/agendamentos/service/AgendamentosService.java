/**
 * @author rsaraiva
 */
package com.rsaraiva.labs.agendamentos.service;

import com.rsaraiva.labs.agendamentos.model.Transferencia;
import com.rsaraiva.labs.agendamentos.repository.AgendamentosRepository;
import com.rsaraiva.labs.agendamentos.strategy.Taxa;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;

public class AgendamentosService {
    
    @Inject
    private AgendamentosRepository repository;
    
    @Inject @Any
    private Instance<Taxa> estrategiasCalculoTaxas;

    public void salva(Transferencia transferencia) {
        transferencia.setTaxa(calculaTaxa(transferencia));
        repository.adiciona(transferencia);
    }
    
    // TODO: usar stream
    private BigDecimal calculaTaxa(Transferencia transferencia) {
        BigDecimal resultado = BigDecimal.ZERO;
        Iterator<Taxa> taxas = estrategiasCalculoTaxas.iterator();
        while(taxas.hasNext()) {
            Taxa instanciaCalculoTaxa = taxas.next();
            resultado = resultado.add(instanciaCalculoTaxa.calcula(transferencia));
        }
        return resultado;
    }

    public List<Transferencia> listaTodas() {
        return repository.getTransferencias();
    }
}

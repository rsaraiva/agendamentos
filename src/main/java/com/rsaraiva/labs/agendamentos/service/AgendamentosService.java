/**
 * @author rsaraiva
 */
package com.rsaraiva.labs.agendamentos.service;

import com.rsaraiva.labs.agendamentos.model.Transferencia;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class AgendamentosService {
    
    @PersistenceContext
    private EntityManager em;

    public void salva(Transferencia transferencia) {
        em.persist(transferencia);
    }

    public List<Transferencia> listaTodas() {
        return em.createQuery("select t from Transferencia t order by t.dataAgendamento")
                .setMaxResults(MAX_RESULTS)
                .getResultList();
    }
    
    private static final int MAX_RESULTS = 100;
}

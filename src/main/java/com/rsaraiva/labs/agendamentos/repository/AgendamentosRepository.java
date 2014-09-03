/**
 * @author rsaraiva
 */
package com.rsaraiva.labs.agendamentos.repository;

import com.rsaraiva.labs.agendamentos.model.Transferencia;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AgendamentosRepository {

    private static final List<Transferencia> transferencias = new ArrayList<>();
    
    public void adiciona(Transferencia transferencia) {
        transferencias.add(transferencia);
    }
    
    public List<Transferencia> getTransferencias() {
        return Collections.unmodifiableList(transferencias);
    }
}

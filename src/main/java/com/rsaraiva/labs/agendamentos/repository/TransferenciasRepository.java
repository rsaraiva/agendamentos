package com.rsaraiva.labs.agendamentos.repository;

import com.rsaraiva.labs.agendamentos.model.TipoOperacao;
import com.rsaraiva.labs.agendamentos.model.Transferencia;
import com.rsaraiva.labs.agendamentos.service.TransferenciaBuilder;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class TransferenciasRepository {

    private static List<Transferencia> transferencias = new ArrayList<>();
    
    public void adiciona(Transferencia transferencia) {
        transferencias.add(transferencia);
    }
    
    public List<Transferencia> lista() {
        return Collections.unmodifiableList(transferencias);
    }

    public void remove(String contaOrigem, String contaDestino, LocalDate dataAgendamento, String tipoOperacao) {
        
        Transferencia transferenciaARemover = new TransferenciaBuilder()
                .daConta(contaOrigem).paraConta(contaDestino)
                .em(dataAgendamento).doTipo(TipoOperacao.valueOf(tipoOperacao)).build();
        
        transferencias = transferencias.stream().filter(t -> !t.equals(transferenciaARemover)).collect(Collectors.toList());
    }
}

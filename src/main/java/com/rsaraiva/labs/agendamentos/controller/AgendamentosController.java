package com.rsaraiva.labs.agendamentos.controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import com.rsaraiva.labs.agendamentos.model.TipoOperacao;
import com.rsaraiva.labs.agendamentos.model.Transferencia;
import com.rsaraiva.labs.agendamentos.service.AgendamentosService;
import java.time.LocalDate;
import javax.inject.Inject;

@Controller
public class AgendamentosController {
    
    @Inject private Result result;
    @Inject private AgendamentosService service;

    @Path("/")
    public void agendamentos() {
        result.include("tipos", TipoOperacao.values());
        result.include("transferencias", service.listaTodas());
    }
    
    public void salva(Transferencia transferencia) {
        service.salva(transferencia);
        result.redirectTo(this).agendamentos();
    }
    
    @Get("/exclui/{contaOrigem}/{contaDestino}/{dataAgendamento}/{tipoOperacao}")
    public void exclui(String contaOrigem, String contaDestino, String dataAgendamento, String tipoOperacao) {
        service.exclui(contaOrigem, contaDestino, toLocalDate(dataAgendamento), tipoOperacao);
        result.redirectTo(this).agendamentos();
    }
    
    private LocalDate toLocalDate(String s) {
        // TODO: tenso! melhorar pesquisando ou implementando converter direto no vraptor para LocalDate
        String[] split = s.split("-");
        return LocalDate.of(Integer.valueOf(split[0]), Integer.valueOf(split[1]), Integer.valueOf(split[2]));  
    }
}

package com.rsaraiva.labs.agendamentos.controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import com.rsaraiva.labs.agendamentos.model.TipoOperacao;
import com.rsaraiva.labs.agendamentos.model.Transferencia;
import com.rsaraiva.labs.agendamentos.service.AgendamentosService;
import javax.inject.Inject;
import javax.transaction.Transactional;

@Controller
public class AgendamentosController {
    
    @Inject private Result result;
    @Inject private AgendamentosService service;

    @Path("/")
    public void agendamentos() {
        result.include("tipos", TipoOperacao.values());
        result.include("transferencias", service.listaTodas());
    }
    
    @Transactional
    public void salva(Transferencia transferencia) {
        service.salva(transferencia);
        result.redirectTo(this).agendamentos();
    }
}

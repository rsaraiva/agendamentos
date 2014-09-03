$(function($) {

    $('#formAgendamentos').validate({
        rules: {
            "transferencia.contaOrigem": {required: true},
            "transferencia.contaDestino": {required: true},
            "transferencia.valor": {required: true},
            "transferencia.dataAgendamento": {required: true},
            "transferencia.tipoOperacao": {required: true}
        },
        messages: {
            "transferencia.contaOrigem": {required: "Informe a conta de origem"},
            "transferencia.contaDestino": {required: "Informe a conta de destino"},
            "transferencia.valor": {required: "Informe o valor da transferência"},
            "transferencia.dataAgendamento": {required: "Informe a data da transferência"},
            "transferencia.tipoOperacao": {required: "Informe o tipo da operação"}
        }
    });

    $("#contaOrigem").mask("99999-9");
    $("#contaDestino").mask("99999-9");
    $("#data").mask("99/99/9999");

    $("#valor").maskMoney({thousands: ".", decimal: ","});
    
    
    // actions
    
    $("#botaoSalvar").click(function() {
        $('#formAgendamentos').submit();
    });
});

function excluirAgendamento(origem, destino, data, tipo) {
    // TODO: implementar ajax
    window.location = '/agendamentos/exclui/' + origem + '/' + destino + '/' + data + '/' + tipo;
}

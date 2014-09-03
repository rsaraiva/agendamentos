<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><fmt:message key="agendamento_de_transferencias_financeiras"/></title>

        <link rel="stylesheet" type="text/css" href="<c:url value='/css/ext/bootstrap.min.css'/>"/>
        <link rel="stylesheet" type="text/css" href="<c:url value='/css/default.css'/>"/>

        <script type="text/javascript" src="<c:url value='/js/ext/jquery-2.1.1.min.js'/>"></script>
        <script type="text/javascript" src="<c:url value='/js/ext/jquery.maskedinput.min.js'/>"></script>
        <script type="text/javascript" src="<c:url value='/js/ext/jquery.maskMoney.min.js'/>"></script>
        <script type="text/javascript" src="<c:url value='/js/ext/jquery.validate.min.js'/>"></script>

        <script type="text/javascript" src="<c:url value='/js/agendamentos/agendamentos.js'/>"></script>
    </head>
    <body>
        <section class="container">
            <h1><fmt:message key="agendamento_de_transferencias_financeiras"/></h1>

            <fieldset>
                <legend><fmt:message key="efetuar_nova_transferencia"/></legend>
                <form id="formAgendamentos" action="${linkTo[AgendamentosController].salva}" method="post">
                    <label><fmt:message key="conta_de_origem"/></label>
                    <input type="text" name="transferencia.contaOrigem" id="contaOrigem"/>

                    <label><fmt:message key="conta_de_destino"/></label>
                    <input type="text" name="transferencia.contaDestino" id="contaDestino"/>


                    <label><fmt:message key="valor"/></label>
                    <input type="text" name="transferencia.valor" id="valor"/>


                    <label><fmt:message key="data_da_transferencia"/></label>
                    <input type="text" name="transferencia.dataAgendamento" id="data"/>

                    <label><fmt:message key="tipo_da_operacao"/></label>
                    <select name="transferencia.tipoOperacao" class="input-medium">
                        <c:forEach items="${tipos}" var="tipo">
                            <option>${tipo}</option>
                        </c:forEach>
                    </select>

                    <label/>
                    <button type="button" id="botaoSalvar" class="btn">Salvar</button>
                </form>
            </fieldset>

            <fieldset>
                <legend><fmt:message key="transferencias_agendadas"/></legend>
                <table class="table table-bordered table-hover">
                    <thead>
                        <tr>
                            <th>Origem</th>
                            <th>Destino</th>
                            <th>Valor</th>
                            <th>Data</th>
                            <th>Operação</th>
                            <th>Taxa</th>
                            <th style="width: 30px;">&nbsp;</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${transferencias}" var="transferencia">
                            <tr>
                                <td>${transferencia.contaOrigem}</td>
                                <td>${transferencia.contaDestino}</td>
                                <td>${transferencia.valor}</td>
                                <td>${transferencia.dataAgendamento}</td>
                                <td>${transferencia.tipoOperacao}</td>
                                <td>${transferencia.taxa}</td>
                                <td>
                                    <button type="button" id="botaoExcluir" class="btn btn-mini" 
                                            onclick="excluirAgendamento('${transferencia.contaOrigem}', '${transferencia.contaDestino}', '${transferencia.dataAgendamento}', '${transferencia.tipoOperacao}')">
                                        Excluir
                                    </button>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </fieldset>
        </section>
    </body>
</html>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="jspf/header_funcionario.jspf" %>
<div class="container">
    <h1>Status do pedido</h1>
    <div class="d-inline p-2">
        <form method="post" action="FrontController?action=FuncionarioPedidosAtivos">
            <input type="hidden" name="id_funcionario" value="${id_funcionario}"/>
            <button type="submit" class="btn btn-primary">Voltar</button>
        </form>
    </div>
    <table class="table table-striped justify-content-center text-center">
        <thead class="thead-dark">
            <tr>
                <th scope="col"></th>
                <th scope="col"></th>
                <th scope="col"></th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>Status do pedido:</td>
                <td>${pedido.getNomeEstado()}</td>
                <td>
                    <form method="post" action="FrontController?action=AtualizarPedido">
                        <input  type="hidden" name="id_pedido" value="${pedido.getId()}"/>
                        <input  type="hidden" name="id_funcionario" value="${id_funcionario}"/>
                        <button class="btn btn-link" type="submit">Atualizar estado do pedido</button>
                    </form>
                </td>
            </tr>
            <tr class="bg-info">
                <td rowspan="${itens.size()+1}">Itens</td>
            </tr>
            <c:forEach var="item" items="${itens}">
            <input type="hidden" name="item" value="${item.getId()}"/>
            <tr>
                <td colspan="3">${item.getNome()}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<%@include file="jspf/footer.jspf" %>
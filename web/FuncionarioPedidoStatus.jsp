<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="jspf/header_funcionario.jspf" %>
<div class="container">
    <h1>Status do pedido</h1>
    <div class="d-inline p-2">
        <form method="post" action="FrontController?action=ClientePedidos">
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
                <td>${pedido.getPedidoEstado()}</td>
                <td>
                    <form method="post" action="FrontController?action=MementoVoltarEstado">
                        <input  type="hidden" name="id_pedido" value="${pedido.getId()}"/>
                        <button class="btn btn-link" type="submit">Atualizar estado do pedido</button>
                    </form>
                </td>
            </tr>
            <c:forEach var="item" items="${itens}">
            <input type="hidden" name="item" value="${item.getId()}"/>
            <tr>
                <td>${item.getNome()}</td>
                <td>R$ ${item.getValor()}</td>
                <td></td>
            </tr>
        </c:forEach>
        </tbody>
        <tfoot>
            <tr>
                <td>Forma de pagamento:</td>
                <td>${pagamento.getNome()}</td>
            </tr>
            <tr>
                <td>Desconto:</td>
                <td>${pagamento.getDesconto()}%</td>
            </tr>
            <tr>
        <input type="hidden" name="total" value="${total}"/>
        <td>Total:</td>
        <td>R$ ${total}</td>
        </tr>
        </tfoot>
    </table>
</div>
<%@include file="jspf/footer.jspf" %>
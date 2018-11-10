<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="jspf/header_cliente.jspf" %>
<div class="container">
    <h1>Status do pedido</h1>
    <div class="d-inline p-2">
        <form method="post" action="FrontController?action=ClientePedidos">
            <input type="hidden" name="id_cliente" value="${id_cliente}"/>
            <button type="submit" class="btn btn-primary">Seus pedidos</button>
        </form>
    </div>
    <form method="post" action="FrontController?action=ClienteConfirmarPedido">
    </form>
    <table class="table table-striped justify-content-center text-center">
        <thead class="thead-dark">
            <tr>
                <th scope="col"></th>
                <th scope="col"></th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>Status do pedido:</td>
                <td>${pedido.getNomeEstado()}</td>
            </tr>
            <c:forEach var="item" items="${itens}">
            <input type="hidden" name="item" value="${item.getId()}"/>
            <tr>
                <td>${item.getNome()}</td>
                <td>R$ ${item.getValor()}</td>
            </tr>
        </c:forEach>
        </tbody>
        <tfoot>
            <tr>
                <td>Forma de pagamento:</td>
                <td>${pedido.getFormaPagamento().getNome()}</td>
            </tr>
            <tr>
                <td>Desconto:</td>
                <td>${pedido.getFormaPagamento().getDesconto()}%</td>
            </tr>
            <tr>
        <input type="hidden" name="total" value="${total}"/>
        <td>Total:</td>
        <td>R$ ${pedido.getValor()}</td>
        </tr>
        </tfoot>
    </table>
</div>
<%@include file="jspf/footer.jspf" %>
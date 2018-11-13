<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="jspf/header_cliente.jspf" %>
<div class="container">
    <h1>Lista de produtos</h1>
    <div class="d-inline p-2">
        <form method="post" action="FrontController?action=ClienteProdutosEmpresa">
            <input type="hidden" name="id_cliente" value="${id_cliente}"/>
            <input type="hidden" name="id_empresa" value="${id_empresa}"/>
            <button type="submit" class="btn btn-primary">Voltar</button>
        </form>
    </div>
    <form method="post" action="FrontController?action=ClientePedidoConcluido">
        <input type="hidden" name="id_cliente" value="${id_cliente}"/>
        <input type="hidden" name="id_empresa" value="${id_empresa}"/>
        <input type="hidden" name="pagamento" value="${pagamento.getNomeSA()}"/>
        <table class="table table-striped justify-content-center text-center">
            <thead class="thead-dark">
                <tr>
                    <th scope="col">Nome</th>
                    <th scope="col">Valor</th>
                </tr>
            </thead>
            <tbody>
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
        <button type="submit" class="btn btn-success" style="margin-top: 1em;">Confirmar pedido</button>
        <div class="container">
        </div>
    </form>
</div>
<%@include file="jspf/footer.jspf" %>
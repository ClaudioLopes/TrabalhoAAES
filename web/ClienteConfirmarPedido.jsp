<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="jspf/header_empresa.jspf" %>
<div class="container">
    <h1>Lista de produtos</h1>
    <div class="d-inline p-2">
        <form method="post" action="FrontController?action=ClienteProdutosEmpresa">
            <input type="hidden" name="id_cliente" value="${id_cliente}"/>
            <input type="hidden" name="id_empresa" value="${id_empresa}"/>
            <button type="submit" class="btn btn-primary">Voltar</button>
        </form>
    </div>
    <form method="post" action="FrontController?action=ClienteConfirmarPedido">
        <input type="hidden" name="id_cliente" value="${id_cliente}"/>
        <input type="hidden" name="id_empresa" value="${id_empresa}"/>
        <table class="table table-striped justify-content-center text-center">
            <thead class="thead-dark">
                <tr>
                    <th scope="col">Nome</th>
                    <th scope="col">Valor</th>
                    <th scope="col">Promoção</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="item" items="${itens}">
                    <tr>
                        <td>${item.getNome()}</td>
                        <td>R$ ${item.getValor()}</td>
                        <td></td>
                    </tr>
                </c:forEach>
            </tbody>
            <tfoot>
                <tr>
                    <td>Total:</td>
                    <td>R$ ${total}</td>
                </tr>
            </tfoot>
        </table>
            <label>Selecione a forma de pagamento</label>
            <select class="custom-select" required>
                <option value="1">One</option>
                <option value="2">Two</option>
                <option value="3">Three</option>
            </select>
            <button type="submit" class="btn btn-success" style="margin-top: 1em;">Confirmar pedido</button>
        <div class="container">
        </div>
    </form>
</div>
<%@include file="jspf/footer.jspf" %>
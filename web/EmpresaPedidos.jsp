<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="jspf/header_empresa.jspf" %>
<div class="container">
    <h1>Lista de pedidos</h1>
    <div class="d-inline p-2">
        <form method="post" action="FrontController?action=EmpresaIndex">
            <input type="hidden" name="id_empresa" value="${id_empresa}"/>
            <button type="submit" class="btn btn-primary">Voltar</button>
        </form>
    </div>
    <table class="table table-striped justify-content-center text-center">
        <thead class="thead-dark">
            <tr>
                <th scope="col">ID do pedido</th>
                <th scope="col">Status</th>
                <th scope="col">Valor</th>
                <th scope="col">Ação</th>
            </tr>
        </thead>
        <tbody>
            <tr> <!--APAGAR ISTO DEPOIS -->
                <th scope="row">EXEMPLO ID</th>
                <td>EXEMPLO ESTADO</td>
                <td>EXEMPLO VALOR</td>
                <td>
                    <form method="post" action="FrontController?action=EmpresaPedidoStatus">
                        <input type="hidden" name="id_empresa" value="${id_empresa}"/>
                        <input type="hidden" name="id_pedido" value="${pedido.getId()}"/>
                        <button type="submit" class="btn btn-link">Visualizar pedido</button>
                    </form>
                </td>
            </tr>
            <c:forEach var="pedido" items="${pedidos}">
                <tr>
                    <th scope="row">${pedido.getId()}</th>
                    <td>${produto.getPedidoEstado()}/td>
                    <td>${produto.getValor()}</td>
                    <td>
                        <form method="post" action="FrontController?action=ClientePedidoStatus">
                            <input type="hidden" name="id_empresa" value="${id_empresa}"/>
                            <input type="hidden" name="id_pedido" value="${pedido.getId()}"/>
                            <button type="submit" class="btn btn-primary">Visualizar pedido</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
<%@include file="jspf/footer.jspf" %>
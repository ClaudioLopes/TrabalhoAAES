<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="jspf/header_empresa.jspf" %>
<div class="container">
    <h1>Lista de produtos</h1>
    <div class="d-inline p-2">
        <form method="post" action="FrontController?action=ClienteNovoPedido">
            <input type="hidden" name="id_cliente" value="${id_cliente}"/>
            <button type="submit" class="btn btn-primary">Voltar</button>
        </form>
    </div>
    <form method="post" action="FrontController?action=ClienteConfirmarPedido">
        <button type="submit" class="btn btn-success">Fechar pedido</button>
        <button type="reset" class="btn btn-secondary">Desmarcar todos</button>
        <input type="hidden" name="id_empresa" value="${id_empresa}"/>
        <input type="hidden" name="id_produto" value="${produto.getId()}"/>
        <table class="table table-striped justify-content-center text-center">
            <thead class="thead-dark">
                <tr>
                    <th scope="col">Selecione os produtos</th>
                    <th scope="col">Nome</th>
                    <th scope="col">Valor</th>
                    <th scope="col">Promoção</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="produto" items="${produtos}">
                    <tr>
                        <th scope="row">
                            <div class="form-check">
                                <input type="checkbox" class="form-check-input" id="${produto.getId()}" name="item" value="${produto.getId()}">
                                <label class="form-check-label" for="${produto.getId()}"></label>
                            </div>
                        </th>
                        <td><label class="custom-control-label" for="${produto.getId()}">${produto.getNome()}</label></td>
                        <td><label class="custom-control-label" for="${produto.getId()}">${produto.getValor()}</label></td>
                        <td></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </form>
</div>
<%@include file="jspf/footer.jspf" %>
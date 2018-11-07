<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="jspf/header_cliente.jspf" %>
<div class="container">
    <h1>Lista de produtos</h1>
    <div class="d-inline p-2">
        <form method="post" action="FrontController?action=EmpresaIndex">
            <input type="hidden" name="id_empresa" value="${id_empresa}"/>
            <button type="submit" class="btn btn-primary">Voltar</button>
        </form>
    </div>
    <form method="post" action="FrontController?action=EmpresaComboConcluido">
        <input type="hidden" name="id_empresa" value="${id_empresa}"/>
        <input type="hidden" name="nome" value="${combo.getNome()}"/>
        <table class="table table-striped justify-content-center text-center">
            <thead class="thead-dark">
                <tr>
                    <th scope="col">Combo</th>
                    <th scope="col">${combo.getNome()}</th>
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
            <input type="hidden" name="total" value="${combo.getValor()}"/>
            <td>Total:</td>
            <td>R$ ${combo.getValor()}</td>
            </tr>
            </tfoot>
        </table>
        <button type="submit" class="btn btn-success" style="margin-top: 1em;">Confirmar combo</button>
        <div class="container">
        </div>
    </form>
</div>
<%@include file="jspf/footer.jspf" %>
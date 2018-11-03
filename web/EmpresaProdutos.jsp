<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="jspf/header_empresa.jspf" %>
<div class="container">
    <h1>Lista de produtos</h1>
        <div class="d-inline p-2">
            <form method="post" action="FrontController?action=ProdutoNovo">
                <input type="hidden" name="id_empresa" value="${id_empresa}"/>
                <button type="submit" class="btn btn-success">Novo produto<span class="sr-only">(current)</span></button>
            </form>
        </div>
        <div class="d-inline p-2">
            <form method="post" action="FrontController?action=EmpresaIndex">
                <input type="hidden" name="id_empresa" value="${id_empresa}"/>
                <button type="submit" class="btn btn-secondary">Voltar<span class="sr-only">(current)</span></button>
            </form>
        </div>
    <ul style="list-style: none">
        <c:forEach var="produto" items="${produtos}">
            <li>
                <form method="post" action="FrontController?action=UpdateClienteForm">
                    <input type="hidden" name="id_empresa" value="${id_empresa}"/>
                    <input type="hidden" name="id_produto" value="${produto.getId()}"/>
                    <button type="submit" class="btn btn-link">${produto.getNome()}</button>
                </form>
            </li>
        </c:forEach>
    </ul>
</div>
<%@include file="jspf/footer.jspf" %>
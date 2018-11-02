<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="jspf/header_cliente.jspf" %>
<div class="container">
    <h1>Escolha a empresa para seu novo pedido</h1>
    <ul style="list-style: none">
        <c:forEach var="empresa" items="${empresas}">
        <li>
            <form method="post" action="FrontController?action=ClienteProdutosEmpresa">
                <input type="hidden" name="id_cliente" value="${id_cliente}"/>
                <input type="hidden" name="id_empresa" value="${empresa.getId()}"/>
                <button type="submit" class="btn btn-link">${empresa.getNome()}</button>
            </form>
        </li>
        </c:forEach>
    </ul>
</div>
<%@include file="jspf/footer.jspf" %>
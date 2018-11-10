<%@include file="jspf/header_funcionario.jspf" %>
<div class="container">
    <h1>Index</h1>
    <ul style="list-style: none">
        <li>
        <form method="post" action="FrontController?action=FuncionarioPedidosAtivos">
            <input type="hidden" name="id_funcionario" value="${id_funcionario}"/>
            <button type="submit" class="btn btn-link">Pedidos ativos</button>
        </form>
        </li>
        <li><a href="index.jsp">Logout</a></li>
    </ul>
</div>
<%@include file="jspf/footer.jspf" %>
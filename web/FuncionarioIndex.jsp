<%@include file="jspf/header_empresa.jspf" %>
<div class="container">
    <h1>Index</h1>
    <ul style="list-style: none">
        <li>
            <form method="post" action="FrontController?action=UpdateFuncionarioForm">
                <input type="hidden" name="id_empresa" value="${id_empresa}"/>
                <button type="submit" class="btn btn-link">Atualizar cadastro</button>
            </form>
        </li>
        <li>
        <form method="post" action="FrontController?action=EmpresaPedidosAtivos">
            <input type="hidden" name="id_empresa" value="${id_empresa}"/>
            <button type="submit" class="btn btn-link">Pedidos ativos</button>
        </form>
        </li>
        <li><a href="index.jsp">Logout</a></li>
    </ul>
</div>
<%@include file="jspf/footer.jspf" %>
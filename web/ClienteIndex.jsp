<%@include file="jspf/header_cliente.jspf" %>
<div class="container">
    <h1>Index</h1>
    <ul style="list-style: none">
        <li>
            <form method="post" action="FrontController?action=UpdateClienteForm">
                <input type="hidden" name="id_cliente" value="${id_cliente}"/>
                <button type="submit" class="btn btn-link">Atualizar cadastro</button>
            </form>
        </li>
        <li><a href="ClientePedidos.jsp">Seus pedidos</a>
        <form method="post" action="FrontController?action=ClientePedidos">
                <input type="hidden" name="id_cliente" value="${id_cliente}"/>
                <button type="submit" class="btn btn-link">Seus pedidos</button>
            </form>
        </li>
        <li><a href="NovoPedido.jsp">Novo pedido</a>
        <form method="post" action="FrontController?action=ClienteNovoPedido">
                <input type="hidden" name="id_cliente" value="${id_cliente}"/>
                <button type="submit" class="btn btn-link">Novo pedido</button>
            </form>
        </li>
        <li><a href="ClienteLogout.jsp">Logout</a></li>
    </ul>
</div>
<%@include file="jspf/footer.jspf" %>
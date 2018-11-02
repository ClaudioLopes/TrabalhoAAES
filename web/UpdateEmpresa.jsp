<%@include file="jspf/header.jspf" %>
<h1>Atualizar Dados</h1>
<form action="FrontController?action=UpdateEmpresa" method="post">
    Entre com o nome
    <input type="text" name="textNome"/><br/>
    Entre com o novo tipo
    <input type="text" name="textModalidade"/><br/>
    <input type="submit"/>
    <a href="Login.jsp"><input type="button" value="Voltar"/></a>
</form>
<%@include file="jspf/footer.jspf" %>
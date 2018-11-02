<%@include file="jspf/header.jspf" %>
<h1>Apagar</h1>
<form action="FrontController?action=DeletarFuncionario" method="post">
    Entre com o nome
    <input type="text" name="textNome"/><br/>
    <input type="submit"/>
    <a href="Delete.jsp"><input type="button" value="Voltar"/></a>
</form>
<%@include file="jspf/footer.jspf" %>
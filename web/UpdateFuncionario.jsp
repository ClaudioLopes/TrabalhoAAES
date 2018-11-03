<%@include file="jspf/header.jspf" %>
<h1>Atualizar Dados</h1>
<form action="FrontController?login=UpdateFuncionario" method="post">
    Entre com o nome
    <input type="text" name="textNome"/><br/>
    Entre com o novo telefone
    <input type="tel" name="textTelefone"/><br/>
    <input type="submit"/>
    <a href="Login.jsp"><input type="button" value="Voltar"/></a>
</form>
<%@include file="jspf/footer.jspf" %>
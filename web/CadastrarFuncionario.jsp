<%-- 
    Document   : CadastrarFuncionario
    Created on : Oct 17, 2018, 8:09:12 AM
    Author     : claudio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>IFood</title>
    </head>
    <body>
        <h1>Cadastrar</h1>
        <form action="FrontController?usuario=CadastrarFuncionario" method="post">
          Entre com o nome
          <input type="text" name="textNome"/><br/>
          Entre com o email
          <input type="email" name="textEmail"/><br/>
          Entre com o telefone
          <input type="tel" name="textTelefone"/><br/>
          <input type="submit" name="Cadastrar"/>
        </form>
    </body>
</html>

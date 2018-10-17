<%-- 
    Document   : LoginCliente
    Created on : Oct 17, 2018, 7:52:16 AM
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
        <h1>Entrar</h1>
        <form action="FrontController?usuario=LoginCliente" method="post">
          Entre com o nome
          <input type="text" name="textNome"/><br/>
          Entre com a senha
          <input type="password" name="textSenha"/><br/>
          <input type="submit"/>
        </form>
    </body>
</html>

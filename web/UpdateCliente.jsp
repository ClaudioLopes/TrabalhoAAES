<%-- 
    Document   : UpdateCliente
    Created on : Oct 17, 2018, 8:15:15 AM
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
        <h1>Atualizar Dados</h1>
        <form action="FrontController?usuario=UpdateCliente" method="post">
          Entre com o nome
          <input type="text" name="textNome"/><br/>
          Entre com o novo telefone
          <input type="tel" name="textTelefone"/><br/>
          <input type="submit"/>
        </form>
    </body>
</html>

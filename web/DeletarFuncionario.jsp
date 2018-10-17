<%-- 
    Document   : DeletarFuncionario
    Created on : Oct 17, 2018, 8:12:49 AM
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
        <h1>Apagar</h1>
        <form action="FrontController?usuario=DeletarFuncionario" method="post">
          Entre com o nome
          <input type="text" name="textNome"/><br/>
          <input type="submit"/>
        </form>
    </body>
</html>

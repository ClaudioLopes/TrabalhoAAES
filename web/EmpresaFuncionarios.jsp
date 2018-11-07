<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="jspf/header_empresa.jspf" %>
<div class="container">
    <h1>Lista de funcionários</h1>
    <div class="d-inline p-2">
        <form method="post" action="FrontController?action=EmpresaIndex" style="margin-bottom: 1em;">
            <input type="hidden" name="id_cliente" value="${id_empresa}"/>
            <button type="submit" class="btn btn-primary">Voltar</button>
        </form>
        <form method="post" action="FrontController?action=FuncionarioCadastrarForm">
            <input type="hidden" name="id_cliente" value="${id_empresa}"/>
            <button type="submit" class="btn btn-success">Novo funcionário</button>
        </form>
    </div>
    <table class="table table-striped justify-content-center text-center">
        <thead class="thead-dark">
            <tr>
                <th scope="col">ID Funcionário</th>
                <th scope="col">Nome</th>
                <th scope="col">Funcao</th>
                <th scope="col">E-mail</th>
            </tr>
        </thead>
        <tbody>
            <tr> <!-- APAGAR ISTO DEPOIS -->
                <th scope="row">1</th>
                <td>João</td>
                <td>Cozinheiro</td>
                <td>j@o.com</td>
            </tr>
            <tr> <!-- APAGAR ISTO DEPOIS -->
                <th scope="row">2</th>
                <td>José</td>
                <td>Administrador</td>
                <td>j@se.com    </td>
            </tr>
            <c:forEach var="funcionario" items="${funcionarios}">
                <tr>
                    <th scope="row">${funcionario.getId()}</th>
                    <td>${funcionario.getNome()}</td>
                    <td>${funcionario.getFuncao()}</td>
                    <td>${funcionario.getEmail()}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
<%@include file="jspf/footer.jspf" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="jspf/header_empresa.jspf" %>
<div class="container">
    <h1>Lista de produtos</h1>
    <div class="d-inline p-2">
        <form method="post" action="FrontController?action=ProdutoCadastrarForm">
            <input type="hidden" name="id_empresa" value="${id_empresa}"/>
            <button type="submit" class="btn btn-success">Novo produto</button>
        </form>
    </div>
    <div class="d-inline p-2">
        <form method="post" action="FrontController?action=EmpresaIndex">
            <input type="hidden" name="id_empresa" value="${id_empresa}"/>
            <button type="submit" class="btn btn-secondary">Voltar</button>
        </form>
    </div>
    <div class="d-inline p-2">
        <form method="post" action="FrontController?action=EmpresaNovoCombo">
            <input type="hidden" name="id_empresa" value="${id_empresa}"/>
            <button type="submit" class="btn btn-secondary">Novo combo</button>
        </form>
    </div>
    <form method="post" action="FrontController?action=ProdutoUpdateForm">
        <input type="hidden" name="id_empresa" value="${id_empresa}"/>
        <input type="hidden" name="id_produto" value="${produto.getId()}"/>
    </form>
    <table class="table table-striped">
        <thead class="thead-dark">
            <tr>
                <th scope="col">ID</th>
                <th scope="col">Nome</th>
                <th scope="col">Valor</th>
                <th scope="col">Promo��o</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="produto" items="${produtos}">
                <tr>
                    <th scope="row">${produto.getId()}</th>
                    <td>${produto.getNome()}</td>
                    <td>${produto.getValor()}</td>
                    <td></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <table class="table table-striped">
        <thead class="thead-dark">
            <tr>
                <th scope="col">ID</th>
                <th scope="col">Nome</th>
                <th scope="col">Valor</th>
                <th scope="col">Promo��o</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="produto" items="${produtos}">
                <tr>
                    <th scope="row">${produto.getId()}</th>
                    <td>${produto.getNome()}</td>
                    <td>${produto.getValor()}</td>
                    <td></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
<%@include file="jspf/footer.jspf" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="jspf/header_empresa.jspf" %>
<div class="container">
    <h1>Lista de produtos</h1>
    <div class="d-inline p-2">
        <form method="post" action="FrontController?action=ClienteNovoPedido">
            <input type="hidden" name="id_cliente" value="${id_cliente}"/>
            <button type="submit" class="btn btn-primary">Voltar</button>
        </form>
    </div>
    <form method="post" action="FrontController?action=ClienteConfirmarPedido">
        <div class="container" style="margin-bottom: 1em;">
            <button type="submit" class="btn btn-success">Fechar pedido</button>
            <button type="reset" class="btn btn-secondary">Desmarcar todos</button>
        </div>
        <input type="hidden" name="id_empresa" value="${id_empresa}"/>
        <input type="hidden" name="id_cliente" value="${id_cliente}"/>
        <label>Selecione a forma de pagamento</label>
        <div class="custom-control custom-radio">
            <input type="radio" id="${dinheiro}" name="pagamento" class="custom-control-input" value="Dinheiro" checked>
            <label class="custom-control-label" for="${dinheiro}">Dinheiro - (${dinheiro.getDesconto()}% de desconto)</label>
        </div>
        <div class="custom-control custom-radio">
            <input type="radio" id="${cartao}" name="pagamento" class="custom-control-input" value="Cartao">
            <label class="custom-control-label" for="${cartao}">Cartão - (${cartao.getDesconto()}% de desconto)</label>
        </div>
        <div class="container">
        </div>
        <table class="table table-striped justify-content-center text-center">
            <thead class="thead-dark">
                <tr>
                    <th scope="col">Selecione os produtos</th>
                    <th scope="col">Nome</th>
                    <th scope="col">Valor</th>
                    <th scope="col">Promoção</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="produto" items="${produtos}">
                    <tr>
                        <th scope="row">
                            <div class="form-check">
                                <input type="checkbox" class="form-check-input" id="${produto.getId()}" name="item" value="${produto.getId()}">
                                <label class="form-check-label" for="${produto.getId()}"></label>
                            </div>
                        </th>
                        <td><label class="custom-control-label" for="${produto.getId()}">${produto.getNome()}</label></td>
                        <td><label class="custom-control-label" for="${produto.getId()}">${produto.getValor()}</label></td>
                        <td></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </form>
</div>
<%@include file="jspf/footer.jspf" %>
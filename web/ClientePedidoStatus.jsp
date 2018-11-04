<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="jspf/header_cliente.jspf" %>
<div class="container">
    <h1>Lista de produtos</h1>
    <div class="d-inline p-2">
        <form method="post" action="FrontController?action=ClienteProdutosEmpresa">
            <input type="hidden" name="id_cliente" value="${id_cliente}"/>
            <input type="hidden" name="id_empresa" value="${id_empresa}"/>
            <button type="submit" class="btn btn-primary">Voltar</button>
        </form>
    </div>
    <form method="post" action="FrontController?action=ClienteConfirmarPedido">
        <input type="hidden" name="id_cliente" value="${id_cliente}"/>
        <input type="hidden" name="id_empresa" value="${id_empresa}"/>
        <input type="hidden" name="produtos" value="${produtos}"/>
        <label>Selecione a forma de pagamento</label>
        <div class="custom-control custom-radio">
            <input type="radio" id="${dinheiro}" name="pagamento" class="custom-control-input" value="${dinheiro}" checked>
            <label class="custom-control-label" for="${dinheiro}">Dinheiro - (${dinheiro.getDesconto()}% de desconto)</label>
        </div>
        <div class="custom-control custom-radio">
            <input type="radio" id="${cartao}" name="pagamento" class="custom-control-input" value="${cartao}">
            <label class="custom-control-label" for="${cartao}">Cartão - (${cartao.getDesconto()}% de desconto)</label>
        </div>
        <button type="submit" class="btn btn-success" style="margin-top: 1em;">Confirmar pagamento</button>
        <div class="container">
        </div>
    </form>
</div>
<%@include file="jspf/footer.jspf" %>
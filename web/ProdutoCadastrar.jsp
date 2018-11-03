<%@include file="jspf/header.jspf" %>
<div class="container">
    <h1>Cadastrar produto</h1>
    <div class="d-inline p-2">
        <form method="POST" action="FrontController?action=ProdutoCadastrar">
            <input type="hidden" name="id_empresa" value="${id_empresa}"/>
            <div class="form-row">
                <div class="form-group col-md-12">
                    <label for="nome">Nome do produto<small class="text-danger"><strong>*</strong></small></label>
                    <input type="text" class="form-control" id="nome" placeholder="Nome do produto" name="nome" required>
                </div>
                <div class="form-group col-md-6">
                    <label for="valor">Valor<small class="text-danger"><strong>*</strong></small></label>
                    <input type="text" class="form-control" id="valor" placeholder="Valor" name="valor" required>
                </div>
            </div>
            <div class="form-group row">
                <small class="text-danger"><small><strong>Os campos com * são obrigatórios!</strong></small></small>
            </div>
            <button type="submit" class="btn btn-success">Cadastrar</button>
            <button type="reset" class="btn btn-secondary">Limpar Campos</button>

        </form>
    </div>
    <div class="d-inline p-2">
        <form method="post" action="FrontController?action=EmpresaProdutos">
            <input type="hidden" name="id_empresa" value="${id_empresa}"/>
            <button type="submit" class="btn btn-danger">Voltar</button>
        </form>
    </div>
</div>
<%@include file="jspf/footer.jspf" %>
<%@include file="jspf/header.jspf" %>
<div class="container">
    <h1>Cadastrar funcionário</h1>
    <form method="POST" action="FrontController?action=CadastrarFuncionario">
        <input type="hidden" name="id_empresa" value="${id_empresa}"/>
        <div class="form-row">
            <div class="form-group col-md-6">
                <label for="nome">Nome completo<small class="text-danger"><strong>*</strong></small></label>
                <input type="text" class="form-control" id="nome" placeholder="Nome completo" name="nome" required>
            </div>
            <div class="form-group col-md-6">
                <label for="funcao">Função<small class="text-danger"><strong>*</strong></small></label>
                <select class="custom-select" name="funcao" id="funcao" required>
                    <option value="Administrador" selected>Administrador</option>
                    <option value="Cozinheiro">Cozinheiro</option>
                    <option value="Entregador">Entregador</option>
                </select>
            </div> 
        </div>
        <div class="form-row">
            <div class="form-group col-md-6">
                <label for="email">E-mail<small class="text-danger"><strong>*</strong></small></label>
                <input type="email" class="form-control" id="email" name="email" placeHolder="seu@email.com" required>
            </div>
            <div class="form-group col-md-6">
                <label for="senha">Senha<small class="text-danger"><strong>*</strong></small></label>
                <input type="password" class="form-control" id="senha" name="senha" required>
            </div>
        </div>
        <div class="form-group row">
            <small class="text-danger"><small><strong>Os campos com * são obrigatórios!</strong></small></small>
        </div>
        <button type="submit" class="btn btn-success">Cadastrar</button>
        <button type="reset" class="btn btn-secondary">Limpar Campos</button>
    </form>
    <form method="post" action="FrontController?action=EmpresaFuncionarios" style="margin-bottom: 1em;">
        <input type="hidden" name="id_empresa" value="${id_empresa}"/>
        <button type="submit" class="btn btn-primary" style="margin-top: 1em;">Voltar</button>
    </form>
</div>
<%@include file="jspf/footer.jspf" %>
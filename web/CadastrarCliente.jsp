<%@include file="jspf/header.jspf" %>
<div class="container">
<h1>Cadastrar cliente</h1>
    <form method="POST" action="FrontController?action=CadastrarCliente">
        <div class="form-row">
            <div class="form-group col-md-6">
                <label for="nomeCompleto">Nome completo<small class="text-danger"><strong>*</strong></small></label>
                <input type="text" class="form-control" id="nomeCompleto" placeholder="Nome completo" name="textNome" required>
            </div>
            <div class="form-group col-md-6">
                <label for="telefone">Telefone<small class="text-danger"><strong>*</strong></small></label>
                <input type="text" class="form-control" id="telefone" placeholder="99999999" name="textTelefone" required>
            </div> 
        </div>
        <div class="form-row">
            <div class="form-group col-md-6">
                <label for="email">E-mail<small class="text-danger"><strong>*</strong></small></label>
                <input type="email" class="form-control" id="email" name="textEmail" placeHolder="seu@email.com" required>
            </div>
            <div class="form-group col-md-6">
                <label for="senha">Senha<small class="text-danger"><strong>*</strong></small></label>
                <input type="password" class="form-control" id="senha" name="textSenha" required>
            </div>
        </div>
        <div class="form-group row">
            <small class="text-danger"><small><strong>Os campos com * são obrigatórios!</strong></small></small>
        </div>
        <button type="submit" class="btn btn-success">Cadastrar</button>
        <button type="reset" class="btn btn-secondary">Limpar Campos</button>
        <a class="btn btn-danger" href="index.jsp">Voltar</a>
    </form>
</div>
<%@include file="jspf/footer.jspf" %>
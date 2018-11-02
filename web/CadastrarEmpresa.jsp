<%@include file="jspf/header.jspf" %>
<div class="container">
<h1>Cadastrar empresa</h1>
    <form method="POST" action="FrontController?action=CadastrarEmpresa">
        <div class="form-row">
            <div class="form-group col-md-12">
                <label for="nomeCompleto">Nome da empresa<small class="text-danger"><strong>*</strong></small></label>
                <input type="text" class="form-control" id="nomeCompleto" placeholder="Nome da empresa" name="textNome" required>
            </div>
        </div>
        <div class="form-row">
            <div class="form-group col-md-6">
                <label for="email">E-mail<small class="text-danger"><strong>*</strong></small></label>
                <input type="text" class="form-control" id="email" placeholder="email@empresa.com" name="textEmail" required>
            </div>
            <div class="form-group col-md-6">
                <label for="senha">Senha<small class="text-danger"><strong>*</strong></small></label>
                <input type="password" class="form-control" id="senha" name="textSenha" required>
            </div>
        </div>
        <div c
        <div class="form-group row">
            <small class="text-danger"><small><strong>Os campos com * s�o obrigat�rios!</strong></small></small>
        </div>
        <button type="submit" class="btn btn-success">Cadastrar</button>
        <button type="reset" class="btn btn-secondary">Limpar Campos</button>
        <a class="btn btn-danger" href="index.jsp">Voltar</a>
    </form>
</div>
<%@include file="jspf/footer.jspf" %>
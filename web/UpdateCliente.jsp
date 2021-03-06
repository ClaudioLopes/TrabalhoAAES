<%@include file="jspf/header_cliente.jspf" %>
<div class="container">
<h1>Atualizar dados</h1>
    <form method="POST" action="FrontController?action=UpdateCliente">
        <input type="hidden" name="id_cliente" value="${id_cliente}"/>
        <div class="form-row">
            <div class="form-group col-md-6">
                <label for="nomeCompleto">Nome completo<small class="text-danger"><strong>*</strong></small></label>
                <input type="text" class="form-control" id="nomeCompleto" placeholder="Nome completo" name="textNome" value="${cliente.getNome()}" required>
            </div>
            <div class="form-group col-md-6">
                <label for="telefone">Telefone<small class="text-danger"><strong>*</strong></small></label>
                <input type="text" class="form-control" id="telefone" placeholder="99999999" name="textTelefone" value="${cliente.getTelefone()}" required>
            </div> 
        </div>
        <div class="form-row">
            <div class="form-group col-md-6">
                <label for="email">E-mail<small class="text-danger"><strong>*</strong></small></label>
                <input type="email" class="form-control" id="email" name="textEmail" placeHolder="seu@email.com" value="${cliente.getEmail()}" required>
            </div>
            <div class="form-group col-md-6">
                <label for="senha">Senha</label>
                <input type="password" class="form-control" id="senha" name="textSenha">
            </div>
        </div>
        <div class="form-group row">
            <small class="text-danger"><small><strong>Os campos com * s�o obrigat�rios!</strong></small></small>
        </div>
        <button type="submit" class="btn btn-success">Cadastrar</button>
        <button type="reset" class="btn btn-secondary">Limpar Campos</button>
    </form>
            <form method="post" action="FrontController?action=ClienteIndex">
                <input type="hidden" name="id_cliente" value="${cliente.getId()}"/>
                <button class="btn btn-primary" type="submit" style="margin-top: 1em;">Voltar</button>
            </form>
</div>
<%@include file="jspf/footer.jspf" %>
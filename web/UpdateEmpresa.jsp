<%@include file="jspf/header_empresa.jspf" %>
<div class="container">
    <h1>Atualizar dados</h1>
    <div class="i-nline p-2">
        <form method="POST" action="FrontController?action=UpdateEmpresa">
            <input type="hidden" name="id_empresa" value="${id_empresa}"/>
            <div class="form-row">
                <div class="form-group col-md-12">
                    <label for="nomeCompleto">Nome da empresa<small class="text-danger"><strong>*</strong></small></label>
                    <input type="text" class="form-control" id="nomeCompleto" placeholder="Nome da empresa" name="textNome" value="${empresa.getNome()}" required>
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="email">E-mail<small class="text-danger"><strong>*</strong></small></label>
                    <input type="text" class="form-control" id="email" placeholder="email@empresa.com" name="textEmail" value="${empresa.getEmail()}" required>
                </div>
                <div class="form-group col-md-6">
                    <label for="senha">Senha</label>
                    <input type="password" class="form-control" id="senha" name="textSenha">
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
        <form method="post" action="FrontController?action=EmpresaIndex">
            <input type="hidden" name="id_empresa" value="${id_empresa}"/>
            <button type="submit" class="btn btn-danger">Voltar<span class="sr-only">(current)</span></button>
        </form>
    </div>
</div>
<%@include file="jspf/footer.jspf" %>
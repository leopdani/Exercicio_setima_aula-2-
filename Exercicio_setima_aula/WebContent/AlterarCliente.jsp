<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

        <!DOCTYPE html>
        <html lang="pt-br">

        <head>
            <meta charset="utf-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <meta name="viewport" content="width=device-width, initial-scale=1">
            <title>cerveja.biz - Alterar Cliente</title>

            <link href="css/bootstrap.min.css" rel="stylesheet">
            <link href="css/style.css" rel="stylesheet">
        </head>

        <body>
                <!-- Barra superior com os menus de navegação -->
				<c:import url="Menu.jsp"/>
                <!-- Container Principal -->
                <div id="main" class="container">
                    <h3 class="page-header">Alterar Cliente #${cliente.id }</h3>
                    <!-- Formulario para alteração de clientes -->
                    <form action="ManterCliente.do" method="post">
                        <!-- area de campos do form -->
                        <input type="hidden" name="id" value="${cliente.id }" />
                        <div class="row">
                            <div class="form-group col-md-12">
                                <label for="nome">Nome</label>
                                <input type="text" class="form-control" name="nome" id="nome" required maxlength="100" placeholder="nome completo" value="${cliente.nome }">
                            </div>
                        </div>
                        <div class="row">
                            <div class="form-group col-md-6">
                                <label for="fone">Celular</label>
                                <input type="tel" class="form-control" name="fone" id="fone" maxlength="15" pattern="(?:\(\d{2}\)|\d{2})[- ]?\d{5}[- ]?\d{4}" placeholder="opcional; celular com ddd no formato (99) 99999-9999" value="${cliente.fone }">
                            </div>

                            <div class="form-group col-md-6">
                                <label for="email">E-Mail</label>
                                <input type="email" class="form-control" name="email" id="email" required maxlength="60" placeholder="email obrigatório" value="${cliente.email }">
                            </div>
                        </div>
                        <hr />
                        <div id="actions" class="row">
                            <div class="col-md-12">
                                <button type="submit" class="btn btn-primary" name="acao" value="Alterar">Salvar</button>
                                <a href="ListarClientes.jsp" class="btn btn-default">Cancelar</a>
                            </div>
                        </div>
                    </form>
                </div>
                <script src="js/jquery.min.js"></script>
                <script src="js/bootstrap.min.js"></script>
        </body>

        </html>
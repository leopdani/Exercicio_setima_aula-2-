<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

        <!DOCTYPE html>
        <html lang="pt-br">

        <head>
            <meta charset="utf-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <meta name="viewport" content="width=device-width, initial-scale=1">
            <title>cerveja.biz - Alterar Pais</title>

            <link href="css/bootstrap.min.css" rel="stylesheet">
            <link href="css/style.css" rel="stylesheet">
        </head>

        <body>
                <!-- Barra superior com os menus de navegação -->
				<c:import url="Menu.jsp"/>
                <!-- Container Principal -->
                <div id="main" class="container">
                    <h3 class="page-header">Alterar Pais #${pais.id }</h3>
                    <!-- Formulario para alteração de paises -->
                    <form action="ManterPais.do" method="post">
                        <!-- area de campos do form -->
                        <input type="hidden" name="id" value="${pais.id }" />
                        <div class="row">
                            <div class="form-group col-md-12">
                                <label for="nome">Nome</label>
                                <input type="text" class="form-control" name="nome" id="nome" required maxlength="100" placeholder="nome completo" value="${pais.nome }">
                            </div>
                        </div>
                        <div class="row">
                            <div class="form-group col-md-6">
                                <label for="populacao">Populacao</label>
                                <input type="populacao" class="form-control" name="populacao" id="populacao" required maxlength="15" value="${pais.populacao}">
                            </div>

                            <div class="form-group col-md-6">
                                <label for="area">Area</label>
                                <input type="area" class="form-control" name="area" id="area" required maxlength="60" value="${pais.area }">
                            </div>
                        </div>
                        <hr />
                        <div id="actions" class="row">
                            <div class="col-md-12">
                                <button type="submit" class="btn btn-primary" name="acao" value="Alterar">Salvar</button>
                                <a href="ListarPaises.jsp" class="btn btn-default">Cancelar</a>
                            </div>
                        </div>
                    </form>
                </div>
                <script src="js/jquery.min.js"></script>
                <script src="js/bootstrap.min.js"></script>
        </body>

        </html>
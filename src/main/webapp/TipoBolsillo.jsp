<!DOCTYPE html >
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

    <html>

    <head>
        <title>Usuario</title>
        <!-- Enlace a Bootstrap CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
        <link rel="stylesheet" href="assets/css/estilos3.css">

        <style>
            /* Estilos personalizados */
            body {
                background-color: #f2f2f2;
            }

            .navbar {
                background-color: #b3bdc7;
                width: 1500px;
                height: 70px;
            }

            .nav-link {
                color: #fff;
            }

            .form-control:focus {
                border-color: #b3bdc7;
                box-shadow: none;
            }

            .btn-primary {
                background-color: #b3bdc7;
                border-color: #b3bdc7;
            }

            .btn-primary:hover {
                background-color: #b3bdc7;
                border-color: #b3bdc7;
            }

            .card {
                margin-top: 50px;
                border: none;
                border-radius: 10px;
                box-shadow: 0 0 5px rgba(0, 0, 0, 0.1);
            }

            .card-header {
                background-color: #b3bdc7;
                color: #fff;
                border-radius: 10px 10px 0 0;
                text-align: center;
            }
        </style>
    </head>

    <body>
        <!-- Menú de navegación -->
        <nav class="navbar navbar-expand-lg navbar-dark">
            <div class="container">
                <a class="navbar-brand" href="#">Bolsillo Digital</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
                    aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarNav">
                    <ul class="navbar-nav ml-auto">

                        <li class="nav-item active">
                            <a class="nav-link" href="Usuarios?accion=login">Salir</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>

        <body>
            <div class="flex-fill flex-grow-1 ms-3">

                <h1>Lista de Usuarios</h1>


                <table class="table table-hover table-bordered">

                    <tr>
                        <th>Id</th>
                        <th>Nequi</th>
                        <th>Daviplata</th>
                        </th>
<br>

                    </tr>

                    <c:forEach var="TipoBolsillo" items="${TipoBolsillo}">

                        <tr>
                            <td>${TipoBolsillo.getId_TipoBolsillo()}</td>
                            <td>${TipoBolsillo.getNequi()}</td>
                            <td>${TipoBolsillo.getDaviplata()}</td>

                            <td>
                                <a TipoBolsillo="button" class="btn btn-warning" href="tipobolsillo?accion=TipoBolsillo-modificar">
                                    <i class="bi bi-pencil"></i>
                                    Actualizar
                                </a>

                            </td>
                        <tr>
                    </c:forEach>
                </table>
            </div>
            </div>
            <a type="button" class="btn btn-primary" href="tipobolsillo?accion=TipoBolsillo-add">
                <i class="bi bi-plus-circle"></i>
                Agregar bolsillo
            </a>
        </body>
        <br>
        <center>
            <footer>
                <P>
                    <b>INFORMACION DE CONTACTO</b>
                    <br><br>
                    Correo Electrinico: briccorrea@tubolsillofavorito.com<br>
                    Telefono:312 366589 <br><br>
                    <b> Copyright &popy; 2023 - BOGOTA D.C</b>
                </P>
        </center>
        </footer>
    </body>
    </html>
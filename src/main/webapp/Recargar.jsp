<!DOCTYPE html <%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>>
<html>

<head>
	<title>Recargar</title>
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
						<a class="nav-link" href="Usuarios?accion=Daviplata">Daviplata</a>
					</li>
					<li class="nav-item active">
						<a class="nav-link" href="Usuarios?accion=Nequi">Nequi</a>
					</li>
					<li class="nav-item active">
						<a class="nav-link" href="Usuarios?accion=login">Salir</a>
					</li>
				</ul>
			</div>
		</div>
	</nav>

	<body>

		<div class="wrapper fadeInDown">
			<div id="formContent">

				<br>
				<h1>Recargar</h1>
				<br>
				<!-- Login Form -->
				<form action="bolsillo" method="post">
					<label for="Recarga">Recarga</label><br>
					<input type="text" name="Recarga">
					<input type="submit" name="accion" value="Recargar">
				</form>


			</div>

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
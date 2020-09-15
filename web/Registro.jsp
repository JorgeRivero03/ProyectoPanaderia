<%-- 
    Document   : Registro
    Created on : 13/09/2020, 09:26:05 PM
    Author     : Jorge Rivero
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Iniciar Sesion</title>
        <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300&display=swap" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="./css/style.css"/>
	<link rel="shortcut icon" href="./img/logo.jpg" type="image/x-icon"/>
    </head>
    <body>
        <header class="header">
		<div class="logo">
			<h1>
				Panaderia el Globito
			</h1>
			<img src="./img/logo.png" alt="logo" width="200px" height="250px">	
		</div>
		<nav class="menu">
			<a href="index.html">Principal</a>
			<a href="nosotros.html">Nosotros</a>
			<a href="#">Productos</a>
			<a href="contacto.html">Contactos</a>
			<a href="Cliente.jsp">Cliente</a>

		</nav>
	</header>
	<section class="globito">
		<h2>La Panaderia el globito, hace pan artesanal desde 1896, y ahora esta en la nube compre su panecito aquí.</h2>
		<img src="./img/globo.jpg" alt="Globito">
	</section>
	<h2 class="titulo-p">
	Pan Artesanal
	</h2>
    <sectio>
        
    </sectio>
    <section class="registro"><h3>
            <form method="pan" action="GuardarUsuario">
                <input type="text" name="nombre">Nombre:</input>
                <input type="text" name="apellidoPaterno">Apellido Paterno:</input>
                <input type="text" name="password">Contraseña:</input>
                <input type="text" name="usuario">Usuario:</input>
                 <td><input type="submit" value="Entrar" name="registrar">
        </h3>
            </form>
        </section>
        
        

        
	<footer class="footer">
		<p>Desarrollado por Jorge Rivero</p>
	</footer>

    </body>
</html>

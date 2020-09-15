<%-- 
    Document   : inicio.jsp
    Created on : 12/09/2020, 12:40:17 PM
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
			<a href="#">Cliente</a>
                        <a href="Registro.jsp">Registrarse</a>
		</nav>
	</header>
	<section class="globito">
		<h2>La Panaderia el globito, hace pan artesanal desde 1896, y ahora esta en la nube compre su panecito aquí.</h2>
		<img src="./img/globo.jpg" alt="Globito">
	</section>
	<h2 class="titulo-p">
	Pan Artesanal
	</h2>

	<section class="hide">
		
	</section>
        
        <section class = "iniciosesion">
            <table width="800" border="0" align="center">
                <tr>
                    <td colspan="2"><h2>Inicio de Sesion</h2></td>
                </tr>
                <tr>
                    <td>
                <from method="post" name="formulario" action="VerificarUsuario">
                    <table width="620" border="0">                       
                        <tr>
                            <td>Usuario:</td>
                            <td> <input type="text" name="user" id="user"> </td>
                        </tr>
                        <tr>
                            <td>Contraseña:</td>
                            <td> <input type="password" name="pass" id="pass"> </td>
                        </tr>
                        <tr>
                            <td><a href="registro.jsp">Nueva Cuenta</a></td>
                            <td><input type="submit" value="Entrar" name="inicio"></td>
                        </tr>
                    </table>
                </from>
                    </td>
                </tr>
            </table>
            
        </section>
        
	<footer class="footer">
		<p>Desarrollado por Jorge Rivero</p>
	</footer>

    </body>
</html>

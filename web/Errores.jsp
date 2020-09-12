<%-- 
    Document   : Errores
    Created on : 12/09/2020, 05:33:31 PM
    Author     : Jorge Rivero
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" session="true"%>

<% 
    String usuario = "";
    HttpSession sesionUser = request.getSession();
    if(sesionUser.getAttribute("usuario") == null){
         
%>
<jsp:forward page="inicio.jsp">
    <jsp:param name="error" value="Es obligatorio Autenticarse pro"/>
</jsp:forward>

<%}else{
    usuario = (String)sesionUser.getAttribute("usuario");
     }}    
%>
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
                        <a href="inicio.jsp">Iniciar Sesion</a>
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
            <h2>Error al introducir sus credenciales favor de intentarlo otra vez crack</h2>
        </section>
        
	<footer class="footer">
		<p>Desarrollado por Jorge Rivero</p>
	</footer>

    </body>
</html>


<%-- 
    Document   : MostrarCarritoPanes
    Created on : 13/09/2020, 02:08:33 PM
    Author     : Jorge Rivero
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="java.util.*, Controlador.*" session="true"%>
<%
String usuario = "";
//sesion del usuario
HttpSession sesionuser = request.getSession();
//verificar el usuario
if (sesionuser.getAttribute("usuario") == null) {
%>



<jsp:forward page="inicio.jsp">
    <jsp:param name="error" value="Es obligatorio autenticarse con una sesion valida"/>   
</jsp:forward>
<%
    }else{
        usuario = (String)sesionuser.getAttribute("usuario");
    }
%>


<!DOCTYPE html>
<head>
	<title>Panaderia Globito</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width-device-width, initial-scale= 1.0">
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
                        <a href="perfil.jsp">Perfil</a>
		</nav>
	</header>
	<section class="globito">
		<h2>Pan artesanal, escoga el que más le guste</h2>
		<img src="./img/globo.jpg" alt="Globito">
	</section>
	<h2 class="titulo-p">
	Pan Artesanal
	</h2>
        
	<section class="pan">
            
            <table width="100" border="0">
                <tr>
                    <th>Nombre del pan</th>
                    <th>Cantidad</th>
                    <th>Subtotal</th>
                   
                </tr>
            
            
            <%
                Vector<DVenta> detalleVentas = (Vector<DVenta>)sesionuser.getAttribute("detalleVenta");
                Vector<MPan> stockPanes = null;
                
                for(DVenta dventa : detalleVentas ){
                    
                //necesitamos buscar el id del pan que se esta escogiendo
                MPan pan = new MPan().buscarPan(dventa.getId_pan());
            %>
            <p class="img" >
            <table>
                <tr>
                    
                    <td><%=pan.getNom_pan() %></td>
                    <td><%=dventa.getCant_dventa() %> </td>
                    <td><%=dventa.getSubtotal_dventa() %> </td>
                    
                </tr>
		<%}%>
                <tr>
                    <td></td>
                    <td><a href="FinalizarCompra">Pagar Panesito</td>
                </tr>
                </table></p>
	</section>
	<section class="hide">
		
	</section>
        <section class="menu" >
            <a href="MostrarPanes.jsp">Mostrar los panes</a>
            <a href="AgregarPan1.jsp">Agregar al carrito de compras</a>
            <a hrf="CerrarSesion.jsp">Cerrar Sesion</a>
        </section>
	<footer class="footer">
		<p>Desarrollado por Jorge Rivero</p>
	</footer>
	<script src="./js/anima.js"></script>
</body>
</html>

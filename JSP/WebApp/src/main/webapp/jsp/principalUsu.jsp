<%@page import="java.util.List"%>
<%@page import="es.altair.bean.Usuarios"%>
<%@page import="es.altair.bean.Libros"%>
<%@page import="es.altair.dao.LibroDAOImplHibernate"%>
<%@page import="es.altair.dao.LibroDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Libros del Usuario</title>
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="../css/bootstrap.min.css">

<!-- Stylesheets -->
<link rel="stylesheet" href="../fonts/font-awesome.min.css">
</head>
<body>
	<div class="container">

		<%
			if (session.getAttribute("usuLogeado") == null || session.isNew()) {
				response.sendRedirect("../index.jsp?mensaje=Inicie sesi�n");
			} else {
				LibroDAO lDAO = new LibroDAOImplHibernate();
				List<Libros> libros = lDAO.listaLibro();
		%>

		<div class="row">
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><a href="../index.jsp">Bienvenido 
					<%=((Usuarios)session.getAttribute("usuLogeado")).getNombre()%>
					</a>
				</li>	
				<li class="breadcrumb-item">ADMINISTRADOR</li>
				<li class="breadcrumb-item active"><a href="../CerrarSesion">Cerrar Sesi�n</a></li>		
			</ol>
		</div>

		<div class="row col-md-8 col-md-offset-2">
			<table class="table table-striped">
				<thead>
						
					<tr>
						<th>T�tulo</th>
						<th>Autor</th>
						<th>ISBN</th>
						<th>Portada</th>
						<th>Precio</th>
						<th></th>
					</tr>
				</thead>
				<%
					for (Libros l : libros) {
				%>
				<tr>
					<td><%=l.getTitulo()%></td>
					<td><%=l.getAutor()%></td>
					<td><%=l.getIsbn()%></td>
					<td><img alt="Portada"
						src="image.jsp?imag=<%=l.getidLibros()%>" class="img-thumbnail"
						width="50" height="50"></td>
					<td><%=l.getPrecio()%></td>
						 <!-- Button trigger modal -->
						<button type="button" class="btn btn-warning" data-toggle="modal"
							data-target="#borrarLibro<%=l.getidLibros()%>">
							<i class="fa fa-times" aria-hidden="true"></i> Borrar
						</button>
						<button type="button" class="btn" data-toggle="modal"
							data-target="#editarLibro<%=l.getidLibros()%>">
							<i class="fa fa-times" aria-hidden="true"></i> Borrar
						</button> <!-- Modal -->
						<div class="modal fade" id="borrarLibro<%=l.getidLibros()%>"
							tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
							aria-hidden="true">
							<div class="modal-dialog" role="document">
								<div class="modal-content">
									<div class="modal-header">
										<h5 class="modal-title" id="exampleModalLabel">Borrar
											Libro</h5>
										<button type="button" class="close" data-dismiss="modal"
											aria-label="Close">
											<span aria-hidden="true">&times;</span>
										</button>
									</div>
								</div>
							</div>
						</div>

					</td>
				</tr>
				<%
					}
				%>
			</table>
		</div>


		<%
			}
		%>



	</div>


	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="../js/jquery-3.2.1.slim.min.js"></script>
	<script src="../js/popper.min.js"></script>
	<script src="../js/bootstrap.min.js"></script>
</body>
</html>
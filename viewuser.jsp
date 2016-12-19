<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">


	<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.11.0/bootstrap-table.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@page import="com.infosyst.dao.UserDao,com.infosyst.bean.*,java.util.*" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h1>User List</h1>
<%
List<User>list=UserDao.getAllRecords();
request.setAttribute("list",list);
%>

<table class="table table-striped table-inverse"
		data-search="true"
    	data-show-refresh="true"
    	data-show-columns="true"
    	data-show-export="true">
<tr> 	
<th>id</th>
<th>Name</th>
<th>Apellido Paterno</th>
<th>Apellido Materno</th>
<th>Email</th>
<th>Edad</th>
<th>Ingreso Mensual</th>
<th>Fecha de Ingreso</th>
<th>Edit</th>
<th>Delete</th>

</tr>

<c:forEach items="${list}" var="u">

<tr><td>${u.getId()}</td><td>${u.getName()}</td><td>${u.getAp()}</td>
<td>${u.getAm()}</td><td>${u.getEmail()}</td><td>${u.getEdad()}</td>
<td>${u.getIngresosMens()}</td><td>${u.getFechaIng()}</td>
<td><a href="editform.jsp?id=${u.getId()}">Editar</a></td>
<td><a href="deleteuser.jsp?id=${u.getId()}">Borrar</a></td></tr>

</c:forEach>

</table>
<br/><a href="adduserform.jsp">Agregar Usuario</a>

</body>
<script 
src="https://code.jquery.com/jquery-3.1.1.min.js"
  integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="
  crossorigin="anonymous"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
  
  <script src="//cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.11.0/bootstrap-table.min.js"></script>

</html>
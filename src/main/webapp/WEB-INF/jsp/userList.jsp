<%@page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
<h2>add page</h2>
<form action="/spring-demo/addUser" method="post">
	<input type="text" name="id" placeholder="id"/>
	<input type="text" name="username" placeholder="username"/>
	<input type="password" name="pwd" placeholder="password"/>
	<input type="submit" value="submit"/>
</form>

<table>
<thead>
	<th>id</th>
	<th>username</th>
	<th>pwd</th>
</thead>
<tbody>
	<!-- 如果集合中不为空，输出数据！ -->
	<c:if test="${!empty userlist}">
	    <c:forEach items="${userlist}" var="list">
	        <tr>
	              <td>${list.id}</td>
	              <td>${list.username}</td>
	           	  <td>${list.pwd}</td>
	        </tr>
	   </c:forEach>
	 </c:if>
	 
	<!-- 如果集合中为空，直接在HTML中输出提示！ -->
	 <c:if test="${empty userlist}">
	    no datas
	 </c:if>
</tbody>
	
</table>

</body>
</html>
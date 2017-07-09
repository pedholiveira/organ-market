<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<c:import url="header.jsp" />
<%@ page isELIgnored="false" %>

<body>
	<div class="container">
	    <div class="center-block">
	        <div class="row">
	            <h1>Organ Market <small>homework</small></h1>
	        </div>
	        
	        <div class="row">
	        	<ul class="nav nav-tabs nav-justified">
	            	<li role="presentation">
	                	<a href="create">
	                    	<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
	                    	Create
	                	</a>
	                </li>
	                
	                <li role="presentation" class="active">
	                	<a href="read">
	                   		<span class="glyphicon glyphicon-search" aria-hidden="true"></span>
	                    	Read
	                    </a>
	                </li>
	                
	                <li role="presentation">
	                	<a href="filter">
	                    	<span class="glyphicon glyphicon-filter" aria-hidden="true"></span>
	                    	Filter
	                    </a>
	                </li>
	                
	                <li role="presentation" class="disabled">
	                	<a href="update">
	                    	<span class="glyphicon glyphicon-edit" aria-hidden="true"></span>
	                    	Update
	                    </a>
	                </li>
	                
	                <li role="presentation" class="disabled">
	                	<a href="delete">
	                    	<span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
	                    	Delete
	                    </a>
	                </li>
	            </ul>
	        </div>
	        
	        <div>
	            <!-- Table -->
	            <table class="table">
	             	<tr>
	                	<td>ID</td>
	                    <td>Organ</td>
	                    <td>Price</td>
	                    <td>Donator</td>
	                    <td>
	                    	<a class="btn btn-link" href="create">
	                        	<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
	                            New Organ
	                        </a>
	                    </td>
	                </tr>
	                
	                <c:forEach var="organ" items="${organs}">
		                <tr>
		                    <td><c:out value="${organ.id}"/></td>
		                    <td><c:out value="${organ.organ}"/></td>
		                    <td><c:out value="${organ.price}"/></td>
		                    <td><c:out value="${organ.donator}"/></td>
		                    <td>
		                        <a class="btn btn-link" href=<c:out value="update?id=${organ.id}"/>>
		                            <span class="glyphicon glyphicon-edit" aria-hidden="true"></span>
		                            Edit
		                        </a>
		                        
		                        <a class="btn btn-link" href=<c:out value="delete?id=${organ.id}"/>>
		                            <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
		                            Delete
		                        </a>
		                    </td>
		                </tr>
	                </c:forEach>
	        	</table>
	        </div>
		</div>
	</div>

<c:import url="footer.jsp" />
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
		            
	                <li role="presentation">
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
	                
	                <li role="presentation" class="active">
	                	<a href="delete">
	                    	<span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
	                    	Delete
	                    </a>
	                </li>
	            </ul>
	        </div>
	        
	        <div>
	            <form action="delete" method="POST">
	        		<input type="hidden" class="form-control" name="id" value="${organ.id}">
	        		<div class="form-group">
			            <table class="table">
			            	<tr>
			                	<td>ID</td>
			                    <td>Organ</td>
			                    <td>Price</td>
			                    <td>Donator</td>
			                    <td>Delete?</td>
			                </tr>
			                
			                <tr>
			                	<td><c:out value="${organ.id}"/></td>
			                    <td><c:out value="${organ.organ}"/></td>
			                    <td><c:out value="${organ.price}"/></td>
			                    <td><c:out value="${organ.donator}"/></td>
			                    <td>
			                        <button type="submit" class="btn btn-link">
						              	<span class="glyphicon glyphicon-ok" aria-hidden="true"></span>
						              	Yes
						            </button>
			                        
			                        <a class="btn btn-link" href="read">
			                            <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
			                            No
			                        </a>
			                    </td>
			           		</tr>
			        	</table>
		        	</div>
	        	</form>
	        </div>
	    </div>
	</div>
	   
<jsp:include page="footer.jsp" />
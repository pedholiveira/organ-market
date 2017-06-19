<jsp:include page="header.jsp" />

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
	                
	                <li role="presentation" class="active">
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
	                    </td>
	                </tr>
	                
	                <tr>
	                	<td><input class="form-control" id="id"></td>
                        <td><input class="form-control" id="organ"></td>
                        <td><input class="form-control" id="price"></td>
                        <td><input class="form-control" id="donator"></td>
                        <td>
                            <a class="btn btn-link" href="/filter">
                                <span class="glyphicon glyphicon-filter" aria-hidden="true"></span>
                                Filter Search
                            </a>
                        </td>
                    </tr>
                    
	                <tr>
	                    <td>9780439708180</td>
	                    <td>Heart</td>
	                    <td>7000.48</td>
	                    <td>Harry Potter, male, 45 years</td>
	                    <td>
	                        <a class="btn btn-link" href="/update">
	                            <span class="glyphicon glyphicon-edit" aria-hidden="true"></span>
	                        </a>
	                        
	                        <a class="btn btn-link" href="/delete">
	                            <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
	                        </a>
	                    </td>
	                </tr>
				</table>
	        </div>
	    </div>
	</div>
   
<jsp:include page="footer.jsp" />
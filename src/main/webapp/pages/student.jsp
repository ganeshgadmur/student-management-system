

<%@ page language="java" 
    contentType="text/html; charset=UTF-8"%>
	
	<%@ taglib prefix="c" 
	    uri="jakarta.tags.core"%>
	
<html>

<head>
    <title>Student Management System</title>
    <style>
        body {
            font-family: Arial;
            margin: 20px;
            background-color: #f4f4f4;
        }
        h1 {
            color: #333;
            text-align: left;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            background: white;
        }
        th {
            background-color: #4CAF50;
            color: white;
            padding: 10px;
        }
        td {
            padding: 10px;
            border: 1px solid #ddd;
            text-align: center;
        }
		.header{
			display: flex;
			justify-content: space-between;
			align-items: center;
		}
        tr:hover {
            background-color: #f5f5f5;
        }
        input[type=text] {
            padding: 8px;
            width: 200px;
        }
        input[type=submit] {
            padding: 8px 15px;
            background: #4CAF50;
            color: white;
            border: none;
            cursor: pointer;
        }
     /*.logout {
            float: right;
            padding: 8px 15px;
            background: red;
            color: white;
            text-decoration: none;
            border-radius: 5px;
        }*/
        .message {
            color: green;
            font-weight: bold;
        }
    </style>
</head>	


<body>
	<div class = "header"">
	   <h1>Student Management System</h1>
						<form action="/logout" method="post">
						    <button style="background:red;
						        color:white;
						        border:none;
						        padding:8px 15px;
						        cursor:pointer;
						        border-radius:5px;
								">
						        Logout
						    </button>
						</form>
						</div>

	
    <h1>Add Student</h1>

    <form action="/saveStudent" method="post">
        Name : <input type="text" name="name"/>
		<span style ="color: red;">
			${nameError}
			</span>
			<br/><br/>
        Email: <input type="text" name="email"/>
		   <span style ="color : red;">
			${emailError}
			</span>
        <br/><br/>
        <input type="submit" value="Save"/>
    </form>

    <h3>${message}</h3>
	
	
	<!-- Edit Form — shows when student selected -->
						<c:if test="${student != null}">
						    <h2>Edit Student</h2>
						    <form action="/updateStudent" method="post">
						        <input type="hidden" 
						            name="id" value="${student.id}"/>
						        Name:
						        <input type="text" 
						            name="name" 
						            value="${student.name}"/>
						        <br/><br/>
						        Email:
						        <input type="text" 
						            name="email" 
						            value="${student.email}"/>
						        <br/><br/>
						        <input type="submit" value="Update"/>
						    </form>
						</c:if>
	
	
	<!-- Display all students -->
	   <h2>All Students</h2>
	   
	   <table border="1">
	       <tr>
	           <th>ID</th>
	           <th>Name</th>
	           <th>Email</th>
			   <th>Action</th>
			   
	       </tr>
		   
	       <c:forEach items="${students}" var="s">
			
	       <tr>
	           <td>${s.id}</td>
	           <td>${s.name}</td>
	           <td>${s.email}</td>
			   <td>
			           <!-- Edit Button -->
			           <a href="/editStudent?sid=${s.id}">
			               <button style="background:blue;
			                   color:white;
			                   border:none;
			                   padding:5px 10px;
			                   cursor:pointer;">
			                   Edit
			               </button>
			             </a>
			           <!-- Delete Button -->
			           <a href="/deleteStudent?sid=${s.id}">
			               <button style="background:red;
			                   color:white;
			                   border:none;
			                   padding:5px 10px;
			                   cursor:pointer;">
			                   Delete
			               </button>
					</a>
					</td>
	       </tr>
		   
	       </c:forEach>
	   </table>
	   
	   <!--Add Search by Id Form-->
	   	<h2>Search Student by Id</h2>
	   	<form action ="/findStudent" method="get">
	   		
	   		Enter ID:
	   		<input type = "text" name="sid">
	   		<input type ="submit" value="Search">
	   		</form>
	   		
	   		<h3>${student}</h3>
			
			<c:if test ="${student != null}">
				<table broder ="1">
					<tr>
						<th>ID</th>
						<th>Name</th>
						 <th>Email</th>
						 </tr>
						 
						 <tr>
							<td>${student.id}</td>
							<td>${student.name}</td>
							<td>${student.email}</td>
					
								  <td>
								      <a href="/editStudent?sid=${student.id}">
								          <button style="background:blue;
								              color:white;
								              border:none;
								              padding:5px 10px;
								              cursor:pointer;">
								              Edit
								          </button>
								      </a>
								      <a href="/deleteStudent?sid=${student.id}">
								          <button style="background:red;
								              color:white;
								              border:none;
								              padding:5px 10px;
								              cursor:pointer;">
								              Delete
								          </button>
								      </a>
								  </td>				
	                          </tr>
				      	</table>
					</c:if>
					
					
					
					
			
					
					<h2> Search by Name</h2>
					
					<form  action ="/findByName"  method="get">
						Enter Name:
						<input type="text" name="sname"/>
						<input type ="submit" value ="Search/">
						</form>

</body>
</html>

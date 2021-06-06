<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>See Users</title>

<link href='http://fonts.googleapis.com/css?family=Oxygen' rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="./css/dashboard.css">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type = "application/javascript" src = "./js/fetchUsers.js"></script>
</head>
<body class="container">
<h4>Please Click below to get User Details!!</h4>
<input type="button" value="Show Users" id="showTable"/>
<br/>
<br/>
<input type="button" value="Click to get back!!" onclick = "history.back()">
<br/>
<br/>
<div id="tablediv">
<table cellspacing="0" id="userTable"> 
    <tr> 
        
        <th scope="col">Username</th> 
        <th scope="col">Password</th>
        
        
                
    </tr> 
</table>
</div>
</body>
</html>
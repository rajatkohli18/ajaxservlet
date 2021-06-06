<html>
<head>
<link rel="stylesheet" href ="style.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>


<body>

	<h1>LOG INTO YOUR AVIS ACCOUNT</h1>
	
	<form action="LoginServlet" method ="post">
		

		<div class="container">
			<label><b>Username</b></label><br/>
			<input type="text" placeholder="Username/Wizard Number" id="username" name="uname" required><br/><br/>

			<label><b>Password</b></label><br/>
			<input type="password" placeholder="Password(case sensitive)" id="password" name="psw" required><br/><br/>
			<input type="checkbox" checked="checked"> Remember me<br/>
			
	
	<div id="data"></div>
			<button onclick="logindata()" type="submit">LOG IN </button><br/>
			
		</div>

		<div class="container" style="background-color:#f1f1f1">
			
			<span class="psww">Forgot <a href="#">username?</a></span>
			<span class="psw">Forgot <a href="#">password?</a></span>
		</div>
	</form>
	<script src="ajax.js"></script>

</body>

</html>

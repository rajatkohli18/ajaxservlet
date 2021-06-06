function authenticate()
{
	var dataFile = 'authenticate?username='+document.getElementById("username").value+'&password='+document.getElementById("password").value;
	var httpRequest = new XMLHttpRequest();
	httpRequest.onreadystatechange = function() {
		if(httpRequest.readyState == 4)
		{
			if(httpRequest.status===200)
			{
				window.alert("VALID USER!!!")
				window.location = "http://localhost:8084/WebAvis/dashboard.jsp";
			}
			
			else if(httpRequest.status===401)
			window.alert("INVALID USER!!")
			

		}
	}
	httpRequest.open("POST",dataFile,true);
	httpRequest.send();
}
<html>
	<body>
		<h1>Result</h1>

		<% 
			Boolean accessGranted = (Boolean)request.getAttribute("accessGranted");
			out.print("<br> "+(accessGranted?"Welcome!":"Access is denied"));
		 %>

	</body>

</html>
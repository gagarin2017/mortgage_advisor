<!DOCTYPE html>
<html lang="en">
  <head>
  	<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

    <title>Mortgage Adviser - Results</title>

    <!-- Bootstrap core CSS -->

	<c:set var = "bootstrap_path" scope = "session" value = "webjars/bootstrap/3.3.7-1"/>
	<c:set var = "jquery_path" scope = "session" value = "webjars/jquery/3.2.1"/>

    <link rel='stylesheet' href='${bootstrap_path}/css/bootstrap.min.css'>

    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <link href="http://getbootstrap.com/assets/css/ie10-viewport-bug-workaround.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/btrp_cover.css" rel="stylesheet">
    <link href="http://getbootstrap.com/examples/starter-template/starter-template.css" rel="stylesheet">

    <link href="https://cdn.datatables.net/1.10.13/css/jquery.dataTables.min.css" rel="stylesheet">
    <link href="css/best_rate_provider.css" rel="stylesheet">
   
  </head>

  <body>

    <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">Mortgage Adviser (boi-branch)</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
          <ul class="nav navbar-nav">
            <li class="active"><a href="#">Home</a></li>
            <li><a href="#about">About</a></li>
            <li><a href="#contact">Contact</a></li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>

	<div class="container-fluid" style="margin-left: 10px; margin-right: 10 px;">

		<div class="starter-template">

			<div class="row">

				<div class="col-lg-10 col-md-10 col-sm-3 col-xs-10">
					<p>Best Bank Of Ireland Rates (BOI Branch)</p>
					
				</div>
				<div class="col-lg-2 col-md-2 col-sm-3 col-xs-2" style="padding: 0px">
					
				</div>
			</div>



		</div>

	</div>
	<!-- /.container -->
    
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
	<script type="text/javascript" src="${jquery_path}/jquery.min.js"></script>
	<script type="text/javascript" src="${bootstrap_path}/js/bootstrap.min.js"></script>
    <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="http://getbootstrap.com/assets/js/ie10-viewport-bug-workaround.js"></script>
    <script src="https://cdn.datatables.net/1.10.13/js/jquery.dataTables.min.js"></script>
    <script src="js/boi.js"></script>
    </script>
  </body>
</html>

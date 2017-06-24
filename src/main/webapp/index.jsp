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
    <link rel="icon" href="view-source:http://getbootstrap.com/favicon.ico">

    <title>Mortgage Options Provider</title>

    <!-- Bootstrap core CSS -->
	<c:set var = "bootstrap_path" scope = "session" value = "webjars/bootstrap/3.3.7-1"/>
	<c:set var = "jquery_path" scope = "session" value = "js/jQuery/jquery-3.2.1.min.js"/>
	
    <link rel='stylesheet' href='${bootstrap_path}/css/bootstrap.min.css'>

    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <link href="css/bootstrap/ie10-viewport-bug-workaround.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/bootstrap/cover.css" rel="stylesheet">
  </head>

  <body>

    <div class="site-wrapper">

      <div class="site-wrapper-inner">

        <div class="cover-container">

          <div class="masthead clearfix">
            <div class="inner">
              <h3 class="masthead-brand">Mortgage Options Provider</h3>
              <nav>
                <ul class="nav masthead-nav">
                  <li class="active"><a href="#">Home</a></li>
                  <li><a href="#">Rates</a></li>
                  <li><a href="#">Contact</a></li>
                </ul>
              </nav>
            </div>
          </div>

          <div class="inner cover">
            <h1 class="cover-heading">Analyze your Mortgage Options.</h1>
            <p class="lead">Here you can check your mortgage options. Check the available rates. See the schedule.</p>
            <p class="lead">
              <a href="analyze.do" class="btn btn-lg btn-default">Analyze</a>
            </p>
          </div>

          <div class="mastfoot">
            <div class="inner">
              <p>No responsibilities for false data. Created by #Yury</p>
            </div>
          </div>

        </div>

      </div>

    </div>

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
	<script type="text/javascript" src="${jquery_path}"></script>
	<script type="text/javascript" src="${bootstrap_path}/js/bootstrap.min.js"></script>
    <script>window.jQuery || document.write('<script src="js/jQuery/jquery-3.2.1.min.js"><\/script>')</script>
	<!--     IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="js/bootstrap/assets/ie10-viewport-bug-workaround.js"></script>
  </body>
</html>

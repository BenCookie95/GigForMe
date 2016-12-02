<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Gigs</title>

    <!-- Bootstrap Core CSS -->
    <link rel="stylesheet" type="text/css" href="slick/slick.css"/>
    <link rel="stylesheet" type="text/css" href="slick/slick-theme.css"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
    <link href="css/mediaQueries.css" rel="stylesheet">
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.6.4/jquery.min.js"></script>
    <script type="text/javascript" src="js/site.js"></script>

    <!-- Custom CSS -->
    

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>
<body id="user-login">
    
    <!--Including the menu -->
    <jsp:include page="normalMenu.jsp" />
        <div id="login">
            <% System.setProperty("java.awt.headless", "false");%>
            <h2>Band Login</h2>
            <form action="${pageContext.request.contextPath}/BandLogin" role="form" method="post">
                  
            <label>UserName :</label>
            <input id="name" name="username" placeholder="username" type="text">
            <label>Password :</label>
            <input id="password" name="password" placeholder="**********" type="password">
            <label><input name="rememberMe" type="checkbox" id="rememberMe" value="rememberMe">Remember Me?</label><br />
            
            <span id="mistake">${error}</span>
            <input name="submit" type="submit" value=" Login ">
            
            </form>
        </div>

    
    <footer class="footerContainer">
        <div class="container">
            <p>&copy; GigForMe 2015</p>

        </div>
    </footer>
</body>

</html>

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


</head>
<body id="user-login">
    
    <!-- Navigation -->
    <header>
        <a href="index.jsp">
            <img src="img/logo.png" alt="logo">
        </a>
    </header>
    
        <div class="container">
            <h1>Register</h1>
            <form onsubmit="return validateRegistration()" action="${pageContext.request.contextPath}/Register" method="post">
            <label>First Name : </label>
            <input id="fname" name="fname" placeholder="first name" type="text" onclick="return colourChange(fname)" maxlength="25">
            <label>Last Name :</label>
            <input id="lname" name="lname" placeholder="last name" type="text" onclick="return colourChange(lname)" maxlength="25" >
            <label>Email :<span id="user-result1"><img src="" /><p></p></span></label>
            <input id="userEmail" name="userEmail" placeholder="Email Address" type="email" onclick="return colourChange(userEmail)" maxlength="60">
            <label>UserName :<span id="username-result"><img src="" /><p></p></span></label>
            <input id="regusername" name="regusername" placeholder="username" type="text" onclick="return colourChange(regusername)" maxlength="25">
            <label>Password :</label>
            <input id="password" name="password" placeholder="**********" type="password" onclick="return colourChange(password)" maxlength="25">
            
            <span id="mistake"></span>
            <input name="submit" type="submit" class="btnRegister" value=" Register ">
            
            </form>
        </div>
     <script src="js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>
    <script type="text/javascript" src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
    <script type="text/javascript" src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
    <footer class="footerContainer" id="footer">
        <div class="container">
            <p>&copy; GigForMe 2015</p>

        </div>
    </footer>
</body>

</html>

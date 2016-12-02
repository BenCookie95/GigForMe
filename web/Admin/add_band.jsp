<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Gig For Me - Admin</title>

    <!-- Bootstrap Core CSS -->

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <link href="../css/style.css" rel="stylesheet">
    <link href="../css/mediaQueries.css" rel="stylesheet">
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.6.4/jquery.min.js"></script>
    <script type="text/javascript" src="../js/site.js"></script>
    
    <script type="text/javascript" src="../js/jQuery.textareaCounter.js"></script>

</head>
<body id="admin-add-band">
    
    
    <!-- Navigation -->
    <header>
        <a href="index.jsp">
            <img src="../img/logo.png" alt="logo">
        </a>
    </header>
    <!--Including the menu -->
    <jsp:include page="menu.jsp" />
        <div class="container">
            <h1>Register Band</h1>
            <form onsubmit="return validateBandRegistration()" action="${pageContext.request.contextPath}/Admin/AddBand" method="post">
            <label>Band Name : </label>
            <input id="fname" name="fname" placeholder="Band Name" type="text" onclick="return colourChange(fname)" maxlength="25">
            <label>Email :<span id="user-result"><img src="" /><p></p></span></label>
            <input id="bandemail" name="bandemail" placeholder="Email Address" type="email" onclick="return colourChange(bandemail)" maxlength="60">
            <label>UserName :<span id="username-result"><img src="" /><p></p></span></label>
            <input id="bandusername" name="bandusername" placeholder="username" type="text" onclick="return colourChange(bandusername)" maxlength="25">
            <label>Password :</label>
            <input id="password" name="password" placeholder="**********" type="password" onclick="return colourChange(password)" maxlength="25">
            <label>Confirm Password :<span id="user-result12"><img src="" /></span></label>
            <input id="password1" name="password1" placeholder="**********" type="password" onclick="return colourChange(password1)" maxlength="25">
            <span id="mistake">${error}</span>
            <input name="submit" id="update" type="submit" class="btnRegister" value=" Register ">
            
            </form>
        </div>
    
    <footer class="footerContainer" id="footer">
        <div class="container">
            <p>&copy; GigForMe 2015</p>

        </div>
    </footer>

        <script src="../js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="../js/bootstrap.min.js"></script>
    <script type="text/javascript" src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
    <script type="text/javascript" src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
</body>

</html>

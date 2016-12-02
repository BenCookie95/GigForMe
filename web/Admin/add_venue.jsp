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
<body id="admin-add-venue">
    
    
    <!-- Navigation -->
    <header>
        <a href="index.jsp">
            <img src="../img/logo.png" alt="logo">
        </a>
    </header>
    <!--Including the menu -->
    <jsp:include page="menu.jsp" />
        <div class="container">
            <h1>Register Venue</h1>
            <form onsubmit="return validateVenueRegistration()" action="${pageContext.request.contextPath}/Admin/AddVenueServlet" method="post">
            <label>Venue Name : </label>
            <input id="venuename" name="venuename" placeholder="Venue Name" type="text" onclick="return colourChange(venuename)" maxlength="25">
            <label>Capacity :</label>
            <input id="capacity" name="capacity" placeholder="Capacity" type="text" onclick="return colourChange(capacity)" maxlength="10">
            <label>Google Maps Latitude : <a href="http://lmgtfy.com/?q=find+latitude+and+longitude+on+google+maps" target="_blank">What's this?</a></label>
            <input id="latitude" name="latitude" placeholder="Latitude" type="text" onclick="return colourChange(latitude)" maxlength="25">
            <label>Google Maps Longitude :</label>
            <input id="longitude" name="longitude" placeholder="Longitude" type="text" onclick="return colourChange(longitude)" maxlength="25">
            <span id="mistake">${error}</span>
            <input name="submit" type="submit" class="btnRegister" value=" Register ">
            
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

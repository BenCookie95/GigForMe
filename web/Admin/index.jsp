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

</head>
<body>
    

    
    <!-- Navigation -->
    <header>
        <a href="index.jsp">
            <img src="../img/logo.png" alt="logo">
        </a>
    </header>
    <jsp:include page="menu.jsp" />
    
    <div class="container">
        <h1>Website Statistics ${message}</h1>
        <div class="numUsers">
            <a href="add_venue.jsp">
            <div class="leftSide">
                <img src="../img/profile.jpg" alt="">
            </div>
            <div class = "rightSide">
                <h2>Add Venue</h2>
            </div>
            </a>
        </div>
        <div class="numUsers">
            <a href="GigManagement">
                <div class="leftSide">
                    <img src="../img/u2.png" alt="">
                </div>
                <div class = "rightSide">
                    <h2>Manage Gigs</h2>
                    
                </div>
            </a>
        </div>
        <div class="numUsers">
            <a href="UserManagement">
            <div class="leftSide">
                <img src="../img/imaginedragons.jpe" alt="">
            </div>
            <div class = "rightSide">
                <h2>Edit Users</h2>
  
            </div>
            </a>
        </div>
        <div class="numUsers">
            <a href="add_band.jsp">
            <div class="leftSide">
                <img src="../img/profile.jpg" alt="">
            </div>
            <div class = "rightSide">
                <h2>Add Band</h2>

            </div>
            </a>
        </div>
        


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



<%@page import="GigForMe.Model.Band"%>
<%@page import="GigForMe.Model.User"%>
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
    <script type="text/javascript" src="js/jQuery.textareaCounter.js"></script>

    <!-- Custom CSS -->
    

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body id="edit_profile">
    
    
    
    <jsp:include page="normalMenu.jsp" />
    
    <!-- Page Content -->
    <div class="container">
        <%Band getBand = (Band) session.getAttribute("BAND");%>
        <h1>Edit Profile</h1>
        <form onsubmit="return validateEditBandProfile()" method="POST" enctype="multipart/form-data" action="${pageContext.request.contextPath}/UpdateBandProfile">
            <img src="<%= getBand.getPicDir()%>" class="editProfileImg" id ="editProfileImg" alt="">
            <div class="fileUpload btn btn-primary">
                <span>Upload</span>
                <input type="file" name="filePhoto" class="upload" id="filePhoto" onchange="ValidateSingleInput(this)"/>
            </div>
            
            <div class="bioCentre">
                
                <textarea class="textareaStyle" name="userpost" id="userpost" placeholder="Your Bio...."><%=getBand.getBio()%></textarea>
                <script type="text/javascript">
                $("textarea").textareaCounter();
                </script>
                <label><input type="checkbox" name="changePassword" id="changePassword" value="checkedPassword">Change Password</label><br />
                <label>Password :</label>
                <input id="password" name="password" placeholder="**********" type="password" onclick="return colourChange(password)" maxlength="25">
                <span id="mistake"></span>
                <input name="submit" type="submit" class="postSubmit" value=" Update ">
            </div>
        </form>
        
    </div>

    <footer class="footerContainer" id="footer">
        <div class="container">
            <p>&copy; GigForMe 2015</p>

        </div>
    </footer>
    

    
    <script src="js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>
    <script type="text/javascript" src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
    <script type="text/javascript" src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>

    
</body>

</html>


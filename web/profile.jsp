<%@page import="GigForMe.Model.Gig"%>
<%@page import="java.util.Vector"%>
<%@page import="GigForMe.Model.User"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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

<body id="profile">
    <jsp:include page="normalMenu.jsp" />
    <% User user = (User)session.getAttribute("USER"); %>
    <!-- Page Content -->
    <div class="container">
        
        <h1>${USER.getUsername()}'s Profile</h1>
        
        <div class="sideContent">
            <img src="${USER.getPicDir()}" alt="profile picture">
            <h3>${USER.getName()}</h3>
            <p>${USER.getBio()}</p>
        </div>
        <div class="content">
            <div class = "sort">
                <a class="editProfile" href="EditProfile">Edit Profile</a>
                <p>Showing gigs created by ${USER.getUsername()}</p>
            </div>
             <% Vector<Gig> getAllGigs = (Vector<Gig>) session.getAttribute("ALLUSERGIGS");%>
             
             <c:forEach items="${ALLUSERGIGS}" var="tempuser">
                 <div class="featuredBox">
                    <a href="ViewGig?g=${tempuser.getGigID()}" class="gigHover"><img src="${tempuser.getPicDir()}" alt=""></a>
                    <a href="ViewGig?g=${tempuser.getGigID()}" class="gigHover"><h3>${tempuser.getBandName()} </h3></a>
                    <h4 class="location">${tempuser.getVenueName()} <i class="fa fa-thumbs-up"> ${tempuser.getVotes()}</i></h4>
                    <h4 class="location">${tempuser.getGigDate()}</h4>
                    <c:if test="${tempuser.getIsConfirmed() eq 'YES'}"><h4 class="location">Gig Confirmed!</h4></c:if>
                </div>      
             </c:forEach>
            
           
        </div>

    </div>

    <footer class="footerContainer">
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

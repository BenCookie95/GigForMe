<%@page import="GigForMe.Model.User"%>
<%@page import="GigForMe.Model.Gig"%>
<%@page import="java.util.Vector"%>
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
    <script type="text/javascript" src="js/voteAjax.js"></script>
    <!-- Custom CSS -->
    

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body id="gigs">
    <jsp:include page="normalMenu.jsp" />
    
    <!-- Page Content -->
    <div class="container">
        
        <h1>Requested Gigs</h1>
        <div class = "sort">

            
            
        </div>
        <div class="sideMenu">
            <div class="navToggle"><h2>Show Navigation <i class="fa fa-plus-circle"></i></h2> </div>
            <h3>In this Section</h3>
            <ul class="sideMenuList">
                
                <a href="Gigs"><li class="sideList current">Proposed Gigs</li></a>
                <a href="ConfirmedGigs"><li class="sideList">Confirmed Gigs</li></a>
                <a href="CreateGig"><li class="sideList">Create Gig</li></a>
            </ul>

        </div>
        <div class="content">
            <% Vector<Gig> getAllGigs = (Vector<Gig>) session.getAttribute("ALLGIGS");%>
            <% User theuser = (User)session.getAttribute("USER"); %>
            <c:forEach items="${ALLGIGS}" var="tempuser">
                <div class="featuredBox">
                    <a href="ViewGig?g=${tempuser.getGigID()}" class="gigHover"><img src="${tempuser.getPicDir()}" alt="U2"></a>
                    <a href="ViewGig?g=${tempuser.getGigID()}" class="gigHover"><h3>${tempuser.getBandName()}</h3></a>
                        <c:choose>
                            <c:when test="${tempuser.getVoteCheck() eq 'NO'}">
                                
                                <h4 class="location">${tempuser.getVenueName()} <i class="fa fa-thumbs-up" id="voting${tempuser.getGigID()}"> ${tempuser.getVotes()}</i><form class = "voter${tempuser.getGigID()}" action="" id = "" method="POST"><input type="hidden" id="vote" name ="vote" class="vote"value="${tempuser.getGigID()}"><input type="button" id = "voteButton" class="voteButton" name="voteButton" value="vote"></form></h4>

                            </c:when>
                            <c:when test="${USER.getUsername() eq null}">
                                
                                <h4 class="location">${tempuser.getVenueName()} <i class="fa fa-thumbs-up"> ${tempuser.getVotes()}</i></h4>
                                
                            </c:when>
                            <c:otherwise>
                                <h4 class="location">${tempuser.getVenueName()} <i class="fa fa-thumbs-up"> ${tempuser.getVotes()}</i></h4>
                                
                            </c:otherwise>  
                        </c:choose>
                        
                        
                    
                    
                    <h4 class="location">${tempuser.getGigDate()}</h4>
                </div>
            </c:forEach>


        </div>

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

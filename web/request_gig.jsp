<%@page import="GigForMe.Model.Venue"%>
<%@page import="java.util.Vector"%>
<%@page import="GigForMe.Model.Band"%>
<%@page import="GigForMe.Model.Gig"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<body id="user-login">
    
    <jsp:include page="normalMenu.jsp" />
    <%Vector<Band> getBands = (Vector<Band>) session.getAttribute("SKALLBANDS");%>
    <% Vector<Venue> getVenues = (Vector<Venue>) session.getAttribute("SKALLVENUES");%>
        <div class="container">
            <h1>Create a Gig</h1>
            <div class="sideMenu">
                <div class="navToggle"><h2>Show Navigation <i class="fa fa-plus-circle"></i></h2> </div>
                <h3>In this Section</h3>
                <ul class="sideMenuList">
                
                    <a href="Gigs"><li class="sideList">Proposed Gigs</li></a>
                    <a href="ConfirmedGigs"><li class="sideList">Confirmed Gigs</li></a>
                    <a href="CreateGig"><li class="sideList current">Create Gig</li></a>
                </ul>

            </div>
            <div class="content">
                
                <form onsubmit="return validateSubmission()" action="${pageContext.request.contextPath}/AddGig" method="post">
                <label>Band : </label>
                <select id = "band" name ="band" onclick="return colourChange(band)">
                    <option value="" disabled selected>Choose a band</option>
                    <c:forEach items="${SKALLBANDS}" var="tempuser">
                        <option value="${tempuser.getBandID()}">${tempuser.getBandName()}</option>                    
                    </c:forEach>
                </select>
                <label>Gig Description :</label>
                <textarea class="gigDescTxt" name="description" onclick="return colourChange(description)" id="description" placeholder="Why do you want this Gig?"></textarea>
                <script type="text/javascript">
                $("textarea").textareaCounter();
                </script>
                <label>Venue :</label>
                <select id="venue" name = "venue" onclick="return colourChange(venue)">
                    <option value="" disabled selected>Choose a venue</option>
                    <c:forEach items="${SKALLVENUES}" var="tempuser">
                        <option value="${tempuser.getVenueID()}">${tempuser.getVenueName()}</option>                    
                    </c:forEach>
                </select>
                <label>Suggested Price (In Euros) :</label>
                <input id="price" name="price" placeholder="Price" type="text" onclick="return colourChange(price)" maxlength="25">
                <label>Suggested Date :</label>
                <input type="date" name="gigDate" id ="gigDate" onclick="return colourChange(gigDate)" placeholder="Date">
                <span id="mistake">${error}</span>
                <input name="submit" type="submit" class="btnRegister"value=" Submit ">
                
                </form>
            </div>
        </div>
            
    <footer class="footerContainer" id="footer">
        <div class="container">
            <p>&copy; GigForMe 2015</p>

        </div>
    </footer>

    <!-- jQuery Version 1.11.1 -->
    <script src="js/jquery.js"></script>
    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>
    <script type="text/javascript" src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
    <script type="text/javascript" src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
</body>

</html>

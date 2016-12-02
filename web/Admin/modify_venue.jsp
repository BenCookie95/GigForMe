<%@page import="GigForMe.Model.Venue"%>
<%@page import="java.util.Vector"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
    <script type="text/javascript" src="../js/venueAjax.js"></script>
</head>

<body id="admin-venues">
    
    
    
    
    <header>
        <a href="index.jsp">
            <img src="../img/logo.png" alt="logo">
        </a>
    </header>
    <!--Including the menu -->
    <jsp:include page="menu.jsp" />
    <div class="container">
        <h1>Modify Venues</h1>
         <c:choose>
            <c:when test="${message=='yes'}">
                <div id="popup1" class="overlay">
                    <div class="popup">
                        <h2>Success</h2>
                        <a class="close" href="#popup1">&times;</a>
                        <div class="content1">
                            The new Venue has been added.
                        </div>
                    </div>
                </div>
            </c:when>    
            <c:otherwise>
                
            </c:otherwise>
        </c:choose>
        <c:remove var="message" scope="session" />
        <div class = "sort">
            <a href="add_venue.jsp" class = "editProfile">Add Venue</a>
            

        </div>
        
        
        
       
        
        <% Vector<Venue> getAllVenues = (Vector<Venue>) session.getAttribute("SKALLVENUES");%>
        
        <c:forEach items="${SKALLVENUES}" var="tempuser">
        <div class="removeRow${tempuser.venueID}">
            <div class = "row">
                <div class="rowLeft">

                    <h2>${tempuser.venueName}</h2>
                    <h4>Venue ID: ${tempuser.venueID}</h4>
                    <h4>${tempuser.capacity} capacity</h4>
                </div>
                <div class="rowRight">
                    <form class="deleteVenue${tempuser.venueID}">
                        <input type="hidden" name="delete" value="${tempuser.venueID}" class="delete">
                        <input name="deleteButton" class="deleteButton" type="button" value=" Remove Venue ">
                    </form>

                </div>


            </div>
        </div>
            
            
        </c:forEach>
        
        


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

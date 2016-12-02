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

    <title>Gig For Me - Admin</title>

    <!-- Bootstrap Core CSS -->

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <link href="../css/style.css" rel="stylesheet">
    <link href="../css/mediaQueries.css" rel="stylesheet">
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.6.4/jquery.min.js"></script>
    <script type="text/javascript" src="../js/site.js"></script>
    <script type="text/javascript" src="../js/gigAjax.js"></script>
</head>

<body id="admin-gigs">
    
    
    
    
    <header>
        <a href="index.jsp">
            <img src="../img/logo.png" alt="logo">
        </a>
    </header>
    <!--Including the menu -->
    <jsp:include page="menu.jsp" />
    <div class="container">
        <h1>Modify Gigs</h1>
        
        <% Vector<Gig> getAllGigs = (Vector<Gig>) session.getAttribute("SKALLGIGS");%>
        
        
        <c:forEach items="${SKALLGIGS}" var="tempuser">
        <div class="removeRow${tempuser.getGigID()}">
            <div class = "row">
                <div class="rowLeft">
                    <img src="../${tempuser.getPicDir()}" alt="profile picture">
                    <h2>${tempuser.getBandName()}</h2>
                    <h4>Venue: ${tempuser.getVenueName()}</h4>
                    <h4>Date: ${tempuser.getGigDate()}</h4>
                </div>
                <div class="rowRight">
                    <form class="deleteGig${tempuser.getGigID()}">
                        <input type="hidden" name="delete" value="${tempuser.getGigID()}" class="delete">
                        <input name="deleteButton" class="deleteButton" type="button" value=" Remove Gig ">
                    </form>
                    <a href="EditGig?g=${tempuser.getGigID()}" class="editUser">Edit Gig</a>
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

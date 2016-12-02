<%@page import="GigForMe.Model.Band"%>
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
    <script type="text/javascript" src="../js/bandAjax.js"></script>
</head>

<body id="admin-bands">
    
    
    
    
    <header>
        <a href="index.jsp">
            <img src="../img/logo.png" alt="logo">
        </a>
    </header>
    <!--Including the menu -->
    <jsp:include page="menu.jsp" />
    <div class="container">
        <h1>Modify Bands</h1>
        <c:choose>
            <c:when test="${message=='yes'}">
                <div id="popup1" class="overlay">
                    <div class="popup">
                        <h2>Success</h2>
                        <a class="close" href="#popup1">&times;</a>
                        <div class="content1">
                            The new Band has been added.
                        </div>
                    </div>
                </div>
            </c:when>    
            <c:otherwise>
                
            </c:otherwise>
        </c:choose>
        <c:remove var="message" scope="session" />
        <div class = "sort">
            <a href="add_band.jsp" class = "editProfile">Add Band</a>
            <form class="search" method="post" action="" >
                            
                <input type="text" name="bandInputSearch" id="bandInputSearch" placeholder="Search..." autocomplete="off" />
                <ul class="search-ac" id="band-result">
                    
                 </ul>
                 <input type="submit" name="search" id="search" Style="display:none;">
             </form>
        </div>
        
        <!--loop here-->
        
        <% Vector<Band> getAllBands = (Vector<Band>) session.getAttribute("SKALLBANDS");%>
        
        <c:forEach items="${SKALLBANDS}" var="tempuser">
            <div class="removeRow${tempuser.getBandID()}">
                <div class = "row" id="${tempuser.bandID}">
                    <div class="rowLeft">
                        <img src="../${tempuser.picDir}" alt="profile picture">
                        <h2>${tempuser.bandName}</h2>
                        <h4>Band ID: ${tempuser.bandID}</h4>
                        <h4>${tempuser.bio}</h4>
                    </div>       
                    <div class="rowRight">
                        <form class="deleteBand${tempuser.getBandID()}">
                            <input type="hidden" name="delete" value="${tempuser.getBandID()}" class="delete">
                            <input name="deleteButton" class="deleteButton" type="button" value=" Remove Band ">
                        </form>
                        <a href="EditBandProfile?u=${tempuser.bandID}" class="editUser">Edit Profile</a>
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

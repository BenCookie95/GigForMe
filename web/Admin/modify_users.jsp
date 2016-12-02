<%@page import="GigForMe.Model.User"%>
<%@page import="java.util.Vector"%>
<%@ page import="java.util.Date"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
    
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <META HTTP-EQUIV="CACHE-CONTROL" CONTENT="NO-CACHE">
    <meta http-equiv="pragma" content="no-cache" />
    <title>Gig For Me - Admin</title>

    <!-- Bootstrap Core CSS -->

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <link href="../css/style.css" rel="stylesheet">
    <link href="../css/mediaQueries.css" rel="stylesheet">
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.6.4/jquery.min.js"></script>
    <script type="text/javascript" src="../js/site.js"></script>
    <script type="text/javascript" src="../js/UserAjax.js"></script>
</head>

<body id="admin-users">
    
    <header>
        <a href="index.jsp">
            <img src="../img/logo.png" alt="logo">
        </a>
    </header>
    <!--Including the menu -->
    <jsp:include page="menu.jsp" />
    <div class="container">
        <h1>Modify Users</h1>
        <div class = "sort">
            
            <form class="search" method="post" action="" >
                            
                <input type="text" name="inputSearch" id="inputSearch" placeholder="Search Username" autocomplete="off" />
                <ul class="search-ac" id="user-result">
                    
                 </ul>
                 <input type="submit" name="search" id="search" Style="display:none;">
             </form>
             
        </div>
        <% Vector<User> getAllUsers = (Vector<User>) session.getAttribute("SKALLUSERS");%>
        <jsp:useBean id="current" class="java.util.Date" />
        <c:forEach items="${SKALLUSERS}" var="tempuser">
            <div class="removeRow${tempuser.userID}">
            <div class = "row" id="${tempuser.userID}">
            <div class="rowLeft">
                <img src="../${tempuser.picDir}?id=${current.time}" alt="profile picture">
                <h2>${tempuser.username}</h2>
                <h4>User ID: <c:out value="${tempuser.getUserID()}"></c:out></h4>
                <h4>${tempuser.email}</h4>
            </div>
            <div class="rowRight">
               
                <c:if test="${tempuser.username ne Admin.getUsername()}">
                    <form class="deleteGig${tempuser.userID}">
                        <input type="hidden" name="delete" value="${tempuser.userID}" class="delete">
                        <input name="deleteButton" class="deleteButton" type="button" value=" Remove User ">
                    </form>  
                </c:if>
                <div class = "banForm">
                    <c:choose>
                    <c:when test="${tempuser.getIsBanned() == 'YES'}">
                        <form id = "unbanUser${tempuser.userID}">
                            <input type="hidden" name="ban" value="${tempuser.userID}" id="unban${tempuser.userID}">
                            <input name="unbanButton${tempuser.userID}" type="button" id ="unbanButton${tempuser.userID}" value=" UnBan User ">
                        </form>
                    </c:when>
                    <c:otherwise>
                        <c:if test="${tempuser.getIsAdmin() ne 'YES'}">
                            <form id = "banUser${tempuser.userID}">
                                <input type="hidden" name="ban" value="${tempuser.userID}" id="ban${tempuser.userID}">
                                <input name="banButton${tempuser.userID}" type="button" id ="banButton${tempuser.userID}" value=" Ban User ">
                            </form>
                        </c:if>
                    </c:otherwise>
                </c:choose>
                    
                    
                </div>
                
                
                <a href="EditProfile?u=${tempuser.userID}" class="editUser">Edit Profile</a>
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

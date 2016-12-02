<%@page import="GigForMe.Model.Band"%>
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
    
    <script type="text/javascript" src="../js/jQuery.textareaCounter.js"></script>

</head>

<body id="admin-edit-user">
    
    
    
    
    <header>
        <a href="index.jsp">
            <img src="../img/logo.png" alt="logo">
        </a>
    </header>
    <!--Including the menu -->
    <jsp:include page="menu.jsp" />
    <%Band getBand = (Band) session.getAttribute("SKBAND");%>
    <div class="container">
        <h1>Edit <%=getBand.getUsername()%>'s Profile</h1>
        <form onsubmit="return validateBandProfileUpdate()" action="${pageContext.request.contextPath}/Admin/UpdateBand" method="post">
            <input id="bandid" name="bandid" value = "<%=getBand.getBandID()%>" type="hidden">
            <label>BIO :</label>
            <div class="bioCentre">
            
            <textarea class="textareaStyle" name="userpost" id="userpost" placeholder="Your Bio...."><%=getBand.getBio()%></textarea>
                <script type="text/javascript">
                $("textarea").textareaCounter();
                </script>
            </div>
            <label><input type="checkbox" name="changePassword" id="changePassword" value="Bike">Change Password?</label><br />
            <label>Password :</label>
            <input id="password" name="password" placeholder="**********" type="password" onclick="return colourChange(password)" maxlength="25">
            <div class="bioCentre"><span id="mistake">${error}</span></div>
            <input name="submit" type="submit" class="postSubmit" value=" Update ">
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

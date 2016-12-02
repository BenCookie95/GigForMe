<%@page import="GigForMe.Model.User"%>
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
    
    <%User getUser = (User) session.getAttribute("SKUSER");%>
    
    
    <header>
        <a href="index.jsp">
            <img src="../img/logo.png" alt="logo">
        </a>
    </header>
    <!--Including the menu -->
    <jsp:include page="menu.jsp" />
    <div class="container">
        <h1>Edit Profile</h1>
        <form onsubmit="return validateProfileUpdate()" method="POST" enctype="multipart/form-data" action="${pageContext.request.contextPath}/Admin/UpdateProfile" >
            <input type="hidden" value="<%=getUser.getUserID()%>" name="userid" id="userid" />
            <img src="../<%= getUser.getPicDir()%>" class="editProfileImg" id="editProfileImg" alt="">
            <div class="fileUpload btn btn-primary">
                <span>Upload</span>
                <input type="file" name="filePhoto" class="upload" id="filePhoto" onchange="ValidateSingleInput(this)" />
            </div>
            <label>Email : <span id="user-result1"><img src="" /><p></p></span></label>
            <input name="email" id="emailEdit"  value="<%=getUser.getEmail()%>" type="email" onclick="return colourChange(email)" maxlength="25">
            <div class="bioCentre">
                
                <textarea name="userpost" id="userpost" class="textareaStyle" onclick="return colourChange(userpost)"><%=getUser.getBio()%></textarea>
                <script type="text/javascript">
                $("textarea").textareaCounter();
                </script>
                

                
            </div>
             <label>Make Admin?</label><br />  
            <c:choose>
                <c:when test="${SKUSER.getIsAdmin() == 'YES'}">
                    <select name = "makeAdmin">
                        <option name = "dropValue2" value="YES">Yes</option>
                        <option name = "dropValue3" value="NO">No</option>               
                    </select> 
                </c:when>
                <c:otherwise>
                    <select name = "makeAdmin">
                        <option name = "dropValue3" value="NO">No</option> 
                        <option name = "dropValue2" value="YES">Yes</option>             
                    </select> 
                </c:otherwise>
            </c:choose>    
             
           
            
            <c:choose>
                <c:when test="${SKUSER.getIsAdmin() == 'YES'}">
                    
                    <label <c:out value="${hideBan}"/>><input type="hidden" name="banUser" id="banUser" value="<%= getUser.getIsBanned()%>"></label><br />
                </c:when>
                <c:otherwise>
                    <c:choose>
                        <c:when test="${SKUSER.getIsBanned() == 'YES'}">
                        <label>Ban User?</label><br /> 
                            <select name = "banUser">
                                <option name = "dropValue2" value="YES">Yes</option>
                                <option name = "dropValue3" value="NO">No</option>               
                            </select> 
                        </c:when>
                        <c:otherwise>
                            <label>Ban User?</label><br /> 
                            <select name = "banUser">
                                <option name = "dropValue3" value="NO">No</option> 
                                <option name = "dropValue2" value="YES">Yes</option>                  
                            </select>
                        
                        </c:otherwise>
                     
                    </c:choose>
                   
                </c:otherwise>
            </c:choose>    
            
            <label><input name="changePassword" type="checkbox" id="changePassword" value="checkboxPassword">Change Password</label><br />
            <label>Password :</label>
            <input id="password" name="password" placme="password"eholder="**********" type="password" onclick="return colourChange(password)" maxlength="25">
            
            <span id="mistake"></span>
            <input name="submit" type="submit" class="postSubmit" id="update" value="Update">
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

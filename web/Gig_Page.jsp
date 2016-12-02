<%@page import="GigForMe.Model.Band"%>
<%@page import="GigForMe.Model.User"%>
<%@page import="GigForMe.Model.Comment"%>
<%@page import="java.util.Vector"%>
<%@page import="GigForMe.Model.Gig"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
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
    <script src="https://maps.googleapis.com/maps/api/js?sensor=false"></script>
    <script type="text/javascript" src="js/comment.js"></script>
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

<body id="gig_page">
    <a href=""></a>
    <!-- Navigation -->
    <jsp:include page="normalMenu.jsp" />
   
    <%Gig getGig = (Gig) session.getAttribute("SKGIG");%>
    <%User getUser = (User) session.getAttribute("USER");%>
    <% Vector<Comment> getComments = (Vector<Comment>) session.getAttribute("SKCOMMENT");%>
    <% Band band = (Band)session.getAttribute("BAND"); %>
    <!-- Page Content -->
    <div class="container">
        <h1>Gig</h1>
        <form>
            <input id="latitude" type = "hidden" value="<%=getGig.getLatitude()%>" />
            <input id="longitude" type = "hidden" value="<%=getGig.getLongitude()%>" />
        </form>
        <div id="map_canvas"></div>
        <h2><%=getGig.getBandName()%></h2>
        <h3><%=getGig.getGigDate()%></h3>
        <p class = "gigDesc"><%=getGig.getGigDescription()%></p>
        <div class="venue"><span class="venue">Venue</span><p class = "venue1"> <%=getGig.getVenueName()%></p></div>
        <div class="price"><span class="price">Gig Price</span><p class = "price1"> &euro;<%=getGig.getPrice()%></p></div>
        <div class="price"><span class="price">Votes</span><p class = "venue1"><i class="fa fa-thumbs-up" id="voting"> &nbsp;<%=getGig.getVotes()%></i></p></div>
        
            
        <c:choose>
            <c:when test="${SKGIG.getVoteCheck() eq 'NO'}">

                <form class = "voter"><input type="hidden" id="vote" name ="vote" value="${SKGIG.getGigID()}"><input type="button" id = "voteButton" class="voteButton" name="voteButton" value="Vote"></form></h4>

            </c:when>
            <c:when test="${USER.getUsername() eq null}">

               

            </c:when>
            <c:otherwise>
                

            </c:otherwise>  
        </c:choose>    
        <c:if test="${SKGIG.getIsConfirmed() eq 'YES'}">
            <p class="confirmed">Confirmed!</p>
        </c:if>
        
       
        
        
        <div class="commentSection">
            
            <h2 class="comments">Comments</h2>
            <c:choose>
                <c:when test="${USER.getUsername() ne null}">
                    <form onsubmit="return validateComment()" action="" method="post">
                        <input type="hidden" id="field" value="<%=getGig.getGigID()%>" />
                        <textarea class="textareaStyle" name="userpost" id="userpost" placeholder="Comment" maxlength="150"></textarea>
                        <p class="warning" id="warning">You must enter a comment!</p>
                        <input name="submit" type="button" class="postSubmit" id = "postSubmit" value=" Post ">

                    </form>
                    
                </c:when>
                <c:when test="${BAND.getUsername() ne null}">
                    <form onsubmit="return validateComment()" action="" method="post">
                        <input type="hidden" id="field" value="<%=getGig.getGigID()%>" />
                        <textarea class="textareaStyle" name="userpost" id="userpost" placeholder="Comment" maxlength="150"></textarea>
                        <p class="warning" id="warning">You must enter a comment!</p>
                        <input name="submit" type="button" class="postSubmit" id = "postSubmit" value=" Post ">

                    </form>
                    
                </c:when>
                <c:otherwise>
                    <p>You must be signed in to comment. You can <a href="login.jsp">login</a> or <a href="register.jsp">register</a> here</p>
                    
                    
                    
                </c:otherwise>
                
                
                
            </c:choose>
            
            <div class="comment1">

            </div>
            <c:forEach items="${SKCOMMENT}" var="tempuser">
                <div class="comment">
                    <img src="${tempuser.getPicdir()}" alt="profile picture">
                    <c:choose>
                        <c:when test="${fn:contains(tempuser.getName(), '<i class=')}">
                            <h3><a href="UserProfile?b=${tempuser.getUserID()}">${tempuser.getName()}</a></h3>
                        </c:when>
                        <c:otherwise>
                            <h3><a href="UserProfile?u=${tempuser.getUserID()}">${tempuser.getUsername()}</a></h3>
                        </c:otherwise>
                    </c:choose>
                    
                    
                    <p>${tempuser.getComment()}</p>

                </div>
                
                
            </c:forEach>
            
            
            
        </div>
        

        

    </div>

    <footer class="footerContainer" id="footer">
        <div class="container">
            <p>&copy; GigForMe 2015</p>

        </div>
    </footer>
    <!-- /.container -->

    <!-- jQuery Version 1.11.1 -->
    <script src="js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>
    <script type="text/javascript" src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
    <script type="text/javascript" src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
    
</body>

</html>

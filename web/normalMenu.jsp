<%-- 
    Document   : normalMenu
    Created on : 26-Jan-2016, 11:34:53
    Author     : Ben
--%>

<%@page import="GigForMe.Model.Band"%>
<%@page import="GigForMe.Model.User"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- Navigation -->
<% User user = (User)session.getAttribute("USER"); %>
<% Band band = (Band)session.getAttribute("BAND"); %>
<c:choose>
    <c:when test="${USER.getUsername() eq null}">
        <c:choose>
        <c:when test="${BAND.getUsername() ne null}">
            <header>
                <a href="Gigs">
                    <img src="img/logo.png" alt="logo">
                </a>
            </header>
            <nav class="navbar navbar-inverse navbar-static-top" role="navigation">

                    <!-- Brand and toggle get grouped for better mobile display -->
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <a class="navbar-brand" href="#">Main Navigation</a>
                    </div>
                    <!-- Collect the nav links, forms, and other content for toggling -->
                    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                        <ul class="nav navbar-nav">
                            <li>
                                <a href="Gigs">Home</a>
                            </li>
                            
                            
                            <li>
                                <a href="ViewBand">${BAND.getUsername()}</a>
                            </li>
                            <li>
                                <a href="BandLogout">Logout</a>
                            </li>   
                        </ul>
                    </div>
                    <!-- /.navbar-collapse -->

            </nav>
              
        </c:when>
        <c:otherwise>
        <header>
            <a href="index.jsp">
                <img src="img/logo.png" alt="logo">
            </a>
        </header>
        <nav class="navbar navbar-inverse navbar-static-top" role="navigation">

                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#">Main Navigation</a>
                </div>
                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        <li>
                            <a href="index.jsp">Home</a>
                        </li>
                        <li>
                            <a href="about_us.jsp">About Us</a>
                        </li>
                        <li>
                            <a href="Gigs">Gigs</a>
                        </li>
                        <li>
                            <a href="login.jsp">Login</a>
                        </li>                    
                    </ul>
                </div>
                <!-- /.navbar-collapse -->

        </nav>
        </c:otherwise>
        </c:choose>
    </c:when>
    <c:otherwise>
        <header>
            <a href="Gigs">
                <img src="img/logo.png" alt="logo">
            </a>
        </header>
        <nav class="navbar navbar-inverse navbar-static-top" role="navigation">

                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#">Main Navigation</a>
                </div>
                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        <li>
                            <a href="Gigs">Home</a>
                        </li>
                        <li>
                            <a href="CreateGig">Create Gig</a>
                        </li>
                         
                        <li>
                            <a href="ViewProfile">${USER.getUsername()}</a>
                        </li>
                        <li>
                            <a href="Logout">Logout</a>
                        </li>   
                    </ul>
                </div>
                <!-- /.navbar-collapse -->

        </nav>
        
        
        
        
    </c:otherwise>
</c:choose>    

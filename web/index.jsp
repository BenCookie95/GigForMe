<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Gig For Me - Homepage</title>

    <!-- Bootstrap Core CSS -->
    <link rel="stylesheet" type="text/css" href="slick/slick.css"/>
    <link rel="stylesheet" type="text/css" href="slick/slick-theme.css"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.6.4/jquery.min.js"></script>
    <link href="css/style.css" rel="stylesheet">
    <link href="css/mediaQueries.css" rel="stylesheet">
    <script type="text/javascript" src="js/site.js"></script>


    <!-- Custom CSS -->
    

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body id="index">
    <div class="container1">
    <!-- Navigation -->
   <jsp:include page="normalMenu.jsp" />
    <div class="one-time">
        <div class="slides">
            <img src="img/Concert.jpg" alt="" class="sliderImage">
            <!-- <div class="slideDesc">
                sdsdgsdgds
            </div> -->
        </div>
        <div class="slides">
            <img src="img/concert1.jpeg" alt="" class="sliderImage">
            <!-- <div class="slideDesc">
                nnmmm
            </div> -->
        </div>
    </div>
    <!-- Page Content -->
    <div class="container">
        <div class="col span5">

            <div class="module m1">
                    
                        <img src="img/imaginedragons.jpe" alt="Gigs">
                        <div class="text">
                            <h2>View Our Gigs</h2>
                        </div><!--/text-->
                   
                </div>
                
                
                <div class="module m2">
                    
                        <img src="img/Eminem.jpg" alt="register">
                        <div class="text">
                            <h2>Register</h2>
                            <p class="more">Become a member</p>
                        </div><!--/text-->
                    
                </div>




        </div>
        <div class="col span7">
                
                <div class="module m3">
                    
                        <img src="img/coldplay1.jpg" alt="Coldplay">
                        <div class="text">
                            <h2>Request a Gig</h2>
                           
                        </div><!--/text-->
                    
                </div>
                
                
                <div class="module m4">
                    
                        <img src="img/u2.jpg" alt="U2">
                        <div class="text">
                            <h2>View the latest Request</h2>
                            
                        </div><!--/text-->
                    
                </div>
                
                
        </div>
    </div>
    

    <footer class="footerContainer">
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
    <script type="text/javascript" src="slick/slick.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function(){
            $('.one-time').slick({
              dots: false,
              infinite: true,
              speed: 300,
              autoplay:true,
              slidesToShow: 1,
              adaptiveHeight: true
            });
            $('.responsive').slick({
                dots: false,
                infinite: true,
                speed: 300,
                slidesToShow: 3,
                slidesToScroll: 1,
                prevArrow: $('.prev'),
                nextArrow: $('.next'),
                autoplay:true,
                responsive: [
                {
                  breakpoint: 1024,
                  settings: {
                    slidesToShow: 3,
                    slidesToScroll: 1,
                    infinite: true,
                    dots: true
                  }
                },
                {
                  breakpoint: 725,
                  settings: {
                    slidesToShow: 2,
                    slidesToScroll: 1
                  }
                },
                {
                  breakpoint: 480,
                  settings: {
                    slidesToShow: 1,
                    slidesToScroll: 1
                  }
                }
                // You can unslick at a given breakpoint now by adding:
                // settings: "unslick"
                // instead of a settings object
              ]
            });
        });
        
        </script>
    </div>
</body>

</html>

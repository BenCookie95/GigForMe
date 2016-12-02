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

<body id="about-us">
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
        <h1>About Us ${message}</h1>
        <p class="aboutUs">Gig for me allows bands interact with their fans all around the world. With a millions of fans logging in each day Gig For Me is the place for any band looking to play the ultimate gig. Fans can propose possible gigs and the band can decide to make that gig a reality. With 100’s of gigs being confirmed everyday Gig For Me is becoming the ideal platform to boost a bands reputation with fans. <br />
        Gig For Me was founded in 2015 by Ben Cooke and launched on 18/11/15 by a small team working very late nights and weekends in no other than lab G.79 in the ORB(as the hipsters call it) in UCC, Ireland.</p>   
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

$(document).ready(function(){
    $(".navToggle").click(function(){
        if ($(".sideMenu ul").hasClass("expanded")) {
            $(".sideMenu ul.expanded").removeClass("expanded").slideUp(250);
            $(this).removeClass("open");
        } else {
            $(".sideMenu ul").addClass("expanded").slideDown(250);
            $(this).addClass("open");
        }
    });
});
$( function () {

    var height_diff = $( window ).height() - $( 'body' ).height();
    if ( height_diff > 0 ) {
        $( '#footer' ).css( 'margin-top', height_diff );
    }

});
function validateComment(){
	if (userpost.value.length < 1) {
	userpost.style.borderWidth = "medium";
	userpost.style.borderColor = "red";
	warning.style.display = "block";
	userpost.focus();
	return false;
	}else{
		return true;
	}

};

var hide = function(){
      mistake.style.color = document.getElementById('mistake').innerHTML = "";
    };
var letterNumber = /^[0-9a-zA-Z]+$/;
var numberCheck = /^[0-9.]+$/;
var integerCheck = /^[0-9]+$/;
var mistakeText;
var date_regex = /^(0[1-9]|1[0-2])\/(0[1-9]|1\d|2\d|3[01])\/(19|20)\d{2}$/ ;

$(document).ready(function() {
    var date = new Date();

    var day = date.getDate();
    var month = date.getMonth() + 1;
    var year = date.getFullYear() + 1;

    if (month < 10) month = "0" + month;
    if (day < 10) day = "0" + day;

    var today = year + "-" + month + "-" + day;       
    $("#gigDate").attr("value", today);
});

function showError(name){
	name.style.borderColor = "red";
	name.style.borderWidth = "medium";
	name.focus();
	name.value = "";
};

function validateRegistration(){
	
if (fname.value.length < 2) {
	var mistakeText = document.getElementById('mistake').innerHTML = "You left your first name blank";
	setTimeout(hide, 5000);
	showError(fname);
	setTimeout(function() { colourChange(fname); }, 5000);
	return false;
}else if(lname.value.length < 2){
	var mistakeText = document.getElementById('mistake').innerHTML = "You left your last name blank";
	setTimeout(hide, 5000);
	showError(lname);
	setTimeout(function() { colourChange(lname); }, 5000);
	return false;
}else if(userEmail.value.length < 2){
	var mistakeText = document.getElementById('mistake').innerHTML = "You left your email blank";
	setTimeout(hide, 5000);
	showError(userEmail);
	setTimeout(function() { colourChange(userEmail); }, 5000);
	return false;
}else if(regusername.value.length < 2){
	var mistakeText = document.getElementById('mistake').innerHTML = "You left your username blank";
	setTimeout(hide, 5000);
	showError(regusername);
	setTimeout(function() { colourChange(regusername); }, 5000);
	return false;
}
else if( !regusername.value.match(letterNumber)){
	var mistakeText = document.getElementById('mistake').innerHTML = "Your username is invalid, your username can only contain alphanumeric characters";
	setTimeout(hide, 10000);
	showError(username);
	setTimeout(function() { colourChange(username); }, 10000);
	return false;
}
else if(password.value.length < 2){
	var mistakeText = document.getElementById('mistake').innerHTML = "You left your password blank";
	setTimeout(hide, 5000);
	showError(password);
	setTimeout(function() { colourChange(password); }, 5000);
	return false;
}else if(fname.value.length > 25){
	var mistakeText = document.getElementById('mistake').innerHTML = "Your first name is greater than 25 characters";
	setTimeout(hide, 10000);
	showError(fname);
	setTimeout(function() { colourChange(fname); }, 10000);
	return false;
}else if(lname.value.length > 25){
	var mistakeText = document.getElementById('mistake').innerHTML = "Your last name is greater than 25 characters";
	setTimeout(hide, 10000);
	showError(lname);
	setTimeout(function() { colourChange(lname); }, 10000);
	return false;
}else if(userEmail.value.length > 60){
	var mistakeText = document.getElementById('mistake').innerHTML = "Your email is too long";
	setTimeout(hide, 10000);
	showError(userEmail);
	setTimeout(function() { colourChange(userEmail); }, 10000);
	return false;
}else if(regusername.value.length > 25){

	var mistakeText = document.getElementById('mistake').innerHTML = "Your username is greater than 25 characters";
	setTimeout(hide, 10000);
	showError(regusername);
	setTimeout(function() { colourChange(regusername); }, 10000);
	return false;
}
else if(password.value.length > 25){
	var mistakeText = document.getElementById('mistake').innerHTML = "Your password is greater than 25 characters";
	setTimeout(hide, 10000);
	showError(password);
	password1.value = ""
	setTimeout(function() { colourChange(password); }, 10000);
	return false;
}
else{
	return true;
}
};

function colourChange(this1){
	this1.style.borderColor = "white";
};

function validateSubmission(){

if (band.value.length < 1) {
	var mistakeText = document.getElementById('mistake').innerHTML = "Please choose a band";
	setTimeout(hide, 5000);
	showError(band);
	setTimeout(function() { colourChange(band); }, 5000);
	return false;
}
else if(description.value.length < 10){
	var mistakeText = document.getElementById('mistake').innerHTML = "Please give the gig a description.";
	setTimeout(hide, 5000);
	showError(description);
	setTimeout(function() { colourChange(description); }, 5000);
	return false;
}
else if (venue.value.length < 1) {
	var mistakeText = document.getElementById('mistake').innerHTML = "Please choose a venue";
	setTimeout(hide, 5000);
	showError(venue);
	setTimeout(function() { colourChange(venue); }, 5000);
	return false;
}
else if( !price.value.match(numberCheck)){
	var mistakeText = document.getElementById('mistake').innerHTML = "You can only use numbers when suggesting a price";
	setTimeout(hide, 10000);
	showError(price);
	setTimeout(function() { colourChange(price); }, 10000);
	return false;
}
else if (gigDate.value.length < 1) {
	var mistakeText = document.getElementById('mistake').innerHTML = "Please choose a date";
	setTimeout(hide, 5000);
	showError(gigDate);
	setTimeout(function() { colourChange(gigDate); }, 5000);
	return false;
}
else{
	return true;
}

};
function validateBandProfileUpdate(){
	if(userpost.value.length < 3){
            var mistakeText = document.getElementById('mistake').innerHTML = "Please provide a BIO";
            showError(userpost);
            setTimeout(function() { colourChange(userpost); }, 5000);
            return false;
        }else if(document.getElementById('changePassword').checked && password.value.length < 1){
            var mistakeText = document.getElementById('mistake').innerHTML = "Please enter a new password";
            showError(password);
            setTimeout(function() { colourChange(password); }, 5000);
            return false;
        }else{
            return true;
	}
};
function validateProfileUpdate(){
	if(email.value.length < 5) {
            var mistakeText = document.getElementById('mistake').innerHTML = "Please provide an email address";
            showError(email);
            setTimeout(function() { colourChange(email); }, 5000);
            return false;
	}else if(userpost.value.length < 3){
            var mistakeText = document.getElementById('mistake').innerHTML = "Please provide a BIO";
            showError(userpost);
            setTimeout(function() { colourChange(userpost); }, 5000);
            return false;
        }else if(document.getElementById('changePassword').checked && password.value.length < 1){
            var mistakeText = document.getElementById('mistake').innerHTML = "Please enter a new password";
            showError(password);
            setTimeout(function() { colourChange(password); }, 5000);
            return false;
        }else{
            return true;
	}
};
function validateEditProfile(){
	if(email.value.length < 5) {
            var mistakeText = document.getElementById('mistake').innerHTML = "Please provide an email address";
            showError(email);
            setTimeout(function() { colourChange(email); }, 5000);
            return false;
	}else if(userpost.value.length < 3){
            var mistakeText = document.getElementById('mistake').innerHTML = "Please provide a BIO";
            showError(userpost);
            setTimeout(function() { colourChange(userpost); }, 5000);
            return false;
        }else if(document.getElementById('changePassword').checked && password.value.length < 2){
		var mistakeText = document.getElementById('mistake').innerHTML = "Please enter a new password!";
		showError(password);
		setTimeout(function() { colourChange(password); }, 5000);
		return false;
	}else{
	return true;
	}
};
function validateEditBandProfile(){
	if(userpost.value.length < 3){
            var mistakeText = document.getElementById('mistake').innerHTML = "Please provide a BIO";
            showError(userpost);
            setTimeout(function() { colourChange(userpost); }, 5000);
            return false;
        }else if(document.getElementById('changePassword').checked && password.value.length < 2){
		var mistakeText = document.getElementById('mistake').innerHTML = "Please enter a new password!";
		showError(password);
		setTimeout(function() { colourChange(password); }, 5000);
		return false;
	}else{
	return true;
	}
};
function validateBandRegistration(){
	if (fname.value.length < 2) {
                var mistakeText = document.getElementById('mistake').innerHTML = "Please enter a band name.";
		showError(fname);
		setTimeout(function() { colourChange(fname); }, 5000);
		return false;
	}else if(password.value !== password1.value){
		var mistakeText = document.getElementById('mistake').innerHTML = "The passwords you provided did not match";
		setTimeout(hide, 10000);
		showError(password1);
		setTimeout(function() { colourChange(password1); }, 10000);
                showError(password);
		setTimeout(function() { colourChange(password); }, 10000);
		return false;
	}else{
		return true;
	}
};
function validateVenueRegistration(){
	if (venuename.value.length < 2) {
		var mistakeText = document.getElementById('mistake').innerHTML = "You must enter a venue name";
		showError(venuename);
		setTimeout(function() { colourChange(venuename); }, 5000);
		return false;
	} else if( !capacity.value.match(integerCheck)){
		var mistakeText = document.getElementById('mistake').innerHTML = "You can only use numbers when entering the capacity";
		setTimeout(hide, 10000);
		showError(capacity);
		setTimeout(function() { colourChange(capacity); }, 10000);
		return false;
	}else if (latitude.value.length < 3) {
		var mistakeText = document.getElementById('mistake').innerHTML = "You must enter a Latitude to use for the Google Maps";
		showError(latitude);
		setTimeout(function() { colourChange(latitude); }, 5000);
		return false;
	}else if (!latitude.value.match(numberCheck)) {
		var mistakeText = document.getElementById('mistake').innerHTML = "The Latitude only accepts numeric characters";
		showError(latitude);
		setTimeout(function() { colourChange(latitude); }, 5000);
		return false;
	}else if (longitude.value.length < 3) {
		var mistakeText = document.getElementById('mistake').innerHTML = "You must enter a Longitude to use for the Google Maps";
		showError(longitude);
		setTimeout(function() { colourChange(longitude); }, 5000);
		return false;
	}else if (!longitude.value.match(numberCheck)) {
		var mistakeText = document.getElementById('mistake').innerHTML = "The Longitude only accepts numeric characters";
		showError(longitude);
		setTimeout(function() { colourChange(longitude); }, 5000);
		return false;
	}else{
		return true;
	}
};
function validateGigEdit(){

	if (gigDate.value.length < 1) {
		var mistakeText = document.getElementById('mistake').innerHTML = "Please choose a date";
		setTimeout(hide, 5000);
		showError(gigDate);
		setTimeout(function() { colourChange(gigDate); }, 5000);
		return false;
	}else if( !Price.value.match(numberCheck)){
		var mistakeText = document.getElementById('mistake').innerHTML = "You can only use numbers when entering the price";
		setTimeout(hide, 10000);
		showError(Price);
		setTimeout(function() { colourChange(Price); }, 10000);
		return false;
	}else{
		return true;
	}
};

$(document).ready(function() {

    $('#userEmail').on('change keydown keyup paste input', function (e) { //user types username on inputfiled
        var email = $("#userEmail").val();
        
        
        var dataString = "Email=" + email;
        if( isValidEmailAddress(email)) {

            $.ajax({
            type: "POST",
            url: "EmailChecker",
            data: dataString,
            dataType: "json",
            success: function(data) {
                if (data.success) {
                    $("#user-result1 img").attr("src", "img/available.png");
                    $("#user-result1 p").html("");
                    $('#update').attr("disabled", false);
                }else {
                    $("#user-result1 img").attr("src", "img/not-available.png");
                    $("#user-result1 p").html("This Email Address is already taken.");
                    $('#update').attr("disabled", true);
                }
            }
         });
        }else{
            $("#user-result1 img").attr("src", "img/not-available.png");
            $("#user-result1 p").html("This is not a valid Email Address.");
            $('#update').attr("disabled", true);
        }
    });
	
});





//$(document).delegate('form', 'click', function() {
//    
//    var $form = $(this);
//    var id = $form.attr('id');
//    //Stops the submit request
//    
//});



function readURL(input) {
    if (input.files && input.files[0]) {
        var reader = new FileReader();
        reader.onload = function (e) {
            document.getElementById('editProfileImg').src=e.target.result;
        }
        reader.readAsDataURL(input.files[0]);
    }
}

var _validFileExtensions = [".jpg", ".jpeg", ".gif", ".png"];    
function ValidateSingleInput(oInput) {
    if (oInput.type == "file") {
        var sFileName = oInput.value;
         if (sFileName.length > 0) {
            var blnValid = false;
            for (var j = 0; j < _validFileExtensions.length; j++) {
                var sCurExtension = _validFileExtensions[j];
                if (sFileName.substr(sFileName.length - sCurExtension.length, sCurExtension.length).toLowerCase() == sCurExtension.toLowerCase()) {
                    blnValid = true;
                    readURL(oInput);
                    break;
                }
            }

            if (!blnValid) {
                alert("Sorry, " + sFileName + " is invalid, allowed extensions are: " + _validFileExtensions.join(", "));
                oInput.value = "";
                return false;
            }
        }
    }
    return true;
}

$(document).ready(function() {

    $("#emailEdit").on('change keydown keyup paste input', function (e) { //user types username on inputfiled
        var email = $("#emailEdit").val();
        var userid = $("#userid").val();
        
        var dataString = "userID=" + userid + "&Email=" + email;
        if( isValidEmailAddress(email)) {

            $.ajax({
            type: "POST",
            url: "CheckEmail",
            data: dataString,
            dataType: "json",
            success: function(data) {
                if (data.success) {
                    $("#user-result1 img").attr("src", "../img/available.png");
                    $("#user-result1 p").html("");
                    $('#update').attr("disabled", false);
                }else {
                    $("#user-result1 img").attr("src", "../img/not-available.png");
                    $("#user-result1 p").html("This Email Address is already taken.");
                    $('#update').attr("disabled", true);
                }
            }
         });
        }else{
            $("#user-result1 img").attr("src", "../img/not-available.png");
            $("#user-result1 p").html("This is not a valid Email Address.");
            $('#update').attr("disabled", true);
        }
    });
	
});

function isValidEmailAddress(emailAddress) {
    var pattern = new RegExp(/^(("[\w-\s]+")|([\w-]+(?:\.[\w-]+)*)|("[\w-\s]+")([\w-]+(?:\.[\w-]+)*))(@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$)|(@\[?((25[0-5]\.|2[0-4][0-9]\.|1[0-9]{2}\.|[0-9]{1,2}\.))((25[0-5]|2[0-4][0-9]|1[0-9]{2}|[0-9]{1,2})\.){2}(25[0-5]|2[0-4][0-9]|1[0-9]{2}|[0-9]{1,2})\]?$)/i);
    return pattern.test(emailAddress);
}



$(document).ready(function() {

    $("#bandemail").on('change keydown keyup paste input', function (e) { //user types username on inputfiled
        var email = $("#bandemail").val();
        
        
        var dataString = "Email=" + email;
        if( isValidEmailAddress(email)) {

            $.ajax({
            type: "POST",
            url: "CheckBandEmail",
            data: dataString,
            dataType: "json",
            success: function(data) {
                if (data.success) {
                    $("#user-result img").attr("src", "../img/available.png");
                    $("#user-result p").html("");
                    $('#update').attr("disabled", false);
                }else {
                    $("#user-result img").attr("src", "../img/not-available.png");
                    $("#user-result p").html("This Email Address is already taken.");
                    $('#update').attr("disabled", true);
                }
            }
         });
        }else{
            $("#user-result img").attr("src", "../img/not-available.png");
            $("#user-result p").html("This is not a valid Email Address.");
            $('#update').attr("disabled", true);
        }
    });
	
});
$(document).ready(function() {

    $("#regusername").on('change keydown keyup paste input', function (e) { //user types username on inputfiled
        var username = $("#regusername").val();
        
        
        var dataString = "username=" + username;
        if(username.match(letterNumber) && username.length > 1) {

            $.ajax({
            type: "POST",
            url: "CheckTheUsername",
            data: dataString,
            dataType: "json",
            success: function(data) {
                if (data.success) {
                    $("#username-result img").attr("src", "img/available.png");
                    $("#username-result p").html("");
                    $('#update').attr("disabled", false);
                }else {
                    $("#username-result img").attr("src", "img/not-available.png");
                    $("#username-result p").html("This Username is already taken.");
                    $('#update').attr("disabled", true);
                }
            }
         });
        }else{
            $("#username-result img").attr("src", "img/not-available.png");
            $("#username-result p").html("This is not a valid Username, you can only use letters and numbers.");
            $('#update').attr("disabled", true);
        }
    });
	
});

$(document).ready(function() {

    $("#bandusername").on('change keydown keyup paste input', function (e) { //user types username on inputfiled
        var username = $("#bandusername").val();
        
        
        var dataString = "username=" + username;
        if(username.match(letterNumber) && username.length > 1) {

            $.ajax({
            type: "POST",
            url: "CheckBandUsername",
            data: dataString,
            dataType: "json",
            success: function(data) {
                if (data.success) {
                    $("#username-result img").attr("src", "../img/available.png");
                    $("#username-result p").html("");
                    $('#update').attr("disabled", false);
                }else {
                    $("#username-result img").attr("src", "../img/not-available.png");
                    $("#username-result p").html("This Username is already taken.");
                    $('#update').attr("disabled", true);
                }
            }
         });
        }else{
            $("#username-result img").attr("src", "../img/not-available.png");
            $("#username-result p").html("This is not a valid Username, you can only use letters and numbers.");
            $('#update').attr("disabled", true);
        }
    });
	
});
$(document).ready(function() {

    $("#userEmailEdit").on('change keydown keyup paste input', function (e) { //user types username on inputfiled
        var email = $("#userEmailEdit").val();
        
        
        var dataString = "Email=" + email;
        if( isValidEmailAddress(email)) {

            $.ajax({
            type: "POST",
            url: "EmailEdit",
            data: dataString,
            dataType: "json",
            success: function(data) {
                if (data.success) {
                    $("#user-result1 img").attr("src", "img/available.png");
                    $("#user-result1 p").html("");
                    $('#update').attr("disabled", false);
                }else {
                    $("#user-result1 img").attr("src", "img/not-available.png");
                    $("#user-result1 p").html("This Email Address is already taken.");
                    $('#update').attr("disabled", true);
                }
            }
         });
        }else{
            $("#user-result1 img").attr("src", "img/not-available.png");
            $("#user-result1 p").html("This is not a valid Email Address.");
            $('#update').attr("disabled", true);
        }
    });
	
});



function initialize() {
var map_canvas = document.getElementById('map_canvas');
var longitude = document.getElementById('longitude').value;
var latitude = document.getElementById('latitude').value;
var map_options = {
center: new google.maps.LatLng(latitude, longitude),
zoom:15,
mapTypeId: google.maps.MapTypeId.ROADMAP
};
var map = new google.maps.Map(map_canvas, map_options)
}
google.maps.event.addDomListener(window, 'load', initialize);




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
    }
var letterNumber = /^[0-9a-zA-Z]+$/;
var numberCheck = /^[0-9.]+$/;
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
}else if(email.value.length < 2){
	var mistakeText = document.getElementById('mistake').innerHTML = "You left your email blank";
	setTimeout(hide, 5000);
	showError(email);
	setTimeout(function() { colourChange(email); }, 5000);
	return false;
}else if(username.value.length < 2){
	var mistakeText = document.getElementById('mistake').innerHTML = "You left your username blank";
	setTimeout(hide, 5000);
	showError(username);
	setTimeout(function() { colourChange(username); }, 5000);
	return false;
}
else if( !username.value.match(letterNumber)){
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
}
else if(password1.value.length < 2){
	var mistakeText = document.getElementById('mistake').innerHTML = "You left the second password field blank";
	setTimeout(hide, 5000);
	showError(password1);
	setTimeout(function() { colourChange(password1); }, 5000);
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
}else if(email.value.length > 60){
	var mistakeText = document.getElementById('mistake').innerHTML = "Your email is too long";
	setTimeout(hide, 10000);
	showError(email);
	setTimeout(function() { colourChange(email); }, 10000);
	return false;
}else if(username.value.length > 25){

	var mistakeText = document.getElementById('mistake').innerHTML = "Your username is greater than 25 characters";
	setTimeout(hide, 10000);
	showError(username);
	setTimeout(function() { colourChange(username); }, 10000);
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

else if(password.value !== password1.value){
	
	var mistakeText = document.getElementById('mistake').innerHTML = "Your passwords don't match";
	setTimeout(hide, 10000);
	showError(password1);
	showError(password);
	setTimeout(function() { colourChange(password); },10000);
	setTimeout(function() { colourChange(password1); }, 10000);
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
function validateProfileUpdate(){
	if (email.value.length < 5) {
		showError(email);
		setTimeout(function() { colourChange(email); }, 5000);
		return false;
	}else if(document.getElementById('changePassword').checked && password.value !== password1.value){
		showError(password1);
		setTimeout(function() { colourChange(password1); }, 5000);
		showError(password);
		setTimeout(function() { colourChange(password); }, 5000);
		return false;
	}else if(document.getElementById('changePassword').checked && password.value.length < 1){
		showError(password1);
		setTimeout(function() { colourChange(password1); }, 5000);
		showError(password);
		setTimeout(function() { colourChange(password); }, 5000);
		return false;
	}else{
	return true;
	}
};
function validateEditProfile(){
	if(document.getElementById('changePassword').checked && password.value !== password1.value){
		showError(password1);
		setTimeout(function() { colourChange(password1); }, 5000);
		showError(password);
		setTimeout(function() { colourChange(password); }, 5000);
		return false;
	}else if(document.getElementById('changePassword').checked && password.value.length < 1){
		showError(password1);
		setTimeout(function() { colourChange(password1); }, 5000);
		showError(password);
		setTimeout(function() { colourChange(password); }, 5000);
		return false;
	}else{
	return true;
	}
};
function validateBandRegistration(){
	if (venuename.value.length < 2) {
		showError(venuename);
		setTimeout(function() { colourChange(venuename); }, 5000);
		return false;
	} else if( !capacity.value.match(numberCheck)){
		var mistakeText = document.getElementById('mistake').innerHTML = "You can only use numbers when entering the capacity";
		setTimeout(hide, 10000);
		showError(capacity);
		setTimeout(function() { colourChange(capacity); }, 10000);
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
	} else if( !capacity.value.match(numberCheck)){
		var mistakeText = document.getElementById('mistake').innerHTML = "You can only use numbers when entering the capacity";
		setTimeout(hide, 10000);
		showError(capacity);
		setTimeout(function() { colourChange(capacity); }, 10000);
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


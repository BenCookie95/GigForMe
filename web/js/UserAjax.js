/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//ban/unban user ajax
$(document).delegate('form', 'click', function() {
    var $form = $(this);
    var id = $form.attr('id');
    var formIdTrim = id.substring(0,7);
    if(formIdTrim === "banUser") {
	$(id).submit(function(e){
            e.preventDefault();
         });
         var trimmed = id.substring(7);
         var dataString = $form.serialize();
         var userID = null;
         userID = $("input#ban"+ trimmed).val();
       $("#banButton"+ trimmed).off('click').on('click',(function(e){
          e.preventDefault();

         //get the form data and then serialize that


         dataString = "userID=" + userID;

        // do the extra stuff here
         if (confirm('Are you sure you want to ban the user with the id of ' + trimmed +'?')) {
         $.ajax({
             type: "POST",
             url: "UserBan",
             data: dataString,
             dataType: "json",
             success: function(data) {
                     if (data.success) {
                        $(".bandForm"+trimmed).html("");
                        
//                        $form = $('<form id = "unbanUser'+ trimmed+'"></form>');
//                        $form.append('<input type="hidden" name="unban" value="' + trimmed + '" id="unban' + trimmed + '">');
//                        $form.append('<input type="button" name="unbanButton' + trimmed + '" id ="unbanButton' + trimmed + '" value=" UnBan User " >');
//                        $('.banForm').append($form);
                        //$('#banUser'+trimmed).attr('id','unbanUser'+trimmed);
                        //$('#ban'+trimmed).attr('id','unban'+trimmed);
                        $('#banButton'+trimmed).hide();
                        //$('#banButton'+trimmed).attr('name','unbanButton'+trimmed);
                        //$('#banButton'+trimmed).attr('id','unbanButton'+trimmed);
                        
                     }else {
                              alert("Error");
                          }


            }
         });
         } else {

         }
       }));
    } 
    else if(formIdTrim === "unbanUs") {
        //Stops the submit request
        $(id).submit(function(e){
           e.preventDefault();
        });
        var trimmed = id.substring(9);
        var dataString = $form.serialize();
        var userID = null;
        userID = $("input#unban"+ trimmed).val();
      $("#unbanButton"+ trimmed).off('click').on('click',(function(e){
         e.preventDefault();

        //get the form data and then serialize that


        dataString = "userID=" + userID;

        // do the extra stuff here
        if (confirm('Are you sure you want to UNBAN the user with the id of ' + trimmed +'?')) {
        $.ajax({
            type: "POST",
            url: "UserUnban",
            data: dataString,
            dataType: "json",
            success: function(data) {
                    if (data.success) {
                        $("#unbanUser"+trimmed).html("");
                        //$('#unbanUser'+trimmed).attr('id','banUser'+trimmed);
                        //$('#unban'+trimmed).attr('id','ban'+trimmed);
                        //$('#unbanButton'+trimmed).hide();
                        //$('#unbanButton'+trimmed).attr('name','banButton'+trimmed);
                        //$('#unbanButton'+trimmed).attr('id','banButton'+trimmed);
                        $form = null;
                        id = null;
                        formIdTrim = null;
                        return;
                    }else {
                             alert("Error");
                         }


           }
        });
        } else {

        }
      }));
    }
    
    
});
$(function(){
    $(".deleteButton").click(function(e){
        var $tr = $(this).closest('.row');
        e.preventDefault();
        var integerCheck = /^[0-9]+$/;
        var vendelete = $tr.find('input[name="delete"]').val();
        
        var dataString = "id=" + vendelete;
        if(vendelete.match(integerCheck)){
            if (confirm('Are you sure you want to delete this User?')) {
                $.ajax({
                    type: "POST",
                    url: "UserDelete",
                    data: dataString,
                    dataType: "json",
                    success: function(data) {
                            if (data.success) {
                                $('.removeRow' + vendelete).remove();
                            }else {
                                alert("Error");
                            }


                            }
                });
            }else{
                
            }
        }else{
            
            return false;
        }
        
        
    });
    
});

$(document).ready(function() {

    $("#inputSearch").on('change keydown keyup paste input', function (e) { //user types username on inputfiled
            if ($('#inputSearch').val().length > 0) {
               var search = $(this).val(); //get the string typed by user
               $.post('UserSearch', {'search':search}, function(data) { //make ajax call to check_username.php
               $("#user-result").html(data); //dump the data received from PHP page

               });
            }
            });
	
});
/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(function(){
    $(".postSubmit").click(function(e){
        
        e.preventDefault();
        $("#userpost").css('border-color', 'none');
        $("#userpost").css('border-width', 'none');
        $("#warning").css('display', 'none');
        var field = $("#field").val();
        var post = $("#userpost").val();
        var dataString = "post=" +post + "&field=" + field;
        if(post.length > 2){
            $.ajax({
                type: "POST",
                url: "AddComment",
                data: dataString,
                dataType: "json",
                success: function(data) {
                        if (data.success) {

                            	
                        $( "<div class=\"comment\">" + "<img src=\"" + data.picdir+"\">" + "<h3>" + data.username + "</h3>" + "<p>" + post + "</p> </div>").prependTo( ".comment1" );
                        $("#userpost").val("");

                        }else {
                                 alert("Error");
                             }


                        }
            });
        }else{
            $("#userpost").css('border-color', 'red');
            $("#userpost").css('border-width', 'medium');
            $("#warning").css('display', 'block');
            $("#userpost").focus();
            return false;
        }
        
        
    });
    
});

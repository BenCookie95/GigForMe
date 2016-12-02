/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(function(){
    $(".btnAccept").click(function(e){
        var $tr = $(this).closest('.featuredBox');
        e.preventDefault();
        var integerCheck = /^[0-9]+$/;
        var vote = $tr.find('input[name="acceptGig"]').val();
        
        var dataString = "vote=" + vote;
        if(vote.match(integerCheck)){
            if (confirm('Are you sure you want to reject this Gig? The gig will be removed from the site!')) {
                $.ajax({
                    type: "POST",
                    url: "AcceptGig",
                    data: dataString,
                    dataType: "json",
                    success: function(data) {
                            if (data.success) {



                                $('.accept' + vote).remove();
                                $('.decline' + vote).remove();
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


$(function(){
    $(".btnDecline").click(function(e){
        var $tr = $(this).closest('.featuredBox');
        e.preventDefault();
        var integerCheck = /^[0-9]+$/;
        var vote = $tr.find('input[name="declineGig"]').val();
        
        var dataString = "vote=" + vote;
        if(vote.match(integerCheck)){
            if (confirm('Are you sure you want to reject this Gig? The gig will be removed from the site!')) {
                $.ajax({
                    type: "POST",
                    url: "DeclineGig",
                    data: dataString,
                    dataType: "json",
                    success: function(data) {
                            if (data.success) {



                                $($tr).remove();

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

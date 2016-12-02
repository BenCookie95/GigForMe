/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(function(){
    $(".voteButton").click(function(e){
        var $tr = $(this).closest('.featuredBox');
        e.preventDefault();
        var integerCheck = /^[0-9]+$/;
        var vote = $tr.find('input[name="vote"]').val();
        
        var dataString = "vote=" + vote;
        if(vote.match(integerCheck)){
            $.ajax({
                type: "POST",
                url: "AddVote",
                data: dataString,
                dataType: "json",
                success: function(data) {
                        if (data.success) {

                            	
                            $('i#voting' + vote).text(data.count);
                            $('.voter' + vote).remove();

                        }else {
                            alert("Error");
                        }


                        }
            });
        }else{
            
            return false;
        }
        
        
    });
    
});


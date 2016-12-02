/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(function(){
    $(".deleteButton").click(function(e){
        var $tr = $(this).closest('.row');
        e.preventDefault();
        var integerCheck = /^[0-9]+$/;
        var vendelete = $tr.find('input[name="delete"]').val();
        
        var dataString = "id=" + vendelete;
        if(vendelete.match(integerCheck)){
            if (confirm('Are you sure you want to delete this Gig?')) {
                $.ajax({
                    type: "POST",
                    url: "DeleteGig",
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


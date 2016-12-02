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
            if (confirm('Are you sure you want to delete this Band? Please note that any Gigs associated with this band will also be removed!')) {
                $.ajax({
                    type: "POST",
                    url: "BandDelete",
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

    $("#bandInputSearch").on('change keydown keyup paste input', function (e) { 
            if ($('#bandInputSearch').val().length > 0) {
               var search = $(this).val(); //get the string typed by user
               $.post('BandSearch', {'search':search}, function(data) { //make ajax call to search
               $("#band-result").html(data); //dump the data received from Servlet

               });
            }
            });
	
});
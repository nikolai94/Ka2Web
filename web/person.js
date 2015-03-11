$(function(){
    $("#form").submit(function(){
        x=$('form').serializeArray();
        $.each(x, function(i, field){
                        
            //ajax kald
            $.ajax({
                type: "GET",
                dataType: "json",
                url: "api/getzip",
                success: function(){
                    $("#form").fadeOut('slow');
                    $("#info").html("tak for indtastning");
                }
            });
            
        });
        return false;
    });
});




/*$(function(){
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
});*/


$("document").ready(function (){ 
 $("#submit_allOnZip").click(findOnZip);
 $("#findAllPerson").click(findAllPerson);
 $("#findAllZip").click(findAllZips);
 $("#submit_personOnId").click(findPersonOnId);
 $("#inputPersonSubmit").click(addPeron);
 $("#sletKnap").click(sletKnap);

});


function sletKnap(){
    var id = $( '#inputSletId' ).val();
      var request = $.ajax({
      url : "api/delperson/"+id,
      type: 'DELETE'
      });
      
     request.done(function(){
         
     });   
     
       request.fail(function( jqXHR, textStatus ) {
            alert( "Request failed: " + textStatus );
       });    
     
}


function addPeron(){
    
      var inputFirstName = $( '#inputFirstName' ).val();
      var inputLastName = $( '#inputLastName' ).val();
      var inputStreet = $( '#inputStreet' ).val();
      var inputAdditionalinfo = $( '#inputAdditionalinfo' ).val();
      var inputEmail = $( '#inputEmail' ).val();
      var inputZipcode = $( '#inputZipcode' ).val();
      var inputCity = $( '#inputCity' ).val();
      var inputPhone = $( '#inputPhone' ).val();
      var inputHobby = $( '#inputHobby' ).val();
      
      
      var toJson = {"firstname": inputFirstName, "lastname": inputLastName, "street":inputStreet, "additionalinfo": inputAdditionalinfo,"email":inputEmail,"zipcode":""+inputZipcode,"city": inputCity };
      toJson = JSON.stringify(toJson);
      
      var request = $.ajax({
      url : "api/opretperson",
      dataType : "json",
      data : toJson,
      contentType : 'application/json; charset=UTF-8',
      type : "POST"
      });
       
      findAllPerson();
        
       
      
} 


function findPersonOnId(){
      var value = $( '#personOnId' ).val();
     var request = $.ajax({
     url : "api/complete/"+value,
     dataType : "json",
     type : "GET"
     });
    
     request.done(function(Person){
      $("#bodyGetPersons").html("<tr><td>"+ Person.firstName +"</td><td>"+ Person.lastName +"</td><td>"+ Person.street+"</td><td>"+Person.additionalInfo+"</td><td></td><td>"+ Person.email+"</td><td>"+Person.phones[0].number+"</td><td>"+Person.zipCode+"</td><td>"+Person.city +"</td></tr>");
     });   
     
       request.fail(function( jqXHR, textStatus ) {
            alert( "Request failed: " + textStatus );
       });
}


function findAllZips(){
    $("#bodyGetZip").text(" ");
    
     var request = $.ajax({
     url : "api/getzip",
     dataType : "json",
     type : "GET"
     });
     
     request.done(function(Zip){
            for (var i = 0; i < Zip.length; i++) {
               var insertText ="<tr>";
                insertText +="<td>"+ Zip[i].city+"</td>";
                insertText +="<td>"+ Zip[i].zipcode+"</td>";
                insertText +="</tr>";
                $("#bodyGetZip").append(insertText);
    
         }
     }); 
        request.fail(function( jqXHR, textStatus ) {
            alert( "Request failed: " + jqXHR.responseText);
       });
    
}
            
function findOnZip(){
     $("#bodyGetPersons").text(" ");
     var value = $( '#zipcode' ).val();
     var request = $.ajax({
     url : "api/getpersononzip/"+value,
     dataType : "json",
     type : "GET"
     });
     
     
         request.done(function(Person){
         for (var i = 0; i < Person.length; i++) {
          var insertText ="<tr>";
          insertText += "<td>"+ Person[i].firstname +"</td>";
          insertText += "<td>"+ Person[i].lastname +"</td>";
          insertText += "<td>"+ Person[i].street +"</td>";
          insertText += "<td>"+ Person[i].additionalinfo +"</td>";
             insertText += "<td>";
             for (var j = 0; j < Person[i].hobbies.length; j++) {
                insertText += Person[i].hobbies[j].name+"<br/>";
            }
          insertText += "</td>";
          insertText += "<td>"+ Person[i].email +"</td>";
          
          insertText += "<td>";
            for (var k = 0; k < Person[i].Phones.length; k++) {
                 insertText += Person[i].Phones[k].number+"<br/>";
            }
          insertText += "</td>";
          
          insertText += "<td>";
            insertText += Person[i].zipcode ;
          insertText += "</td>";
          
          insertText += "<td>";
            insertText += Person[i].city;
          insertText += "</td>";
          
             
          insertText += "</tr>";
          $("#bodyGetPersons").append(insertText);   
        }   
         
      });            

      request.fail(function( jqXHR, textStatus ) {
            // console.log(jqXHR.responseText);
         
          
            alert( "Request failed: " + jqXHR.responseText);
       });
         
}


function findAllPerson (){ 
    $("#bodyGetPersons").text(" ");
     var request = $.ajax({
     url : "api/complete",
     dataType : "json",
     type : "GET"
     });
     
     request.done(function(Person){
         for (var i = 0; i < Person.length; i++) {
          var insertText ="<tr>";
          insertText += "<td>"+ Person[i].firstname +"</td>";
          insertText += "<td>"+ Person[i].lastname +"</td>";
          insertText += "<td>"+ Person[i].street +"</td>";
          insertText += "<td>"+ Person[i].additionalinfo +"</td>";
             insertText += "<td>";
             for (var j = 0; j < Person[i].hobbies.length; j++) {
                insertText += Person[i].hobbies[j].name+"<br/>";
            }
          insertText += "</td>";
          insertText += "<td>"+ Person[i].email +"</td>";
          
          insertText += "<td>";
            for (var k = 0; k < Person[i].Phones.length; k++) {
                 insertText += Person[i].Phones[k].number+"<br/>";
            }
          insertText += "</td>";
          
          insertText += "<td>";
            insertText += Person[i].zipcode ;
          insertText += "</td>";
          
          insertText += "<td>";
            insertText += Person[i].city;
          insertText += "</td>";
          
             
          insertText += "</tr>";
          $("#bodyGetPersons").append(insertText);   
        }   
         
      });            

      request.fail(function( jqXHR, textStatus ) {
            alert( "Request failed: " + jqXHR.responseText);
       });

}


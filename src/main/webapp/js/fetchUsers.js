$(document).ready(function() {
	$("#tablediv").hide();
     $("#showTable").click(function(event){
           $.get('dataToTable',function(responseJson) {
        	   if(responseJson!=null){
            	   $("#userTable").find("tr:gt(0)").remove();
            	   var table1 = $("#userTable");
	               $.each(responseJson, function(key,value) { 
	               		   var rowNew = $("<tr><td></td><td></td></tr>");
	                       
	                       rowNew.children().eq(0).text(value['username']); 
	                       rowNew.children().eq(1).text(value['password']); 
	                       	                  
	                       
	                      
	                       rowNew.appendTo(table1);
	               });
                }
    
            });
            $("#tablediv").show();          
	 });      
});
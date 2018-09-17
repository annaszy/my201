<!DOCTYPE html>
<html lang="en">
  <head>
  
  	<!-- do i need this part for back end -->
  	<script
  src="https://code.jquery.com/jquery-3.3.1.js"
  integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60="
  crossorigin="anonymous"></script>
  
  	<link rel="stylesheet" href="signin.css" />
    <meta name="google-signin-scope" content="profile email">
    <meta name="google-signin-client_id" content="327794825592-d502jq1gd9c1mr9ibijs2sc428qo8bot.apps.googleusercontent.com">
    <title>Log In</title>
    <script src="https://apis.google.com/js/platform.js" async defer></script>
  </head>
  <body>
  	
  	<div class="top"></div> 

  	<table id="logintable" >
  		<tr >
  			<td align="center">
  				<img id="leaf" src="transparentleaf.png" alt="Sycamore Leaf"></img>
  			</td>
  			
  			<td align="center">
  				<div id="name">Sycamore Calendar</div>
  				<div id="google_sign-in" class="g-signin2" data-onsuccess="onSignIn" data-theme="light"></div>
  			</td>
  		</tr>
  	</table>
  	
  	<div id = "googleid">
  	</div>
  	<br>
  	<br>
  	<br>
  	<div id = "accesstoken">
  	</div>
  		
  	
  

  		
    
    <script>
      function onSignIn(googleUser) {
    	  
    	  function sendResults(){
        	  
        	  
        	  
    	        // Useful data for your client-side scripts:
    	        var profile = googleUser.getBasicProfile();
    	        console.log("ID: " + profile.getId()); // Don't send this directly to your server!
    	        console.log('Full Name: ' + profile.getName());
    	        console.log('Given Name: ' + profile.getGivenName());
    	        console.log('Family Name: ' + profile.getFamilyName());
    	        console.log("Image URL: " + profile.getImageUrl());
    	        console.log("Email: " + profile.getEmail());

    	        
    	       
    	            
    	      
    	        
    	        var access_token = googleUser.getAuthResponse().access_token;
    	          	        
    	        sessionStorage.setItem('imageurl', profile.getImageUrl());
    	        
    	     // The ID token you need to pass to your backend:
    	        var id_token = googleUser.getAuthResponse().id_token;
    	        console.log("ID Token: " + id_token);
    	        var requeststr= "thislilservlet?";
    	       requeststr += "myid="+profile.getId();
    	       requeststr += "&myaccesstoken="+ access_token;
    	       console.log(requeststr);
    	       var xhttp = new XMLHttpRequest();
    	       xhttp.open("GET", requeststr, false);
    	       xhttp.send();
    	  }
    	  
    	  if(googleUser.hasGrantedScopes('https://www.googleapis.com/auth/calendar'))
    	  {
    	      console.log("we have already been granted the Calendar scope!");
    	      sendResults();
    	  }
    	  else
    	  {
    	     googleUser.grant({'scope':'https://www.googleapis.com/auth/calendar'}).then(function(){
    	    	 setTimeout(sendResults, 500);
    	     });
    	  }

      };
    </script>
    
    <!-- -------------------------------------------------------------------------------------------------------- 

  	sessionStorage.setItem("id", "profile.getId()");
  	sessionStorage.setItem("fullname","profile.getName()");
  	sessionStorage.setItem("givenname", "profile.getGivenName()");
  	sessionStorage.setItem("familyname", "profile.getFamilyName()");
  	sessionStorage.setItem("imageurl", "profile.getImageUrl()");
  	sessionStorage.setItem("email","profile.getEmail()");
  	
  	
  	-------------------------------------------------------------------------------------------------------- -->
  	
  	<div id="bottomofpage"></div> 
  
    
  </body>
</html>
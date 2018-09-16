
<!-- make sure it says signed in instead of sign in -->

<!DOCTYPE html>
<html>
		
	<head>
		<link rel="stylesheet" href="signin.css" />
		<meta name="google-signin-scope" content="profile email">
    	<meta name="google-signin-client_id" content="327794825592-d502jq1gd9c1mr9ibijs2sc428qo8bot.apps.googleusercontent.com">
		<meta charset="UTF-8">
		<title>Logged In</title>
		<script src="https://apis.google.com/js/platform.js" async defer></script>
	</head>
	<body>
	
	<div class="top">
		<table id="loggedintable" style="width:100%;">
			<tr id= "littr">
				<td class="littd" style="width:70%;"/>
				<td class="littd" style="width:100px; width:15%;"><a href= "linktoprofilepage.html">Profile</a></td>
				<td class="littd" style="width:100px; width:15%;"><a href= "linktohomepage.html" >Home</a></td>
			</tr>
		</table>
	</div> 
	
	<table id="logintable" >
  		<tr >
  			<td align="center">
  				<img id="leaf" src="transparentleaf.png" alt="Sycamore Leaf"></img>
  			</td>
  			
  			<td align="center">
  				<div id="name">Sycamore Calendar</div>
  				<div class="g-signin2" data-onsuccess="onSignIn" data-theme="light"></div>
  			</td>
  		</tr>
  	</table>
	
	
	<div id="bottomofpage"></div> 

	</body>
</html>
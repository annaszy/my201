<!DOCTYPE html>
<html>
  

	<head>

		<link rel="stylesheet" href="signin.css" />
		<meta charset="UTF-8">
		<title>Profile</title>
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
  
  	
  	<br>
  	<br>
  	<br>
  	<br>
  	<br>
  	<br>
  	<br>
  	
  	
  	<div>
  	
	    <p>Google Calendar API Quickstart</p>
	
	    <!--Add buttons to initiate auth sequence and sign out-->
	    <button id="authorize_button" style="display: none;">Authorize</button>
	    <button id="signout_button" style="display: none;">Sign Out</button>
	
	    <pre id="content"></pre>
	
	    <script type="text/javascript">
	      // Client ID and API key from the Developer Console
	      var CLIENT_ID = '327794825592-d502jq1gd9c1mr9ibijs2sc428qo8bot.apps.googleusercontent.com';
	      var API_KEY = 'AIzaSyAKO_l51jSseerfNUZX0BQLz6gW7dAROkg';
	
	      // Array of API discovery doc URLs for APIs used by the quickstart
	      var DISCOVERY_DOCS = ["https://www.googleapis.com/discovery/v1/apis/calendar/v3/rest"];
	
	      // Authorization scopes required by the API; multiple scopes can be
	      // included, separated by spaces.
	      var SCOPES = "https://www.googleapis.com/auth/calendar.readonly";
	
	      var authorizeButton = document.getElementById('authorize_button');
	      var signoutButton = document.getElementById('signout_button');
	
	      /**
	       *  On load, called to load the auth2 library and API client library.
	       */
	      function handleClientLoad() {
	        gapi.load('client:auth2', initClient);
	      }
	
	      /**
	       *  Initializes the API client library and sets up sign-in state
	       *  listeners.
	       */
	      function initClient() {
	        gapi.client.init({
	          apiKey: API_KEY,
	          clientId: CLIENT_ID,
	          discoveryDocs: DISCOVERY_DOCS,
	          scope: SCOPES
	        }).then(function () {
	          // Listen for sign-in state changes.
	          gapi.auth2.getAuthInstance().isSignedIn.listen(updateSigninStatus);
	
	          // Handle the initial sign-in state.
	          updateSigninStatus(gapi.auth2.getAuthInstance().isSignedIn.get());
	          authorizeButton.onclick = handleAuthClick;
	          signoutButton.onclick = handleSignoutClick;
	        });
	      }
	
	      /**
	       *  Called when the signed in status changes, to update the UI
	       *  appropriately. After a sign-in, the API is called.
	       */
	      function updateSigninStatus(isSignedIn) {
	        if (isSignedIn) {
	          authorizeButton.style.display = 'none';
	          signoutButton.style.display = 'block';
	          listUpcomingEvents();
	        } else {
	          authorizeButton.style.display = 'block';
	          signoutButton.style.display = 'none';
	        }
	      }
	
	      /**
	       *  Sign in the user upon button click.
	       */
	      function handleAuthClick(event) {
	        gapi.auth2.getAuthInstance().signIn();
	      }
	
	      /**
	       *  Sign out the user upon button click.
	       */
	      function handleSignoutClick(event) {
	        gapi.auth2.getAuthInstance().signOut();
	      }
	
	      /**
	       * Append a pre element to the body containing the given message
	       * as its text node. Used to display the results of the API call.
	       *
	       * @param {string} message Text to be placed in pre element.
	       */
	      function appendPre(message) {
	        var pre = document.getElementById('content');
	        var textContent = document.createTextNode(message + '\n');
	        pre.appendChild(textContent);
	      }
	
	      /**
	       * Print the summary and start datetime/date of the next ten events in
	       * the authorized user's calendar. If no events are found an
	       * appropriate message is printed.
	       */
	      function listUpcomingEvents() {
	        gapi.client.calendar.events.list({
	          'calendarId': 'primary',
	          'timeMin': (new Date()).toISOString(),
	          'showDeleted': false,
	          'singleEvents': true,
	          'maxResults': 10,
	          'orderBy': 'startTime'
	        }).then(function(response) {
	          var events = response.result.items;
	          appendPre('Upcoming events:');
	
	          if (events.length > 0) {
	            for (i = 0; i < events.length; i++) {
	              var event = events[i];
	              var when = event.start.dateTime;
	              if (!when) {
	                when = event.start.date;
	              }
	              appendPre(event.summary + ' (' + when + ')')
	            }
	          } else {
	            appendPre('No upcoming events found.');
	          }
	        });
	      }
	
	    </script>
	
	    <script async defer src="https://apis.google.com/js/api.js"
	      onload="this.onload=function(){};handleClientLoad()"
	      onreadystatechange="if (this.readyState === 'complete') this.onload()">
	    </script>
    
    
    </div>
    
    
    
  </body>
</html>
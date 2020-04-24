localhost:8082/oauth/token
Authorization ->
 BasicAuth: 
	username: app1
	password: pass
Body -> 
	form-data	
		grant_type password
		username email.com
		password pass
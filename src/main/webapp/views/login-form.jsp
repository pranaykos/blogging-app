<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<title>Please sign in</title>
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M"
	crossorigin="anonymous">
<link
	href="https://getbootstrap.com/docs/4.0/examples/signin/signin.css"
	rel="stylesheet" crossorigin="anonymous" />
</head>
<body>


	${SPRING_SECURITY_LAST_EXCEPTION.message}

	<div class="container">


		<div class="row">
			<div class="w-25 mx-auto my-4">
				<form class="form-signin" method="post" action="/login">
					<h2 class="form-signin-heading display-4 my-4">Sign In</h2>
					<p>
						<label for="username" class="sr-only">Username</label> <input
							type="text" id="username" name="username" class="form-control"
							placeholder="Username" required autofocus>
					</p>
					<p>
						<label for="password" class="sr-only">Secret Password</label> <input
							type="password" id="password" name="password"
							class="form-control" placeholder="Password" required>
					</p>

					<p class="form-check my-3">
							<input  type="checkbox" value=""
								name="remember-me" id="remember-me">
							</input>
							<label class="form-check-label" for="remember-me">
								    Remember Me
							</label>
								  
					</p>
				
					
					<button class="btn btn-outline-primary btn-block" type="submit">Sign
						in</button>
		</form>
			</div>
		</div>
	
	
		
	</div>
</body>
</html>
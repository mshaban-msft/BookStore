<!DOCTYPE html>
<html>
	
	<!-- *********************************************** -->
	<!-- DEFINE HEADER -->
	<!-- *********************************************** -->
	<head>
		<link rel="stylesheet" href="http://www.w3schools.com/lib/w3.css">
		<link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.6.3/css/font-awesome.min.css">
		
		<style>
			.sh-btn
			{
				
			}
		</style>
	</head>
	

	<!-- *********************************************** -->
	<!-- DEFINE BODY -->
	<!-- *********************************************** -->
	<body class="w3-container w3-dark-grey">

		<div id="signin_modal" class="w3-modal">

			<form action="/Library/signin/submit" method="POST" class="w3-modal-content w3-animate-zoom w3-card-12" style="width:400px; overflow:hidden;">
			
				<header class="w3-container w3-teal">
					<h2 class="w3-xlarge">
						<i class="fa fa-user w3-margin-right w3-margin-left w3-xlarge"></i>
						Account Login
					</h2>
				</header>

				<div class="w3-container w3-red" id="error_msg">
					Incorrect UserName or Password
				</div>
				 
				<div class="w3-container" style="margin-left:15px; margin-right:15px;">
					<div style="padding-top: 10px;">
						<label class="w3-text-grey"><b>Email</b></label>
						<input type="email" class="w3-input w3-border" placeholder="userID@provider.domain" name="email" />
					</div>
					<div style="padding-top: 10px;">
						<label class="w3-text-grey"><b>Password</b></label>
						<input type="password" class="w3-input w3-border" placeholder="1234567890" name="password" />
					</div>

					<div class="w3-center" style="padding-top: 15px;">
						<button class="w3-btn w3-green w3-margin-bottom w3-round-xxlarge w3-ripple w3-padding-8" style="width:100px;" name="signin_btn" type="submit" value = "signin" >Sign In</button>
						<button class="w3-btn w3-dark-grey w3-margin-bottom w3-round-xxlarge w3-ripple w3-padding-8" style="width:100px;" name="signup_btn" type="submit" value = "signup" formaction="/Library/signup">Sign Up</button>
					</div>
				</div>
			</form>

		</div>

	</body>


	<!-- *********************************************** -->
	<!-- POST-LOADING SCRIPTS -->
	<!-- *********************************************** -->
	<script>
		document.getElementById('signin_modal').style.display='block';
		document.getElementById('error_msg').style.display='none';
		if('${error}' != '#')
		{
			document.getElementById('error_msg').style.display='block';
		}
	</script>

</html>


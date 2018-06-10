<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>


<html>

	<!-- *********************************************** -->
	<!-- DEFINE HEADER -->
	<!-- *********************************************** -->
	<head>
		<link rel="stylesheet" href="http://www.w3schools.com/lib/w3.css">
	</head>

	<style>
		
		.sh-form
		{
			width: 600px; padding-top: 0px; padding-bottom: 20px; padding-left: 0px; margin-top:10px; margin-left:26%;
		}

		.sh-label
		{
			width: 100px; padding-top: 8px; padding-right: 10px; text-align: right;
		}

	</style>

	<!-- *********************************************** -->
	<!-- DEFINE BODY -->
	<!-- *********************************************** -->
	<body style="background-color: #FFFFF0;">

		<!-- navigation bar -->
		<ul class="w3-navbar w3-blue-grey w3-card-2">
			<p style="text-align: center;">CREATE NEW ACCOUNT</p>
		</ul>

		<!-- adjust spacing -->
		<div style="padding: 5px;">
			
		</div>



		<!-- signup form -->
		<div id="form_container" class="sh-form" style="display: table; margin: 0 auto;">

			<div class="w3-red" id="error_msg" style="padding:10px;">
					${error}
			</div>

			<form action="/Library/signup/submit" method="POST" style="padding-left:5px; padding-top:25px;">
			

				<!-- user name -->
				<div class="w3-row" style="padding: 10px;">
					<div class="w3-col sh-label">
						<label class="w3-label" style="text-align: right;" >User Name</label>
					</div>

					<div class="w3-col" style="width: 400px;">
						<input type="text" class="w3-input w3-border" name ="userName"/>
					</div>
				</div>

				<!-- password -->
				<div class="w3-row" style="padding: 10px;">
					<div class="w3-col sh-label">
						<label class="w3-label">Password</label>
					</div>

					<div class="w3-col" style="width: 400px;">
						<input type="password" class="w3-input w3-border"  name = "password" />
					</div>
				</div>

				<!-- first name -->
				<div class="w3-row" style="padding: 10px;">
					<div class="w3-col sh-label">
						<label class="w3-label">First Name</label>
					</div>

					<div class="w3-col" style="width: 400px;">
						<input type="text" class="w3-input w3-border" name = "firstName" />
					</div>
				</div>

				<!-- last name -->
				<div class="w3-row" style="padding: 10px;">
					<div class="w3-col sh-label">
						<label class="w3-label">Last Name</label>
					</div>

					<div class="w3-col" style="width: 400px;">
						<input type="text" class="w3-input w3-border" name = "lastName" />
					</div>
				</div>

				<!-- user email -->
				<div class="w3-row" style="padding: 10px;">
					<div class="w3-col sh-label">
						<label class="w3-label">Email</label>
					</div>

					<div class="w3-col" style="width: 400px;">
						<input type="email" class="w3-input w3-border"  name = "email" />
					</div>
				</div>

				<!-- user phone -->
				<div class="w3-row" style="padding: 10px;">
					<div class="w3-col sh-label">
						<label class="w3-label">Phone</label>
					</div>

					<div class="w3-col" style="width: 400px;">
						<input type="text" class="w3-input w3-border"  name = "phone"/>
					</div>
				</div>

				<!-- shipping address -->
				<div class="w3-row" style="padding: 10px;">
					<div class="w3-col sh-label">
						<label class="w3-label">Address</label>
					</div>

					<div class="w3-col" style="width: 400px;">
						<input type="text" class="w3-input w3-border"  name ="address" />
					</div>
				</div>

				<div class="w3-container" style="margin-top:5px;">
					<button class="w3-btn w3-right w3-green" style="margin-right: 69px;" name="signup_btn" type="submit" value = "signup" >Sign Up</button>
				</div>



			</form>

		</div>


	</body>

	<!-- *********************************************** -->
	<!-- POST-LOADING SCRIPTS -->
	<!-- *********************************************** -->
	<script>
	
		document.getElementById('error_msg').style.display='none';
		/*if('${error}' != '#')
		{
			document.getElementById('error_msg').style.display='block';
		}*/
		
	</script>

</html>
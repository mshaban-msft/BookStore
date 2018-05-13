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
			width: 600px; padding-top: 40px; padding-bottom: 20px; padding-left: 20px;
		}

		.sh-label
		{
			width: 100px; padding-top: 8px; padding-right: 10px; text-align: right;
		}

	</style>

	<!-- *********************************************** -->
	<!-- DEFINE BODY -->
	<!-- *********************************************** -->
	<body>

		<!-- navigation bar -->
		<ul class="w3-navbar w3-teal w3-card-2">
			<p style="text-align: center;">CREATE NEW ACCOUNT</p>
		</ul>




		<!-- signup form -->
		<div id="form_container" style="padding-left: 27%;">

			<form action="/Library/signup/submit" method="POST" class="sh-form w3-card-2 w3-margin-top">
			
				<div class="w3-container w3-red" id="error_msg">
						${error}
				</div>

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

				<button class="w3-btn w3-margin-top w3-margin-bottom w3-green" style="margin-left: 425px;" name="signup_btn" type="submit" value = "signup" >Sign Up</button>

			</form>

		</div>


	</body>

	<!-- *********************************************** -->
	<!-- POST-LOADING SCRIPTS -->
	<!-- *********************************************** -->
	<script>
	
		document.getElementById('error_msg').style.display='none';
		if('${error}' != '#')
		{
			document.getElementById('error_msg').style.display='block';
		}
		
	</script>

</html>
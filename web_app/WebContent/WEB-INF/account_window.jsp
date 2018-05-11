<!DOCTYPE html>
<html>
	
	<!-- *********************************************** -->
	<!-- DEFINE HEADER -->
	<!-- *********************************************** -->
	<head>
		<link rel="stylesheet" href="http://www.w3schools.com/lib/w3.css">
		<link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.6.3/css/font-awesome.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
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
	</head>
	

	<!-- *********************************************** -->
	<!-- DEFINE BODY -->
	<!-- *********************************************** -->
	<body>
		<!--top nav bar-->
		<div class="w3-top" id="bar_toggle">
			<ul class="w3-navbar w3-teal w3-card-2" style="min-width:1100px">
				<li><a href="#" class="w3-hover-teal" style="padding-top:15px; padding-bottom:15px" onclick="handleSideNav()"><i class="fa fa-bars w3-xlarge"></i></a></li>
				<li><a href="#" class="w3-padding-16 w3-hover-teal">My Account</a></li>
			</ul>
		</div>
		
		<!-- side tabs -->
		<nav class="w3-sidenav w3-white w3-card-2 w3-light-grey w3-animate-left" style="width:250px; margin-top:57px; display:none" id="SideNav01">
			<div class="w3-container">
				<h3>M-Shaban</h3>
			</div>
		  
			<a href="#" onclick="$('#home_hidden_form').submit(); return false;">HOME</a>
			<a href="#" class="w3-green">ACCOUNT</a>
			<a href="#" onclick="$('#cart_hidden_form').submit(); return false;" >SHOPPING CART</a>
			<a href="#" onclick="$('#orders_hidden_form').submit(); return false;">MY ORDERS</a>
			<a href="#" onclick="$('#publisher_orders_hidden_form').submit(); return false;">PUBLISHER ORDERS</a>
			<a href="#" onclick="$('#signout_hidden_form').submit(); return false;">SIGN OUT</a>
		</nav>
		
		<!-- page content -->
		<div class="w3-container">
			<div style="height:55px;">
			</div>
			
			<!-- account info -->
			<form id="form_container" style="padding-left: 25%;" action = "/Library/account/edit" method ="post">
			<div class="sh-form w3-card-2 w3-margin-top" >

				<!-- account info -->
				<div class="w3-row" style="padding: 10px;">
					<div class="w3-col sh-label">
						<label class="w3-label" style="text-align: right;" >User Name</label>
					</div>

					<div class="w3-col" style="width: 400px;">
						<input type="text" class="w3-input w3-border sh-input" name ="userName" />
					</div>
				</div>

				<!-- password -->
				<div class="w3-row" style="padding: 10px;">
					<div class="w3-col sh-label">
						<label class="w3-label">Password</label>
					</div>

					<div class="w3-col" style="width: 400px;">
						<input type="password" class="w3-input w3-border sh-input" required name = "password" />
					</div>
				</div>

				<!-- first name -->
				<div class="w3-row" style="padding: 10px;">
					<div class="w3-col sh-label">
						<label class="w3-label">First Name</label>
					</div>

					<div class="w3-col" style="width: 400px;">
						<input type="text" class="w3-input w3-border sh-input" required name = "firstName" />
					</div>
				</div>

				<!-- last name -->
				<div class="w3-row" style="padding: 10px;">
					<div class="w3-col sh-label">
						<label class="w3-label">Last Name</label>
					</div>

					<div class="w3-col" style="width: 400px;">
						<input type="text" class="w3-input w3-border sh-input" required name = "lastName" />
					</div>
				</div>

				<!-- user email -->
				<div class="w3-row" style="padding: 10px;">
					<div class="w3-col sh-label">
						<label class="w3-label">Email</label>
					</div>

					<div class="w3-col" style="width: 400px;">
						<input type="text" class="w3-input w3-border sh-input" required name = "email" />
					</div>
				</div>

				<!-- user phone -->
				<div class="w3-row" style="padding: 10px;">
					<div class="w3-col sh-label">
						<label class="w3-label">Phone</label>
					</div>

					<div class="w3-col" style="width: 400px;">
						<input type="text" class="w3-input w3-border sh-input" required name = "phone" />
					</div>
				</div>

				<!-- shipping address -->
				<div class="w3-row" style="padding: 10px;">
					<div class="w3-col sh-label">
						<label class="w3-label">Address</label>
					</div>

					<div class="w3-col" style="width: 400px;">
						<input type="text" class="w3-input w3-border sh-input" required name ="address" />
					</div>
				</div>

				<div class="w3-container" style="margin-top:10px; margin-bottom: 10px; padding-right: 70px;" >
					<button id="edit_data_btn" class="w3-btn w3-green w3-right" style="width: 80px;" >Edit</button>
					<button id="update_info_btn" class="w3-btn w3-blue w3-right w3-margin-right" style="width: 80px;" >Update</button>
				</div>

			</div>

			</form>


			
		</div>




		<!-- handling site navigation (hidden forms) -->
		<form id="home_hidden_form" action="/Library/home" method="get" style="display: none">
		  <input type="hidden" name="myParameterName" value="myParameterValue">
		</form>

		<form id="cart_hidden_form" action="/Library/cart" method="post" style="display: none">
		  <input type="hidden" name="myParameterName" value="myParameterValue">
		</form>

		<form id="orders_hidden_form" action="/Library/orders" method="post" style="display: none">
		  <input type="hidden" name="myParameterName" value="myParameterValue">
		</form>

		<form id="publisher_orders_hidden_form" action="/Library/publiser_orders" method="get" style="display: none">
		  <input type="hidden" name="myParameterName" value="myParameterValue">
		</form>

		<form id="signout_hidden_form" action="/Library/signin" method="get" style="display: none">
		  <input type="hidden" name="myParameterName" value="myParameterValue">
		</form>



		
	</body>
	
	<!-- *********************************************** -->
	<!-- POST-LOADING SCRIPTS -->
	<!-- *********************************************** -->
	<script>

		document.getElementById("edit_data_btn").addEventListener("click", function(event){
		    event.preventDefault();
		    toggle_disabled();
		});


		/* post-load script */
		var disabled_flag = true;
		var x = document.getElementsByClassName("sh-input");
		var i;
		for (i = 0; i < x.length; i++) {
			x[i].disabled = true;
		}	

		document.getElementById('update_info_btn').style.display='none';

		/* DOM manipulation functions */
		function handleSideNav(){
			var x=document.getElementById("SideNav01");
			if (x.className.indexOf("w3-show") == -1) {
				x.className += " w3-show";
			} else {
				x.className = x.className.replace(" w3-show", "");
			}
		}

		function toggle_disabled()
		{
			if(disabled_flag == true){
				disabled_flag = false;
				document.getElementById("edit_data_btn").innerHTML = "Cancel";
				document.getElementById('update_info_btn').style.display='block';
			}
			else{
				disabled_flag = true;
				document.getElementById("edit_data_btn").innerHTML = "Edit";
				document.getElementById('update_info_btn').style.display='none';
			}
			
			for (i = 0; i < x.length; i++) {
			    x[i].disabled = disabled_flag;
			}	
		}

		

	</script>
	
</html>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
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
				width: 600px; padding-top: 0px; padding-bottom: 20px; padding-left: 20px; margin-top: 25px;
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
	<body style="background-color: #FFFFF0;">
		
		<!-- side tabs -->
		<nav class="w3-sidenav w3-card-2 w3-light-grey" style="width:250px">
			<div class="w3-blue-grey w3-padding-16" style="padding-left: 37px;">
				<a href="#" class="w3-hover-blue-grey w3-xlarge" onclick="$('#home_hidden_form').submit(); return false;" >Amazon.com</a>
			</div>
		  
		  	<div class="w3-container" style="padding-top: 20px; font-weight: bold; padding-bottom: 10px;"> M-Shaban </div>
			<a href="#" onclick="$('#home_hidden_form').submit(); return false;">HOME</a>
			<a href="#" class="w3-blue-grey">ACCOUNT</a>
			<a href="#" onclick="$('#cart_hidden_form').submit(); return false;" >SHOPPING CART</a>
			<a href="#" onclick="$('#orders_hidden_form').submit(); return false;">MY ORDERS</a>
			<a href="#" onclick="$('#signout_hidden_form').submit(); return false;">SIGN OUT</a>

			<div id="admin_rights">
				<div class="w3-container" style="padding-top: 20px; font-weight: bold; padding-bottom: 5px;"> Admin Controls </div>
				<a href="#" onclick="$('#manage_books_hidden_form').submit(); return false;">Manage Inventory</a>
				<a href="#" onclick="$('#manage_publishers_hidden_form').submit(); return false;">Manage Publishers</a>
				<a href="#" onclick="$('#publisher_orders_hidden_form').submit(); return false;">Publisher Orders</a>
				<a href="#" onclick="$('#user_accounts_hidden_form').submit(); return false;">User Accounts</a>
			</div>
		</nav>
		
		<!-- page content -->
		<div class="w3-container" style="margin-left: 250px; padding-left: 0px;">
			<div style="height:20px;">
			</div>

			<!--search and title-->
			<div class="w3-container w3-center" style="margin-bottom:10px;">
				<span class="w3-text-blue-grey" style="font-size:27px; font-weight:bold; font-family: arial;">Account Info</span>
			</div>
			
			<!-- account info -->
			<form id="form_container" style="display: table; margin: 0 auto;" action = "/Library/account/edit" method ="post">
			<div class="sh-form">

				<!-- account info -->
				<div class="w3-row" style="padding: 10px;">
					<div class="w3-col sh-label">
						<label class="w3-label" style="text-align: right;" >User Name</label>
					</div>

					<div class="w3-col" style="width: 400px;">
						<input type="text" class="w3-input w3-border sh-input" required name ="userName" id="userName" />
					</div>
				</div>

				<!-- password -->
				<div class="w3-row" style="padding: 10px;">
					<div class="w3-col sh-label">
						<label class="w3-label">Password</label>
					</div>

					<div class="w3-col" style="width: 400px;">
						<input type="password" class="w3-input w3-border sh-input" required name = "password" id="password" />
					</div>
				</div>

				<!-- first name -->
				<div class="w3-row" style="padding: 10px;">
					<div class="w3-col sh-label">
						<label class="w3-label">First Name</label>
					</div>

					<div class="w3-col" style="width: 400px;">
						<input type="text" class="w3-input w3-border sh-input" required name = "firstName" id="firstName" />
					</div>
				</div>

				<!-- last name -->
				<div class="w3-row" style="padding: 10px;">
					<div class="w3-col sh-label">
						<label class="w3-label">Last Name</label>
					</div>

					<div class="w3-col" style="width: 400px;">
						<input type="text" class="w3-input w3-border sh-input" required name = "lastName" id="lastName" />
					</div>
				</div>

				<!-- user email -->
				<div class="w3-row" style="padding: 10px;">
					<div class="w3-col sh-label">
						<label class="w3-label">Email</label>
					</div>

					<div class="w3-col" style="width: 400px;">
						<input type="text" class="w3-input w3-border sh-input" required name = "email" id="email" />
					</div>
				</div>

				<!-- user phone -->
				<div class="w3-row" style="padding: 10px;">
					<div class="w3-col sh-label">
						<label class="w3-label">Phone</label>
					</div>

					<div class="w3-col" style="width: 400px;">
						<input type="text" class="w3-input w3-border sh-input" required name = "phone" id="phone" />
					</div>
				</div>

				<!-- shipping address -->
				<div class="w3-row" style="padding: 10px;">
					<div class="w3-col sh-label">
						<label class="w3-label">Address</label>
					</div>

					<div class="w3-col" style="width: 400px;">
						<input type="text" class="w3-input w3-border sh-input" required name ="address" id="address" />
					</div>
				</div>

				<div class="w3-container" style="margin-top:10px; margin-bottom: 10px; padding-right: 70px;" >
					<button id="edit_data_btn" class="w3-btn w3-teal w3-right" style="width: 80px;" >Edit</button>
					<button id="update_info_btn" class="w3-btn w3-red w3-right w3-margin-right" style="width: 80px;" >Update</button>
				</div>

			</div>

			</form>


			
		</div>




		<!-- handling site navigation (hidden forms) -->
		<form id="home_hidden_form" action="/Library/home" method="get" style="display: none">
		  <input type="hidden" name="myParameterName" value="myParameterValue">
		</form>

		<form id="cart_hidden_form" action="/Library/cart" method="get" style="display: none">
		  <input type="hidden" name="myParameterName" value="myParameterValue">
		</form>

		<form id="orders_hidden_form" action="/Library/orders" method="post" style="display: none">
		  <input type="hidden" name="myParameterName" value="myParameterValue">
		</form>

		<form id="signout_hidden_form" action="/Library/signin" method="get" style="display: none">
		  <input type="hidden" name="myParameterName" value="myParameterValue">
		</form>


		<form id="manage_books_hidden_form" action="/Library/manage_inventory" method="get" style="display: none">
		  <input type="hidden" name="x" value="">
		</form>

		<form id="manage_publishers_hidden_form" action="/Library/manage_publishers" method="get" style="display: none">
		  <input type="hidden" name="x" value="">
		</form>

		<form id="publisher_orders_hidden_form" action="/Library/publiser_orders" method="get" style="display: none">
		  <input type="hidden" name="x" value="">
		</form>

		<form id="user_accounts_hidden_form" action="/Library/manage_user_accounts" method="get" style="display: none">
		  <input type="hidden" name="x" value="">
		</form>



		
	</body>
	
	<!-- *********************************************** -->
	<!-- POST-LOADING SCRIPTS -->
	<!-- *********************************************** -->
	<script>

		/* show/hide admin controls */
		/******************************************/
		var user_name;
		var admin_rights = false;

		if(admin_rights == false){
			$("#admin_rights").remove();
		}


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
		function handle_side_nav(){
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


		document.getElementById("userName").value = "${signed_user.userName}";
		document.getElementById("address").value = "${signed_user.address}";
		document.getElementById("email").value = "${signed_user.email}";
		document.getElementById("phone").value = "${signed_user.phone}";
		document.getElementById("lastName").value = "${signed_user.lastName}";
		document.getElementById("firstName").value = "${signed_user.firstName}";
		document.getElementById("password").value = "${signed_user.password}";

		

	</script>
	
</html>
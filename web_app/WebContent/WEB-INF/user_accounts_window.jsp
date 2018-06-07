<!DOCTYPE html>
<html>
	
	<!-- *********************************************** -->
	<!-- DEFINE HEADER -->
	<!-- *********************************************** -->
	<head>
		<link rel="stylesheet" href="http://www.w3schools.com/lib/w3.css">
		<link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.6.3/css/font-awesome.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	</head>
	

	<!-- *********************************************** -->
	<!-- DEFINE BODY -->
	<!-- *********************************************** -->
	<body style="background-color: #FFFFF0;">
		<!--top nav bar-->
		<div class="w3-top" id="bar_toggle">
			<ul class="w3-navbar w3-blue-grey w3-card-2" style="min-width:1100px; padding-left:10px;">
				<li><a href="#" class="w3-blue-grey" style="padding-top:18px; padding-bottom:15px" onclick="handle_side_nav()"><i class="fa fa-bars w3-large"></i></a></li>
				<li><a href="#" class="w3-padding-16 w3-blue-grey" style="padding-left:3px;" >User Accounts</a></li>
			</ul>
		</div>
		
		<!-- side tabs -->
		<nav class="w3-sidenav w3-white w3-card-2 w3-light-grey w3-animate-left" style="width:250px; margin-top:55px; display:none" id="SideNav01">
			<div class="w3-container">
				<h3>M-Shaban</h3>
			</div>
		  
			<a href="#" onclick="$('#home_hidden_form').submit(); return false;">HOME</a>
			<a href="#" onclick="$('#account_hidden_form').submit(); return false;" >ACCOUNT</a>
			<a href="#" onclick="$('#shopping_cart_hidden_form').submit(); return false;" >SHOPPING CART</a>
			<a href="#" onclick="$('#orders_hidden_form').submit(); return false;">MY ORDERS</a>
			<a href="#" onclick="$('#signout_hidden_form').submit(); return false;">SIGN OUT</a>

			<div class="w3-container" style="padding-top: 20px; font-weight: bold; padding-bottom: 5px;"> Admin Controls </div>
			<a href="#" onclick="$('#manage_books_hidden_form').submit(); return false;">Manage Inventory</a>
			<a href="#" onclick="$('#manage_publishers_hidden_form').submit(); return false;">Manage Publishers</a>
			<a href="#" onclick="$('#publisher_orders_hidden_form').submit(); return false;">Publisher Orders</a>
			<a href="#" class="w3-blue-grey">User Accounts</a>
		</nav>
		
		<!-- page content -->
		<div class="w3-container">
			<div style="height:55px;">
			</div>
			

			<div class="w3-container w3-margin" style="padding-right:0px; padding-left: 0px;">
				<span class="w3-text-blue-grey" style="font-size:28px; font-weight:bold; font-family: arial;">Manage User Accounts</span>
			</div>

			<div class="w3-container">
			  <table class="w3-table-all">
			  	<!-- header -->
			    <thead>
			      <tr class="w3-dark-grey">
			        <th>Email</th>
			        <th>Account Type</th>
			        <th></th>
			      </tr>
			    </thead>
			    <!-- create rows -->
			    <tr>
			      <td>mohamed_shaapan@gmail.com</td>
			      <td>admin</td>
			      <th> <button class="w3-right" disabled 
				      onclick="select_account(0); $('#promote_hidden_form').submit(); return false;">
				      promote</button>
				  </th>
			    </tr>
			    <tr>
			      <td>santa_clause@northpole.com</td>
			      <td>customer</td>
			      <th> <button class="w3-right"
				      onclick="select_account(1); $('#promote_hidden_form').submit(); return false;">
				      promote</button>
				  </th>
			    </tr>

			  </table>
			</div>

			
		</div>


	<!-- handling site navigation (hidden forms) -->
	<form id="account_hidden_form" action="/Library/account" method="post" style="display: none">
	  <input type="hidden" name="myParameterName" value="myParameterValue">
	</form>

	<form id="home_hidden_form" action="/Library/home" method="get" style="display: none">
	  <input type="hidden" name="myParameterName" value="myParameterValue">
	</form>

	<form id="orders_hidden_form" action="/Library/orders" method="post" style="display: none">
	  <input type="hidden" name="myParameterName" value="myParameterValue">
	</form>

	<form id="publisher_orders_hidden_form" action="/Library/publiser_orders" method="post" style="display: none">
		  <input type="hidden" name="myParameterName" value="myParameterValue">
		</form>

	<form id="signout_hidden_form" action="/Library/signin" method="get" style="display: none">
	  <input type="hidden" name="myParameterName" value="myParameterValue">
	</form>

	<form id="checkout_hidden_form" action="/Library/checkout" method="post" style="display: none">
	  <input id="submit_qnt_book_1" type="hidden" name="book_1" value="1">
	</form>


	<form id="promote_hidden_form" action="/Library/home" method="get" style="display: none">
		  <input id="promote_account_index" type="hidden" name="selected_index" value="0">
	</form>
	


		
	</body>
	
	<!-- *********************************************** -->
	<!-- POST-LOADING SCRIPTS -->
	<!-- *********************************************** -->
	<script>

		function select_account(account_index)
		{
			document.getElementById('promote_account_index').value = account_index;
		}

		function handle_side_nav(){
			var x=document.getElementById("SideNav01");
			if (x.className.indexOf("w3-show") == -1) {
				x.className += " w3-show";
			} else {
				x.className = x.className.replace(" w3-show", "");
			}
		}

	</script>
	
</html>


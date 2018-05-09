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
			width: 600px; padding-top: 15px; padding-bottom: 10px; padding-left: 20px;
		}

		.sh-label
		{
			width: 100px; padding-top: 3px; padding-right: 10px; text-align: right;
		}

		.sh-input
		{
			height: 30px;
		}

		.sh-book-attr
		{
			padding: 5px;
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
				<li><a href="#" class="w3-padding-16 w3-hover-teal">Publisher Orders</a></li>
			</ul>
		</div>
		
		<!-- side tabs -->
		<nav class="w3-sidenav w3-white w3-card-2 w3-light-grey w3-animate-left" style="width:250px; margin-top:57px; display:none" id="SideNav01">
			<div class="w3-container">
				<h3>M-Shaban</h3>
			</div>
		  
			<a href="#" onclick="$('#home_hidden_form').submit(); return false;">HOME</a>
			<a href="#" onclick="$('#account_hidden_form').submit(); return false;" >ACCOUNT</a>
			<a href="#" onclick="$('#cart_hidden_form').submit(); return false;" >SHOPPING CART</a>
			<a href="#" onclick="$('#orders_hidden_form').submit(); return false;">MY ORDERS</a>
			<a href="#" class="w3-green">PUBLISHER ORDERS</a>
			<a href="#" onclick="$('#signout_hidden_form').submit(); return false;">SIGN OUT</a>
		</nav>
		
		<!-- page content -->
		<div class="w3-container">
			<div style="height:55px;">
			</div>
			

			<div class="w3-container w3-card-2 w3-margin w3-padding-8">
				<button class="w3-btn w3-teal" onclick="toggle_add_order_modal()">New Order</button>
				<button class="w3-btn w3-teal" onclick="toggle_edit_order_modal()">View Order</button>
			</div>

			<div class="w3-container">
			  <table class="w3-table-all w3-hoverable w3-card-2">
			  	<!-- header -->
			    <thead>
			      <tr class="w3-blue">
			        <th>First Name</th>
			        <th>Last Name</th>
			        <th>Points</th>
			      </tr>
			    </thead>
			    <!-- create rows -->
			    <tr>
			      <td>Jill</td>
			      <td>Smith</td>
			      <td>50</td>
			    </tr>
			    <tr>
			      <td>Eve</td>
			      <td>Jackson</td>
			      <td>94</td>
			    </tr>
			    <tr>
			      <td>Adam</td>
			      <td>Johnson</td>
			      <td>67</td>
			    </tr>
			  </table>
			</div>

			
		</div>


		<!-- new order modal -->
		<div id="new_order_modal" class="w3-modal">

			<div class="w3-modal-content w3-card-12" style="width:580px; overflow:hidden;">
			
				<header class="w3-container w3-teal">
					<h2 class="w3-xlarge">
						<i class="fa fa-plus w3-margin-left w3-large" style="margin-right: 10px;"></i>
						New Order
					</h2>
				</header>
				 

				<form class="sh-form" action="home_window.html" method="POST">

					<!-- user name -->
					<div class="w3-row sh-book-attr">
						<div class="w3-col sh-label">
							<label class="w3-label" style="text-align: right;" >ISBN</label>
						</div>

						<div class="w3-col" style="width: 400px;">
							<input type="text" class="w3-input w3-border sh-input"  />
						</div>
					</div>

					<!-- password -->
					<div class="w3-row sh-book-attr">
						<div class="w3-col sh-label">
							<label class="w3-label">Quantity</label>
						</div>

						<div class="w3-col" style="width: 400px;">
							<input type="password" class="w3-input w3-border sh-input"  />
						</div>
					</div>

					<!-- first name -->
					<div class="w3-row sh-book-attr">
						<div class="w3-col sh-label">
							<label class="w3-label">Date</label>
						</div>

						<div class="w3-col" style="width: 400px;">
							<input type="password" class="w3-input w3-border sh-input"  />
						</div>
					</div>

					<div class="w3-container" style="padding-top: 10px; padding-bottom: 10px;">
						<button class="w3-btn w3-green w3-right" style="margin-right: 60px;" type="submit" >Place Order</button>
						<button class="w3-btn w3-red w3-right" onclick="toggle_add_order_modal()" style="margin-right: 10px;" type="button">CANCEL</button>
					</div>
				</form>


			</div>
		</div>


		<!-- edit order modal -->
		<div id="edit_order_modal" class="w3-modal">

			<div class="w3-modal-content w3-card-12" style="width:580px; overflow:hidden;">
				 

				<header class="w3-container w3-teal">
					<h2 class="w3-xlarge">
						<i class="fa fa-barcode w3-margin-left w3-large" style="margin-right: 10px;"></i>
						View Order
					</h2>
				</header>

				<form class="sh-form" action="home_window.html" method="POST">

					<!-- user name -->
					<div class="w3-row sh-book-attr">
						<div class="w3-col sh-label">
							<label class="w3-label" style="text-align: right;" >ISBN</label>
						</div>

						<div class="w3-col" style="width: 400px;">
							<input type="text" class="w3-input w3-border sh-input sh-disable"  />
						</div>
					</div>

					<!-- password -->
					<div class="w3-row sh-book-attr">
						<div class="w3-col sh-label">
							<label class="w3-label">Quantity</label>
						</div>

						<div class="w3-col" style="width: 400px;">
							<input type="password" class="w3-input w3-border sh-input sh-disable"  />
						</div>
					</div>

					<!-- first name -->
					<div class="w3-row sh-book-attr">
						<div class="w3-col sh-label">
							<label class="w3-label">Date</label>
						</div>

						<div class="w3-col" style="width: 400px;">
							<input type="password" class="w3-input w3-border sh-input sh-disable"  />
						</div>
					</div>

					<div class="w3-container" style="padding-top: 10px; padding-bottom: 10px;">
						<button class="w3-btn w3-green w3-right" style="margin-right: 60px;" onclick="toggle_disabled()" type="button">
						Edit Order</button>
						<button class="w3-btn w3-red w3-right" onclick="toggle_edit_order_modal()" style="margin-right: 10px;" type="button">CANCEL</button>
					</div>
				</form>


			</div>
		</div>


		<!-- handling site navigation (hidden forms) -->
		<form id="home_hidden_form" action="/Library/home" method="get" style="display: none">
		  <input type="hidden" name="myParameterName" value="myParameterValue">
		</form>

		<form id="account_hidden_form" action="/Library/account" method="post" style="display: none">
		  <input type="hidden" name="myParameterName" value="myParameterValue">
		</form>

		<form id="cart_hidden_form" action="/Library/cart" method="post" style="display: none">
		  <input type="hidden" name="myParameterName" value="myParameterValue">
		</form>

		<form id="orders_hidden_form" action="/Library/orders" method="post" style="display: none">
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

		/* post-load scripts */
		var add_order_modal_shown = false;
		document.getElementById('new_order_modal').style.display='none';

		var edit_order_modal_shown = false;
		document.getElementById('edit_order_modal').style.display='none';

		var disabled_flag = true;
		var x = document.getElementsByClassName("sh-disable");
		var i;
		for (i = 0; i < x.length; i++) {
			x[i].disabled = true;
		}

		/* DOM manipulation functions */
		function handleSideNav(){
			var y=document.getElementById("SideNav01");
			if (y.className.indexOf("w3-show") == -1) {
				y.className += " w3-show";
			} else {
				y.className = y.className.replace(" w3-show", "");
			}
		}


		function toggle_add_order_modal()
		{
			if(add_order_modal_shown == true)
			{
				document.getElementById('new_order_modal').style.display='none';
				add_order_modal_shown = false;
			}else{
				document.getElementById('new_order_modal').style.display='block';
				add_order_modal_shown = true;
			}
		}

		function toggle_edit_order_modal()
		{
			if(edit_order_modal_shown == true)
			{
				document.getElementById('edit_order_modal').style.display='none';
				edit_order_modal_shown = false;
			}else{
				document.getElementById('edit_order_modal').style.display='block';
				edit_order_modal_shown = true;
			}
		}

		function toggle_disabled()
		{
			if(disabled_flag == true){disabled_flag = false;}
			else{disabled_flag = true;}
			
			for (i = 0; i < x.length; i++) {
			    x[i].disabled = disabled_flag;
			}	
		}

	</script>
	
</html>


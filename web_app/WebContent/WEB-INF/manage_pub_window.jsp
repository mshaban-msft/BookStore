<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

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
			width: 100px; padding-top: 8px; padding-right: 10px; text-align: right;
		}

		.sh-input
		{
			
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
	<body style="background-color: #FFFFF0;">
		
		<!-- side tabs -->
		<nav class="w3-sidenav w3-card-2 w3-light-grey" style="width:250px">
			<div class="w3-blue-grey w3-padding-8" style="padding-left: 47px;">
				<h3>Amazon.com</h3>
			</div>
		  
		  	<div class="w3-container" style="padding-top: 20px; font-weight: bold; padding-bottom: 10px;"> M-Shaban </div>
			<a href="#" onclick="$('#home_hidden_form').submit(); return false;">HOME</a>
			<a href="#" onclick="$('#account_hidden_form').submit(); return false;" >ACCOUNT</a>
			<a href="#" onclick="$('#cart_hidden_form').submit(); return false;" >SHOPPING CART</a>
			<a href="#" onclick="$('#orders_hidden_form').submit(); return false;">MY ORDERS</a>
			<a href="#" onclick="$('#signout_hidden_form').submit(); return false;">SIGN OUT</a>

			<div class="w3-container" style="padding-top: 20px; font-weight: bold; padding-bottom: 5px;"> Admin Controls </div>
			<a href="#" onclick="$('#manage_books_hidden_form').submit(); return false;">Manage Inventory</a>
			<a href="#" class="w3-blue-grey">Manage Publishers</a>
			<a href="#" onclick="$('#publisher_orders_hidden_form').submit(); return false;" >Publisher Orders</a>
			<a href="#" onclick="$('#user_accounts_hidden_form').submit(); return false;">User Accounts</a>
		</nav>
		
		<!-- page content -->
		<div class="w3-container" style="margin-left: 250px;">
			<div style="height:10px;">
			</div>
			

			<div class="w3-container w3-margin" style="padding-right: 0px; padding-left:0px;">
			<span class="w3-text-blue-grey" style="font-size:28px; font-weight:bold; font-family: arial;">Publisher Accounts</span>
				<button class="w3-btn w3-right w3-blue-grey" onclick="toggle_add_publisher_modal()">Add Publisher</button>
			</div>

			<div class="w3-container">
			  <table class="w3-table-all">
			  	<!-- header -->
			    <thead>
			      <tr class="w3-dark-grey">
			        <th>Publishing House</th>
			        <th>Address</th>
			        <th>Phone</th>
			      </tr>
			    </thead>

			    <!-- create rows -->
			    <c:forEach items="${publishers}" var="publisher">
				    <tr>
				        <td><c:out value="${publisher.name}"/></td>
				        <td><c:out value="${publisher.address}"/></td>
				        <td><c:out value="${publisher.phone}"/></td>
				    </tr>
				</c:forEach>
			  </table>
			</div>

			
		</div>


		<!-- new order modal -->
		<div id="add_publisher_modal" class="w3-modal">

			<div class="w3-modal-content w3-card-12 w3-animate-zoom" style="width:580px; overflow:hidden;">
			
				<header class="w3-container w3-blue-grey">
					<h2 class="w3-xlarge">
						<i class="fa fa-plus w3-margin-left w3-large" style="margin-right: 10px;"></i>
						Add Publisher
					</h2>
				</header>
				 

				<form class="sh-form" action="/Library/manage_publishers/add" method="POST">

					<!-- user name -->
					<div class="w3-row sh-book-attr">
						<div class="w3-col sh-label">
							<label class="w3-label" style="text-align: right;" >Name</label>
						</div>

						<div class="w3-col" style="width: 400px;">
							<input type="text" name="name" required class="w3-input w3-border sh-input"  />
						</div>
					</div>

					<!-- password -->
					<div class="w3-row sh-book-attr">
						<div class="w3-col sh-label">
							<label class="w3-label">Phone</label>
						</div>

						<div class="w3-col" style="width: 400px;">
							<input type="text" name="phone" required class="w3-input w3-border sh-input"  />
						</div>
					</div>

					<div class="w3-row sh-book-attr">
						<div class="w3-col sh-label">
							<label class="w3-label" style="text-align: right;" >address</label>
						</div>

						<div class="w3-col" style="width: 400px;">
							<input type="text" name="address" required class="w3-input w3-border sh-input"  />
						</div>
					</div>


					<div class="w3-container" style="padding-top: 10px; padding-bottom: 10px;">
						<button class="w3-btn w3-green w3-right" style="margin-right: 60px;" type="submit" >Add</button>
						<button id="cancel_btn" class="w3-btn w3-teal w3-right" style="margin-right: 10px;" >CANCEL</button>
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

		<form id="manage_books_hidden_form" action="/Library/manage_inventory" method="get" style="display: none">
		  <input type="hidden" name="x" value="">
		</form>

		<form id="publisher_orders_hidden_form" action="/Library/publiser_orders" method="get" style="display: none">
		  <input type="hidden" name="x" value="">
		</form>

		<form id="user_accounts_hidden_form" action="/Library/manage_user_accounts" method="get" style="display: none">
		  <input type="hidden" name="x" value="">
		</form>


		<form id="remove_publisher_hidden_form" action="/Library/manage_user_accounts" method="get" style="display: none">
		  <input id="selected_publisher_index" type="hidden" name="name" value="0">
		</form>



		
	</body>
	
	<!-- *********************************************** -->
	<!-- POST-LOADING SCRIPTS -->
	<!-- *********************************************** -->
	<script>

		/* confirm order */
		function select_publisher(selected_index)
		{
			document.getElementById('selected_publisher_index').value = selected_index;
		}

		/* new order modal */
		/************************************************/
		var add_publisher_modal = document.getElementById("add_publisher_modal");
		var cancel_btn = document.getElementById("cancel_btn");

		add_publisher_modal.style.display = 'none';
		var add_publisher_modal_shown = false;

		// When the user clicks anywhere outside of the modal, close it
		window.onclick = function(event) {
		  if (event.target == add_publisher_modal) {
		    add_publisher_modal.style.display = "none";
		  }
		}

		cancel_btn.addEventListener("click", function(event){
		    event.preventDefault();
		    toggle_add_publisher_modal();
		});

		function toggle_add_publisher_modal()
		{
			if(add_publisher_modal_shown == true)
			{
				add_publisher_modal.style.display='none';
				add_publisher_modal_shown = false;
			}else{
				add_publisher_modal.style.display='block';
				add_publisher_modal_shown = true;
			}
		}

		/* DOM manipulation functions */
		/************************************************/
		function handle_side_nav(){
			var y=document.getElementById("SideNav01");
			if (y.className.indexOf("w3-show") == -1) {
				y.className += " w3-show";
			} else {
				y.className = y.className.replace(" w3-show", "");
			}
		}

	</script>
	
</html>

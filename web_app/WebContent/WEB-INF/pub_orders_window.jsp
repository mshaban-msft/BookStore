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
		<!--top nav bar-->
		<div class="w3-top"">
			<ul class="w3-navbar w3-blue-grey w3-card-2" style="min-width:1100px; padding-left:10px;">
				<li><a href="#" class="w3-blue-grey" onclick="handle_side_nav()" style="padding-top:18px; padding-bottom:15px"><i class="fa fa-bars w3-large"></i></a></li>
				<li><a href="#" class="w3-padding-16 w3-blue-grey" style="padding-left:3px;" >Publisher Orders</a></li>
			</ul>
		</div>
		
		<!-- side tabs -->
		<nav class="w3-sidenav w3-white w3-card-2 w3-light-grey w3-animate-left" style="width:250px; margin-top:54px; display:none" id="SideNav01">
			<div class="w3-container">
				<h3>M-Shaban</h3>
			</div>
		  
			<a href="#" onclick="$('#home_hidden_form').submit(); return false;">HOME</a>
			<a href="#" onclick="$('#account_hidden_form').submit(); return false;" >ACCOUNT</a>
			<a href="#" onclick="$('#cart_hidden_form').submit(); return false;" >SHOPPING CART</a>
			<a href="#" onclick="$('#orders_hidden_form').submit(); return false;">MY ORDERS</a>
			<a href="#" onclick="$('#signout_hidden_form').submit(); return false;">SIGN OUT</a>

			<div class="w3-container" style="padding-top: 20px; font-weight: bold; padding-bottom: 5px;"> Admin Controls </div>
			<a href="#" onclick="$('#manage_books_hidden_form').submit(); return false;">Manage Inventory</a>
			<a href="#" onclick="$('#manage_publishers_hidden_form').submit(); return false;">Manage Publishers</a>
			<a href="#" class="w3-blue-grey" >Publisher Orders</a>
			<a href="#" onclick="$('#user_accounts_hidden_form').submit(); return false;">User Accounts</a>
		</nav>
		
		<!-- page content -->
		<div class="w3-container">
			<div style="height:55px;">
			</div>
			

			<div class="w3-container w3-margin" style="padding-right: 0px; padding-left:0px;">
			<span class="w3-text-blue-grey" style="font-size:28px; font-weight:bold; font-family: arial;">Manage Publisher Orders</span>
				<button class="w3-btn w3-right w3-blue-grey" onclick="toggle_new_order_modal()">New Order</button>
			</div>

			<div class="w3-container">
			  <table class="w3-table-all">
			  	<!-- header -->
			    <thead>
			      <tr class="w3-dark-grey">
			        <th>ISBN</th>
			        <th>Publisher name</th>
			        <th>Quantity</th>
			        <th></th>
			      </tr>
			    </thead>


			    <tr>
			        <td>12345678</td>
			        <td>Pearson</td>
			        <td>50,000</td>
			        <td> <button class="w3-right"
				      onclick="select_order(0); $('#confirm_order_hidden_form').submit(); return false;">
				      confirm</button>
				  	</td>
			    </tr>
			    <!-- create rows -->
			    <c:forEach items="${orders}" var="order">
				    <tr>
				        <td><c:out value="${order.isbn}"/></td>
				        <td><c:out value="${order.publisherName}"/></td>
				        <td><c:out value="${order.quantity}"/></td>
				        <td> <button class="w3-right"
					      onclick="select_order(1); $('#confirm_order_hidden_form').submit(); return false;">
					      confirm</button>
					  	</td>
				    </tr>
				</c:forEach>
			  </table>
			</div>

			
		</div>


		<!-- new order modal -->
		<div id="new_order_modal" class="w3-modal">

			<div class="w3-modal-content w3-card-12 w3-animate-zoom" style="width:580px; overflow:hidden;">
			
				<header class="w3-container w3-blue-grey">
					<h2 class="w3-xlarge">
						<i class="fa fa-plus w3-margin-left w3-large" style="margin-right: 10px;"></i>
						New Order
					</h2>
				</header>
				 

				<form class="sh-form" action="/Library/publiser_orders/add_order" method="POST">

					<!-- user name -->
					<div class="w3-row sh-book-attr">
						<div class="w3-col sh-label">
							<label class="w3-label" style="text-align: right;" >ISBN</label>
						</div>

						<div class="w3-col" style="width: 400px;">
							<input type="text" name="isbn" class="w3-input w3-border sh-input"  />
						</div>
					</div>

					<!-- password -->
					<div class="w3-row sh-book-attr">
						<div class="w3-col sh-label">
							<label class="w3-label">Quantity</label>
						</div>

						<div class="w3-col" style="width: 400px;">
							<input type="text" name="quantity" class="w3-input w3-border sh-input"  />
						</div>
					</div>

					<!-- first name -->
					<div class="w3-row sh-book-attr">
						<div class="w3-col sh-label">
							<label class="w3-label">Publisher</label>
						</div>

						<div class="w3-col" style="width: 400px;">
							<input type="text" name="publisherName" class="w3-input w3-border sh-input"  />
						</div>
					</div>

					<div class="w3-container" style="padding-top: 10px; padding-bottom: 10px;">
						<button class="w3-btn w3-green w3-right" style="margin-right: 60px;" type="submit" >Place Order</button>
						<button id="cancel_order_btn" class="w3-btn w3-teal w3-right" style="margin-right: 10px;" >CANCEL</button>
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


		<form id="confirm_order_hidden_form" action="/Library/signin" method="get" style="display: none">
		  <input id="selected_order_index" type="hidden" name="selected_order_index" value="myParameterValue">
		</form>



		
	</body>
	
	<!-- *********************************************** -->
	<!-- POST-LOADING SCRIPTS -->
	<!-- *********************************************** -->
	<script>

		/* confirm order */
		function select_order(selected_index)
		{
			document.getElementById('selected_order_index').value = selected_index;
		}

		/* new order modal */
		/************************************************/
		var new_order_modal = document.getElementById("new_order_modal");
		var cancel_order_btn = document.getElementById("cancel_order_btn");
		new_order_modal.style.display = 'none';
		var new_order_modal_shown = false;

		// When the user clicks anywhere outside of the modal, close it
		window.onclick = function(event) {
		  if (event.target == new_order_modal) {
		    new_order_modal.style.display = "none";
		  }
		}

		cancel_order_btn.addEventListener("click", function(event){
		    event.preventDefault();
		    toggle_new_order_modal();
		});

		function toggle_new_order_modal()
		{
			if(new_order_modal_shown == true)
			{
				new_order_modal.style.display='none';
				new_order_modal_shown = false;
			}else{
				new_order_modal.style.display='block';
				new_order_modal_shown = true;
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


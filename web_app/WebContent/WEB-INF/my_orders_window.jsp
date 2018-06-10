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
		  
		  	<div id="display_user_name" class="w3-container" style="padding-top: 20px; font-weight: bold; padding-bottom: 10px;"> User_Name </div>
			<a href="#" onclick="$('#home_hidden_form').submit(); return false;" >HOME</a>
			<a href="#" onclick="$('#account_hidden_form').submit(); return false;" >ACCOUNT</a>
			<a href="#" onclick="$('#cart_hidden_form').submit(); return false;" >SHOPPING CART</a>
			<a href="#" class="w3-blue-grey">MY ORDERS</a>
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
		<div class="w3-container" style="margin-left: 250px;">

			<!--search and title-->
			<div class="w3-container" style="margin-top:20px;">
				<span class="w3-text-blue-grey" style="font-size:27px; font-weight:bold; font-family: arial;">My Orders</span>
			</div>

			<div class="w3-container" style="margin-top: 10px;">
			  <table class="w3-table-all w3-hoverable">
			  	<!-- header -->
			    <thead>
			      <tr class="w3-dark-grey">
			        <th>ISBN</th>
			        <th>Title</th>
			        <th>Quantity</th>
			        <th>Date</th>
			      </tr>
			    </thead>
			    <!-- create rows -->
			    <c:forEach items = "${orders}" var = "order" varStatus = "status">
			    	<tr>
			    	 <td>"${order.isbn}"</td>
			    	 <td>"${order.title}"</td>
					 <td>"${order.quantity}"</td>
					 <td>"${order.date}"</td>
				    </tr>	
			    </c:forEach>
			    
			    
			  </table>
			</div>

			
		</div>


		<!-- handling site navigation (hidden forms) -->
		<form id="home_hidden_form" action="/Library/home" method="get" style="display: none">
		  <input type="hidden" name="myParameterName" value="myParameterValue">
		</form>

		<form id="account_hidden_form" action="/Library/account" method="post" style="display: none">
		  <input type="hidden" name="myParameterName" value="myParameterValue">
		</form>

		<form id="cart_hidden_form" action="/Library/cart" method="get" style="display: none">
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
		var display_user_name = '<c:out value="${user_name}"/>' ;
		var view_admin_rights = <c:out value="${admin_rights}"/> ;

		if(view_admin_rights == false){
			$("#admin_rights").remove();
		}

		$("#display_user_name").text(display_user_name);

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


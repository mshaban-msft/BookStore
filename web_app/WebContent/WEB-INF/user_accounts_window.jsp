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
		  
		  	<div class="w3-container" style="padding-top: 20px; font-weight: bold; padding-bottom: 10px;"> M-Shaban </div>
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
		<div class="w3-container" style="margin-left: 250px;">
			<div style="height:5px;">
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

			    
			    <c:forEach items="${users}" var="user" >
				    <tr>
				        <td><c:out value="${user.email}"/></td>
				        <td><c:out value="${user.userAdmin}"/></td>
				        <th> <button class="w3-right"
					       onclick="select_account('${user.email}'); $('#promote_hidden_form').submit(); return false;">
					       promote</button>
					   </th>
				    </tr>
				</c:forEach>
			    

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

	<form id="signout_hidden_form" action="/Library/signin" method="get" style="display: none">
	  <input type="hidden" name="myParameterName" value="myParameterValue">
	</form>

	<form id="checkout_hidden_form" action="/Library/checkout" method="post" style="display: none">
	  <input id="submit_qnt_book_1" type="hidden" name="book_1" value="1">
	</form>


	<form id="promote_hidden_form" action="/Library/manage_user_accounts/promote" method="post" style="display: none">
		  <input id="promote_account_index" type="hidden" name="email" value="0">
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

		function select_account(user_mail)
		{
			document.getElementById('promote_account_index').value = user_mail;
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


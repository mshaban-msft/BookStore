<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<<<<<<< HEAD

=======
>>>>>>> 37c6f3bd08258e3d59490ef974580c2f065e31df
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
<<<<<<< HEAD
		
=======
		<!--top nav bar-->
		<div class="w3-top" id="bar_toggle">
			<ul class="w3-navbar w3-blue-grey w3-card-2" style="min-width:1100px; padding-left:10px;">
				<li><a href="#" class="w3-blue-grey" style="padding-top:18px; padding-bottom:15px" onclick="handle_side_nav()"><i class="fa fa-bars w3-large"></i></a></li>
				<li><a href="#" class="w3-padding-16 w3-blue-grey" style="padding-left:3px;" >Shopping Cart</a></li>
			</ul>
		</div>
>>>>>>> 37c6f3bd08258e3d59490ef974580c2f065e31df
		
		<!-- side tabs -->
		<nav class="w3-sidenav w3-card-2 w3-light-grey" style="width:250px">
			<div class="w3-blue-grey w3-padding-16" style="padding-left: 37px;">
				<a href="#" class="w3-hover-blue-grey w3-xlarge" onclick="$('#home_hidden_form').submit(); return false;" >Amazon.com</a>
			</div>
		  
		  	<div class="w3-container" style="padding-top: 20px; font-weight: bold; padding-bottom: 10px;"> M-Shaban </div>
			<a href="#" onclick="$('#home_hidden_form').submit(); return false;">HOME</a>
			<a href="#" onclick="$('#account_hidden_form').submit(); return false;" >ACCOUNT</a>
			<a href="#" class="w3-blue-grey" >SHOPPING CART</a>
			<a href="#" onclick="$('#orders_hidden_form').submit(); return false;">MY ORDERS</a>
			<a href="#" onclick="$('#signout_hidden_form').submit(); return false;">SIGN OUT</a>

			<div class="w3-container" style="padding-top: 20px; font-weight: bold; padding-bottom: 5px;"> Admin Controls </div>
<<<<<<< HEAD
			<a href="#" onclick="$('#manage_books_hidden_form').submit(); return false;">MANAGE INVENTORY</a>
			<a href="#" onclick="$('#manage_publishers_hidden_form').submit(); return false;">MANAGE PUBLISHERS</a>
			<a href="#" onclick="$('#publisher_orders_hidden_form').submit(); return false;">PUBLISHER ORDERS</a>
			<a href="#" onclick="$('#user_accounts_hidden_form').submit(); return false;">USER ACCOUNTS</a>
=======
			<a href="#" onclick="$('#manage_books_hidden_form').submit(); return false;">Manage Inventory</a>
			<a href="#" onclick="$('#manage_publishers_hidden_form').submit(); return false;">Manage Publishers</a>
			<a href="#" onclick="$('#publisher_orders_hidden_form').submit(); return false;">Publisher Orders</a>
			<a href="#" onclick="$('#user_accounts_hidden_form').submit(); return false;">User Accounts</a>
>>>>>>> 37c6f3bd08258e3d59490ef974580c2f065e31df
		</nav>
		
		<!-- page content -->
		<form class="w3-container" action="/Library/checkout" method="get" style="margin-left:250px">
			<div style="height:10px;">
			</div>
			

			<div class="w3-container w3-margin" style="padding-right:0px; padding-left: 0px;">
				<span class="w3-text-blue-grey" style="font-size:25px; font-weight:bold; font-family: arial;">My Shopping Cart</span>
<<<<<<< HEAD
				<button class="w3-btn w3-teal w3-right" type="submit" >Checkout</button>
=======
				<button class="w3-btn w3-teal w3-right" onclick="update_qnt_values(); $('#checkout_hidden_form').submit(); return false;">Checkout</button>
>>>>>>> 37c6f3bd08258e3d59490ef974580c2f065e31df
			</div>

			<div class="w3-container">
			  <table class="w3-table-all">
			  	<!-- header -->
			    <thead>
			      <tr class="w3-dark-grey">
			        <th>ISBN</th>
			        <th>Title</th>
			        <th>Unit Price</th>
			        <th>Qnt</th>
			        <th></th>
			      </tr>
			    </thead>
			    <!-- create rows -->
			    <c:forEach items = "${cart.books}" var = "book" varStatus = "status">
			    	<tr>
			    	 <td><input name="books[${status.index}].isbn" value="${book.isbn}"/></td>
			    	 <td><input name="books[${status.index}].title" value="${book.title}"/></td>
					 <td><input name="books[${status.index}].price" value="${book.price}"/></td>
					 <td><input name="books[${status.index}].quantity" id="qnt_book_${status.index}" type="numeric" style="width:35px;" value="1"/> </td>
<<<<<<< HEAD
				       <td> <button class="sh_del_btn w3-right" name="${book.isbn}" >- del</button>
=======
				       <td> <button class="w3-right"
					       onclick="select_book(${status.index}); $('#delete_hidden_form').submit(); return false;">
					       - del</button>
>>>>>>> 37c6f3bd08258e3d59490ef974580c2f065e31df
					   </td>
				     </tr>	
			    </c:forEach>
			  </table>
			</div>

			
		</form>


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

<<<<<<< HEAD
=======
	<form id="publisher_orders_hidden_form" action="/Library/publiser_orders" method="post" style="display: none">
		  <input type="hidden" name="myParameterName" value="myParameterValue">
		</form>

>>>>>>> 37c6f3bd08258e3d59490ef974580c2f065e31df
	<form id="signout_hidden_form" action="/Library/signin" method="get" style="display: none">
	  <input type="hidden" name="myParameterName" value="myParameterValue">
	</form>

<<<<<<< HEAD
	<form id="delete_hidden_form" action="/Library/cart/delete" method="post" style="display: none">
		  <input id="book_remove_index" type="hidden" name="isbn" value="0">
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
=======
	<form id="checkout_hidden_form" action="/Library/checkout" method="post" style="display: none">
	  <input id="submit_qnt_book_1" type="hidden" name="book_1" value="1">
	</form>


	<form id="delete_hidden_form" action="/Library/home" method="get" style="display: none">
		  <input id="book_remove_index" type="hidden" name="selected_index" value="0">
>>>>>>> 37c6f3bd08258e3d59490ef974580c2f065e31df
	</form>
	


		
	</body>
	
	<!-- *********************************************** -->
	<!-- POST-LOADING SCRIPTS -->
	<!-- *********************************************** -->
	<script>
		var x = document.getElementsByClassName("sh_del_btn");
		var i;
		for (i = 0; i < x.length; i++) {
			//alert("success");
		    x[i].addEventListener("click", function(event){
			    event.preventDefault();
			    //alert("success");
			    select_book(event.target.name);
			    $('#delete_hidden_form').submit();
			    return false;
			});
		}

		function select_book(book_index)
		{
			document.getElementById('book_remove_index').value = book_index;
		}

<<<<<<< HEAD
=======
		function update_qnt_values()
		{
			var index;
			for(index = 1; index <= 1; index++)
			{
				var to = "submit_qnt_book_" + index;
				var from = "qnt_book_" + index;
				document.getElementById(to).value = document.getElementById(from).value;
			}			

		}

>>>>>>> 37c6f3bd08258e3d59490ef974580c2f065e31df
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

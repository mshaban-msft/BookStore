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
			<a href="#" onclick="$('#home_hidden_form').submit(); return false;">HOME</a>
			<a href="#" onclick="$('#account_hidden_form').submit(); return false;" >ACCOUNT</a>
			<a href="#" class="w3-blue-grey" >SHOPPING CART</a>
			<a href="#" onclick="$('#orders_hidden_form').submit(); return false;">MY ORDERS</a>
			<a href="#" onclick="$('#signout_hidden_form').submit(); return false;">SIGN OUT</a>

			<div id="admin_rights">
				<div class="w3-container" style="padding-top: 20px; font-weight: bold; padding-bottom: 5px;"> Admin Controls </div>
				<a href="#" onclick="$('#manage_books_hidden_form').submit(); return false;">MANAGE INVENTORY</a>
				<a href="#" onclick="$('#manage_publishers_hidden_form').submit(); return false;">MANAGE PUBLISHERS</a>
				<a href="#" onclick="$('#publisher_orders_hidden_form').submit(); return false;">PUBLISHER ORDERS</a>
				<a href="#" onclick="$('#user_accounts_hidden_form').submit(); return false;">USER ACCOUNTS</a>
			</div>
		</nav>
		
		<!-- page content -->
		<form class="w3-container" action="/Library/checkout" method="get" style="margin-left:250px">
			<div style="height:10px;">
			</div>
			

			<div class="w3-container w3-margin" style="padding-right:0px; padding-left: 0px;">
				<span class="w3-text-blue-grey" style="font-size:25px; font-weight:bold; font-family: arial;">My Shopping Cart</span>
				<button class="w3-btn w3-teal w3-right" type="submit" >Checkout</button>
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
			    	 <td><input readonly ="readonly" name="books[${status.index}].isbn" value="${book.isbn}"/></td>
			    	 <td><input readonly ="readonly" name="books[${status.index}].title" value="${book.title}"/></td>
					 <td><input readonly ="readonly" name="books[${status.index}].price" value="${book.price}"/></td>
					 <td><input  name="books[${status.index}].quantity" id="qnt_book_${status.index}" type="number" style="width:35px;" value="1"/> </td>
				       <td> <button class="sh_del_btn w3-right" name="${book.isbn}" >- del</button>
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

	<form id="signout_hidden_form" action="/Library/signin" method="get" style="display: none">
	  <input type="hidden" name="myParameterName" value="myParameterValue">
	</form>

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

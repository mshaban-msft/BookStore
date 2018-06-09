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
				width: 540px; padding-top: 20px; padding-bottom: 10px; padding-left: 20px;
			}

			.sh-label
			{
				width: 100px; padding-top: 6px; padding-right: 10px; text-align: right;
			}

			.sh-input
			{
				height: 35px;
			}

			.sh-book-attr
			{
				padding: 2px;
			}

		</style>

	</head>
	

	<!-- *********************************************** -->
	<!-- DEFINE BODY -->
	<!-- *********************************************** -->
	<body style="background-color: #FFFFF0;">
<<<<<<< HEAD
		
		<!-- side tabs -->
		<nav class="w3-sidenav w3-card-2 w3-light-grey" style="width:250px">
			<div class="w3-blue-grey w3-padding-16" style="padding-left: 37px;">
				<a href="#" class="w3-hover-blue-grey w3-xlarge" onclick="$('#home_hidden_form').submit(); return false;" >Amazon.com</a>
			</div>
		  
		  	<div class="w3-container" style="padding-top: 20px; font-weight: bold; padding-bottom: 10px;"> M-Shaban </div>
=======
		<!--top nav bar-->
		<div class="w3-top"">
			<ul class="w3-navbar w3-blue-grey w3-card-2" style="min-width:1100px; padding-left:10px;">
				<li><a href="#" class="w3-blue-grey" onclick="handle_side_nav()" style="padding-top:18px; padding-bottom:15px"><i class="fa fa-bars w3-large"></i></a></li>
				<li><a href="#" class="w3-padding-16 w3-blue-grey" style="padding-left:3px;" >BookStore</a></li>
			</ul>
		</div>
		
		<!-- side tabs -->
		<nav class="w3-sidenav w3-white w3-card-2 w3-light-grey w3-animate-left" style="width:250px; margin-top:33px; display:none" id="SideNav01">
			<div class="w3-container">
				<h3>M-Shaban</h3>
			</div>
		  
>>>>>>> 37c6f3bd08258e3d59490ef974580c2f065e31df
			<a href="#" class="w3-blue-grey">HOME</a>
			<a href="#" onclick="$('#account_hidden_form').submit(); return false;" >ACCOUNT</a>
			<a href="#" onclick="$('#cart_hidden_form').submit(); return false;" >SHOPPING CART</a>
			<a href="#" onclick="$('#orders_hidden_form').submit(); return false;">MY ORDERS</a>
			<a href="#" onclick="$('#signout_hidden_form').submit(); return false;">SIGN OUT</a>

			<div class="w3-container" style="padding-top: 20px; font-weight: bold; padding-bottom: 5px;"> Admin Controls </div>
			<a href="#" onclick="$('#manage_books_hidden_form').submit(); return false;">Manage Inventory</a>
			<a href="#" onclick="$('#manage_publishers_hidden_form').submit(); return false;">Manage Publishers</a>
			<a href="#" onclick="$('#publisher_orders_hidden_form').submit(); return false;">Publisher Orders</a>
			<a href="#" onclick="$('#user_accounts_hidden_form').submit(); return false;">User Accounts</a>
		</nav>
		
		<!-- page content -->
<<<<<<< HEAD
		<div class="w3-container" id="page_content" style="margin-left:250px">
			<div style="height:20px;">
=======
		<div class="w3-container" id="page_content">
			<div style="height:50px;">
>>>>>>> 37c6f3bd08258e3d59490ef974580c2f065e31df
			</div>
			
			<!--search and title-->
			<div class="w3-container" style="margin-bottom:10px;">
				<span class="w3-text-blue-grey" style="font-size:27px; font-weight:bold; font-family: arial;">Best Sellers!</span>
				<button class="w3-btn w3-teal w3-right" style="margin-top:5px;" onclick="show_search_modal()">Search</button>
			</div>

			<!--book table-->
			<div class="w3-container">

				<table class="w3-table-all" id = "book_table">

				    <thead>
				      <tr class="w3-dark-grey">
				        <th>Title</th>
				        <th>Price</th>
				        <th></th>
				      </tr>
				    </thead>
				    
				  </table>
			</div>

			
		</div>


		<!-- search modal -->
		<div id="search_modal" class="w3-modal">

			<form class="w3-modal-content w3-animate-zoom w3-card-12" style="width:400px;" action = "/Library/home/search"  method = "post">

				<header class="w3-container w3-blue-grey">
					<h2 class="w3-xlarge">
						<i class="fa fa-search w3-margin-right w3-margin-left w3-xlarge"></i>
						Search Books
					</h2>
				</header>

				<div class="w3-container w3-margin-top" style="height: 50px;">
					<input name="searchTerm" type="text" class="w3-input w3-border" required />
				</div>

				<div class="w3-container w3-padding-8">
					<label class="w3-text-grey"><b>Search By</b></label>
				</div>

				<div class="w3-row w3-container" style="padding-bottom: 40px;">

					<div class="w3-col" style="width: 200px; height: 40px;">
						<select class="w3-select w3-border w3-small" name="searchCriteria" required>
							<option value="Title" selected >Title</option>
							<option value="Author">Author</option>
							<option value="Publisher">Publisher</option>
						</select>
					</div>

					<div class="w3-col w3-right" style="width: 85px;">
						<button class="w3-btn w3-teal w3-ripple" >Search</button>
					</div>

				</div>

			</form>
		
		</div>



		<!-- view new book -->
		<div id="view_book_modal" class="w3-modal">

			<div class="w3-modal-content w3-animate-zoom w3-card-12" style="width:580px; overflow:hidden;">	 

				<header class="w3-container w3-blue-grey w3-tiny">
					<h2 class="w3-large w3-center">book view</h2>
				</header>

				<form class="sh-form" action="/Library/home/addBook" method="POST">

					<!-- user name -->
					<div class="w3-row sh-book-attr">
						<div class="w3-col sh-label">
							<label class="w3-label" style="text-align: right;" >ISBN</label>
						</div>

						<div class="w3-col" style="width: 400px;">
<<<<<<< HEAD
							<input id="book_isbn" type="number" class="w3-input w3-border sh-input" readonly="readonly" name = "isbn"/>
=======
							<input id="book_isbn" type="text" class="w3-input w3-border sh-input" readonly="readonly" name = "isbn"/>
>>>>>>> 37c6f3bd08258e3d59490ef974580c2f065e31df
						</div>
					</div>

					<!-- password -->
					<div class="w3-row sh-book-attr">
						<div class="w3-col sh-label">
							<label class="w3-label">Title</label>
						</div>

						<div class="w3-col" style="width: 400px;">
							<input id="book_title" type="text" class="w3-input w3-border sh-input" readonly="readonly" name = "title"/>
						</div>
					</div>

					<!-- first name -->
					<div class="w3-row sh-book-attr">
						<div class="w3-col sh-label">
							<label class="w3-label">Author</label>
						</div>

						<div class="w3-col" style="width: 400px;">
							<input id="book_author" type="text" class="w3-input w3-border sh-input" readonly="readonly" name = "author"/>
						</div>
					</div>

					<!-- last name -->
					<div class="w3-row sh-book-attr">
						<div class="w3-col sh-label">
							<label class="w3-label">Publisher</label>
						</div>

						<div class="w3-col" style="width: 400px;">
							<input id="book_publisher" type="text" class="w3-input w3-border sh-input" readonly="readonly" name = "publisher"/>
						</div>
					</div>


					<!-- user email -->
					<div class="w3-row sh-book-attr">
						<div class="w3-col sh-label">
							<label class="w3-label">Category</label>
						</div>

						<div class="w3-col" style="width: 400px;">
							<input id="book_category" type="text" class="w3-input w3-border sh-input" readonly="readonly" name = "category" />
						</div>
					</div>

					<!-- user phone -->
					<div class="w3-row sh-book-attr">
						<div class="w3-col sh-label">
							<label class="w3-label">Price</label>
						</div>

						<div class="w3-col" style="width: 400px;">
<<<<<<< HEAD
							<input id="book_price" type="number" class="w3-input sh-input w3-border" readonly="readonly" name = "price" />
=======
							<input id="book_price" type="text" class="w3-input sh-input w3-border" readonly="readonly" name = "price" />
>>>>>>> 37c6f3bd08258e3d59490ef974580c2f065e31df
						</div>
					</div>

					<!-- shipping address -->
					<div class="w3-row sh-book-attr">
						<div class="w3-col sh-label">
							<label class="w3-label">Year</label>
						</div>

						<div class="w3-col" style="width: 400px;">
<<<<<<< HEAD
							<input id="book_year" type="date" class="w3-input sh-input w3-border"  readonly="readonly" name="date" />
=======
							<input id="book_year" type="text" class="w3-input sh-input w3-border"  readonly="readonly" name="date" />
>>>>>>> 37c6f3bd08258e3d59490ef974580c2f065e31df
						</div>
					</div>


					<div class="w3-container" style="padding-top: 15px;">
						<button class="w3-btn w3-green w3-right" style="margin-right: 2px;" type="submit" >ADD TO CART</button>
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
		
		var list = ${bookList};

		$(document).ready(function() {
			$.each(list, function( index, value ) {
				var table = document.getElementById("book_table") ;
				var row = table.insertRow(index+1) ;
				var cell1 = row.insertCell(0);
			    var cell2 = row.insertCell(1);
			    var cell3 = row.insertCell(2);
			    cell1.innerHTML = value["title"];
			    cell2.innerHTML = value["price"];
			    newElem = document.createElement( 'input' );		
			    newElem.setAttribute("type", 'button'); 
			    newElem.setAttribute("class", 'w3-right');
			    newElem.setAttribute("value", 'View');
			    newElem.setAttribute("onclick", 'show_view_book_modal('+index+');' ) ;
				cell3.appendChild(newElem) ;
			});	
		});
	
	
		var search_modal = document.getElementById('search_modal');
		var view_book_modal = document.getElementById('view_book_modal');
		var side_nav = document.getElementById('SideNav01');
		var page_content = document.getElementById('page_content');
	
		// When the user clicks anywhere outside of the modal, close it
		window.onclick = function(event) {
		  if (event.target == search_modal) {
		    search_modal.style.display = "none";
		    return;
<<<<<<< HEAD
		  }
		  if (event.target == view_book_modal) {
		    view_book_modal.style.display = "none";
		    return;
		  }
=======
		  }
		  if (event.target == view_book_modal) {
		    view_book_modal.style.display = "none";
		    return;
		  }
>>>>>>> 37c6f3bd08258e3d59490ef974580c2f065e31df

		}
	
		/* post-load scripts */
		document.getElementById('view_book_modal').style.display='none';
		document.getElementById('search_modal').style.display='none';

		/* DOM manipulation functions */
		function show_view_book_modal(book_index)
		{
			document.getElementById('book_isbn').value = list[book_index]["isbn"];
			document.getElementById('book_title').value = list[book_index]["title"];
			document.getElementById('book_author').value = list[book_index]["author"];
			document.getElementById('book_publisher').value = list[book_index]["publisher"];
			document.getElementById('book_category').value = list[book_index]["category"];
			document.getElementById('book_price').value = list[book_index]["price"];
<<<<<<< HEAD
			document.getElementById('book_year').value = list[book_index]["date"];
=======
			document.getElementById('book_year').value = list[book_index]["year"];
>>>>>>> 37c6f3bd08258e3d59490ef974580c2f065e31df
			document.getElementById('view_book_modal').style.display='block';
		}


		function show_search_modal()
		{
			document.getElementById('search_modal').style.display='block';
		}

		function handle_side_nav()
		{
			if (side_nav.className.indexOf("w3-show") == -1) {
				side_nav.className += " w3-show";
			} else {
				side_nav.className = side_nav.className.replace(" w3-show", "");
			}
		}

	</script>
	
</html>
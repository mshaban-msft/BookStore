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
		<!--top nav bar-->
		<div class="w3-top"">
			<ul class="w3-navbar w3-blue-grey w3-card-2" style="min-width:1100px; padding-left:10px;">
				<li><a href="#" class="w3-blue-grey" onclick="handle_side_nav()" style="padding-top:18px; padding-bottom:15px"><i class="fa fa-bars w3-large"></i></a></li>
				<li><a href="#" class="w3-padding-16 w3-blue-grey" style="padding-left:3px;" >Manage Inventory</a></li>
			</ul>
		</div>
		
		<!-- side tabs -->
		<nav class="w3-sidenav w3-white w3-card-2 w3-light-grey w3-animate-left" style="width:250px; margin-top:33px; display:none" id="SideNav01">
			<div class="w3-container">
				<h3>M-Shaban</h3>
			</div>
		  
			<a href="#" onclick="$('#home_hidden_form').submit(); return false;">HOME</a>
			<a href="#" onclick="$('#account_hidden_form').submit(); return false;" >ACCOUNT</a>
			<a href="#" onclick="$('#cart_hidden_form').submit(); return false;" >SHOPPING CART</a>
			<a href="#" onclick="$('#orders_hidden_form').submit(); return false;">MY ORDERS</a>
			<a href="#" onclick="$('#signout_hidden_form').submit(); return false;">SIGN OUT</a>

			<div class="w3-container" style="padding-top: 20px; font-weight: bold; padding-bottom: 5px;"> Admin Controls </div>
			<a href="#" class="w3-blue-grey">Manage Inventory</a>
			<a href="#" onclick="$('#manage_publishers_hidden_form').submit(); return false;">Manage Publishers</a>
			<a href="#" onclick="$('#publisher_orders_hidden_form').submit(); return false;">Publisher Orders</a>
			<a href="#" onclick="$('#user_accounts_hidden_form').submit(); return false;">User Accounts</a>
		</nav>
		
		<!-- page content -->
		<div class="w3-container" id="page_content">
			<div style="height:50px;">
			</div>
			
			<!--search and title-->
			<div class="w3-container" style="margin-bottom:10px;">
				<span class="w3-text-blue-grey" style="font-size:28px; font-weight:bold; font-family: arial;">Manage Inventory</span>
				<button class="w3-btn w3-teal w3-right" style="margin-top:5px;" onclick="show_search_modal()">Search</button>
				<button class="w3-btn w3-teal w3-right" style="margin-top:5px; margin-right: 10px;" onclick="new_book_modal.style.display = 'block'">Add Book</button>
			</div>

			<!--book table-->
			<div class="w3-container">

				<table class="w3-table-all">

				    <thead>
				      <tr class="w3-dark-grey">
				        <th>Title</th>
				        <th>Price</th>
				        <th></th>
				      </tr>
				    </thead>

				    <tr>
				      <td>Game of Thrones</td>
				      <td>$35.99</td>
				      <th> <button class="w3-right" onclick="show_view_book_modal(0);">view</button> </th>
				    </tr>

				    <tr>
				      <td>Alice In Wonderland</td>
				      <td>$28.45</td>
				      <th> <button class="w3-right" onclick="show_view_book_modal(1);"">view</button> </th>
				    </tr>

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
						<button class="w3-btn w3-teal w3-ripple">Search</button>
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

				<form class="sh-form" action = "/Library/account/edit" method ="post">

					<!-- user name -->
					<div class="w3-row sh-book-attr">
						<div class="w3-col sh-label">
							<label class="w3-label" style="text-align: right;" >ISBN</label>
						</div>

						<div class="w3-col" style="width: 400px;">
							<input id="book_isbn" type="text" class="w3-input w3-border sh-input sh-view-input" disabled name = "isbn"/>
						</div>
					</div>

					<!-- password -->
					<div class="w3-row sh-book-attr">
						<div class="w3-col sh-label">
							<label class="w3-label">Title</label>
						</div>

						<div class="w3-col" style="width: 400px;">
							<input id="book_title" type="text" class="w3-input w3-border sh-input sh-view-input" disabled name = "title"/>
						</div>
					</div>

					<!-- first name -->
					<div class="w3-row sh-book-attr">
						<div class="w3-col sh-label">
							<label class="w3-label">Author</label>
						</div>

						<div class="w3-col" style="width: 400px;">
							<input id="book_author" type="text" class="w3-input w3-border sh-input sh-view-input" disabled name = "author"/>
						</div>
					</div>

					<!-- last name -->
					<div class="w3-row sh-book-attr">
						<div class="w3-col sh-label">
							<label class="w3-label">Publisher</label>
						</div>

						<div class="w3-col" style="width: 400px;">
							<input id="book_publisher" type="text" class="w3-input w3-border sh-input sh-view-input" disabled name = "publisher"/>
						</div>
					</div>


					<!-- user email -->
					<div class="w3-row sh-book-attr">
						<div class="w3-col sh-label">
							<label class="w3-label">Category</label>
						</div>

						<div class="w3-col" style="width: 400px;">
							<input id="book_category" type="text" class="w3-input w3-border sh-input sh-view-input" disabled name = "category" />
						</div>
					</div>

					<!-- user phone -->
					<div class="w3-row sh-book-attr">
						<div class="w3-col sh-label">
							<label class="w3-label">Price</label>
						</div>

						<div class="w3-col" style="width: 400px;">
							<input id="book_price" type="text" class="w3-input sh-input w3-border sh-view-input" disabled name = "price" />
						</div>
					</div>

					<!-- shipping address -->
					<div class="w3-row sh-book-attr">
						<div class="w3-col sh-label">
							<label class="w3-label">Year</label>
						</div>

						<div class="w3-col" style="width: 400px;">
							<input id="book_year" type="text" class="w3-input sh-input w3-border sh-view-input"  disabled name="date" />
						</div>
					</div>


					<div class="w3-container" style="padding-top: 15px; padding-bottom: 15px;">
						<button id="edit_book_btn" class="w3-btn w3-teal w3-right" style="margin-right: 2px;">Edit</button>
						<button id="remove_book_btn" class="w3-btn w3-red w3-right" style="margin-right: 5px;">Remove!</button>
						<button id="cancel_update_btn" class="w3-btn w3-teal w3-right" style="margin-right: 2px;">Cancel</button>
						<button id="confirm_edit_btn" class="w3-btn w3-red w3-right" style="margin-right: 2px;"
								type="submit" >Confirm</button>
					</div>

				</form>


			</div>
		</div>



		<!-- adding new book -->
		<div id="new_book_modal" class="w3-modal">

			<div class="w3-modal-content w3-animate-zoom w3-card-12" style="width:580px; overflow:hidden;">
			
				<header class="w3-container w3-blue-grey w3-tiny">
					<h2 class="w3-large">
						<i class="fa fa-plus w3-margin-left w3-medium" style="margin-right: 10px;"></i>
						New Book
					</h2>
				</header>
				 

				<form class="sh-form" action="/Library/home/addBook" method="POST">

					<!-- user name -->
					<div class="w3-row sh-book-attr">
						<div class="w3-col sh-label">
							<label class="w3-label" style="text-align: right;" >ISBN</label>
						</div>

						<div class="w3-col" style="width: 400px;">
							<input type="text" class="w3-input w3-border sh-input"  name = "isbn"/>
						</div>
					</div>

					<!-- password -->
					<div class="w3-row sh-book-attr">
						<div class="w3-col sh-label">
							<label class="w3-label">Title</label>
						</div>

						<div class="w3-col" style="width: 400px;">
							<input type="text" class="w3-input w3-border sh-input"  name = "title"/>
						</div>
					</div>

					<!-- first name -->
					<div class="w3-row sh-book-attr">
						<div class="w3-col sh-label">
							<label class="w3-label">Author</label>
						</div>

						<div class="w3-col" style="width: 400px;">
							<input type="text" class="w3-input w3-border sh-input"  name = "author"/>
						</div>
					</div>

					<!-- last name -->
					<div class="w3-row sh-book-attr">
						<div class="w3-col sh-label">
							<label class="w3-label">Publisher</label>
						</div>

						<div class="w3-col" style="width: 400px;">
							<input type="text" class="w3-input w3-border sh-input"  name = "publisher"/>
						</div>
					</div>


					<!-- user email -->
					<div class="w3-row sh-book-attr">
						<div class="w3-col sh-label">
							<label class="w3-label">Category</label>
						</div>

						<div class="w3-col" style="width: 400px;">
							<select class="w3-select w3-border sh-input w3-tiny" name="category" required>
								<option value="Science" selected >Science</option>
								<option value="Art">Art</option>
								<option value="Religion">Religion</option>
								<option value="History">History</option>
								<option value="Geography">Geography</option>
							</select>
						</div>
					</div>

					<!-- user phone -->
					<div class="w3-row sh-book-attr">
						<div class="w3-col sh-label">
							<label class="w3-label">Price</label>
						</div>

						<div class="w3-col" style="width: 400px;">
							<input type="text" class="w3-input w3-border sh-input"  name = "price" />
						</div>
					</div>

					<!-- shipping address -->
					<div class="w3-row sh-book-attr">
						<div class="w3-col sh-label">
							<label class="w3-label">Year</label>
						</div>

						<div class="w3-col" style="width: 400px;">
							<input type="date" class="w3-input w3-border sh-input"  name="date" />
						</div>
					</div>

					<!-- shipping address -->
					<div class="w3-row sh-book-attr">
						<div class="w3-col sh-label">
							<label class="w3-label">Quantity</label>
						</div>

						<div class="w3-col" style="width: 400px;">
							<input type="text" class="w3-input w3-border sh-input"  name = "quantity" />
						</div>
					</div>

					<!-- shipping address -->
					<div class="w3-row sh-book-attr">
						<div class="w3-col sh-label">
							<label class="w3-label">Threshold</label>
						</div>

						<div class="w3-col" style="width: 400px;">
							<input type="text" class="w3-input w3-border sh-input"  name = "thershold" />
						</div>
					</div>

					<div class="w3-container" style="padding-top: 10px; padding-bottom: 10px;">
						<button class="w3-btn w3-green w3-right" style="margin-right: 2px;" type="submit" >Add Book</button>
						<button class="w3-btn w3-teal w3-right" id="cancel_adding_btn" style="margin-right: 10px;">Cancel</button>
					</div>
				</form>


			</div>
		</div>






		<!-- handling site navigation (hidden forms) -->
		<form id="account_hidden_form" action="/Library/account" method="post" style="display: none">
		  <input type="hidden" name="myParameterName" value="myParameterValue">
		</form>

		<form id="cart_hidden_form" action="/Library/cart" method="post" style="display: none">
		  <input type="hidden" name="myParameterName" value="myParameterValue">
		</form>

		<form id="orders_hidden_form" action="/Library/orders" method="post" style="display: none">
		  <input type="hidden" name="myParameterName" value="myParameterValue">
		</form>

		<form id="publisher_orders_hidden_form" action="/Library/publiser_orders" method="get" style="display: none">
		  <input type="hidden" name="myParameterName" value="myParameterValue">
		</form>

		<form id="signout_hidden_form" action="/Library/signin" method="get" style="display: none">
		  <input type="hidden" name="myParameterName" value="myParameterValue">
		</form>


		<form id="remove_book_hidden_form" action="/Library/signin" method="get" style="display: none">
		  <input id="selected_book_index" type="hidden" name="selected_book_index" value="0">
		</form>



		
	</body>
	
	<!-- *********************************************** -->
	<!-- POST-LOADING SCRIPTS -->
	<!-- *********************************************** -->
	<script>
		var b1 = { "ISBN":1234, "Title":"Alice In Wonderland", "Author":"haha", "Publisher":"mosh 3aref", "Category":"fiction", "Price":123, "Year":1912};
		var b2 = { "ISBN":43221, "Title":"Game of Thrones", "Author":"haha", "Publisher":"mosh 3aref", "Category":"fanatasy", "Price":123, "Year":2007};

		var book_list = [b1, b2];
	</script>

	<script>

		/* assign variables to document elements */
		/************************************************************/
		var search_modal = document.getElementById('search_modal');
		var view_book_modal = document.getElementById('view_book_modal');
		var new_book_modal = document.getElementById('new_book_modal');
		var side_nav = document.getElementById('SideNav01');
		var page_content = document.getElementById('page_content');
		var edit_book_btn = document.getElementById('edit_book_btn');
		var cancel_update_btn = document.getElementById('cancel_update_btn');
		var remove_book_btn = document.getElementById('remove_book_btn');
		var cancel_adding_btn = document.getElementById('cancel_adding_btn');


		/* view book modal */
		/************************************************************/
		cancel_update_btn.style.display = "none";
		confirm_edit_btn.style.display = "none";

		var disabled_flag = true;
		var view_book_fields = document.getElementsByClassName("sh-view-input");
		var selected_book = 0;

		edit_book_btn.addEventListener("click", function(event){
		    event.preventDefault();
		    toggle_disabled();
		});

		cancel_update_btn.addEventListener("click", function(event){
		    event.preventDefault();
		    toggle_disabled();
		});

		remove_book_btn.addEventListener("click", function(event){
		    event.preventDefault();
		    $('#remove_book_hidden_form').submit();
		    return false;
		});

		cancel_adding_btn.addEventListener("click", function(event){
		    event.preventDefault();
		    new_book_modal.style.display = 'none';
		});

		function toggle_disabled()
		{
			if(disabled_flag == true){
				disabled_flag = false;
				remove_book_btn.style.display = "none";
				edit_book_btn.style.display = "none";
				cancel_update_btn.style.display = "block";
				confirm_edit_btn.style.display = "block";
			}
			else{
				disabled_flag = true;
				remove_book_btn.style.display = "block";
				edit_book_btn.style.display = "block";
				cancel_update_btn.style.display = "none";
				confirm_edit_btn.style.display = "none";
			}
			
			for (i = 0; i < view_book_fields.length; i++) {
			    view_book_fields[i].disabled = disabled_flag;
			}	
		}
	
		/* modal windows */
		/************************************************************/
		/* When the user clicks anywhere outside of the modal, close it */ 
		window.onclick = function(event) {
		  if (event.target == search_modal) {
		    search_modal.style.display = "none";
		    return;
		  }
		  if (event.target == view_book_modal) {
		    view_book_modal.style.display = "none";
		    return;
		  }
		  if (event.target == new_book_modal) {
		    new_book_modal.style.display = "none";
		    return;
		  }

		}
	
		/* post-load scripts */
		/************************************************************/
		view_book_modal.style.display='none';
		search_modal.style.display='none';
		new_book_modal.style.display = 'none';

		/* DOM manipulation functions */
		/************************************************************/
		function show_view_book_modal(book_index)
		{
			// update selected book index
			document.getElementById('selected_book_index').value = book_index;
			// update displayed attributes
			document.getElementById('book_isbn').value = book_list[book_index]["ISBN"];
			document.getElementById('book_title').value = book_list[book_index]["Title"];
			document.getElementById('book_author').value = book_list[book_index]["Author"];
			document.getElementById('book_publisher').value = book_list[book_index]["Publisher"];
			document.getElementById('book_category').value = book_list[book_index]["Category"];
			document.getElementById('book_price').value = book_list[book_index]["Price"];
			document.getElementById('book_year').value = book_list[book_index]["Year"];
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
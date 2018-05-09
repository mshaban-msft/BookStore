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
				<li><a href="#" class="w3-padding-16 w3-hover-teal">BookStore</a></li>
			</ul>
		</div>
		
		<!-- side tabs -->
		<nav class="w3-sidenav w3-white w3-card-2 w3-light-grey w3-animate-left" style="width:250px; margin-top:57px; display:none" id="SideNav01">
			<div class="w3-container">
				<h3>M-Shaban</h3>
			</div>
		  
			<a href="#" class="w3-green">HOME</a>
			<a href="#" onclick="$('#account_hidden_form').submit(); return false;" >ACCOUNT</a>
			<a href="#" onclick="$('#cart_hidden_form').submit(); return false;" >SHOPPING CART</a>
			<a href="#" onclick="$('#orders_hidden_form').submit(); return false;">MY ORDERS</a>
			<a href="#" onclick="$('#publisher_orders_hidden_form').submit(); return false;">PUBLISHER ORDERS</a>
			<a href="#" onclick="$('#signout_hidden_form').submit(); return false;">SIGN OUT</a>
		</nav>
		
		<!-- page content -->
		<div class="w3-container">
			<div style="height:55px;">
			</div>
			

			<div class="w3-container w3-card-2 w3-margin w3-padding-8">

				<button class="w3-btn w3-teal" onclick="show_search_modal()">Search</button>
				<button class="w3-btn w3-teal" onclick="">Browse</button>
				<button class="w3-btn w3-teal" onclick="show_new_book_modal()">Add New Book</button>

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


		<!-- search modal -->
		<div id="search_modal" class="w3-modal">

			<div class="w3-modal-content w3-animate-zoom w3-card-12" style="width:400px;">

				<header class="w3-container w3-teal">
					<h2 class="w3-xlarge">
						<i class="fa fa-search w3-margin-right w3-margin-left w3-xlarge"></i>
						Search Books
					</h2>
				</header>

				<div class="w3-container w3-margin-top" style="height: 50px;">
					<input type="text" class="w3-input w3-border" required />
				</div>

				<div class="w3-container w3-padding-8">
					<label class="w3-text-grey"><b>Search By</b></label>
				</div>

				<div class="w3-row w3-container" style="padding-bottom: 40px;">

					<div class="w3-col" style="width: 200px; height: 40px;">
						<select class="w3-select w3-border w3-small" name="option">
							<option value="1" selected >Book Name</option>
							<option value="2">Author</option>
							<option value="3">Publisher</option>
						</select>
					</div>

					<div class="w3-col w3-right" style="width: 85px;">
						<button class="w3-btn w3-teal w3-ripple" onclick="close_search_modal()">Search</button>
					</div>

				</div>

			</div>
		
		</div>



		<!-- adding new book -->
		<div id="new_book_modal" class="w3-modal">

			<div class="w3-modal-content w3-animate-zoom w3-card-12" style="width:580px; overflow:hidden;">
			
				<header class="w3-container w3-teal w3-tiny">
					<h2 class="w3-large">
						<i class="fa fa-plus w3-margin-left w3-medium" style="margin-right: 10px;"></i>
						New Book
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
							<label class="w3-label">Title</label>
						</div>

						<div class="w3-col" style="width: 400px;">
							<input type="password" class="w3-input w3-border sh-input"  />
						</div>
					</div>

					<!-- first name -->
					<div class="w3-row sh-book-attr">
						<div class="w3-col sh-label">
							<label class="w3-label">Author</label>
						</div>

						<div class="w3-col" style="width: 400px;">
							<input type="text" class="w3-input w3-border sh-input"  />
						</div>
					</div>

					<!-- last name -->
					<div class="w3-row sh-book-attr">
						<div class="w3-col sh-label">
							<label class="w3-label">Publisher</label>
						</div>

						<div class="w3-col" style="width: 400px;">
							<input type="text" class="w3-input w3-border sh-input"  />
						</div>
					</div>

					<!-- user email -->
					<div class="w3-row sh-book-attr">
						<div class="w3-col sh-label">
							<label class="w3-label">Category</label>
						</div>

						<div class="w3-col" style="width: 400px;">
							<input type="text" class="w3-input w3-border sh-input"  />
						</div>
					</div>

					<!-- user phone -->
					<div class="w3-row sh-book-attr">
						<div class="w3-col sh-label">
							<label class="w3-label">Price</label>
						</div>

						<div class="w3-col" style="width: 400px;">
							<input type="text" class="w3-input w3-border sh-input"  />
						</div>
					</div>

					<!-- shipping address -->
					<div class="w3-row sh-book-attr">
						<div class="w3-col sh-label">
							<label class="w3-label">Year</label>
						</div>

						<div class="w3-col" style="width: 400px;">
							<input type="text" class="w3-input w3-border sh-input"  />
						</div>
					</div>

					<!-- shipping address -->
					<div class="w3-row sh-book-attr">
						<div class="w3-col sh-label">
							<label class="w3-label">Quantity</label>
						</div>

						<div class="w3-col" style="width: 400px;">
							<input type="text" class="w3-input w3-border sh-input"  />
						</div>
					</div>

					<!-- shipping address -->
					<div class="w3-row sh-book-attr">
						<div class="w3-col sh-label">
							<label class="w3-label">Threshold</label>
						</div>

						<div class="w3-col" style="width: 400px;">
							<input type="text" class="w3-input w3-border sh-input"  />
						</div>
					</div>

					<div class="w3-container" style="padding-top: 10px; padding-bottom: 10px;">
						<button class="w3-btn w3-green w3-right" style="margin-right: 60px;" type="submit" >ADD BOOK</button>
						<button class="w3-btn w3-red w3-right" id="cancel_btn" style="margin-right: 10px;">CANCEL</button>
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

		<form id="publisher_orders_hidden_form" action="/Library/publiser_orders" method="post" style="display: none">
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

		var search_modal = document.getElementById('search_modal');
	
		// When the user clicks anywhere outside of the modal, close it
		window.onclick = function(event) {
		  if (event.target == search_modal) {
		    search_modal.style.display = "none";
		  }
		}
	
	
		document.getElementById("cancel_btn").addEventListener("click", function(event){
		    event.preventDefault();
		    hide_new_book_modal();
		});
	
		/* post-load scripts */
		document.getElementById('new_book_modal').style.display='none';
		document.getElementById('search_modal').style.display='none';

		/* DOM manipulation functions */
		function show_new_book_modal()
		{
			document.getElementById('new_book_modal').style.display='block';
		}

		function hide_new_book_modal()
		{
			document.getElementById('new_book_modal').style.display='none';
		}

		function show_search_modal()
		{
			document.getElementById('search_modal').style.display='block';
		}

		function close_search_modal()
		{
			document.getElementById('search_modal').style.display='none';
		}

		function handleSideNav(){
			var x=document.getElementById("SideNav01");
			if (x.className.indexOf("w3-show") == -1) {
				x.className += " w3-show";
			} else {
				x.className = x.className.replace(" w3-show", "");
			}
		}

	</script>
	
</html>
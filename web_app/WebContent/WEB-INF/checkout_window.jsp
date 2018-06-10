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
				padding-top: 15px; padding-bottom: 20px; padding-left: 20px;
			}

			.sh-label
			{
				width: 100px; padding-top: 8px; padding-right: 10px; text-align: right;
			}

		</style>
	</head>
	

	<!-- *********************************************** -->
	<!-- DEFINE BODY -->
	<!-- *********************************************** -->
	<body style="background-color: #FFFFF0;">
		<!--top nav bar-->
		<ul class="w3-navbar w3-blue-grey w3-card-2">
			<p style="text-align: center;">Order Checkout</p>
		</ul>
		
		
		<!-- page content -->
		<div class="w3-container">

			<!-- receipient info -->
			<form action="/Library/checkout/submit" method="POST" style="display: table; margin: 0 auto; padding-top: 7px; padding-bottom: 20px; width: 600px; padding-left: 45px; margin-top:10px;">

			<div id="recipient_info_container" style="margin-top: 0px; width:500px;">

				<div class="w3-container w3-dark-grey">
					<p>Recipient Info</p>
				</div>

				<div class="sh-form" >
				<!-- user name -->
					<div class="w3-row" style="padding-top: 5px; padding-bottom: 5px;">
						<div class="w3-col sh-label">
							<label class="w3-label w3-text-grey" style="text-align: right;" ><b>Name</b></label>
						</div>

						<div class="w3-col w3-grey" style="width: 300px;">
							<input id="full_name" type="text" class="w3-input sh-input" style="border: none;" disabled/>
						</div>
					</div>

					<!-- password -->
					<div class="w3-row" style="padding-top: 5px; padding-bottom: 5px;">
						<div class="w3-col sh-label">
							<label class="w3-label w3-text-grey"><b>Phone</b></label>
						</div>

						<div class="w3-col" style="width: 300px;">
							<input id="phone" type="text" class="w3-input sh-input" style="border: none;" disabled/>
						</div>
					</div>

					<!-- first name -->
					<div class="w3-row" style="padding-top: 5px; padding-bottom: 5px;">
						<div class="w3-col sh-label">
							<label class="w3-label w3-text-grey"><b>Address</b></label>
						</div>

						<div class="w3-col" style="width: 300px;">
							<input id="address" type="text" class="w3-input sh-input" style="border: none;" disabled/>
						</div>
					</div>

					<!-- first name -->
					<div class="w3-row" style="padding-top: 5px; padding-bottom: 5px;">
						<div class="w3-col sh-label">
							<label class="w3-label w3-text-grey"><b>Total Price</b></label>
						</div>

						<div class="w3-col" style="width: 300px;">
							<input id="total_price" type="text" class="w3-input sh-input" style="border: none;" disabled/>
						</div>
					</div>

				</div>
			</div>


			<!-- card info container -->
			<div id="card_info_container" class="" style="margin-top: 20px; width:500px;">

				<div class="w3-container w3-dark-grey">
					<p>Card Info</p>
				</div>

				<div class="sh-form" >
				<!-- user name -->
					<div class="w3-row" style="padding-top: 5px; padding-bottom: 5px;">
						<div class="w3-col sh-label">
							<label class="w3-label w3-text-grey" style="text-align: right;" ><b>Card No</b></label>
						</div>

						<div class="w3-col w3-grey" style="width: 300px;">
							<input type="number" class="w3-input sh-input w3-border" name="cardNo" />
						</div>
					</div>

					<!-- password -->
					<div class="w3-row" style="padding-top: 5px; padding-bottom: 5px;">
						<div class="w3-col sh-label">
							<label class="w3-label w3-text-grey"><b>Expiry Date</b></label>
						</div>

						<div class="w3-col" style="width: 300px;">
							<input type="date" class="w3-input w3-border sh-input"  name="expiryDate" />
						</div>
					</div>

				</div>
			</div>

			<!-- place order -->
			<div id="verifiy_btn_container" style="margin-top: 20px; width:500px;">
				<button class="w3-btn w3-teal" type="submit" >Place Order</button>
			</div>

			</form>


			
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

		<form id="publisher_orders_hidden_form" action="/Library/publiser_orders" method="get" style="display: none">
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
	
		var full_name = '<c:out value="${user.firstName}"/>' ;
		var phone = '<c:out value="${user.phone}"/>' ;
		var address = '<c:out value="${user.address}"/>' ;
		var total_price = <c:out value="${total_price}"/> ;
	
		$(document).ready(function(){

			$("#full_name").val(full_name);
			$("#phone").val(phone);
			$("#address").val(address);
			$("#total_price").val(total_price);

		});

	</script>
	
</html>


<html>
	<head>
		<link rel="stylesheet" href="http://www.w3schools.com/lib/w3.css">
	</head>

	<body class="w3-container w3-margin">
	
		<div class="w3-card-4" style="width:600px">
			<div class="w3-row w3-padding-16 w3-teal w3-center">
				<div class="w3-col w3-quarter">Name</div>
				<div class="w3-col w3-quarter">Address</div>
				<div class="w3-col w3-quarter">City</div>
				<div class="w3-col w3-quarter">State</div>
			</div>
			
			<div style="height:500px;overflow:scroll">
				<table class="w3-table-all">
					<?php
						require "connectToDatabase.php";
						//echo "Connected!";
						require "displayTableScript.php";
					?>
				</table>
			</div>
		</div>
	</body>

</html>
<?php			
	$query="SELECT * FROM customers";
	$query_run=mysql_query($query);
						
	while($query_row=mysql_fetch_assoc($query_run)){
		$customer_name=$query_row["name"];
		$customer_address=$query_row["address"];
		$customer_city=$query_row["city"];
		$customer_state=$query_row["state"];
							
		echo "<tr>";
		echo "<td>".$customer_name."</td>";
		echo "<td>".$customer_address."</td>";
		echo "<td>".$customer_city."</td>";
		echo "<td>".$customer_state."</td>";
		echo "</tr>";
	}
?>
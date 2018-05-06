<?php
	$host_address="localhost";
	$user_name="root";
	$login_password="";
	$target_database="sql_php";
	
	$server_connect=@mysql_connect($host_address, $user_name, $login_password);
	$database_connect=@mysql_select_db($target_database);
	
	if((!$server_connect)||(!$database_connect)){
		die("Could NOT connect!");
	}
?>
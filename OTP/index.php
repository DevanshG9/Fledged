<?php
	include "smsGateway.php";
	$smsGateway = new SmsGateway('devanshngholba@gmail.com', 'fledged');
	$deviceID = 83072;
	$phone = $_GET['phone'];
	echo "$phone";
	echo "<br>";
	$otp = $_GET['otp'];
	echo "$otp";
	echo "<br>";
	echo "Sending text...";
	echo "<br>";
	$options = [];
	$result = $smsGateway->sendMessageToNumber($phone, $otp, $deviceID, $options);
?>

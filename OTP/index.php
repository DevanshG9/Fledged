<?php
	include "smsGateway.php";
	$smsGateway = new SmsGateway('devanshngholba@gmail.com', 'fledged');

	$deviceID = 82768;
	$phone = $_GET['phone'];
	echo "$phone";
	echo "<br>";
	$otp = $_GET['otp'];
	echo "$otp";
	echo "<br>";
	echo "Sending text...";
	echo "<br>";

	$options = [
	'send_at' => strtotime('+10 minutes'), // Send the message in 10 minutes
	'expires_at' => strtotime('+1 hour') // Cancel the message in 1 hour if the message is not yet sent
	];

	$result = $smsGateway->sendMessageToNumber($phone, $otp, $deviceID, $options);

	echo "$result->success";
?>
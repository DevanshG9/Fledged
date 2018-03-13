<?php
	include "smsGateway.php";
	$smsGateway = new SmsGateway('devanshngholba@gmail.com', 'fledged');

	$deviceID = 82768;
	$number = $_GET['n'];
	echo "$number";
	echo "<br>";
	$message = $_GET['number'];
	echo "$message";
	echo "<br>";
	echo "Sending text...";
	echo "<br>";

	$options = [
	'send_at' => strtotime('+10 minutes'), // Send the message in 10 minutes
	'expires_at' => strtotime('+1 hour') // Cancel the message in 1 hour if the message is not yet sent
	];

	$result = $smsGateway->sendMessageToNumber($number, $message, $deviceID, $options);
?>
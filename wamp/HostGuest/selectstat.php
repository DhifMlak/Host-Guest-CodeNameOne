<?php
require_once('connect.php');



$sql = "select count(*) as nb,note from evaluations group by note";

$result = $conn->query($sql);
$json = new SimpleXMLElement('<xml/>');
if ($result->num_rows > 0) {
    // output data of each row
    while($row = $result->fetch_assoc()) {
      $mydata = $json->addChild('evaluations');
      $mydata->addChild('nb',$row['nb']);
      $mydata->addChild('note',$row['note']);
    

         }
} else {
    echo "0 results";
}
$conn->close();
	 echo( json_encode ($json));
?>
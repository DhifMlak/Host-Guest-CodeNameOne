<?php
require_once('connect.php');


$ids=$_GET['ids'];
$sql = "SELECT * FROM rating where idsortie ='$ids' ";
$result = $conn->query($sql);

$json = new SimpleXMLElement('<xml/>');
if ($result->num_rows > 0) {
    // output data of each row
    while($row = $result->fetch_assoc()) {
      $mydata = $json->addChild('rating');
        $mydata->addChild('id',$row['id']);
        $mydata->addChild('idsortie',$row['idsortie']);
        $mydata->addChild('rate',$row['rate']);

         }

} else {
    echo "0 results";
}
$conn->close();
	 echo( json_encode ($json));
?>
<?php
require_once('connect.php');



$sql = "SELECT * FROM logements";
$result = $conn->query($sql);
$json = new SimpleXMLElement('<xml/>');
if ($result->num_rows > 0) {
    // output data of each row
    while($row = $result->fetch_assoc()) {
      $mydata = $json->addChild('logement');
	  
	  
        $mydata->addChild('id',$row['id']);
        $mydata->addChild('titre',$row['titre']);
        $mydata->addChild('adresse',$row['adresse']);
		$mydata->addChild('ville',$row['ville']);
		$mydata->addChild('pays',$row['pays']);
		$mydata->addChild('prix',$row['prix']);
		$mydata->addChild('type',$row['type']);
		
         }
} else {
    echo "0 results";
}
$conn->close();
	 echo( json_encode ($json));
?>
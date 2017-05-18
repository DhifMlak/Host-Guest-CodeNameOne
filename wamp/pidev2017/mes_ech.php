<?php
require_once('connect.php');



$sql = "SELECT * FROM echange where e_id=3";
$result = $conn->query($sql);
$json = new SimpleXMLElement('<xml/>');
if ($result->num_rows > 0) {
    // output data of each row
    while($row = $result->fetch_assoc()) {
      $mydata = $json->addChild('echange');
        $mydata->addChild('id',$row['id']);
        $mydata->addChild('description',$row['description']);
        $mydata->addChild('dateDeb',$row['dateDeb']);
		$mydata->addChild('dateFin',$row['dateFin']);
        $mydata->addChild('prix',$row['prix']);
    	$mydata->addChild('prixMinimal',$row['prixMinimal']);
    	$mydata->addChild('e_id',$row['e_id']);
    	$mydata->addChild('id_cat',$row['id_cat']);
         }
} else {
    echo "0 results";
}
$conn->close();
	 echo( json_encode ($json));
?>
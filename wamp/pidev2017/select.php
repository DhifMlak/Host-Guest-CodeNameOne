<?php
require_once('connect.php');



$sql = "SELECT * FROM sorties";
$result = $conn->query($sql);
$json = new SimpleXMLElement('<xml/>');
if ($result->num_rows > 0) {
    // output data of each row
    while($row = $result->fetch_assoc()) {
      $mydata = $json->addChild('sorties');
        $mydata->addChild('id',$row['id']);
        $mydata->addChild('titre',$row['titre']);
        $mydata->addChild('date',$row['date']);
		$mydata->addChild('lieu',$row['lieu']);
        $mydata->addChild('description',$row['description']);
    	$mydata->addChild('nbMax',$row['nbMax']);
    	$mydata->addChild('conditions',$row['conditions']);
    	$mydata->addChild('type_sortie',$row['type_sortie']);
         }

} else {
    echo "0 results";
}
$conn->close();
	 echo( json_encode ($json));
?>
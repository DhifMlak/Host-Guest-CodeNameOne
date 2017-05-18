<?php
require_once('connect.php');


$idHote=$_GET['id_hote'];
$lieu=$_GET['lieu'];
//$idHote=1;



$sql = "SELECT * FROM randonnees r,offres o WHERE o.id_hote=".$idHote." and o.id=r.id and r.etat=1 and r.lieu like '%".$lieu."%'";
$result = $conn->query($sql);
$json = new SimpleXMLElement('<xml/>');
if ($result->num_rows > 0) {
    // output data of each row
    while($row = $result->fetch_assoc()) {
      $mydata = $json->addChild('rando');
        $mydata->addChild('id',$row['id']);
		$mydata->addChild('titre',$row['titre']);
        $mydata->addChild('lieu',$row['lieu']);
        $mydata->addChild('nbMax',$row['nbMax']);
		$mydata->addChild('description',$row['description']);
		$mydata->addChild('lieu_rencontre',$row['lieu_rencontre']);
		$mydata->addChild('heure_rencontre',$row['heure_rencontre']);
		$mydata->addChild('prix',$row['prix']);
         }
} else {
    echo "0 results";
}
$conn->close();
	 echo( json_encode ($json));
   
?>
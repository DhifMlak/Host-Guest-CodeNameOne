
<?php
require_once('connect.php');


$id=$_GET['id'];
$sql = "SELECT * FROM evaluations where id_offre=".$id;
$result = $conn->query($sql);
$json = new SimpleXMLElement('<xml/>');
if ($result->num_rows > 0) {
    // output data of each row
    while($row = $result->fetch_assoc()) {
      $mydata = $json->addChild('evaluation');
         $mydata->addChild('id',$row['id']);
        $mydata->addChild('titre',$row['titre']);
        $mydata->addChild('commentaire',$row['commentaire']);
		$mydata->addChild('facility',$row['facility']);
		$mydata->addChild('service',$row['service']);
		$mydata->addChild('interesting',$row['interesting']);
		$mydata->addChild('human',$row['human']);
$mydata->addChild('id_offre',$row['id_offre']);

         }
} else {
    echo "0 results";
}
$conn->close();
	 echo( json_encode ($json));
?>


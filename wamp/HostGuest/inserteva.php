<?php
require_once('connect.php');
$titre=$_GET['titre'];
$commentaire=$_GET['commentaire'];
$facility=$_GET['facility'];
$service=$_GET['service'];
$interesting=$_GET['interesting'];
$human=$_GET['human'];
$id_offre=$_GET['id_offre'];

$note= ($facility+$service+$interesting+$human)/4;



$sql = "INSERT INTO Evaluations  (titre, commentaire, facility, service, interesting, human ,note, id_offre)
VALUES ( '$titre','$commentaire','$facility','$service','$interesting','$human','$note','$id_offre')";

if (mysqli_query($conn, $sql)) {
    echo "success";
} else {
    echo "Error: " . $sql . "<br>" . mysqli_error($conn);
}

mysqli_close($conn);
?>
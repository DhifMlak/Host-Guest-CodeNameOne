<?php
require_once('connect.php');


$id=$_GET['id'];
$titre=$_GET['titre'];
//$date=$_GET['date'];
$lieu=$_GET['lieu'];
$description=$_GET['description'];
$nbMax=$_GET['nbMax'];
$conditions=$_GET['conditions'];
$type_sortie=$_GET['type_sortie'];

$date = getdate();
$etat='non traité';

$sql = "UPDATE sorties SET titre='$titre',lieu='$lieu',description='$description',nbMax='$nbMax',conditions='$conditions',type_sortie='$type_sortie'
 WHERE id='$id'";

if (mysqli_query($conn, $sql)) {
    echo "successfully updated";
} else {
    echo "Error: " . $sql . "<br>" . mysqli_error($conn);
}

mysqli_close($conn);
?>
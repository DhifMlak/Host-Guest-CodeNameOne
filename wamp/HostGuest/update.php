<?php
require_once('connect.php');


$id=$_GET['id'];
$titre=$_GET['titre'];

$commentaire=$_GET['commentaire'];


$fas=$_GET['fas'];

$ser=$_GET['ser'];
$inter=$_GET['inter'];
$human=$_GET['human'];


$sql = "UPDATE evaluations SET titre='$titre',commentaire='$commentaire',facility='$fas',sevice='$ser',interesting='$inter',human='$human'
 WHERE id='$id'";

if (mysqli_query($conn, $sql)) {
    echo "successfully updated";
} else {
    echo "Error: " . $sql . "<br>" . mysqli_error($conn);
}

mysqli_close($conn);
?>
<?php
require_once('connect.php');

$id=$_GET['id'];
$titre=$_GET['titre'];
$lieu=$_GET['lieu'];
$nbMax=$_GET['nbMax'];
$description=$_GET['description'];
$lieu_rencontre=$_GET['lieu_rencontre'];
$heure_rencontre=$_GET['heure_rencontre'];
$prix=$_GET['prix'];

$sql = "UPDATE randonnees SET titre='".$titre."', lieu='".$lieu."', nbMax=".$nbMax.", description='".$description."', lieu_rencontre='".$lieu_rencontre."', heure_rencontre='".$heure_rencontre."', prix='".$prix."' WHERE id=".$id;

if (mysqli_query($conn, $sql)) {
    echo "success";
} else {
    echo "Error: " . $sql . "<br>" . mysqli_error($conn);
}

mysqli_close($conn);
?>
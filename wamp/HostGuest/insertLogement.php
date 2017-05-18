<?php
require_once('connect.php');

$idHote=$_GET['id_hote'];
$sql1 = "INSERT INTO offres  ( type_offre, id_hote)
VALUES ( 'logement',$idHote)";

if (mysqli_query($conn, $sql1)) {
	 $last_id = mysqli_insert_id($conn);
    
} 


$titre=$_GET['titre'];
$adresse=$_GET['adresse'];
$ville=$_GET['ville'];
$pays=$_GET['pays'];
$prix=$_GET['prix'];
$type=$_GET['type'];

$sql = "INSERT INTO Logements  (id, titre, adresse, ville, pays, prix, type)
VALUES ( '$last_id','$titre','$adresse','$ville','$pays','$prix','$type')";

if (mysqli_query($conn, $sql)) {
    echo "success";
} else {
    echo "Error: " . $sql . "<br>" . mysqli_error($conn);
}

mysqli_close($conn);
?>
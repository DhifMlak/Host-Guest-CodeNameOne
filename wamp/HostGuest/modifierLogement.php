<?php
require_once('connect.php');

$id=$_GET['id'];
$titre=$_GET['titre'];
$adresse=$_GET['adresse'];
$ville=$_GET['ville'];
$pays=$_GET['pays'];
$prix=$_GET['prix'];
$type=$_GET['type'];

$sql = "UPDATE Logements SET titre='".$titre."',adresse='".$adresse."',ville='".$ville."',pays='".$pays."',prix='".$prix."',type='".$type."' WHERE id=".$id ;

if (mysqli_query($conn, $sql)) {
    echo "success";
} else {
    echo "Error: " . $sql . "<br>" . mysqli_error($conn);
}

mysqli_close($conn);
?>
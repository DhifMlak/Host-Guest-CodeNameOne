<?php
require_once('connect.php');

$idHote=$_GET['id_hote'];
$sql1 = "INSERT INTO offres  ( type_offre, id_hote)
VALUES ( 'randonnee',$idHote)";

if (mysqli_query($conn, $sql1)) {
	 $last_id = mysqli_insert_id($conn);
    
} 

$titre=$_GET['titre'];
$lieu=$_GET['lieu'];
$nbMax=$_GET['nbMax'];
$description=$_GET['description'];
$lieu_rencontre=$_GET['lieu_rencontre'];
$heure_rencontre=$_GET['heure_rencontre'];
$prix=$_GET['prix'];

$sql = "INSERT INTO randonnees  (id, titre, lieu, nbMax, description, lieu_rencontre,heure_rencontre,prix,etat)
VALUES ( '$last_id','$titre','$lieu','$nbMax','$description','$lieu_rencontre','$heure_rencontre','$prix','1')";

if (mysqli_query($conn, $sql)) {
    echo "success";
} else {
    echo "Error: " . $sql . "<br>" . mysqli_error($conn);
}

mysqli_close($conn);
?>
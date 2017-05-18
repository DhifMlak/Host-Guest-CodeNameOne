<?php
require_once('connect.php');


$sql1 = "INSERT INTO offres  ( type_offre, id_hote)
VALUES ( 'sortie','1')";

if (mysqli_query($conn, $sql1)) {
    $last_id = mysqli_insert_id($conn);

}




$id=$last_id;
$titre=$_GET['titre'];
$date=$_GET['datep'];
$lieu=$_GET['lieu'];
$description=$_GET['description'];
$nbMax=$_GET['nbMax'];
$conditions=$_GET['conditions'];
$type_sortie=$_GET['type_sortie'];





$sql = "INSERT INTO Sorties  (id, titre , date , lieu, description, nbMax, conditions, type_sortie)
VALUES ( '$last_id','$titre','$date','$lieu' ,'$description','$nbMax','$conditions','$type_sortie')";

if (mysqli_query($conn, $sql)) {
    echo "success";
} else {
    echo "Error: " . $sql . "<br>" . mysqli_error($conn);
}

mysqli_close($conn);
?>
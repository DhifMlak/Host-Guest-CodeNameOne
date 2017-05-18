<?php
require_once('connect.php');

$id=$_GET['id'];

$sql = "DELETE FROM randonnees  WHERE id=".$id;
//$sql1 = "DELETE FROM offres  WHERE id=".$id;

if (mysqli_query($conn, $sql)) {
    //mysqli_query($conn, $sql1)
    echo "success";
} else {
    echo "Error: " . $sql . "<br>" . mysqli_error($conn);
}

mysqli_close($conn);
?>
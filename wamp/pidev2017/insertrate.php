<?php
require_once('connect.php');




$a=$_GET['idsortie'];
$b=$_GET['rate'];






$sql = "INSERT INTO rating  ( idsortie , rate )
VALUES ( '$a','$b')";

if (mysqli_query($conn, $sql)) {
    echo "success";
} else {
    echo "Error: " . $sql . "<br>" . mysqli_error($conn);
}

mysqli_close($conn);
?>
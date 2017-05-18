<?php
require_once('connect.php');

$return_arr = array();

$sql = "SELECT * FROM colors";
$result = $conn->query($sql);
if ($result->num_rows > 0) {
    // output data of each row
    while($row = $result->fetch_assoc()) {
       $row_array['id'] = $row['id'];
       $row_array['colorName'] = $row['colorName'];
       $row_array['hexValue'] = $row['hexValue'];
    array_push($return_arr,$row_array);
    }
} 


echo json_encode($return_arr);

?>
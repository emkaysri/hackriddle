<?php
require("phpsqlajax_dbinfo.php");
$connection = new mysqli($server, $username, $password, $db);

if (!$connection) {
  die('Not connected : ' . mysql_error());
}
if($_PUT)
{
  $lat=$db->prepare($_PUT['lat']);
  $lng=$db->prepare($_PUT['lng']);
// sql to create table
$sql = "INSERT TABLE markers (found, lat, lng) VALUES (0, $lat, $lng)";


if ($connection->query($sql) === TRUE) {
    echo "added values";
} else {
    echo "Error adding values " . $connection->error;
}
}else{
  echo "no Post"
}
$connection->close();
?>

<?php
require("phpsqlajax_dbinfo.php");
$connection = new mysqli($server, $username, $password, $db);

if (!$connection) {
  die('Not connected : ' . mysql_error());
}
$lat=$_GET['lat'];
$lng=$_GET['lng'];
// sql to create table
$sql = "INSERT INTO people_loc (found, lat, lng) VALUES (0, $lat, $lng)";


if ($connection->query($sql) === TRUE) {
    echo "0";
} else {
    echo "1" . $connection->error;
}
$connection->close();
?>

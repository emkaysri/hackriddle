<?php
require("phpsqlajax_dbinfo.php");
$connection = new mysqli($hostname, $username, $password, $database);

if (!$connection) {
  die('Not connected : ' . mysql_error());
}

// sql to create table
$sql = "INSERT TABLE markers (found, lat, lng) VALUES (0, 1, 2)";

if ($connection->query($sql) === TRUE) {
    echo "added values";
} else {
    echo "Error adding values " . $connection->error;
}

$connection->close();
?>

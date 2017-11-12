<?php
require("phpsqlajax_dbinfo.php");
$connection = new mysqli($hostname, $username, $password, $database);

if (!$connection) {
  die('Not connected : ' . mysql_error());
}

$sql = "DROP TABLE markers";

if ($connection->query($sql) === TRUE) {
    echo "Table dropped";
} else {
    echo "Error creating table: " . $connection->error;
}

// sql to create table
$sql = "CREATE TABLE people_loc (
  `id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY ,
  `foun` BIT NOT NULL,
  `lat` FLOAT(10, 6) NOT NULL,
  `lng` FLOAT(10, 6) NOT NULL
)";

if ($connection->query($sql) === TRUE) {
    echo "Table markers created successfully";
} else {
    echo "Error creating table: " . $connection->error;
}

$connection->close();
?>

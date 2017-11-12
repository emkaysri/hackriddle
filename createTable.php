<?php
require("phpsqlajax_dbinfo.php");
$connection = new mysqli($hostname, $username, $password, $database);

if (!$connection) {
  die('Not connected : ' . mysql_error());
}

// sql to create table
$sql = "CREATE TABLE markers (
  `id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY ,
  `name` VARCHAR(60) NOT NULL,
  `address` VARCHAR(80 ) NOT NULL,
  `lat` FLOAT(10, 6) NOT NULL,
  `lng` FLOAT(10, 6) NOT NULL,
  `type` VARCHAR(30) NOT NULL
)";

if ($connection->query($sql) === TRUE) {
    echo "Table markers created successfully";
} else {
    echo "Error creating table: " . $connection->error;
}

$sql = "SHOW TABLES FROM $dbname";
$result = mysql_query($sql);

if (!$result) {
    echo "DB Error, could not list tables\n";
    echo 'MySQL Error: ' . mysql_error();
    exit;
}

while ($row = mysql_fetch_row($result)) {
    echo "Table: {$row[0]}\n";
}

mysql_free_result($result);

$connection->close();
?>

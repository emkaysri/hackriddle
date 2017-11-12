<?php
require("phpsqlajax_dbinfo.php");
$connection = new mysqli($server, $username, $password, $db);

if (!$connection) {
  die('Not connected : ' . mysql_error());
}

$sql = "SELECT FROM people_loc WHERE *";


if ($result = $connection->query($sql)) {
  printf("Select returned %d rows.\n", $result->num_rows);
  $result->close();
} else {
    echo "1" . $connection->error;
}
$connection->close();
?>

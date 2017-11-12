<?php
require("phpsqlajax_dbinfo.php");

// Start XML file, create parent node
$doc = domxml_new_doc("1.0");
$node = $doc->create_element("markers");
$parnode = $doc->append_child($node);

$connection = new mysqli($server, $username, $password, $db);

if (!$connection) {
  die('Not connected : ' . mysql_error());
}

?>

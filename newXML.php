<?php
require("phpsqlajax_dbinfo.php");

// Start XML file, create parent node
$doc = domxml_new_doc("1.0");
$node = $doc->create_element("markers");
$parnode = $doc->append_child($node);

$connection = new mysqli($hostname, $username, $password, $database);

if (!$connection) {
  die('Not connected : ' . mysql_error());
}

// Set the active MySQL database
$db_selected = mysql_select_db($database, $connection);
if (!$db_selected) {
  die ('Can\'t use db : ' . mysql_error());
}

// Select all the rows in the markers table
$query = "SELECT * FROM people_loc WHERE 1";
$result = mysql_query($query);
if (!$result) {
  die('Invalid query: ' . mysql_error());
}

header("Content-type: text/xml");

// Iterate through the rows, adding XML nodes for each
while ($row = @mysql_fetch_assoc($result)){
  // Add to XML document node
  $node = $doc->create_element("marker");
  $newnode = $parnode->append_child($node);
  $newnode->set_attribute("id", $row['id']);
  $newnode->set_attribute("lat", $row['lat']);
  $newnode->set_attribute("lng", $row['lng']);
}

$xmlfile = $doc->dump_mem();
echo $xmlfile;
$connection->close();

?>

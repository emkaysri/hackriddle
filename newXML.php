<?php
require("phpsqlajax_dbinfo.php");

// Start XML file, create parent node
$doc = domxml_new_doc("1.0");
$node = $doc->create_element("markers");
$parnode = $doc->append_child($node);

$connection = new mysqli($server, $username, $password, $db);



// Select all the rows in the markers table
$query = "SELECT * FROM people_loc WHERE found = '0'";
$result = $connection->query($sql)
if ($result->num_rows > 0) {
  die('Invalid query:';
}

header("Content-type: text/xml");

// Iterate through the rows, adding XML nodes for each
while ($row = $result->fetch_assoc()){
  // Add to XML document node
  $node = $doc->create_element("marker");
  $newnode = $parnode->append_child($node);
  $newnode->set_attribute("id", $row['id']);
  $newnode->set_attribute("lat", $row['lat']);
  $newnode->set_attribute("lng", $row['lng']);
}

$xmlfile = $doc->dump_mem();
echo $xmlfile;

?>

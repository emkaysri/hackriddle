<?php
$url = getenv('JAWSDB_URL');
$dbparts = parse_url($url);

$hostname = $dbparts['sp6xl8zoyvbumaa2.cbetxkdyhwsb.us-east-1.rds.amazonaws.com'];
$username = $dbparts['vsu491eodhqjotuf'];
$password = $dbparts['py20vqenruna8574'];
$database = ltrim($dbparts['path'],'/');
?>

<?php
session_start();
    if (!isset($_SESSION["visits"]))
        $_SESSION["visits"] = 0;
    $_SESSION["visits"] = $_SESSION["visits"] + 1;
header( 'Location: /index.html') ;
?>

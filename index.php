<?php
session_start();
if(!$_SESSION['refresh']){
  $_SESSION['refresh'] = -1;
}
header( 'Location: /index.html?', ) ;
?>

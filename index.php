<?php
session_start();
if(!$_SESSION['refresh']){
  $_SESSION['refresh'] = -1;
}
$_SESSION['refresh']= 1 + $_SESSION['refresh'];
header( 'Location: /index.html?', ) ;
?>

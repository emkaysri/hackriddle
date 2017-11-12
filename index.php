<? php

session_start();
    if (!isset($_SESSION["visits"]))
        $_SESSION["visits"] = 0;
    $_SESSION["visits"] = $_SESSION["visits"] + 1;

echo '<!DOCTYPE html>';
echo '<html>';
echo '<head>';
echo '<title>Geolocation</title>';
echo '<meta name="viewport" content="initial-scale=1.0, user-scalable=no">';
echo '<meta charset="utf-8">';
echo '<style>';
echo '/* Always set the map height explicitly to define the size of the div';
echo '* element that contains the map. */';
echo '#map {';
echo 'height: 100%;';
echo '}';
echo '/* Optional: Makes the sample page fill the window. */';
echo 'html, body {';
echo 'height: 100%;';
echo 'margin: 0;';
echo 'padding: 0;';
echo '}';
echo '</style>';
echo '</head>';
echo '<body>';
echo '<div id="map"></div>';
echo '<script>';
echo '// Note: This example requires that you consent to location sharing when';
echo '// prompted by your browser. If you see the error "The Geolocation service';
echo '// failed.", it means you probably did not give permission for the browser to';
echo '// locate you.';
echo 'var map, infoWindow;';
echo 'function initMap() {';
echo '';
echo 'var mapOptions = {';
echo '// How zoomed in you want the map to start at (always required)';
echo 'zoom: 5,';
echo '';
echo '// The latitude and longitude to center the map (always required)';
echo 'center: {lat: 39, lng: -95},';
echo '';
echo '// How you would like to style the map.';
echo '// This is where you would paste any style found on Snazzy Maps.';
echo 'styles: [{"featureType":"all","elementType":"labels","stylers":[{"visibility":"off"}]},{"featureType":"landscape","elementType":"all","stylers":[{"visibility":"on"},{"color":"#f3f4f4"}]},{"featureType":"landscape.man_made","elementType":"geometry","stylers":[{"weight":0.9},{"visibility":"off"}]},{"featureType":"poi.park","elementType":"geometry.fill","stylers":[{"visibility":"on"},{"color":"#83cead"}]},{"featureType":"road","elementType":"all","stylers":[{"visibility":"on"},{"color":"#ffffff"}]},{"featureType":"road","elementType":"labels","stylers":[{"visibility":"off"}]},{"featureType":"road.highway","elementType":"all","stylers":[{"visibility":"on"},{"color":"#fee379"}]},{"featureType":"road.arterial","elementType":"all","stylers":[{"visibility":"on"},{"color":"#fee379"}]},{"featureType":"water","elementType":"all","stylers":[{"visibility":"on"},{"color":"#7fc8ed"}]}]';
echo '};';
echo '';
echo 'map = new google.maps.Map(document.getElementById('map'), mapOptions);';
echo 'infoWindow = new google.maps.InfoWindow;';
echo '';
echo '// Try HTML5 geolocation.';
echo 'if (navigator.geolocation) {';
echo 'navigator.geolocation.getCurrentPosition(function(position) {';
echo 'var pos = {';
echo 'lat: position.coords.latitude,';
echo 'lng: position.coords.longitude';
echo '};';
echo '';
echo 'map.setCenter(pos);';
echo 'map.setZoom(11);';
echo '}, function() {';
echo 'handleLocationError(true, infoWindow, map.getCenter());';
echo '});';
echo '} else {';
echo '// Browser doesn't support Geolocation';
echo 'handleLocationError(false, infoWindow, map.getCenter());';
echo '}';
echo '';
echo '</script>';
echo '<script async defer';
echo 'src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAs9Ws4puGCG0GU2oaNgpl8_1to2SigJAc&callback=initMap">';
echo '</script>';
echo '</body>';
echo '</html>';
echo '';
?>

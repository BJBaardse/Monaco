<%@ page language="java" contentType="text/html; charset=EUC-KR"
         pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8' />
    <title>Display a map</title>
    <meta name='viewport' content='initial-scale=1,maximum-scale=1,user-scalable=no' />
    <script src='https://api.tiles.mapbox.com/mapbox-gl-js/v0.53.1/mapbox-gl.js'></script>
    <link href='https://api.tiles.mapbox.com/mapbox-gl-js/v0.53.1/mapbox-gl.css' rel='stylesheet' />
    <style>
        body { margin:0; padding:0; }
        #map { position:absolute; top:0; bottom:0; width:100%; }
    </style>
</head>
<body>

<div id='map'></div>
<script>
    mapboxgl.accessToken = 'pk.eyJ1Ijoiam9leWJ1cmdlcnMwOTkiLCJhIjoiY2p0cG9iOTZtMDY2azRlczdybHU5OTU2eiJ9.BScZE0DWOamSxZpiYzf4pQ';
    var map = new mapboxgl.Map({
        container: 'map', // container id
        style: 'mapbox://styles/mapbox/streets-v11', // stylesheet location
        center: [7.482523, 43.704097], // starting position [lng, lat]
        zoom: 11 // starting zoom
    });

    map.on('load', function() {
        map.loadImage('Images/SuzikiCarAbove.png', function(error, image) {
            if (error) throw error;
            map.addImage('car', image);
            map.addLayer({
                "id": "points",
                "type": "symbol",
                "source": {
                    "type": "geojson",
                    "data": {
                        "type": "FeatureCollection",
                        "features": [{
                            "type": "Feature",
                            "geometry": {
                                "type": "Point",
                                "coordinates": [7.482523, 43.704097]
                            }
                        }]
                    }
                },
                "layout": {
                    "icon-image": "car",
                    "icon-size": 15
                }
            });
        });
    });
</script>

</body>
</html>

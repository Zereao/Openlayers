<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<html>
<head>
    <title>OpenLayers_Hibernate_Struts2_Demo</title>
    <link href="resources/css/ol.css" rel="stylesheet" type="text/css"/>
    <link href="resources/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <script src="resources/js/ol.js" type="text/javascript"></script>
    <script src="resources/js/jquery-3.2.1.min.js" type="text/javascript"></script>
    <script src="resources/js/bootstrap.min.js" type="text/javascript"></script>

    <style type="text/css">
        #map {
            width: 100%;
            height: 100%;
            position: absolute;
        }

        .fromSearch {
            z-index: 2;
            float: left;
            position: relative;
        }
    </style>
</head>
<body>
<div>
    <div id="map"></div>
    <div class="fromSearch">
        <input type="text" class="form-control" id="ProvinceID" name="province" placeholder="请输入 省/市 查询">
        <button type="submit" class="btn btn-default" onclick="ajaxLoadSrv()">查询</button>
    </div>
</div>
</body>
<script>
    var dataCompany;

    function ajaxLoadSrv() {
        $.ajax({
            type: "POST",
            url: "/company/get",
            produces: "text/html;charset=UTF-8",
            data: {province: $("#ProvinceID").val()},
            error: function (request) {
                alert("Connection error");
            },
            success: function (data) {
                dataCompany = JSON.parse(data);
                addHitArray(dataCompany);
            }
        });
    }
</script>

<script type="text/javascript">
    var layer = new ol.layer.Vector({
        source: new ol.source.Vector()
    });
    var map = new ol.Map({
        target: 'map',
        layers: [
            new ol.layer.Tile({
                source: new ol.source.OSM()
            }),
            layer
        ],
        view: new ol.View({
            projection: 'EPSG:4326',
            center: [112, 42],
            zoom: 4
        })
    });
</script>

<script>
    function getJsonLength(json) {
        var temp = 0;
        for (var i in json) {
            temp++;
        }
        return temp;
    }

    function addHit(X, Y) {
        var anchor = new ol.Feature({
            geometry: new ol.geom.Point([X, Y])
        });
        anchor.setStyle(new ol.style.Style({
            image: new ol.style.Icon({
                src: '/resources/img/tag.png'
            })
        }));
        layer.getSource().addFeature(anchor);
    }

    function addHitArray(jsonArray) {
        for (var i = 0; i < getJsonLength(jsonArray); i++) {
            addHit(jsonArray[i].Y, jsonArray[i].X);
        }
    }
</script>
</html>

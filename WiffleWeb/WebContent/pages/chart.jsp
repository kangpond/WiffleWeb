<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>chart demo</title>
<link href="<s:url value='/css/c3.min.css'/>" rel="stylesheet" type="text/css">
<script src="<s:url value='/js/d3.v3.min.js'/>" charset="utf-8"></script>
<script src="<s:url value='/js/c3.min.js'/>" ></script>
<script src="<s:url value='/js/topojson.v1.min.js'/>"></script>
<script src="<s:url value='/js/jquery/plugin/jquery-1.11.3.min.js'/>" ></script>
<style>
body {
    background-color: #FFFFFF;
}

.subunit-boundary {
    fill: none;
    stroke: #fff;
    stroke-dasharray: 5, 0;
    stroke-linejoin: round;
}

#panel {
    position: absolute;
    z-index: 99;
    height: 20px;
    width: 60px;
    background-color: #fff;
    -webkit-transition: all .1s;
    border-radius: 5px;
    background-color: #000;
    background-color: rgba(0, 0, 0, 0.3);
    color: #fff;
    padding: 10px;
}

.svgback {
    background-color: #ffffff;
}
</style>
</head>
<body>

<div id='panel' style="display: none">
    <span id='title'></span><br />
</div>

<script>

var width = 800,
    height = 600;
var svg = d3.select("body").append("svg")
    // .attr("class", "svgback")
    .attr("width", width)
    .attr("height", height);

var projection = d3.geo.mercator()
    .center([121,24])
    .scale(6000);

var path = d3.geo.path()
    .projection(projection);

// load and display the World
d3.json("taiwan.city.topojson", function(error, topology) {
    var g = svg.append("g");
    
    // load and display the cities
    d3.csv("taiwan.city.csv", function(error, data) {
        g.selectAll("circle")
           .data(data)
           .enter()
           .append("circle")
           .attr("cx", function(d) {
                   return projection([d.lon, d.lat])[0];
           })
           .attr("cy", function(d) {
                   return projection([d.lon, d.lat])[1];
           })
           .attr("r", 5)
           .style("fill", "red");
    });
    
    d3.select("svg").append("path").datum(
            topojson.mesh(topology,
                    topology.objects["TaiwanCity"], function(a,
                            b) {
                        return a !== b;
                    })).attr("d", path).attr("class","subunit-boundary");
    
    d3.select("g").selectAll("path")
          .data(topojson.feature(topology, topology.objects.TaiwanCity).features)
          .enter()
          .append("path")
          .attr("d", path)
          .attr({
                d : path,
                name : function(d) {
                    return d.properties["C_Name"];
                },
                fill : '#55AA00'
        });
    
    d3.select("svg").selectAll("path").on("mouseenter", function() {
        // console.log(e);
        fill = $(this).attr("fill");
        $(this).attr("fill", '#00DD77');
    
        $('#title').html($(this).attr("name"));
        $('#panel').css({
            "height" : "20px",
            "width" : "60px"
        });
    }).on("mouseout", function() {
        $(this).attr("fill", fill);
    });
    
    $("path").mouseover(function(e) {
        if($('#panel').is(':visible')){
            $('#panel').css({
                'top' : e.pageY,
                'left' : e.pageX
            });
        } else {
            $('#panel').fadeIn('slow').fadeOut();
        }
    });

});

setInterval(function() {
    d3.csv("taiwan.city2.csv", function(error, data) {
        svg.select("g").selectAll("circle").remove();
        
        // new data joins old elements 'circle'
        var update = svg.append("g").selectAll("circle")
            .data(data)
            .enter()
            .append("circle")
            .attr("cx", function(d) {
                return projection([d.lon, d.lat])[0];
            })
            .attr("cy", function(d) {
                    return projection([d.lon, d.lat])[1];
            })
            .attr("r", 5)
            .style("fill", "red");
    });
}, 2000);
</script>

<hr>

<div id="chart"></div>
<script>
var chart = c3.generate({
    bindto: '#chart',
	size: {
        height: 480,
        width: 880
    },
    data: {
		x:'x',
      columns: [
	    ['x', '一月', '二月', '三月', '四月', '五月', '六月'],
        ['資料1', 30, 200, 100, 400, 150, 250],
        ['資料2', 50, 20, 10, 40, 15, 25],
		['資料3', 60, 100, 70, 120, 85, 150]
      ],
	  types: {
	  	'資料1': 'spline',
        '資料2': 'bar', 
        '資料3': 'spline' 
      },
	  colors: {
        '資料1': '#ff7777',
        '資料2': '#33ff77',
        '資料3': '#7777ff'
      }
    },
    axis: {
		x: {
			type: 'category',
			label: {
				text: 'X軸標籤',
				position: 'outer-middle'
			}
		},
		y: {
			label: { // ADD
				text: 'Y軸標籤',
				position: 'outer-middle'
			}
		}
	},
    zoom: {
        enabled: true
    }
});

function loadData(){
	chart.load({
	  columns: [
	    ['資料1', 300, 100, 250, 150, 300, 150],
	    ['資料2', 100, 200, 150, 50, 100, 250],
		['資料3', 200, 100, 50, 100, 200, 150]
	  ]
	});	
}
function showData(){
	chart.show(['資料2', '資料3']);	
}
function hideData(){
	chart.hide(['資料2', '資料3']);
}
function toPie(){
	chart.transform('pie');
}
function toLine(){
	chart.transform('line');
}
function toBar(){
	chart.transform('bar');
}
</script>
<p align="center">
<button onclick="loadData();">變更資料</button>
<button onclick="hideData();">隱藏資料</button>
<button onclick="showData();">顯示資料</button>
<button onclick="toPie();">轉圓餅圖</button>
<button onclick="toLine();">顯曲線圖</button>
<button onclick="toBar();">顯直條圖</button>
</p>

<hr>

<div id="barChart"></div>
<script>
var barChart = c3.generate({
    bindto: '#barChart',
    data: {
      columns: [
        ['資料1', 30, 200, 100, 400, 150, 250],
        ['資料2', 50, 20, 10, 40, 15, 25],
		['資料3', 60, 100, 70, 120, 85, 150]
      ],
	  types: {
	  	'資料1': 'bar',
        '資料2': 'bar', 
        '資料3': 'bar' 
      },
	  groups: [
        ['資料2', '資料3']
      ]
    },
    axis: {
		rotated: true,
		x: {
			label: { // ADD
				text: 'X軸標籤',
				position: 'outer-middle'
			}
		},
		y: {
			label: { // ADD
				text: 'Y軸標籤',
				position: 'outer-middle'
			}
		}
	}
});

function loadBarData(){
	barChart.load({
	  columns: [
	    ['資料1', 300, 100, 250, 150, 300, 150],
	    ['資料2', 100, 200, 150, 50, 100, 250],
		['資料3', 200, 100, 50, 100, 200, 150]
	  ]
	});	
}
function showBarData(){
	barChart.show(['資料2', '資料3']);
}
function hideBarData(){
	barChart.hide(['資料2', '資料3']);
}
</script>
<p align="center">
<button onclick="loadBarData();">變更資料</button>
<button onclick="hideBarData();">隱藏資料</button>
<button onclick="showBarData();">顯示資料</button>
</p>

<hr>

<div id="pieChart"></div>
<script>
var pieChart = c3.generate({
    bindto: '#pieChart',
    data: {
      columns: [
	    ['資料1', 300, 100, 250, 150, 300, 150],
	    ['資料2', 100, 200, 150, 50, 100, 250],
		['資料3', 200, 100, 50, 100, 200, 150]
      ],
	  type: 'pie',
	  onclick: function (d, i) { console.log("onclick", d, i); },
      onmouseover: function (d, i) { console.log("onmouseover", d, i); },
      onmouseout: function (d, i) { console.log("onmouseout", d, i); }
    },
    axis: {
		x: {
			label: { // ADD
				text: 'X軸標籤',
				position: 'outer-middle'
			}
		},
		y: {
			label: { // ADD
				text: 'Y軸標籤',
				position: 'outer-middle'
			}
		}
	}
});

function loadPieData(){
	pieChart.load({
	  columns: [
	    ['資料1', 30, 130, 250, 150, 300, 150],
	    ['資料2', 10, 00, 150, 50, 10, 20],
		['資料3', 20, 140, 80, 180, 280, 190]
	  ]
	});	
}
function showPieData(){
	pieChart.show(['資料3']);
}
function hidePieData(){
	pieChart.hide(['資料3']);
}
</script>
<p align="center">
<button onclick="loadPieData();">變更資料</button>
<button onclick="hidePieData();">隱藏資料</button>
<button onclick="showPieData();">顯示資料</button>
</p>

</body>
</html>
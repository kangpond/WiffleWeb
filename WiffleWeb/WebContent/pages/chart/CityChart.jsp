<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- <link href="${pageContext.request.contextPath}/css/c3.min.css" rel="stylesheet" type="text/css"> --%>
<link href="${pageContext.request.contextPath}/css/chart.css" rel="stylesheet" type="text/css">
<script src="${pageContext.request.contextPath}/js/d3.v3.min.js" charset="utf-8"></script>
<%-- <script src="${pageContext.request.contextPath}/js/c3.min.js" ></script> --%>
<script src="${pageContext.request.contextPath}/js/topojson.v1.min.js"></script>

<c:set var="csvPath" value="${pageContext.request.contextPath}/pages/chart/" />
<c:set var="cityChartId" value="${param.cityChartId}" />

<div id="cityChartDiv" style="min-width: 800px; text-align: center; padding: 10px;">
	<div id="cityTooltipDiv" class="cityTooltip">
		<div id="name"></div>
		<div id="cnt"></div>
		<div id="unit">( 單位:人 )</div>
	</div>
	<svg id="citySvg" viewBox="0 0 800 560" preserveAspectRatio="xMidYMid" class="citySvg">loading...</svg>
</div>
<div id="d_tips_${cityChartId}" class="cityTooltip" style="display: none">
	 <span id="d_tipsName_${cityChartId}"></span><br />
</div>
<script type="text/javascript">
	(function($) {

		$(document).ready(function() {
		});

		var pathColor, pathWidth, rectColor, rectWidth, lineColor, lineWidth;

		${cityChartId}_cityChart = function(cityChartData) {

			if (d3.select("#citySvg")) {
				d3.select("#citySvg").selectAll("*").remove();
			}

			//d3.select("body").append("#citySvg").attr("class", "citySvg");

			// Define the div for the tooltip
			//var tipsDiv = d3.select("body").append("div").attr("class", "cityTooltip").style("opacity", 0);

			var cityDataMap = cityChartData.dataMap;
			d3.json("${csvPath}taiwan.city.json", function(topodata) {
				//var maxCnt = d3.max(density, function(d){return d});
				var color = d3.scale.linear().domain([ 0, cityChartData.maxCnt ]).range([ "#FFCCCC", "#880000" ]);
				var features = topojson.feature(topodata, topodata.objects.county).features;
				var projection = d3.geo.mercator().center([ 121, 24.3 ]).scale(6500);
				var path = d3.geo.path().projection(projection);
				for (idx = features.length - 1; idx >= 0; idx--) {
					features[idx].density = cityDataMap[features[idx].properties.C_Name];
				}

				var shadow = d3.select("#citySvg").append("shadow");
				var shadow_projection = d3.geo.mercator().center([ 122, 23 ]).scale(6500);
				var shadow_path = d3.geo.path().projection(shadow_projection);
				shadow.selectAll("path").data(features).enter().append("path")
					.attr("d", shadow_path)
					.attr("fill", function(d) {return color(100000);});

				d3.select("#citySvg").selectAll("path").data(features).enter().append("path");

				d3.select("#citySvg").selectAll("path")
					.attr("d", path)
					.attr("fill", function(d) {return color(d.density);})
					.attr("name", function(d) {return (d.properties["C_Name"] + d.density + "人");})
					.attr("cnt", function(d) {return +d.density;})
					.attr("id", function(d) { return "path_" + d.properties["C_Name"]; })
					.attr("class", "cityPath");

				drawTips(cityChartData, projection);
			});
		}

		drawTips = function (cityChartData, projection) {

			d3.select("#citySvg").selectAll("path").on("mouseenter", function(d) {
				//fillColor = $(this).attr("fill");
				//$(this).attr("fill", "#BBFFEE");
				pathColor = $(this).css("stroke");
				pathWidth = $(this).css("stroke-width");
				rectColor = d3.select("#rect_" + d.properties["C_Name"]).style("stroke");
				rectWidth = d3.select("#rect_" + d.properties["C_Name"]).style("stroke-width");
				lineColor = d3.select("#line_" + d.properties["C_Name"]).style("stroke");
				lineWidth = d3.select("#line_" + d.properties["C_Name"]).style("stroke-width");
				$(this).css("stroke", "#009FAA");
				$(this).css("stroke-width", "4px");
				d3.select("#rect_" + d.properties["C_Name"]).style("stroke", "#F08030");
				d3.select("#rect_" + d.properties["C_Name"]).style("stroke-width", "4px");
				d3.select("#line_" + d.properties["C_Name"]).style("stroke", "#F08030");
				d3.select("#line_" + d.properties["C_Name"]).style("stroke-width", "4px");
			}).on("mouseout", function(d) {
				$(this).css("stroke", pathColor);
				$(this).css("stroke-width", pathWidth);
				d3.select("#rect_" + d.properties["C_Name"]).style("stroke", rectColor);
				d3.select("#rect_" + d.properties["C_Name"]).style("stroke-width", rectWidth);
				d3.select("#line_" + d.properties["C_Name"]).style("stroke", lineColor);
				d3.select("#line_" + d.properties["C_Name"]).style("stroke-width", lineWidth);
				// $("#d_tips_${cityChartId}").fadeOut();
			}).on("mouseover", function(d) {
				$("#name").text(d.properties["C_Name"]);
				$("#cnt").text(d.density);
				//d3.select("#d_tips_${cityChartId}").transition().duration(200).style("opacity", .9);
				//d3.select("#d_tips_${cityChartId}").html(d.density).style("top", (d3.event.pageY - 28) + "px").style("left", (d3.event.pageX) + "px");
			});

			if (cityChartData.cityTipsList != null) {
				// draw the Tips
				var g = d3.select("#citySvg").append("g");
				g.selectAll("circle").data(cityChartData.cityTipsList).enter().append("circle")
					.attr("cx", function(d) {return projection([+d.lon, +d.lat])[0];})
					.attr("cy", function(d) {return projection([+d.lon, +d.lat])[1];})
					.attr("r", 2)
					.attr("class", "cityDescCircle");

				g.selectAll("line").data(cityChartData.cityTipsList).enter().append("line")
					.attr("x1", function(d) {return projection([+d.lon, +d.lat])[0];})
					.attr("y1", function(d) {return projection([+d.lon, +d.lat])[1];})
					.attr("x2", function(d) {return projection([getLineX2(+d.x2), +d.y2])[0];})
					.attr("y2", function(d) {return projection([getLineX2(+d.x2), +d.y2])[1];})
			        .attr("id", function(d) { return "line_" + d.codeDataValueDesc; })
					.attr("class", "cityDescLine");

				g.selectAll("rect").data(cityChartData.cityTipsList).enter().append("rect")
			        .attr("x", function(d) {return projection([+d.x2-0.1, +d.y2+0.18])[0];})
			        .attr("y", function(d) {return projection([+d.x2-0.1, +d.y2+0.18])[1];})
			        .attr("rx", 8)
			        .attr("ry", 8)
			        .attr("width", function(d) { return 150; })
			        .attr("height", function(d) { return 32; })
			        .attr("id", function(d) { return "rect_" + d.codeDataValueDesc; })
			        .attr("class", "cityDescRect");

				var cityDataMap = cityChartData.dataMap;
				g.selectAll("rect").on("mouseenter", function(d) {
					tipsOnMouseEnter(d);
				}).on("mouseout", function(d) {
					tipsOnMouseOut(d);
				}).on("mouseover", function(d) {
					tipsOnMouseOver(d, cityDataMap);
				});

				g.selectAll("text").data(cityChartData.cityTipsList).enter().append("text").text(function(d) {
					return d.codeDataValueDesc + d.cnt + "人";
				}).attr("x", function(d) {
					return projection([ +d.x2, +d.y2 ])[0];
				}).attr("y", function(d) {
					return projection([ +d.x2, +d.y2 ])[1];
				}).attr("class", "cityDescText");

				g.selectAll("text").on("mouseenter", function(d) {
					tipsOnMouseEnter(d);
				}).on("mouseout", function(d) {
					tipsOnMouseOut(d);
				}).on("mouseover", function(d) {
					tipsOnMouseOver(d, cityDataMap);
				});
			}
		}

		getLineX2 = function(textX2) {
			if (textX2 < 121) {
				return textX2 + 0.8;
			}
			return textX2;
		}

		tipsOnMouseEnter = function(d) {
			pathColor = $("#path_" + d.codeDataValueDesc).css("stroke");
			pathWidth = $("#path_" + d.codeDataValueDesc).css("stroke-width");
			rectColor = $("#rect_" + d.codeDataValueDesc).css("stroke");
			rectWidth = $("#rect_" + d.codeDataValueDesc).css("stroke-width");
			lineColor = $("#line_" + d.codeDataValueDesc).css("stroke");
			lineWidth = $("#line_" + d.codeDataValueDesc).css("stroke-width");
			$("#path_" + d.codeDataValueDesc).css("stroke", "#009FAA");
			$("#path_" + d.codeDataValueDesc).css("stroke-width", "4px");
			$("#rect_" + d.codeDataValueDesc).css("stroke", "#F08030");
			$("#rect_" + d.codeDataValueDesc).css("stroke-width", "4px");
			$("#line_" + d.codeDataValueDesc).css("stroke", "#F08030");
			$("#line_" + d.codeDataValueDesc).css("stroke-width", "4px");
		}

		tipsOnMouseOut = function(d) {
			$("#path_" + d.codeDataValueDesc).css("stroke", pathColor);
			$("#path_" + d.codeDataValueDesc).css("stroke-width", pathWidth);
			$("#rect_" + d.codeDataValueDesc).css("stroke", rectColor);
			$("#rect_" + d.codeDataValueDesc).css("stroke-width", rectWidth);
			$("#line_" + d.codeDataValueDesc).css("stroke", lineColor);
			$("#line_" + d.codeDataValueDesc).css("stroke-width", lineWidth);
		}

		tipsOnMouseOver = function(d, cityDataMap) {
			var density = cityDataMap[d.codeDataValueDesc];
			$("#name").text(d.codeDataValueDesc);
			$("#cnt").text(density);
		}

	})(jQuery);
</script>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link href="${pageContext.request.contextPath}/css/c3.min.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/css/chart.css" rel="stylesheet" type="text/css">
<script src="${pageContext.request.contextPath}/js/d3.v3.min.js" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/js/c3.min.js" ></script>
<script src="${pageContext.request.contextPath}/js/topojson.v1.min.js"></script>

<c:set var="csvPath" value="${pageContext.request.contextPath}/pages/chart/" />
<c:set var="graphChartId" value="${param.graphChartId}" />
<div id="d_graphChart_${graphChartId}"></div>
<script type="text/javascript">
	(function($) {

		$(document).ready(function() {
			jQuery("#d_graphChart_${graphChartId}").hide();
		});

		var graphChart;

		${graphChartId}_graphChart = function(graphChartData) {

			jQuery("#d_graphChart_${graphChartId}").hide();
			graphChart = null;
			if (graphChartData == null || graphChartData.dataList == null) {
				alert("查無圖資料");
				return;
			}

			jQuery("#d_graphChart_${graphChartId}").show();

			var chart_w;
			try { chart_w = (graphChartData.dataList[0].length - 1) * 50; } catch (e) {};
			if (isEmpty(chart_w) || chart_w < 600)
				chart_w = 600;

			graphChart = c3.generate({
				bindto : '#d_graphChart_${graphChartId}',
				size : {
					height : 550,
					width : chart_w
				},
				data : {
					x : 'x',
					/* columns : [ [ 'x', '一月', '二月', '三月', '四月', '五月', '六月' ],
							[ '資料1', 30, 200, 100, 400, 150, 250 ], [ '資料2', 50, 20, 10, 40, 15, 25 ],
							[ '資料3', 60, 100, 70, 120, 85, 150 ] ], */
					columns : graphChartData.dataList,
					type : 'line',
					labels: true
				},
				axis : {
					x : {
						type : 'category',
						label : {
							text : graphChartData.xName,
							position : 'outer-middle'
						}
					},
					y : {
						label : { // ADD
							text : graphChartData.yName,
							position : 'outer-middle'
						}
					}
					/* ,
					y2 : {
						show: true,
						label : { // ADD
							text : 'Y2軸標籤',
							position : 'outer-middle'
						}
					} */
				},
				zoom : {
					enabled : false
				}
			});
		};

	})(jQuery);
</script>

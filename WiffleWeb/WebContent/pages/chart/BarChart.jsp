<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link href="${pageContext.request.contextPath}/css/c3.min.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/css/chart.css" rel="stylesheet" type="text/css">
<script src="${pageContext.request.contextPath}/js/d3.v3.min.js" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/js/c3.min.js" ></script>
<script src="${pageContext.request.contextPath}/js/topojson.v1.min.js"></script>

<c:set var="csvPath" value="${pageContext.request.contextPath}/pages/chart/" />
<c:set var="barChartId" value="${param.barChartId}" />
<div id="d_barChart_${barChartId}"></div>
<script type="text/javascript">
	(function($) {

		$(document).ready(function() {
			jQuery("#d_barChart_${barChartId}").hide();
		});

		var barChart;

		${barChartId}_barChart = function(barChartData) {

			jQuery("#d_barChart_${barChartId}").hide();
			barChart = null;

			if (barChartData == null || barChartData.dataList == null) {
				alert("查無圖資料");
				return;
			}

			jQuery("#d_barChart_${barChartId}").show();

			var chart_w;
			try { chart_w = (barChartData.dataList.length - 1) * (barChartData.dataList[0].length - 1) * 30; } catch (e) {};
			if (isEmpty(chart_w) || chart_w < 600)
				chart_w = 600;

			barChart = c3.generate({
				bindto : '#d_barChart_${barChartId}',
				size : {
					height : 550,
					width : chart_w
				},
				data : {
					x : 'x',
					columns : barChartData.dataList,
					type : 'bar',
					labels: true
				},
				axis : {
					x : {
						type : 'category',
						label : {
							text : barChartData.xName,
							position : 'outer-middle'
						}
					},
					y : {
						label : { // ADD
							text : barChartData.yName,
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

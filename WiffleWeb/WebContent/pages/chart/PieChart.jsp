<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link href="${pageContext.request.contextPath}/css/c3.min.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/css/chart.css" rel="stylesheet" type="text/css">
<script src="${pageContext.request.contextPath}/js/d3.v3.min.js" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/js/c3.min.js" ></script>
<script src="${pageContext.request.contextPath}/js/topojson.v1.min.js"></script>

<c:set var="csvPath" value="${pageContext.request.contextPath}/pages/chart/" />
<c:set var="pieChartId" value="${param.pieChartId}" />
<div id="d_pieChart_${pieChartId}"></div>
<script type="text/javascript">
	(function($) {

		$(document).ready(function() {
			jQuery("#d_pieChart_${pieChartId}").hide();
		});

		var pieChart;

		${pieChartId}_pieChart = function(pieChartData) {

			jQuery("#d_pieChart_${pieChartId}").hide();
			pieChart = null;

			if (pieChartData == null || pieChartData.dataList == null) {
				alert("查無圖資料");
				return;
			}

			jQuery("#d_pieChart_${pieChartId}").show();

			pieChart = c3.generate({
				bindto : '#d_pieChart_${pieChartId}',
				size : {
					height : 550,
					width : 900
				},
				data : {
					/* columns : [ [ '資料1', 300, 100, 250, 150, 300, 150 ], [ '資料2', 100, 200, 150, 50, 100, 250 ],
							[ '資料3', 200, 100, 50, 100, 200, 150 ] ], */
					columns : pieChartData.dataList,
					type : 'pie',
					onclick : function(d, i) {
						//console.log("onclick", d, i);
					},
					onmouseover : function(d, i) {
						//console.log("onmouseover", d, i);
					},
					onmouseout : function(d, i) {
						//console.log("onmouseout", d, i);
					}
				},
				pie: {
					label: {
						format: function (value, ratio, id) {
			                return value + ' 人';//d3.format('$');
			            }
					}
				}
			});
		};

	})(jQuery);
</script>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags"%>

<script type="text/javascript">
	(function($) {
		$(document).ready(function() {

			if ('' != '${message}') {
				alert('${message}');
			}

			$("#bt_toQuery").click(function() {
				$("#form").attr("action", "query").submit();
			});

			$("#bt_report").click(function() {
				$("#form").attr("action", "report").submit();
			});

			$("#tabs").tabs();

			$(".d_diagram").css("width", (getBrowserWidth() - 360) + "px");
			$(".tableDiv").css("width", (getBrowserWidth() - 340) + "px");
		});
	})(jQuery);
</script>
<input type="hidden" name="startYearResults" value="${startYearResults}" />
<input type="hidden" name="startMonthResults" value="${startMonthResults}" />
<input type="hidden" name="endYearResults" value="${endYearResults}" />
<input type="hidden" name="endMonthResults" value="${endMonthResults}" />
<input type="hidden" name="cityResult" value="${cityResult}" />
<c:if test="${not empty param.monthOfHeader}">
<h2><span>${param.monthOfHeader}-列表頁</span></h2>
</c:if>
<section class="styleTb2">
	<div id="tabs">
		<ul>
			<li><a href="#tabs-1">表</a></li>
			<li><a href="#tabs-2" onclick="onShowBarChart();">長條圖</a></li>
			<li><a href="#tabs-3" onclick="onShowGraphChart();">曲線圖</a></li>
			<li><a href="#tabs-4" onclick="onShowPieChart();">圓餅圖</a></li>
		</ul>
		<div id="tabs-1" class="mid"><div class="tableDiv"><s:property value="tableHtml" escapeHtml="false" /></div></div>
		<div id="tabs-2" class="mid diagram">
			<div class="d_diagram" id="barChartDiv">
				<c:set var="barChartId" value="monthOf" />
				<jsp:include page="/pages/chart/BarChart.jsp">
					<jsp:param name="barChartId" value="${barChartId}" />
				</jsp:include>
				<script type="text/javascript">
					function onShowBarChart() {
						jQuery.getJSON('barChart_ajax', {
							startYearResults : "${startYearResults}",
							startMonthResults : "${startMonthResults}",
							endYearResults : "${endYearResults}",
							endMonthResults : "${endMonthResults}"
						}, function(response) {
							if (response.barChartData != null) {
								try { ${barChartId}_barChart(response.barChartData); } catch(e) {};
							}
						});
					}
				</script>
			</div>
		</div>
		<div id="tabs-3" class="mid diagram">
			<div class="d_diagram" id="graphChartDiv">
				<c:set var="graphChartId" value="monthOf" />
				<jsp:include page="/pages/chart/GraphChart.jsp">
					<jsp:param name="graphChartId" value="${graphChartId}" />
				</jsp:include>
				<script type="text/javascript">
					function onShowGraphChart() {
						jQuery.getJSON('graphChart_ajax', {
							startYearResults : "${startYearResults}",
							startMonthResults : "${startMonthResults}",
							endYearResults : "${endYearResults}",
							endMonthResults : "${endMonthResults}"
						}, function(response) {
							if (response.graphChartData != null) {
								try { ${graphChartId}_graphChart(response.graphChartData); } catch(e) {};
							}
						});
					}
				</script>
			</div>
		</div>
		<div id="tabs-4" class="mid diagram">
			<div class="d_diagram" id="pieChartDiv">
				<c:set var="pieChartId" value="monthOf" />
				<jsp:include page="/pages/chart/PieChart.jsp">
					<jsp:param name="pieChartId" value="${pieChartId}" />
				</jsp:include>
				<script type="text/javascript">
					function onShowPieChart() {
						jQuery.getJSON('pieChart_ajax', {
							startYearResults : "${startYearResults}",
							startMonthResults : "${startMonthResults}",
							endYearResults : "${endYearResults}",
							endMonthResults : "${endMonthResults}"
						}, function(response) {
							if (response.pieChartData != null) {
								try { ${pieChartId}_pieChart(response.pieChartData); } catch(e) {};
							}
						});
					}
				</script>
			</div>
		</div>
	</div>
	<section class="butCenter">
	  <input type="button" id="bt_report" class="btn2" value="下載Excel報表" />
	  <input type="button" id="bt_toQuery" class="btn2" value="回查詢頁" />
	</section>
</section>

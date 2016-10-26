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
<input type="hidden" name="yearResults" value="${yearResults}" />
<input type="hidden" name="monthResults" value="${monthResults}" />
<input type="hidden" name="cityResult" value="${cityResult}" />
<input type="hidden" name="townResult" value="${townResult}" />
<input type="hidden" name="fsTypeResult" value="${fsTypeResult}" />
<c:if test="${not empty param.cityOfHeader}">
<h2><span>${param.cityOfHeader}-列表頁</span></h2>
</c:if>
<section class="styleTb2">
	<div id="tabs">
		<ul>
			<li><a href="#tabs-1">表</a></li>
			<li><a href="#tabs-2" onclick="onShowBarChart();">長條圖</a></li>
			<li><a href="#tabs-3" onclick="onShowGraphChart();">曲線圖</a></li>
			<li><a href="#tabs-4" onclick="onShowPieChart();">圓餅圖</a></li>
			<li><a href="#tabs-5" onclick="onShowCityChart();">地理資訊</a></li>
		</ul>
		<div id="tabs-1" class="mid"><div class="tableDiv"><s:property value="tableHtml" escapeHtml="false" /></div></div>
		<div id="tabs-2" class="mid diagram">
			<div class="d_diagram" id="barChartDiv">
				<c:set var="barChartId" value="cityOf" />
				<jsp:include page="/pages/chart/BarChart.jsp">
					<jsp:param name="barChartId" value="${barChartId}" />
				</jsp:include>
				<script type="text/javascript">
					function onShowBarChart() {
						jQuery.getJSON('barChart_ajax', {
							yearResults : "${yearResults}",
							monthResults : "${monthResults}",
							cityResult : "${cityResult}",
							townResult : "${townResult}",
							fsTypeResult : "${fsTypeResult}"
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
				<c:set var="graphChartId" value="cityOf" />
				<jsp:include page="/pages/chart/GraphChart.jsp">
					<jsp:param name="graphChartId" value="${graphChartId}" />
				</jsp:include>
				<script type="text/javascript">
					function onShowGraphChart() {
						jQuery.getJSON('graphChart_ajax', {
							yearResults : "${yearResults}",
							monthResults : "${monthResults}",
							cityResult : "${cityResult}",
							townResult : "${townResult}",
							fsTypeResult : "${fsTypeResult}"
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
				<c:set var="pieChartId" value="cityOf" />
				<jsp:include page="/pages/chart/PieChart.jsp">
					<jsp:param name="pieChartId" value="${pieChartId}" />
				</jsp:include>
				<script type="text/javascript">
					function onShowPieChart() {
						jQuery.getJSON('pieChart_ajax', {
							yearResults : "${yearResults}",
							monthResults : "${monthResults}",
							cityResult : "${cityResult}",
							townResult : "${townResult}",
							fsTypeResult : "${fsTypeResult}"
						}, function(response) {
							if (response.pieChartData != null) {
								try { ${pieChartId}_pieChart(response.pieChartData); } catch(e) {};
							}
						});
					}
				</script>
			</div>
		</div>
		<div id="tabs-5" class="mid diagram">
			<div class="d_diagram" id="cityChartDiv">
				<c:set var="cityChartId" value="cityOf" />
				<jsp:include page="/pages/chart/CityChart.jsp">
					<jsp:param name="cityChartId" value="${cityChartId}" />
				</jsp:include>
				<script type="text/javascript">
					function onShowCityChart() {
						jQuery.getJSON('cityChart_ajax', {
							yearResults : "${yearResults}",
							monthResults : "${monthResults}",
							cityResult : "${cityResult}",
							townResult : "${townResult}",
							fsTypeResult : "${fsTypeResult}"
						}, function(response) {
							if (response.cityChartData != null) {
								try { ${cityChartId}_cityChart(response.cityChartData); } catch(e) {};
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

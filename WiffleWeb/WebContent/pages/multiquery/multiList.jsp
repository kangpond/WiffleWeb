<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>

<c:set var="col_attr_id" value="colAttr" />
<c:set var="row_attr_id" value="rowAttr" />
<c:set var="bar_attr_id" value="barAttr" />
<c:set var="graph_attr_id" value="graphAttr" />
<c:set var="pie_attr_id" value="pieAttr" />
<c:set var="city_attr_id" value="cityAttr" />

<script type="text/javascript">
(function($) {
	$(document).ready(function() {

		if ('' != '${message}') {
			alert('${message}');
		}

		$("#bt_toQuery").click(function() {
			$("#form").attr("action", "query").submit();
		});

		$("#bt_dlReport").click(function() {
			//alert(jQuery("select[name='${col_attr_id}Results']").map(function() { return $(this).val(); }).get());
			$("#form").attr("action", "dlReport").submit();
		});

		jQuery("#barChartDiv").hide();
		jQuery("#graphChartDiv").hide();
		jQuery("#pieChartDiv").hide();
		jQuery("#cityChartDiv").hide();

		$.getJSON('ds_ajax', {}, function(response) {
			if (response.dsCodeList != null) {
				try { ${col_attr_id}_linkSBox(response.dsCodeList); } catch(e) {};
				try { ${row_attr_id}_linkSBox(response.dsCodeList); } catch(e) {};
				try { ${bar_attr_id}_linkSBox(response.dsCodeList); } catch(e) {};
				try { ${graph_attr_id}_linkSBox(response.dsCodeList); } catch(e) {};
				try { ${pie_attr_id}_linkSBox(response.dsCodeList); } catch(e) {};
				try { ${city_attr_id}_linkSBox(response.dsCodeList); } catch(e) {};
			}
		});
	});

	showChartDiv = function(showDivId) {
		$(".d_diagram").hide();
		$("#" + showDivId).show();
	}

})(jQuery);
</script>

<c:set var="th_width" value="200px" />
<s:form id="form" cssClass="form" namespace="multiquery" method="post">
<input type="hidden" name="attrFilter" value="${attrFilter}" />
<input type="hidden" name="startYearResults" value="${startYearResults}" />
<input type="hidden" name="endYearResults" value="${endYearResults}" />
<input type="hidden" name="startMonthResults" value="${startMonthResults}" />
<input type="hidden" name="endMonthResults" value="${endMonthResults}" />
<div class="d_th left">一、統計分析表</div>
<section class="styleTb" style="margin: 2px auto;">
	<table>
		<tr>
			<th style="width: ${th_width};"><label>欄(至少選一項)</label></th>
			<td>
				<jsp:include page="/pages/component/LinkSelectBox.jsp">
					<jsp:param name="linkSBoxId" value="${col_attr_id}" />
					<jsp:param name="linkSBoxNum" value="2" />
				</jsp:include>
			</td>
			<td rowspan="2" style="width: ${th_width};">
				<input type="button" id="bt_dlReport" class="innerBtn" value="下載報表" />
			</td>
		</tr>
		<tr>
			<th style="width: ${th_width};"><label>列(至少選一項)</label></th>
			<td>
				<jsp:include page="/pages/component/LinkSelectBox.jsp">
					<jsp:param name="linkSBoxId" value="${row_attr_id}" />
					<jsp:param name="linkSBoxNum" value="3" />
				</jsp:include>
			</td>
		</tr>
	</table>
</section>
<div class="d_th left">二、統計圖</div>
<section class="styleTb" style="margin: 2px auto;">
	<table>
		<tr>
			<th style="width: ${th_width};"><label>長條圖(最多選兩項)</label></th>
			<td>
				<jsp:include page="/pages/component/LinkSelectBox.jsp">
					<jsp:param name="linkSBoxId" value="${bar_attr_id}" />
					<jsp:param name="linkSBoxNum" value="2" />
				</jsp:include>
			</td>
			<td style="width: ${th_width};">
				<input type="button" id="bt_barChart" value="長條圖" class="innerBtn" onclick="onShowBarChart();" />
			</td>
		</tr>
		<tr>
			<th style="width: ${th_width};"><label>曲線圖(最多選兩項)</label></th>
			<td>
				<jsp:include page="/pages/component/LinkSelectBox.jsp">
					<jsp:param name="linkSBoxId" value="${graph_attr_id}" />
					<jsp:param name="linkSBoxNum" value="2" />
				</jsp:include>
			</td>
			<td style="width: ${th_width};">
				<input type="button" id="bt_graphChart" value="曲線圖" class="innerBtn" onclick="onShowGraphChart();" />
			</td>
		</tr>
		<tr>
			<th style="width: ${th_width};"><label>圖餅圖</label></th>
			<td>
				<jsp:include page="/pages/component/LinkSelectBox.jsp">
					<jsp:param name="linkSBoxId" value="${pie_attr_id}" />
					<jsp:param name="linkSBoxNum" value="1" />
				</jsp:include>
			</td>
			<td style="width: ${th_width};">
				<input type="button" id="bt_pieChart" value="圓餅圖" class="innerBtn" onclick="onShowPieChart();" />
			</td>
		</tr>
		<tr>
			<th style="width: ${th_width};"><label>地圖</label></th>
			<td>
			</td>
			<td style="width: ${th_width};">
				<input type="button" id="bt_cityChart" value="地圖" class="innerBtn" onclick="onShowCityChart();" />
			</td>
		</tr>
	</table>
	<section class="butCenter">
		<input type="button" id="bt_toQuery" value="回查詢頁" />
	</section>
</section>
<div class="mid" style="width: 1000px; overflow: auto;">
	<div class="d_diagram" id="barChartDiv">
		<c:set var="barChartId" value="barChartId1" />
		<jsp:include page="../chart/BarChart.jsp">
			<jsp:param name="barChartId" value="${barChartId}" />
		</jsp:include>
		<script type="text/javascript">
			function onShowBarChart() {

				if (jQuery("select[name='${bar_attr_id}Results']").val() == "-1") {
					alert("請選擇一個長條圖的屬性");
					return;
				}

				showChartDiv("barChartDiv");

				//jQuery("#barChart_div_${barChartId}").hide();

				/* if(jQuery("#barChart_div_${barChartId}").is(":visible")) {
					jQuery("#bt_barChart").val("隱藏長條圖");
				} else {
					jQuery("#bt_barChart").val("顯示長條圖");
				} */

				jQuery.getJSON('barChart_ajax', {
					barAttrResults : function () {
						var barSelectVal = jQuery("select[name='${bar_attr_id}Results']").map(function() { return $(this).val(); }).get();
						return barSelectVal;
					},
					attrFilter : function () {
						return jQuery("input[name='attrFilter']").val();
					}
				}, function(response) {
					if (response.barChartData != null) {
						try { ${barChartId}_barChart(response.barChartData); } catch(e) {};
					}
				});
			}
		</script>
	</div>
	<div class="d_diagram" id="graphChartDiv">
		<c:set var="graphChartId" value="graphChartId1" />
		<jsp:include page="../chart/GraphChart.jsp">
			<jsp:param name="graphChartId" value="${graphChartId}" />
		</jsp:include>
		<script type="text/javascript">
			function onShowGraphChart() {

				if (jQuery("select[name='${graph_attr_id}Results']").val() == "-1") {
					alert("請選擇一個曲線圖的屬性");
					return;
				}

				showChartDiv("graphChartDiv");

				jQuery.getJSON('graphChart_ajax', {
					graphAttrResults : function () {
						var graphSelectVal = jQuery("select[name='${graph_attr_id}Results']").map(function() { return $(this).val(); }).get();
						return graphSelectVal;
					},
					attrFilter : function () {
						return jQuery("input[name='attrFilter']").val();
					}
				}, function(response) {
					if (response.graphChartData != null) {
						try { ${graphChartId}_graphChart(response.graphChartData); } catch(e) {};
					}
				});
			}
		</script>
	</div>
	<div class="d_diagram" id="pieChartDiv">
		<c:set var="pieChartId" value="pieChartId1" />
		<jsp:include page="../chart/PieChart.jsp">
			<jsp:param name="pieChartId" value="${pieChartId}" />
		</jsp:include>
		<script type="text/javascript">
			function onShowPieChart() {

				showChartDiv("pieChartDiv");

				if (jQuery("select[name='${pie_attr_id}Results']").val() == "-1") {
					alert("請選擇一個圓餅圖的屬性");
					return;
				}

				jQuery.getJSON('pieChart_ajax', {
					pieAttrResults : function () {
						var pieSelectVal = jQuery("select[name='${pie_attr_id}Results']").map(function() { return $(this).val(); }).get();
						return pieSelectVal;
					},
					attrFilter : function () {
						return jQuery("input[name='attrFilter']").val();
					}
				}, function(response) {
					if (response.pieChartData != null) {
						try { ${pieChartId}_pieChart(response.pieChartData); } catch(e) {};
					}
				});
			}
		</script>
	</div>
	<div class="d_diagram" id="cityChartDiv">
		<c:set var="cityChartId" value="cityChartId1" />
		<jsp:include page="../chart/CityChart.jsp">
			<jsp:param name="cityChartId" value="${cityChartId}" />
		</jsp:include>
		<script type="text/javascript">
			function onShowCityChart() {

				showChartDiv("cityChartDiv");

				jQuery.getJSON('cityChart_ajax', {
					attrFilter : function () {
						return jQuery("input[name='attrFilter']").val();
					}
				}, function(response) {
					if (response.cityChartData != null) {
						try { ${cityChartId}_cityChart(response.cityChartData); } catch(e) {};
					}
				});
			}
		</script>
	</div>
</div>
</s:form>

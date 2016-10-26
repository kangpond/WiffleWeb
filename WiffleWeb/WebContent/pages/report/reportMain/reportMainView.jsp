<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<script type="text/javascript">
	(function($) {
		$(document)
				.ready(
						function() {

							bindDatePlugin("input[name*='Date']");

							if ('' != '${message}')
								alert('${message}');

							$("#bt_query").click(
									function() {
										if (checkInput()) {
											var reportId = $("input[name='reportQueryView.reportId']").val();
											//alert("reportId:"+reportId);
											$("#reportDemoViewform").attr("action",
													"query?maintainFunctionId="+reportId).submit();
										}
									});

							$("#bt_download").click(
									function() {
										if (checkInput()) {
											$("#reportDemoViewform").attr("action",
													"getReport").submit();
										}
									});

						});

		function checkInput() {
			return true;
		}

		function isEmpty(obj) {
			return (!obj || $.trim(obj) === "");
		}

	})(jQuery);
</script>

<s:form id="reportDemoViewform" method="post">
	<s:hidden name="pageName" value="view" />
	<input type="hidden" name="reportQueryView.reportYear" value="${reportQuery.reportYear}" />
	<input type="hidden" name="reportQueryView.reportMonth" value="${reportQuery.reportMonth}" />
	<input type="hidden" name="reportQueryView.reportId" value="${reportQuery.reportId}" />

	<div class="Dashboard">
		<h2><span>檢視頁</span></h2>
		<section class="styleTb">
			<div style="WIDTH: 1740px; HEIGHT: 450px; BACKGROUND-COLOR: #FFFFFF;
					overflow-x:scroll; SCROLLBAR-FACE-COLOR: #c2d3fc;
					SCROLLBAR-HIGHLIGHT-COLOR: #c2d3fc; SCROLLBAR-SHADOW-COLOR: BLACK; SCROLLBAR-3DLIGHT-COLOR: #c2d3fc;
					 SCROLLBAR-ARROW-COLOR:#000000; SCROLLBAR-TRACK-COLOR: FFFFFF; SCROLLBAR-DARKSHADOW-COLOR: EAECEC" >

			<s:iterator status="i" var="f" value="picViewList">
				<font color="red">*** ${f.imageDesc} ***</font> <BR/>
				<img src="<s:url value="%{#f.imageStr}" />" border="0" align="middle"><BR/>
			</s:iterator>
			</div>
		</section>
		<div class="aCenter">
			<BR/>
			<button type="button" class="btn2" id="bt_query">回查詢頁</button>
			<button type="button" class="btn2" id="bt_download">下載報表</button>
		</div>
	</div>

</s:form>
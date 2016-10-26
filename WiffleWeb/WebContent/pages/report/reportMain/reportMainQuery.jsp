<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<script type="text/javascript">
	(function($) {
		$(document)
				.ready(
						function() {

							var myParam = location.search.split('maintainFunctionId=')[1];
							//alert(myParam);

							if ('' != '${message}')
								alert('${message}');

							$("#bt_query").click(
									function() {
										if (checkInput()) {
											$("#reportDemoQueryform").attr("action",
													"view").submit();
										}
									});

							$("#bt_reset")
									.click(
											function() {
												$("input[name='reportQuery.reportYear']").attr("value", "");
												$("input[name='reportQuery.reportMonth']").attr("value", "");
												//alert("");
												//$("#reportDemoQueryform").validate().resetForm();
											});

							$("#reportDemoQueryform").validate({
								rules : {
									'reportQuery.reportYear' : {
										digits : true
									},
									'reportQuery.reportMonth': {
										englishNumberValidate : true
									}
								}
							});

						});

		function checkInput() {

			var reportYear = $("input[name='reportQuery.reportYear']").val();
			var reportMonth = $("input[name='reportQuery.reportMonth']").val();

			if (isEmpty(reportYear) || isEmpty(reportMonth)) {
				alert("請輸入查詢條件");
				return false;
			}

			return true;
		}

		function isEmpty(obj) {
			return (!obj || $.trim(obj) === "");
		}

	})(jQuery);
</script>

<s:form id="reportDemoQueryform" method="post">
	<s:hidden name="pageName" value="query" />
	<input type="hidden" name="reportQuery.reportId" value="${maintainFunctionId}" />

	<div class="Dashboard">
		<h2><span>查詢頁</span></h2>

		<section class="styleTb">
			<table class="rowTb">
				<colgroup width="30%" />
				<colgroup width="70%" />
				<tr>
					<th>報表ID</th>
					<td colspan="3">
						<s:property value="maintainFunctionId" />
					</td>
				</tr>
				<tr>
					<th>報表年度</th>
					<td colspan="3">
						<input type="text"
							name="reportQuery.reportYear"
						value="${reportQuery.reportYear}" maxLength="4"/>
					</td>
				</tr>
				<tr>
					<th>報表月份</th>
					<td colspan="3">
						<input type="text"
							name="reportQuery.reportMonth"
						value="${reportQuery.reportMonth}" maxLength="2"/>
					</td>
				</tr>
			</table>

			<div class="aCenter">
				<BR/>
				<button type="button" class="btn2" id="bt_query">查詢</button>
				<button type="reset" class="btn" >清除</button>
			</div>

		</section>
	</div>

</s:form>
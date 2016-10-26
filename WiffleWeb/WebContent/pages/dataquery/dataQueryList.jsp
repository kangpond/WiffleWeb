<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="n" uri="/newresident-tags"%>
<script type="text/javascript">
	(function($) {
		$(function() {
			$(".pagelinks").appendTo("#displayFooter");
			$(".pagebanner").appendTo("#displayFooter");

			$("#bt_toQuery").click(function() {
				$("#dataQueryListform").attr("action", "inquiry").submit();
			});
		});
	})(jQuery);

	function onRowView(residentIdNo, firstReceiveNo) {
		jQuery("#residentIdNo").val(residentIdNo);
		jQuery("#firstReceiveNo").val(firstReceiveNo);
		jQuery("#dataQueryListform").attr("action", "detail").submit();
	}
</script>
<s:form id="dataQueryListform" method="post" namespace="/dataQuery">
	<s:hidden id="residentIdNo" name="residentIdNo" />
	<s:hidden id="firstReceiveNo" name="firstReceiveNo" />
	<section class="styleTb2">
		<display:table name="respList" id="result" pagesize="10"
			requestURI="list">
			<display:column title="項次" value="${result_rowNum}" />
			<display:column title="居留證號" property="residentIdNo" />
			<display:column title="中文姓名" property="chineseName" />
			<display:column title="英文姓名" property="englishName" />
			<display:column title="出生日期">
				<n:formatDate date="${result.birthDate}" />
			</display:column>
			<display:column title="護照號碼" property="passportNo" />
			<display:column title="身分證碼" property="personId" />
			<display:column title="首次入出境許可證號" property="firstReceiveNo" />
			<display:column title="功能選項">
				<button type="button" id="bt_update" class="btnCode"
					onclick="onRowView('${result.residentIdNo}','${result.firstReceiveNo}');">檢視</button>
			</display:column>
		</display:table>
		<div id="displayFooter" class="aCenter"></div>
		<section class="butCenter">
			<button type="button" class="btn2" id="bt_toQuery">回查詢頁</button>
		</section>
	</section>
</s:form>


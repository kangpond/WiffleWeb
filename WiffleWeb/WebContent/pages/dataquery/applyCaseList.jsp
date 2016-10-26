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

			changeLinks("resultList");
		});
	})(jQuery);
</script>
<s:form id="applyCaseListform" method="post" namespace="/dataQuery">
	<section class="styleTb2">
		<div id="resultList">
			<display:table name="applyCaseList" id="result" pagesize="10"
				requestURI="queryApplyCaseList">
				<display:column title="項次" value="${result_rowNum}" />
				<display:column title="申請日期">
					<n:formatDate date="${result.applyDate}" />
				</display:column>
				<display:column title="入出境證號" property="receiveNo" />
				<display:column title="申請類別">
					<n:code code="${result.applyType}" category="6" />
				</display:column>
				<display:column title="申請事由">
					<n:code code="${result.reason}" category="1" />
				</display:column>
				<display:column title="收件單位">
					<n:code code="${result.receiveBureau}" category="34" />
				</display:column>
				<display:column title="核定狀況">
					<n:code code="${result.decideMark}" category="63" />
				</display:column>
				<display:column title="核淮日期">
					<n:formatDate date="${result.decideDate}" />
				</display:column>
				<display:column title="證件效期">
					<n:formatDate date="${result.exitExpiryDate}" />
				</display:column>
				<display:column title="居留狀況">
					<n:code code="${result.residenceStatus}" category="240" />
				</display:column>
				<display:column title="護照號碼">
					<s:if
						test='#attr.result.foreignPassportNo == null || #attr.result.foreignPassportNo == ""'>
						${result.passportNo}
					</s:if>
					<s:else>
						${result.foreignPassportNo}
					</s:else>
				</display:column>
			</display:table>
			<div id="displayFooter" class="aCenter"></div>
		</div>
	</section>
</s:form>


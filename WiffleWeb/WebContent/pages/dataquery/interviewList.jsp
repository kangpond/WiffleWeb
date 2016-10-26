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

	function onRowView(param) {
		var url = '<s:url action="queryInterviewDetail" />';
		var urlParam = url + "?interviewSeq=" + param;
		var name = "_blank";
		var specs = "height=768,width=850,location=no,menubar=no,resizable=no,scrollbars=yes,status=no,titlebar=no,toolbar=no";
		window.open(urlParam, name, specs).focus();

	}
</script>
<s:form id="interviewListform" method="post" namespace="/dataQuery">
	<section class="styleTb2">
		<div id="resultList">
			<display:table name="interviewList" id="result" pagesize="10"
				requestURI="queryInterviewList">
				<display:column title="項次" value="${result_rowNum}" />
				<display:column title="入出境許可證號" property="receiveNo" />
				<display:column title="面談對象">
					<s:if
						test='#attr.result.f2fPerson != null && #attr.result.f2fPerson == "1"'>
						大陸配偶
					</s:if>
					<s:elseif
						test='#attr.result.f2fPerson != null && #attr.result.f2fPerson == "2"'>
						在台配偶
					</s:elseif>
					<s:elseif
						test='#attr.result.f2fPerson != null && #attr.result.f2fPerson == "3"'>
						大陸+在台配偶
					</s:elseif>
					<s:elseif
						test='#attr.result.f2fPerson != null && #attr.result.f2fPerson == "4"'>
						外籍配偶
					</s:elseif>
					<s:else>外籍配偶+在台配偶</s:else>
				</display:column>
				<display:column title="面談日期">
					<n:formatDate date="${result.startF2fTalkDate}" />
				</display:column>
				<display:column title="面談地點">
					<n:code code="${result.talkPlace}" category="324" />
				</display:column>
				<display:column title="面談處置">
					<n:code code="${result.f2fResult}" category="225" />
				</display:column>
				<display:column title="功能選項">
					<input type="button" id="bt_update" value="檢視"
						onclick="onRowView('${result.seq}')" />
				</display:column>
			</display:table>
			<div id="displayFooter" class="aCenter"></div>
		</div>
	</section>
</s:form>


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
<s:form id="immiListform" method="post" namespace="/dataQuery">
	<section class="styleTb2">
		<div id="resultList">
			<display:table name="immiList" id="result" pagesize="10"
				requestURI="queryImmiList">
				<display:column titleKey="項次">
					<s:if
						test='#attr.result.fromDaily != null && "Y".equals(#attr.result.fromDaily)'>*</s:if>${result_rowNum}
				</display:column>
				<display:column title="入出別">
					<n:code code="${result.immigrateType}" category="25" />
				</display:column>
				<display:column title="入出境日期">
					<n:formatDate date="${result.immigrateDate}" />
				</display:column>
				<display:column title="機場/港口">
					<n:code code="${result.port}" category="26" />
				</display:column>
				<display:column title="航班" property="flightNo" />
				<display:column title="來往地區">
					<n:code code="${result.fromTo}" category="15" />
				</display:column>
				<display:column title="入出境方式">
					<s:if
						test='#attr.result.immigWay != null && #attr.result.immigWay == "1"'>
						一般查驗
					</s:if>
					<s:elseif
						test='#attr.result.immigWay != null && #attr.result.immigWay == "2"'>
						一般eGate
					</s:elseif>
					<s:elseif
						test='#attr.result.immigWay != null && #attr.result.immigWay == "3"'>
						緊急查驗
					</s:elseif>
					<s:elseif
						test='#attr.result.immigWay != null && #attr.result.immigWay == "4"'>
						機組人員專用eGate
					</s:elseif>
					<s:else>
					</s:else>
				</display:column>
				<display:column title="護照號碼" property="passportNo" />
			</display:table>
			<div id="displayFooter" class="aCenter"></div>
		</div>
	</section>
</s:form>


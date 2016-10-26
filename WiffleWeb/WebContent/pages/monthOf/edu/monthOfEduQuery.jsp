<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<script type="text/javascript">
	(function($) {
		$(document).ready(function() {

		});
	})(jQuery);
</script>
<s:form id="form" cssClass="form" namespace="monthOfEdu" method="post">
	<jsp:include page="/pages/monthOf/MonthOfQuery.jsp">
		<jsp:param name="monthOfHeader" value="教育程度每月分析表" />
		<jsp:param name="isShowFsType" value="true" />
	</jsp:include>
</s:form>

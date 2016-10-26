<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<script type="text/javascript">
	(function($) {
		$(document).ready(function() {

		});
	})(jQuery);
</script>
<s:form id="form" cssClass="form" namespace="monthOfNation" method="post">
	<jsp:include page="/pages/monthOf/MonthOfQuery.jsp">
		<jsp:param name="monthOfHeader" value="國籍每月分析表" />
	</jsp:include>
</s:form>

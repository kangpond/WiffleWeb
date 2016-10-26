<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<script type="text/javascript">
	(function($) {
		$(document).ready(function() {

		});
	})(jQuery);
</script>
<s:form id="form" cssClass="form" namespace="cityOfOcc" method="post">
	<jsp:include page="/pages/cityOf/CityOfList.jsp">
		<jsp:param name="cityOfHeader" value="職業各縣市分布" />
	</jsp:include>
</s:form>
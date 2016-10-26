<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<script type="text/javascript">
	(function($) {
		$(document).ready(function() {

		});
	})(jQuery);
</script>
<s:form id="form" cssClass="form" namespace="cityOfEdu" method="post">
	<jsp:include page="/pages/cityOf/CityOfQuery.jsp">
		<jsp:param name="cityOfHeader" value="教育程度各縣市分布" />
		<jsp:param name="isShowFsType" value="true" />
	</jsp:include>
</s:form>

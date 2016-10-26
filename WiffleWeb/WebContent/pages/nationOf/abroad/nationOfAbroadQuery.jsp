<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<script type="text/javascript">
	(function($) {
		$(document).ready(function() {

		});
	})(jQuery);
</script>
<s:form id="form" cssClass="form" namespace="nationOfAbroad" method="post">
	<jsp:include page="/pages/nationOf/NationOfQuery.jsp">
		<jsp:param name="nationOfHeader" value="外配國籍分布(依縣市)-依子女出國未歸年" />
	</jsp:include>
</s:form>
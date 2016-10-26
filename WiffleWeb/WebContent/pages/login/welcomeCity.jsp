<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>

<script type="text/javascript">
	(function($) {
		$(function() {
			$(".pagelinks").appendTo("#displayFooter");
			$(".pagebanner").appendTo("#displayFooter");
		});
	})(jQuery);
</script>

<s:form id="welcomeCityform" cssClass="form" method="post"
	namespace="/">
	<div id="displayFooter" class="aCenter"></div>
		<img src="<s:url value="%{picCityF}" />" border="0" align="middle">
	<br />
</s:form>
</html>

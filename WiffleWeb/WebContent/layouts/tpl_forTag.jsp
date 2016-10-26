<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="jwr" uri="http://jawr.net/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jwr:style src="/bundles/all.css" />
<jwr:script src="/bundles/all.js" />

<script type="text/javascript">
var basicPath = "<%=request.getContextPath()%>";
	(function($) {
		$(document).ready(function() {
			try {
				$("input[type='text'],select").first().focus();
			} catch (e) {
				console.log('focus error', e);
			}
		});
	})(jQuery);
</script>
<title><tiles:insertAttribute name="title" /></title>
</head>
<body>
	<div class="wrap mpwrap">
		<em>
			<div class="main">
				<div class="Search">
					<tiles:insertAttribute name="body" />
				</div>
			</div>
		</em>
	</div>
</body>
</html>

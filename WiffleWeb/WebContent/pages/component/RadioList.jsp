<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div>
	<c:set var="radioBoxId" value="${param.radioBoxId}" />
	<div id="rb_div_${radioBoxId}">
		<c:if test="${not empty param.radioBoxName}">
		<span>${param.radioBoxName}：</span>
		</c:if>
		<span id="rb_content_${radioBoxId}"></span>
		<span>
			<c:set var="ucrBtnId" value="${radioBoxId}Result" />
			<input type="button" value="清除" id="ucr_${ucrBtnId}" onclick="${ucrBtnId}_ucr('${ucrBtnId}');" class="innerBtn" />
		</span>
	</div>
</div>
<script type="text/javascript">
(function($) {

	$(document).ready(function() {
	});

	${radioBoxId}_rb = function(sourceList) {

		$.each(sourceList, function(i, item) {

			var container = $("#rb_content_${radioBoxId}");
			$("<input />", { type: "radio", id: "${radioBoxId}Result" + i, name: "${radioBoxId}Result", value: item.codeDataValue, class: "radioBtn" }).appendTo(container);
			$("<label />", { for: "${radioBoxId}Result" + i, text: item.codeDataValueDesc, class: "radioBtn"}).appendTo(container);
		});
	};

	${ucrBtnId}_ucr = function(itemName) {
		jQuery("input[name='" + itemName + "']").prop("checked", false);
	};

})(jQuery);
</script>

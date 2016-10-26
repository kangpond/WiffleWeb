<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div>
	<c:set var="cBoxId" value="${param.cBoxId}" />
	<div id="clb_div_${cBoxId}">
		<c:if test="${not empty param.cBoxName}">
		<span>${param.cBoxName}：</span>
		</c:if>
		<span id="clb_content_${cBoxId}"></span>
		<span style="margin-left: 5px;">
			<c:set var="cacBoxItemName" value="${cBoxId}Result" />
			<input type="checkbox" id="cac_${cacBoxItemName}" onclick="${cacBoxItemName}_click(this, '${cacBoxItemName}');"
				style="visibility: hidden; display: none;"  />
			<label class="innerBtn" for="cac_${cacBoxItemName}">全選</label>
		</span>
	</div>
</div>
<script type="text/javascript">
(function($) {

	$(document).ready(function() {
	});

	${cBoxId}_clb = function(sourceList) {

		$.each(sourceList, function(i, item) {

			var container = $("#clb_content_${cBoxId}");
			$("<input />", { type: "checkbox", id: "${cBoxId}Result" + i, name: "${cBoxId}Result", value: item.codeDataValue, class: "checkboxBtn" }).appendTo(container);
			$("<label />", { for: "${cBoxId}Result" + i, text: item.codeDataValueDesc, class: "checkboxLabel"}).appendTo(container);
		});
	};

	${cacBoxItemName}_click = function(item, itemName) {
		jQuery("input[name='" + itemName + "']").prop("checked", jQuery(item).prop("checked"));
	};

})(jQuery);
</script>

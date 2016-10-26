<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="linkSBoxId" value="${param.linkSBoxId}" />
<c:set var="linkSBoxNum" value="${param.linkSBoxNum}" />
<span id="linkSBox_div_${linkSBoxId}">
	<c:if test="${not empty param.linkSBoxName}">
	<span>${param.linkSBoxName}：</span>
	</c:if>
	<span style="margin:right: 10px;">
		<c:forEach var="i" begin="1" end="${linkSBoxNum}">
		<select id="${linkSBoxId}${i}" name="${linkSBoxId}Results" class="form-control">
			<option value="-1">請選擇</option>
		</select>
		</c:forEach>
	</span>
</span>
<script type="text/javascript">
(function($) {

	$(document).ready(function() {
	});

	${linkSBoxId}_linkSBox = function(sourceList) {

		$("select[name=${linkSBoxId}Results]").each(function(i, selectElm){
			$.each(sourceList, function(j, item) {
				$(selectElm).append($("<option></option>").attr("value", item.codeDataValue).text(item.codeDataValueDesc));
			});
		});

		$("select[name=${linkSBoxId}Results]").each(function(i, selectBox){
			$(selectBox).change(function() {
				$("select[name=${linkSBoxId}Results]").each(function(j){
					var otherElmNo = (j + 1);
					$("#${linkSBoxId}" + otherElmNo + " option").show();
					$("select[name=${linkSBoxId}Results] option:selected").each(function(k, selectElm){
						var sVal = $(selectElm).val();
						if (sVal != "-1" && sVal != $("#${linkSBoxId}" + otherElmNo).val()) {
							$("#${linkSBoxId}" + otherElmNo + " option[value=" + sVal + "]").hide();
						}
					});
				});
			});
		});
	};

})(jQuery);
</script>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="sBoxId" value="${param.sBoxId}" />
<c:set var="sBoxName" value="${param.sBoxName}" />
<c:set var="containDesc" value="${param.containDesc}" />
<c:set var="panelWidth" value="${550}" />
<c:set var="panelBtnWidth" value="${120}" />
<div>
	<input type="hidden" id="${sBoxId}Result" name="${sBoxId}Result" />
	<div style="margin-bottom:10px">
		<c:if test="${not empty param.sBoxName}">
		<label class="lb_title" for="sBox_${sBoxId}">${sBoxName}：</label>
		</c:if>
		<input type="text" id="sBox_${sBoxId}" />
	</div>
	<div style="width: ${panelWidth}px;">
		<div style="width: ${(panelWidth - panelBtnWidth) / 2}px; float:left;">
		<select id="boxSource_${sBoxId}" style="width: ${(panelWidth - panelBtnWidth) / 2}px;" size="5" multiple="multiple" class="form-control"></select>
		</div>
		<div style="width: ${(panelWidth - panelBtnWidth) / 2}px; float:right;">
		<select id="boxTarget_${sBoxId}" style="width: ${(panelWidth - panelBtnWidth) / 2}px;" size="5" multiple="multiple" class="form-control"></select>
		</div>
		<div style="width: ${panelBtnWidth}px; margin:0 auto; text-align: center;">
			<input type="button" class="innerBtn" value="加入" onclick="${sBoxId}_add()" />
			<input type="button" class="innerBtn" value="刪除" onclick="${sBoxId}_remove()" />
		</div>
	</div>
	<script type="text/javascript">
	(function($) {

		$(document).ready(function() {
		});

		${sBoxId}_sg = function(sourceList) {
			$("#sBox_${sBoxId}").autocomplete({
				search : function(event, ui) {
					$("#boxSource_${sBoxId}").empty();
				},
				minLength: 0,
				source : sourceList,
				focus : function() {
					// event.preventDefault();
					/* $("#sBox_${sBoxId}").autocomplete("search", "").data("ui-autocomplete")._renderItem = function(ul, item) {
						return ${sBoxId}_listBox_append("boxSource_${sBoxId}", item);
					}; */
				}
			}).data("ui-autocomplete")._renderItem = function(ul, item) {
				return ${sBoxId}_listBox_append("boxSource_${sBoxId}", item);
				//return $("#boxSource_${sBoxId}").append($("<option></option>").attr("value", item.label).text(item.label + ", " + item.desc));
			};

			$("#sBox_${sBoxId}").focus(function(){
				$("#sBox_${sBoxId}").autocomplete("search", "");
			});

			/* $.each(sourceList, function(i, val) {
				$("#boxSource_${sBoxId}").append($("<option></option>").attr("value", itemVal).text(itemVal));
				if (i == 3) {
					return false;
				}
			}); */
		};

		${sBoxId}_listBox_append = function(widgetId, item) {
			var itemText = item.label;
			if ('true' == '${containDesc}') {
				itemText = item.label + ", " + item.desc;
			}
			return $("#" + widgetId).append($("<option></option>").attr("value", item.value.toUpperCase()).text(itemText));
		};

		${sBoxId}_add = function() {
			$("#boxSource_${sBoxId} :selected").each(function(i, selectedObj){
				var selectedValue = $(selectedObj).val().toUpperCase();
				var selectedText = $(selectedObj).text();
				var valueExist = false;
				$("#boxTarget_${sBoxId} option").each(function(j, optionObj) {
					var optionValue = $(optionObj).val().toUpperCase();
					if (optionValue == selectedValue) {
						valueExist = true;
						return false;
					}
				});
				if (!valueExist) {
					$("#boxTarget_${sBoxId}").append($("<option></option>").attr("value", selectedValue).text(selectedText));
					var values = $("#boxTarget_${sBoxId} option").map(function() { return $(this).val(); }).get();
					$("#${sBoxId}Result").val(values);
				}
			});
		};

		${sBoxId}_remove = function() {
			$("#boxTarget_${sBoxId}").find(":selected").remove();
			var values = $("#boxTarget_${sBoxId} option").map(function() { return $(this).val(); }).get();
			$("#${sBoxId}Result").val(values);
		};

	})(jQuery);
	</script>
</div>

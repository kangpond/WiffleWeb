<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>

<script type="text/javascript">
(function($) {

	$(document).ready(function() {

		if ('' != '${message}') {
			alert('${message}');
		}

		$("#bt_update").click(function() {
			if (checkInput() && confirm('確定要修改嗎？')) {
				$("#form").attr("action", "motify").submit();
			}
		});

		function checkInput() {
			if (isEmpty(jQuery("#deptId").val())) {
				alert('取不到機關代碼，請重新查詢一次');
				return false;
			}
			else if (isEmpty(jQuery("#deptName").val())) {
				alert('請輸入機關名稱');
				return false;
			}
			return true;
		}
	});

})(jQuery);
</script>

<section class="styleTb">
<s:form id="form" cssClass="form" method="post">
	<s:hidden id="deptId" name="deptData.deptId" />
	<table>
		<tr>
			<th>機關代碼：</th>
			<td><s:property value="deptData.deptId" /></td>
		</tr>
		<tr>
			<th>機關名稱：</th>
			<td><s:textfield id="deptName" name="deptData.deptName" style="width:300px" /></td>
		</tr>
	</table>
	<section class="butCenter">
	  <button type="button" id="bt_update" class="btn2">修改</button>
	  <button type="button"  class="btn2" onclick="javascript:window.history.back()" >回上一頁</button>
	</section>
</s:form>
</section>

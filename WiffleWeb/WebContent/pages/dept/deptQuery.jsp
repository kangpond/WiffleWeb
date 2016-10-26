<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<script type="text/javascript">
(function($) {
	$(document).ready(function() {

		if ('' != '${message}') {
			alert('${message}');
		}

		$("#bt_query").click(function() {
			doQuery();
		});

		$(document).keypress(function(e) {
			if (e.which == 13) {
				doQuery();
			}
		});

		$("#bt_clear").click(function() {
			$("#deptId").val('');
			$("#deptName").val('');
		});

		$('#bt_create').click(function() {
			$("#form").attr('action', 'create').submit();
		});
	});

	function doQuery() {
		if (isEmpty(jQuery("#deptId").val()) && isEmpty(jQuery("#deptName").val())) {
			if (!confirm("沒有任何輸入值，是否要查詢前100筆資料？")) {
				return;
			}
		}

		$("#form").attr("action", "list").submit();
	}

})(jQuery);
</script>
<section class="styleTb">
<s:form id="form" class="form" namespace="dept" method="post">
	<table class="">
		<tr>
			<th>機關代碼：</th>
			<td><s:textfield id="deptId" name="deptId" value="%{deptId}" /></td>
		</tr>
		<tr>
			<th>機關名稱：</th>
			<td><s:textfield id="deptName" name="deptName" value="%{deptName}" /></td>
		</tr>
	</table>
	<section class="butCenter">
	  	<button type="button" id="bt_query" class="btn2">查詢</button>
	  	<button type="button" id="bt_clear" class="btn2">清除</button>
	  	<button type="button" id="bt_create" class="btn2">新增</button>
	</section>
</s:form>
</section>

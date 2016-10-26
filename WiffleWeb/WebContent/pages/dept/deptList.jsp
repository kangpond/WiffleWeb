<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<script type="text/javascript">
	(function($) {
		$(document).ready(function() {

			if ('' != '${message}') {
				alert('${message}');
			}

			$("#bt_toQuery").click(function() {
				$("#form").attr("action", "query").submit();
			});

		});
	})(jQuery);

	function onRowEdit(deptId) {
		jQuery("#selectedDeptId").val(deptId);
		jQuery("#form").attr("action", "deptEdit").submit();
	}

	function onRowDelete(deptId, deptName) {
		jQuery("#selectedDeptId").val(deptId);
		if (confirm("確定要刪除機關單位:" + deptId + ", " + deptName + "？")) {
			jQuery("#form").attr("action", "delete").submit();
		}
	}

</script>
<section class="styleTb2">
<s:form id="form" cssClass="form" namespace="dept" method="post">
	<s:hidden id="selectedDeptId" name="selectedDeptId" />
	<s:hidden name="deptId" />
	<s:hidden name="deptName" />

	<s:if test="%{deptList==null || deptList.size <= 0}">
		查無資料。
	</s:if>
	<s:else>
		<display:table name="${deptList}" id="deptTable" sort="external" partialList="true" size="${deptListSize}"
			defaultsort="1" pagesize="10" requestURI="list" class="displayTag">
			<display:column title="機關代碼" property="deptId" sortable="true" />
			<display:column title="機關名稱" property="deptName" />
			<display:column title="操作">
				<button type="button" onclick="onRowEdit('${deptTable.deptId}')" class="btnCode">編輯</button>
				<button type="button" onclick="onRowDelete('${deptTable.deptId}', '${deptTable.deptName}')" class="btnCode">刪除</button>
			</display:column>
			<display:footer>
			</display:footer>
		</display:table>
	</s:else>
	<!--
	<div style="text-align: center;" class="errorMessage">
		<s:property value="message" />
	</div>
	-->
	<section class="butCenter">
	  <button type="button" id="bt_toQuery" class="btn2">回查詢頁</button>
	</section>
</s:form>
</section>
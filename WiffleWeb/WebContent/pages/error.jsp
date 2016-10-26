<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>

<script>
	jQuery(document).ready(function() {
		jQuery("#messageDetail").hide();
		jQuery("#showDetail").click(function() {
			if ("+" == jQuery(this).val()) {
				jQuery("#messageDetail").show();
				jQuery(this).val("-");
			} else {
				jQuery("#messageDetail").hide();
				jQuery(this).val("+");
			}
		});
	});
</script>
<s:form id="errorform" cssClass="form">
	<h1>系統異常錯誤</h1>
	<table class="rowTb">
		<tr>
			<th>錯誤訊息</th>
			<td><s:property value="exception.message" /></td>
		</tr>
		<tr>
			<td colspan="2" style="max-width: 600px;"><input type="button"
				id="showDetail" value="+" />
				<p id="messageDetail">
					<s:property value="%{exceptionStack}" />
				</p></td>
		</tr>
	</table>
</s:form>
</html>

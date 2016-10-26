<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		 <script type="text/javascript">
			 function changeForm(actionName){
					if(actionName != null && actionName != "undefined"){
						jQuery("#funcForm").attr('action',actionName)
					    jQuery("#funcForm").submit();
					}
			}
			function redirectActions(redirectUrl){
				window.location.href = redirectUrl;
			}
		 </script>
	</head>
	<section class="styleTb">
 	 <s:form method="post"  id="funcForm" action="saveFunction" >
 	     <div class="rowTb">
 	 	 <table >
 	 	 	 <tr>
 	 	 	 	<th>
					 <span class="asterisk">*</span>
					  功能代碼：
				</th>
				<td>
					<s:textfield  name="functionId" maxlength="40"  value="%{functionId}" size="30"/>
					<s:fielderror fieldName="functionId"/>
				</td>
 	 	 	 </tr>
 	 	 	 <tr>
 	 	 	 	<th>
					 <span class="asterisk">*</span>
					  功能敘述：
				</th>
				<td>
					<s:textfield  name="functionName" maxlength="50"  value="%{functionName}" size="60"/>
					<s:fielderror fieldName="functionName"/>
				</td>
 	 	 	 </tr>
 	 	 	 <tr>
 	 	 	 	<th>
					  上層功能：
				</th>
				<td>
					<s:select list="%{functionList}" name="upperFunctionId" listKey="functionId" 
									headerKey=""  headerValue="請選擇"	listValue="functionName" value="%{upperFunctionId}" />
				</td>
 	 	 	 </tr>
 	 	 	 <tr>
 	 	 	 	<th>
					 <span class="asterisk">*</span>
					  節點：
				</th>
				<td>
					<s:radio list="#{'0':'根','1':'子','2':'第二層'}" name="isLeaf"  value="%{isLeaf}" />
				</td>
 	 	 	 </tr>
 	 	 	 <tr>
 	 	 	 	<th>
					 <span class="asterisk">*</span>
					  連結：
				</th>
				<td>
					<s:textfield  name="linkUrl" maxlength="256"  value="%{linkUrl}" size="60"/>
					<s:fielderror fieldName="linkUrl"/>
					<br><span class="asterisk">如果此功能是根節點有子功能，請填入 "#"</span>
				</td>
 	 	 	 </tr>
 	 	 	 <tr>
				<th>動態查詢：</th>
				<td>
					<s:radio list="#{'1':'是','0':'否'}" name="visible"  value="%{visible}" />
				</td>
 	 	 	 </tr>
 	 	 	 <tr>
 	 	 	 	<th>
					 <span class="asterisk">*</span>
					  狀態：
				</th>
				<td>
					<s:radio list="#{'1':'啟用','2':'停用'}" name="state"  value="%{state}" />
				</td>
 	 	 	 </tr>
 	 	 </table>
 	 	 </div>
 	 	 <section class="butCenter">
 	 	 	 <button type="submit" class="button">儲存</button>
		 	 <button type="button" class="btn2" onclick="redirectActions('<s:url action="functionList" namespace="/functions"/>');" >返回</button>
 	 	 </section>
 	 </s:form>
	</section>	 	 
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	</head>
	<body id="">
	  <section class="styleTb">
	 	  <s:form method="post"  id="functionForm" action="functionList">
	 	  	   <table>
	 	  	     <tr>
					<th>功能代碼：</th>
					<td><s:textfield  name="functionId" maxlength="50"  /></td>
				</tr>
				<!-- 
				<tr>
					<td>功能名稱：</td>
					<td><s:textfield  name="functionDesc" maxlength="50"  /></td>
				</tr>
				 -->
		 	</table>
		 	<section class="butCenter">
		 		<button type="submit" class="btn" >查詢</button>
				<button type="button" class="btn2" onclick="changeForm('createFunc')" >建立</button>
		 	</section>
	 	  </s:form>
		 </section>	  
		 <section class="styleTb2">	  
		   <display:table name="functionList" class="displayTag" id="r">
		 	 <display:column property="sequence" title="順序"/>
	 	     <display:column property="functionId" title="功能代碼"/>
	 	     <display:column property="functionName" title="功能名稱"/>
	 	     <display:column title="操作">
	 	       <c:url value="updateFunc.action" var="urlTag">
	 	        <c:param name="functionId"  value="${r.functionId}" />
	 	       </c:url>
	 	       
	 	       <c:url value="delete.action" var="deleteUrl">
	 	        <c:param name="functionId"  value="${r.functionId}" />
	 	       </c:url>
	 	       
		  	   <a href="<c:out value="${urlTag}" />"  class ='butEditor'>編輯</a>
		  	   <a class='butDelete' onclick="deleteItem('<c:out value="${deleteUrl}" />')">刪除</a>
	 	     </display:column>						  
		   </display:table>	  
		 </section>	  
		 <script type="text/javascript">
			function changeForm(actionName){
				if(actionName != null && actionName != "undefined"){
					jQuery("#functionForm").attr('action',actionName)
				    jQuery("#functionForm").submit();
				}
			}
			function deleteItem(url){
				if(confirm('確定要刪除嗎?')){
					window.location.href=url
				}else{
					return;
				}
			}
		</script>
	</body>
</html>
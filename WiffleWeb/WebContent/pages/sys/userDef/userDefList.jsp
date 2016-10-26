<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"  %>
<%@ taglib prefix="n" uri="/newresident-tags"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	</head>
	<section class="styleTb">
		<s:form method="post" id="userForm" action="userDefList">
		    <div class="rowTb">
			 	<table >
					<tr>
					  <th>使用者帳號</th>
					  <td><s:textfield   name="userId" maxlength="20"  /></td>
					</tr>
					<tr>
					  <th>所屬機關</th>
					  <td><s:textfield id="deptId" name="deptId"  size="20" /></td>
					</tr>
			 	</table>
		 	</div>
		 	<section class="butCenter">
		 	  <button type="submit" class="btn">查詢</button>
		 	  <button type="reset" class="btn">清除</button>
		 	</section>
		 </s:form>
	</section>	 
	<section class="styleTb2">	 
 	  <display:table name="displayList" class="displayTag" pagesize="10"  partialList="true" 
 	 							requestURI="userDefList.action" size="totalSize" id="user">
 	      <display:column property="userId" title="使用者帳號"/>
 	      <display:column property="userName" title="姓名"/>
 	      <display:column title="所屬機關">
 	      	<n:gov deptId="${user.deptId}"/>
 	      </display:column>
 	      <display:column title="選項" >
 	      	<c:url value="/userDef/userInfo"  var="infoUrl">
	 	      <c:param name="userId"  value="${user.userId}" />
	 	    </c:url>
	      	<a href="<c:out value="${infoUrl}"/>" class="butEditor">檢視</a>
	      	<c:url value="usereEditInfo" var="editUrl">
	 	      <c:param name="userId"  value="${user.userId}" />
	 	    </c:url>
	      	<a href="<c:out value="${editUrl}"/>" class="butEditor">編輯</a>
	      	<c:url value="userDeleteInfo" var="deleteUrl">
	 	      <c:param name="userId"  value="${user.userId}" />
	 	    </c:url>
	      	<a href="<c:out value="${deleteUrl}"/>" class="butEditor">刪除</a>
 	      </display:column>
 	  </display:table>
	</section>	 
	 <script type="text/javascript">
 		jQuery(document).ready(function() {
 			jQuery("input[name='deptId']").appendGov();
 		 })
	</script>
	</body>
</html>
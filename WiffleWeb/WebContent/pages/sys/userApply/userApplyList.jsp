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
    <body id="">
      <section class="styleTb">
       <s:form method="post" action="userApplyList" id="maintainForm" role="form">
	     <table>
	       <tr>
	      	 <th>使用者帳號</th>
	      	   <td><s:textfield name="userId" maxlength="10"/></td>
	      	 </tr>
	      	 <tr>
	      	   <th>類別</th>
	      	    <td>
	      	      <s:checkbox name="applyKind" fieldValue="0" />申請帳號
		      	  <s:checkbox name="applyKind" fieldValue="1" />權限變更
	      	   </td>
	      	 </tr>
	      </table>
      	  <section class="butCenter">
      	    <button class="button" type="submit">查詢</button>
      	    <button class="button" type="reset">清除</button>
		  </section>
		</s:form>
      </section>
      <section class="styleTb2">	 
 	  	<display:table name="displayList" class="displayTag" pagesize="10"  partialList="true" 
 	 							requestURI="userApplyList.action" size="totalSize" id="user">
 	      <display:column property="userId" title="使用者帳號"/>
 	      <display:column property="userName" title="姓名"/>
 	      <display:column title="所屬機關">
 	      	<n:gov deptId="${user.deptId}"/>
 	      </display:column>
 	      <display:column property="applyDate" title="申請日期"/>
 	      <display:column property="applyKind" title="類別"/>
 	      <display:column title="選項" >
 	      	<c:url value="/userApply/applyCaseInfo"  var="infoUrl">
	 	      <c:param name="uuid"  value="${user.uuid}" />
	 	    </c:url>
	      	<a href="<c:out value="${infoUrl}"/>" class="butEditor">審核</a>
 	      </display:column>
 	  </display:table>
	</section>
      
    </body>
</html>
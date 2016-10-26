<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="n" uri="/newresident-tags"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"  %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<section class="styleTb2">
  <display:table name="displayList" class="displayTag" pagesize="10"  partialList="true" 
 	 							requestURI="marriage.action" size="totalSize" id="result">
	<display:column title="項次" value="${result_rowNum}" />
	<display:column property="chineseName" title="配偶姓名"/>
 	<display:column property="personId" title="配偶身分證"/>
 	<display:column title="結/離婚註記">
 	  <n:code code="${result.marry}" category="10"/>
 	</display:column>
 	<display:column property="marrageDate" title="結婚日期"/>
 	<display:column property="divorceDate" title="離婚日期"/>
 	<display:column title="功能選項" >
 	  <c:choose>
 	  	<c:when test='${result.hm !="true"}'>
 	 	  <c:url value="/otherQuery/marrageInfo" var="infoUrl">
	     	<c:param name="personId"  value="${result.personId}" />
	     	<c:param name="marrageDate"  value="${result.marrageDate}" />
	   	  </c:url>
	   	  <a href="<c:out value="${infoUrl}"/>" class="butEditor">檢視</a> 	  
 	 	</c:when>
 	  </c:choose>
 	</display:column>
  </display:table>
  <div>資料來源:戶政司+內政部移民署</div>
</section>



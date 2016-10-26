<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="n" uri="/newresident-tags"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"  %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<section class="styleTb2">
  <display:table name="displayList" class="displayTag"  id="result">
	<display:column title="項次" value="${result_rowNum}" />
	<display:column property="chineseName" title="申請人姓名"/>
 	<display:column property="personId" title="申請人身分證號"/>
 	<display:column property="agentChineseName" title="代理人姓名"/>
 	<display:column property="agentPersonId" title="代理人身分證號"/>
 	<display:column property="notarizeClass" title="公證書類別"/>
 	<display:column property="notarizePurpose" title="公證書用途"/>
 	<display:column property="applyDate" title="申請日期"/>
 	<display:column property="processResult" title="處理結果"/>
 	<display:column title="功能選項" >
	  <c:url value="/otherQuery/getSefCertifyInfo" var="infoUrl">
     	<c:param name="documentNo"  value="${result.documentNo}" />
   	  </c:url>
   	  <a href="<c:out value="${infoUrl}"/>"  target="_new" class="butEditor">檢視</a> 	  
 	</display:column>
  </display:table>
  <div>資料來源:海基會</div>
</section>
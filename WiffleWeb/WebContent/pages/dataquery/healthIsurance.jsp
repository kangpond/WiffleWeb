<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="n" uri="/newresident-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<section class="styleTb2">
  <display:table name="displayList" class="displayTag" pagesize="10"  partialList="true" 
 	 							requestURI="healthIsurance.action" size="totalSize" id="result">
	<display:column title="項次" value="${result_rowNum}" />
	<display:column title="投保身分註記">
		<c:choose>
		  <c:when test='${result.insureRemark == "1"}'>
		            眷屬身分投保
		  </c:when>
		  <c:when test='${result.insureRemark == "2"}'>
		           本人身分投保
		  </c:when>
		</c:choose>
	</display:column>
 	<display:column property="id.insurePersonId" title="被保險人身分證號"/>
 	<display:column property="insureChineseName" title="被保險人姓名"/>
 	<display:column property="insureBirthdate" title="被保險人出生日期"/>
 	<display:column property="insureClass" title="投保類別"/>
 	<display:column title="投保狀態">
 	  <n:enums type="gov.nia.nrs.eums.InsuranceEums" value="${result.insureStatus}"/>
 	</display:column>
  </display:table>
  <div>資料來源:健保局</div>
</section>
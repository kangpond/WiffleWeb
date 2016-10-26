<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="n" uri="/newresident-tags"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<section class="styleTb2">
  <display:table name="displayList" class="displayTag" pagesize="10"  partialList="true" 
 	 							requestURI="laborIsurance.action" size="totalSize" id="result">
	<display:column title="項次" value="${result_rowNum}" />
	<display:column property="insureUnit" title="投保單位名稱"/>
 	<display:column property="insureUnitAddr" title="投保單位地址"/>
 	<display:column property="id.insureId" title="保險證號"/>
 	<display:column property="insureOccupation" title="行職業代碼"/>
 	<display:column title="異動">
 		<n:enums type="gov.nia.nrs.eums.InsuranceEums" value="${result.changeId}"/>
 	</display:column>
 	<display:column property="effectiveDate" title="生效日"/>
 	<display:column property="salary" title="投保薪資"/>
 	<display:column title="異動">
 		<n:enums type="gov.nia.nrs.eums.InsuranceEums" value="${result.changeId1}"/>
 	</display:column>
 	<display:column property="id.effectiveDate1" title="生效日"/>
 	<display:column property="salary1" title="投保薪資"/>
 	<display:column property="id.residentIdNo" title="綜合證號"/>
  </display:table>
  <div>資料來源:健保局</div>
</section>
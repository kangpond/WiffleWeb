<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="n" uri="/newresident-tags"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"  %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<section class="styleTb2">
  <display:table name="displayList" class="displayTag" id="result">
	<display:column title="項次" value="${result_rowNum}" />
	<display:column property="marry" title="結婚日期"/>
 	<display:column property="divorce" title="離婚日期"/>
 	<display:column title="投保狀態">
	  <n:desc type="1" value="${result.insureStatus}"/>	
 	</display:column>
 	<display:column property="occupation" title="職業"/>
 	<display:column property="profileCreateDate" title="建卡日期"/>
 	<display:column title="建卡身分別">
 	  <c:choose>
		<c:when test='${result.mentalHealth == "1" }'>
		     智障
		</c:when>
		<c:when test='${result.psychosis == "1" }'>
		     精神病
		</c:when>
		<c:when test='${result.disability == "1" }'>
		    其他身心障礙
		</c:when>
		<c:when test='${result.immature == "1" }'>
		    未成年
		</c:when>
		<c:when test='${result.foreignSpouseMark == "1" }'>
		    外籍配偶
		</c:when>
 	  </c:choose>
 	</display:column>
 	<display:column property="trackDate" title="最後一次追蹤管理日期"/>
 	<display:column title="是否懷孕">
 	  <n:desc type="1" value="${result.pregnancy}"/>	
 	</display:column>
 	<display:column property="birthCheckDate" title="最近一次產檢日"/>
 	<display:column property="birthControl" title="未懷孕者，生育調節狀況">
 	  <n:desc type="3" value="${result.birthControl}"/>	
 	</display:column>
 	<display:column property="childNo" title="子女數"/>
 	<display:column title="可扣除各按原因分析">
 	  <n:desc type="4" value="${result.caseStudy}"/>	
 	</display:column>
 	<display:column title="衛教指導">
 	  <n:desc type="1" value="${result.hygienGuide}"/>	
 	</display:column>
 	<display:column property="liveAddr" title="現居地址"/>
  </display:table>
  <div>資料來源:國民健康署</div>
</section>
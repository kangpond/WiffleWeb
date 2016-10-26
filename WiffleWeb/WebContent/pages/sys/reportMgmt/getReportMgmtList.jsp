<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="n" uri="/newresident-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		 <c:url value="/reportMgmt/getReportMgmts.action" var="refreshUrl">
	 	     <c:param name="startDate"  value="${startDate}" />
	 	     <c:param name="endDate"  value="${endDate}" />
	 	 </c:url>
		 <meta http-equiv="refresh" content="180;url=${refreshUrl}">
    </head>
    <section class="styleTb2">
      <s:if test="%{displayList.size() > 0}">
      	<div style="text-align: left;">畫面更新時間:<s:date name="sysDate" format="yyyy/MM/dd HH:mm:ss"/> </div>
      	
	  	<display:table name="displayList" class="displayTag" pagesize="10"  partialList="true" 
		 	 							requestURI="getReportMgmts.action"   size="totalSize" id="r">
 	 	  <display:column  title="項次">
	 	 	  	 <c:out value="${r_rowNum}" />
	 	  </display:column>					
 	      <display:column property="reportName" title="報表名稱"/>
 	      <display:column property="requestTime" title="開始時間"/>
 	      <display:column property="responTime" title="結束時間"/>
 	      <display:column title="執行狀態">
 	      	<n:processState state="${r.processState}"/>
 	      </display:column>
 	      <display:column title="下載">
 	        <c:if test="${r.processState == '2' && r.isExist}">
 	      	  <c:url value="/report/downloadAuditReport.action" var="downloadUrl">
	 	      	<c:param name="filePath"  value="${r.filePath}" />
	 	      </c:url>
	 	      <a href="<c:out value="${downloadUrl}" />" class="butEditor">下載</a>
 	        </c:if>
 	        <c:url value="queryinfo.action" var="infoUrl">
	 	      <c:param name="reportId"  value="${r.reportId}" />
	 	    </c:url>
	 	    <a href="<c:out value="${infoUrl}" />" class="butEditor">查詢條件</a>
 	      </display:column>
		</display:table>
		<div style="text-align: left;" class="asterisk">註:此頁面每三分鐘自動更新一次</div>
	  </s:if>      
      <s:else>
      	<div class="butCenter">
      	      無符合資料
      	</div>
      </s:else>
      
      <section class="butCenter">
      	<button class="btn2" type="button" onclick="searchPage()">回查詢頁</button>
      	<button class="btn2" type="button" onclick='refeshPage("${refreshUrl}")'>更新狀態</button>
	  </section>
      <script type="text/javascript">
		jQuery(document).ready(function(){
			if ('' != '${message}')
				  alert('${message}');
		})

      	function searchPage() {
			window.location.href='<s:url value="/reportMgmt/searchReportMgmt"/>';
		}  
		function refeshPage(url){
			window.location.href=url;
		}
      </script>
  </section>
</html>
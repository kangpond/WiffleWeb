<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="n" uri="/newresident-tags"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"  %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<section class="styleTb2">
  <display:table name="displayList" class="displayTag"  id="ref">
	<display:column title="項次" value="${ref_rowNum}" />
	<display:column property="referenceDate" title="註參日期"/>
 	<display:column title="註參類別">
 	  <n:code code="${ref.kind}" category="37"/>
 	</display:column>
 	<display:column property="missingDate"  title="失蹤(遺失)日期"/>
 	<display:column title="處理情形">
 	  <n:code code="${ref.process}" category="37"/>
 	</display:column>
 	<display:column title="處理單位">
 	  <n:code code="${ref.processDept}" category="656"/>
 	</display:column>
 	<display:column property="foundDate" title="尋獲日期"/>
 	<display:column title="尋獲單位">
 	  <n:code code="${ref.foundDept}" category="37"/>
 	</display:column>
  </display:table>
  <div>資料來源:內政部移民署</div>
</section>
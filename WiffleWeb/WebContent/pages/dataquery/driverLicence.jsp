<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"  %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<section class="styleTb2">
  <display:table name="displayList" class="displayTag"  id="driver">
  	<display:column title="項次" value="${driver_rowNum}" />
	<display:column property="announceDate" title="汽機車駕照取得日期"/>
 	<display:column property="id.licenceType"  title="駕駛執照種類"/>
  </display:table>
  <div>資料來源:交通部</div>
</section>
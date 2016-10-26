<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="jwr" uri="http://jawr.net/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="n" uri="/newresident-tags"  %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jwr:style src="/bundles/all.css" />
<jwr:script src="/bundles/all.js" />
</head>
<body style="width: 100%">
  <div class="wrap mpwrap">
      <tiles:insertAttribute name="header" />
      <em>
        <table class="layout" summary="排版表格">
          <tbody>
	        <tr>
	          <td class="leftbg"><tiles:insertAttribute name="menu" /></td>
	          <td class="center">
	          	<div class="main">
	              <div class="Search">
	              	 <n:crumb functionId="${session['userProfile'].maintainFunctionId}"/>
	                 <tiles:insertAttribute name="body" />
	              </div>
	            </div>   
	          </td>
	         </tr>
           </tbody>
         </table>
       </em>
       <tiles:insertAttribute name="footer" />
   </div>
</body>
<script type="text/javascript">
	var basicPath = "<%=request.getContextPath()%>";
</script>
</html>

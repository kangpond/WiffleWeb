<%@page import="java.util.jar.Attributes"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
java.util.Properties prop = new java.util.Properties();
prop.load(getServletContext().getResourceAsStream("/META-INF/MANIFEST.MF"));
String version = prop.getProperty("Build-Version");
%>
<label>version:281</label>
<h1>TEST</h1>
<a href ="<s:url value = '/cdisys/authMgmtQuery.action'/>">授權管理</a>
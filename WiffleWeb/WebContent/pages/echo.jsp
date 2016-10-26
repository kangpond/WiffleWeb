<%@page import="java.util.jar.Attributes"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
java.util.Properties prop = new java.util.Properties();
prop.load(getServletContext().getResourceAsStream("/META-INF/MANIFEST.MF"));
String version = prop.getProperty("Build-Version");
%>
<h1>TEST</h1>
<h1>version:${version}</h1>
<h1>${message}</h1>
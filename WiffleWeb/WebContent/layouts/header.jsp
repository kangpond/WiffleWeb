<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="jwr" uri="http://jawr.net/tags" %>
<div class="top" id="zone.head">
	<!--header Start-->
	<!--可更改或增加header區塊的class name-->

	<header class="header">
		<!--可設定顯示/隱藏網站Logo圖片-->
  		<h1>
  			 <a href="<s:url value='/home.action' />" title="首頁">
  			 	<jwr:img src="/images/logo_h1a.png" alt="" title=""/>
  			 </a>
  		</h1>
	    <ul class="Ribbon">
	    	<li><s:a namespace="/" action="logout">登出</s:a></li>
        </ul>
        <div class="userProfile">&nbsp;
		  <span><s:property value="#session['userProfile'].deptName" /></span>
		  <em><s:property value="#session['userProfile'].userName" /></em>
		</div>
	</header>
	<!--header End-->
</div>

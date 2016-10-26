<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body id="">
      <section class="styleTb">
      <table>
      	<tr>
      	  <td>
      	  	帳號申請已送出。請先自行列印申請表，簽核後函送移民署進行帳號權限審核作業。(審核時間約?工作天)
      	  </td>
      	</tr>
      </table>
      </section>
      <section class="butCenter">
      	  <s:url action="login" namespace="/" var="loginUrl"/>
	      <s:url action="downloadApplyFrom" namespace="/report" var="reportUrl">
	      	<s:param name="uuid">
		      	  <s:property value="%{uuid}"/>
		    </s:param>
	      </s:url>
	      <button class="btn2" type="button" onclick="redirectActions('<s:property value="%{reportUrl}"/>')">列印帳號申請表</button>
	      <button class="btn2" type="button" onclick="redirectActions('<s:property value="%{loginUrl}"/>')">回登入頁</button>
	  </section>
	  <script type="text/javascript">
	  function redirectActions(url){
		  window.location.href = url;
	  }
    </script>
    </body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body id="">
      <section class="styleTb">
    	<s:include value="/pages/sys/template/userInfoTemplate.jsp"/>  	
      </section>
      <section class="butCenter">
      	<s:url action="deleteUser" namespace="/userDef" var="deleteUrl" escapeAmp="false">
	      <s:param name="userId">
	      	<s:property value="%{userId}"/>
	      </s:param>
	    </s:url>
      	<button class="btn2" onclick="deleteUser('<s:property value="%{deleteUrl}"/>');" type="button">刪除</button>
      	<button class="btn2" onclick="javascript:history.back()" type="button">返回</button>
      </section>
      <script type="text/javascript">
		function deleteUser(url){
			if(confirm("確定要刪除此筆資料?")){
				 window.location.href = url;
			}
		}
      </script>
    </body>
</html>
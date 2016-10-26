<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <section class="styleTb">
	    <table>
	      <tr>
	      	<th><span class="asterisk">*</span>日期區間</th>
	      	<td colspan="5">
	      	  <s:property value="%{startDate}"/>~
	      	  <s:property value="%{endDate}"/>
	      	</td>
	      </tr>
	    </table>
	    <table>
	      <caption>被操作者</caption>
	      <tr>
	      	<th>身分證號 </th>
	      	<td><s:property value="%{personId}"/></td>
	      	<th>護照號碼 </th>
	      	<td><s:property value="%{passportNo}"/></td>
	      </tr>
	      <tr>
	      	<th>收件號 </th>
	      	<td><s:property value="%{permitNo}"/></td>
	      	<th>居留證碼 </th>
	      	<td><s:property value="%{residentIdNo}"/></td>
	      </tr>
	      <tr>
	      	<th>首次收件號 </th>
	      	<td><s:property value="%{firstReceiveNo}"/></td>
	      	<th>國籍</th>
	      	<td><s:property value="%{nation}"/></td>
	      </tr>
	      <tr>
	      	<th>中文姓名 </th>
	      	<td><s:property value="%{chineseName}"/></td>
	      	<th>出生日期</th>
	      	<td><s:property value="%{birthDate}"/></td>
	      </tr>
	      <tr>
	      	<th>英文姓名 </th>
	      	<td colspan="3"><s:property value="%{englishName}"/></td>
	      </tr>
	    </table>
	    <table>	
	      <caption>操作者</caption>
	      <tr>
	      	<th>帳號 </th>
	      	<td colspan="5"><s:property value="%{userId}"/></td>
	      </tr>
	      <tr>
	      	<th>姓名 </th>
	      	<td colspan="5"><s:property value="%{userName}"/></td>
	      </tr>
	    </table>
	  <section class="butCenter">
      	<button class="button" type="submit" onclick="javascript:history.back()" >上一步</button>
      	<button class="button" type="submit" onclick="searchPage()">回查詢頁</button>
	  </section>
	  <script type="text/javascript">
		function searchPage() {
			window.location.href='<s:url value="/reportMgmt/searchReportMgmt"/>';
		}
	  </script>
  </section>
</html>
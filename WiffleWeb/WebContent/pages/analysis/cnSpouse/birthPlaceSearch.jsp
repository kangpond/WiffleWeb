<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body id="">
      <section class="styleTb">
        <s:form method="post" role="form" action="list" namespace="cnSpouse">
          <table>
            <tr>
              <th>年月</th>
              <td>
              	<s:select list="%{yearList}" id="year" name="startYearResults" headerKey=""  headerValue="請選擇" value="%{startYearResults}" />
				<s:select list="%{monthList}" id="month" name="startMonthResults" headerKey=""  headerValue="請選擇" value="%{startMonthResults}" />							
              </td>
            </tr>
          </table>
          
          <section class="butCenter">
			  <button type="submit" class="btn2">查詢</button>
		  </section>
        </s:form>
      </section>	
    </body>
</html>
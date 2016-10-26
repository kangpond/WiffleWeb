<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		 <script type="text/javascript">
			 jQuery(document).ready(function() {
		 		 jQuery("input[name*='Date']").each(
	  				function() {
	  					jQuery("<span class='btnCalendar'><a href='#'><img src=\"../images/icon_Calendar.png\" /></a></span>").insertAfter(jQuery(this));
	  					jQuery(this).dynDateTime({
	  						button : ".next()",
	  						ifFormat : "%Y%m%d",
	  						minDate:0
	  				});
	  			 });
		 		 jQuery("#queryForm").validate({
		 			rules : {
		 				'startDate':{
							niiDateFmChk : true
						},
						'endDate':{
							niiDateFmChk : true
						}
			 		},
			 		submitHandler : function(form) {
		 				var startDate = jQuery("#startDate").val()        	
			 			var endDate = jQuery("#endDate").val()
			 			
			 			if(isNotNull(startDate) && isNotNull(endDate)){
			 				if(checkTwoTime(startDate,endDate))
			 					form.submit();
				 		}else
				 			form.submit();
					}
		 		 });
			 })
		 </script>
    </head>
    <section class="styleTb">
      <s:form method="post" action="getReportMgmts" id="queryForm">
      	  <table>
      	  	<tr>
      	  	  <th>
      	  	  	報表執行日期
      	  	  </th>
      	  	  <td>
      	  	  	<s:textfield id="startDate" key="startDate" maxLength="8" size="12"/>
      	  	  	~
      	  	  	<s:textfield id="endDate" key="endDate" maxLength="8" size="12"/>
      	  	  	<s:hidden name="operationType" value="3"/>
      	  	  </td>
      	  	</tr>
      	  </table>
		<section class="butCenter">
      	  <button class="button" type="submit">查詢</button>
		</section>
      </s:form> 	
  </section>
</html>
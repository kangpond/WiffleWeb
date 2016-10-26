<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <section class="styleTb">
      <s:form method="post" action="searchSummaryByDay" id="summaryForm" namespace="/report">
	      <table>
	      	<tr>
	      	  	<th><span class="asterisk">*</span>日期區間</th>
	      	  	<td colspan="5">
	      	  	  <s:textfield id="startDate" name="startDate" maxLength="8"/>~
	      	  	  <s:textfield id="endDate" name="endDate" maxLength="8"/>
	      	  	</td>
	      	</tr>
	      	<tr>
	      	  <th>查詢者帳號 </th>
	      	  <td colspan="5"><s:textfield name="userId" maxLength="20"/></td>
	      	</tr>
	      </table>
	      <div class="asterisk" style="text-align:left;">註：前有＊者代表必填</div>
		<section class="butCenter">
      	  <button class="btn" type="submit">查詢</button>
      	  <button class="button" type="reset">清除</button>
		</section>
      </s:form>
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
	    	  
	         jQuery("#summaryForm").validate({
	        	 submitHandler : function(form) {
	        		 var f = jQuery(form);
		        	 var startDate = jQuery(f.find("#startDate")).val()      	
		 			 var endDate = jQuery(f.find("#endDate")).val()
		 			 
			    	 jQuery("#errMsg").hide();
		 			 if(checkTwoTime(startDate,endDate))
				    	form.submit();
			    	 return
	 			 },
	        	 rules : {
	        		'startDate':{
						required : true,
						niiDateFmChk : true
					},
					'endDate':{
						required : true,
						niiDateFmChk : true
					}
		       	 }
		     })
	      })
			if ('' != '${message}')
			  alert('${message}');
      </script>
  </section>
</html>
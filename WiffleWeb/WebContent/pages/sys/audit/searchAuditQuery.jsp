<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    </head>
    <section class="styleTb">
      <s:form method="post" action="searchQuery" id="auditQueryForm" role="form">
	      <table>
	      	<tr>
	      	  	<th><span class="asterisk">*</span>日期區間</th>
	      	  	<td colspan="5">
	      	  	  <s:textfield id="startDate" name="startDate" maxLength="8"/>~
	      	  	  <s:textfield id="endDate" name="endDate" maxLength="8"/>
	      	  	</td>
	      	</tr>
	      </table>
	      <table>
	      	<caption>被查詢者</caption>
	      	<tr>
	      	  <th>身分證號 </th>
	      	  <td><s:textfield name="personId" maxLength="20"/></td>
	      	  <th>護照號碼 </th>
	      	  <td><s:textfield name="passportNo" maxLength="15"/></td>
	      	</tr>
	      	<tr>
	      	  <th>收件號 </th>
	      	  <td><s:textfield name="permitNo" maxLength="12"/></td>
	      	  <th>居留證號 </th>
	      	  <td><s:textfield name="residentIdNo" maxLength="10"/></td>
	      	</tr>
	      	<tr>
	      	  <th>首次收件號 </th>
	      	  <td><s:textfield name="firstReceiveNo" maxLength="12"/></td>
	      	  <th>國籍</th>
	      	  <td><s:textfield name="nation" maxLength="3"/></td>
	      	</tr>
	      	<tr>
	      	  <th>中文姓名 </th>
	      	  <td><s:textfield name="chineseName" maxLength="20"/></td>
	      	  <th>出生日期</th>
	      	  <td><s:textfield name="birthDate" maxLength="8"/></td>
	      	</tr>
	      	<tr>
	      	  <th>英文姓名 </th>
	      	  <td colspan="3"><s:textfield name="englishName" maxLength="50"/></td>
	      	</tr>
	      </table>
	      <table>	
	      	<caption>查詢者</caption>
	      	<tr>
	      	  <th>帳號 </th>
	      	  <td colspan="5"><s:textfield name="userId" maxLength="20"/></td>
	      	</tr>
	      	<tr>
	      	  <th>姓名 </th>
	      	  <td colspan="5"><s:textfield name="userName" maxLength="50"/></td>
	      	</tr>
	      </table>
	    <div class="asterisk" style="text-align:left;">
	    	註1：前有＊者代表必填 
	    </div>
      	<section class="butCenter">
      	  <button class="button" type="submit">查詢</button>
      	  <button class="button" type="reset">清除</button>
		</section>
      </s:form>
      <script type="text/javascript">
	      jQuery(document).ready(function() {
	    	 //jQuery("input[name='nation']").appendNationData();
		     
			 jQuery("input[name*='Date']").each(
				function() {
					jQuery("<span class='btnCalendar'><a href='#'><img src=\"../images/icon_Calendar.png\" /></a></span>").insertAfter(jQuery(this));
					jQuery(this).dynDateTime({
						button : ".next()",
						ifFormat : "%Y%m%d",
						minDate:0
				});
			 });
	 		 jQuery("#auditQueryForm").validate({
			 			submitHandler : function(form) {
			 				var f = jQuery(form);
				        	var startDate = jQuery(f.find("#startDate")).val()      	
				 			var endDate = jQuery(f.find("#endDate")).val()
			 				if(checkTwoTime(startDate,endDate))
			 					form.submit();
						},
						rules : {
							'permitNo' : {
								number : true
							},
							'firstReceiveNo' : {
								number : true
							},
							'nation' : {
								number : true
							},
							'passportNo' : {
								englishNumberValidate : true
							},
							'personId' : {
								englishNumberValidate : true
							},
							'residentIdNo': {
								englishNumberValidate : true
							},
							'chineseName' : {
								chineseValidate : true
							},
							'userName' : {
								chineseValidate : true
							},
							'englishName' : {
								englishNameValidate : true
							},
							'birthDate' : {
								niiDateFmChk : true
							},
							'startDate':{
								required : true,
								niiDateFmChk : true
							},
							'endDate':{
								required : true,
								niiDateFmChk : true
							},
							actionType:{require_from_group:[1,".actionType"]},
						},
						messages:{
							actionType:{require_from_group:"請至少選擇一個!"},
						},
						errorPlacement:function(error,element){
							if(element.attr("name")== "actionType"){
								error.insertAfter("#actionType"); 
							}else
								error.insertAfter(element); 
						}
					});
				
	 		if ('' != '${message}')
	 			  alert('${message}');
	      })
      </script>
  </section>
</html>
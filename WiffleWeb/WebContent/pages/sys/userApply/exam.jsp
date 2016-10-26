<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body id="">
      <section class="styleTb">
      	<s:form method="post" id="examForm" role="form" action="examApply" namespace="/userApply">
      	  <s:include value="/pages/sys/template/userEditTemplate.jsp"/>
      	  <s:hidden name="uuid" value="%{uuid}"/>
      	  <s:hidden id="caseStatus" name="caseStatus" value="%{caseStatus}"/>
      	  <s:hidden name="applyKind" value="%{applyKind}"/>
      	</s:form>
      </section>
	  <section class="butCenter">
	      <button class="btn2" type="button" onclick="examUser('1');">核准</button>
	      <button class="btn2" type="button" onclick="examUser('2');">不准</button>
	      <button class="btn2" type="button" onclick="javascript:history.back();">返回</button>
	  </section>      
      
      <script type="text/javascript">
      	jQuery(document).ready(function() {
      		jQuery("input[name='deptId']").appendGov();
      		jQuery("#examForm").validate({
 	  			invalidHandler: function(form, validator) {
 	  		        var errors = validator.numberOfInvalids();
 	  		        if (errors) {                    
 	  		            validator.errorList[0].element.focus();
 	  		        }
 	  		    }, 
 				rules : {
 					'userName' : {
 						required : true,
 						chineseValidate : true
 					},
 					'email' : {
 						required : true,
 						email : true
 					},
 					'tel' : {
 						required : true,
 						number : true
 					},
 					'userTitle': {
 						required : true
 					},
 					'deptId':{
 						required : true,
 						englishNumberValidate : true
 	 				},
 	 				'deptAddr':{
 	 					required : true
 	 	 			}
 				}
 	  		})
		 })
      	function examUser(caseStatus){
      		if(confirm("確定要送出?")){
      			jQuery("#caseStatus").val(caseStatus)
      			getChecked();
       		 	jQuery("#examForm").submit();
          	}
        }
      </script>
      
      	
    </body>
</html>
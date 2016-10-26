<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body id="">
      <section class="styleTb">
      	<s:form method="post" id="examForm" role="form" action="saveAuthority" namespace="/userApply">
      	  <s:include value="/pages/sys/template/userEditTemplate.jsp"/>
      	  <s:hidden name="uuid" value="%{uuid}"/>
      	  <s:hidden id="applyKind" name="applyKind" value="%{applyKind}"/>  	
      	</s:form>
      </section>
      <section class="butCenter">
	      <button class="btn2" type="button" onclick="alterApply('1');">送出</button>
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
 	  		
			if ('' != '${message}')
				alert('${message}');
		 })
      	function alterApply(applyKind){
      		if(confirm("確定要送出?")){
      			jQuery("#applyKind").val(applyKind)
				getChecked();
       		 	jQuery("#examForm").submit();
          	}
        }
      </script>
    </body>
</html>
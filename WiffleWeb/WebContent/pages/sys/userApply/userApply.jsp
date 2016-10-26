<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body id="">
	  <section class="styleTb">
      	<s:form method="post" id="applyForm" role="form" action="saveUserApply" namespace="/userCAApply">
      	  <!-- 
      	  <table>
			  <tr>
			  	<th>使用者帳號</th>
			  	<td><s:property value='%{userId}'/>
			  		<s:hidden name="userId" value='%{userId}'/>
			  	</td>
			  </tr>
			  <tr>
			  	<th>憑證序號</th>
			  	<td><s:property value='%{certificateSn}'/>
			  		<s:hidden name="certificateSn" value='%{certificateSn}'/>
			  	</td>
			  </tr>
			  <tr>
			  	<th><span class="asterisk">*</span>使用者姓名</th>
			  	<td><s:textfield name="userName" maxlength="15" value="%{userName}"/> </td>
			  </tr>
			  <tr>
			  	<th><span class="asterisk">*</span>電子郵件</th>
			  	<td><s:textfield name="email" maxlength="150" value="%{email}"/></td>
			  </tr>
			  <tr>
			  	<th><span class="asterisk">*</span>聯絡電話</th>
			  	<td>
			  		<s:textfield name="tel" maxlength="10" value="%{tel}"/>
			  		分機
			  		<s:textfield name="telExt" maxlength="4" value="%{telExt}"/>
			  	</td>
			  </tr>
			  <tr>
			  	<th>傳真電話 </th>
			  	<td><s:textfield name="fax" maxlength="10" value="%{fax}"/></td>
			  </tr>
			  <tr>
			  	<th><span class="asterisk">*</span>職稱</th>
			  	<td><s:textfield name="userTitle" maxlength="60"  value="%{userTitle}"/></td>
			  </tr>
			  <tr>
			  	<th><span class="asterisk">*</span>使用者所屬機關</th>
			  	<td>
			  	  <s:textfield id="deptId" name="deptId"  size="20" value="%{deptId}"/>
			  	</td>
			  </tr>
			  <tr>
			  	<th><span class="asterisk">*</span>機關地址</th>
			  	<td><s:textfield name="deptAddr" maxlength="200" value="%{deptAddr}" size="80"/></td>
			  </tr>
			  <tr>
			  	<th>申請功能項目</th>
			  	<td>
			 	  <ul id="tree" class="tree"></ul>
			 	  <s:hidden name="functionIds"  id="functionIds"/>
			    </td>
			  </tr>
			  <tr>
			  	<th>名冊所轄縣市</th>
			  	<td>
			  	  <input type="checkbox" id="checkAll" name="checkAll">全選<br>
			  	  <s:iterator status="i" var="c" value="citys">
			  	  	<input type="checkbox" name="cityCode" value="${c.cityCode}"
			  	  	  <s:iterator value="selectedCitys" var="sc">
					    <s:if test="%{#sc.equals(#c.cityCode)}">  
					      checked="checked"  
					    </s:if>  
					  </s:iterator>
			  	  	/>
			  	  	<s:property value="#c.cityName"/> 
			  	  	<s:if test="%{(#i.index+1) % 4 == 0}">
			  	  	  <br>
			  	  	</s:if>
			  	  </s:iterator>
			  	</td>
			  </tr>
			</table> 
			
			<!-- 
			 	  <s:iterator status="i" var="f" value="functions">
					<input type="checkbox" name="functionId" value="${f.functionId}" 
						<s:iterator value="userFunctions" var="uf">
					        <s:if test="%{#uf.equals(#f.functionId)}">  
					          checked="checked"  
					        </s:if>  
					      </s:iterator>							
					/>
					<s:property value="#f.functionName"/> <br>
			 	  </s:iterator> -->
			<s:include value="/pages/sys/template/userEditTemplate.jsp"/>
      	  	<s:hidden name="uuid" value="%{uuid}"/>
      	  	<s:hidden id="applyKind" name="applyKind" value="%{applyKind}"/>
      	  	<s:hidden id="caseStatus" name="caseStatus" value="%{caseStatus}"/>  	
      	</s:form>
      </section>
      <section class="butCenter">
	      <button class="btn2" type="button" onclick="alterApply('0');">送出</button>
	      <button class="btn2" type="button" onclick="javascript:history.back();">返回</button>
	  </section>
	  <script type="text/javascript">
      	jQuery(document).ready(function() {
			jQuery("input[name='deptId']").appendGov();
			jQuery("#applyForm").validate({
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
			jQuery('#checkAll').click(function(){
				if(jQuery(this).prop('checked') == true){
					jQuery("input[name*='cityCode']").each(function(idx){
						jQuery(jQuery("input[name*='cityCode']").get(idx)).prop('checked',true);
					});
				}else{
					jQuery("input[name*='cityCode']").each(function(idx){
						jQuery(jQuery("input[name*='cityCode']").get(idx)).prop('checked',false);
					});
				}
			});
			
			if ('' != '${message}')
				alert('${message}');
		 })
      	function alterApply(applyKind){
      		if(confirm("確定要送出?")){
      			jQuery("#applyKind").val(applyKind)
      			jQuery("#caseStatus").val("0")
      			/*
    			var rids = jQuery('input[type="checkbox"][name="functionId"]:checked').map(function(){   		            		
    				return jQuery(this).val();
       		    });
       		    if(rids.length == 0 || rids == null || rids == "undefined"){
        		    alert("請勾選功能!")
        		    return
        		}*/

	       		var cidys = jQuery('input[type="checkbox"][name="cityCode"]:checked').map(function(){   		            		
	 				return jQuery(this).val();
	    		});
	    		if(cidys.length == 0 || cidys == null || cidys == "undefined"){
	     		    alert("請勾選縣市!")
	     		    return
	     		}
	    		getChecked();
       		 	jQuery("#applyForm").submit();
          	}
        }
      </script>    
    </body>
</html>
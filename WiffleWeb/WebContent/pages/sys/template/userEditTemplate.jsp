<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<table>
  <tr>
  	<th>使用者帳號</th>
  	<td><s:property value="%{userId}"/>
  		<s:hidden name="userId" value="%{userId}"/>
  	</td>
  </tr>
  <tr>
  	<th>憑證序號</th>
  	<td><s:property value="%{certificateSn}"/></td>
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

<script type="text/javascript">
	jQuery(document).ready(function() {
		var functionTree = <c:out value='${functionTree}' escapeXml="false" />;
		jQuery('#tree').tree({
			data: functionTree,
 			checkbox: true,
 			animate:true,
 			cascadeCheck:true,
 			onlyLeafCheck:false,
 			onClick:function(node){
 				jQuery(this).tree('toggle', node.target);
 			},
 			onLoadSuccess:function(node, data){
	 			if(data != null && data != "undefined")
 					jQuery('#loading').hide();
 			},
 			onContextMenu: function(e, node){
 				e.preventDefault();
 				jQuery('#tree').tree('select', node.target);
 			}
	 	});
		
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
	})
	
	function getChecked(){
 		var nodes = jQuery('#tree').tree('getChecked');

 		if(nodes.length == 0 || nodes == null || nodes == "undefined"){
		    alert("請勾選功能!")
		    return
		}
		
 		var s = '';
 		for(var i=0; i<nodes.length; i++){
 			if (s != '') s += ',';
 			s += nodes[i].id;
 		}
 		jQuery('#functionIds').val(s);
 	}
</script>
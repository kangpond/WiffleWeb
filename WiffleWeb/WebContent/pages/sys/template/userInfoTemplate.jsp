<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="n" uri="/newresident-tags"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<table>
  <tr>
  	<th>使用者帳號</th>
  	<td><s:property value="%{userId}"/></td>
  </tr>
  <tr>
	<th>憑證序號</th>
	<td><s:property value="%{certificateSn}"/></td>
  </tr>
  <tr>
	<th>使用者姓名</th>
	<td><s:property value="%{userName}"/></td>
  </tr>
  <tr>
	<th>電子郵件</th>
	<td><s:property value="%{email}"/></td>
  </tr>
  <tr>
	<th>聯絡電話</th>
	<td>
	  <s:property value="%{tel}"/>
	  <s:if test='%{telExt != null && telExt != ""}'>
		分機  <s:property value="%{telExt}"/>    	  	  
	  </s:if>
	</td>
  </tr>
  <tr>
	<th>傳真電話 </th>
	<td><s:property value="%{fax}"/></td>
  </tr>
  <tr>
	<th>職稱</th>
	<td><s:property value="%{userTitle}"/></td>
  </tr>
  <tr>
	<th>使用者所屬機關</th>
	<td><n:gov deptId="${deptId}"/></td>
  </tr>
  <tr>
	<th>機關地址</th>
	<td><s:property value="%{deptAddr}"/></td>
  </tr>
  <tr>
	<th>申請功能項目</th>
	<td>
	  <!-- 
  	  <s:iterator status="i" var="f" value="functions">
		<input type="checkbox" name="functionId" value="${f.functionId}" disabled="disabled"
			<s:iterator value="userFunctions" var="uf">
        		<s:if test="%{#uf.equals(#f.functionId)}">  
          			checked="checked"  
        		</s:if>  
      		</s:iterator>							
		/>
	 	<s:property value="#f.functionName"/> <br>
  	 </s:iterator> -->
  	   <ul id="tree" class="tree"></ul>
    </td>
   </tr>
   <tr>
	 <th>名冊所轄縣市</th>
	 <td>
	   <s:iterator status="i" var="c" value="citys">
  	  	<input type="checkbox" name="cityCode" value="${c.cityCode}" disabled="disabled"
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
		var functionTree = <c:out value='${functionTree}' escapeXml='false' />
		jQuery('#tree').tree({
			data: functionTree,
 			checkbox:true,
 			animate:true,
 			cascadeCheck:false,
 			onlyLeafCheck:true,
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
	})
</script>
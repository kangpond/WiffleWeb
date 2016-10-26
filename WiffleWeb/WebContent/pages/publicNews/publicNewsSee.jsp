<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		 
		 
<style>
.wrapline {
    width: 700px;
    /* border: 0px solid #FFFFFF; */
    word-wrap: break-word;
    
} 
</style>
		 <title>公告</title>
	
		 <script type="text/javascript">
		 <%-- jQuery(document).ready(function(){
			

				
				var newsDept = "<%=request.getAttribute("newsDept")%>";
				var flag=false;
		 		jQuery.post('<s:url value="/json/ajaxNewsDept.action"/>',{newsDept:newsDept}).done(function( data ) {
		 			jQuery('#tree').tree({
		 				data: jQuery.parseJSON(data.strFunc),
			 			checkbox: true,
			 			animate:true,
			 			cascadeCheck:true,
			 			onClick:function(node){
			 				//alert(node.text);
			 				jQuery(this).tree('toggle', node.target);
			 			},
			 			onLoadSuccess:function(node, data){
				 			if(data != null && data != "undefined")
			 					{
			 						//jQuery('#loading').hide(); 
			 						jQuery('#tree').tree('collapseAll');
			 						flag=true;
				 					}
			 			},
			 			onContextMenu: function(e, node){
			 				e.preventDefault();
			 				jQuery('#tree').tree('select', node.target);
			 				
			 			},onBeforeCheck:function(node, checked){
			 				if(flag){
			 					return false;
			 				}
			 			}

			 			
				 	});
			 	});
				
			 					 })  --%>
		 (function($) {
				$(function() {
					
					var url =location.href;
					
					var idx = url.indexOf("fromIndex=1");

				   	 if(idx>0)
					{
				   	    //var style = document.getElementById('fromIndex').style;
				   	    document.getElementById('fromIndex').style.display='none';
					    }
					//判斷從首頁連過來之公告不顯示回查詢頁按鈕
					
				});
			})(jQuery);
			 function changeForm(actionName){
					if(actionName != null && actionName != "undefined"){
						jQuery("#userForm").attr('action',actionName)
						/* if(!checkSubmit()){
							return false;
					    } */
					    jQuery("#userForm").submit();
					}
				}
		 function download(uuid,fileName){
				
				jQuery("#selectedId").val(uuid);
				jQuery("#exportFileName").val(fileName);
				jQuery("#userForm").attr('action','newsDownload').submit();
			   }
          
		 </script>
	</head>
	<body id="">
	
	<div class="main">
    <div class="Search">
		 <h2><span>佈告欄 - 詳細</span></h2>
		 <section class="styleTb">
		 <s:form method="post" cssClass="form" id="userForm" action="" >
		 
		 <s:hidden id="selectedId" name="selectedId" />
		 <s:hidden id="exportFileName" name="exportFileName" />
		 	 <table >
		 		 <tr>
		 		 
		 		     <s:hidden  id="newsSeq"  name="newsSeq" />	
		 		    
					<th>
						標題
					</th>
					
					<td>
						
					 <s:property value="%{title}" escapeHtml="false"/>
					 
										
					</td>
				 </tr>
				
				<%-- <tr>
				 	<th>重要性</th>
				 	<td><s:radio list="#{'1':'置頂','0':'一般'}" name="priority"  value="%{priority}" disabled="true"/>
				 	
				 	</td>
				 </tr>  --%>
				
				 <tr>
				 <th>公告日期</th>
				 <td>
				
					 <s:property value="%{startDate}"/>～<s:property value="%{endDate}"/> 
					 
			     </td>
				 
				 </tr>
				 
				 <tr>
				 	<th>內容</th>
				 	<td>
				 	<%-- <s:textarea id="content" maxlength="300"  name="content" value="%{content}" readonly="true" style="width: 377px; height: 153px; resize: none;">
				 	</s:textarea> --%>
				 	 
				 	<s:property value="%{content}" escapeHtml="false"/> 
				 	</td>
				 	</tr>
				 
				
				 <tr >
					<th> 公告人員</th>
					<td>
						
					    <s:property value="%{userName}"/>
					  
					</td>
				
				 </tr>
				 
		
				<s:if test='%{newsSeq != null && newsSeq != ""}'>
					<s:if test="%{existUuids.size > 0}">
					<s:iterator status="stat" value="existUuids">


								<tr>
									<th>附件<s:property value="#stat.index+1"/></th>
									<td>
										<input
										name="existUuids[<s:property value="#stat.index"/>]"
										value="<s:property />"
										style="padding: 0.03em 1em;" type="hidden" size="12" >
										
										<s:property value="%{existFileNameList[#stat.index]}"/>
										&nbsp;&nbsp;
										<input type="button" style="padding: 0.13em 0.5em;" class="btnHL" onclick="download('<s:property />','<s:property value="%{existFileNameList[#stat.index]}"/>')" value="下載">	
									</td>
		
								</tr>


							</s:iterator>
					</s:if>
				</s:if>
				 
		 	 </table>
		 	 <section class="butCenter">
		 	 	<input type="button"  name="backStep" class="btnHL" value="上一頁"   onclick="window.history.back();" />
		 	 	<input type="button"  name="lastStep" class="btnHL" id="fromIndex" value="回查詢頁"  onclick="changeForm('back')" />
		 	 	
		 	<!--end of class="butCenter"--></section>
		 </s:form>
		 <!--end of class="styleTb"--></section> 
<!--end of class="Search"--></div>
<!--end of class="main"--></div>
	</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
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

.tableline {
    width: 340px;
    /* border: 0px solid #FFFFFF; */
    word-wrap: break-word; 
    text-align:left;
  
}
.NoNewline {
	white-space: nowrap; 
}
</style>
</head>
<body id="">
	

	<s:if test="%{displayList.size > 0}">
	<div class="Search">
	<h2>佈告欄 - 列表</h2>
	<section class="styleTb2">
		<display:table name="displayList" id="result" class="displayTag"
			pagesize="10" partialList="true"  defaultsort="1"	 sort="external"
			requestURI="publicNewsSearch.action" size="totalSize"
			>
		
			<display:column title="項次" >
			 <c:out value="${result_rowNum}" />
			</display:column>
			
			<display:column title="標題" >
			<div class="tableline">
			 <c:out value="${result.title}" />
			 </div>
			</display:column> 
			<display:column  title="公告時間(起)" >
			<fmt:parseDate pattern="yyyyMMdd" value="${result.startDate}" var="parsedDate" />
			<fmt:formatDate value="${parsedDate}" pattern="yyyy/MM/dd" />
			</display:column>
			
			<display:column title="公告時間(迄)"  >
			<fmt:parseDate pattern="yyyyMMdd" value="${result.endDate}" var="parsedDate2" />
			<fmt:formatDate value="${parsedDate2}" pattern="yyyy/MM/dd" />
			</display:column>
			<%-- <display:column property="title" title="標題" />  --%>
			
			<display:column title="功能選項">
				<div class="NoNewline">
					
					<input type="button" class="btnHL"  value="檢視"
						onclick="onRowShow('${result.newsSeq}')" />
						
					
					<input type="button" class="edit" value="編輯"
							onclick="onRowEdit('${result.newsSeq}')" />
					
				</div>
			</display:column>
			
			
		</display:table>
		  <br>
		 <div id="displayFooter" class="aCenter"></div>
		
		 <br>
		 
		 <input type="button" class="btnHL" name="backStep"  value="上一頁" onclick="window.history.back();" />
		
		 
		<input type="button" class="btnHL" name="lastStep" id="fromIndex"  value="回查詢頁"  onclick="changeForm('back')" />
		 
		
		<!--end of class="styleTb2"--></section> 
		<!--end of class="Search"--></div>
	</s:if>
	<s:form method="post" cssClass="form" id="userForm">
	<s:hidden id="selectedId" name="selectedId" />
	
	<s:else>
	<div class="main">
		<div class="Search">
	<h2>佈告欄 - 查詢</h2>
	<section class="styleTb">
		<s:if test="hasActionMessages()">
			<s:iterator value="actionMessages">
				<script language="JavaScript">   
                 alert("<s:property escape="false"/>")   
             </script>
			</s:iterator>

		</s:if>
			<table>
			
				<tr>
					<th>公告日期</th>
					<td><s:textfield id="startDate" name="startDate" maxlength="8" /> ～ <s:textfield
							id="endDate" name="endDate" maxlength="8" /></td>
				</tr>
				<tr>
					<th>使用者帳號</th>
					<td><s:textfield id="userId" name="userId" maxlength="10" /> </td>
				</tr>
				<tr>
					<th>標題</th>
					<td><s:textfield id="title" name="title" maxlength="100" /> </td>
				</tr>
				
			</table>
			<section class="butCenter">
				<!--<s:submit name="submit"  align="center"  value="查詢"  cssClass="btnHL" action="userDefList"/>-->
				
				
				<input type="button" value="查詢" name="btnEnter" class="btnHL"
					onclick="changeForm('publicNewsSearch')" /> 
				
					
					
				<input type="button" value="清除" name="clear" class="btnHL" onclick="cl()"/>
					
					
				<input type="button" value="新增" name="create" class="btnHL"
					onclick="changeForm('publicNewsCreate')" />
					

			</section>

			
			</section>
	<!--end of class="Search"--></div>
	<!--end of class="main"--></div>
	<div style="margin-left: 3%">
				<p>備註：</p>
				<ol>
					
					<li>不輸入條件則直接查詢</li>
					<li>公告日期格式YYYYMMDD</li>
					
				</ol>
			</div> 
	</s:else>
	</s:form>

	<script type="text/javascript">
		 (function($) {
				$(function() {

					
					 jQuery("#userForm").validate({
							rules : {
								'startDate' : {
									niiDateFmChk : true
								},
								'endDate' : {
									niiDateFmChk : true
								},'userId' : {
									englishNumberValidate : true
								}
								
							}
						});

					
					$(".pagelinks").appendTo("#displayFooter");
					$(".pagebanner").appendTo("#displayFooter");
					$("#startDate").focus();
					bindDatePlugin("input[name*='Date']");

					
					var url =location.href;
					
					var idx = url.indexOf("fromIndex=1");

				   	if(idx>0)
					{
				   	    //var style = document.getElementById('fromIndex').style;
				   	    document.getElementById('fromIndex').style.display='none';
				   	    //document.getElementById('edit').style.display='none';
						$('.edit').css('display', 'none');
					}
					//判斷從首頁連過來之公告不顯示回查詢頁；維護按鈕
					
				});
			})(jQuery);

		 
			function changeForm(actionName){
				if(actionName != null && actionName != "undefined"){
					jQuery("#userForm").attr('action',actionName)
								
				    jQuery("#userForm").submit();
				}
			}


			
		function cl() {

			userForm.startDate.value = '';
			userForm.endDate.value = '';
			userForm.userId.value = '';
			userForm.title.value = '';
			}

		function onRowEdit(seq) {
			jQuery("#selectedId").val(seq);
			jQuery("#userForm").attr('action', 'updatePublicNews').submit();
		}

	
		function onRowShow(seq) {
			jQuery("#selectedId").val(seq);
			var url =location.href;
			var idx = url.indexOf("fromIndex=1");

			if (idx > 0) {
				jQuery("#userForm").attr('action', 'seePublicNews?fromIndex=1')
						.submit();
			} else {
				jQuery("#userForm").attr('action', 'seePublicNews')
				.submit();
			}

		}
	</script>
</body>
</html>
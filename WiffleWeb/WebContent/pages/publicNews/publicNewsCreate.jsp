<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
	<head>
		 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		 <title>公告</title>
		
		 <script type="text/javascript">
		
		
		 jQuery(document).ready(function(){

			  
				bindDatePlugin("input[name*='Date']");


				
				 jQuery("#userForm").validate({
						rules : {
							'startDate' : {
								niiDateFmChk : true
							},
							'endDate' : {
								niiDateFmChk : true
							}
							
						}
					});

			
			
		 					 }) 
		 					 
			 function changeForm(actionName){
				if(actionName != null && actionName != "undefined"){

						if (actionName == "deletePublicNews"){
							if (confirm('確定要刪除嗎？')) 
								{
									jQuery("#userForm").attr('action',actionName);
									
									jQuery("#userForm").submit();
	
	
									}
							else{
								return false;
							}

						}
						else {
							jQuery("#userForm").attr('action',actionName);
							
							if(actionName == 'savePublicNews')
								{
									
									if(!checkFile())
									{
										return false;
										}
									
									
									var title = document.getElementById('title').value;
									var startDate = document.getElementById('startDate').value;
									var endDate = document.getElementById('endDate').value;
								 
								   
								    var content = document.getElementById('content').value;

								   /*  var priority = document.userForm.priority;
								    var len = priority.length;
								    var chosen = null;

								    for (i = 0; i <len; i++) {
								        if (priority[i].checked) {
								           chosen = priority[i].value;
								        }
								    }

								    if (chosen == null) {
								    	alert('請選擇重要性');
										return false;
								    } */

									
								if(title==null || title=='')
									{
										alert('標題不得為空');
										return false;
									}
									else if(startDate==null || startDate=='')
									{
										alert('請輸入公告起日');
										return false;
									}
									else if(endDate==null || endDate=='')
									{
										alert('請輸入公告迄日');
										return false;
									}
									
									else if(content==null || content=='')
									{
										alert('請輸入公告內容');
										return false;
									}

									if (!checkTwoTime(startDate, endDate)) {
										//alert('公告迄日不得小於公告起日');
										return false;
										}
								}
							jQuery("#userForm").submit();
							
						}
					}
				}
		
			
		 function cla(){
			 	 //jQuery('input[name=priority]:checked').attr('checked',false);
			
			   
			     userForm.content.value = '';
				 userForm.title.value = '';
				 userForm.startDate.value = '';
				 userForm.endDate.value = '';
			
				 }


		 var rowindex = 0;
		 function addfujian() {    
			 
			   var num = document.getElementById("mytable").rows.length;  
			   
			   var Table = document.getElementById("mytable");
			   var Tr =  Table.insertRow(num);
			  
			   //建立新的td 而Tr.cells.length就是這個tr目前的td數  
			   Td = Tr.insertCell(Tr.cells.length);
			   //Td.innerHTML = '顯示附件檔名 <input name="docTitle" type="text" size="15">';     

			   Td = Tr.insertCell(Tr.cells.length);
			  
			   Td.innerHTML = '附件 <s:file label="附件上傳" name="uploads"  /> <input type="button" style="padding: 0.13em 0.5em;" class="btnHL" onclick="del(this)" value="刪除附件">  ';     
			
			   rowindex++;
			   	
				}


	
				function del(ele) {
					
					jQuery(ele).closest("tr").remove();
				}
				
				   
				   

				function checkFile() {
				        //var f = document.getElementById("uploads").files;
				         var fileSize= 0;
				         var checkIndex = 0 ;
				         var totalSize = 0 ;
				        jQuery('#userForm input[name="uploads"]')
				        .each(function(i, item) {
				       	       fileSize = item.files.item(0).size;
				       	       //var fileName = item.files.item(0).name;
				       	       totalSize = totalSize+fileSize ;
				        	 	  
					        });  


				       		 if(!checkSize(totalSize))
			        		 {
			        		  
			        		   return false;
			        	  	 }
		
				       		 else
					        {
								return true;
					        }
						
				    }

				    //檢查檔案大小
				    function checkSize(totalSize) {
				    	 var SizeLimit = 52428800;  //上傳上限50mb，單位:byte
				        if (totalSize > SizeLimit) {
				    
				            var msg = /* "您所選擇的檔案 :"+fileName + " ,大小為 " + 
				            (fileSize / 1024 /1024).toPrecision(4) + 
				            " MB\n */"已超過單次上傳上限 " +
				             (SizeLimit / 1024 /1024) + " MB\n不允許上傳！";
				             
					        alert(msg);
				            return false;
						} else {
				            return true;
				        }
				    }

				    
			</script>
	</head>
	<body id="">
	 <div class="Search">
		 <h2> ${session['newstitle']}</h2>
		 <section class="styleTb">
		 <s:form method="post" Class="form" id="userForm" action="savePublicNews" enctype="multipart/form-data">
		 	 
		 	  
		 	 <table id="mytable">
		 		 <tr>
		 		
		 		     <s:hidden  id="newsSeq"  name="newsSeq" />	
		 		    
					<th>
						<span class="asterisk">*</span>
						標題
					</th>
					
					
					<td>
						
					   <s:textfield  name="title" id="title" maxlength="100"  value="%{title}"/>
						
					  						
					</td>
				 </tr>
				 
				 <%-- <tr>
				 	<th><span class="asterisk">*</span>重要性</th>
				 	<td><s:radio list="#{'1':'置頂','0':'一般'}" name="priority" id="priority"  value="%{priority}"/>
				 	
				 	</td>
				 </tr>  --%>
				 
				 <tr>
				 <th><span class="asterisk">*</span>公告日期</th>
				 <td>
						
					    <s:textfield  name="startDate" id="startDate"  maxlength="8"  value="%{startDate}" />
						
						起 ～	
						 <s:textfield  name="endDate" id="endDate" maxlength="8"  value="%{endDate}" />
						迄
						<br>
						
						
			     </td>
				 
				 </tr>
				 
				 <tr>
				 	<th><span class="asterisk">*</span>內容</th>
				 	<td>
				 	<s:textarea id="content" maxlength="300"  name="content" value="%{content}"  style="width: 377px; height: 153px; resize: none;">
				 	</s:textarea>
				
				 	</td>
				 </tr>
				 
				
				 <tr>
						<th><span class="asterisk">*</span>公告人員</th>
					
						
						<td>
						<s:hidden name="userId" id="userId" value="%{userId}" />
				     
                        <s:property value="%{userName}"/>
                        
						</td>
				 </tr>
				
					
				<tr>
				<th>附件上傳</th>
				
				<td>
				 <input type="button"   name="addf"  class="btnHL" value="新增附件" onclick="addfujian();" />
			<!-- 	<a href="javascript:void(0)" onclick="addfujian();">添加附件</a>  -->
				 <br> 單次上傳總量限制：50MB
				
				
				</td>
				
				</tr>
			
				<s:if test='%{newsSeq != null && newsSeq != ""}'>
					<s:if test="%{existUuids.size > 0}">
					<s:iterator status="stat" id="existUuids" value="existUuids">
					
								<tr>
									<th>附件<s:property value="#stat.index+1"/></th>
									<td>
										<input
										name="existUuids[<s:property value="#stat.index"/>]"
										value="<s:property />"
										style="padding: 0.03em 1em;" type="hidden"  >
										
										
										<s:property value="%{existFileNameList[#stat.index]}"/>
										<%-- <input
										name="existFileNameList[<s:property value="#stat.index"/>]"
										value="<s:property value="%{existFileNameList[#stat.index]}"/>"
										style="padding: 0.03em 1em;" type="text"  readonly> --%>
										&nbsp;&nbsp;
										<input type="button" class="btnHL"  style="padding: 0.13em 0.5em;"  onclick="del(this)" value="刪除附件">	
									</td>
		
								</tr>

					</s:iterator>
					
					</s:if>
				</s:if>
		 	 </table>
		 	 
		 	<s:if test="hasActionErrors()">     
      		   <s:iterator value="actionErrors">     
                <script   language="JavaScript">     
                 alert("<s:property escape="false"/>")     
                </script>     
             </s:iterator>     
    		 </s:if> 
    		 
		 	<section class="butCenter">
		 	
		 	   
		    	 <s:if test='%{newsSeq != null && newsSeq != ""}'>
		 	     <input type="button"   name="backStep"  value="上一頁" onclick="window.history.back();" />
		 	 	 </s:if>
		 	 	 <input type="button" name="savePublicNews" value="送出"  class="btnHL"  onclick="changeForm('savePublicNews')" /> 	 
		 	 	 <input type="button"  name="lastStep"  value="回查詢頁" class="btnHL"   onclick="changeForm('back')" />
		 	 	
		 	 		
		 	 	<s:if test='%{newsSeq != null && newsSeq != ""}'> <!-- 近編輯頁 +刪除按鈕 -->
		 	    <input type="button" name="deletePublicNews" value="刪除"  class="btnHL" onclick="changeForm('deletePublicNews')" />
		 		<!-- <input type="button" value="清除"  name="clear1"  onclick="cla()" /> -->
		 		</s:if>
		 		
		 		
		 	</section>
		 </s:form>
		  <!--end of class="styleTb"--></section> 
		<!--end of class="Search"--></div>
	</body>
</html>
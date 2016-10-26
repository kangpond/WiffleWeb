<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="n" uri="/newresident-tags"%>
<script type="text/javascript">
	(function($) {
		$(function() {
			$("#bt_toQuery").click(function() {
				$("#dataQueryDetailform").attr("action", "inquiry").submit();
			});

			$("#tabs").tabs({
				cache : false,
				async : false,
				ajaxOptions : {
					cache : false
				},
				itemOptions : [ {
					cache : false
				} ],
				beforeLoad : function(event, ui) {
					ui.jqXHR.error(function() {
						ui.panel.html("此功能未完成，請洽開發人員！");
					});
				},
				show : function(event, ui) {
					// $("input[value=返回]").remove();
					$("[id^='ui-tabs']").html("");
				},
				activate : function(e, ui) {
					ui.oldPanel.html("");
				}
			});
		});
	})(jQuery);
</script>
<s:form id="dataQueryDetailform" method="post" action="#"
	namespace="/dataQuery">
	<section class="styleTb">
		<table class="rowTb">
			<colgroup style="width: 20%" />
			<colgroup style="width: 30%" />
			<colgroup style="width: 20%" />
			<colgroup style="width: 30%" />
			<tr>
				<th colspan="4" style="text-align: center;">外籍、大陸、港澳配偶基本資料</th>
			</tr>
			<tr>
				<th>中文姓名</th>
				<td>${resp.chineseName}</td>
				<th>居留證號</th>
				<td>${resp.residentIdNo}</td>
			</tr>
			<tr>
				<th>英文姓名</th>
				<td>${resp.englishName}</td>
				<th>身分證號</th>
				<td>${resp.personId}</td>
			</tr>
			<tr>
				<th>出生日期</th>
				<td><n:formatDate date="${resp.birthDate}" /></td>
				<th>首次入出境許可證號</th>
				<td>${resp.firstReceiveNo}</td>
			</tr>
			<tr>
				<th>性別</th>
				<td><n:code code="${resp.gender}" category="70" /></td>
				<th>護照號碼</th>
				<s:if
					test='resp.foreignPassportNo == null || resp.foreignPassportNo == ""'>
					<td>${resp.passportNo}</td>
				</s:if>
				<s:else>
					<td>${resp.foreignPassportNo}</td>
				</s:else>
			</tr>
			<tr>
				<th>教育程度</th>
				<td><n:code code="${resp.education}" category="14" /></td>
				<th>僑居地/國籍</th>
				<td><n:code code="${resp.nation}" category="15" /></td>
			</tr>
			<tr>
				<th>職業</th>
				<td><n:code code="${resp.occupation}" category="4" /></td>
				<th>出生地</th>
				<td><n:birthPlace birthPlace2="${resp.birthPlace2}"
						birthPlace1="${resp.birthPlace1}"
						birthPlaceCode="${resp.birthPlaceCode}" /></td>
			</tr>
			<tr>
				<th>身分</th>
				<td><n:code code="${resp.position}" category="5" /></td>
				<th>手機</th>
				<td>${resp.mobile}</td>
			</tr>
			<tr>
				<th>居留電話</th>
				<td colspan="3">${resp.telA}</td>
			</tr>
			<tr>
				<th>海外地址</th>
				<td colspan="3">${resp.addr1B}${resp.addr2B}${resp.addr3B}
					${resp.addr4B}</td>
			</tr>
			<tr>
				<th>居留地址</th>
				<td colspan="3"><n:displayAddress niiAddress="${niiAddressVo}" /></td>
			</tr>
			<tr>
				<th>註記說明</th>
				<td colspan="3"><s:if
						test='resp.fsType != null && resp.fsType == "0"'>外籍</s:if> <s:elseif
						test='resp.fsType != null && resp.fsType == "1"'>大陸</s:elseif> <s:else>港澳</s:else>
				</td>
			</tr>
		</table>
		<div id="tabs">
			<ul>
				<n:link firstReceiveNo="${resp.firstReceiveNo}" residentIdNo="${resp.residentIdNo}"/>
			</ul>
		</div>
		<section class="butCenter">
			<button type="button" class="btn2" onclick="javascript:window.history.back();" >上一頁</button> 
		    <button type="button" class="btn2" id="bt_toQuery">回查詢頁</button> 
		</section>
	</section>
</s:form>

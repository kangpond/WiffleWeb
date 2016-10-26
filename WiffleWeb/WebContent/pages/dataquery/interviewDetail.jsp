<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="n" uri="/newresident-tags"%>

<s:form id="interviewDetailform" cssClass="form" method="post"
	namespace="/dataQuery">
	<section class="styleTb">
		<table class="rowTb">
			<colgroup style="width: 100px" />
			<colgroup style="width: 200px" />
			<colgroup style="width: 100px" />
			<colgroup style="width: 200px" />
			<tr>
				<th>入出境許可證號</th>
				<td>${interviewResp.receiveNo}</td>
				<th>首次入出境許可證號</th>
				<td>${interviewResp.firstReceiveNo}</td>
			</tr>
			<tr>
				<th>面談對象</th>
				<td><s:if
						test='interviewResp.f2fPerson != null && interviewResp.f2fPerson == "1"'>
						大陸配偶
					</s:if> <s:elseif
						test='interviewResp.f2fPerson != null && interviewResp.f2fPerson == "2"'>
						在台配偶
					</s:elseif> <s:elseif
						test='interviewResp.f2fPerson != null && interviewResp.f2fPerson == "3"'>
						大陸+在台配偶
					</s:elseif> <s:elseif
						test='interviewResp.f2fPerson != null && interviewResp.f2fPerson == "4"'>
						外籍配偶
					</s:elseif> <s:else>外籍配偶+在台配偶</s:else></td>
				<th>面談第次別</th>
				<td>${interviewResp.timesF2fTalk}</td>
			</tr>
			<tr>
				<th>開始面談日期時間</th>
				<td><n:formatDate
						date="${interviewResp.startF2fTalkDate}${interviewResp.startF2fTalkTime}" /></td>
				<th>截止面談日期時間</th>
				<td><n:formatDate
						date="${interviewResp.endF2fTalkDate}${interviewResp.endF2fTalkTime}" /></td>
			</tr>
			<tr>
				<th>面談地點</th>
				<td>${interviewResp.talkPlace}</td>
				<th>面談結果</th>
				<td><n:code code="${interviewResp.f2fResult}" category="225" /></td>
			</tr>
			<tr>
				<th>面談備註說明</th>
				<td colspan="3">${interviewResp.remark}</td>
			</tr>
			<tr>
				<th>入境日期</th>
				<td><n:formatDate date="${interviewResp.entryDate}" /></td>
				<th>遣返日期</th>
				<td><n:formatDate date="${interviewResp.exitDate}" /></td>
			</tr>
			<tr>
				<th>入境班機</th>
				<td>${interviewResp.entryFlyNo}</td>
				<th>遣返班機</th>
				<td>${interviewResp.exitFlyNo}</td>
			</tr>
			<tr>
				<th>電話-1</th>
				<td>${interviewResp.telNo1}</td>
				<th>電話-2</th>
				<td>${interviewResp.telNo2}</td>
			</tr>
			<tr>
				<th>訴願狀況</th>
				<td colspan="3"><n:code code="${interviewResp.appealStatus}"
						category="226" /></td>
			</tr>
		</table>
		<section class="butCenter">
			<input type="button" class="btnHL" value="關閉視窗"
				onclick="window.close()" />
		</section>
	</section>
</s:form>

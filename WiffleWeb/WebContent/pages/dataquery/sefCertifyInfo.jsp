<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
      <section class="styleTb">
      	<table>
      	  <tr>
      	    <th colspan="6" style="text-align: center;">海基會認證資料</th>
      	  </tr>
		  <tr>
		    <th>文件總編號</th>
		    <td><s:property value="%{sefCertify.documentNo}"/></td>
		  </tr>
		  <tr>
      	    <th colspan="6" style="text-align: center;">申請人</th>
      	  </tr>
		  <tr>
		    <th>姓名</th>
		    <td><s:property value="%{sefCertify.chineseName}"/></td>
		    <th>身分證號</th>
		    <td><s:property value="%{sefCertify.personId}"/></td>
		    <th>出生日期</th>
		    <td><s:property value="%{sefCertify.birthDate}"/></td>
		  </tr>
		  <tr>
		    <th>電話一</th>
		    <td><s:property value="%{sefCertify.tel1}"/></td>
		    <th>電話二</th>
		    <td><s:property value="%{sefCertify.tel2}"/></td>
		    <th>通訊地址</th>
		    <td><s:property value="%{sefCertify.address}"/></td>
		  </tr>
		  <tr>
      	    <th colspan="6" style="text-align: center;">代理人</th>
      	  </tr>
		  <tr>
		    <th>姓名</th>
		    <td><s:property value="%{sefCertify.agentChineseName}"/></td>
		    <th>身分證號</th>
		    <td><s:property value="%{sefCertify.agentPersonId}"/></td>
		    <th>出生日期</th>
		    <td><s:property value="%{sefCertify.agentBirthDate}"/></td>
		  </tr>
		  <tr>
		    <th>電話一</th>
		    <td><s:property value="%{sefCertify.agentTel1}"/></td>
		    <th>電話二</th>
		    <td><s:property value="%{sefCertify.agentTel2}"/></td>
		    <th>通訊地址</th>
		    <td><s:property value="%{sefCertify.agentAddress}"/></td>
		  </tr>
		  <tr>
      	    <th colspan="6" style="text-align: center;">公證書資料</th>
      	  </tr>
		  <tr>
		    <th>公證處</th>
		    <td><s:property value="%{sefCertify.notarizePlace}"/></td>
		    <th>公證字號</th>
		    <td><s:property value="%{sefCertify.notarizeId}"/></td>
		    <th>公證日期</th>
		    <td><s:property value="%{sefCertify.notarizeDate}"/></td>
		  </tr>
		  <tr>
		    <th>公證書原樣</th>
		    <td><s:property value="%{sefCertify.notarizeOrigId}"/></td>
		    <th>類別</th>
		    <td><s:property value="%{sefCertify.notarizeClass}"/></td>
		    <th>用途</th>
		    <td><s:property value="%{sefCertify.notarizePurpose}"/></td>
		  </tr>
		  <tr>
      	    <th colspan="6" style="text-align: center;">副本資料</th>
      	  </tr>
		  <tr>
		    <th>當事人</th>
		    <td colspan="6"><s:property value="%{sefCertify.copyParty}"/></td>
		  </tr>
		  <tr>
      	    <th colspan="6" style="text-align: center;">狀態資料</th>
      	  </tr>
		  <tr>
		    <th>狀態</th>
		    <td><s:property value="%{sefCertify.statusData}"/></td>
		    <th>作業項目</th>
		    <td><s:property value="%{sefCertify.statusItem}"/></td>
		    <th>作業時間</th>
		    <td><s:property value="%{sefCertify.statusProcessDate}"/></td>
		  </tr>
		  <tr>
      	    <th colspan="6" style="text-align: center;">處理結果</th>
      	  </tr>
		  <tr>
		    <th>發證日期</th>
		    <td><s:property value="%{sefCertify.processIssueDate}"/></td>
		    <th>驗證結果</th>
		    <td colspan="3"><s:property value="%{sefCertify.processResult}"/></td>
		  </tr>
      	</table>
      </section>
	  <section class="butCenter">
		<button class="btn2" type="button" onclick="window.close();">關閉視窗</button>
	  </section>
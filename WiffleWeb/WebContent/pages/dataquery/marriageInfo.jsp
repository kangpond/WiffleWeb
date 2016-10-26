<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="n" uri="/newresident-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<section class="styleTb" id="tabs">
  <table>
  	<tr>
  	  <th>通報日期</th>
  	  <td>
  	  	<s:property value="%{householdMarriage.id.announceDate}"/>
  	  </td>
  	  <th>通報時間</th>
  	  <td><s:property value="%{householdMarriage.id.announceTime}"/></td>
  	</tr>
  	<tr>
  	  <th>戶籍地址</th>
  	  <td colspan="3">
  	    <s:property value="%{householdMarriage.addr1}"/>
  	    <s:property value="%{householdMarriage.addr2}"/>
  	    <s:property value="%{householdMarriage.addr3}"/>
  	    <s:property value="%{householdMarriage.addr4}"/>
  	  </td>
  	</tr>
  	<tr>
  	  <th>結婚日期</th>
  	  <td><s:property value="%{householdMarriage.marrageDate}"/></td>
  	  <th>申請日期</th>
  	  <td><s:property value="%{householdMarriage.applyDate}"/></td>
  	</tr>
  	<tr>
  	  <th>記事</th>
  	  <td colspan="3">
  	  	<s:property value="%{householdMarriage.remark1}"/>
  	  	<s:property value="%{householdMarriage.remark2}"/>
  	  </td>
  	</tr>
  	<tr>
  	  <th>申請人姓名_1</th>
  	  <td><s:property value="%{householdMarriage.apply1name}"/></td>
  	  <th>申請人姓名_2</th>
  	  <td><s:property value="%{householdMarriage.apply2name}"/></td>
  	</tr>
  	<tr>
  	  <th>申請人統號_1</th>
  	  <td><s:property value="%{householdMarriage.apply1personId}"/></td>
  	  <th>申請人統號_2</th>
  	  <td><s:property value="%{householdMarriage.apply2personId}"/></td>
  	</tr>
  	<tr>
  	  <th>申請人地址_1</th>
  	  <td colspan="3">
  	    <s:property value="%{householdMarriage.apply1zipCode}"/>
  	    <s:property value="%{householdMarriage.apply1addr1}"/>
  	    <s:property value="%{householdMarriage.apply1addr2}"/>
  	    <s:property value="%{householdMarriage.apply1addr3}"/>
  	    <s:property value="%{householdMarriage.apply1addr4}"/>
  	  </td>
  	</tr>
  	<tr>
  	  <th>申請人地址_2</th>
  	  <td colspan="3">
  	  	<s:property value="%{householdMarriage.apply2zipCode}"/>
  	    <s:property value="%{householdMarriage.apply2addr1}"/>
  	    <s:property value="%{householdMarriage.apply2addr2}"/>
  	    <s:property value="%{householdMarriage.apply2addr3}"/>
  	    <s:property value="%{householdMarriage.apply2addr4}"/>
  	  </td>
  	</tr>
  	<tr>
  	  <th>戶長統號</th>
  	  <td><s:property value="%{householdMarriage.headPersonId}"/></td>
  	  <th>原住民族別代碼</th>
  	  <td><s:property value="%{householdMarriage.indigenousGroup}"/></td>
  	</tr>
  	<tr>
  	  <th>當事人關係_1</th>
  	  <td><s:property value="%{householdMarriage.reason1}"/></td>
  	  <th>當事人關係_2</th>
  	  <td><s:property value="%{householdMarriage.reason2}"/></td>
  	</tr>
  </table>
</section>
<section class="butCenter">
   <button class="btn2" type="button" onclick="window.close();">關閉視窗</button>
</section>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="n" uri="/newresident-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"  %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<section class="styleTb">
  <table>
    <tr>
      <th>入出境證號</th>
      <td><s:property value="%{resultMap.get('receiveNo')}"/> </td>
      <th>抵台日期</th>
      <td><s:property value="%{resultMap.get('entryDate')}"/></td>
      <th>離台日期</th>
      <td><s:property value="%{resultMap.get('exitDate')}"/></td>
    </tr>
    <tr>
      <th>辦公室地址</th>
      <td colspan="3"><s:property value="%{resultMap.get('addressWK')}"/></td>
      <th>辦公室電話</th>
      <td><s:property value="%{resultMap.get('telNoWK')}"/></td>
    </tr>
    <tr>
      <th>服務機關</th>
      <td colspan="3"><s:property value="%{resultMap.get('serviceOfficeName')}"/></td>
      <th>服務機關電話</th>
      <td><s:property value="%{resultMap.get('serviceOfficeTel')}"/></td>
    </tr>
    <tr>
      <th>附註</th>
      <td colspan="5"><s:property value="%{resultMap.get('remark')}"/></td>
    </tr>
    
    <tr>
      <th>稱謂</th>
      <td>
      	<n:code code="${resultMap.get('relation')}" category="131"/>
      </td>
      <th>中文姓名</th>
      <td><s:property value="%{resultMap.get('chineseName')}"/></td>
      <th>國籍</th>
      <td>
      	<n:code code="${resultMap.get('nation')}" category="15"/>
      </td>
    </tr>
    <tr>
      <th>電話</th>
      <td><s:property value="%{resultMap.get('relTel')}"/></td>
      <th>英文姓名</th>
      <td><s:property value="%{resultMap.get('englishName')}"/></td>
      <th>身分(居留)證號</th>
      <td><s:property value="%{resultMap.get('relationIdNo')}"/></td>
    </tr>
  </table>
  <br>
  <display:table name="${resultMap.get('passportList')}" class="displayTag"  id="p">
	<display:column property="foreignPassportNo" title="護照號碼"/>
 	<display:column property="issueExpireDate" title="護照期限"/>
 	<display:column property="residentIdNo" title="統一證號"/>
 	<display:column title="核准效期">
 	  ${p.rcStartDate}~${p.rcEndDate}
 	</display:column>
  </display:table>
  <br>
  <display:table name="${resultMap.get('workList')}" class="displayTag"  id="w">
	<display:column title="核准聘僱機關">
	  <n:code code="${w.workAllowDept}" category="12"/>
	</display:column>
 	<display:column property="workAllowDate" title="核准日期"/>
 	<display:column property="workAllowDocNo" title="文號"/>
 	<display:column title="期限">
 	  ${w.workAllowStartDate}~${w.workAllowEndDate}
 	</display:column>
  </display:table>
  <br>
  <display:table name="${resultMap.get('livingAddressList')}" class="displayTag"  id="l">
  	<display:caption>居留地址及遷移記錄</display:caption>
	<display:column property="applyDate" title="申請日期"/>
 	<display:column property="address" title="居留地址"/>
 	<display:column property="telNo" title="電話"/>
  </display:table>
  
  <display:table name="${resultMap.get('workAddressList')}" class="displayTag"  id="w">
  	<display:caption>辦公地址及遷移記錄</display:caption>
	<display:column property="applyDate" title="申請日期"/>
 	<display:column property="address" title="辦公地址"/>
 	<display:column property="telNo" title="電話"/>
  </display:table>
</section>
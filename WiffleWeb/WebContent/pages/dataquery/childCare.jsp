<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="n" uri="/newresident-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<section class="styleTb">
  <table>
    <tr>
      <th>項次</th>
      <th>子女身分證</th>
      <th>中文姓名</th>
      <th>出生日期</th>
      <th>出生健康狀況</th>
      <th>目前存歿狀況</th>
      <th>最近一次 0-3歲兒童發展遲緩篩檢日期</th>
      <th>是否接受遲緩兒通報</th>
      <th>0-3歲兒童發展遲緩篩檢結果</th>
    </tr>
    <s:if test='%{resultMap.get("childNo") != null 
    				&& resultMap.get("childNo") !="" && resultMap.get("childNo") > 0 }'>
      <tr>
		  <td>1</td>      
	      <td><s:property value='%{resultMap.get("firstChildPersonId")}' /></td>
	      <td><s:property value='%{resultMap.get("firstChildChineseName")}'/></td>
	      <td><s:property value='%{resultMap.get("firstChildBirthDate")}' /></td>
	      <td>
	        <n:desc type="6" value='${resultMap.get("firstChildHealth")}'/>
	      </td>
	      <td>
	      	<n:desc type="5" value='${resultMap.get("firstChildLive")}'/>
	      </td>
	      <td><s:property value='%{resultMap.get("firstChildCheckDate")}' /></td>
	      <td><s:property value='%{resultMap.get("firstGrowthDelay")}' /></td>
	      <td>
	      	<n:desc type="7" value='${resultMap.get("firstChildStunt")}'/>
	      </td>
      </tr>
      <s:if test='%{resultMap.get("secondChildPersonId") != ""}'>
        <tr>
		  <td>2</td>      
	      <td><s:property value='%{resultMap.get("secondChildPersonId")}' /></td>
	      <td><s:property value='%{resultMap.get("secondChildChineseName")}' /></td>
	      <td><s:property value='%{resultMap.get("secondChildBirthDate")}' /></td>
	      <td>
	        <n:desc type="6" value='${resultMap.get("secondChildHealth")}'/>
	      </td>
	      <td>
	        <n:desc type="5" value='${resultMap.get("secondChildLive")}'/>
	      </td>
	      <td><s:property value='%{resultMap.get("secondChildCheckDate")}' /></td>
	      <td><s:property value='%{resultMap.get("secondGrowthDelay")}' /></td>
	      <td>
	        <n:desc type="7" value='${resultMap.get("secondChildStunt")}'/>
	      </td>
        </tr>
      </s:if>
      <s:if test='%{resultMap.get("thirdChildPersonId") != ""}'>
        <tr>
		  <td>3</td>      
	      <td><s:property value='%{resultMap.get("thirdChildPersonId")}' /></td>
	      <td><s:property value='%{resultMap.get("thirdChildChineseName")}' /></td>
	      <td><s:property value='%{resultMap.get("thirdChildBirthDate")}' /></td>
	      <td>
	        <n:desc type="6" value='${resultMap.get("thirdChildHealth")}'/>
	      </td>
	      <td>
	        <n:desc type="5" value='${resultMap.get("thirdChildLive")}'/>
	      </td>
	      <td><s:property value='%{resultMap.get("thirdChildCheckDate")}' /></td>
	      <td><s:property value='%{resultMap.get("thirdGrowthDelay")}' /></td>
	      <td>
	        <n:desc type="7" value='${resultMap.get("thirdChildStunt")}'/>
	      </td>
        </tr>
      </s:if>
      <s:if test='%{resultMap.get("fourthChildPersonId") != ""}'>
        <tr>
		  <td>4</td>      
	      <td><s:property value='%{resultMap.get("fourthChildPersonId")}' /></td>
	      <td><s:property value='%{resultMap.get("fourthChildChineseName")}' /></td>
	      <td><s:property value='%{resultMap.get("fourthChildBirthDate")}' /></td>
	      <td>
	         <n:desc type="6" value='${resultMap.get("fourthChildHealth")}'/>
	      </td>
	      <td>
	        <n:desc type="5" value='${resultMap.get("fourthChildLive")}'/>
	      </td>
	      <td><s:property value='%{resultMap.get("fourthChildCheckDate")}' /></td>
	      <td><s:property value='%{resultMap.get("fourthGrowthDelay")}' /></td>
	      <td>
	        <n:desc type="7" value='${resultMap.get("fourthChildStunt")}'/>
	      </td>
        </tr>
      </s:if>
      <s:if test='%{resultMap.get("fifthChildPersonId") != ""}'>
        <tr>
		  <td>5</td>      
	      <td><s:property value='%{resultMap.get("fifthChildPersonId")}' /></td>
	      <td><s:property value='%{resultMap.get("fifthChildChineseName")}' /></td>
	      <td><s:property value='%{resultMap.get("fifthChildBirthDate")}' /></td>
	      <td>
	        <n:desc type="6" value='${resultMap.get("fifthChildHealth")}'/>
	      </td>
	      <td>
	        <n:desc type="5" value='${resultMap.get("fifthChildLive")}'/>
	      </td>
	      <td><s:property value='%{resultMap.get("fifthChildCheckDate")}' /></td>
	      <td><s:property value='%{resultMap.get("fifthGrowthDelay")}' /></td>
	      <td>
	        <n:desc type="7" value='${resultMap.get("fifthChildStunt")}'/>
	      </td>
        </tr>
      </s:if>
      <s:if test='%{resultMap.get("sixthChildPersonId") != ""}'>
        <tr>
		  <td>6</td>      
	      <td><s:property value='%{resultMap.get("sixthChildPersonId")}' /></td>
	      <td><s:property value='%{resultMap.get("sixthChildChineseName")}' /></td>
	      <td><s:property value='%{resultMap.get("sixthChildBirthDate")}' /></td>
	      <td>
	        <n:desc type="6" value='${resultMap.get("sixthChildHealth")}'/>
	      </td>
	      <td>
	        <n:desc type="5" value='${resultMap.get("sixthChildLive")}'/>
	      </td>
	      <td><s:property value='%{resultMap.get("sixthChildCheckDate")}' /></td>
	      <td><s:property value='%{resultMap.get("sixthGrowthDelay")}' /></td>
	      <td>
	        <n:desc type="7" value='${resultMap.get("sixthChildStunt")}'/>
	      </td>
        </tr>
      </s:if>
    </s:if>
    <s:else>
      <tr>
      	<td colspan="9">查無資料</td> 
      </tr>
    </s:else>
  </table>
  <div>資料來源:國民健康署+社家署</div>
</section>
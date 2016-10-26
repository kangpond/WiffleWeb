<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="n" uri="/newresident-tags"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"  %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<section class="styleTb2">
  <display:table name='${resultMap.get("disableList")}' class="displayTag"  id="disable">
  	<display:caption>身心障礙</display:caption>
  	<display:column title="障礙類別">
  	  <n:desc type="8" value="${result.handiCapType}"/>	
  	</display:column>
 	<display:column title="傷殘等級">
 	  <n:desc type="9" value="${result.disabilityClass}"/>
 	</display:column>
 	<display:column property="tel" title="聯絡電話"/>
 	<display:column property="createTime" title="資料產生日期"/>
 	<display:column property="lastUpdateTime" title="資料更新日期"/>
 	<display:column title="戶籍地址">
 	</display:column>
 	<display:column property="commAddr" title="通訊地址"/>
  </display:table>
  
  <display:table name='${resultMap.get("allowanceList")}' class="displayTag"  id="disable">
  	<display:caption>領取中低收入老人津貼</display:caption>
 	<display:column title="戶籍地址">
 	</display:column>
 	<display:column property="createTime" title="資料產生日期"/>
 	<display:column property="lastUpdateTime" title="資料更新日期"/>
  </display:table>

  <display:table name='${resultMap.get("lowIncomeList")}' class="displayTag"  id="disable">
  	<display:caption>低收入戶</display:caption>
 	<display:column title="戶籍地址">
 	</display:column>
 	<display:column property="createTime" title="資料產生日期"/>
 	<display:column property="lastUpdateTime" title="資料更新日期"/>
  </display:table>
</section>
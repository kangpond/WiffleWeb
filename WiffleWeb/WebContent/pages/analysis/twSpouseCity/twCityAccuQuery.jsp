<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<s:form id="form" cssClass="form" namespace="cityOfEdu" method="post">
	<jsp:include page="/pages/cityOf/CityOfQuery.jsp">
		<jsp:param name="isShowFsType" value="true" />
	</jsp:include>
</s:form>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:include page="hycert/hycert.jsp" />
<script type="text/javascript">
	(function($) {

		$(document).ready(function() {

			if ('' != '${message}')
				alert('${message}');

			$("#personId").focus();

			$("#bt_loginic").click(function() {
				verify();
			});

			$("#bt_clear").click(function() {
				$("#personId").val('');
				$("#password").val('');
			});

			$("#bt_apply").click(function() {
				jQuery("#form").attr("action", '<s:url action="loginApply" namespace="/userCAApply"/>').submit();
			});

			$(document).keypress(function(e) {
				if (e.which == 13) {
					verify();
				}
			});

			$("#personId").blur(function() {
				$("#personId").val($("#personId").val().toUpperCase());
			});

		});

	})(jQuery);

	function verify() {

		if (isEmpty(jQuery("#personId").val())) {
			alert('請輸入帳號！');
			return;
		}

		if (isEmpty(jQuery("#password").val())) {
			alert('請輸入密碼！');
			return;
		}

		jQuery("#personId").val(jQuery("#personId").val().toUpperCase());
		var pawd = jQuery("#password").val();
		if (typeof verifyPawd == 'function') {
			verifyPawd(pawd);
		}
	}

	function onVerifyFailure(ErrMsg) {
		//alert('憑證認証失敗!');
		alert(ErrMsg);
		jQuery("#personId").focus();
	}

	function onVerifySuccess(InvokeMsg) {
		document.getElementById("signedData").value = InvokeMsg;
		jQuery("#form").attr("action", "auth").submit();
	}

</script>
<s:form id="form" namespace="/" cssClass="form" method="post">
	<%-- SessionId --%>
	<s:hidden id="content" name="loginIcForm.content" value="%{request.getSession().getId()}>" />
	<%-- 憑證序號 --%>
	<s:hidden id="certSn" name="loginIcForm.certSn"/>
	<%-- 憑證卡號 --%>
	<s:hidden id="certCardNumber" name="loginIcForm.certCardNumber" />
	<%-- 自然人序號 --%>
	<s:hidden id="subjectSN" name="loginIcForm.subjectSN"/>
	<%-- 擁有者名稱 --%>
	<s:hidden id="certOwnerName" name="loginIcForm.certOwnerName" />
	<%-- 名稱 --%>
	<s:hidden id="certUserName" name="loginIcForm.certUserName" />
	<%-- 憑證擁有者ID --%>
	<s:hidden id="ownerId" name="loginIcForm.ownerId" />
	<%-- 憑證主卡或附卡 --%>
	<s:hidden id="isMainCard" name="loginIcForm.isMainCard" />
	<%-- 憑證主旨 --%>
	<s:hidden id="certSubject" name="loginIcForm.certSubject" />
	<%-- 憑證主體 --%>
	<s:hidden id="signedData" name="loginIcForm.signedData" />
	<section class="inputArea">
		<ul>
		  <li>
		     <label for="exampleInputEmail1" class="sr-only">身分證號：</label>
		  	 <s:textfield id="personId" name="loginIcForm.personId" value="%{loginIcForm.personId}" class="account" />
		  </li>
		  <li>
		     <label for="exampleInputPassword1" class="sr-only">憑證密碼：</label>
		  	 <s:password id="password" name="loginIcForm.password" />
		  </li>
		</ul>
    </section>
	<section class="butCenter">
		<%--將按鈕及連結移出表格 --%>
		<button type="button" id="bt_loginic"  class="btn">憑證登入</button>
		<button type="button" id="bt_clear"  class="btn">清除</button>
		<button type="button" id="bt_apply"  class="btn">申請帳號</button>
		
		<%-- <s:if test="%{isAdmin}"> --%>
		<script type="text/javascript">
			function testlogin() {
				jQuery("#form").attr("action", "authtest").submit();
			}
		</script>
		<button type="button" id="bt_login" onclick="testlogin()" style="background-color:#C10066;" >測試登入</button>
		<%-- </s:if> --%>
	</section>
	<div align="center">
			※若您的電腦第一次使用本網站，請安裝<a href="javascript:download('/pages/login/hycert/HywebCertyComSetup.msi')"><u>憑證驗證元件</u></a>，才能使用憑證登入
	</div>
</s:form>


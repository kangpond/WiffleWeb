<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<script type="text/javascript" for="myControl" event="ErrMsgEvent(ErrMsg)">
	<%-- VerifyPassword錯誤時會呼叫ErrMsgEvent --%>
	if (typeof onVerifyFailure == 'function') {
		<%-- 當錯誤時呼叫onVerifyFailure, 請撰寫onVerifyFailure --%>
		onVerifyFailure(ErrMsg);
	}
</script>
<script type="text/javascript" for="myControl" event="InvokeMsgEvent(InvokeMsg)">
	<%-- VerifyPassword正確時會呼叫InvokeMsgEvent --%>
	if (typeof onVerifySuccess == 'function') {
		<%-- 當正確時呼叫onVerifySuccess, 請撰寫onVerifySuccess --%>
		onVerifySuccess(InvokeMsg);
	}
	else {
		if (typeof onVerifyFailure !== 'function') {
			onVerifyFailure('Please define onVerifySuccess function');
		}
		else {
			alert('Please define onVerifySuccess and onVerifyFailure method.');
		}
	}
</script>
<script type="text/javascript">
	<%-- 憑證驗證卡片方法 --%>
	function verifyPawd(pawd) {
		try {
			document.getElementById("myControl").VerifyPassword(pawd);
		} catch (e)	{
			if (typeof onVerifyFailure == 'function') {
				<%-- 當錯誤時呼叫onVerifyFailure, 請撰寫onVerifyFailure --%>
				onVerifyFailure('無法使用憑證驗證元件，請確認是否有安裝憑證驗證元件，並且使用IE瀏覽器');
			}
		}
	}
</script>
<object id="myControl" classid="clsid:0EC35F17-E2AD-4a7b-B4A1-D9558C5E84D0"></object>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript">
	(function($) {
		$(function() {
			var $form = $("#dataQueryform");
			var $residentIdNo = $("input[name='req.residentIdNo']")
			var $personId = $("input[name='req.personId']");
			var $passportNo = $("input[name='req.passportNo']");
			var $receiveNo = $("input[name='req.receiveNo']");
			var $chineseName = $("input[name='req.chineseName']");
			var $englishName = $("input[name='req.englishName']");
			var $birthDate = $("input[name='req.birthDate']");
			var $personId2 = $("input[name='req.personId2']");
			var $chineseName2 = $("input[name='req.chineseName2']");
			var $birthDate2 = $("input[name='req.birthDate2']");
			var $personId3 = $("input[name='req.personId3']");
			var $chineseName3 = $("input[name='req.chineseName3']");
			var $birthDate3 = $("input[name='req.birthDate3']");

			var $queryButton = $("#bt_query");

			bindDatePlugin("input[name*='Date']");

			$form.validate({
				rules : {
					'req.residentIdNo' : {
						englishNumberValidate : true
					},
					'req.personId' : {
						englishNumberValidate : true
					},
					'req.personId2' : {
						englishNumberValidate : true
					},
					'req.personId3' : {
						englishNumberValidate : true
					},
					'req.passportNo' : {
						englishNumberValidate : true
					},
					'req.receiveNo' : {
						digits : true
					},
					'req.chineseName' : {
						chineseValidate : true
					},
					'req.chineseName2' : {
						chineseValidate : true
					},
					'req.chineseName3' : {
						chineseValidate : true
					},
					'req.englishName' : {
						englishNameValidate : true
					},
					'req.birthDate' : {
						niiDateFmChk : true
					},
					'req.birthDate2' : {
						niiDateFmChk : true
					},
					'req.birthDate3' : {
						niiDateFmChk : true
					}
				}
			});

			var checkInput = function checkInput() {
				var result = ($form
						.find('input:text[name!="req.birthDate"][name!="req.birthDate2"][name!="req.birthDate3"]:filled').length > 0);
				if (!result) {
					confirmWindow("請輸入一項(含)以上(不包含出生日期)查詢資料！");
				}
				return result;
			};

			$queryButton.click(function() {
				if (checkInput()) {
					$form.attr("action", "list").submit();
				}
			});
		});
	})(jQuery);
</script>
<section class="styleTb">
	<s:form id="dataQueryform" method="post" action="#"
		namespace="/dataQuery">
		<div class="styleTb">
			<table>
				<tr>
					<th colspan="2" style="text-align: center;">外籍與大陸配偶基本資料</th>
				</tr>
				<tr>
					<th>居留證號</th>
					<td><s:textfield name="req.residentIdNo" /></td>
				</tr>
				<tr>
					<th>身分證號</th>
					<td><s:textfield name="req.personId" /></td>
				</tr>
				<tr>
					<th>護照號碼</th>
					<td><s:textfield name="req.passportNo" /></td>
				</tr>
				<tr>
					<th>入出境許可證號</th>
					<td><s:textfield name="req.receiveNo" /></td>
				</tr>
				<tr>
					<th>中文姓名</th>
					<td><s:textfield name="req.chineseName" /></td>
				</tr>
				<tr>
					<th>英文姓名</th>
					<td><s:textfield name="req.englishName" /></td>
				</tr>
				<tr>
					<th>出生日期</th>
					<td><s:textfield name="req.birthDate" /></td>
				</tr>
				<tr>
					<th colspan="2" style="text-align: center;">臺籍配偶基本資料</th>
				</tr>
				<tr>
					<th>身分證號</th>
					<td><s:textfield name="req.personId2" /></td>
				</tr>
				<tr>
					<th>中文姓名</th>
					<td><s:textfield name="req.chineseName2" /></td>
				</tr>
				<tr>
					<th>出生日期</th>
					<td><s:textfield name="req.birthDate2" /></td>
				</tr>
				<tr>
					<th colspan="2" style="text-align: center;">子女基本資料</th>
				</tr>
				<tr>
					<th>身分證號</th>
					<td><s:textfield name="req.personId3" /></td>
				</tr>
				<tr>
					<th>中文姓名</th>
					<td><s:textfield name="req.chineseName3" /></td>
				</tr>
				<tr>
					<th>出生日期</th>
					<td><s:textfield name="req.birthDate3" /></td>
				</tr>
			</table>
		</div>
		<section class="butCenter">
			<button type="button" class="btn2" id="bt_query">查詢</button>
			<button type="reset" class="btn" >清除</button>
		</section>
	</s:form>
</section>

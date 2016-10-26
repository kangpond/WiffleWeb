(function($) {
	$.validator.addMethod("personIdChk", personIdChk, "請輸入正確的身分證字號");
	
	// 中文檢核機制，該欄位只可輸入中文
	$.validator.addMethod("chineseValidate", chineseValidate, "請輸入正確的中文姓名");

	// 日期插件統一日期格式驗證, 需為yyyy/MM/dd 或 yyyyMMdd
	$.validator.addMethod("niiDateFmChk", niiDateFmChk, "請輸入正確日期格式(YYYYMMDD)");

	// 英文數字驗證
	$.validator.addMethod("englishNumberValidate", englishNumberValidate, "請輸入英數字格式");
	
	// 英文姓名檢核機制，僅可輸入英文、非連續之空白，並會自動轉為大寫
	$.validator.addMethod("englishNameValidate", englishNameValidate, "請輸入正確的英文姓名");
	
	// 檔案最大size檢查
	$.validator.addMethod("fileSizeChk", fileSizeChk, "檔案大小超過限制");
	
	$.validator.addMethod("atLastChk", atLastChk, "請至少選填{0}個欄位");
	
	// 統一證號檢查機制
	$.validator.addMethod("residentNoValidate", residentNoValidate, "請輸入正確的統一證號");
	
	$.validator.addMethod("foreignPassportChk", foreignPassportChk, "外國籍請輸入外國護照號碼");
})(jQuery);

function personIdChk(value, element, arg) {
	var result = this.optional(element);
	if (!result && /^[A-Z,a-z][1,2]\d{8}$/.test(value)) {
		value = value.toUpperCase();
		result = checkPersonIdOrResidentId(value) ? (jQuery(element).val(value)) : false;
	}
	return result;
}

/*
 * 中文檢核機制，該欄位只可輸入中文
 *
 * 2012/9/14: 匯入
 * 2013/2/26: 配合統一詞彙，變更檢驗規則
 * 			由原有允許範圍：RegExp("^[\u4E00-\u9fa5,\u010000-\uffffff]*$")
 * 			改為排除一下範圍：RegExp("[\u0000-\u0fff]")
 */
function chineseValidate(value, element) {
	var reg = new RegExp("[\u0000-\u0fff]");
	return this.optional(element) || !reg.test(value);
}


/*
 * englishNumberValidate 暫時驗證外人「身分證 / 社會安全碼」
 * 僅可輸入 [a-zA-Z0-9]等字元，並會自動轉為大寫
 *
 * Author : Eric (A1026)
 * Creat Date : 2013/03/01
 */
function englishNumberValidate(value, element) {
	var result = this.optional(element);
	var reg = new RegExp("^([a-zA-Z0-9]*)$");

	if (!result && reg.test(value)) {
		jQuery(element).val(value.toUpperCase());
		result = true;
	}

	return result;
}

/*
 * niiDateFmChk 日期格式驗證, 此需套用jQuery validator
 * 需為 yyyy/MM/dd 或 yyyyMMdd
 *
 * 2012/9/14: 匯入
 * 2013/2/27: 改以共通格式化方法 dateFormat 驗證
 */
function niiDateFmChk(value, element, arg) {
	var result = this.optional(element);
	if (!result) {
		var fmtDate = dateFormat(value, "Complete");
		result = (fmtDate) ? (jQuery(element).val(fmtDate)) : false;
	}
	return result;
}

/*
 * fileSize 檔案最大size檢查
 */
function fileSizeChk(value, element, arg) {
	return this.optional(element) || (element.files[0].size <= arg);
}

/**
 * 將數字前方自動補零
 *
 * @param source 來源數字或字串
 * @param bits 總位數
 * @returns {String} 格式後字串
 *
 * Author : Carl (A0105)
 * Creat Date : 2013/02/27
 */
function zeroBackfill(source, bits) {
	var result = "" + source;
	while (result.length < bits)
		result = "0" + result;
	return result;
}

/**
 * 將字串格式化為 yyyy/MM/dd 之日期字串<br>
 * 若傳入格式錯誤或非正確日期，則回傳 Null
 *
 * @param source 待格式化字串
 * @param kind 種類 Complete or 1~3
 * @param delimiter 分隔符號(預設 / )
 * @returns {String} 格式後字串
 *
 * Author : Carl (A0105)
 * Creat Date : 2013/02/27
 */
function dateFormat(source, kind, delimiter) {
	var result;
	var formatType;
	var sourceNo = [1911, 1, 1];
	var defDelimiter = "";

	if (/^\d{4}\/\d{4}$/.test(source))
		source = source.replace(/\/+/g, '');

	// 輸入字串檢驗與分割字串
	if (/^\d{4}(\d{2}){0,2}$/.test(source)) {
		formatType = source.length / 2 - 1;
		sourceNo[0] = parseInt(source.substr(0, 4), 10);
		for (var i = 1; i < formatType; i++)
			sourceNo[i] = parseInt(source.substr(2 * i + 2, 2), 10);
	} else if (/^\d{4}(\/\d{1,2}){1,2}$/.test(source)) {
		var temp = source.split("/");
		formatType = temp.length;
		for (var i = 0; i < formatType; i++)
			sourceNo[i] = parseInt(temp[i], 10);
	} else {
		return null;
	}

	// 基本判斷，月份大於12 or 日期大於 31
	if (sourceNo[1] > 12 || sourceNo[2] > 31)
		return null;

	if (kind) {
		if ("COMPLETE" == kind.toUpperCase() && 3 != formatType)
			return null;
		if (/^[1-3]$/.test(kind) && kind != formatType)
			return null;
	}

	if (delimiter)
		defDelimiter = delimiter;

	var accDate = new Date(sourceNo[0], sourceNo[1] - 1, sourceNo[2]);
	var formatNo = [accDate.getFullYear(), accDate.getMonth() + 1, accDate.getDate()];

	// 判斷格式化前後是否相符
	for (var i = 0; i < formatType; i++)
		if (sourceNo[i] != formatNo[i])
			return null;

	result = zeroBackfill(formatNo[0], 4);
	for (var i = 1; i < formatType; i++)
		result += defDelimiter + zeroBackfill(formatNo[i], 2);

	return result;
}

/*
 * englishNameValidate 英文姓名檢核機制, 此需套用jQuery validator
 * 僅可輸入英文、非連續之空白，並會自動轉為大寫
 * 
 * 2012/9/14: 匯入
 * 2013/2/26: 
 * 		1. 配合統一詞彙，變更檢驗規則
 * 			將原有僅可輸入 [a-zA-Z0-9, _]等字元，RegExp("^\w,]*([ ]?[\\w,]+)*)$")
 * 			改為 -> RegExp("^[a-zA-Z]+([ ][a-zA-Z]+)*$")
 * 		2. 將原有 englishNameSpaceValidate 驗證方式併入此功能
 * 			2013/1/13: Mantis:7187 Chuck (A0031)
 * 			英文姓名檢核允許","、"-"輸入之 RegExp("^([a-zA-Z]+(([,]?[ ]?)|[-]?))+$")
 * 			由於未列入統一詞彙規範，故將之移除
 */
function englishNameValidate(value, element) {
	var result = this.optional(element);
	var reg = new RegExp("^[a-zA-Z]+([ ][a-zA-Z]+)*$");

	if (!result && reg.test(value)) {
		jQuery(element).val(value.toUpperCase());
		result = true;
	}

	return result;
}

function checkTwoTime(time1, time2){
	var start = testTimes(time1);
	var end	= testTimes(time2);
	var compared = comparedTime(start, end);
	if(start && end && compared){
		return true;
	}else if(!start && !end){
		alert("開始時間和結束時間格式錯誤！");
		return false;
	}else if(!start){
		alert("開始時間格式錯誤！");
		return false;
	}else if(!end){
		alert("結束時間格式錯誤！");
		return false;
	}else if(!compared){
		alert("開始時間大於結束時間！");
		return false;
	}
}

function testTimes(obj){
	var tem = obj;
	
	if(tem.length == 8){
		tem = tem.substr(0,4)+ "/" + tem.substr(4,2) + "/" + tem.substring(6);
		obj.value = tem;
	}
	
	if(tem.length == 10){
		var tem_time = new Date(parseInt(tem.substr(0,4),10),parseInt(tem.substr(5,2),10)-1,parseInt(tem.substr(8,2),10));
		var mm = (tem_time.getMonth()+1) > 9 ? (tem_time.getMonth()+1) : "0" + (tem_time.getMonth()+1);
		var dd = (tem_time.getDate()) > 9 ? (tem_time.getDate()) : ("0" + (tem_time.getDate()));
		return (tem_time.getFullYear() + "/" +mm + "/" + dd) == tem ? tem_time : false;
	}else
		return false;
}

function comparedTime(time1, time2){
	if(time1 && time2)
		return time1.getTime() > time2.getTime() ? false : true;
	else
		return false;
}

function isNotNull(vals){
	if(vals!= null && vals != "" && vals != "undefined"){
		return true
	}
	return false	
}
function isNull(vals){
	if(vals == null || vals == "" || vals == "undefined"){
		return true
	}
	return false	
}

function diffDay(date1, date2) {
	return Math.abs((date1 - date2) / (24 * 60 * 60 * 1000));
}

function parseDate(name) {
	var value = $(name).val();
	
	if (value.length === 8) {
		return $.datepicker.parseDate("yymmdd", value);
	}

	return $.datepicker.parseDate("yy/mm/dd", value);
}

function atLastChk(value, element, options){
	var requires = options[0];
	var target = options[1];
	
	var fields = $(target,element.form);
	
	var validOrNot = fields.filter(function() {
		return $(this).val();
	}).length >= requires
	
	var validator = this;
	if(!$(element).data('being_validated')){
		fields.data('being_validated',true).each(function(){
			validator.valid(this);
		}).data('being_validated',false)
	}
	return validOrNot;
}

function foreignPassportChk(value, element){
	var result =true;
	var nationList = {};
	nationList["0"] = 1;
	nationList["35"] = 1;
	nationList["37"] = 1;
	for (var i = 61; i <= 90; i++) {
		nationList[i] = 1;	
	}
	nationList["95"] = 1;
	if (nationList[$("#nation").val()] != '1') {
		if (value == '') {
			return false;
		}
	}
	return result;
}


function residentNoValidate(value, element, params) {
	var result = this.optional(element);
	if (!result && /^[A-Z,a-z][A-D,a-d]\d{8}$/.test(value)) {
		value = value.toUpperCase();
		result = checkPersonIdOrResidentId(value) ? (jQuery(element).val(value)) : false;
	}
	return result;
}

/**
 * 驗證身分證號或統一證號是否正確
 *
 * @param value 身分證號或統一證號
 * @returns {Boolean} 驗證結果
 *
 * Author : Carl (A0105)
 * Creat Date : 2013/02/27
 */
function checkPersonIdOrResidentId(value) {
	value = value.toUpperCase();
	if (!/^[A-Z][1,2,A-D]\d{8}$/.test(value))
		return false;

	var idCheckNumber = [10, 11, 12, 13, 14, 15, 16, 17, 34, 18, 19, 20, 21,	// A-M
	                     22, 35, 23, 24, 25, 26, 27, 28, 29, 32, 30, 31, 33];	// N-Z
	var checkCode = parseInt(idCheckNumber[value.charCodeAt(0) - 65] / 10, 10);
	checkCode += idCheckNumber[value.charCodeAt(0) - 65] * 9;

	// 第二碼加權
	if (/[1,2]/.test(value.charAt(1))) {
		checkCode += parseInt(value.charAt(1), 10) * 8;
	} else {
		checkCode += idCheckNumber[value.charCodeAt(1) - 65] * 8;
	}

	// 3~9 碼的加權計算 * 7~1
	for (var i = 2; i < 9; i++) {
		checkCode += parseInt(value.charAt(i), 10) * (9 - i);
	}
	checkCode += parseInt(value.charAt(9), 10);
	return (0 == checkCode % 10);
}
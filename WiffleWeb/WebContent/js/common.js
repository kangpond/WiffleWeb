/*
 * NiiMessage 使用jquery block UI顯示訊息
 * @param msg
 */
function niiMessage(msg) {
	confirmWindow(msg);
}

/*
 * confirmWindow 之預設參數內容
 */
var $confirmDefaults = {
	title: "提示訊息",
	msg: "",
	btn1name: "確定",
	btn1function: null,
	btn2name: null,
	btn2function: null,
	blockContainer: null,
	autoUnblock: true,
	custHeight: 90
};

/*
 * confirmWindow 使用jquery block UI 產生確認視窗
 * @param opts 傳遞所需之參數，若為字串，則使用預設參數(參數如上方顯示)，字串內容為訊息內容，
 */
function confirmWindow(opts) {
	if (opts) {
		if (typeof opts == 'string') {
			opts = jQuery.extend({}, $confirmDefaults, {msg: opts} || {});
		} else {
			opts = jQuery.extend({}, $confirmDefaults, opts || {});
		}
	} else {
		return;
	}

	var height = [30, opts.custHeight];
	var vHeight = height[0] + height[1] + 40;
	var vWidth = 250;
	var dateLong = "blockBtn" + (new Date().getTime());

	var titleStyle = "text-align: left; color: #000000; background-color: #eeeeee;";
	titleStyle += "height: " + height[0] + "px; font-size: 16px; ";

	var messageStyle = "text-align: center; color: #FF0000;";
	messageStyle += "height: " + height[1] / 3 + "px; font-size: 1.2em;";

	var $blockWindow = jQuery("<div/>");
	var $buttonDiv = jQuery("<div/>", {
		'class' : "aCenter",
		style: "height: 40px;"
	});

	// 設定 title 樣式與內容
	jQuery("<div/>", {
		text: opts.title,
		style: titleStyle
	}).appendTo($blockWindow);

	// 設定訊息區樣式與內容
	jQuery("<div/>", {
		style: "height: " + height[1] + "px"
	}).append(jQuery("<div/>", {
		style: "height: " + height[1] / 3 + "px"
	})).append(jQuery("<div/>", {
		html: opts.msg,
		style: messageStyle
	})).appendTo($blockWindow);

	// 設定功能按鍵樣式與內容
	$buttonDiv.append(jQuery("<input/>", {
		id: dateLong + "-1",
		type: 'button',
		value: opts.btn1name,
		'class' : 'btnbg'
	}));

	if (opts.btn2name != undefined) {
		// user提出需求：　確認與取消button間，需要有空隔 -- 2015/08/24
		$buttonDiv.append("　　");
		$buttonDiv.append(jQuery("<input/>", {
			id: dateLong + "-2",
			type: 'button',
			value: opts.btn2name,
			'class' : 'btnbg'
		}));
	}

	$buttonDiv.appendTo($blockWindow);

	var blockUIOptions = {
        css: {
        	top:  (jQuery(window).height() - vHeight) /2 + 'px',
        	left: (jQuery(window).width() - vWidth) /2 + 'px',
        	width: vWidth + 'px',
        	height: vHeight + 'px'
        },
        message: $blockWindow
	};

	opts.blockContainer ? $(opts.blockContainer).block(blockUIOptions) : jQuery.blockUI(blockUIOptions);

	jQuery("#" + dateLong + "-1").click(function() {
		if (opts.autoUnblock)
			opts.blockContainer ? $(opts.blockContainer).unblock() : jQuery.unblockUI();

		if (opts.btn1function && typeof opts.btn1function == 'function')
			opts.btn1function();
	});

	if (opts.btn2name != undefined) {
		jQuery("#" + dateLong + "-2").click(function() {
			if (opts.autoUnblock)
				opts.blockContainer ? $(opts.blockContainer).unblock() : jQuery.unblockUI();

			if (opts.btn2function && typeof opts.btn2function == 'function')
				opts.btn2function();
		});
	}
}

/*
 * dynDateTime 掛上日期元件
 * @param selector (input text object)
 */
function dynDateTime(selector) {
	jQuery(selector).dynDateTime({
		button: ".next()"
	});
}

/*
 * getBlockUIOptionsCSS 取得 blockUI options 的 css 參數
 * @param options 參數
 *                data type: object
 *                default value : {
 *                    width: 800,
 *                    height: 600,
 *                    cursor: null
 *                }
 */
function getBlockUIOptionsCSS(options) {
	var opt = jQuery.extend({
		width: 640,
		height: 480,
		cursor: null
	}, options || {});
	var windowWidth = jQuery(window).width();
	var windowHeight = jQuery(window).height();
	var width = (windowWidth < opt.width ? windowWidth : opt.width);
	var height = (windowHeight < opt.height ? windowHeight : opt.height);
	var css = {
		top: (windowHeight - height) / 2 + "px",
		left: (windowWidth - width) / 2 + "px",
		width: width + "px",
		height: height + "px",
		cursor: opt.cursor
	};
	return css;
}

/*
 * addSlashToDate 為日期字串加上斜線
 * @param dateString 日期字串，須為8位數字的字串
 */
function addSlashToDate(dateString) {
	if (/^\d{8}$/.test(dateString) == false) {
		return dateString;
	}

	return dateString.substr(0, 4) + "/" + dateString.substr(4, 2) + "/" + dateString.substr(6);
}

/*
 * 提供onkeyup時英文小寫轉大寫的功能
 * 使用方式如下:
 *
 * <input id="receiveNo" type="text">
 *
 * $('#receiveNo').niiToUpperCase();
 */
;(function($){
	$.fn.niiToUpperCase = function() {
		$(this).bind("keyup.niiToUpperCaseKeyup change.niiToUpperCaseChange", function(){
			$(this).val($(this).val().toUpperCase());
		});
	}
})(jQuery);

/*
 * 判斷是否為日期格式
 * @param dateString 日期字串，須為8位數字的字串
 * @return true or false
 * @author Eric Shih
 */
function checkDateFormat(dateString) {
	var re = new RegExp("^([0-9]{4})([0-9]{2})([0-9]{2})$");
	if ( re.test(dateString) == true ) {        //match
		var accDate = new Date(dateString.substring(0,4), dateString.substring(4,6) - 1, dateString.substring(6));
		var chkYear = (dateString.substr(0, 4) == accDate.getFullYear());
		var chkMonth = (dateString.substr(4, 2) == accDate.getMonth() + 1);
		var chkDate = (dateString.substr(6, 2) == accDate.getDate());
		return (chkYear && chkMonth && chkDate) ? true : false;
	} else {
		return false;
	}
}
/*
 * $.niiCW 使用 confirmWindow 產生連鎖確認視窗
 *
 * 使用方式: $.niiCW.add(opt);
 * @param opt confirmWindow 傳遞所需之參數，不可為字串;
 *            若為 function，則直接執行此 function，且不執行下一個 confirmWindow
 * 注意: btn1function 或 btn2function 回傳 false 就不會執行下一個 confirmWindow 了
 *
 * @author Terry Lee
 */
;(function($){
	var run = false;
	var queueName = "niiConfirmWindow";
	var $doc = $(document);

    $.niiCW = {
        add: function(opt) {
        	$doc.queue(queueName, function() {
				if ($.isFunction(opt)) {
					opt();
					$.niiCW.reset();
					return;
				} else if ($.isPlainObject(opt)) {
					var options = {
						btn1function: function() {
							var result;

							if ($.isFunction(opt.btn1function)) {
								result = opt.btn1function();
							}

							if (result !== false) {
								$.niiCW.run();
							} else {
								$.niiCW.reset();
							}
						},

						btn2function: function() {
							var result;

							if ($.isFunction(opt.btn2function)) {
								result = opt.btn2function();
							}

							if (result !== false) {
								$.niiCW.run();
							} else {
								$.niiCW.reset();
							}
						}
					};

					confirmWindow($.extend({}, opt, options));
				} else {
					$.niiCW.run();
				}
        	});

        	if (!run) {
        		this.run();
        	}
        },

        run: function() {
            if ($doc.queue(queueName).length > 0) {
        		run = true;
				$doc.dequeue(queueName);
			} else {
				this.reset();
			}
        },

		reset: function() {
			run = false;
			$doc.clearQueue(queueName);
		}
    };
})(jQuery);

/*
 * 日期格式補零與補斜線功能(前提須符合日期格式驗證才有作用)
 * @param selector jquery selector(單個或多個)
 * ***********************************************************
 * 20130705 新增 : Brian Su
 * 說明 : 新增日期格式補零與補斜線功能
 * ***********************************************************
 * 20130708 修正 : Brian Su
 * 說明 : 新增綁定事件後，立即觸發事件，使得初始化資料可以有補零與補斜線功能
 * ***********************************************************
 */
function dateFillZeroAndSlash(selector) {
	// 補斜線與補零動作
	$(selector).each(function(){
		$(selector).live('focusout', function(){  //JQuery的Live與Delegate不支援blur，所以改由focusout取代
			var originValue = $(this).val(); //原始日期值
			var dateNumArray = [1911, 1, 1]; //存放日期整數(預設1911年1月1號)
			var dateGroupLength; //依(4,2,2)切割日期長度, ex : 20125 -> 2 , 20120531 -> 3
			var dateDelimiter = '/'; //分隔符號

			// 只有當長度大於4才處理(有填年份與其他)
			if($.trim(originValue) != '' && originValue.length > 4){
				if (/^\d{4}\/\d{4}$/.test(originValue)){ //特殊格式 1911/1212 要轉成 1911/12/12
					originValue = originValue.replace(/\/+/g, '');
				}
				// 輸入字串檢驗與分割字串
				if (/^\d{4}(\d{2}){0,2}$/.test(originValue)) { //格式 yyyy(MMdd)
					dateGroupLength = originValue.length / 2 - 1;
					dateNumArray[0] = parseInt(originValue.substr(0, 4), 10);
					for (var i = 1; i < dateGroupLength; i++){
						dateNumArray[i] = parseInt(originValue.substr(2 * i + 2, 2), 10);
					}
				} else if (/^\d{4}(\/\d{1,2}){1,2}$/.test(originValue)) { //格式 yyyy(/MM/dd)
					var temp = originValue.split('/');
					dateGroupLength = temp.length;
					for (var i = 0; i < dateGroupLength; i++){
						dateNumArray[i] = parseInt(temp[i], 10);
					}
				}else{ //怪格式不處理
					return false;
				}
				// 檢查日期是否一致
				var accDate = new Date(dateNumArray[0], dateNumArray[1] - 1, dateNumArray[2]);
				var formatNo = [accDate.getFullYear(), accDate.getMonth() + 1, accDate.getDate()];
				// 判斷格式化前後資料是否相符
				if( ($(dateNumArray).not(formatNo).length == 0) ){
					// 補斜線與補零動作
					result = zeroBackfill(formatNo[0], 4);
					for (var i = 1; i < dateGroupLength; i++){
						result += dateDelimiter + zeroBackfill(formatNo[i], 2);
					}
					// 寫回補斜線與補零的值
					$(this).val(result);
				}
			}
		});
	});
	// 綁定事件後立即觸發，使得初始化資料可以有作用
	$(selector).trigger('focusout');
}

;(function($){
	/*
	 * jQuery Plug-in niiCode 代碼查詢共用元件
	 * -----------------------------------------------------------------------------
	 * 使用方式 1：.niiCode(category, code)
	 * 描述：將代碼中文說明帶入所選的 tag 中
	 * category: 代碼類別
	 * code: 代碼
	 * -----------------------------------------------------------------------------
	 * 使用方式 2：.niiCode(options)
	 * 描述：將所選的 input:text 綁定事件，輸入代碼後 onblur 會在右邊顯示代碼中文說明，
	 *     將查詢代碼按鈕綁定事件，會顯示 blockUI 供使用者查詢代碼。
	 * 前置準備：要使用此元件的網頁要有以上的代碼
	 * 		  <input type="text" id="xxx" name="xxx" data-category="xxx" data-categoryType="xxx"
	 * 			data-filter1="" data-filter2="" data-filter3="" data-order="" />
	 *        <input type="button" value="xxx"/>
	 *        data-category: 放置代碼類別
	 *        data-categoryType: 放置代碼中文說明類別。1:顯示說明1。2:顯示說明2。3:顯示說明1+說明2。
	 *        data-filter1: 過濾條件1。optional。
	 *        data-filter2: 過濾條件2。optional。
	 *        data-filter3: 過濾條件3。optional。
	 *        data-order: 是否用資料庫表格欄位 OrderList 排序。true or false。default false。
	 *        data-filter-name: 篩選名稱。optional。
	 *        data-filter-type: 篩選類別。optional。include or exclude。default include。
	 *        data-default-if-empty: 當欄位為空白時，是否帶入預設代碼。當查回的代碼清單只有一個代碼時才會作用。optional。true or false。default false。
	 * options:代碼查詢共用元件選項，data type: object。
	 * 		   options.blockContainer: 此選項為當要綁定的 input 已經在 blockUI 上所使用。
	 *                                 給定目前 blockUI container 的 jQuery selector，
	 *                                 ex: var options = {blockContainer: "#blockUIDiv"};
	 *         options.initQuery: 是否要在查詢頁面(blockUI)一打開即查詢所有代碼，boolean，default true。
	 *         options.inputDisplay: 是否要用input text顯示代碼說明，boolean，default false。
	 * 額外資料：若要檢核代碼是否為共用元件所查出的正確代碼 -> $(代碼input).data("codeValid")，回傳 boolean
	 * 		     若要取得代碼名稱 -> $(代碼input).data("codeName")，回傳 string
	 */
	$.fn.niiCode = function() {
		var options = $.extend({
			initQuery: true,
			inputDisplay: false
	    }, arguments[0] || {});
		var doQueryCodeList = function($text, callbackFunc, callbackArgs) {
			$.post(basicPath + '/code/queryCodeList.action', {
				"condition.category": $text.attr("data-category"),
				"condition.keyWord": convertStringData($text.attr("data-ignoreCase") != null ? $("#niiCodeQueryText").val().toUpperCase() : $("#niiCodeQueryText").val(), "string"),
			},
			function(result, status, xhr) {
				if (status != "success") {
					niiMessage("發生錯鋘，請洽系統管理員!");
				} else {
					callbackArgs.push(result);
					callbackFunc.apply(callbackFunc, callbackArgs);
				}
			}, "json");
		};
		var doDefaultIfEmpty = function($text) {
			doQueryCodeList($text, function(codeList) {
				if (codeList.length == 1) {
					$text.val(codeList[0].code).blur();
				}
			}, []);
		};
		if (arguments.length < 2) {
			return this.each(function() {
				$(this).blur(function() {
					var $text = $(this).data({
						codeValid: false,
						codeName: ""
					});
					if ($.trim($text.val()) == "") {
						showCodeDesc($text, "", false);
						return;
					}
					var upperCase = "";
					upperCase = $text.val().toUpperCase();
					$text.val(upperCase);
					$.getJSON(basicPath + '/code/queryCode.action', {
						"condition.category": $text.attr("data-category"),
						"categoryType": $text.attr("data-categoryType"),
						"condition.code": $text.val()
					},
					function(result, status, xhr) {
						if (status != "success") {
							showCodeDesc($text, "發生錯鋘，請洽系統管理員!", true);
						} else if (result == null) {
							showCodeDesc($text, "無此代碼!", true);
						} else {
							showCodeDesc($text, result, false);
						}
					});
				});
				var $text = $(this).data({
					codeValid: false,
					codeName: ""
				});
				$(this).next(":button").click(function() {
					var vWindowWidth = $(window).width();
					var vWindowHeight = $(window).height();
					var vWidth = (vWindowWidth < 640 ? vWindowWidth : 640);
					var vHeight = (vWindowHeight < 520 ? vWindowHeight : 520);
					var blockUIOptions = {
						message: "<div><h3 class='aCenter'>" + $(this).parent().prev("th").text() + "代碼查詢" +
							"<input type='text' id='niiCodeQueryText'/><input type='button' class='btnbg' id='niiCodeQueryButton' value='查詢'/><input type='button' class='btnbg' id='niiCodeCloseButton' value='關閉'/></h3>" +
							"<div class='aCenter form' style='width: 640px; height: 440px; overflow: auto;' id='niiCodeQueryResultDiv'><div></div>",
						css: {
							top: (vWindowHeight - vHeight) / 2 + "px",
							left: (vWindowWidth - vWidth) / 2 + "px",
							width: vWidth + "px",
							height: vHeight + "px",
							cursor: null
						}
					};
					options.blockContainer ? $(options.blockContainer).block(blockUIOptions) : $.blockUI(blockUIOptions);
					$("#niiCodeQueryButton").click(function() {
						$("#niiCodeQueryResultDiv").html("<img src='" + basicPath + "/images/loading.gif'/>");
						doQueryCodeList($text, showQueryResult, [$text, $text.attr("data-categoryType")]);
					});
					$("#niiCodeCloseButton").click(function() {
						unblock(options);
					});
					$("#niiCodeQueryText").keypress(function(e) {
						var code = (e.keyCode ? e.keyCode : e.which);
						if (code == 13) {
							$("#niiCodeQueryButton").click();
						}
					});
					if (options.initQuery) {
						$("#niiCodeQueryButton").click();
					}
				});
				if ($.trim($(this).val()) != "") {
					$(this).blur();
				} else {
					/* 當欄位為空白時，是否帶入預設代碼。當查回的代碼清單只有一個代碼時才會作用。 */
					if ($text.data("defaultIfEmpty")) {
						doDefaultIfEmpty($text);
					}
				}
			});
		}

		function showCodeDesc($text, desc, isError) {
			var tagName = options.inputDisplay ? "input" : "span";
			var className = options.inputDisplay ? "niiCodeInput" : "niiCodeSpan";
			var idSuffix = options.inputDisplay ? "CodeDescInput" : "CodeDescSpan";
			var $showElement = $text.nextAll(tagName + "." + className);
			if ($showElement.length == 0) {
				var id = ($text.attr("id") || $text.attr("name") || $.now()) + idSuffix;
				if (options.inputDisplay) {
					$text.nextAll().last().after("<input type='text' id='" + id + "' class='" + className + "' style='color: " + (isError ? "red" : "blue") + ";' value='" + desc + "'>");
				} else {
					$text.nextAll().last().after("<span id='" + id + "' class='" + className + "' style='color: " + (isError ? "red" : "blue") + ";'>" + desc + "</span>");
				}
			} else {
				if (options.inputDisplay) {
					$showElement.val(desc).css("color", isError ? "red" : "blue");
				} else {
					$showElement.text(desc).css("color", isError ? "red" : "blue");
				}
			}
			$text.data({
				codeValid: !isError,
				codeName: isError ? "" : desc
			}).focusout();
			$text.change();
		}
		function showQueryResult($text, categoryType, codeList) {
			if (codeList.length == 0) {
				$("#niiCodeQueryResultDiv").html("<label class='error'>無此代碼!</label>");
				return;
			}
			var html = [];
			html.push("<table class='colTb' style='width: 95%;'>");
			html.push("<tr><th>代碼</th><th>代碼名稱</th><th>功能列</th></tr>");
			if(categoryType == '2'){
				for (var i = 0; i < codeList.length; i++) {
					html.push("<tr><td>" + codeList[i].code + "</td><td>" + ((codeList[i].comment == null)?'':codeList[i].comment) + "</td><td><input type='button' class='btnbg' value='選擇' data-code='" + codeList[i].code + "' data-code-name='" + ((codeList[i].comment == null)?'':codeList[i].comment) + "'/></td></tr>");
				}
			}else if(categoryType == '3'){
				for (var i = 0; i < codeList.length; i++) {
					html.push("<tr><td>" + codeList[i].code + "</td><td>" + codeList[i].codeName + ((codeList[i].comment == null)?'':codeList[i].comment) + "</td><td><input type='button' class='btnbg' value='選擇' data-code='" + codeList[i].code + "' data-code-name='" + codeList[i].codeName + ((codeList[i].comment == null)?'':codeList[i].comment) + "'/></td></tr>");
				}
			}else{
				for (var i = 0; i < codeList.length; i++) {
					html.push("<tr><td>" + codeList[i].code + "</td><td>" + codeList[i].codeName + "</td><td><input type='button' class='btnbg' value='選擇' data-code='" + codeList[i].code + "' data-code-name='" + codeList[i].codeName + "'/></td></tr>");
				}
			}
			html.push("</table>");
			$("#niiCodeQueryResultDiv").html(html.join("")).find(":button").click(function() {
				$text.val($(this).attr("data-code"));
				showCodeDesc($text, $(this).attr("data-code-name"), false);
				unblock(options);
			});

		}

		function unblock(options) {
			options.blockContainer ? $(options.blockContainer).unblock() : $.unblockUI();
		}

		function convertStringData(data, convertType) {
			switch (convertType) {
			case "string":
				data = data == null ? "" : $.trim(data);
				break;
			case "boolean":
				data = data == null ? false : ("true" == $.trim(data).toLowerCase() ? true : false);
				break;
			};
			return data;
		}
	};

	$.fn.niiNation = function() {
		var options = $.extend({
			initQuery: true,
			inputDisplay: false
	    }, arguments[0] || {});


		var doQueryCodeList = function($text, callbackFunc, callbackArgs) {
			$.post(basicPath + '/country-code/list', {
				"keyword" : $("#niiCountryCodeQueryText").val()
			}, function(result, status, xhr) {
				if (status != "success") {
					niiMessage("發生錯鋘，請洽系統管理員!");
				} else {
					callbackArgs.push(result.countryCodes);
					callbackFunc.apply(callbackFunc, callbackArgs);
				}
			}, "json");
		};

		var doDefaultIfEmpty = function($text) {
			doQueryCodeList($text, function(countryCodeList) {
				if (countryCodeList.length == 1) {
					$text.val(countryCodeList[0].code).blur();
				}
			}, []);
		};

		if (arguments.length < 2) {
			return this.each(function() {
				$(this).blur(function() {
					var $text = $(this).data({
						codeValid: false,
						codeName: ""
					});
					if ($.trim($text.val()) == "") {
						showCodeDesc($text, "", false);
						return;
					}
					var upperCase = "";
					upperCase = $text.val().toUpperCase();
					$text.val(upperCase);
					$.getJSON(basicPath + '/country-code/code', {
						"code": $text.val()
					},
					function(result, status, xhr) {
						if (status != "success") {
							showCodeDesc($text, "發生錯鋘，請洽系統管理員!", true);
						} else if (result.chineseName == null) {
							showCodeDesc($text, "無此國籍!", true);
						} else {
							showCodeDesc($text, result.chineseName, false);
						}
					});
				});

				var $text = $(this).data({
					codeValid: false,
					codeName: ""
				});

				$(this).next(":button").click(function() {
					var vWindowWidth = $(window).width();
					var vWindowHeight = $(window).height();
					var vWidth = (vWindowWidth < 640 ? vWindowWidth : 640);
					var vHeight = (vWindowHeight < 520 ? vWindowHeight : 520);
					var blockUIOptions = {
						message: "<div><h3 class='aCenter'>" + $(this).parent().prev("th").text() + "國籍查詢" +
							"<input type='text' id='niiCountryCodeQueryText'/><input type='button' class='btnbg' id='niiCountryCodeQueryButton' value='查詢'/><input type='button' class='btnbg' id='niiCountryCodeCloseButton' value='關閉'/></h3>" +
							"<div class='aCenter form' style='width: 640px; height: 440px; overflow: auto;' id='niiCountryCodeQueryResultDiv'><div></div>",
						css: {
							top: (vWindowHeight - vHeight) / 2 + "px",
							left: (vWindowWidth - vWidth) / 2 + "px",
							width: vWidth + "px",
							height: vHeight + "px",
							cursor: null
						}
					};

					options.blockContainer ? $(options.blockContainer).block(blockUIOptions) : $.blockUI(blockUIOptions);

					$("#niiCountryCodeQueryButton").click(function() {
						$("#niiCountryCodeQueryResultDiv").html("<img src='" + basicPath + "/images/loading.gif'/>");
						doQueryCodeList($text, showQueryResult, [$text]);
					});

					$("#niiCountryCodeCloseButton").click(function() {
						unblock(options);
					});

					$("#niiCountryCodeQueryText").keypress(function(e) {
						var code = (e.keyCode ? e.keyCode : e.which);
						if (code == 13) {
							$("#niiCountryCodeQueryButton").click();
						}
					});

					if (options.initQuery) {
						$("#niiCountryCodeQueryButton").click();
					}
				});

				if ($.trim($(this).val()) != "") {
					$(this).blur();
				} else {
					/* 當欄位為空白時，是否帶入預設代碼。當查回的代碼清單只有一個代碼時才會作用。 */
					if ($text.data("defaultIfEmpty")) {
						doDefaultIfEmpty($text);
					}
				}
			});
		}

		function showCodeDesc($text, desc, isError) {
			var tagName = options.inputDisplay ? "input" : "span";
			var className = options.inputDisplay ? "niiCodeInput" : "niiCodeSpan";
			var idSuffix = options.inputDisplay ? "CodeDescInput" : "CodeDescSpan";
			var $showElement = $text.nextAll(tagName + "." + className);
			if ($showElement.length == 0) {
				var id = ($text.attr("id") || $text.attr("name") || $.now()) + idSuffix;
				if (options.inputDisplay) {
					$text.nextAll().last().after("<input type='text' id='" + id + "' class='" + className + "' style='color: " + (isError ? "red" : "blue") + ";' value='" + desc + "'>");
				} else {
					$text.nextAll().last().after("<span id='" + id + "' class='" + className + "' style='color: " + (isError ? "red" : "blue") + ";'>" + desc + "</span>");
				}
			} else {
				if (options.inputDisplay) {
					$showElement.val(desc).css("color", isError ? "red" : "blue");
				} else {
					$showElement.text(desc).css("color", isError ? "red" : "blue");
				}
			}
			$text.data({
				codeValid: !isError,
				codeName: isError ? "" : desc
			}).focusout();
			$text.change();
		}

		function showQueryResult($text, countryCodes) {
			if (countryCodes.length == 0) {
				$("#niiCountryCodeQueryResultDiv").html("<label class='error'>無此國籍!</label>");
				return;
			}
			var html = [];
			html.push("<table class='colTb' style='width: 95%;'>");
			html.push("<tr><th>國籍</th><th>國籍名稱</th><th>功能列</th></tr>");
			for (var i = 0; i < countryCodes.length; i++) {
				html.push("<tr><td>" + countryCodes[i].code3 + "</td><td>" + countryCodes[i].chineseName + "</td><td><input type='button' class='btnbg' value='選擇' data-code='" + countryCodes[i].code3 + "' data-code-name='" + countryCodes[i].chineseName + "'/></td></tr>");
			}
			html.push("</table>");
			$("#niiCountryCodeQueryResultDiv").html(html.join("")).find(":button").click(function() {
				$text.val($(this).attr("data-code"));
				showCodeDesc($text, $(this).attr("data-code-name"), false);
				unblock(options);
			});
		}

		function unblock(options) {
			options.blockContainer ? $(options.blockContainer).unblock() : $.unblockUI();
		}
	};
})(jQuery);

/*
 * 驗證碼重新整理圖片
 *

function refreshCaptcha(selector) {
	jQuery(selector).attr("src", basicPath + '/jcaptcha.do?captchaId=' + Math.random());
} */

/*
 * 日期插件統一呼叫方法
 * @param selector jquery selector(單個或多個)
 */
function bindDatePlugin(selector, options) {
	var defaults = {
		button: '.next()',
		ifFormat : "%Y%m%d"
	};
	var opts = jQuery.extend({}, defaults, options);
	// 使用小日曆plugin
	jQuery("<span class=\"btnCalendar\"><img src=\"../images/icon_Calendar.png\" /></span>").insertAfter(jQuery(selector));
	jQuery(selector).dynDateTime(opts);
}

/*
 * permit, receiveNo, firstReceiveNo 11碼補成12碼
 *
 */
(function($) {
	$(function() {
		for ( var frm in $("form")) {
			$(frm).bind("submit", function() {
				$('.receiveNoFill2').each(function() {
					var val = $.trim($(this).val());
					if (/^\d{11}$/.test(val)) {
						$(this).val(val + "0");
					}
				});
			});
		}
		$('.receiveNoFill2').each(function() {
			$(this).blur(function() {
				var val = $.trim($(this).val());
				if (/^\d{11}$/.test(val)) {
					$(this).val(val + "0");
				}
			});
		});
		$(':text[data-category]').each(
				function() {
					$("<input type=\"button\" value=\"查代碼\" class=\"btnbg\">").insertAfter($(this));
					$(this).niiCode();
				}
		);
	});
})(jQuery)


/*
 * 使用tabs時, 分頁控制
 * @param selector jquery selector(單個或多個)
 */
function changeLinks(containerId) {
    done = true;
    var linkData, queryArr, action, qryStr;

    selector = "div#" + containerId + ">div>span.pagelinks>a";
    changeUsingSelector(selector, containerId);
    selector = "div#" + containerId + '>table>thead>tr>th>a';
    changeUsingSelector(selector, containerId);
}

function changeUsingSelector(selector, containerId) {
	jQuery(selector).each(function() {
        linkData = jQuery(this).attr("href");
        queryArr = linkData.split("?");
        action = queryArr[0];
        qryStr = queryArr[1];
        newStr = "javascript:doAjax('" +
        			action + "','" +
        			qryStr + "','" +
        			containerId  + "');";
        jQuery(this).attr("href", newStr);
        jQuery(this).attr("onMouseOver","window.status='Pagination Links have been Ajaxified!!';return false;");
        jQuery(this).attr("onMouseOut","window.status='';return false;");
    });
}

function doAjax(url, data, eleId) {
	jQuery.ajax({
		url : url,
		data : data,
		async : false,
		success : function(resp) {
			var d = jQuery(resp);
			htmlStr = "";
			var elemId = "#" + eleId;

			d.find(elemId + ">span.pagelinks").appendTo(d.find(elemId + ">div#displayFooter"));
			d.find(elemId + ">span.pagebanner").appendTo(d.find(elemId + ">div#displayFooter"));

			htmlStr = d.find(elemId).html();
			jQuery(elemId).html(htmlStr);

			changeLinks(eleId);

			jQuery("img[attrSrc]").each(function() {
				var $img = jQuery(this);
				$img.attr("src", basicPath + $img.attr("attrSrc"));
			});
		}
	});
}

(function($) {

	var browsermsie = /msie/.test(navigator.userAgent.toLowerCase());

	/** 取得瀏覽器視窗高度 */
	function getBrowserHeight() {
	    if (browsermsie) {
	        return document.compatMode == "CSS1Compat" ? document.documentElement.clientHeight :
	                 document.body.clientHeight;
	    } else {
	        return self.innerHeight;
	    }
	}

	/** 取得瀏覽器視窗寬度 */
	function getBrowserWidth() {
	    if (browsermsie) {
	        return document.compatMode == "CSS1Compat" ? document.documentElement.clientWidth :
	                 document.body.clientWidth;
	    } else {
	        return self.innerWidth;
	    }
	}

	/** 鎖住頁面:圖層處理中.. */
	handler = {

		show : function(msg) {
			var w = getBrowserWidth();

			alert(w);
			var body = document.body;
			var html = document.documentElement;
			var h = Math.max(body.scrollHeight, body.offsetHeight, html.clientHeight, html.scrollHeight,
				html.offsetHeight);

			if (!window.location.origin) {
				window.location.origin = window.location.protocol + "//" + window.location.hostname
					+ (window.location.port ? ':' + window.location.port : '');
			}
			var webPath = window.location.origin + "/" + window.location.pathname.split('/')[1];

			var msgStr = ((msg === undefined || '' === msg) ? '處理中..' : msg);
			var panel = '<div style="width: ' + w + 'px; height: ' + h + 'px; position: absolute; top: 0px; left: 0px; visibility: visible; display: block; background-color: #000; opacity: 0.3; filter: alpha(opacity = 30);">';
			panel += '</div>';
			panel += '<div style="visibility: visible; overflow: visible; position: fixed; top: 50%; left: 50%; width: 250px;	margin-left: -125px; height: 100px;	margin-top: -50px; background: white; padding: 3px; border: 2px solid #007777; color: black; font-size: 22px; background-color: #DDFFDD; text-align: center;">';
			panel += '<table style="width: 100%; height: 100%;">';
			panel += '<tr><td style="vertical-align: middle; text-align: center; color: black;">';
			panel += msgStr;
			panel += '</td></tr>';
			panel += '<tr><td style="vertical-align: middle; text-align: center; color: black;">';
			panel += '<img src="' + webPath + '/images/handling.gif" />';
			panel += '</td></tr>';
			panel += '</table>';
			panel += '</div>';

			jQuery(document.body).append(panel);
			$.scrollLock(true);
		},

		hide : function() {
			jQuery(".handling-center").remove();
			$.scrollLock(false);
		}
	};

	$.scrollLock = (function scrollLockSimple() {
		var locked = false;
		var previous;

		function lock() {

			previous = $('body').css('overflow');

			$('body').css('overflow', 'hidden');

			locked = true;
		}

		function unlock() {
			$('body').css('overflow', previous);
			locked = false;
		}

		return function scrollLock(on) {
			// If an argument is passed, lock or unlock depending on truthiness
			if (arguments.length) {
				if (on) {
					lock();
				}
				else {
					unlock();
				}
			}
			// Otherwise, toggle
			else {
				if (locked) {
					unlock();
				}
				else {
					lock();
				}
			}
		};
	}());

})(jQuery);


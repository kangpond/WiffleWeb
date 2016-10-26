
(function($) {
	$.fn.gov = function() {
		var options = $.extend({
			initQuery : true,
			inputDisplay : false
		}, arguments[0] || {});

		var doQueryCodeList = function($text, callbackFunc, callbackArgs) {
			$.post(basicPath + '/govDialog/lists', {
				"keyword" : $("#niiUserQueryText").val(),
				"deptId" :  $("#deptId").val()
			}, function(result, status, xhr) {
				if (status != "success") {
					niiMessage("發生錯鋘，請洽系統管理員!");
				} else {
					callbackArgs.push(result.dialogs);
					callbackFunc.apply(callbackFunc, callbackArgs);
				}
			}, "json");
		};

		var doDefaultIfEmpty = function($text) {
			doQueryCodeList($text, function(dialogs) {
				if (dialogs.length == 1) {
					$text.val(dialogs[0].deptId).blur();
				}
			}, []);
		};

		if (arguments.length < 2) {
			return this.each(function() {
						$(this).blur(
								function() {
									var $text = $(this).data({
										codeValid : false,
										codeName : ""
									});
									if ($.trim($text.val()) == "") {
										showCodeDesc($text, "", false);
										return;
									}
									var upperCase = "";
									upperCase = $text.val().toUpperCase();
									$text.val(upperCase);
									$.getJSON(basicPath
											+ '/govDialog/descs', {
										"deptId" : $text.val()
									}, function(result, status, xhr) {
										if (status != "success") {
											showCodeDesc($text,"發生錯鋘，請洽系統管理員!", true);
										} else if (result.deptName == null) {
											showCodeDesc($text, "無此機關!", true);
										} else {
											showCodeDesc($text,result.deptName, false);
										}
									});
								});

						var $text = $(this).data({
							codeValid : false,
							codeName : ""
						});

						$(this).next(":button").click(
										function() {
											var vWindowWidth = $(window)
													.width();
											var vWindowHeight = $(window)
													.height();
											var vWidth = (vWindowWidth < 640 ? vWindowWidth
													: 640);
											var vHeight = (vWindowHeight < 520 ? vWindowHeight
													: 600);
											var blockUIOptions = {
												message : "<div><h3 class='aCenter'>"
														+ $(this).parent().prev("th").text()
														+ "查詢"
														+ "<input type='text' id='niiUserQueryText'/><span class='styleTb'><button type='button' class='dialog' id='niiUserQueryButton'>查詢</button>" 
														+ "<button type='button' class='dialog' id='niiUserCloseButton'>關閉</button></span></h3>"
														//+ "<div class='aCenter form' style='width: 90%; height: 440px; overflow: auto;' id='niiUserQueryResultDiv'><div>" 
														+"<section class='styleTb2'style='text-align: center; width: 90%; height: 440px; overflow: auto;' id='niiUserQueryResultDiv'></section>"
														+"</div>",
												css : {
													top : (vWindowHeight - vHeight)
															/ 2 + "px",
													left : (vWindowWidth - vWidth)
															/ 2 + "px",
													width : vWidth + "px",
													height : vHeight + "px",
													cursor : null
												}
											};

											options.blockContainer ? 
													$(options.blockContainer)
													.block(blockUIOptions) : $
													.blockUI(blockUIOptions);

											$("#niiUserQueryButton").click(
															function() {
																$("#niiUserQueryResultDiv")
																		.html("<img src='"+ basicPath+ "/images/loading.gif'/>");
																doQueryCodeList(
																		$text,
																		showQueryResult,
																		[ $text ]);
															});

											$("#niiUserCloseButton").click(function() {
														unblock(options);
													});
											if (options.initQuery) {
												$("#niiUserQueryButton").click();
											}
											$("#niiUserQueryText").keypress(
															function(e) {
																var code = (e.keyCode ? e.keyCode: e.which);
																if (code == 13) {
																	$("#niiUserQueryButton").click();
																}
															});
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

			$("<button  type='button' class='dialog'>查所屬機關</button>").insertAfter(
					$(this));
		}

		function showCodeDesc($text, desc, isError) {
			var tagName = options.inputDisplay ? "input" : "span";
			var className = options.inputDisplay ? "niiCodeInput"
					: "niiCodeSpan";
			var idSuffix = options.inputDisplay ? "CodeDescInput"
					: "CodeDescSpan";
			var $showElement = $text.nextAll(tagName + "." + className);
			if ($showElement.length == 0) {
				var id = ($text.attr("id") || $text.attr("name") || $.now())
						+ idSuffix;
				if (options.inputDisplay) {
					$text.nextAll().last().after(
							"<input type='text' id='" + id + "' class='"
									+ className + "' style='color: "
									+ (isError ? "red" : "blue") + ";' value='"
									+ desc + "'>");
				} else {
					$text.nextAll().last().after(
							"<span id='" + id + "' class='" + className
									+ "' style='color: "
									+ (isError ? "red" : "blue") + ";'>" + desc
									+ "</span>");
				}
			} else {
				if (options.inputDisplay) {
					$showElement.val(desc).css("color",
							isError ? "red" : "blue");
				} else {
					$showElement.text(desc).css("color",
							isError ? "red" : "blue");
				}
			}
			$text.data({
				codeValid : !isError,
				codeName : isError ? "" : desc
			}).focusout();
			$text.change();
		}

		function showQueryResult($text, users) {
			if (users.length == 0) {
				$("#niiUserQueryResultDiv").html(
						"<label class='error'>無此使用者姓名!</label>");
				return;
			}
			var html = [];
			html.push("<table class='colTb' style='width: 95%;'>");
			html.push("<tr><th>機關編號</th><th>機關名稱</th><th>功能列</th></tr>");
			for (var i = 0; i < users.length; i++) {
				html.push("<tr><td>"
								+ users[i].deptId
								+ "</td><td>"
								+ users[i].deptName
								+ "</td><td><button type='button' class='dialog' data-code='"
								+ users[i].deptId
								+ "' data-code-name='"
								+ users[i].deptName + "'>選擇</button></td></tr>");
			}
			html.push("</table>");
			$("#niiUserQueryResultDiv").html(html.join("")).find(
					":button").click(function() {
				$text.val($(this).attr("data-code"));
				showCodeDesc($text, $(this).attr("data-code-name"), false);
				unblock(options);
			});
		}

		function unblock(options) {
			options.blockContainer ? $(options.blockContainer).unblock() : $
					.unblockUI();
		}
	};
	$.fn.appendGov = function() {
		$("<button  type='button' class='dialog'>查代碼</button>").insertAfter(
				$(this));
		$(this).gov();
	};
	
	
})(jQuery);
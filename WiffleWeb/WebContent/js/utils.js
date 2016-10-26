(function($) {

	//bind component
	bindCitySBox = function(cityBoxId, townBoxId) {

		try {
			var contextPath = window.location.pathname.substring(0, window.location.pathname.indexOf("/", 2));
			$("#" + cityBoxId).append($("<option></option>").attr("value", "-1").text("請選擇"));
			$.getJSON(contextPath + "/multiquery/code_ajax", {
				codeId : "612"
			}, function(response) {
				if (response.codeList != null) {
					$.each(response.codeList, function(i, item) {
						$("#" + cityBoxId).append($("<option></option>").attr("value", item.codeDataValue).text(item.codeDataValueDesc));
					});
				}
			});

			$("#" + cityBoxId).change(function() {
				$("#" + townBoxId).empty();
				$("#" + townBoxId).append($("<option></option>").attr("value", "-1").text("請選擇"));

				$.getJSON(contextPath + "/multiquery/cityTown_ajax", {
					cityCodeValue : function() {
						return $("#" + cityBoxId).val();
					}
				}, function(response) {
					if (response.codeList != null) {
						$.each(response.codeList, function(i, item) {
							$("#" + townBoxId).append($("<option></option>").attr("value", item.codeDataValue).text(item.codeDataValueDesc));
						});
					}
				});
			});
		}
		catch (e) {
			console.log(e);
		}
	}

	//取得瀏覽器視窗高度
	getBrowserHeight = function () {
	    if ($.browser && $.browser.msie) {
	        return document.compatMode == "CSS1Compat" ? document.documentElement.clientHeight :
	                 document.body.clientHeight;
	    } else {
	        return self.innerHeight;
	    }
	}

	//取得瀏覽器視窗寬度
	getBrowserWidth = function () {
	    if ($.browser && $.browser.msie) {
	        return document.compatMode == "CSS1Compat" ? document.documentElement.clientWidth :
	                 document.body.clientWidth;
	    } else {
	        return self.innerWidth;
	    }
	}

	handler = {

		show : function(msg) {
			var w = getBrowserWidth();
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
			var panel = '<div class="handling-center" style="width: ' + w + 'px; height: ' + h + 'px;">';
			panel += '</div>';
			panel += '<div class="handling-panel">';
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

	/**
	 * 判斷是否為空值
	 */
	isEmpty = function (obj) {
		return (!obj || ( typeof obj === 'string' && jQuery.trim(obj) === ""));
	}

})(jQuery);

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags"%>

<script type="text/javascript">
(function($) {
	$(document).ready(function() {

		if ('' != '${message}') {
			alert('${message}');
		}

		$("#bt_query").click(function() {
			doQuery();
		});

		$(document).keypress(function(e) {
			if (e.which == 13) {
				doQuery();
			}
		});

		$("#bt_clear").click(function() {
		});

		$(".toggleDiv").each(function(i, item){
			var titleElm = $(item).find("div").first();
			var imgH = $(titleElm).height();
			$(titleElm).prepend('<img class="plus" src="${pageContext.request.contextPath}/images/plus.png" style="width:auto; height:' + (imgH) + 'px; display: inline-block; vertical-align: middle; float: left;" />');
			$(titleElm).prepend('<img class="minus" src="${pageContext.request.contextPath}/images/minus.png" style="width:auto; height:' + (imgH) + 'px; display: inline-block; vertical-align: middle; float: left;" />');
			$(titleElm).find(".plus").css("display", "none");
			var contentElm = $(item).children("div").eq(1);
			$(titleElm).click(function() {
				$(contentElm).toggle();
				var isNextItemVisible = $(contentElm).is(":visible");
				if (isNextItemVisible) {
					$(titleElm).find(".plus").css( "display", "none" );
					$(titleElm).find(".minus").css( "display", "inline-block" );
				} else {
					$(titleElm).find(".plus").css( "display", "inline-block" );
					$(titleElm).find(".minus").css( "display", "none" );
				}
			});
		});

		/* $.getJSON('ajaxNations', {}, function(response) {
			if (response.nationList != null) {
				$("#nations").autocomplete({
					search : function(event, ui) {
						$("#nationSource").empty();
					},
					source : response.nationList,
					focus : function(event, ui) {
						event.preventDefault();
						$("#nations").val(ui.item.label);
					}
				}).data("ui-autocomplete")._renderItem = function(ul, item) {
					return $("#nationSource").append($("<option/>").attr(item.value, item.value).text(item.value));
				};
			}
		}); */
	});

	function doQuery() {
		jQuery("#form").attr("action", "list").submit();
	}

})(jQuery);
</script>

<c:set var="th_width" value="180px" />
<s:form id="form" class="form" namespace="multiquery" method="post">
<h2><span>多維度查詢-查詢頁</span></h2>
<section class="styleTb" style="margin: 2px auto;">
	<div class="toggleDiv">
		<div class="d_th mid">時間區間</div>
		<div>
		<table>
			<tr>
				<th style="width: ${th_width};"><label>查詢年月起</label></th>
				<td>
				<jsp:include page="/pages/component/LinkSelectBox.jsp">
					<jsp:param name="linkSBoxId" value="startYear" />
					<jsp:param name="linkSBoxNum" value="1" />
				</jsp:include>
				<script type="text/javascript">
					jQuery.getJSON("code_ajax", {codeId : "Z000"}, function(response) {
						if (response.codeList != null) {
							try { startYear_linkSBox(response.codeList); } catch(e) {};
						}
					});
				</script>
				年
				<jsp:include page="/pages/component/LinkSelectBox.jsp">
					<jsp:param name="linkSBoxId" value="startMonth" />
					<jsp:param name="linkSBoxNum" value="1" />
				</jsp:include>
				<script type="text/javascript">
					jQuery.getJSON("code_ajax", {codeId : "Z001"}, function(response) {
						if (response.codeList != null) {
							try { startMonth_linkSBox(response.codeList); } catch(e) {};
						}
					});
				</script>
				月
				</td>
			</tr>
			<tr>
				<th style="width: ${th_width};"><label>查詢年月迄</label></th>
				<td>
					<jsp:include page="/pages/component/LinkSelectBox.jsp">
						<jsp:param name="linkSBoxId" value="endYear" />
						<jsp:param name="linkSBoxNum" value="1" />
					</jsp:include>
					<script type="text/javascript">
						jQuery.getJSON("code_ajax", {codeId : "Z000"}, function(response) {
							if (response.codeList != null) {
								try { endYear_linkSBox(response.codeList); } catch(e) {};
							}
						});
					</script>
					年
					<jsp:include page="/pages/component/LinkSelectBox.jsp">
						<jsp:param name="linkSBoxId" value="endMonth" />
						<jsp:param name="linkSBoxNum" value="1" />
					</jsp:include>
					<script type="text/javascript">
						jQuery.getJSON("code_ajax", {codeId : "Z001"}, function(response) {
							if (response.codeList != null) {
								try { endMonth_linkSBox(response.codeList); } catch(e) {};
							}
						});
					</script>
					月
				</td>
			</tr>
		</table>
		</div>
	</div>
	<div class="toggleDiv">
		<div class="d_th mid">外配背景資料</div>
		<div>
		<table>
			<tr>
				<th style="width: ${th_width};"><label>配偶類別</label></th>
				<td>
					<jsp:include page="/pages/component/CheckListBox.jsp">
						<jsp:param name="cBoxId" value="fsType" />
					</jsp:include>
					<script type="text/javascript">
						jQuery.getJSON("code_ajax", {codeId : "Z002"}, function(response) {
							if (response.codeList != null) {
								try { fsType_clb(response.codeList); } catch(e) {};
							}
						});
					</script>
					<%-- <s:checkboxlist list="fsTypeList" name="fsTypeResult" cssClass="checkboxBtn" />
					<jsp:include page="checkedAllCheckbox.jsp">
						<jsp:param name="cacBoxItemName" value="fsTypeResult" />
					</jsp:include> --%>
				</td>
			</tr>
			<tr>
				<th style="width: ${th_width};"><label>國籍</label></th>
				<td>
					<jsp:include page="/pages/component/SuggestAddListBox.jsp">
						<jsp:param name="sBoxId" value="nation" />
						<jsp:param name="containDesc" value="true" />
					</jsp:include>
					<script type="text/javascript">
						jQuery.getJSON("code_sg_ajax", {codeId : "15"}, function(response) {
							if (response.codeSgList != null) {
								try { nation_sg(response.codeSgList); } catch(e) {};
							}
						});
					</script>
				</td>
			</tr>
			<tr>
				<th style="width: ${th_width};"><label>婚姻狀態</label></th>
				<td>
					<jsp:include page="/pages/component/RadioList.jsp">
						<jsp:param name="radioBoxId" value="marry" />
					</jsp:include>
					<script type="text/javascript">
						jQuery.getJSON("code_ajax", {codeId : "10"}, function(response) {
							if (response.codeList != null) {
								try { marry_rb(response.codeList); } catch(e) {};
							}
						});
					</script>
					<%-- <s:radio label="婚姻狀態" list="marryList" name="marryResult" cssClass="radioBtn" />
					<jsp:include page="uncheckRadioBtn.jsp">
						<jsp:param name="ucrBtnId" value="marryResult" />
					</jsp:include> --%>
				</td>
			</tr>
			<tr>
				<th style="width: ${th_width};"><label>性別</label></th>
				<td>
					<jsp:include page="/pages/component/RadioList.jsp">
						<jsp:param name="radioBoxId" value="gender" />
					</jsp:include>
					<script type="text/javascript">
						jQuery.getJSON("code_ajax", {codeId : "70"}, function(response) {
							if (response.codeList != null) {
								try { gender_rb(response.codeList); } catch(e) {};
							}
						});
					</script>
				</td>
			</tr>
			<tr>
				<th style="width: ${th_width};"><label>教育程度</label></th>
				<td>
					<jsp:include page="/pages/component/CheckListBox.jsp">
						<jsp:param name="cBoxId" value="edu" />
					</jsp:include>
					<script type="text/javascript">
						jQuery.getJSON("code_ajax", {codeId : "14"}, function(response) {
							if (response.codeList != null) {
								try { edu_clb(response.codeList); } catch(e) {};
							}
						});
					</script>
				</td>
			</tr>
			<tr>
				<th style="width: ${th_width};"><label>職業別</label></th>
				<td>
					<jsp:include page="/pages/component/CheckListBox.jsp">
						<jsp:param name="cBoxId" value="occupation" />
					</jsp:include>
					<script type="text/javascript">
						jQuery.getJSON("code_ajax", {codeId : "4"}, function(response) {
							if (response.codeList != null) {
								try { occupation_clb(response.codeList); } catch(e) {};
							}
						});
					</script>
				</td>
			</tr>
			<tr>
				<th style="width: ${th_width};"><label>年齡分佈</label></th>
				<td>
					<jsp:include page="/pages/component/CheckListBox.jsp">
						<jsp:param name="cBoxId" value="age" />
					</jsp:include>
					<script type="text/javascript">
						jQuery.getJSON("code_ajax", {codeId : "Z003"}, function(response) {
							if (response.codeList != null) {
								try { age_clb(response.codeList); } catch(e) {};
							}
						});
					</script>
				</td>
			</tr>
			<tr>
				<th style="width: ${th_width};"><label>證別</label></th>
				<td>
					<jsp:include page="/pages/component/SuggestAddListBox.jsp">
						<jsp:param name="sBoxId" value="permitNoCode" />
					</jsp:include>
					<script type="text/javascript">
						jQuery.getJSON("code_sg_ajax", {codeId : "18"}, function(response) {
							if (response.codeSgList != null) {
								try { permitNoCode_sg(response.codeSgList); } catch(e) {};
							}
						});
					</script>
				</td>
			</tr>
			<tr>
				<th style="width: ${th_width};"><label>事由</label></th>
				<td>
					<jsp:include page="/pages/component/SuggestAddListBox.jsp">
						<jsp:param name="sBoxId" value="reason" />
					</jsp:include>
					<script type="text/javascript">
						jQuery.getJSON("code_sg_ajax", {codeId : "1"}, function(response) {
							if (response.codeSgList != null) {
								try { reason_sg(response.codeSgList); } catch(e) {};
							}
						});
					</script>
				</td>
			</tr>
			<tr>
				<th style="width: ${th_width};"><label>證件狀態</label></th>
				<td>
					<jsp:include page="/pages/component/RadioList.jsp">
						<jsp:param name="radioBoxId" value="lossMark" />
					</jsp:include>
					<script type="text/javascript">
						jQuery.getJSON("code_ajax", {codeId : "54"}, function(response) {
							if (response.codeList != null) {
								try { lossMark_rb(response.codeList); } catch(e) {};
							}
						});
					</script>
				</td>
			</tr>
			<tr>
				<th style="width: ${th_width};"><label>子女數</label></th>
				<td>
					<jsp:include page="/pages/component/CheckListBox.jsp">
						<jsp:param name="cBoxId" value="childNum" />
					</jsp:include>
					<script type="text/javascript">
						jQuery.getJSON("code_ajax", {codeId : "Z004"}, function(response) {
							if (response.codeList != null) {
								try { childNum_clb(response.codeList); } catch(e) {};
							}
						});
					</script>
				</td>
			</tr>
			<tr>
				<th style="width: ${th_width};"><label>是否有行方不明</label></th>
				<td>
					<jsp:include page="/pages/component/RadioList.jsp">
						<jsp:param name="radioBoxId" value="referenceMark" />
					</jsp:include>
					<script type="text/javascript">
						jQuery.getJSON("code_ajax", {codeId : "Z005"}, function(response) {
							if (response.codeList != null) {
								try { referenceMark_rb(response.codeList); } catch(e) {};
							}
						});
					</script>
				</td>
			</tr>
			<tr>
				<th style="width: ${th_width};"><label>是否在台</label></th>
				<td>
					<jsp:include page="/pages/component/RadioList.jsp">
						<jsp:param name="radioBoxId" value="entryDate" />
					</jsp:include>
					<script type="text/javascript">
						jQuery.getJSON("code_ajax", {codeId : "Z006"}, function(response) {
							if (response.codeList != null) {
								try { entryDate_rb(response.codeList); } catch(e) {};
							}
						});
					</script>
				</td>
			</tr>
			<tr>
				<th style="width: ${th_width};"><label>是否死亡</label></th>
				<td>
					<jsp:include page="/pages/component/RadioList.jsp">
						<jsp:param name="radioBoxId" value="deadMark" />
					</jsp:include>
					<script type="text/javascript">
						jQuery.getJSON("code_ajax", {codeId : "74"}, function(response) {
							if (response.codeList != null) {
								try { deadMark_rb(response.codeList); } catch(e) {};
							}
						});
					</script>
				</td>
			</tr>
		</table>
		</div>
	</div>

	<div class="toggleDiv">
		<div class="d_th mid">外配生活狀態</div>
		<div>
		<table>
			<tr>
				<th style="width: ${th_width};"><label>是否遭遇家暴</label></th>
				<td>
					<jsp:include page="/pages/component/RadioList.jsp">
						<jsp:param name="radioBoxId" value="rapeMark" />
					</jsp:include>
					<script type="text/javascript">
						jQuery.getJSON("code_ajax", {codeId : "Z007"}, function(response) {
							if (response.codeList != null) {
								try { rapeMark_rb(response.codeList); } catch(e) {};
							}
						});
					</script>
				</td>
			</tr>
			<tr>
				<th style="width: ${th_width};"><label>是否遭遇性侵</label></th>
				<td>
					<jsp:include page="/pages/component/RadioList.jsp">
						<jsp:param name="radioBoxId" value="domViolenceMark" />
					</jsp:include>
					<script type="text/javascript">
						jQuery.getJSON("code_ajax", {codeId : "Z020"}, function(response) {
							if (response.codeList != null) {
								try { domViolenceMark_rb(response.codeList); } catch(e) {};
							}
						});
					</script>
				</td>
			</tr>
			<tr>
				<th style="width: ${th_width};"><label>是否取得駕照</label></th>
				<td>
					<jsp:include page="/pages/component/RadioList.jsp">
						<jsp:param name="radioBoxId" value="driverLicenseMark" />
					</jsp:include>
					<script type="text/javascript">
						jQuery.getJSON("code_ajax", {codeId : "Z008"}, function(response) {
							if (response.codeList != null) {
								try { driverLicenseMark_rb(response.codeList); } catch(e) {};
							}
						});
					</script>
				</td>
			</tr>
			<tr>
				<th style="width: ${th_width};"><label>是否投保勞保</label></th>
				<td>
					<jsp:include page="/pages/component/RadioList.jsp">
						<jsp:param name="radioBoxId" value="insureMark" />
					</jsp:include>
					<script type="text/javascript">
						jQuery.getJSON("code_ajax", {codeId : "Z009"}, function(response) {
							if (response.codeList != null) {
								try { insureMark_rb(response.codeList); } catch(e) {};
							}
						});
					</script>
				</td>
			</tr>
			<tr>
				<th style="width: ${th_width};"><label>是否投保健保</label></th>
				<td>
					<jsp:include page="/pages/component/RadioList.jsp">
						<jsp:param name="radioBoxId" value="healthCareMark" />
					</jsp:include>
					<script type="text/javascript">
						jQuery.getJSON("code_ajax", {codeId : "Z010"}, function(response) {
							if (response.codeList != null) {
								try { healthCareMark_rb(response.codeList); } catch(e) {};
							}
						});
					</script>
				</td>
			</tr>
			<tr>
				<th style="width: ${th_width};"><label>與台配年齡差距狀況</label></th>
				<td>
					<jsp:include page="/pages/component/CheckListBox.jsp">
						<jsp:param name="cBoxId" value="ageDiff" />
					</jsp:include>
					<script type="text/javascript">
						jQuery.getJSON("code_ajax", {codeId : "Z011"}, function(response) {
							if (response.codeList != null) {
								try { ageDiff_clb(response.codeList); } catch(e) {};
							}
						});
					</script>
				</td>
			</tr>
		</table>
		</div>
	</div>

	<div class="toggleDiv">
		<div class="d_th mid">台配背景資料</div>
		<div>
		<table>
			<tr>
				<th style="width: ${th_width};"><label>性別</label></th>
				<td>
					<jsp:include page="/pages/component/RadioList.jsp">
						<jsp:param name="radioBoxId" value="twSpouseGender" />
					</jsp:include>
					<script type="text/javascript">
						jQuery.getJSON("code_ajax", {codeId : "70"}, function(response) {
							if (response.codeList != null) {
								try { twSpouseGender_rb(response.codeList); } catch(e) {};
							}
						});
					</script>
				</td>
			</tr>
			<tr>
				<th style="width: ${th_width};"><label>年齡分佈</label></th>
				<td>
					<jsp:include page="/pages/component/CheckListBox.jsp">
						<jsp:param name="cBoxId" value="twSpouseAge" />
					</jsp:include>
					<script type="text/javascript">
						jQuery.getJSON("code_ajax", {codeId : "Z012"}, function(response) {
							if (response.codeList != null) {
								try { twSpouseAge_clb(response.codeList); } catch(e) {};
							}
						});
					</script>
				</td>
			</tr>
			<tr>
				<th style="width: ${th_width};"><label>教育程度</label></th>
				<td>
					<jsp:include page="/pages/component/CheckListBox.jsp">
						<jsp:param name="cBoxId" value="twSpouseEducation" />
					</jsp:include>
					<script type="text/javascript">
						jQuery.getJSON("code_ajax", {codeId : "14"}, function(response) {
							if (response.codeList != null) {
								try { twSpouseEducation_clb(response.codeList); } catch(e) {};
							}
						});
					</script>
				</td>
			</tr>
		</table>
		</div>
	</div>

	<div class="toggleDiv">
		<div class="d_th mid">台配生活狀態</div>
		<div>
		<table>
			<tr>
				<th style="width: ${th_width};"><label>符合原住民</label></th>
				<td>
					<jsp:include page="/pages/component/RadioList.jsp">
						<jsp:param name="radioBoxId" value="twSpouseNativeMark" />
					</jsp:include>
					<script type="text/javascript">
						jQuery.getJSON("code_ajax", {codeId : "Z013"}, function(response) {
							if (response.codeList != null) {
								try { twSpouseNativeMark_rb(response.codeList); } catch(e) {};
							}
						});
					</script>
				</td>
			</tr>
			<tr>
				<th style="width: ${th_width};"><label>符合台女陸男</label></th>
				<td>
					<jsp:include page="/pages/component/RadioList.jsp">
						<jsp:param name="radioBoxId" value="twSpouseType" />
					</jsp:include>
					<script type="text/javascript">
						jQuery.getJSON("code_ajax", {codeId : "Z014"}, function(response) {
							if (response.codeList != null) {
								try { twSpouseType_rb(response.codeList); } catch(e) {};
							}
						});
					</script>
				</td>
			</tr>
			<tr>
				<th style="width: ${th_width};"><label>符合榮民</label></th>
				<td>
					<jsp:include page="/pages/component/RadioList.jsp">
						<jsp:param name="radioBoxId" value="twSpouseVeteranMark" />
					</jsp:include>
					<script type="text/javascript">
						jQuery.getJSON("code_ajax", {codeId : "Z015"}, function(response) {
							if (response.codeList != null) {
								try { twSpouseVeteranMark_rb(response.codeList); } catch(e) {};
							}
						});
					</script>
				</td>
			</tr>
			<tr>
				<th style="width: ${th_width};"><label>符合身心障礙</label></th>
				<td>
					<jsp:include page="/pages/component/RadioList.jsp">
						<jsp:param name="radioBoxId" value="twSpouseDisabledMark" />
					</jsp:include>
					<script type="text/javascript">
						jQuery.getJSON("code_ajax", {codeId : "Z016"}, function(response) {
							if (response.codeList != null) {
								try { twSpouseDisabledMark_rb(response.codeList); } catch(e) {};
							}
						});
					</script>
				</td>
			</tr>
			<tr>
				<th style="width: ${th_width};"><label>符合中低收入</label></th>
				<td>
					<jsp:include page="/pages/component/RadioList.jsp">
						<jsp:param name="radioBoxId" value="twSpouseMidLowIncomeMark" />
					</jsp:include>
					<script type="text/javascript">
						jQuery.getJSON("code_ajax", {codeId : "Z017"}, function(response) {
							if (response.codeList != null) {
								try { twSpouseMidLowIncomeMark_rb(response.codeList); } catch(e) {};
							}
						});
					</script>
				</td>
			</tr>
			<tr>
				<th style="width: ${th_width};"><label>符合低收入</label></th>
				<td>
					<jsp:include page="/pages/component/RadioList.jsp">
						<jsp:param name="radioBoxId" value="twSpouseLowIncomeMark" />
					</jsp:include>
					<script type="text/javascript">
						jQuery.getJSON("code_ajax", {codeId : "Z018"}, function(response) {
							if (response.codeList != null) {
								try { twSpouseLowIncomeMark_rb(response.codeList); } catch(e) {};
							}
						});
					</script>
				</td>
			</tr>
			<tr>
				<th style="width: ${th_width};"><label>符合中低收入老人津貼</label></th>
				<td>
					<jsp:include page="/pages/component/RadioList.jsp">
						<jsp:param name="radioBoxId" value="twSpouseOldAllowanceMark" />
					</jsp:include>
					<script type="text/javascript">
						jQuery.getJSON("code_ajax", {codeId : "Z019"}, function(response) {
							if (response.codeList != null) {
								try { twSpouseOldAllowanceMark_rb(response.codeList); } catch(e) {};
							}
						});
					</script>
				</td>
			</tr>
		</table>
		</div>
	</div>

	<div class="toggleDiv">
		<div class="d_th mid">地區分佈</div>
		<div>
		<table>
			<tr>
				<th style="width: ${th_width};"><label>外配縣市</label></th>
				<td>
					<jsp:include page="/pages/component/SuggestAddListBox.jsp">
						<jsp:param name="sBoxId" value="cityA" />
					</jsp:include>
					<script type="text/javascript">
						jQuery.getJSON("code_sg_ajax", {codeId : "612"}, function(response) {
							if (response.codeSgList != null) {
								try { cityA_sg(response.codeSgList); } catch(e) {};
							}
						});
					</script>
				</td>
			</tr>
			<tr>
				<th style="width: ${th_width};"><label>外配鄉鎮</label></th>
				<td>
					<jsp:include page="/pages/component/SuggestAddListBox.jsp">
						<jsp:param name="sBoxId" value="townshipA" />
					</jsp:include>
					<script type="text/javascript">
						jQuery.getJSON("code_sg_ajax", {codeId : "613-634"}, function(response) {
							if (response.codeSgList != null) {
								try { townshipA_sg(response.codeSgList); } catch(e) {};
							}
						});
					</script>
				</td>
			</tr>
			<tr>
				<th style="width: ${th_width};"><label>台配縣市</label></th>
				<td>
					<jsp:include page="/pages/component/SuggestAddListBox.jsp">
						<jsp:param name="sBoxId" value="twSpouseCityA" />
					</jsp:include>
					<script type="text/javascript">
						jQuery.getJSON("code_sg_ajax", {codeId : "612"}, function(response) {
							if (response.codeSgList != null) {
								try { twSpouseCityA_sg(response.codeSgList); } catch(e) {};
							}
						});
					</script>
				</td>
			</tr>
			<tr>
				<th style="width: ${th_width};"><label>台配鄉鎮市區</label></th>
				<td>
					<jsp:include page="/pages/component/SuggestAddListBox.jsp">
						<jsp:param name="sBoxId" value="twSpouseTownshipA" />
					</jsp:include>
					<script type="text/javascript">
						jQuery.getJSON("code_sg_ajax", {codeId : "613-634"}, function(response) {
							if (response.codeSgList != null) {
								try { twSpouseTownshipA_sg(response.codeSgList); } catch(e) {};
							}
						});
					</script>
				</td>
			</tr>
		</table>
		</div>
	</div>
	<section class="butCenter">
		<input type="button" id="bt_query" value="下一步" />
		<input type="button" id="bt_clear" value="清除" />
	</section>
</section>
</s:form>

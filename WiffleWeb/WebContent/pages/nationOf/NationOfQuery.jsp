<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="th_width" value="180px" />
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
				$("select").val("-1");
			});

			bindCitySBox("citySBox", "townSBox");
		});

		doQuery = function() {
			if (jQuery("select[name='yearResults']").val() == "-1"
					|| jQuery("select[name='monthResults']").val() == "-1") {
				alert("請選擇年月！");
				return;
			}
			$("#form").attr("action", "list").submit();
		}
	})(jQuery);
</script>
<c:if test="${not empty param.nationOfHeader}">
<h2><span>${param.nationOfHeader}-查詢頁</span></h2>
</c:if>
<section class="styleTb">
	<table>
		<tr>
			<th style="width: ${th_width};"><label>年月</label></th>
			<td>
				<jsp:include page="/pages/component/LinkSelectBox.jsp">
					<jsp:param name="linkSBoxId" value="year" />
					<jsp:param name="linkSBoxNum" value="1" />
				</jsp:include>
				<script type="text/javascript">
					jQuery.getJSON("${pageContext.request.contextPath}/multiquery/code_ajax", {codeId : "Z000"}, function(response) {
						if (response.codeList != null) {
							try { year_linkSBox(response.codeList); } catch(e) {};
						}
					});
				</script>
				<jsp:include page="/pages/component/LinkSelectBox.jsp">
					<jsp:param name="linkSBoxId" value="month" />
					<jsp:param name="linkSBoxNum" value="1" />
				</jsp:include>
				<script type="text/javascript">
					jQuery.getJSON("${pageContext.request.contextPath}/multiquery/code_ajax", {codeId : "Z001"}, function(response) {
						if (response.codeList != null) {
							try { month_linkSBox(response.codeList); } catch(e) {};
						}
					});
				</script>
			</td>
		</tr>
	</table>
	<section class="butCenter">
	  	<input type="button" id="bt_query" class="btn2" value="查詢" />
	  	<%-- <input type="button" id="bt_clear" class="btn2" value="清除" /> --%>
	</section>
</section>

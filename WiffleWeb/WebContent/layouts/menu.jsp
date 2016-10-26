<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

<tiles:importAttribute name="parent" ignore="true" />
<tiles:importAttribute name="functionId" ignore="true" />
<script type="text/javascript">
	$(document).ready(function() {
		$("#jstree").jstree({
			"core" : {
				"multiple" : false,
				"data" : loadMenu(),
				"themes" : {
					"icons" : false
				}
			}
		});

		$("#jstree").on("select_node.jstree", function(e, data) {
			if (data.node.a_attr.href.substr(-1) !== "#") {
				document.location.href = data.node.a_attr.href;
			}

			return data.instance.toggle_node(data.node);
		});
	});

	function loadMenu() {
		var menu = <c:out value='${sessionScope.menu}' escapeXml="false" />;

		var parent = "<c:out value='${parent}' />";
		var functionId = "<c:out value='${functionId}' />";

		for (var i = 0; i < menu.length; ++i) {
			if (menu[i].parent === '#') {
				if (menu[i].id === parent) {
					menu[i]["state"] = {
						"opened" : true
					};
				}
			} else {
				if (menu[i].id === functionId) {
					menu[i]["state"] = {
						"selected" : true
					};
				}
			}
		}

		return menu;
	}
</script>
<html>
	<body>
	    <div id="jstree" class="menubg"></div>
	</body>
</html>


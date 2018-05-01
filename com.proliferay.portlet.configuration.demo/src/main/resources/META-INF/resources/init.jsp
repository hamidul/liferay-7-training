<%@page import="com.proliferay.configuration.DemoConfiguration"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@ page import="com.liferay.portal.kernel.util.Constants"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<%
DemoConfiguration demoConfiguration = (DemoConfiguration) 	renderRequest.getAttribute(DemoConfiguration.class.getName());

	String city = StringPool.BLANK;
	String unit = StringPool.BLANK;
	

	if (Validator.isNotNull(demoConfiguration)) {
		city =
			portletPreferences.getValue(
				"city", demoConfiguration.city());

		unit = portletPreferences.getValue("unit", demoConfiguration.temperatureUnit());
	}else{
		city =	portletPreferences.getValue("city", "");

		unit = portletPreferences.getValue("unit", "");
	}
%>
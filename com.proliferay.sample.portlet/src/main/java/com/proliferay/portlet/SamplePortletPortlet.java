package com.proliferay.portlet;

import com.proliferay.constants.SamplePortletPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

/**
 * @author Hamidul Islam
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=Pro Liferay",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=Sample Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + SamplePortletPortletKeys.SamplePortlet,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class SamplePortletPortlet extends MVCPortlet {
}
package com.proliferay.config;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

import aQute.bnd.annotation.metatype.Meta;

@ExtendedObjectClassDefinition(
		category = "Pro Liferay",
		scope = ExtendedObjectClassDefinition.Scope.COMPANY
		
	)

@Meta.OCD( 
		id = "com.proliferay.config.ReservedWordsConfiguration",
		localization = "content.Language", 
		name = "custom.screen.name"
	)

public interface ReservedWordsConfiguration {

	@Meta.AD(deflt = "admin | user", required = false)
	public String[] reservedWords();
}

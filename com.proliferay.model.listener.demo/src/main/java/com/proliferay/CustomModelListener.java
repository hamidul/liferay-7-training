package com.proliferay;

import com.liferay.portal.kernel.exception.ModelListenerException;
import com.liferay.portal.kernel.model.BaseModelListener;
import com.liferay.portal.kernel.model.ModelListener;
import com.liferay.portal.kernel.model.User;

import org.osgi.service.component.annotations.Component;

/**
 * @author Hamidul Islam
 */
@Component(
	immediate = true,
	property = {
		// TODO enter required service properties
	},
	service = ModelListener.class
)
public class CustomModelListener extends BaseModelListener<User> {

	@Override
	public void onBeforeCreate(User model) throws ModelListenerException {
		System.out.println("############### Creating User ################# " +model.getPrimaryKey()); 
	}

	@Override
	public void onAfterUpdate(User model) throws ModelListenerException {
		System.out.println("#### CustomModelListener called after updating user ######"); 
	}

	

}
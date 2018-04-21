/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.proliferay.book.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the Book service. Represents a row in the &quot;BOOK_PORTLET&quot; database table, with each column mapped to a property of this class.
 *
 * @author Hamidul Islam
 * @see BookModel
 * @see com.proliferay.book.model.impl.BookImpl
 * @see com.proliferay.book.model.impl.BookModelImpl
 * @generated
 */
@ImplementationClassName("com.proliferay.book.model.impl.BookImpl")
@ProviderType
public interface Book extends BookModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.proliferay.book.model.impl.BookImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Book, Long> BOOK_ID_ACCESSOR = new Accessor<Book, Long>() {
			@Override
			public Long get(Book book) {
				return book.getBookId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Book> getTypeClass() {
				return Book.class;
			}
		};
}
/*
 * Copyright (C) 2016, Ulrich Wolffgang <u.wol@wwu.de>
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD 3-clause license. See the LICENSE file for details.
 */

package io.proleap.vb6.asg.metamodel.type.impl;

import io.proleap.vb6.asg.metamodel.type.BaseType;

public class BaseTypeImpl extends TypeImpl implements BaseType {

	public BaseTypeImpl(final String name, final boolean isCollection) {
		super(name, isCollection);
	}

}

/*
 * Copyright (C) 2016, Ulrich Wolffgang <u.wol@wwu.de>
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD 3-clause license. See the LICENSE file for details.
 */

package io.proleap.vb6.parser.metamodel;

import java.util.List;

import io.proleap.vb6.VisualBasic6Parser.PropertyGetStmtContext;
import io.proleap.vb6.parser.metamodel.call.PropertyGetCall;
import io.proleap.vb6.parser.metamodel.type.AssignableTypedElement;

/**
 * Declares the name, arguments, and code that form the body of a Property
 * procedure, which gets the value of a property.
 */
public interface PropertyGet extends Procedure, Statement, AssignableTypedElement {

	void addPropertyGetCall(PropertyGetCall propertyGetCall);

	@Override
	PropertyGetStmtContext getCtx();

	List<PropertyGetCall> getPropertyGetCalls();

	boolean isDeclaredAsArray();

	void setDeclaredAsArray(boolean isArray);

}

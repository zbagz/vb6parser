/*
 * Copyright (C) 2016, Ulrich Wolffgang <u.wol@wwu.de>
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD 3-clause license. See the LICENSE file for details.
 */

package io.proleap.vb6.parser.metamodel.impl;

import org.antlr.v4.runtime.tree.ParseTree;

import io.proleap.vb6.parser.metamodel.IfCondition;
import io.proleap.vb6.parser.metamodel.Module;
import io.proleap.vb6.parser.metamodel.Scope;
import io.proleap.vb6.parser.metamodel.type.Type;
import io.proleap.vb6.parser.metamodel.valuestmt.ValueStmt;

public class IfConditionImpl extends ScopedElementImpl implements IfCondition {

	protected ValueStmt valueStmt;

	public IfConditionImpl(final Module module, final Scope scope, final ParseTree ctx) {
		super(module, scope, ctx);
	}

	@Override
	public Type getType() {
		Type result;

		if (valueStmt == null) {
			result = null;
		} else {
			result = valueStmt.getType();
		}

		return result;
	}

	@Override
	public ValueStmt getValueStmt() {
		return valueStmt;
	}

	@Override
	public void setValueStmt(final ValueStmt valueStmt) {
		this.valueStmt = valueStmt;
	}

}

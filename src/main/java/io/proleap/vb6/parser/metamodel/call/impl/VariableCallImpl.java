/*
 * Copyright (C) 2016, Ulrich Wolffgang <u.wol@wwu.de>
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD 3-clause license. See the LICENSE file for details.
 */

package io.proleap.vb6.parser.metamodel.call.impl;

import org.antlr.v4.runtime.tree.ParseTree;

import io.proleap.vb6.parser.metamodel.Module;
import io.proleap.vb6.parser.metamodel.Variable;
import io.proleap.vb6.parser.metamodel.Scope;
import io.proleap.vb6.parser.metamodel.call.VariableCall;
import io.proleap.vb6.parser.metamodel.type.Type;

public class VariableCallImpl extends CallImpl implements VariableCall {

	protected final Variable variable;

	public VariableCallImpl(final String name, final Variable variable, final Module module, final Scope scope,
			final ParseTree ctx) {
		super(name, module, scope, ctx);

		this.variable = variable;
	}

	@Override
	public CallType getCallType() {
		return CallType.VariableCall;
	}

	@Override
	public Type getType() {
		final Type result;

		if (variable != null) {
			result = variable.getType();
		} else {
			result = null;
		}

		return result;
	}

	@Override
	public Variable getVariable() {
		return variable;
	}

	@Override
	public String toString() {
		return super.toString() + ", variable=[" + variable + "]";
	}
}

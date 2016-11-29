/*
 * Copyright (C) 2016, Ulrich Wolffgang <u.wol@wwu.de>
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD 3-clause license. See the LICENSE file for details.
 */

package io.proleap.vb6.parser.metamodel.impl;

import io.proleap.vb6.VisualBasic6Parser.RedimSubStmtContext;
import io.proleap.vb6.parser.metamodel.Module;
import io.proleap.vb6.parser.metamodel.ReDim;
import io.proleap.vb6.parser.metamodel.Variable;
import io.proleap.vb6.parser.metamodel.Scope;
import io.proleap.vb6.parser.metamodel.type.Type;

public class ReDimImpl extends ScopedElementImpl implements ReDim {

	protected final RedimSubStmtContext ctx;

	protected final Variable variable;

	public ReDimImpl(final Variable variable, final Module module, final Scope scope,
			final RedimSubStmtContext ctx) {
		super(module, scope, ctx);

		this.ctx = ctx;
		this.variable = variable;
	}

	@Override
	public String getName() {
		final String result;

		if (variable != null) {
			result = variable.getName();
		} else {
			result = null;
		}

		return result;
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

}

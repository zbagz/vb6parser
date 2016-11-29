/*
 * Copyright (C) 2016, Ulrich Wolffgang <u.wol@wwu.de>
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD 3-clause license. See the LICENSE file for details.
 */

package io.proleap.vb6.parser.metamodel.impl;

import java.util.ArrayList;
import java.util.List;

import io.proleap.vb6.VisualBasic6Parser.ForNextStmtContext;
import io.proleap.vb6.parser.metamodel.ForNext;
import io.proleap.vb6.parser.metamodel.Module;
import io.proleap.vb6.parser.metamodel.Variable;
import io.proleap.vb6.parser.metamodel.Scope;
import io.proleap.vb6.parser.metamodel.ScopedElement;
import io.proleap.vb6.parser.metamodel.valuestmt.ValueStmt;

public class ForNextImpl extends ScopeImpl implements ForNext {

	protected final ForNextStmtContext ctx;

	protected ValueStmt from;

	protected Variable iteratorVariable;

	protected ValueStmt step;

	protected ValueStmt to;

	public ForNextImpl(final Module module, final Scope scope, final ForNextStmtContext ctx) {
		super(module, scope, ctx);

		this.ctx = ctx;
	}

	@Override
	public ForNextStmtContext getCtx() {
		return ctx;
	}

	@Override
	public ValueStmt getFrom() {
		return from;
	}

	@Override
	public Variable getIteratorVariable() {
		return iteratorVariable;
	}

	@Override
	public List<ScopedElement> getScopedElementsInScope(final String name) {
		final List<ScopedElement> result;

		if (name == null) {
			result = null;
		} else if (iteratorVariable != null && iteratorVariable.getName().toLowerCase().equals(name.toLowerCase())) {
			result = new ArrayList<ScopedElement>();
			result.add(iteratorVariable);
		} else {
			result = super.getScopedElementsInScope(name);
		}

		return result;
	}

	@Override
	public ValueStmt getStep() {
		return step;
	}

	@Override
	public ValueStmt getTo() {
		return to;
	}

	@Override
	public void setFrom(final ValueStmt from) {
		this.from = from;
	}

	@Override
	public void setIteratorVariable(final Variable iteratorVariable) {
		this.iteratorVariable = iteratorVariable;
	}

	@Override
	public void setStep(final ValueStmt step) {
		this.step = step;
	}

	@Override
	public void setTo(final ValueStmt to) {
		this.to = to;
	}
}

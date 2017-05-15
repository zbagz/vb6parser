/*
 * Copyright (C) 2016, Ulrich Wolffgang <u.wol@wwu.de>
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD 3-clause license. See the LICENSE file for details.
 */

package io.proleap.vb6.asg.metamodel.statement.foreach.impl;

import java.util.ArrayList;
import java.util.List;

import io.proleap.vb6.VisualBasic6Parser.ForEachStmtContext;
import io.proleap.vb6.asg.metamodel.Module;
import io.proleap.vb6.asg.metamodel.Scope;
import io.proleap.vb6.asg.metamodel.ScopedElement;
import io.proleap.vb6.asg.metamodel.Variable;
import io.proleap.vb6.asg.metamodel.impl.ScopeImpl;
import io.proleap.vb6.asg.metamodel.statement.StatementType;
import io.proleap.vb6.asg.metamodel.statement.StatementTypeEnum;
import io.proleap.vb6.asg.metamodel.statement.foreach.ForEach;
import io.proleap.vb6.asg.metamodel.valuestmt.ValueStmt;

public class ForEachImpl extends ScopeImpl implements ForEach {

	protected final ForEachStmtContext ctx;

	protected Variable elementVariable;

	protected ValueStmt in;

	protected final StatementType statementType = StatementTypeEnum.FOR_EACH;

	public ForEachImpl(final Module module, final Scope scope, final ForEachStmtContext ctx) {
		super(module.getProgram(), module, scope, ctx);

		this.ctx = ctx;
	}

	@Override
	public ForEachStmtContext getCtx() {
		return ctx;
	}

	@Override
	public Variable getElementVariable() {
		return elementVariable;
	}

	@Override
	public ValueStmt getIn() {
		return in;
	}

	@Override
	public List<ScopedElement> getScopedElementsInScope(final String name) {
		final List<ScopedElement> result;

		if (name == null) {
			result = null;
		} else if (elementVariable != null && elementVariable.getName().equals(name)) {
			result = new ArrayList<ScopedElement>();
			result.add(elementVariable);
		} else {
			result = super.getScopedElementsInScope(name);
		}

		return result;
	}

	@Override
	public StatementType getStatementType() {
		return statementType;
	}

	@Override
	public void setElementVariable(final Variable elementVariable) {
		this.elementVariable = elementVariable;
	}

	@Override
	public void setIn(final ValueStmt in) {
		this.in = in;
	}
}

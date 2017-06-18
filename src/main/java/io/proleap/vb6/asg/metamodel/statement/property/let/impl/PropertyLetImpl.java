/*
 * Copyright (C) 2016, Ulrich Wolffgang <u.wol@wwu.de>
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD 3-clause license. See the LICENSE file for details.
 */

package io.proleap.vb6.asg.metamodel.statement.property.let.impl;

import java.util.ArrayList;
import java.util.List;

import io.proleap.vb6.VisualBasic6Parser.PropertyLetStmtContext;
import io.proleap.vb6.asg.metamodel.Module;
import io.proleap.vb6.asg.metamodel.VisibilityEnum;
import io.proleap.vb6.asg.metamodel.call.PropertyLetCall;
import io.proleap.vb6.asg.metamodel.impl.ProcedureImpl;
import io.proleap.vb6.asg.metamodel.statement.StatementType;
import io.proleap.vb6.asg.metamodel.statement.StatementTypeEnum;
import io.proleap.vb6.asg.metamodel.statement.property.let.PropertyLet;

public class PropertyLetImpl extends ProcedureImpl implements PropertyLet {

	protected final PropertyLetStmtContext ctx;

	protected final List<PropertyLetCall> propertyLetCalls = new ArrayList<PropertyLetCall>();

	protected final StatementType statementType = StatementTypeEnum.PROPERTY_LET;

	public PropertyLetImpl(final String name, final VisibilityEnum visibility, final Module module,
			final PropertyLetStmtContext ctx) {
		super(name, visibility, module, ctx);

		this.ctx = ctx;
	}

	@Override
	public void addPropertyLetCall(final PropertyLetCall propertyLetCall) {
		propertyLetCalls.add(propertyLetCall);
	}

	@Override
	public PropertyLetStmtContext getCtx() {
		return ctx;
	}

	@Override
	public List<PropertyLetCall> getPropertyLetCalls() {
		return propertyLetCalls;
	}

	@Override
	public StatementType getStatementType() {
		return statementType;
	}

	@Override
	public boolean hasReturnType() {
		return false;
	}
}
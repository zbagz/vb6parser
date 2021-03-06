/*
 * Copyright (C) 2016, Ulrich Wolffgang <u.wol@wwu.de>
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD 3-clause license. See the LICENSE file for details.
 */

package io.proleap.vb6.asg.metamodel.valuestmt.impl;

import org.antlr.v4.runtime.ParserRuleContext;

import io.proleap.vb6.asg.metamodel.Module;
import io.proleap.vb6.asg.metamodel.Scope;
import io.proleap.vb6.asg.metamodel.call.SubCall;
import io.proleap.vb6.asg.metamodel.call.impl.CallImpl;
import io.proleap.vb6.asg.metamodel.statement.sub.Sub;
import io.proleap.vb6.asg.metamodel.type.Type;

public class SubCallImpl extends CallImpl implements SubCall {

	protected Sub sub;

	public SubCallImpl(final String name, final Sub sub, final Module module, final Scope scope,
			final ParserRuleContext ctx) {
		super(name, module, scope, ctx);

		this.sub = sub;
	}

	@Override
	public CallType getCallType() {
		return CallType.SUB_CALL;
	}

	@Override
	public Sub getSub() {
		return sub;
	}

	@Override
	public Type getType() {
		// sub do not return values
		final Type result = null;
		return result;
	}

	@Override
	public String toString() {
		return super.toString() + ", sub=[" + sub + "]";
	}
}

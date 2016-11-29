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
import io.proleap.vb6.parser.metamodel.Scope;
import io.proleap.vb6.parser.metamodel.api.ApiEnumeration;
import io.proleap.vb6.parser.metamodel.call.ApiEnumerationCall;
import io.proleap.vb6.parser.metamodel.type.Type;

public class ApiEnumerationCallImpl extends CallImpl implements ApiEnumerationCall {

	protected ApiEnumeration apiEnumeration;

	public ApiEnumerationCallImpl(final String name, final ApiEnumeration apiEnumeration, final Module module,
			final Scope scope, final ParseTree ctx) {
		super(name, module, scope, ctx);

		this.apiEnumeration = apiEnumeration;
	}

	@Override
	public ApiEnumeration getApiEnumeration() {
		return apiEnumeration;
	}

	@Override
	public CallType getCallType() {
		return CallType.ApiEnumerationCall;
	}

	@Override
	public Type getType() {
		final Type result;

		if (apiEnumeration != null) {
			result = apiEnumeration;
		} else {
			result = null;
		}

		return result;
	}

	@Override
	public String toString() {
		return super.toString() + ", apiEnumeration=[" + apiEnumeration + "]";
	}
}

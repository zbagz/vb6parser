/*
 * Copyright (C) 2016, Ulrich Wolffgang <u.wol@wwu.de>
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD 3-clause license. See the LICENSE file for details.
 */

package io.proleap.vb6.asg.metamodel.api;

import java.util.List;

import io.proleap.vb6.asg.metamodel.Declaration;
import io.proleap.vb6.asg.metamodel.ModelElement;
import io.proleap.vb6.asg.metamodel.call.ApiProcedureCall;
import io.proleap.vb6.asg.metamodel.type.TypedElement;

public interface ApiProcedure extends ModelElement, TypedElement, Declaration {

	void addApiProcedureCall(ApiProcedureCall apiProcedureCall);

	List<ApiProcedureCall> getApiProcedureCalls();

}

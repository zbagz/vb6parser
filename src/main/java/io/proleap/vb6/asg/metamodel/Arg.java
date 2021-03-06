/*
 * Copyright (C) 2016, Ulrich Wolffgang <u.wol@wwu.de>
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD 3-clause license. See the LICENSE file for details.
 */

package io.proleap.vb6.asg.metamodel;

import java.util.List;

import io.proleap.vb6.VisualBasic6Parser.ArgContext;
import io.proleap.vb6.asg.metamodel.call.ArgCall;
import io.proleap.vb6.asg.metamodel.call.Call;
import io.proleap.vb6.asg.metamodel.type.AssignableTypedElement;

public interface Arg extends AssignableTypedElement, NamedElement, ScopedElement {

	void addArgCall(ArgCall argCall);

	List<ArgCall> getArgCalls();

	@Override
	ArgContext getCtx();

	Call getDefaultValueCall();

	Procedure getProcedure();

	ProcedureDeclaration getProcedureDeclaration();

	boolean isCollection();

	boolean isOptional();

	void setDefaultValueCall(Call defaultValueCall);

	void setProcedure(Procedure procedure);

	void setProcedureDeclaration(ProcedureDeclaration procedureDeclaration);
}

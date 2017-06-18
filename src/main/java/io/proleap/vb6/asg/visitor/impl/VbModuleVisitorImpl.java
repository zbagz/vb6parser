/*
 * Copyright (C) 2016, Ulrich Wolffgang <u.wol@wwu.de>
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD 3-clause license. See the LICENSE file for details.
 */

package io.proleap.vb6.asg.visitor.impl;

import java.util.List;

import io.proleap.vb6.VisualBasic6Parser;
import io.proleap.vb6.asg.metamodel.Module;
import io.proleap.vb6.asg.metamodel.Program;
import io.proleap.vb6.asg.metamodel.impl.ClazzModuleImpl;
import io.proleap.vb6.asg.metamodel.impl.StandardModuleImpl;

/**
 * Visitor for collecting module declarations in the AST.
 */
public class VbModuleVisitorImpl extends AbstractVbParserVisitorImpl {

	protected final boolean isClazzModule;

	protected final boolean isStandardModule;

	protected final List<String> lines;

	protected final String moduleName;

	protected final Program program;

	public VbModuleVisitorImpl(final String moduleName, final List<String> lines, final boolean isClazzModule,
			final boolean isStandardModule, final Program program) {
		super(null);

		this.program = program;
		this.moduleName = moduleName;
		this.lines = lines;
		this.isClazzModule = isClazzModule;
		this.isStandardModule = isStandardModule;
	}

	@Override
	public Boolean visitModule(final VisualBasic6Parser.ModuleContext ctx) {
		final Module result;

		if (isClazzModule) {
			result = new ClazzModuleImpl(moduleName, program, ctx);
		} else if (isStandardModule) {
			result = new StandardModuleImpl(moduleName, program, ctx);
		} else {
			result = null;
		}

		if (result != null) {
			result.setLines(lines);
			module = result;
		}

		return visitChildren(ctx);
	}
}

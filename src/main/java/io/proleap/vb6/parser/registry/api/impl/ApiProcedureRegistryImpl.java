/*
 * Copyright (C) 2016, Ulrich Wolffgang <u.wol@wwu.de>
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD 3-clause license. See the LICENSE file for details.
 */

package io.proleap.vb6.parser.registry.api.impl;

import java.util.HashMap;
import java.util.Map;

import io.proleap.vb6.parser.applicationcontext.VbParserContext;
import io.proleap.vb6.parser.metamodel.api.ApiProcedure;
import io.proleap.vb6.parser.registry.api.ApiProcedureRegistry;

public class ApiProcedureRegistryImpl implements ApiProcedureRegistry {

	final Map<String, ApiProcedure> apiProcedures = new HashMap<String, ApiProcedure>();

	@Override
	public ApiProcedure getApiProcedure(final String name) {
		final String key = getKey(name);
		return apiProcedures.get(key);
	}

	private String getKey(final String name) {
		final String sanitizedTypeName = VbParserContext.getInstance().getTypeNameSanitizer().sanitize(name);
		return sanitizedTypeName.toLowerCase();
	}

	@Override
	public void registerApiProcedure(final ApiProcedure apiProcedure) {
		final String key = getKey(apiProcedure.getName());
		apiProcedures.put(key, apiProcedure);
	}
}

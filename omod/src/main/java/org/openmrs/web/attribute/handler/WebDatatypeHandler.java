/**
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.web.attribute.handler;

import javax.servlet.http.HttpServletRequest;

import org.openmrs.customdatatype.CustomDatatype;
import org.openmrs.customdatatype.CustomDatatypeHandler;
import org.openmrs.customdatatype.InvalidCustomValueException;

/**
 * A web-layer extension of {@link CustomDatatypeHandler}, which generates the HTML for a widget,
 * and handles the submission of that widget
 */
public interface WebDatatypeHandler<DT extends CustomDatatype<T>, T> extends HtmlDisplayableDatatypeHandler<T> {
	
	/**
	 * Generates the HTML for a widget
	 * 
	 * @param datatype the underlying datatype for this widget
	 * @param formFieldName the name the widget should submit with
	 * @param widgetId a unique id, generated by the web framework, that the widget should use
	 * @param startingValue the initial value for the generated HTML
	 * @return HTML for editing/creating a value of this datatype
	 */
	String getWidgetHtml(DT datatype, String formFieldName, String widgetId, T startingValue);
	
	/**
	 * Handles a form submission including a widget generated by this handler
	 * 
	 * @param datatype the underlying datatype for this widget
	 * @param request the submitted HTTP request
	 * @param formFieldName the same value passed to
	 *            {@link #getWidgetHtml(CustomDatatype, String, String, Object)} when generating
	 *            this widget
	 * @return a parsed and validated value submitted by the widget
	 * @throws InvalidCustomValueException
	 */
	T getValue(DT datatype, HttpServletRequest request, String formFieldName) throws InvalidCustomValueException;
	
}

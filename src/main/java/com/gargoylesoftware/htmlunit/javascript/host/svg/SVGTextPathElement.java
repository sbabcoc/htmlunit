/*
 * Copyright (c) 2002-2023 Gargoyle Software Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.gargoylesoftware.htmlunit.javascript.host.svg;

import static com.gargoylesoftware.htmlunit.javascript.configuration.SupportedBrowser.CHROME;
import static com.gargoylesoftware.htmlunit.javascript.configuration.SupportedBrowser.EDGE;
import static com.gargoylesoftware.htmlunit.javascript.configuration.SupportedBrowser.FF;
import static com.gargoylesoftware.htmlunit.javascript.configuration.SupportedBrowser.FF_ESR;

import com.gargoylesoftware.htmlunit.javascript.configuration.JsxClass;
import com.gargoylesoftware.htmlunit.javascript.configuration.JsxConstant;
import com.gargoylesoftware.htmlunit.javascript.configuration.JsxConstructor;
import com.gargoylesoftware.htmlunit.svg.SvgTextPath;

/**
 * A JavaScript object for {@code SVGTextPathElement}.
 *
 * @author Ahmed Ashour
 * @author Ronald Brill
 */
@JsxClass(domClass = SvgTextPath.class)
public class SVGTextPathElement extends SVGTextContentElement {

    /** The constant {@code TEXTPATH_METHODTYPE_UNKNOWN}. */
    @JsxConstant
    public static final int TEXTPATH_METHODTYPE_UNKNOWN = 0;
    /** The constant {@code TEXTPATH_SPACINGTYPE_UNKNOWN}. */
    @JsxConstant
    public static final int TEXTPATH_SPACINGTYPE_UNKNOWN = 0;
    /** The constant {@code TEXTPATH_METHODTYPE_ALIGN}. */
    @JsxConstant
    public static final int TEXTPATH_METHODTYPE_ALIGN = 1;
    /** The constant {@code TEXTPATH_SPACINGTYPE_AUTO}. */
    @JsxConstant
    public static final int TEXTPATH_SPACINGTYPE_AUTO = 1;
    /** The constant {@code TEXTPATH_METHODTYPE_STRETCH}. */
    @JsxConstant
    public static final int TEXTPATH_METHODTYPE_STRETCH = 2;
    /** The constant {@code TEXTPATH_SPACINGTYPE_EXACT}. */
    @JsxConstant
    public static final int TEXTPATH_SPACINGTYPE_EXACT = 2;

    /**
     * Creates an instance.
     */
    public SVGTextPathElement() {
    }

    /**
     * Creates an instance.
     */
    @JsxConstructor({CHROME, EDGE, FF, FF_ESR})
    @Override
    public void jsConstructor() {
        super.jsConstructor();
    }
}

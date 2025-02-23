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
package com.gargoylesoftware.htmlunit.javascript.host.html;

import static com.gargoylesoftware.htmlunit.BrowserVersionFeatures.HTMLBASEFONT_END_TAG_FORBIDDEN;
import static com.gargoylesoftware.htmlunit.javascript.configuration.SupportedBrowser.IE;

import com.gargoylesoftware.htmlunit.html.HtmlBaseFont;
import com.gargoylesoftware.htmlunit.javascript.configuration.JsxClass;
import com.gargoylesoftware.htmlunit.javascript.configuration.JsxGetter;
import com.gargoylesoftware.htmlunit.javascript.configuration.JsxSetter;

import net.sourceforge.htmlunit.corejs.javascript.Context;

/**
 * The JavaScript object {@code HTMLBaseFontElement}.
 *
 * @author Ahmed Ashour
 */
@JsxClass(domClass = HtmlBaseFont.class, value = IE)
public class HTMLBaseFontElement extends HTMLElement {

    /**
     * Default constructor.
     */
    public HTMLBaseFontElement() {
    }

    /**
     * Gets the {@code color} attribute.
     * @return the {@code color} attribute
     */
    @JsxGetter
    public String getColor() {
        final HtmlBaseFont base = (HtmlBaseFont) getDomNodeOrDie();
        return base.getColorAttribute();
    }

    /**
     * Sets the {@code color} attribute.
     * @param color the {@code color} attribute
     */
    @JsxSetter
    public void setColor(final String color) {
        getDomNodeOrDie().setAttribute("color", color);
    }

    /**
     * Gets the typeface family.
     * @return the typeface family
     */
    @JsxGetter
    public String getFace() {
        final HtmlBaseFont base = (HtmlBaseFont) getDomNodeOrDie();
        return base.getFaceAttribute();
    }

    /**
     * Sets the typeface family.
     * @param face the typeface family
     */
    @JsxSetter
    public void setFace(final String face) {
        getDomNodeOrDie().setAttribute("face", face);
    }

    /**
     * Gets the {@code size} attribute.
     * @return the {@code size} attribute
     */
    @JsxGetter
    public int getSize() {
        final HtmlBaseFont base = (HtmlBaseFont) getDomNodeOrDie();
        return (int) Context.toNumber(base.getSizeAttribute());
    }

    /**
     * Sets the {@code size} attribute.
     * @param size the {@code size} attribute
     */
    @JsxSetter
    public void setSize(final int size) {
        getDomNodeOrDie().setAttribute("size", Context.toString(Integer.valueOf(size)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected boolean isEndTagForbidden() {
        return getBrowserVersion().hasFeature(HTMLBASEFONT_END_TAG_FORBIDDEN);
    }
}

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

import static com.gargoylesoftware.htmlunit.javascript.configuration.SupportedBrowser.IE;

import com.gargoylesoftware.htmlunit.javascript.HtmlUnitScriptable;
import com.gargoylesoftware.htmlunit.javascript.configuration.JsxClass;
import com.gargoylesoftware.htmlunit.javascript.configuration.JsxConstructor;
import com.gargoylesoftware.htmlunit.javascript.configuration.JsxFunction;

import net.sourceforge.htmlunit.corejs.javascript.ScriptRuntime;
import net.sourceforge.htmlunit.corejs.javascript.Undefined;

/**
 * A JavaScript object for {@code Enumerator}.
 *
 * @author Ahmed Ashour
 * @author Ronald Brill
 * @see <a href="http://msdn.microsoft.com/en-us/library/6ch9zb09.aspx">MSDN Documentation</a>
 */
@JsxClass(IE)
public class Enumerator extends HtmlUnitScriptable {

    /**
     * Creates an instance.
     */
    public Enumerator() {
    }

    /**
     * JavaScript constructor.
     * @param o the object to enumerate over
     */
    @JsxConstructor
    public void jsConstructor(final Object o) {
        if (Undefined.isUndefined(o)) {
            return;
        }
        throw ScriptRuntime.typeError("object is not enumerable");
    }

    /**
     * Returns whether the enumerator is at the end of the collection or not.
     * @return whether the enumerator is at the end of the collection or not
     */
    @JsxFunction
    public boolean atEnd() {
        return true;
    }

    /**
     * Returns the current item in the collection.
     * @return the current item in the collection
     */
    @JsxFunction
    public Object item() {
        return Undefined.instance;
    }

    /**
     * Resets the current item in the collection to the first item.
     */
    @JsxFunction
    public void moveFirst() {
    }

    /**
     * Moves the current item to the next item in the collection.
     */
    @JsxFunction
    public void moveNext() {
    }
}

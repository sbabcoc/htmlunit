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
package com.gargoylesoftware.htmlunit.javascript.host.media;

import static com.gargoylesoftware.htmlunit.javascript.configuration.SupportedBrowser.CHROME;
import static com.gargoylesoftware.htmlunit.javascript.configuration.SupportedBrowser.EDGE;
import static com.gargoylesoftware.htmlunit.javascript.configuration.SupportedBrowser.FF;
import static com.gargoylesoftware.htmlunit.javascript.configuration.SupportedBrowser.FF_ESR;

import com.gargoylesoftware.htmlunit.javascript.configuration.JsxClass;
import com.gargoylesoftware.htmlunit.javascript.configuration.JsxConstructor;
import com.gargoylesoftware.htmlunit.javascript.configuration.JsxFunction;
import com.gargoylesoftware.htmlunit.javascript.host.event.EventTarget;

import net.sourceforge.htmlunit.corejs.javascript.ScriptRuntime;

/**
 * A JavaScript object for {@code AudioNode}.
 *
 * @author Ahmed Ashour
 * @author Ronald Brill
 */
@JsxClass({CHROME, EDGE, FF, FF_ESR})
public class AudioNode extends EventTarget {

    /**
     * Creates an instance.
     */
    public AudioNode() {
    }

    /**
     * Creates an instance.
     * @param baCtx the required audio context
     */
    @JsxConstructor
    public void jsConstructor(final Object baCtx) {
        if (!(baCtx instanceof BaseAudioContext)) {
            throw ScriptRuntime.typeError(
                    "Failed to construct '" + getClass().getSimpleName()
                        + "': first parameter is not of type 'BaseAudioContext'.");
        }
    }

    /**
     * Lets you connect one of the node's outputs to a target, which may be either another
     * AudioNode (thereby directing the sound data to the specified node) or an AudioParam,
     * so that the node's output data is automatically used to change the value
     * of that parameter over time.
     */
    @JsxFunction
    public void connect() {
    }
}

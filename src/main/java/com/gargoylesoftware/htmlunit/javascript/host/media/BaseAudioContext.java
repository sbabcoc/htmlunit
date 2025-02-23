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

import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.javascript.JavaScriptEngine;
import com.gargoylesoftware.htmlunit.javascript.PostponedAction;
import com.gargoylesoftware.htmlunit.javascript.configuration.JsxClass;
import com.gargoylesoftware.htmlunit.javascript.configuration.JsxConstructor;
import com.gargoylesoftware.htmlunit.javascript.configuration.JsxFunction;
import com.gargoylesoftware.htmlunit.javascript.host.Window;
import com.gargoylesoftware.htmlunit.javascript.host.event.EventTarget;

import net.sourceforge.htmlunit.corejs.javascript.Context;
import net.sourceforge.htmlunit.corejs.javascript.Function;
import net.sourceforge.htmlunit.corejs.javascript.LambdaConstructor;
import net.sourceforge.htmlunit.corejs.javascript.LambdaFunction;
import net.sourceforge.htmlunit.corejs.javascript.Scriptable;
import net.sourceforge.htmlunit.corejs.javascript.ScriptableObject;
import net.sourceforge.htmlunit.corejs.javascript.typedarrays.NativeArrayBuffer;

/**
 * A JavaScript object for {@code BaseAudioContext}.
 *
 * @author Ahmed Ashour
 * @author Ronald Brill
 */
@JsxClass({CHROME, EDGE, FF, FF_ESR})
public class BaseAudioContext extends EventTarget {

    /**
     * Creates an instance.
     */
    public BaseAudioContext() {
    }

    /**
     * Creates an instance.
     */
    @JsxConstructor
    public void jsConstructor() {
        throw Context.reportRuntimeError("Illegal constructor.");
    }

    /**
     * @return a new AudioBufferSourceNode, which can be used to
     * play audio data contained within an AudioBuffer object.
     */
    @JsxFunction
    public AudioBufferSourceNode createBufferSource() {
        final AudioBufferSourceNode node = new AudioBufferSourceNode();
        node.setParentScope(getParentScope());
        node.setPrototype(getPrototype(node.getClass()));
        return node;
    }

    /**
     * @return new, empty AudioBuffer object, which can then be
     * populated by data, and played via an AudioBufferSourceNode.
     */
    @JsxFunction
    public AudioBuffer createBuffer() {
        final AudioBuffer node = new AudioBuffer();
        node.setParentScope(getParentScope());
        node.setPrototype(getPrototype(node.getClass()));
        return node;
    }

    /**
     * @return a GainNode, which can be used to control the overall gain (or volume) of the audio graph.
     */
    @JsxFunction
    public GainNode createGain() {
        final GainNode node = new GainNode();
        node.setParentScope(getParentScope());
        node.setPrototype(getPrototype(node.getClass()));
        node.jsConstructor(this);
        return node;
    }

    /**
     * The decodeAudioData() method of the BaseAudioContext Interface is used to asynchronously
     * decode audio file data contained in an ArrayBuffer. In this case the ArrayBuffer is
     * loaded from XMLHttpRequest and FileReader.
     * The decoded AudioBuffer is resampled to the AudioContext's sampling rate,
     * then passed to a callback or promise.
     * @param buffer An ArrayBuffer containing the audio data to be decoded, usually grabbed
     * from XMLHttpRequest, WindowOrWorkerGlobalScope.fetch() or FileReader
     * @param success A callback function to be invoked when the decoding successfully finishes.
     * The single argument to this callback is an AudioBuffer representing the decodedData
     * (the decoded PCM audio data). Usually you'll want to put the decoded data into
     * an AudioBufferSourceNode, from which it can be played and manipulated how you want.
     * @param error An optional error callback, to be invoked if an error occurs
     * when the audio data is being decoded.
     * @return the promise or null
     */
    @JsxFunction
    public Object decodeAudioData(final NativeArrayBuffer buffer, final Function success, final Function error) {
        final Window window = getWindow();
        final HtmlPage owningPage = (HtmlPage) window.getDocument().getPage();
        final JavaScriptEngine jsEngine =
                (JavaScriptEngine) window.getWebWindow().getWebClient().getJavaScriptEngine();

        if (error != null) {
            jsEngine.addPostponedAction(new PostponedAction(owningPage, "BaseAudioContext.decodeAudioData") {
                @Override
                public void execute() throws Exception {
                    jsEngine.callFunction(owningPage, error, getParentScope(), BaseAudioContext.this, new Object[] {});
                }
            });
            return null;
        }

        final Scriptable scope = ScriptableObject.getTopLevelScope(this);
        final LambdaConstructor ctor = (LambdaConstructor) getProperty(scope, "Promise");
        final LambdaFunction reject = (LambdaFunction) getProperty(ctor, "reject");
        return reject.call(Context.getCurrentContext(), this, ctor, new Object[] {});
    }
}

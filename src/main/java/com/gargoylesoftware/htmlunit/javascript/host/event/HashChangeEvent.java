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
package com.gargoylesoftware.htmlunit.javascript.host.event;

import static com.gargoylesoftware.htmlunit.javascript.configuration.SupportedBrowser.CHROME;
import static com.gargoylesoftware.htmlunit.javascript.configuration.SupportedBrowser.EDGE;
import static com.gargoylesoftware.htmlunit.javascript.configuration.SupportedBrowser.FF;
import static com.gargoylesoftware.htmlunit.javascript.configuration.SupportedBrowser.FF_ESR;

import com.gargoylesoftware.htmlunit.javascript.configuration.JsxClass;
import com.gargoylesoftware.htmlunit.javascript.configuration.JsxConstructor;
import com.gargoylesoftware.htmlunit.javascript.configuration.JsxFunction;
import com.gargoylesoftware.htmlunit.javascript.configuration.JsxGetter;

import net.sourceforge.htmlunit.corejs.javascript.ScriptableObject;
import net.sourceforge.htmlunit.corejs.javascript.Undefined;

/**
 * JavaScript object representing the HashChangeEvent.
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/window.onhashchange">Mozilla Developer Network</a>
 * @see <a href="http://msdn.microsoft.com/en-us/library/cc288209.aspx">MSDN</a>
 *
 * @author Ronald Brill
 * @author Marc Guillemot
 * @author Frank Danek
 */
@JsxClass({CHROME, EDGE, FF, FF_ESR})
public class HashChangeEvent extends Event {

    private String oldURL_ = "";
    private String newURL_ = "";

    /**
     * Creates a new event instance.
     */
    public HashChangeEvent() {
        setEventType("");
    }

    /**
     * Creates a new event instance.
     *
     * @param target the event target
     * @param type the event type
     * @param oldURL the old URL
     * @param newURL the new URL
     */
    public HashChangeEvent(final EventTarget target, final String type,
            final String oldURL, final String newURL) {
        super(target, type);
        oldURL_ = oldURL;
        newURL_ = newURL;

        setBubbles(false);
        setCancelable(false);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @JsxConstructor({CHROME, EDGE, FF, FF_ESR})
    public void jsConstructor(final String type, final ScriptableObject details) {
        super.jsConstructor(type, details);

        String oldURL = "";
        String newURL = "";
        if (details != null && !Undefined.isUndefined(details)) {
            oldURL = (String) details.get("oldURL");
            newURL = (String) details.get("newURL");
        }
        oldURL_ = oldURL;
        newURL_ = newURL;
    }

    /**
     * Initializes this event.
     *
     * @param type the event type
     * @param bubbles whether or not the event should bubble
     * @param cancelable whether or not the event the event should be cancelable
     * @param oldURL the old URL
     * @param newURL the new URL
     */
    @JsxFunction({FF, FF_ESR})
    public void initHashChangeEvent(final String type, final boolean bubbles, final boolean cancelable,
        final String oldURL, final String newURL) {
        initEvent(type, bubbles, cancelable);
        oldURL_ = oldURL;
        newURL_ = newURL;
    }

    /**
     * Returns the old URL.
     * @return the old URL
     */
    @JsxGetter({CHROME, EDGE, FF, FF_ESR})
    public Object getOldURL() {
        return oldURL_;
    }

    /**
     * Returns the new URL.
     * @return the new URL
     */
    @JsxGetter({CHROME, EDGE, FF, FF_ESR})
    public Object getNewURL() {
        return newURL_;
    }
}

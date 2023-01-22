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
package com.gargoylesoftware.htmlunit.javascript.host.dom;

import org.w3c.dom.DOMException;
import org.xml.sax.SAXException;

import static com.gargoylesoftware.htmlunit.javascript.configuration.SupportedBrowser.CHROME;
import static com.gargoylesoftware.htmlunit.javascript.configuration.SupportedBrowser.EDGE;
import static com.gargoylesoftware.htmlunit.javascript.configuration.SupportedBrowser.FF;
import static com.gargoylesoftware.htmlunit.javascript.configuration.SupportedBrowser.FF_ESR;

import java.io.IOException;

import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.DomNode;
import com.gargoylesoftware.htmlunit.javascript.configuration.JsxClass;
import com.gargoylesoftware.htmlunit.javascript.configuration.JsxConstructor;
import com.gargoylesoftware.htmlunit.javascript.configuration.JsxGetter;
import com.gargoylesoftware.htmlunit.javascript.configuration.JsxSetter;
import com.gargoylesoftware.htmlunit.javascript.host.Element;
import com.gargoylesoftware.htmlunit.javascript.host.animations.Animation;
import com.gargoylesoftware.htmlunit.javascript.host.css.CSSStyleSheet;
import com.gargoylesoftware.htmlunit.javascript.host.css.StyleSheetList;
import com.gargoylesoftware.htmlunit.javascript.host.event.Event;
import com.gargoylesoftware.htmlunit.javascript.host.event.EventHandler;
import com.gargoylesoftware.htmlunit.javascript.host.html.HTMLElement;

import net.sourceforge.htmlunit.corejs.javascript.Context;
import net.sourceforge.htmlunit.corejs.javascript.Function;

/**
 * A JavaScript object for {@code ShadowRoot}.
 *
 * @author Ahmed Ashour
 * @author Ronald Brill
 * @author Scott Babcock
 * @see <a href="https://www.w3docs.com/learn-javascript/javascript-shadow-dom.html">JavaScript Shadow DOM</a>
 */
@JsxClass({CHROME, EDGE, FF, FF_ESR})
public class ShadowRoot extends DocumentFragment {
    
    private CSSStyleSheet[] adoptedStyleSheets_ = new CSSStyleSheet[0];
    private boolean delegatesFocus_ = false;
    private SlotAssignmentMode slotAssignment_;
    private Element fullscreenElement_;
    private final Element host_;
    private final ShadowRootMode mode_;
    private Element pictureInPictureElement_;
    private Element pointerLockElement_;
    private StyleSheetList styleSheets_;

    /** The symbolic node name. */
    public static final String NODE_NAME = "shadowRoot";

    /**
     * Creates a new instance.
     */
    @JsxConstructor
    public ShadowRoot(final Element host, final ShadowRootMode mode) {
        this.host_ = host;
        this.mode_ = mode;
    }
    
    @Override
    public String getNodeName() {
        return NODE_NAME;
    }
    
    // FIXME: Not implemented
    public Animation[] getAnimations() {
        return null;
    }
    
    // FIXME: Not implemented
    public Selection getSelection() {
        return null;
    }
    
    // FIXME: Not implemented
    public Element elementFromPoint() {
        return null;
    }
    
    // FIXME: Not implemented
    public Element[] elementsFromPoint() {
        return null;
    }
    
    // EVENTS
    
    // slotchange : HTMLSlotChange
    
    /**
     * Returns the value of the {@code activeElement} property.
     * @see <a href="http://msdn.microsoft.com/en-us/library/ms533065.aspx">MSDN documentation</a>
     * @return the value of the {@code activeElement} property
     */
    @JsxGetter({CHROME, EDGE, FF, FF_ESR})
    public Element getActiveElement() {
        
        return null;
    }

    /**
     * Returns the value of the {@code adoptedStyleSheets} property.
     * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/Document/adoptedStyleSheets">MDN documentation</a>
     * @return the value of the {@code adoptedStyleSheets} property
     */
    @JsxGetter({CHROME, EDGE, FF, FF_ESR})
    public CSSStyleSheet[] getAdoptedStyleSheets() {
        return adoptedStyleSheets_;
    }
    
    /**
     * Set the array of style sheets to be used by the shadow DOM subtree.
     * @param styleSheets array of {@link CSSStyleSheet} objects to be adopted
     * @throws DOMException <i>NotAllowedError</i> if a specified style sheet is not owned by the current document
     */
    @JsxSetter({CHROME, EDGE, FF, FF_ESR})
    public void setAdoptedStyleSheets(final CSSStyleSheet... styleSheets) throws DOMException {
        Object ownerDocument = getOwnerDocument();
        CSSStyleSheet[] adoptedStyleSheets = new CSSStyleSheet[styleSheets.length];
        // iterate over style sheet adoptees
        for (int i = 0; i < styleSheets.length; i++) {
            HTMLElement ownerNode = styleSheets[i].getOwnerNode();
            // if style sheet owned
            if (ownerNode != null) {
                // if style sheet not owned by shadow root document
                if (ownerNode.getOwnerDocument() != ownerDocument) {
                    throw Context.reportRuntimeError("NotAllowedError: Style sheet was not constructed in the current document.");
                }
            }
            // save reference to style sheet
            adoptedStyleSheets[i] = styleSheets[i];
        }
        adoptedStyleSheets_ = adoptedStyleSheets;
    }
    
    @JsxGetter({CHROME, EDGE, FF, FF_ESR})
    public boolean getDelegatesFocus() {
        return delegatesFocus_;
    }
    
    @Override
    public void setEventHandler(final String eventType, final Object value) {
        super.setEventHandler(eventType, value);
    }
    
    @JsxGetter({CHROME, EDGE, FF, FF_ESR})
    public Function getOnslotchange() {
        return getEventHandler(Event.TYPE_SLOT_CHANGE);
    }
    
    @JsxSetter({CHROME, EDGE, FF, FF_ESR})
    public void setOnslotchange(final EventHandler slotchange) {
        setEventHandler(Event.TYPE_SLOT_CHANGE, slotchange);
    }
    
    @JsxGetter({CHROME, EDGE, FF, FF_ESR})
    public Object getFullscreenElement() {
        return fullscreenElement_;
    }
    
    @JsxGetter({CHROME, EDGE, FF, FF_ESR})
    public Object getHost() {
        return host_;
    }
    
    @JsxGetter({CHROME, EDGE, FF, FF_ESR})
    public String getInnerHTML() {
        final StringBuilder buf = new StringBuilder();
        for (DomNode child : getChildren().getElements()) {
            if (child instanceof DomElement) {
                Element elem = new Element();
                elem.setDomNode(child);
                buf.append(elem.getInnerHTML());
            }
        }
        return buf.toString();
    }
    
    @SuppressWarnings("unused")
    private static void printNode(final StringBuilder buf, final Node node) {
        if (node instanceof Element) {
            ((Element) node).getInnerHTML();
        }
    }
    
    @JsxSetter({CHROME, EDGE, FF, FF_ESR})
    public void setInnerHTML(final String innerHTML) throws SAXException, IOException {
        DomNode domNode = getDomNodeOrDie();
        domNode.removeAllChildren();
        domNode.parseHtmlSnippet(innerHTML);
    }
    
    enum SlotAssignmentMode {
        MANUAL("manual"),
        NAMED("named");
        
        private final String mode;

        SlotAssignmentMode(String mode) {
            this.mode = mode;
        }
        
        @Override
        public String toString() {
            return mode;
        }
    }
    
    enum ShadowRootMode {
        OPEN("open"),
        CLOSED("closed");
        
        private final String mode;

        ShadowRootMode(String mode) {
            this.mode = mode;
        }
        
        @Override
        public String toString() {
            return mode;
        }
    }

}

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

import static com.gargoylesoftware.htmlunit.javascript.configuration.SupportedBrowser.CHROME;
import static com.gargoylesoftware.htmlunit.javascript.configuration.SupportedBrowser.EDGE;
import static com.gargoylesoftware.htmlunit.javascript.configuration.SupportedBrowser.FF;
import static com.gargoylesoftware.htmlunit.javascript.configuration.SupportedBrowser.FF_ESR;

import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlSlot;
import com.gargoylesoftware.htmlunit.javascript.configuration.JsxClass;
import com.gargoylesoftware.htmlunit.javascript.configuration.JsxConstructor;
import com.gargoylesoftware.htmlunit.javascript.host.Element;
import com.gargoylesoftware.htmlunit.javascript.host.dom.Node;
import com.gargoylesoftware.htmlunit.javascript.host.dom.ShadowRoot;
import com.gargoylesoftware.htmlunit.javascript.host.event.Event;

import net.sourceforge.htmlunit.corejs.javascript.ScriptableObject;

/**
 * A JavaScript object for {@code HTMLSlotElement}.
 * <p>
 * A slot has an associated name (a string). Unless stated otherwise it is the empty string.
 * Use these <a href="https://dom.spec.whatwg.org/#concept-element-attributes-change-ext">attribute change steps</a>
 * to update a slot’s name:
 * 
 * <ol>
 *     <li>If element is a slot, localName is name, and namespace is null, then: <ol>
 *         <li>If value is oldValue, then return.</li>
 *         <li>If value is null and oldValue is the empty string, then return.</li>
 *         <li>If value is the empty string and oldValue is null, then return.</li>
 *         <li>If value is null or the empty string, then set element’s
 *             <a href="https://dom.spec.whatwg.org/#slot-name">name</a> to the empty string.</li>
 *         <li>Otherwise, set element’s name to value.</li>
 *         <li>Run <a href="https://dom.spec.whatwg.org/#assign-slotables-for-a-tree>assign slottables for a tree</a>
 *             with element’s <a href="https://dom.spec.whatwg.org/#concept-tree-root>root</a>.</li>
 *     </ol></li>
 * </ol>
 *
 * @author Ahmed Ashour
 * @author Ronald Brill
 * @see <a href="https://dom.spec.whatwg.org/#shadow-trees">Shadow Tree</a>
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/Web_Components/Using_templates_and_slots">Using templates and slots</a>
 */
@SuppressWarnings("serial")
@JsxClass(domClass = HtmlSlot.class, value = {CHROME, EDGE, FF, FF_ESR})
public class HTMLSlotElement extends HTMLElement {
    
    private Node[] assignedNodes;
    
    // METHODS
    
    /**
     * Creates an instance.
     */
    @JsxConstructor
    public HTMLSlotElement() {
    }
    
    /**
     * Sets the value of the JavaScript attribute {@code name}.
     *
     * @param newName the new name
     */
    @Override
    public void setName(final String newName) {
        String name = newName;
        String oldName = getLocalName();
        if (null == name) {
            if ("".equals(oldName)) {
                return;
            }
            name = "";
        } else if ((null == oldName) && "".equals(name)) {
            return;
        }
        super.setName(name);
        // TODO: Run 'assign slottables for a tree' with element's root
    }

    // 1 or more 'Element' or 'Text' node
    public void assign(final Node... nodes) {
        // NOTE: 'mode' of slot must be 'manual'
    }
    
    public Element[] assignedElements() {
        return assignedElements(new AssignedNodesOptions());
    }
    
    // FIXME: Not implemented
    public Element[] assignedElements(final AssignedNodesOptions options) {
        return null;
    }
    
    public Node[] assignedNodes() {
        return assignedNodes(new AssignedNodesOptions());
    }

    // FIXME: Not implemented
    public Node[] assignedNodes(final AssignedNodesOptions options) {
        return null;
    }

    /**
     * <a href="https://dom.spec.whatwg.org/#signaling-slot-change">Signaling slot change</a>
     * <p>
     * Each <a href="https://html.spec.whatwg.org/multipage/webappapis.html#similar-origin-window-agent">
     * similar-origin window agent</a> has signal slots (a set of slots), which is initially empty.
     * To signal a slot change, for a slot slot, run these steps:
     * 
     * <ol>
     *     <li>Append slot to slot’s <a href="https://html.spec.whatwg.org/multipage/webappapis.html#relevant-agent">
     *         relevant agent</a>’s <a href="https://dom.spec.whatwg.org/#signal-slot-list">signal slots</a>.</li>
     *     <li><a href="https://dom.spec.whatwg.org/#queue-a-mutation-observer-compound-microtask">
     *         Queue a mutation observer microtask</a>.</li>
     * </ol>
     * 
     * @param shadowRoot
     */
    @SuppressWarnings("unused")
    private void fireSlotChange(final ShadowRoot shadowRoot) {
        fireEvent(new Event(shadowRoot, Event.TYPE_SLOT_CHANGE));
    }
    
    public static final class AssignedNodesOptions extends ScriptableObject {
        
        public AssignedNodesOptions() {
            super();
            this.defineProperty("flatten", Boolean.FALSE, PERMANENT);
            this.sealObject();
        }
        
        public AssignedNodesOptions flatten() {
            this.put("flatten", this, Boolean.TRUE);
            return this;
        }
        
        public boolean doFlatten() {
            return this.get("flatten") == Boolean.TRUE;
        }

        @Override
        public String getClassName() {
            return getClass().getSimpleName();
        }
    }
}

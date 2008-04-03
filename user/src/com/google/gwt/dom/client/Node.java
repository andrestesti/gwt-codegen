/*
 * Copyright 2008 Google Inc.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.google.gwt.dom.client;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * The Node interface is the primary datatype for the entire Document Object
 * Model. It represents a single node in the document tree. While all objects
 * implementing the Node interface expose methods for dealing with children, not
 * all objects implementing the Node interface may have children.
 */
public class Node extends JavaScriptObject {

  /**
   * The node is an {@link Element}.
   */
  public static final short ELEMENT_NODE = 1;

  /**
   * The node is a {@link Text} node.
   */
  public static final short TEXT_NODE = 3;

  /**
   * The node is a {@link Document}.
   */
  public static final short DOCUMENT_NODE = 9;

  protected Node() {
  }

  /**
   * Adds the node newChild to the end of the list of children of this node. If
   * the newChild is already in the tree, it is first removed.
   * 
   * @param newChild The node to add
   * @return The node added
   */
  public final native Node appendChild(Node newChild) /*-{
    return this.appendChild(newChild);
  }-*/;

  /**
   * Returns a duplicate of this node, i.e., serves as a generic copy
   * constructor for nodes. The duplicate node has no parent; (parentNode is
   * null.).
   * 
   * Cloning an Element copies all attributes and their values, including those
   * generated by the XML processor to represent defaulted attributes, but this
   * method does not copy any text it contains unless it is a deep clone, since
   * the text is contained in a child Text node. Cloning an Attribute directly,
   * as opposed to be cloned as part of an Element cloning operation, returns a
   * specified attribute (specified is true). Cloning any other type of node
   * simply returns a copy of this node.
   * 
   * @param deep If true, recursively clone the subtree under the specified
   *          node; if false, clone only the node itself (and its attributes, if
   *          it is an {@link Element})
   * @return The duplicate node
   */
  public final native Node cloneNode(boolean deep) /*-{
    return this.cloneNode(deep);
  }-*/;

  /**
   * A NodeList that contains all children of this node. If there are no
   * children, this is a NodeList containing no nodes.
   */
  public final native NodeList<Node> getChildNodes() /*-{
    return this.childNodes;
  }-*/;

  /**
   * The first child of this node. If there is no such node, this returns null.
   */
  public final native Node getFirstChild() /*-{
    return this.firstChild;
  }-*/;

  /**
   * The last child of this node. If there is no such node, this returns null.
   */
  public final native Node getLastChild() /*-{
    return this.lastChild;
  }-*/;

  /**
   * The node immediately following this node. If there is no such node, this
   * returns null.
   */
  public final native Node getNextSibling() /*-{
    return this.nextSibling;
  }-*/;

  /**
   * The name of this node, depending on its type; see the table above.
   */
  public final native String getNodeName() /*-{
    return this.nodeName;
  }-*/;

  /**
   * A code representing the type of the underlying object, as defined above.
   */
  public final native short getNodeType() /*-{
    return this.nodeType;
  }-*/;

  /**
   * The value of this node, depending on its type; see the table above. When it
   * is defined to be null, setting it has no effect.
   */
  public final native String getNodeValue() /*-{
    return this.nodeValue;
  }-*/;

  /**
   * The Document object associated with this node. This is also the
   * {@link Document} object used to create new nodes.
   */
  public final native Document getOwnerDocument() /*-{
    return this.ownerDocument;
  }-*/;

  /**
   * The parent of this node. All nodes except Document may have a parent.
   * However, if a node has just been created and not yet added to the tree, or
   * if it has been removed from the tree, this is null.
   */
  public final native Node getParentNode() /*-{
    return this.parentNode;
  }-*/;

  /**
   * The node immediately preceding this node. If there is no such node, this
   * returns null.
   */
  public final native Node getPreviousSibling() /*-{
    return this.previousSibling;
  }-*/;

  /**
   * Returns whether this node has any children.
   */
  public final native boolean hasChildNodes() /*-{
    return this.hasChildNodes();
  }-*/;

  /**
   * Inserts the node newChild before the existing child node refChild. If
   * refChild is null, insert newChild at the end of the list of children.
   * 
   * @param newChild The node to insert
   * @param refChild The reference node, i.e., the node before which the new
   *          node must be inserted
   * @return The node being inserted
   */
  public final native Node insertBefore(Node newChild, Node refChild) /*-{
    return this.insertBefore(newChild, refChild);
  }-*/;

  /**
   * Removes the child node indicated by oldChild from the list of children, and
   * returns it.
   * 
   * @param oldChild The node being removed
   * @return The node removed
   */
  public final native Node removeChild(Node oldChild) /*-{
    return this.removeChild(oldChild);
  }-*/;

  /**
   * Replaces the child node oldChild with newChild in the list of children, and
   * returns the oldChild node.
   * 
   * @param newChild The new node to put in the child list
   * @param oldChild The node being replaced in the list
   * @return The node replaced
   */
  public final native Node replaceChild(Node newChild, Node oldChild) /*-{
    return this.replaceChild(newChild, oldChild);
  }-*/;

  /**
   * The value of this node, depending on its type; see the table above. When it
   * is defined to be null, setting it has no effect.
   */
  public final native void setNodeValue(String nodeValue) /*-{
    this.nodeValue = nodeValue;
  }-*/;
}

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

/**
 * Form control.
 * 
 * Note: Depending upon the environment in which the page is being viewed, the
 * value property may be read-only for the file upload input type. For the
 * "password" input type, the actual value returned may be masked to prevent
 * unauthorized use.
 * 
 * @see http://www.w3.org/TR/1999/REC-html401-19991224/interact/forms.html#edef-INPUT
 */
public class InputElement extends Element {

  /**
   * Assert that the given {@link Element} is compatible with this class and
   * automatically typecast it.
   */
  public static InputElement as(Element elem) {
    assert elem.getTagName().equalsIgnoreCase("input");
    return (InputElement) elem;
  }

  protected InputElement() {
  }

  /**
   * Removes keyboard focus from this element.
   */
  public final native void blur() /*-{
    this.blur();
  }-*/;

  /**
   * Simulate a mouse-click. For INPUT elements whose type attribute has one of
   * the following values: "button", "checkbox", "radio", "reset", or "submit".
   */
  public final native void click() /*-{
    this.click;
  }-*/;

  /**
   * Gives keyboard focus to this element.
   */
  public final native void focus() /*-{
    this.focus();
  }-*/;

  /**
   * A comma-separated list of content types that a server processing this form
   * will handle correctly.
   * 
   * @see http://www.w3.org/TR/1999/REC-html401-19991224/interact/forms.html#adef-accept
   */
  public final native String getAccept() /*-{
    return this.accept;
  }-*/;

  /**
   * A single character access key to give access to the form control.
   * 
   * @see http://www.w3.org/TR/1999/REC-html401-19991224/interact/forms.html#adef-accesskey
   */
  public final native String getAccessKey() /*-{
    return this.accessKey;
  }-*/;

  /**
   * Alternate text for user agents not rendering the normal content of this
   * element.
   * 
   * @see http://www.w3.org/TR/1999/REC-html401-19991224/struct/objects.html#adef-alt
   */
  public final native String getAlt() /*-{
    return this.alt;
  }-*/;

  /**
   * When the type attribute of the element has the value "text", "file" or
   * "password", this represents the HTML value attribute of the element. The
   * value of this attribute does not change if the contents of the
   * corresponding form control, in an interactive user agent, changes.
   * 
   * @see http://www.w3.org/TR/1999/REC-html401-19991224/interact/forms.html#adef-value-INPUT
   */
  public final native String getDefaultValue() /*-{
    return this.defaultValue;
  }-*/;

  /**
   * Returns the FORM element containing this control. Returns null if this
   * control is not within the context of a form.
   */
  public final native FormElement getForm() /*-{
    return this.form;
  }-*/;

  /**
   * Maximum number of characters for text fields, when type has the value
   * "text" or "password".
   * 
   * @see http://www.w3.org/TR/1999/REC-html401-19991224/interact/forms.html#adef-maxlength
   */
  public final native int getMaxLength() /*-{
    return this.maxLength;
  }-*/;

  /**
   * Form control or object name when submitted with a form.
   * 
   * @see http://www.w3.org/TR/1999/REC-html401-19991224/interact/forms.html#adef-name-INPUT
   */
  public final native String getName() /*-{
    return this.name;
  }-*/;

  /**
   * Size information. The precise meaning is specific to each type of field.
   * 
   * @see http://www.w3.org/TR/1999/REC-html401-19991224/interact/forms.html#adef-size-INPUT
   */
  public final native int getSize() /*-{
    return this.size;
  }-*/;

  /**
   * When the type attribute has the value "image", this attribute specifies the
   * location of the image to be used to decorate the graphical submit button.
   * 
   * @see http://www.w3.org/TR/1999/REC-html401-19991224/interact/forms.html#adef-src
   */
  public final native String getSrc() /*-{
    return this.src;
  }-*/;

  /**
   * Index that represents the element's position in the tabbing order.
   * 
   * @see http://www.w3.org/TR/1999/REC-html401-19991224/interact/forms.html#adef-tabindex
   */
  public final native int getTabIndex() /*-{
    return this.tabIndex;
  }-*/;

  /**
   * The type of control created (all lower case).
   * 
   * @see http://www.w3.org/TR/1999/REC-html401-19991224/interact/forms.html#adef-type-INPUT
   */
  public final native String getType() /*-{
    return this.type;
  }-*/;

  /**
   * When the type attribute of the element has the value "text", "file" or
   * "password", this represents the current contents of the corresponding form
   * control, in an interactive user agent. Changing this attribute changes the
   * contents of the form control, but does not change the value of the HTML
   * value attribute of the element. When the type attribute of the element has
   * the value "button", "hidden", "submit", "reset", "image", "checkbox" or
   * "radio", this represents the HTML value attribute of the element.
   * 
   * @see http://www.w3.org/TR/1999/REC-html401-19991224/interact/forms.html#adef-value-INPUT
   */
  public final native String getValue() /*-{
    return this.value;
  }-*/;

  /**
   * When the type attribute of the element has the value "radio" or "checkbox",
   * this represents the current state of the form control, in an interactive
   * user agent. Changes to this attribute change the state of the form control,
   * but do not change the value of the HTML checked attribute of the INPUT
   * element.
   * 
   * Note: During the handling of a click event on an input element with a type
   * attribute that has the value "radio" or "checkbox", some implementations
   * may change the value of this property before the event is being dispatched
   * in the document. If the default action of the event is canceled, the value
   * of the property may be changed back to its original value. This means that
   * the value of this property during the handling of click events is
   * implementation dependent.
   */
  public final native boolean isChecked() /*-{
    return this.checked;
  }-*/;

  /**
   * When type has the value "radio" or "checkbox", this represents the HTML
   * checked attribute of the element. The value of this attribute does not
   * change if the state of the corresponding form control, in an interactive
   * user agent, changes.
   * 
   * @see http://www.w3.org/TR/1999/REC-html401-19991224/interact/forms.html#adef-checked
   */
  public final native boolean isDefaultChecked() /*-{
    return this.defaultChecked;
  }-*/;

  /**
   * The control is unavailable in this context.
   * 
   * @see http://www.w3.org/TR/1999/REC-html401-19991224/interact/forms.html#adef-disabled
   */
  public final native boolean isDisabled() /*-{
    return this.disabled;
  }-*/;

  /**
   * This control is read-only. Relevant only when type has the value "text" or
   * "password".
   * 
   * @see http://www.w3.org/TR/1999/REC-html401-19991224/interact/forms.html#adef-readonly
   */
  public final native boolean isReadOnly() /*-{
    return this.readOnly;
  }-*/;

  /**
   * Use client-side image map.
   * 
   * @see http://www.w3.org/TR/1999/REC-html401-19991224/struct/objects.html#adef-usemap
   */
  public final native boolean useMap() /*-{
    return this.useMap;
  }-*/;

  /**
   * Select the contents of the text area. For INPUT elements whose type
   * attribute has one of the following values: "text", "file", or "password".
   */
  public final native void select() /*-{
    this.select();
  }-*/;

  /**
   * A comma-separated list of content types that a server processing this form
   * will handle correctly.
   * 
   * @see http://www.w3.org/TR/1999/REC-html401-19991224/interact/forms.html#adef-accept
   */
  public final native void setAccept(String accept) /*-{
    this.accept = accept;
  }-*/;

  /**
   * A single character access key to give access to the form control.
   * 
   * @see http://www.w3.org/TR/1999/REC-html401-19991224/interact/forms.html#adef-accesskey
   */
  public final native void setAccessKey(String accessKey) /*-{
    this.accessKey = accessKey;
  }-*/;

  /**
   * Alternate text for user agents not rendering the normal content of this
   * element.
   * 
   * @see http://www.w3.org/TR/1999/REC-html401-19991224/struct/objects.html#adef-alt
   */
  public final native void setAlt(String alt) /*-{
    this.alt = alt;
  }-*/;

  /**
   * When the type attribute of the element has the value "radio" or "checkbox",
   * this represents the current state of the form control, in an interactive
   * user agent. Changes to this attribute change the state of the form control,
   * but do not change the value of the HTML checked attribute of the INPUT
   * element.
   * 
   * Note: During the handling of a click event on an input element with a type
   * attribute that has the value "radio" or "checkbox", some implementations
   * may change the value of this property before the event is being dispatched
   * in the document. If the default action of the event is canceled, the value
   * of the property may be changed back to its original value. This means that
   * the value of this property during the handling of click events is
   * implementation dependent.
   */
  public final native void setChecked(boolean checked) /*-{
    this.checked = checked;
  }-*/;

  /**
   * When type has the value "radio" or "checkbox", this represents the HTML
   * checked attribute of the element. The value of this attribute does not
   * change if the state of the corresponding form control, in an interactive
   * user agent, changes.
   * 
   * @see http://www.w3.org/TR/1999/REC-html401-19991224/interact/forms.html#adef-checked
   */
  public final native void setDefaultChecked(boolean defaultChecked) /*-{
    this.defaultChecked = defaultChecked;
  }-*/;

  /**
   * When the type attribute of the element has the value "text", "file" or
   * "password", this represents the HTML value attribute of the element. The
   * value of this attribute does not change if the contents of the
   * corresponding form control, in an interactive user agent, changes.
   * 
   * @see http://www.w3.org/TR/1999/REC-html401-19991224/interact/forms.html#adef-value-INPUT
   */
  public final native void setDefaultValue(String defaultValue) /*-{
    this.defaultValue = defaultValue;
  }-*/;

  /**
   * The control is unavailable in this context.
   * 
   * @see http://www.w3.org/TR/1999/REC-html401-19991224/interact/forms.html#adef-disabled
   */
  public final native void setDisabled(boolean disabled) /*-{
    this.disabled = disabled;
  }-*/;

  /**
   * Maximum number of characters for text fields, when type has the value
   * "text" or "password".
   * 
   * @see http://www.w3.org/TR/1999/REC-html401-19991224/interact/forms.html#adef-maxlength
   */
  public final native void setMaxLength(int maxLength) /*-{
    this.maxLength = maxLength;
  }-*/;

  /**
   * Form control or object name when submitted with a form.
   * 
   * @see http://www.w3.org/TR/1999/REC-html401-19991224/interact/forms.html#adef-name-INPUT
   */
  public final native void setName(String name) /*-{
    this.name = name;
  }-*/;

  /**
   * This control is read-only. Relevant only when type has the value "text" or
   * "password".
   * 
   * @see http://www.w3.org/TR/1999/REC-html401-19991224/interact/forms.html#adef-readonly
   */
  public final native void setReadOnly(boolean readOnly) /*-{
    this.readOnly = readOnly;
  }-*/;

  /**
   * Size information. The precise meaning is specific to each type of field.
   * 
   * @see http://www.w3.org/TR/1999/REC-html401-19991224/interact/forms.html#adef-size-INPUT
   */
  public final native void setSize(int size) /*-{
    this.size = size;
  }-*/;

  /**
   * When the type attribute has the value "image", this attribute specifies the
   * location of the image to be used to decorate the graphical submit button.
   * 
   * @see http://www.w3.org/TR/1999/REC-html401-19991224/interact/forms.html#adef-src
   */
  public final native void setSrc(String src) /*-{
    this.src = src;
  }-*/;

  /**
   * Index that represents the element's position in the tabbing order.
   * 
   * @see http://www.w3.org/TR/1999/REC-html401-19991224/interact/forms.html#adef-tabindex
   */
  public final native void setTabIndex(int tabIndex) /*-{
    this.tabIndex = tabIndex;
  }-*/;

  /**
   * Use client-side image map.
   * 
   * @see http://www.w3.org/TR/1999/REC-html401-19991224/struct/objects.html#adef-usemap
   */
  public final native void setUseMap(boolean useMap) /*-{
    this.useMap = useMap;
  }-*/;

  /**
   * When the type attribute of the element has the value "text", "file" or
   * "password", this represents the current contents of the corresponding form
   * control, in an interactive user agent. Changing this attribute changes the
   * contents of the form control, but does not change the value of the HTML
   * value attribute of the element. When the type attribute of the element has
   * the value "button", "hidden", "submit", "reset", "image", "checkbox" or
   * "radio", this represents the HTML value attribute of the element.
   * 
   * @see http://www.w3.org/TR/1999/REC-html401-19991224/interact/forms.html#adef-value-INPUT
   */
  public final native void setValue(String value) /*-{
    this.value = value;
  }-*/;
}

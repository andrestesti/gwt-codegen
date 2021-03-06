/*
 * Copyright 2013 Google Inc.
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
package com.google.gwt.sample.hellorebinding.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.sample.hellorebinding.client.util.JsniUtil;
import com.google.gwt.sample.hellorebinding.client.util.Strings;
import com.google.gwt.sample.hellorebinding.client.util.UiBinders;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

/**
 * Main view.
 * This class contains examples of rebinding methods invocations.
 */
public class MainWidget extends Composite {
  
  private static final String APP_NAME = "HelloRebinding";
      
  public MainWidget() {
    /*
     * No boilerplate required to bind user interfaces.
     */
    initWidget(UiBinders.createAndBindUi(Widget.class, MainWidget.class, this));
  }
  
  @UiField
  TextBox name;  
  
  @UiHandler("sayHello")
  void clickSayHello(ClickEvent e) {
    if (name.getValue().isEmpty()) {
      alert("Please, enter your name");
    } else {
      /*
       * The StringFormatterGenerator processes the format String in compile time.
       * See the generated files.
       */
      String message = 
          Strings.format("Hello %s, you are welcome to %s app.", name.getValue(), APP_NAME);
      alert(message);
    }
  }
  
  private void alert(String message) {
    /**
     * Easy definition of JSNI snippets.
     */
    JsniUtil.jsni("$wnd.alert(#)", message);
  }
}

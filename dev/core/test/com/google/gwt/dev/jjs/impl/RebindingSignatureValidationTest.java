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
package com.google.gwt.dev.jjs.impl;

import com.google.gwt.core.ext.TreeLogger;
import com.google.gwt.core.ext.UnableToCompleteException;
import com.google.gwt.dev.javac.testing.impl.MockJavaResource;
import com.google.gwt.dev.util.UnitTestTreeLogger;

/**
 * Tests validation of rebinding method signature.
 */
public class RebindingSignatureValidationTest extends JJSTestBase {
  
  public void testTypeParamAlreadyDefined() {
    sourceOracle.addOrReplace(new MockJavaResource("test.TypeParamAlreadyDefined") {
      @Override
      public CharSequence getContent() {
        StringBuffer code = new StringBuffer();
        code.append("package test;\n");
        code.append("import com.google.gwt.core.shared.Rebind;\n");
        code.append("public class TypeParamAlreadyDefined {\n");
        code.append("  @Rebind(type = String.class)\n");
        code.append("  public void foo(@Rebind.Type final Class<?> t) {}\n");
        code.append("}\n");
        return code;
      }
    });
    UnitTestTreeLogger logger;
    {
      UnitTestTreeLogger.Builder builder = new UnitTestTreeLogger.Builder();
      builder.setLowestLogLevel(TreeLogger.ERROR);
      builder.expectError("Errors in 'test/TypeParamAlreadyDefined.java'", null);
      builder.expectError("Line 5: Type parameter already defined in @Rebind annotation", null);
      logger = builder.createLogger();
      this.logger = logger;
    }

    try {
      compileSnippet("void", "new TypeParamAlreadyDefined();");
      fail("Expected compilation to fail");
    } catch (UnableToCompleteException e) {
      // expected
    }

    logger.assertCorrectLogEntries();
  }
  
  public void testTooMuchTypeParams() {
    sourceOracle.addOrReplace(new MockJavaResource("test.TooMuchTypeParams") {
      @Override
      public CharSequence getContent() {
        StringBuffer code = new StringBuffer();
        code.append("package test;\n");
        code.append("import com.google.gwt.core.shared.Rebind;\n");
        code.append("import com.google.gwt.core.shared.Rebind.Type;\n");
        code.append("public class TooMuchTypeParams {\n");
        code.append("  @Rebind\n");
        code.append("  public void foo(@Type final Class<?> t0, @Type final Class<?> t1) {}\n");
        code.append("}\n");
        return code;
      }
    });
    UnitTestTreeLogger logger;
    {
      UnitTestTreeLogger.Builder builder = new UnitTestTreeLogger.Builder();
      builder.setLowestLogLevel(TreeLogger.ERROR);
      builder.expectError("Errors in 'test/TooMuchTypeParams.java'", null);
      builder.expectError("Line 6: Too much type parameters", null);
      logger = builder.createLogger();
      this.logger = logger;
    }

    try {
      compileSnippet("void", "new TooMuchTypeParams();");
      fail("Expected compilation to fail");
    } catch (UnableToCompleteException e) {
      // expected
    }

    logger.assertCorrectLogEntries();
  }
   
  public void testBadCtorParamOverride() {
    sourceOracle.addOrReplace(new MockJavaResource("test.BadCtorParamOverride") {
      @Override
      public CharSequence getContent() {
        StringBuffer code = new StringBuffer();
        code.append("package test;\n");
        code.append("import com.google.gwt.core.shared.Rebind;\n");
        code.append("import com.google.gwt.core.shared.Rebind.Param;\n");
        code.append("public interface BadCtorParamOverride {\n");
        code.append("  @Rebind(type = String.class)");
        code.append("  void foo(@Param int p0, @Param boolean p1);\n");
        code.append("}\n");
        return code;
      }
    });
    sourceOracle.addOrReplace(new MockJavaResource("test.BadCtorParamOverrideImpl") {
      @Override
      public CharSequence getContent() {
        StringBuffer code = new StringBuffer();
        code.append("package test;\n");
        code.append("import com.google.gwt.core.shared.Rebind;\n");
        code.append("public class BadCtorParamOverrideImpl implements BadCtorParamOverride {\n");
        code.append("  @Rebind(type = String.class)\n");
        code.append("  public void foo(@Rebind.Param final int p0, boolean p1) {}\n");
        code.append("}\n");
        return code;
      }
    });  
    UnitTestTreeLogger logger;
    {
      UnitTestTreeLogger.Builder builder = new UnitTestTreeLogger.Builder();
      builder.setLowestLogLevel(TreeLogger.ERROR);
      builder.expectError("Errors in 'test/BadCtorParamOverrideImpl.java'", null);
      builder.expectError(
          "Line 5: Overriding method must complain the rebinding method signature", null);
      logger = builder.createLogger();
      this.logger = logger;
    }

    try {
      compileSnippet("void", "new BadCtorParamOverrideImpl();");
      fail("Expected compilation to fail");
    } catch (UnableToCompleteException e) {
      // expected
    }

    logger.assertCorrectLogEntries();
  }
  
  public void testBadTypeParamOverride() {
    sourceOracle.addOrReplace(new MockJavaResource("test.BadTypeParamOverride") {
      @Override
      public CharSequence getContent() {
        StringBuffer code = new StringBuffer();
        code.append("package test;\n");
        code.append("import com.google.gwt.core.shared.Rebind;\n");
        code.append("public interface BadTypeParamOverride {\n");
        code.append("  @Rebind\n");
        code.append("  void foo(@Rebind.Type Class<?> type);\n");
        code.append("}\n");
        return code;
      }
    });
    sourceOracle.addOrReplace(new MockJavaResource("test.BadTypeParamOverrideImpl") {
      @Override
      public CharSequence getContent() {
        StringBuffer code = new StringBuffer();
        code.append("package test;\n");
        code.append("import com.google.gwt.core.shared.Rebind;\n");
        code.append("public class BadTypeParamOverrideImpl implements BadTypeParamOverride {\n");
        code.append("  @Rebind(type = Integer.class)");
        code.append("  public void foo(@Rebind.Param final Class<?> type) {}\n");
        code.append("}\n");
        return code;
      }
    });  
    UnitTestTreeLogger logger;
    {
      UnitTestTreeLogger.Builder builder = new UnitTestTreeLogger.Builder();
      builder.setLowestLogLevel(TreeLogger.ERROR);
      builder.expectError("Errors in 'test/BadTypeParamOverrideImpl.java'", null);
      builder.expectError(
          "Line 4: Overriding method must complain the rebinding method signature", null);
      logger = builder.createLogger();
      this.logger = logger;
    }

    try {
      compileSnippet("void", "new BadTypeParamOverrideImpl();");
      fail("Expected compilation to fail");
    } catch (UnableToCompleteException e) {
      // expected
    }

    logger.assertCorrectLogEntries();
  }
  
  public void testBadTypeOverride() {
    sourceOracle.addOrReplace(new MockJavaResource("test.BadTypeOverride") {
      @Override
      public CharSequence getContent() {
        StringBuffer code = new StringBuffer();
        code.append("package test;\n");
        code.append("import com.google.gwt.core.shared.Rebind;\n");
        code.append("public interface BadTypeOverride {\n");
        code.append("  @Rebind(type = String.class)");
        code.append("  void foo(@Rebind.Param int p);\n");
        code.append("}\n");
        return code;
      }
    });
    sourceOracle.addOrReplace(new MockJavaResource("test.BadTypeOverrideImpl") {
      @Override
      public CharSequence getContent() {
        StringBuffer code = new StringBuffer();
        code.append("package test;\n");
        code.append("import com.google.gwt.core.shared.Rebind;\n");
        code.append("public class BadTypeOverrideImpl implements BadTypeOverride {\n");
        code.append("  @Rebind(type = Integer.class)");
        code.append("  public void foo(@Rebind.Param final int p) {}\n");
        code.append("}\n");
        return code;
      }
    });  
    UnitTestTreeLogger logger;
    {
      UnitTestTreeLogger.Builder builder = new UnitTestTreeLogger.Builder();
      builder.setLowestLogLevel(TreeLogger.ERROR);
      builder.expectError("Errors in 'test/BadTypeOverrideImpl.java'", null);
      builder.expectError(
          "Line 4: Overriding method must complain the rebinding method signature", null);
      logger = builder.createLogger();
      this.logger = logger;
    }

    try {
      compileSnippet("void", "new BadTypeOverrideImpl();");
      fail("Expected compilation to fail");
    } catch (UnableToCompleteException e) {
      // expected
    }

    logger.assertCorrectLogEntries();
  }
}

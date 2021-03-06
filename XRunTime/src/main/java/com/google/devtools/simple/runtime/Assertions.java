/*
 * Copyright 2009 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.devtools.simple.runtime;

import com.google.devtools.simple.runtime.annotations.SimpleFunction;
import com.google.devtools.simple.runtime.annotations.SimpleObject;
import com.google.devtools.simple.runtime.errors.AssertionFailure;
import com.google.devtools.simple.runtime.variants.Variant;

/**
 * Assertions allow test against assumptions about the runtime state of an
 * application. A failing assertion will result in an {@link AssertionFailure}
 * runtime error.
 * 
 * @author Herbert Czymontek
 */
@SimpleObject
public class Assertions {

  private Assertions() {
  }

  /**
   * Tests whether an assertion is true. Evaluates the given expression and
   * causes an {@link AssertionFailure} runtime error if the expression does
   * not evaluate to {@code True}.
   * 
   * @param expression  expression to test
   */
  @SimpleFunction
  public static void AssertTrue(Variant expression) {
    if (!expression.getBoolean()) {
      throw new AssertionFailure();
    }
  }

  /**
   * Tests whether an assertion is false. Evaluates the given expression and
   * causes an {@link AssertionFailure} runtime error if the expression does
   * not evaluate to {@code False}.
   * 
   * @param expression  expression to test
   */
  @SimpleFunction
  public static void AssertFalse(Variant expression) {
    if (expression.getBoolean()) {
      throw new AssertionFailure();
    }
  }
}

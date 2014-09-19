/*
 *
 *  * Copyright 2014 Orient Technologies.
 *  *
 *  * Licensed under the Apache License, Version 2.0 (the "License");
 *  * you may not use this file except in compliance with the License.
 *  * You may obtain a copy of the License at
 *  *
 *  *      http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  * See the License for the specific language governing permissions and
 *  * limitations under the License.
 *
 */

package com.orientechnologies.test;

import org.testng.annotations.Test;

import com.orientechnologies.orient.core.Orient;
import com.orientechnologies.orient.core.db.document.ODatabaseDocument;
import com.orientechnologies.orient.core.db.document.ODatabaseDocumentTx;

/**
 * Created by enricorisa on 19/09/14.
 */
@Test
public abstract class BaseLuceneTest {

  protected ODatabaseDocument databaseDocumentTx;
  private static String       url;
  static {
    String buildDirectory = System.getProperty("buildDirectory", ".");
    if (buildDirectory == null)
      buildDirectory = ".";

    url = "plocal:" + buildDirectory + "/test-db";

  }

  @Test(enabled = false)
  public void initDB() {

    databaseDocumentTx = new ODatabaseDocumentTx(url);
    if (!databaseDocumentTx.exists()) {
      databaseDocumentTx = Orient.instance().getDatabaseFactory().createDatabase("graph", url);
      databaseDocumentTx.create();
    } else {
      databaseDocumentTx.open("admin", "admin");
    }
  }

  @Test(enabled = false)
  public void deInitDB() {
    databaseDocumentTx.drop();
  }
}
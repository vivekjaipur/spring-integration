/*
 * Copyright 2002-2016 the original author or authors.
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

package org.springframework.integration.jms.config;

import java.io.File;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Before;

/**
 * @author Oleg Zhurakousky
 * @author Gary Russell
 *
 */
public class ActiveMqTestUtils {

	private static final Log logger = LogFactory.getLog(ActiveMqTestUtils.class);


	private ActiveMqTestUtils() {
		super();
	}

	@Before
	public static void prepare() {
		logger.info("####### Refreshing ActiveMq ########");
		File activeMqTempDir = new File("activemq-data");
		deleteDir(activeMqTempDir);
	}

	private static void deleteDir(File directory) {
		if (directory.exists()) {
			String[] children = directory.list();
			if (children != null) {
				 for (int i = 0; i < children.length; i++) {
			         deleteDir(new File(directory, children[i]));
			     }
			}
		}
		directory.delete();
	}

}

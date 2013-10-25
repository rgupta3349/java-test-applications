/*
 * Copyright 2013 the original author or authors.
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

package com.gopivotal.cloudfoundry.test;

import com.gopivotal.cloudfoundry.test.ApplicationConfiguration;
import com.gopivotal.cloudfoundry.test.core.InitializationUtils;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.ApplicationContext;

import play.Application;
import play.GlobalSettings;

public class ApplicationGlobal extends GlobalSettings {

    private ApplicationContext applicationContext;

    @Override
    public void onStart(Application application) {
        new InitializationUtils().fail();
        applicationContext = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
    }

    @Override
    public <A> A getControllerInstance(Class<A> clazz) {
        return applicationContext.getBean(clazz);
    }
}

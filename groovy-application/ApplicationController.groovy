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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gopivotal.cloudfoundry.test.core.DataSourceUtils
import com.gopivotal.cloudfoundry.test.core.RuntimeUtils

@RestController
class ApplicationController {

    def dataSource

    def dataSourceUtils

    def runtimeUtils

    @Autowired
    ApplicationController(DataSource dataSource, DataSoourceUtils dataSourceUtils, RuntimeUtils runtimeUtils) {
        this.dataSource = dataSource
        this.dataSourceUtils = dataSourceUtils
        this.runtimeUtils = runtimeUtils
    }

    @RequestMapping(method = RequestMethod.GET, value = "/class-path")
    def classPath() {
        return this.runtimeUtils.classPath()
    }

    @RequestMapping(method = RequestMethod.GET, value = "/datasource-classname")
    def dataSourceClassName() {
        return this.dataSourceUtils.getClassName(this.datasource)
    }

    @RequestMapping(method = RequestMethod.GET, value = "/environment-variables")
    def environmentVariables() {
        return this.runtimeUtils.environmentVariables()
    }

    @RequestMapping(method = RequestMethod.GET, value = "/input-arguments")
    def inputArguments() {
        return this.runtimeUtils.inputArguments()
    }

    @RequestMapping(method = RequestMethod.GET, value = "/system-properties")
    def systemProperties() {
        return this.runtimeUtils.systemProperties()
    }

}

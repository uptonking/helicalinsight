/**
 *    Copyright (C) 2013-2017 Helical IT Solutions (http://www.helicalinsight.com) - All rights reserved.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package com.helicalinsight.datasource;

import com.google.gson.JsonObject;
import com.helicalinsight.efw.ApplicationProperties;
import com.helicalinsight.efw.framework.utils.ApplicationContextAccessor;
import net.sf.json.JSONObject;


/**
 * Created by author on 19-01-2015.
 *
 * @author Rajasekhar
 */
@SuppressWarnings("unused")
public class GlobalJdbcDataSource implements IDriver {

    @Override
    public JsonObject getJSONData(JSONObject requestParameterJson, JSONObject connectionDetails,
                                  JSONObject dataMapTagContent, ApplicationProperties applicationProperties) {
        String httpData = requestParameterJson.toString();
        String connectionInfo = connectionDetails.toString();
        String dataMapTag = dataMapTagContent.toString();

        IEfwdService efwdService = ApplicationContextAccessor.getBean(IEfwdService.class);
        return efwdService.execute(httpData, connectionInfo, dataMapTag, applicationProperties);
    }

    @Override
    public String getQuery(JSONObject dataMapTagContent, JSONObject requestParameterJson) {
        final EfwdQueryProcessor efwdQueryProcessor = ApplicationContextAccessor.getBean(EfwdQueryProcessor.class);
        return efwdQueryProcessor.getQuery(dataMapTagContent, requestParameterJson);
    }
}


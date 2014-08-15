package com.yammer.backups.util;

/*
 * #%L
 * Backups
 * %%
 * Copyright (C) 2013 - 2014 Microsoft Corporation
 * %%
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
 * #L%
 */

import com.google.common.base.Function;
import com.google.common.base.Throwables;
import com.yammer.collections.azure.Bytes;

import java.io.UnsupportedEncodingException;

public class StringDeserializationFunction implements Function<Bytes, String> {

    public static final Function<Bytes, String> INSTANCE = new StringDeserializationFunction();
    private static final String ENCODING = "UTF-8";

    @Override
    public String apply(Bytes input) {
        try {
            return new String(input.getBytes(), ENCODING);
        } catch (UnsupportedEncodingException e) {
            // shouldn't happen but
            throw Throwables.propagate(e);
        }
    }
}

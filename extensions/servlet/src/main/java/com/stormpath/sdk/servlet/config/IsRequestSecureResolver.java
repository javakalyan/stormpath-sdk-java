/*
 * Copyright 2016 Stormpath, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.stormpath.sdk.servlet.config;

import com.stormpath.sdk.servlet.http.Resolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * A Resolver that takes into account the X-Forwarded-Proto header to determine if the request is secure or not.
 *
 * @since 1.1.0
 */
public class IsRequestSecureResolver implements Resolver<Boolean> {

    private static final String HEADER_FORWARDED_PROTO = "X-Forwarded-Proto";

    private static final String HTTPS = "https";

    @Override
    public Boolean get(HttpServletRequest request, HttpServletResponse response) {
        String protocol = request.getHeader(HEADER_FORWARDED_PROTO);
        return HTTPS.equals(request.getScheme()) || HTTPS.equalsIgnoreCase(protocol);
    }
}
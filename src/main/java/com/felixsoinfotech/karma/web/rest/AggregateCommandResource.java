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

package com.felixsoinfotech.karma.web.rest;
/**
 * TODO Provide a detailed description here 
 * @author Owner
 * sarangibalu, sarangibalu.a@lxisoft.com
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.felixsoinfotech.karma.service.AggregateCommandService;

/**
 * REST controller for managing Activity.
 */
@RestController
@RequestMapping("/api")
public class AggregateCommandResource {
	
	private final Logger log = LoggerFactory.getLogger(AggregateCommandResource.class);

    private static final String ENTITY_NAME = "karmaAggregateCommandResource";

    private AggregateCommandService aggregateCommandService;

	public AggregateCommandResource(AggregateCommandService aggregateCommandService) {
		this.aggregateCommandService=aggregateCommandService;
	}
	
	

}

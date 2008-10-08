/*
 * Copyright 2002-2008 the original author or authors.
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

package org.springframework.integration.config.annotation;

import java.lang.reflect.Method;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.integration.annotation.Splitter;
import org.springframework.integration.message.MessageConsumer;
import org.springframework.integration.splitter.MethodInvokingSplitter;

/**
 * Post-processor for Methods annotated with {@link Splitter @Splitter}.
 *
 * @author Mark Fisher
 */
public class SplitterAnnotationPostProcessor extends AbstractMethodAnnotationPostProcessor<Splitter> {

	public SplitterAnnotationPostProcessor(BeanFactory beanFactory) {
		super(beanFactory);
	}


	@Override
	protected MessageConsumer createConsumer(Object bean, Method method, Splitter annotation) {
		return new MethodInvokingSplitter(bean, method);
	}

}

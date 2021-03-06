/*-
 * #%L
 * Slice - Mapper API
 * %%
 * Copyright (C) 2012 Cognifide Limited
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

package com.cognifide.slice.mapper.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Allows mapper to map all child resources of a parent resource into array, <tt>List</tt>, <tt>Set</tt>,
 * <tt>SortedSet</tt> or <tt>Collection</tt>. When mapping to <tt>SortedSet</tt> child model must implement
 * the <tt>Comparable</tt> interface.<br>
 * The parent resource is the one indicated by the name of the field or {@link JcrProperty}. If the child
 * resource doesn't exist, then the collection will be empty, but never <code>null</code>.
 *
 * <pre>
 * {@code
 * {@literal @}SliceResource
 * public class ExampleModel {
 *
 *   {@literal @}Children(LinkModel.class)
 *   {@literal @}JcrProperty
 *   private List<LinkModel> links;
 *
 * }
 * }
 * </pre>
 *
 * @author Kamil Ciecierski
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Children {
	/**
	 * @return Expected type of models which all child resources will be mapped to. It must be the same as
	 * used in generic type of the collection, or component type for arrays.
	 * 
	 */
	Class<?> value();
}

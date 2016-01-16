/*
 * Copyright (C) 2015 Hannes Dorfmann
 * Copyright (C) 2015 Tickaroo, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.tickaroo.tikxml.processor.field

import com.tickaroo.tikxml.processor.field.access.FieldAccessPolicy
import javax.lang.model.element.VariableElement
import javax.lang.model.type.TypeMirror

/**
 * Represents a Field with [com.tickaroo.tikxml.annotation.Element] annotation
 * @author Hannes Dorfmann
 */
open class PolymorphicElementField(element: VariableElement, name: String, required: Boolean?, val typeElementNameMatcher: List<PolymorphicTypeElementNameMatcher>) : ElementField(element, name, required)

class PolymorphicListElementField(element: VariableElement, name: String, required: Boolean?, typeElementNameMatcher: List<PolymorphicTypeElementNameMatcher>, val inlineList: Boolean) : PolymorphicElementField(element, name, required, typeElementNameMatcher)

data class PolymorphicTypeElementNameMatcher(val xmlElementName: String, val type: TypeMirror)

/**
 * This kind of element will be used to replace a [PolymorphicElementField]
 */
class PolymorphicSubstitutionField(element: VariableElement, override val typeMirror: TypeMirror, override var accessPolicy: FieldAccessPolicy, name: String, required: Boolean? = null) : ElementField(element, name, required)
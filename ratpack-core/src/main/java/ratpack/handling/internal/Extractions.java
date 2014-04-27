/*
 * Copyright 2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package ratpack.handling.internal;

import com.google.common.reflect.TypeToken;
import ratpack.registry.Registry;

import java.util.List;

public abstract class Extractions {

  private Extractions() {
  }

  public static Object[] extract(List<TypeToken<?>> types, Registry registry) {
    Object[] services = new Object[types.size()];
    extract(types, registry, services, 0);
    return services;
  }

  public static void extract(List<TypeToken<?>> types, Registry registry, Object[] services, int startIndex) {
    for (int i = 0; i < types.size(); ++i) {
      TypeToken<?> type = types.get(i);
      Object service = registry.get(type);
      services[i + startIndex] = service;
    }
  }
}

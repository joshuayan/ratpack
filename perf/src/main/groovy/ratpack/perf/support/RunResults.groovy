/*
 * Copyright 2014 the original author or authors.
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

package ratpack.perf.support

import groovy.transform.CompileStatic

@CompileStatic
class RunResults {

  final List<RoundResults> rounds = []

  BigDecimal getAverageBatchTime() {
    BigDecimal total = new BigDecimal(0)
    for (RoundResults round : rounds) {
      for (BigDecimal time : round.batches) {
        total = total.add(time)
      }
    }
    def totalBatches = rounds.sum(0) { RoundResults it -> it.batches.size() } as Integer
    total.divide(new BigDecimal(totalBatches))
  }

}
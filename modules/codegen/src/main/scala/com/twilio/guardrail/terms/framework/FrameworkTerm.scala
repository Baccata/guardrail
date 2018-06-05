package com.twilio.guardrail
package terms.framework

import scala.meta._

sealed trait FrameworkTerm[T]
case class GetFrameworkImports(tracing: Boolean) extends FrameworkTerm[List[Import]]
case class GetFrameworkImplicits() extends FrameworkTerm[Defn.Object]

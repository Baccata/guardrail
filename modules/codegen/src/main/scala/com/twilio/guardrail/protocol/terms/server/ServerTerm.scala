package com.twilio.guardrail.protocol.terms.server

import _root_.io.swagger.models.{ Operation, Path }
import com.twilio.guardrail.generators.{ GeneratorSettings, ScalaParameter }
import com.twilio.guardrail.{ RenderedRoute, ServerRoute, StrictProtocolElems }

import scala.meta._

sealed trait ServerTerm[T]
case class ExtractOperations(paths: List[(String, Path)]) extends ServerTerm[List[ServerRoute]]

case class GetClassName(operation: Operation)                                                  extends ServerTerm[List[String]]
case class BuildTracingFields(operation: Operation, className: List[String], tracing: Boolean) extends ServerTerm[Option[(ScalaParameter, Term)]]
case class GenerateRoute(resourceName: String,
                         basePath: Option[String],
                         route: ServerRoute,
                         tracingFields: Option[(ScalaParameter, Term)],
                         responseDefinitions: List[Defn],
                         protocolElems: List[StrictProtocolElems])
    extends ServerTerm[RenderedRoute]
case class GetExtraRouteParams(tracing: Boolean)                                                       extends ServerTerm[List[Term.Param]]
case class GenerateResponseDefinitions(operation: Operation, protocolElems: List[StrictProtocolElems]) extends ServerTerm[List[Defn]]
case class RenderClass(className: String,
                       handlerName: String,
                       combinedRouteTerms: Term,
                       extraRouteParams: List[Term.Param],
                       responseDefinitions: List[Defn],
                       supportDefinitions: List[Defn])
    extends ServerTerm[Stat]
case class RenderHandler(handlerName: String, methodSigs: List[Decl.Def], handlerDefinitions: List[Stat]) extends ServerTerm[Stat]
case class CombineRouteTerms(terms: List[Term])                                                           extends ServerTerm[Term]
case class GetExtraImports(tracing: Boolean)                                                              extends ServerTerm[List[Import]]

package com.twilio.guardrail.protocol.terms.protocol

import cats.InjectK

class AliasProtocolTerms[F[_]](implicit I: InjectK[AliasProtocolTerm, F]) {}
object AliasProtocolTerms {
  implicit def aliasProtocolTerm[F[_]](implicit I: InjectK[AliasProtocolTerm, F]): AliasProtocolTerms[F] =
    new AliasProtocolTerms[F]
}

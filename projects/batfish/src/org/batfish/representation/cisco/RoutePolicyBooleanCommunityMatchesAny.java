package org.batfish.representation.cisco;

import org.batfish.datamodel.Configuration;
import org.batfish.datamodel.routing_policy.expr.BooleanExpr;
import org.batfish.datamodel.routing_policy.expr.MatchCommunitySet;
import org.batfish.main.Warnings;

public class RoutePolicyBooleanCommunityMatchesAny extends RoutePolicyBoolean {

   private static final long serialVersionUID = 1L;

   private RoutePolicyCommunitySet _commSet;

   public RoutePolicyBooleanCommunityMatchesAny(RoutePolicyCommunitySet commSet) {
      _commSet = commSet;
   }

   public RoutePolicyCommunitySet getCommSet() {
      return _commSet;
   }

   @Override
   public RoutePolicyBooleanType getType() {
      return RoutePolicyBooleanType.COMMUNITY_MATCHES_ANY;
   }

   @Override
   public BooleanExpr toBooleanExpr(CiscoConfiguration cc, Configuration c,
         Warnings w) {
      return new MatchCommunitySet(_commSet.toCommunitySetExpr(cc, c, w));
   }

}

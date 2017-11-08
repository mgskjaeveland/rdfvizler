package osl.rdfvizler.dot.rules;

import org.apache.jena.graph.Node;
import org.apache.jena.rdf.model.ResourceFactory;
import org.apache.jena.reasoner.rulesys.BuiltinException;
import org.apache.jena.reasoner.rulesys.RuleContext;

public class Namespace extends NodeFunction {

    @Override
    public String getName() {
        return "namespace";
    }

    protected Node value(Node node, RuleContext context) {
        if (node.isURI()) {
            return ResourceFactory.createPlainLiteral(node.getNameSpace()).asNode();
        } else {
            throw new BuiltinException(this, context, "Illegal node type: " + node);
        }
    }
}
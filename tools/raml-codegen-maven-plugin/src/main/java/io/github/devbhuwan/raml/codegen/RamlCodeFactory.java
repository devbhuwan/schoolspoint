package io.github.devbhuwan.raml.codegen;

import java.util.List;

class RamlCodeFactory {

    static List<CodeGenerate> codeFactories() {
        return List.of(new RamlToPojoCode(), new RamlToEndpointCode());
    }


}

package io.github.devbhuwan.raml.codegen;

import org.raml.v2.api.model.v10.api.Api;

import java.io.File;

@FunctionalInterface
interface CodeGenerate {
    void generate(Api api, String defaultPackage, File outputDirectory);
}
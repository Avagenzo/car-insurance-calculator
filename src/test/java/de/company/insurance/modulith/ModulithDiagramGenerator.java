package de.company.insurance.modulith;

import org.springframework.modulith.docs.Documenter;
import org.springframework.modulith.core.ApplicationModules;

class ModulithDiagramGenerator {
    public static void main(String[] args) {
        ApplicationModules modules = ApplicationModules.of("de.company.insurance");
        new Documenter(modules)
                .writeDocumentation()
                .writeModulesAsPlantUml();
    }
}

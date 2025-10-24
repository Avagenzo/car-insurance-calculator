package de.company.insurance.modulith;

import org.junit.jupiter.api.Test;
import org.springframework.modulith.core.ApplicationModules;

class ModulithAnalysisTest {

    @Test
    void verifyModularStructure() {
        ApplicationModules modules = ApplicationModules.of("de.company.insurance");
        modules.verify(); // fails test if module boundaries are violated
    }
}
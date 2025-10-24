package de.company.insurance.quote;

public record QuoteRequest(
        int jahresKilometer,
        String fahrzeugtyp,
        String postleitzahl
) {}
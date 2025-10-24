package de.company.insurance.region;

public record RegionRecord(
        String isoCountryCode,
        String isoRegionCode,
        String region1,
        String region2,
        String region3,
        String region4,
        String postleitzahl,
        String ort
) {}
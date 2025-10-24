package de.company.insurance.region;

import com.opencsv.CSVReader;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Repository;

import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;

@Repository
public class RegionRepository {

    private final Resource csvFile;
    private final Map<String, String> postcodeToRegionCode = new HashMap<>();

    public RegionRepository(@Value("${app.regions.csv}") Resource csvFile) {
        this.csvFile = csvFile;
    }

    @PostConstruct
    public void init() {
        try (var reader = new CSVReader(new InputStreamReader(csvFile.getInputStream(), StandardCharsets.UTF_8))) {
            String[] line;
            boolean header = true;
            while ((line = reader.readNext()) != null) {
                if (header) { header = false; continue; }
                String regionCode = clean(line[1]);
                String postcode = clean(line[6]);
                if (!postcode.isEmpty() && !regionCode.isEmpty()) {
                    postcodeToRegionCode.put(postcode, regionCode);
                }
            }
            System.out.println("Loaded " + postcodeToRegionCode.size() + " postcodes from CSV.");
        } catch (Exception e) {
            throw new RuntimeException("Failed to read postcodes.csv", e);
        }
    }

    public Optional<String> findRegionCodeByPostcode(String postcode) {
        return Optional.ofNullable(postcodeToRegionCode.get(postcode));
    }

    private String clean(String value) {
        return value == null ? "" : value.replaceAll("\"", "").trim();
    }
}

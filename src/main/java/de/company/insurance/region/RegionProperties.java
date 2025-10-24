package de.company.insurance.region;

import org.springframework.boot.context.properties.ConfigurationProperties;
import java.util.Map;

@ConfigurationProperties(prefix = "app.regions")
public class RegionProperties {

    private String csv;
    private Map<String, Double> factors;

    public String getCsv() { return csv; }
    public void setCsv(String csv) { this.csv = csv; }

    public Map<String, Double> getFactors() { return factors; }
    public void setFactors(Map<String, Double> factors) { this.factors = factors; }
}

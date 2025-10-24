package de.company.insurance.region;

import org.springframework.stereotype.Service;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;


@Service
public class RegionService {

    private final RegionRepository regionRepository;
    private final RegionProperties props;

    public RegionService(RegionRepository regionRepository, RegionProperties props) {
        this.regionRepository = regionRepository;
        this.props = props;
    }

    public double getFactorForPostcode(String postcode) {
        var regionCode = regionRepository.findRegionCodeByPostcode(postcode).orElse(null);
        if (regionCode == null) return 1.0;
        String key = regionCode.replace("-", "_"); // matches DE_BW
        return props.getFactors().getOrDefault(key, 1.0);
    }
}

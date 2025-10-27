package de.company.insurance.region;

import de.company.insurance.region.RegionProperties;
import de.company.insurance.region.RegionRepository;
import de.company.insurance.region.RegionService;
import org.junit.jupiter.api.Test;
import java.util.Map;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class RegionServiceTest {

    @Test
    void shouldReturnConfiguredFactorForKnownPostcode() {
        // Arrange
        RegionRepository repo = mock(RegionRepository.class);
        when(repo.findRegionCodeByPostcode("79189")).thenReturn(Optional.of("DE-BW"));

        RegionProperties props = new RegionProperties();
        props.setFactors(Map.of("DE_BW", 1.1, "DE_BY", 1.0));

        RegionService service = new RegionService(repo, props);

        // Act
        double factor = service.getFactorForPostcode("79189");

        // Assert
        assertThat(factor).isEqualTo(1.1);
    }

    @Test
    void shouldReturnDefaultFactorForUnknownPostcode() {
        RegionRepository repo = mock(RegionRepository.class);
        when(repo.findRegionCodeByPostcode("99999")).thenReturn(Optional.empty());

        RegionProperties props = new RegionProperties();
        props.setFactors(Map.of("DE_BW", 1.1));

        RegionService service = new RegionService(repo, props);

        double factor = service.getFactorForPostcode("99999");

        assertThat(factor).isEqualTo(1.0);
    }

    @Test
    void shouldReplaceDashInRegionCodeBeforeLookup() {
        RegionRepository repo = mock(RegionRepository.class);
        when(repo.findRegionCodeByPostcode("12345")).thenReturn(Optional.of("DE-BE"));

        RegionProperties props = new RegionProperties();
        props.setFactors(Map.of("DE_BE", 1.3));

        RegionService service = new RegionService(repo, props);

        double factor = service.getFactorForPostcode("12345");

        assertThat(factor).isEqualTo(1.3);
    }
}
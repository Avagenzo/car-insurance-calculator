package quote;

import de.company.insurance.quote.Quote;
import de.company.insurance.quote.QuoteRepository;
import de.company.insurance.quote.QuoteRequest;
import de.company.insurance.quote.QuoteService;
import de.company.insurance.region.RegionService;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class QuoteServiceTest {

    @Test
    void shouldCalculateCorrectPremium() {
        RegionService regionService = mock(RegionService.class);
        when(regionService.getFactorForPostcode("79189")).thenReturn(1.1);

        QuoteRepository repo = mock(QuoteRepository.class);
        when(repo.save(any())).thenAnswer(invocation -> invocation.getArgument(0));

        QuoteService service = new QuoteService(repo, regionService);

        QuoteRequest req = new QuoteRequest(12000, "SUV", "79189");
        Quote result = service.calculateAndSave(req);

        assertThat(result).isNotNull();
        assertThat(result.getPraemie()).isEqualTo(858.33);
    }
}

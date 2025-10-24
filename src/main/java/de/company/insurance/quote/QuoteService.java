package de.company.insurance.quote;


import de.company.insurance.region.RegionService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class QuoteService {

    private final QuoteRepository repo;
    private final RegionService regionService;

    public QuoteService(QuoteRepository repo, RegionService regionService) {
        this.repo = repo;
        this.regionService = regionService;
    }

    @Transactional
    public Quote calculateAndSave(QuoteRequest req) {
        double kmFactor = req.jahresKilometer() <= 5000 ? 0.5 :
                req.jahresKilometer() <= 10000 ? 2.0 :
                        req.jahresKilometer() <= 20000 ? 1.5 : 2.0;

        double vehicleFactor = switch (req.fahrzeugtyp().toUpperCase()) {
            case "KLEINWAGEN" -> 360.5;
            case "MITTELKLASSE" -> 400.8;
            case "SUV" -> 520.2;
            case "TRANSPORTER" -> 690.5;
            default -> 100;
        };

        double regionFactor = regionService.getFactorForPostcode(req.postleitzahl());
        double praemie = round(kmFactor * vehicleFactor * regionFactor, 2);

        Quote quote = new Quote(
                req.jahresKilometer(),
                req.fahrzeugtyp(),
                req.postleitzahl(),
                praemie
        );

        return repo.save(quote);
    }

    private double round(double value, int scale) {
        return BigDecimal.valueOf(value)
                .setScale(scale, RoundingMode.HALF_UP)
                .doubleValue();
    }

}
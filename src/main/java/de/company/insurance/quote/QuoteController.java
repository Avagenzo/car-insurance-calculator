package de.company.insurance.quote;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/quotes")
public class QuoteController {

    private final QuoteService service;

    public QuoteController(QuoteService service) {
        this.service = service;
    }

    @PostMapping("/calculate")
    public Quote calculate(@RequestBody QuoteRequest req) {
        return service.calculateAndSave(req);
    }

//    @GetMapping
//    public java.util.List<Quote> all() {
//        return service.getAll();
//    }
}


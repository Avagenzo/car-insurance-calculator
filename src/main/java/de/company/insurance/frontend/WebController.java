package de.company.insurance.frontend;

import de.company.insurance.quote.Quote;
import de.company.insurance.quote.QuoteRequest;
import de.company.insurance.quote.QuoteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class WebController {

    private final QuoteService quoteService;

    public WebController(QuoteService quoteService) {
        this.quoteService = quoteService;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("quoteRequest", new QuoteRequest(0, "", ""));
        return "index";
    }

    @PostMapping("/calculate")
    public String calculate(@ModelAttribute QuoteRequest quoteRequest, Model model) {
        Quote quote = quoteService.calculateAndSave(quoteRequest);
        model.addAttribute("quote", quote);
        return "result";
    }

    @GetMapping("/docs")
    public String docs() {
        return "redirect:/docs/index.html";
    }
}

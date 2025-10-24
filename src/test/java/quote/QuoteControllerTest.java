package quote;

import de.company.insurance.CarInsuranceCalculatorApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(classes = CarInsuranceCalculatorApplication.class)
@AutoConfigureMockMvc
class QuoteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldCalculateQuoteSuccessfully() throws Exception {
        String json = """
            {
              "jahresKilometer": 12000,
              "fahrzeugtyp": "SUV",
              "postleitzahl": "79189"
            }
            """;

        mockMvc.perform(post("/api/quotes/calculate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.praemie").value(858.33));
    }
}
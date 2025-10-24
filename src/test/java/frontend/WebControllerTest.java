package frontend;

import de.company.insurance.CarInsuranceCalculatorApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(classes = CarInsuranceCalculatorApplication.class)
@AutoConfigureMockMvc
class WebControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldRenderIndexPage() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"))
                .andExpect(model().attributeExists("quoteRequest"));
    }

    @Test
    void shouldRenderResultPageAfterCalculation() throws Exception {
        mockMvc.perform(post("/calculate")
                        .param("jahresKilometer", "12000")
                        .param("fahrzeugtyp", "SUV")
                        .param("postleitzahl", "79189"))
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attributeExists("quote"))
                .andExpect(xpath("//h1").string("Berechnete Versicherungsprämie"));
    }
}
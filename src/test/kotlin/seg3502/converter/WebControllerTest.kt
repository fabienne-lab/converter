package seg3502.converter

 import org.junit.jupiter.api.Test
 import org.springframework.beans.factory.annotation.Autowired
 import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
 import org.springframework.test.web.servlet.MockMvc
 import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
 import org.springframework.test.web.servlet.result.MockMvcResultMatchers

 @WebMvcTest
 class WebControllerTest {
 @Autowired
 lateinit var mockMvc: MockMvc

 @Test
 
 fun request_to_home() {
 mockMvc.perform(MockMvcRequestBuilders.get("/"))
 .andExpect(MockMvcResultMatchers.status().isOk)
 .andExpect(MockMvcResultMatchers.view().name("home"))
 }

 @Test
 fun celsius_to_fahrenheit_conversion() {
 mockMvc.perform(
 MockMvcRequestBuilders.get("/convert")
 .param("n1", "0")
 .param("n2", "0")
 
 .param("operation", "plus"))
 
 
 .andExpect(MockMvcResultMatchers.status().isOk)
 .andExpect(MockMvcResultMatchers.model().attribute("r", "0.00"))
 .andExpect(MockMvcResultMatchers.view().name("home"))

 }
 }

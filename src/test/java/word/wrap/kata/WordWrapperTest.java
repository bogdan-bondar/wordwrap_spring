package word.wrap.kata;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class WordWrapperTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void postWrap() throws Exception {
        final int maxLineLength = 3;
        final JSONObject wordWrapResource = new JSONObject();
        wordWrapResource.put("line", "word word word");

        mockMvc.perform(MockMvcRequestBuilders.post("/wrap/" + maxLineLength).contentType(MediaType.APPLICATION_JSON)
                .content(wordWrapResource.toString())).andExpect(status().isOk())
                .andExpect(content().string("wor\nd\nwor\nd\nwor\nd"));
    }

}

package com.example;

import com.example.restApis.UserController;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


/**
 * Created by xyfhy on 16/7/28.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MockServletContext.class)
@WebAppConfiguration
//
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserControllerTests {

    private MockMvc mvc;

    @Before
    public void setUp() throws Exception {
        mvc = MockMvcBuilders.standaloneSetup(new UserController()).build();

    }

    @Test
    public void test_A_GetUsers() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/users/"))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("[]")));

    }

    @Test
    public void test_B_PostUser() throws Exception {

        mvc.perform(MockMvcRequestBuilders.post("/users/")
                .param("id", "1")
                .param("name", "NewUser")
                .param("age", "20")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(content().string(equalTo("success")));

        mvc.perform(MockMvcRequestBuilders.get("/users/").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("[{\"id\":1,\"name\":\"NewUser\",\"age\":20}]")));

    }


    @Test
    public void test_C_PutUser() throws Exception {

        mvc.perform(MockMvcRequestBuilders.put("/users/1").param("name", "NewUser").param("age", "32"))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("success")));
    }

    @Test
    public void test_D_GetUser() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/users/1").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("{\"id\":1,\"name\":\"NewUser\",\"age\":32}")));

    }

    @Test
    public void test_E_deleteUser() throws Exception {
        mvc.perform(MockMvcRequestBuilders.delete("/users/1").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("success")));

        mvc.perform(MockMvcRequestBuilders.get("/users/"))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("[]")));

    }
}

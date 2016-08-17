package com.example;


import com.example.dbo.ProductDetailRepository;
import com.example.restApis.ProductDetailController;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by xyfhy on 16/8/2.
 */

@RunWith(MockitoJUnitRunner.class) //  重要!!!!!!
@SpringApplicationConfiguration(classes = MockServletContext.class)
@WebAppConfiguration
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProductDetailControllerTests2 {


    private MockMvc mvc ;

    private final String productDetail = "{\n" +
            "    \"productId\": \"DEF0000\",\n" +
            "    \"productName\": \"MakerBot\",\n" +
            "    \"shortDescription\": \"A product that makes other products\",\n" +
            "    \"longDescription\": \"This is an extended description for a makerbot, which is basically a product that makes other products.\",\n" +
            "    \"inventoryId\": \"00854321\"\n" +
            "}";




    //  重要!!!!!!
    @InjectMocks
    ProductDetailController controller;

    //  重要!!!!!!
    @Mock
    ProductDetailRepository repository;




    @Before
    public void setUp() throws Exception {
//        MockitoAnnotations.initMocks(this);
        mvc = MockMvcBuilders.standaloneSetup(controller).build();

    }


    @Test
    public void test_A_Create() throws Exception {
        mvc.perform(MockMvcRequestBuilders.post("/products/")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .content(productDetail))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("success")));

    }


}

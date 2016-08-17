package com.example;


import com.example.dbo.ProductDetailRepository;
import com.example.entities.ProductDetail;
import com.example.restApis.ProductDetailController;
import io.restassured.RestAssured;
import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;

import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by xyfhy on 16/8/2.
 */

@RunWith(SpringJUnit4ClassRunner.class) //  1 重要!!!!!!
@SpringApplicationConfiguration(classes = Application.class)  // 2
@WebAppConfiguration   // 3
@IntegrationTest("server.port:0")   // 4
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProductDetailControllerTests3 {

    @Autowired
    ProductDetailRepository repository;  // 5

    @Value("${local.server.port}")   // 6
     int port;

    private final String productDetail = "{\n" +
            "    \"productId\": \"DEF0000\",\n" +
            "    \"productName\": \"MakerBot\",\n" +
            "    \"shortDescription\": \"A product that makes other products\",\n" +
            "    \"longDescription\": \"This is an extended description for a makerbot, which is basically a product that makes other products.\",\n" +
            "    \"inventoryId\": \"00854321\"\n" +
            "}";


    ProductDetail mickey;
    ProductDetail minnie;
    ProductDetail pluto;


    @Before
    public void setUp() throws Exception {
        mickey = new ProductDetail();
        mickey.setProductName("Mickey Mouse");
        minnie = new ProductDetail();
        minnie.setProductName("Minnie Mouse");
        pluto = new ProductDetail();
        pluto.setProductName("Pluto");

        // 8
        repository.deleteAll();
        repository.save(Arrays.asList(mickey, minnie, pluto));

        // 9
        RestAssured.port = port;
    }


    // 10
//    @Test
//    public void canFetchMickey() {
//        Integer mickeyId = mickey.getProductId();
//
//        when().
//                get("/products/", mickeyId).
//                then().
//                statusCode(HttpStatus.SC_OK).
//                body("name", Matchers.is("Mickey Mouse")).
//                body("id", Matchers.is(mickeyId));
//    }

    @Test
    public void canFetchAll() {
        when().
                get("/products/").
                then().
                statusCode(HttpStatus.SC_OK).
                body("name", Matchers.hasItems("Mickey Mouse", "Minnie Mouse", "Pluto"));
    }

//    @Test
//    public void canDeletePluto() {
//        Integer plutoId = pluto.getId();
//
//        when()
//                .delete("/characters/{id}", plutoId).
//                then().
//                statusCode(HttpStatus.SC_NO_CONTENT);
//    }
//
//
//    @Test
//    public void test_A_Create() throws Exception {
//        mvc.perform(MockMvcRequestBuilders.post("/products/")
//                .contentType(MediaType.APPLICATION_JSON_UTF8)
//                .accept(MediaType.APPLICATION_JSON_UTF8)
//                .content(productDetail))
//                .andExpect(status().isOk())
//                .andExpect(content().string(equalTo("success")));
//
//    }


}

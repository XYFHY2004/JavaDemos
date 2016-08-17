package com.example;

import com.example.dbo.ProductDetailRepository;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by xyfhy on 16/8/3.
 */
@Configuration
public class TestContext {

    @Bean
    public ProductDetailRepository ProductDetailRepositoryMock() {
        return Mockito.mock(ProductDetailRepository.class);
    }
}

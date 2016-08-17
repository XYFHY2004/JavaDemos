package com.example;

import com.example.dbo.ProductDetailRepository;
import com.example.entities.ProductDetail;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.List;

// @SpringBootApplication 注解跟使用 @Configuration、@EnableAutoConfiguration、@ComponentScan 三个注解一起使用的效果一样,虽然方便但会有以下
// 几方面的副作用: 1、项目启动时间变长 2、会加载多余实例 3、会增加CPU消耗
@SpringBootApplication
public class Application {


	public static void main(String[] args) {


//		SpringApplication.run(Application.class, args);
		ApplicationContext ctx = SpringApplication.run(Application.class, args);

		ProductDetail detail = new ProductDetail();
		detail.setProductName("Dan's Book of Writing");
		detail.setShortDescription("A book about writing books.");
		detail.setLongDescription("In this book about writing books, Dan will show you how to write a book.");
		detail.setInventoryId("009178461");
		ProductDetailRepository repository = ctx.getBean(ProductDetailRepository.class);
		ProductDetail p = repository.save(detail);
//		for (ProductDetail productDetail : repository.findAll()) {
//			System.out.println(productDetail.getProductId());
//		}

	}
}

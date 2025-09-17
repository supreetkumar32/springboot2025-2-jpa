package com.three.jpaTutorial.jpaTuts;

import com.three.jpaTutorial.jpaTuts.entities.ProductEntity;
import com.three.jpaTutorial.jpaTuts.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class JpaTutsApplicationTests {

	@Autowired
	ProductRepository productRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void testRepository(){
		ProductEntity productEntity=ProductEntity.builder()
				.sku("nestle2345")
				.title("Nestle chocolate")
				.price(BigDecimal.valueOf(123.45))
				.quantity(12)
				.build();

		ProductEntity savedProductEntity=productRepository.save(productEntity);
		System.out.println(savedProductEntity);
	}

	@Test
	void getRepository(){
//		List<ProductEntity> entities=productRepository.findAll();
//		List<ProductEntity> entities=productRepository.findByTitle("Pepsi");
//		List<ProductEntity> entities=productRepository.findByCreatedAtAfter(
//				LocalDateTime.of(2024,1,1,0,0,0));
		//List<ProductEntity> entities=productRepository.findByQuantityAndPrice(8,BigDecimal.valueOf(16.8));
		//List<ProductEntity> entities=productRepository.findByQuantityGreaterThanAndPriceLessThan(8,BigDecimal.valueOf(16.8));
		//List<ProductEntity> entities=productRepository.findByTitleLike("%choco%");
//		List<ProductEntity> entities=productRepository.findByTitleContaining("choco");
		List<ProductEntity> entities=productRepository.findByTitleContainingIgnoreCase("chOCo");
		System.out.println(entities);
	}

	@Test
	void getSingleFromRepository(){
		Optional<ProductEntity> productEntity=productRepository
				.findByTitleAndPrice("Pepsi",BigDecimal.valueOf(14.4));
		productEntity.ifPresent(System.out::println);
	}


}

package com.inventory.shopping.controller;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.inventory.shopping.model.Product;
import com.inventory.shopping.repository.ProductRepo;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(ProductController.class)
class ProductControllerTest {

//	@InjectMocks
//	private ProductController controller;
//	
	@MockBean
	private ProductRepo productRepo;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	void testGetAllProduct() throws Exception {
		Product product = new Product(101, "dummy", 10000);
		List<Product> productList = new ArrayList<>();
		productList.add(product);
		
		when(productRepo.findAll()).thenReturn(productList);
		
		mockMvc.perform(get("/product/"))
		
		.andExpect(status().isOk()).andExpect(jsonPath("$", Matchers.hasSize(1)))
        .andExpect(jsonPath("$[0].name", Matchers.is("dummy")));
	}

	@Test
	void testAddProduct() {
		Product product = new Product(101, "dummy", 10000);
		
		productRepo.save(product);
		
		verify(productRepo,times(1)).save(product);
	}

}

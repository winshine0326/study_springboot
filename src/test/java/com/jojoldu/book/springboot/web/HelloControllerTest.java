package com.jojoldu.book.springboot.web;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = HelloController.class)
public class HelloControllerTest {

  @Autowired
  private MockMvc mvc;

  @Test
  public void hello가_리턴된다() throws Exception {
    String hello = "hello";

    mvc.perform(get("/hello"))
            .andExpect(status().isOk())
            .andExpect(content().string(hello));
  }

  @Test
  public void helloDto가_리턴된다() throws Exception {
    String name = "hello";
    int amount = 1000;

    mvc.perform(
            get("/hello/dto")
                    .param("name", name)
                    .param("amount", String.valueOf(amount))
    )
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.name", is(name)))
            .andExpect(jsonPath("$.amount",is(amount)));

  }
}
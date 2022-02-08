package com.github.whiliang.producer.controller;

import org.springframework.web.bind.annotation.*;

/**
 * @author whiliang
 */
@RestController
@RequestMapping("/person")
public class PersonController {
 
  @GetMapping("/{id}")
  @ResponseBody
  public Person findById(@PathVariable Long id) {
    return new Person("Lily");
  }
}
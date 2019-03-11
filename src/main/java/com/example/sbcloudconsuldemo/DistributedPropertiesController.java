package com.example.sbcloudconsuldemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * assumes you have the following KVs defined in Consul
 * config/<your-app>,dev/my/prop=Hello DEV
 * config/<your-app>,prod/my/prop=Hello PROD
 */
@RestController
public class DistributedPropertiesController {

  @Value("${my.prop}")
  String value;

  @Autowired
  private MyProperties properties;

  @GetMapping("/getConfigFromValue")
  public String getConfigFromValue() {
    return value;
  }

  @GetMapping("/getConfigFromProperty")
  public String getConfigFromProperty() {
    return properties.getProp();
  }

}

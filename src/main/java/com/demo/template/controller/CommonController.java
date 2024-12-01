package com.demo.template.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.demo.template.CommonService;
import com.demo.template.entity.CommonDto;

@RestController
@RequestMapping(value = "/controller")
public class CommonController {
  private static final Logger LOGGER = LoggerFactory.getLogger(CommonController.class);

  @Autowired
  CommonService commonService;
  
  @GetMapping(value = "/get")
  public ResponseEntity<List<CommonDto>> get() {
    LOGGER.warn("[COMONCONTROLLER] :: GET() METHOD");
    CommonDto dto = new CommonDto();
    dto.setBagType("NOR");
    return ResponseEntity.ok(commonService.selectBagIdList(dto));
  }

  @GetMapping(value = "/test")
  public ResponseEntity<String> test() {
    return ResponseEntity.ok("TEST");
  }

}

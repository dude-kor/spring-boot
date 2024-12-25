package com.demo.template.controller;

import java.util.List;
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

  @Autowired
  CommonService commonService;
  
  @GetMapping(value = "/get")
  public ResponseEntity<List<CommonDto>> get(CommonDto dto) {
    return ResponseEntity.ok(commonService.selectBagIdListByBagType(dto));
  }

  @GetMapping(value = "/test")
  public ResponseEntity<String> test() {
    return ResponseEntity.ok("TEST");
  }

}

package com.demo.template.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.demo.template.mapper.CommonMapper;
import com.demo.template.CommonService;
import com.demo.template.entity.CommonDto;

@Service
public class CommonServiceImpl implements CommonService {

  @Autowired
  CommonMapper commonMapper;

  @Override
  public List<CommonDto> selectBagIdListByBagType(CommonDto dto) {
    return commonMapper.selectBagIdListByBagType(dto);
  }
}

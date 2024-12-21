package com.demo.template.service;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.demo.template.CommonMapper;
import com.demo.template.CommonService;
import com.demo.template.entity.CommonDto;
import com.demo.template.repository.CommonDao;

@Service
public class CommonServiceImpl implements CommonService {
  private static final Logger LOGGER = LoggerFactory.getLogger(CommonServiceImpl.class);

  @Autowired
  CommonDao commonDao;
  
  @Autowired
  CommonMapper commonMapper;

  @Override
  public List<CommonDto> selectBagIdList(CommonDto dto) {
    LOGGER.warn(dto.toString());
//    return commonDao.selectBagIdList(dto);
    return commonMapper.selectBagIdListByBagType(dto);
  }
}

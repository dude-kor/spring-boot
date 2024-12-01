package com.demo.template.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.demo.template.CommonService;
import com.demo.template.entity.CommonDto;
import com.demo.template.repository.CommonDao;

@Service
public class CommonServiceImpl implements CommonService {

  @Autowired
  CommonDao commonDao;

  @Override
  public List<CommonDto> selectBagIdList(CommonDto dto) {
    return commonDao.selectBagIdList(dto);
  }
}

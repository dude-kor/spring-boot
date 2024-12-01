package com.demo.template;

import java.util.List;
import com.demo.template.entity.CommonDto;

public interface CommonService {

  public List<CommonDto> selectBagIdList(CommonDto dto);
}

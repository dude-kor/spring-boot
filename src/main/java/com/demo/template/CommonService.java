package com.demo.template;

import java.util.List;
import org.springframework.stereotype.Component;
import com.demo.template.entity.CommonDto;

@Component
public interface CommonService {

  public List<CommonDto> selectBagIdListByBagType(CommonDto dto);
}

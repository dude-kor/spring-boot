package com.demo.template;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import com.demo.template.entity.CommonDto;

@Component
@Mapper
public interface CommonMapper {

  public List<CommonDto> selectBagIdListByBagType(CommonDto dto);

}

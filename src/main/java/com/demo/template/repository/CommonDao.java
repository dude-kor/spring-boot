package com.demo.template.repository;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.demo.template.entity.CommonDto;

@Repository
public class CommonDao {
  private static final Logger LOGGER = LoggerFactory.getLogger(CommonDao.class);

  @Autowired
  SqlSession sqlSession;

  // private static final String SQL_PREFIX = CommonDao.class.getCanonicalName();
  private static final String SQL_PREFIX = "com.demo.template.repository.CommonDao";

  public List<CommonDto> selectBagIdList(CommonDto dto) {
    LOGGER.warn(SQL_PREFIX);
    return sqlSession.selectList(SQL_PREFIX + ".selectBagIdListByBagType", dto);
  }

}

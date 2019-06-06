package com.imooc.myo2o.dao;

import com.imooc.myo2o.entity.LocalAuth;
import org.apache.ibatis.annotations.Param;

public interface LocalAuthDao {


    LocalAuth queryLocalByUserNameAndPwd(@Param("userName") String name,
                                         @Param("password") String password);


}

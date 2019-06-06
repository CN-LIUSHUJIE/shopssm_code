package com.imooc.myo2o.service;

import com.imooc.myo2o.entity.LocalAuth;

public interface LocalAuthService {
    LocalAuth getLocalAuthByUserNameAndPwd(String userName, String password);

}

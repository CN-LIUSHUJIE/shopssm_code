package com.imooc.myo2o.service.impl;

import com.imooc.myo2o.dao.LocalAuthDao;
import com.imooc.myo2o.entity.LocalAuth;
import com.imooc.myo2o.service.LocalAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocalAuthServiceImpl implements LocalAuthService {
    @Autowired
    private LocalAuthDao localAuthDao;
    @Override
    public LocalAuth getLocalAuthByUserNameAndPwd(String userName, String password) {
        LocalAuth localAuth = localAuthDao.queryLocalByUserNameAndPwd(userName, password);
        return localAuth;
    }
}

package com.imooc.myo2o.web.superadmin;

import com.imooc.myo2o.entity.LocalAuth;
import com.imooc.myo2o.service.LocalAuthService;
import com.imooc.myo2o.util.HttpServletRequestUtil;
import com.imooc.myo2o.util.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/superadmin")
public class LoginController {

    @Autowired
    private LocalAuthService localAuthService;

    /**
     * 用户登录验证
     * @param request
     * @return
     */
    @RequestMapping(value = "logincheck", method = RequestMethod.POST)
    @ResponseBody
    private Map<String, Object> loginCheck(HttpServletRequest request) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        String userName = HttpServletRequestUtil.getString(request, "userName");
        String password = HttpServletRequestUtil.getString(request, "password");
        if (userName != null && password != null) {
            password = MD5.getMd5(password);
            LocalAuth localAuth = localAuthService.getLocalAuthByUserNameAndPwd(userName, password);
            if (localAuth != null) {
                if (localAuth.getPersonInfo().getAdminFlag() == 1) {
                    modelMap.put("success", true);
                    request.getSession().setAttribute("user", localAuth.getPersonInfo());
                } else {
                    modelMap.put("success", false);
                    modelMap.put("errMsg", "非管理员没有权限访问");
                }
            }
        } else {
            modelMap.put("success", false);
            modelMap.put("errMsg", "用户名和密码均不能为空");
        }
        return modelMap;


    }

}

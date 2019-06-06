package com.imooc.myo2o.web.shop;

import com.imooc.myo2o.entity.Shop;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "shop", method = { RequestMethod.GET,
		RequestMethod.POST })
public class AdminController {
	@RequestMapping(value = "/test")
	public Map<String, Object> productcategory(HttpServletRequest request) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		String kaptchaExpected = (String) request.getSession().getAttribute(
				com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
		System.out.println(kaptchaExpected);
		modelMap.put("verifyCode", kaptchaExpected);
		return modelMap;
	}
}

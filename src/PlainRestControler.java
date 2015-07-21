package com.loiane.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bnym.gsss.common.constants.Constants;
import com.bnym.gsss.common.util.CustomUtils;
import com.loiane.dao.MovieInfoDao;

@Controller
public class PlainRestControler {

	@Autowired
	MovieInfoDao infoDao;
	
	@RequestMapping(value="/getLoginUser/{phoneNo}/{email}", method=RequestMethod.GET)
	public @ResponseBody Object getLoginUser(HttpServletRequest request, @PathVariable String phoneNo, @PathVariable String email) {
		Map<String, Object> responseInfo = new HashMap<String, Object>();
		try {
			responseInfo.put(Constants.MAP_DATA_KEY, infoDao.getLoginUser(phoneNo, email));
			return responseInfo;
		} catch (Exception exception) {
			return responseInfo.put(Constants.MAP_ERROR_KEY, CustomUtils.getExceptionMessage(exception));
		}
	}
}

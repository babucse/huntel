package com.loiane.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

import com.bnym.gsss.common.annotation.PersistenceConfig;
import com.bnym.gsss.common.constants.Constants;
import com.bnym.gsss.common.controller.ControllerTemplateSupport;
import com.loiane.model.MovieInfoModel;

@Controller
public class RestController extends ControllerTemplateSupport {

	@RequestMapping(value = "/saveMovieInfo", method = RequestMethod.POST)
	@PersistenceConfig(enableGenericValidator=false, persistenceHandlerId="movieInfoPersistHndlr", enableEthicalHackValidation = false,formValidatorId = "")
	public @ResponseBody Object saveUserQuestionnaire(HttpServletRequest request,HttpServletResponse response, @RequestBody MovieInfoModel model) {
		
		Map<String, Object> responseInfo = new HashMap<String, Object>();
		List<String> errorList = new ArrayList<String>();
		
		if (super.persistObject(request, response, model, errorList)) {
				responseInfo.put(Constants.MAP_SUCCESS_KEY, model.getMovInfoBean().getMovieName()+" : Has been saved successfully");	
		} else {
			responseInfo.put(Constants.MAP_ERROR_KEY, errorList);
		}
		
		return responseInfo;
	}
	
	@RequestMapping(value = "/getMovieInfo/{movInfoId}", method = RequestMethod.GET)
	public @ResponseBody Object getMovieInfo(HttpServletRequest request, @PathVariable String movInfoId) {
		
		MovieInfoModel model = new MovieInfoModel();
		boolean isUIFldConfigNeeded = false;
		String repositoryId = "movieInfoDao";
		String methodId = "getMovieInfo";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("movInfoId", movInfoId);
		
		Map<String, Object> responseMap = super.buildView(request, model, repositoryId, methodId, paramMap, isUIFldConfigNeeded, null);

		return responseMap;
	}
	
	@PersistenceConfig(enableGenericValidator = false, persistenceHandlerId = "movieImageUploadPersistence", enableEthicalHackValidation = false)
	@RequestMapping(value="/uploadImg", method=RequestMethod.POST)
	public View uploadMovieImg(HttpServletRequest request,  @RequestParam("file") MultipartFile file){
		String contextPath=request.getContextPath();
		System.out.println(">>>>>>>>>>>>>File Upload>>>>>>");
		String fileName = file.getOriginalFilename();
		if (!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();
				File dir = new File("C:/tmp" + File.separator);
				if (!dir.exists()) {
					dir.mkdirs();
				}
				// Create the file on server
				File localFilePath = new File(dir.getAbsolutePath() + File.separator + fileName );
				System.out.println("localFilePath :: "+localFilePath);
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(localFilePath));
				stream.write(bytes);
				stream.close();
//				return "You successfully uploaded " + fileName + " into " + fileName + "-uploaded !";
				return new RedirectView("http://localhost:8080/thar/#/about?success");

			} catch (Exception e) {
				return new RedirectView("http://localhost:8080/thar/#/about?failed");
			}
		} else {
			return new RedirectView("http://localhost:8080/thar/#/about?failed");
		}
	}

	@RequestMapping(value = "/saveLoginUser", method = RequestMethod.POST)
	@PersistenceConfig(enableGenericValidator=false, persistenceHandlerId="loginUserPersistHndlr", enableEthicalHackValidation = false)
	public @ResponseBody Object saveLoginUser(HttpServletRequest request,HttpServletResponse response, @RequestBody LoginUserModel model) {
		
		Map<String, Object> responseInfo = new HashMap<String, Object>();
		List<String> errorList = new ArrayList<String>();
		
		if (super.persistObject(request, response, model, errorList)) {
				responseInfo.put(Constants.MAP_SUCCESS_KEY, model.getLoginUsrBean().getlName() + " " +model.getLoginUsrBean().getfName()+" : User has been created successfully");	
		} else {
			responseInfo.put(Constants.MAP_ERROR_KEY, errorList);
		}
		
		return responseInfo;
	}
	
}

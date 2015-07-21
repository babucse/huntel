package com.loiane.databse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bnym.gsss.common.constants.Constants;
import com.bnym.gsss.common.dao.JPATemplateSupport;
import com.bnym.gsss.common.database.PersistenceHandler;
import com.bnym.gsss.common.ui.model.ModelTemplate;
import com.loiane.bean.LoginUserBean;
import com.loiane.model.LoginUserModel;

@Service("loginUserPersistHndlr")
public class LoginUserPersistenceHandler extends PersistenceHandler {
	@Autowired
	JPATemplateSupport jpaTemplateSupport;
	
	@Override
	public void beforeTransaction(ModelTemplate model) throws Exception {
		
	}

	@Override
	public void preSave(ModelTemplate model) throws Exception {
		
	}

	@Override
	public void save(ModelTemplate model) throws Exception {
		LoginUserModel loginUsrModel = (LoginUserModel) model;
		LoginUserBean loginBean = loginUsrModel.getLoginUsrBean();
		if (loginBean.getRowStatus().equals(Constants.RECORD_INSERTED)) {
			jpaTemplateSupport.getDAOAccessor().persist(loginBean);			
		} else if (loginBean.getRowStatus().equals(Constants.RECORD_UPDATED)) {
			jpaTemplateSupport.getDAOAccessor().merge(loginBean);
		}
	}

	@Override
	public void postSave(ModelTemplate model) throws Exception {
		
	}

	@Override
	public void afterTransaction(ModelTemplate model) throws Exception {
		
	}

}

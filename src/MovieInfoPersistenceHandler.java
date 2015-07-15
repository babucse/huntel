package com.loiane.databse;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bnym.gsss.common.constants.Constants;
import com.bnym.gsss.common.dao.JPATemplateSupport;
import com.bnym.gsss.common.database.PersistenceHandler;
import com.bnym.gsss.common.ui.model.ModelTemplate;
import com.loiane.bean.MovieInfoBean;
import com.loiane.model.MovieInfoModel;

@Service("movieInfoPersistHndlr")
public class MovieInfoPersistenceHandler extends PersistenceHandler {

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
		MovieInfoModel movieInfoModel = (MovieInfoModel) model;
		MovieInfoBean movieInfoBean = movieInfoModel.getMovInfoBean();
		if (movieInfoBean.getRowStatus().equals(Constants.RECORD_INSERTED)) {
			movieInfoBean.setLastUpdatedId(movieInfoBean.getRecordCreatedId());
			movieInfoBean.setRecordCreatedDt(new Timestamp(new Date().getTime()));
			jpaTemplateSupport.getDAOAccessor().persist(movieInfoBean);
		} else if (movieInfoBean.getRowStatus().equals(Constants.RECORD_UPDATED)) {
			jpaTemplateSupport.getDAOAccessor().merge(movieInfoBean);
		}
		
	}

	@Override
	public void postSave(ModelTemplate model) throws Exception {

		
	}

	@Override
	public void afterTransaction(ModelTemplate model) throws Exception {

		
	}

}

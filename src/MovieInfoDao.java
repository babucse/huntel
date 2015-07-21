package com.loiane.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;

import com.bnym.gsss.common.dao.JDBCTemplateSupport;
import com.loiane.bean.MovieInfoBean;
import com.loiane.model.MovieInfoModel;

public class MovieInfoDao extends JDBCTemplateSupport{

	public MovieInfoModel getMovieInfo(Map<String, Object> paramMap) {
		
		MovieInfoModel model = new MovieInfoModel();
		
		MovieInfoBean movInfoBean = new MovieInfoBean();
		movInfoBean.setMovieName("Test Data");
		model.setMovInfoBean(movInfoBean );
		
		String sql =	"SELECT	ID, " +
						"MOVIE_NAME, " +
						"MOVIE_RELEASE_DATE, " +
						"MOVIE_LANGUAGE, " +
						"MOVIE_ORGIN, " +
						"MOVIE_ORGIN_VARIANT, " +
						"MOVIE_GENRES, " +
						"MOVIE_SYNOPSIS, " +
						"MOVIE_IS_3D, " +
						"MOVIE_TEAM_ROLE_IDS, " +
						"MOVIE_TRAILER_LINK, " +
						"MOVIE_TEASER_LINK, " +
						"MOVIE_RATING, " +
						"MOVIE_CERTIF, " +
						"MOVIE_RUN_TIME, " +
						"RCD_CRD_ID, " +
						"RCD_CRD_DT, " +
						"LST_UPDT_ID, " +
						"LST_UPDT_DT " +
				"FROM 	MOVIE_INFO " +
				"WHERE 	ID = ?" ;
		Object[] qryParams = {paramMap.get("movInfoId")};
		int[] argTypes = {Types.NUMERIC};
		
		movInfoBean = getDAOAccessor().queryForObject(sql, qryParams, argTypes, new RowMapper<MovieInfoBean>() {

			@Override
			public MovieInfoBean mapRow(ResultSet rs, int inx)
					throws SQLException {
				MovieInfoBean bean = new MovieInfoBean();
				bean.setMovieInfoId(rs.getInt("ID"));
				bean.setMovieName(rs.getString("MOVIE_NAME"));
				bean.setMovieReleseDt(rs.getDate("MOVIE_RELEASE_DATE"));
				bean.setMovieLanguage(rs.getString("MOVIE_LANGUAGE"));
				bean.setMovieOrgin(rs.getString("MOVIE_ORGIN"));
				bean.setMovieOrginVariant(rs.getString("MOVIE_ORGIN_VARIANT"));
				bean.setMovieGenres(rs.getString("MOVIE_GENRES"));
				bean.setMovieSynops(rs.getString("MOVIE_SYNOPSIS"));
				bean.setMovieIs3d(rs.getBoolean("MOVIE_IS_3D"));
				bean.setMovieTeamRolId(rs.getInt("MOVIE_TEAM_ROLE_IDS"));
				bean.setMovieTrailrLnk(rs.getString("MOVIE_TRAILER_LINK"));
				bean.setMovieTeaserLnk(rs.getString("MOVIE_TEASER_LINK"));
				bean.setMovieRating(rs.getInt("MOVIE_RATING"));
				bean.setMovieCertif(rs.getString("MOVIE_CERTIF"));
				bean.setMovieRunTime(rs.getString("MOVIE_RUN_TIME"));
				bean.setRecordCreatedDt(rs.getTimestamp("RCD_CRD_DT"));
				bean.setRecordCreatedId(rs.getString("RCD_CRD_ID"));
				bean.setLastUpdatedDt(rs.getTimestamp("LST_UPDT_DT"));
				bean.setLastUpdatedId(rs.getString("LST_UPDT_ID"));
				return bean;
			}
			
		});
		
		model.setMovInfoBean(movInfoBean);
		
		return model;
	}
	
	public LoginUserBean getLoginUser(String phoneNo, String email) throws Exception {
		String sql =	"SELECT	FIRST_NAME, " +
								"LAST_NAME, " +
								"EMAIL, " +
								"PHONE_NO, " +
								"RCD_CRD_ID, " +
								"RCD_CRD_DT, " +
								"LST_UPDT_ID, " +
								"LST_UPDT_DT " +
						"FROM 	LOGIN_USERS" +
						"WHERE 	PHONE_NO = ? " ;
		
		LoginUserBean loginBean =null;
		try {
			Object[] qryParams = {phoneNo};
			int[] argTypes = {Types.NUMERIC};
			
			loginBean = getDAOAccessor().queryForObject(sql, qryParams, argTypes, new RowMapper<LoginUserBean>() {

				@Override
				public LoginUserBean mapRow(ResultSet rs, int inx)
						throws SQLException {
					LoginUserBean loginBean = new LoginUserBean();
					loginBean.setfName(rs.getString("FIRST_NAME"));
					loginBean.setlName(rs.getString("LIRST_NAME"));
					loginBean.setEmail(rs.getString("EMAIL"));
					loginBean.setPhoneNo(rs.getString("PHONE_NO"));
					loginBean.setRecordCreatedId(rs.getString("RCD_CRD_ID"));
					loginBean.setRecordCreatedDt(rs.getTimestamp("RCD_CRD_DT"));
					loginBean.setLastUpdatedId(rs.getString("LST_UPDT_ID"));
					loginBean.setLastUpdatedDt(rs.getTimestamp("LST_UPDT_DT"));
					return loginBean;
					
				}
			});
		} catch (EmptyResultDataAccessException e) {
			throw new Exception("User not available.");
		}  
		
		return loginBean;
	}
}

package com.loiane.bean;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Version;

import com.bnym.gsss.common.domain.BeanTemplate;

@Entity
@Table(name = "MOVIE_INFO")
public class MovieInfoBean extends BeanTemplate{

	@Id
	@TableGenerator(name="THAR_SEQ", table="SEQ_KEY", pkColumnName="NAME", valueColumnName="VALUE", pkColumnValue="MOVIE_INFO_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.TABLE, generator="THAR_SEQ")
	@Column(name = "ID", nullable = false)
	private int movieInfoId;
	
	@Column(name = "MOVIE_NAME", nullable = false)
	private String movieName;
	
	@Column(name = "MOVIE_RELEASE_DATE")
	private Date movieReleseDt;
	
	@Column(name = "MOVIE_LANGUAGE", nullable = false)
	private String movieLanguage;
	
	@Column(name = "MOVIE_ORGIN", nullable = false)
	private String movieOrgin;
	
	@Column(name = "MOVIE_ORGIN_VARIANT", nullable = false)
	private String movieOrginVariant;
	
	@Column(name = "MOVIE_GENRES", nullable = false)
	private String movieGenres;
	
	@Column(name = "MOVIE_SYNOPSIS", nullable = false)
	private String movieSynops;
	
	@Column(name = "MOVIE_IS_3D", nullable = false)
	private boolean movieIs3d;
	
	@Column(name = "MOVIE_TEAM_ROLE_IDS", nullable = false)
	private int movieTeamRolId;
	
	@Column(name = "MOVIE_TRAILER_LINK")
	private String movieTrailrLnk;
	
	@Column(name = "MOVIE_TEASER_LINK")
	private String movieTeaserLnk;
	
	@Column(name = "MOVIE_RATING")
	private int movieRating;
	
	@Column(name = "MOVIE_CERTIF", nullable = false)
	private String movieCertif;
	
	@Column(name = "MOVIE_RUN_TIME", nullable = false)
	private String movieRunTime;
	
	@Column(name = "RCD_CRD_ID", nullable = false)
	private String recordCreatedId;
	
	@Column(name = "RCD_CRD_DT", nullable = false)
	private Timestamp recordCreatedDt;
	
	@Column(name = "LST_UPDT_ID", nullable = false)
	private String lastUpdatedId;
	
	@Version
	@Column(name = "LST_UPDT_DT", nullable = false)
	private Timestamp lastUpdatedDt;

	public int getMovieInfoId() {
		return movieInfoId;
	}

	public void setMovieInfoId(int movieInfoId) {
		this.movieInfoId = movieInfoId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public Date getMovieReleseDt() {
		return movieReleseDt;
	}

	public void setMovieReleseDt(Date movieReleseDt) {
		this.movieReleseDt = movieReleseDt;
	}

	public String getMovieLanguage() {
		return movieLanguage;
	}

	public void setMovieLanguage(String movieLanguage) {
		this.movieLanguage = movieLanguage;
	}

	public String getMovieOrgin() {
		return movieOrgin;
	}

	public void setMovieOrgin(String movieOrgin) {
		this.movieOrgin = movieOrgin;
	}

	public String getMovieOrginVariant() {
		return movieOrginVariant;
	}

	public void setMovieOrginVariant(String movieOrginVariant) {
		this.movieOrginVariant = movieOrginVariant;
	}

	public String getMovieGenres() {
		return movieGenres;
	}

	public void setMovieGenres(String movieGenres) {
		this.movieGenres = movieGenres;
	}

	public String getMovieSynops() {
		return movieSynops;
	}

	public void setMovieSynops(String movieSynops) {
		this.movieSynops = movieSynops;
	}

	public boolean isMovieIs3d() {
		return movieIs3d;
	}

	public void setMovieIs3d(boolean movieIs3d) {
		this.movieIs3d = movieIs3d;
	}

	public int getMovieTeamRolId() {
		return movieTeamRolId;
	}

	public void setMovieTeamRolId(int movieTeamRolId) {
		this.movieTeamRolId = movieTeamRolId;
	}

	public String getMovieTrailrLnk() {
		return movieTrailrLnk;
	}

	public void setMovieTrailrLnk(String movieTrailrLnk) {
		this.movieTrailrLnk = movieTrailrLnk;
	}

	public String getMovieTeaserLnk() {
		return movieTeaserLnk;
	}

	public void setMovieTeaserLnk(String movieTeaserLnk) {
		this.movieTeaserLnk = movieTeaserLnk;
	}

	public int getMovieRating() {
		return movieRating;
	}

	public void setMovieRating(int movieRating) {
		this.movieRating = movieRating;
	}

	public String getMovieCertif() {
		return movieCertif;
	}

	public void setMovieCertif(String movieCertif) {
		this.movieCertif = movieCertif;
	}

	public String getMovieRunTime() {
		return movieRunTime;
	}

	public void setMovieRunTime(String movieRunTime) {
		this.movieRunTime = movieRunTime;
	}

	public String getRecordCreatedId() {
		return recordCreatedId;
	}

	public void setRecordCreatedId(String recordCreatedId) {
		this.recordCreatedId = recordCreatedId;
	}

	public Timestamp getRecordCreatedDt() {
		return recordCreatedDt;
	}

	public void setRecordCreatedDt(Timestamp recordCreatedDt) {
		this.recordCreatedDt = recordCreatedDt;
	}

	public String getLastUpdatedId() {
		return lastUpdatedId;
	}

	public void setLastUpdatedId(String lastUpdatedId) {
		this.lastUpdatedId = lastUpdatedId;
	}

	public Timestamp getLastUpdatedDt() {
		return lastUpdatedDt;
	}

	public void setLastUpdatedDt(Timestamp lastUpdatedDt) {
		this.lastUpdatedDt = lastUpdatedDt;
	}
	
	
}

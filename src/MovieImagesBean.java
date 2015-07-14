package com.loiane.bean;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "MOVIE_IMAGES")
public class MovieImagesBean {

	@Column(name = "ID", nullable = false)
	private int movieId;
	
	@Lob
	@Column(name="MOV_ENCOD_ORG_IMG", nullable=false, columnDefinition="mediumblob")
	private byte[] encodeImageOrgnl;
	
	@Lob
	@Column(name="MOV_ENCOD_NORM_IMG", nullable=false, columnDefinition="mediumblob")
	private byte[] encodeImageNorm;
	
	@Lob
	@Column(name="MOV_ENCOD_MED_IMG", nullable=false, columnDefinition="mediumblob")
	private byte[] encodeImageMedm;
	
	@Lob
	@Column(name="MOV_ENCOD_SMALL_IMG", nullable=false, columnDefinition="mediumblob")
	private byte[] encodeImageSmal;
	
	@Column(name = "MOVIE_INFO_ID", nullable = false)
	private int movieInfoId;
	
	@Column(name = "MOV_IMG_VIEW_TYPE", nullable = false)
	private String movieImgViewType;
	
	@Column(name = "RCD_CRT_ID", nullable = false)
	private String recordCreatedId;
	
	@Column(name = "RCD_CRT_DT", nullable = false)
	private Timestamp recordCreatedDt;
	
	@Column(name = "LST_UPDT_ID", nullable = false)
	private String lastUpdatedId;
	
	@Version
	@Column(name = "LST_UPDT_DT", nullable = false)
	private Timestamp lastUpdatedDt;

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public byte[] getEncodeImageOrgnl() {
		return encodeImageOrgnl;
	}

	public void setEncodeImageOrgnl(byte[] encodeImageOrgnl) {
		this.encodeImageOrgnl = encodeImageOrgnl;
	}

	public byte[] getEncodeImageNorm() {
		return encodeImageNorm;
	}

	public void setEncodeImageNorm(byte[] encodeImageNorm) {
		this.encodeImageNorm = encodeImageNorm;
	}

	public byte[] getEncodeImageMedm() {
		return encodeImageMedm;
	}

	public void setEncodeImageMedm(byte[] encodeImageMedm) {
		this.encodeImageMedm = encodeImageMedm;
	}

	public byte[] getEncodeImageSmal() {
		return encodeImageSmal;
	}

	public void setEncodeImageSmal(byte[] encodeImageSmal) {
		this.encodeImageSmal = encodeImageSmal;
	}

	public int getMovieInfoId() {
		return movieInfoId;
	}

	public void setMovieInfoId(int movieInfoId) {
		this.movieInfoId = movieInfoId;
	}

	public String getMovieImgViewType() {
		return movieImgViewType;
	}

	public void setMovieImgViewType(String movieImgViewType) {
		this.movieImgViewType = movieImgViewType;
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

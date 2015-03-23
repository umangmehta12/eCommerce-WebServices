package com.edeal.base;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the alldeals database table.
 * 
 */
@Entity
@Table(name="alldeals")
@NamedQuery(name="findAllAlldeals", query="SELECT a FROM Alldeal a")
public class Alldeal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String catgory;

	private String descrp;

	private String offeredprice;

	private String originalprice;

	private String prdcname;

	private String prodname;

	private String siteurl;

	private String stname;

	public Alldeal(int id, String catgory, String descrp, String offeredprice, String originalprice, String prdcname,
			String prodname, String siteurl, String stname) {
		this.id =id;
		this.catgory =catgory;
		this.descrp= descrp;
		this.offeredprice = offeredprice;
		this.originalprice = originalprice;
		this.prdcname= prdcname;
		this.prodname = prodname;
		this.siteurl = siteurl;
		this.stname = stname;
		
	}


	public Alldeal() {
	}
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCatgory() {
		return this.catgory;
	}

	public void setCatgory(String catgory) {
		this.catgory = catgory;
	}

	public String getDescrp() {
		return this.descrp;
	}

	public void setDescrp(String descrp) {
		this.descrp = descrp;
	}

	public String getOfferedprice() {
		return this.offeredprice;
	}

	public void setOfferedprice(String offeredprice) {
		this.offeredprice = offeredprice;
	}

	public String getOriginalprice() {
		return this.originalprice;
	}

	public void setOriginalprice(String originalprice) {
		this.originalprice = originalprice;
	}

	public String getPrdcname() {
		return this.prdcname;
	}

	public void setPrdcname(String prdcname) {
		this.prdcname = prdcname;
	}

	public String getProdname() {
		return this.prodname;
	}

	public void setProdname(String prodname) {
		this.prodname = prodname;
	}

	public String getSiteurl() {
		return this.siteurl;
	}

	public void setSiteurl(String siteurl) {
		this.siteurl = siteurl;
	}

	public String getStname() {
		return this.stname;
	}

	public void setStname(String stname) {
		this.stname = stname;
	}

}
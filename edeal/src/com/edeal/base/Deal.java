package com.edeal.base;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the deals database table.
 * 
 */
@Entity
@Table(name="deals")
@NamedQuery(name="findAllDeals", query="SELECT d FROM Deal d")
public class Deal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private float offer;

	private int productid;

	private int siteid;

	public Deal() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getOffer() {
		return this.offer;
	}

	public void setOffer(float offer) {
		this.offer = offer;
	}

	public int getProductid() {
		return this.productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	public int getSiteid() {
		return this.siteid;
	}

	public void setSiteid(int siteid) {
		this.siteid = siteid;
	}

}
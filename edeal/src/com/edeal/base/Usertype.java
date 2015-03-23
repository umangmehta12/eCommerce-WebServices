package com.edeal.base;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the usertype database table.
 * 
 */
@Entity
@NamedQuery(name="findAllUsertypes", query="SELECT u FROM Usertype u")
public class Usertype implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String typename;

	public Usertype() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTypename() {
		return this.typename;
	}

	public void setTypename(String typename) {
		this.typename = typename;
	}

}
package com.edeal.base;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the producer database table.
 * 
 */
@Entity
@NamedQuery(name="findAllProducers", query="SELECT p FROM Producer p")
public class Producer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String producername;

	public Producer() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProducername() {
		return this.producername;
	}

	public void setProducername(String producername) {
		this.producername = producername;
	}

}
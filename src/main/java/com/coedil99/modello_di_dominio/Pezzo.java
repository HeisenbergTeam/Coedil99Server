/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: 
 * License Type: Evaluation
 */
package com.coedil99.modello_di_dominio;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.xml.bind.annotation.*;

@XmlRootElement
public class Pezzo {
	public Pezzo() {
	}

	private int ID;

	private int quantita;
	
	private com.coedil99.modello_di_dominio.DescrizionePezzo descrizionePezzo;
	
	private com.coedil99.modello_di_dominio.RigaRDA rigaRDA;
	
	private void setID(int value) {
		this.ID = value;
	}
	@XmlID
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	public void setQuantita(int value) {
		this.quantita = value;
	}
	
	public int getQuantita() {
		return quantita;
	}
	
	public void setDescrizionePezzo(com.coedil99.modello_di_dominio.DescrizionePezzo value) {
		this.descrizionePezzo = value;
	}

	@XmlIDREF
	public com.coedil99.modello_di_dominio.DescrizionePezzo getDescrizionePezzo() {
		return descrizionePezzo;
	}
	
	public void setRigaRDA(com.coedil99.modello_di_dominio.RigaRDA value) {
		if (this.rigaRDA != value) {
			com.coedil99.modello_di_dominio.RigaRDA lrigaRDA = this.rigaRDA;
			this.rigaRDA = value;
			if (value != null) {
				rigaRDA.setPezzo(this);
			}
			if (lrigaRDA != null && lrigaRDA.getPezzo() == this) {
				lrigaRDA.setPezzo(null);
			}
		}
	}

	@XmlIDREF
	public com.coedil99.modello_di_dominio.RigaRDA getRigaRDA() {
		return rigaRDA;
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}

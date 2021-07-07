package com.packt.pyetesor.domain;

public class Alternativ {

	private int alternativId;
	private String alternativ;
	private int esakt;
	private String esakta;
	
	public void setEsakta(String esakta) {
		this.esakta = esakta;
	}
	public String getEsakta() {
		return esakta;
	}
	public void setAlternativId(int alternativId){
		this.alternativId = alternativId;
	}
	public int getAlternativId(){
		return alternativId;
	}
	public void setAlternativ(String alternativ) {
		this.alternativ = alternativ;
	}
	public String getAlternativ() {
		return alternativ;
	}
	public void setEsakt(int esakt) {
		this.esakt = esakt;
	}
	public int getEsakt() {
		return esakt;
	}
	public Alternativ(){
		super();
	}
	public Alternativ (int alternativId,String alternativ,int esakt){
		this.alternativId = alternativId;
		this.alternativ = alternativ;
		this.esakt = esakt;
	}
}

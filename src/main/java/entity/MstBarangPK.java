package entity;

import java.io.Serializable;

public class MstBarangPK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String kodeBarang;
	public String getKodeBarang() {
		return kodeBarang;
	}
	public void setKodeBarang(String kodeBarang) {
		this.kodeBarang = kodeBarang;
	}
}

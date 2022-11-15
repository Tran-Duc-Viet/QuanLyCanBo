package Model.Entity;

import Model.Entity.Canbo;

public class Kysu extends Canbo {
	private String nganhDaoTao;

	public String getNganhDaoTao() {
		return nganhDaoTao;
	}

	public void setNganhDaoTao(String nganhDaoTao) {
		this.nganhDaoTao = nganhDaoTao;
	}

	public Kysu(String[] t) {
		super(t);
		this.nganhDaoTao = t[4];
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return "Kỹ Sư";
	}

	@Override
	public String[] getStringArray() {
		// TODO Auto-generated method stub
		String t[] = new String[5];
		t[0] = super.getHoTen();
		t[1] = String.valueOf(super.getTuoi());
		t[2] = super.getGioiTinh();
		t[3] = super.getDiaChi();
		t[4] = nganhDaoTao;

		return t;
	}

	public void printThongTin() {
		// TODO Auto-generated method stub
		System.out.println("Ho va ten: " + super.getHoTen());
		System.out.println("Tuoi: " + super.getTuoi());
		System.out.println("Gioi tinh: " + super.getGioiTinh());
		System.out.println("Bac:" + getNganhDaoTao());
	}

}
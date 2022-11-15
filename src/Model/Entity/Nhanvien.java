package Model.Entity;

import Model.Entity.Canbo;

//lớp nhân viên kế thừa lớp cán bộ
public class Nhanvien extends Canbo {
	private String congViec;

	public String getCongViec() {
		return congViec;
	}

	public void setCongViec(String congViec) {
		this.congViec = congViec;
	}
//Phương thức khởi tạo lớp nhân viên
	public Nhanvien(String []t) {
		super(t);
		this.congViec = t[4];
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return "Nhân Viên";
	}

	@Override
	public String[] getStringArray() {
		// TODO Auto-generated method stub
		String t[]=new String[5];
		t[0]=super.getHoTen();
		t[1]=String.valueOf(super.getTuoi());
		t[2]=super.getGioiTinh();
		t[3]=super.getDiaChi();
		t[4]=congViec;
		
		return t;
	}
	public void printThongTin() {
		// TODO Auto-generated method stub
		System.out.println("Ho va ten: "+super.getHoTen());
		System.out.println("Tuoi: "+super.getTuoi());
		System.out.println("Gioi tinh: "+super.getGioiTinh());
		System.out.println("Bac:"+ getCongViec());
	}
	
	

}


package Model.Entity;

import Model.Entity.Canbo;

//lớp công nhân kế thừa lớp trừu tượng cán bộ
public class Congnhan extends Canbo {
	private int bac;

	// Phương thức khởi tạo lớp cán bộ
	public Congnhan(String[] t) {
		super(t);
		this.bac = Integer.parseInt(t[4]);
	}

	public int getBac() {
		return bac;
	}

	public void setBac(int bac) {
		if ((0 < bac) && (bac < 11)) {
			this.bac = bac;
		}
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return "Công Nhân";
	}

	@Override
	public String[] getStringArray() {
		// TODO Auto-generated method stub
		String t[] = new String[5];
		t[0] = super.getHoTen();
		t[1] = String.valueOf(super.getTuoi());
		t[2] = super.getGioiTinh();
		t[3] = super.getDiaChi();
		t[4] = String.valueOf(bac);

		return t;
	}

	@Override
	public void printThongTin() {
		// TODO Auto-generated method stub
		System.out.println("Ho va ten: " + super.getHoTen());
		System.out.println("Tuoi: " + super.getTuoi());
		System.out.println("Gioi tinh: " + super.getGioiTinh());
		System.out.println("Bac:" + getBac());
	}

}

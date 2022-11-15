package Model.Entity;

//lớp cán bộ
public abstract class Canbo {
	private String hoTen;
	private int tuoi;
	private String gioiTinh;
	private String diaChi;

//các phương thức get và set
	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public int getTuoi() {
		return tuoi;
	}

	public void setTuoi(int tuoi) {
		this.tuoi = tuoi;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

//phương thức khởi tạo cán bộ
	public Canbo(String[] t) {
		this.hoTen = t[0];
		this.tuoi = Integer.parseInt(t[1]);
		this.gioiTinh = t[2];
		this.diaChi = t[3];
	}

	public abstract String getType();

	public abstract String[] getStringArray();

	public abstract void printThongTin();

}
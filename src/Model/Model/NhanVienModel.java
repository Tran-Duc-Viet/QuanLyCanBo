package Model.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import GUI.NhanVienView;
import Model.Entity.*;

//Lớp thao tác dữ liệu nhân viên
public class NhanVienModel {
	private NhanVienView nhanVienView = null;
	private final static String databaseName = "qlnhanvien";
	// Hoten, tuoi, gioitinh, dia chi, CongViec
	private final String insertSQL = "INSERT INTO " + databaseName + " VALUE (?, ?, ?, ?, ?)";
	private final String selectAllSQL = "SELECT * FROM " + databaseName;
	private final String deleteSQL = "DELETE FROM " + databaseName;

	// phuong thức khởi tạo
	public NhanVienModel(NhanVienView nhanVienView) {
		this.nhanVienView = nhanVienView;
	}

	// phương thức thêm mới nhân viên vào danh sách nhân viên
	public void them(Nhanvien nhanVien) throws Exception {
		Connection con = SQLConnector.getCon();
		PreparedStatement stmt = con.prepareStatement(insertSQL);
		// Hoten, tuoi, gioitinh, dia chi, CongViec
		stmt.setString(1, nhanVien.getHoTen());
		stmt.setInt(2, nhanVien.getTuoi());
		stmt.setString(3, nhanVien.getGioiTinh());
		stmt.setString(4, nhanVien.getDiaChi());
		stmt.setString(5, nhanVien.getCongViec());
		try {
			stmt.execute();
		} catch (SQLIntegrityConstraintViolationException e) {
			// TODO: handle exception
			throw new Exception("Đã tồn tại nhân viên này");
		}
		con.close();
		nhanVienView.setDataForTable(getData(nhanVienView.getTextToFind()));

	}

	// phương thức lấy danh sách nhân viên
	public ArrayList<Nhanvien> getData(String condition) throws Exception {
		String query = selectAllSQL;
		if (!condition.equals(""))
			query = selectAllSQL + " WHERE HovaTen LIKE ?";

		Connection con = SQLConnector.getCon();
		PreparedStatement stmt = con.prepareStatement(query);
		if (!condition.equals("")) {
			condition = "%" + condition + "%";
			stmt.setString(1, condition);
		}
		ResultSet rs = stmt.executeQuery();
		ArrayList<Nhanvien> data = new ArrayList<>();
		while (rs.next()) {
			String[] t = { rs.getString("HovaTen"), String.valueOf(rs.getInt("Tuoi")), rs.getString("GioiTinh"),
					rs.getString("DiaChi"), rs.getString("CongViec") };
			// Hoten, tuoi, gioitinh, dia chi, CongViec
			Nhanvien nhanVien = new Nhanvien(t);
			data.add(nhanVien);
		}
		con.close();
		return data;
	}

	// phuog thức tìm danh sách nhân viên có họ tên nào đó
	public void timKiem(String name) throws Exception {
		nhanVienView.setDataForTable(getData(name));
	}

	// Hoten, tuoi, gioitinh, dia chi, bac
	public void delete(Nhanvien nhanVien) throws Exception {
		Connection con = SQLConnector.getCon();

		if ((!nhanVien.getHoTen().equals("")) && (!nhanVien.getDiaChi().equals("")) && (!nhanVien.getGioiTinh().equals(""))) {
			String query = deleteSQL + " WHERE HovaTen = '" + nhanVien.getHoTen() + "' AND Tuoi = '"
					+ String.valueOf(nhanVien.getTuoi()) + "' AND DiaChi = '" + nhanVien.getDiaChi() + "' AND GioiTinh = '"
					+ nhanVien.getGioiTinh() + "' ";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.execute();
			con.close();
			nhanVienView.setDataForTable(getData(nhanVienView.getTextToFind()));
		}
	}
}

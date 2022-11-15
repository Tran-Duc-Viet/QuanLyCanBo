package Model.Model;

import Model.Entity.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;

import GUI.CongNhanView;

	//lớp thao tác với dữ liệu của công nhân
public class CongNhanModel {
	private CongNhanView congNhanView = null;
	private final static String databaseName = "qlcongnhan";
	// Hoten, tuoi, gioitinh, dia chi, bac
	private final String insertSQL = "INSERT INTO " + databaseName + " VALUE (?, ?, ?, ?, ?)";
	private final String selectAllSQL = "SELECT * FROM " + databaseName;

	// phuong thức khởi tạo
	public CongNhanModel(CongNhanView congNhanView) {
		this.congNhanView = congNhanView;
	}

	// phương thức thêm công nhan mới vào ds
	public void them(Congnhan congnhan) throws Exception {
		Connection con = SQLConnector.getCon();
		PreparedStatement stmt = con.prepareStatement(insertSQL);
		// Hoten, tuoi, gioitinh, dia chi, bac
		stmt.setString(1, congnhan.getHoTen());
		stmt.setInt(2, congnhan.getTuoi());
		stmt.setString(3, congnhan.getGioiTinh());
		stmt.setString(4, congnhan.getDiaChi());
		stmt.setInt(5, congnhan.getBac());

		try {
			stmt.execute();
		} catch (SQLIntegrityConstraintViolationException e) {
			// TODO: handle exception
			throw new Exception("Đã tồn tại công nhân này");
		}
		con.close();
		congNhanView.setDataForTable(getData(congNhanView.getTextToFind()));

	}

	// phuong thức xem ds
	public void xemDS() throws Exception {
		congNhanView.setDataForTable(getData(congNhanView.getTextToFind()));
	}

	// phương thức lấy ds công nhân
	public ArrayList<Congnhan> getData(String condition) throws Exception {
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
		ArrayList<Congnhan> data = new ArrayList<>();
		while (rs.next()) {
			String[] t = { rs.getString("HovaTen"), String.valueOf(rs.getInt("Tuoi")), rs.getString("GioiTinh"),
					rs.getString("DiaChi"), String.valueOf(rs.getInt("Bac")) };
			// Hoten, tuoi, gioitinh, dia chi, bac
			Congnhan congNhan = new Congnhan(t);
			data.add(congNhan);
		}
		con.close();
		return data;
	}

	public void timKiem(String name) throws Exception {
		congNhanView.setDataForTable(getData(name));
	}
}
package Model.Model;

import java.util.ArrayList;
import Model.Entity.*;
import GUI.KySuView;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

//lớp thao tác với dữ liệu của ký sư
public class KySuModel {
	private KySuView kySuView = null;
	protected ArrayList<Kysu> ksList = new ArrayList<Kysu>();
	private final static String databaseName = "qlkysu";
	// Hovaen, tuoi, gioitinh, dia chi, nganhDaoTao
	private final String insertSQL = "INSERT INTO " + databaseName + " VALUE (?, ?, ?, ?, ?)";
	private final String selectAllSQL = "SELECT * FROM " + databaseName;

	// phuownng thức khởi tạo
	public KySuModel(KySuView kySuView) {
		this.kySuView = kySuView;
	}

	// phương thức thêm ký sư mới vào ds ký sư
	public void them(Kysu Kysu) throws Exception {
		Connection con = SQLConnector.getCon();
		PreparedStatement stmt = con.prepareStatement(insertSQL);
		// Hovaen, tuoi, gioitinh, dia chi, nganhDaoTao
		stmt.setString(1, Kysu.getHoTen());
		stmt.setInt(2, Kysu.getTuoi());
		stmt.setString(3, Kysu.getGioiTinh());
		stmt.setString(4, Kysu.getDiaChi());
		stmt.setString(5, Kysu.getNganhDaoTao());

		try {
			stmt.execute();
		} catch (SQLIntegrityConstraintViolationException e) {
			// TODO: handle exception
			throw new Exception("Đã tồn tại công nhân này");
		}
		con.close();
		kySuView.setDataForTable(getData(kySuView.getTextToFind()));

	}

	// phương thức xem danh sách
	public void xemDS() throws Exception {

		kySuView.setDataForTable(getData(kySuView.getTextToFind()));

	}

	// phương thức lấy danh sách ký sư
	public ArrayList<Kysu> getData(String condition) throws Exception {
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
		ArrayList<Kysu> data = new ArrayList<>();
		while (rs.next()) {
			String[] t = { rs.getString("HovaTen"), String.valueOf(rs.getInt("Tuoi")), rs.getString("GioiTinh"),
					rs.getString("DiaChi"), rs.getString("NganhDaoTao") };
			// Hovaen, tuoi, gioitinh, dia chi, nganhDaoTao
			Kysu kySu = new Kysu(t);
			data.add(kySu);
		}
		con.close();
		return data;
	}

	// phương thức tìm kiếm danh sách nhứng người có họ tên nào đó
	public void timKiem(String name) throws Exception {
		kySuView.setDataForTable(getData(name));
	}

}

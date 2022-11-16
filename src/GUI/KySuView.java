package GUI;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;
import Model.Entity.*;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

//lớp giao diện quản lý ký sư
public class KySuView {

	private JFrame frame;
	private JTextField hoVaTen;
	private JTextField tuoi;
	private JTextField gioiTinh;
	private JTextField diaChi;
	private JTable table;
	private DefaultTableModel model;
	public static final String colName[] = { "Họ và tên", "Tuổi", "Giới tính", "Địa chỉ", "Ngành đào tạo" };
	private JTextField nganhDaoTao;
	private JTextField tenTimKiem;
	private JButton btnThem, btnClear, btnDelete, btnTimKiem;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public KySuView() {
		// initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1086, 682);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Quản Lý Kỹ Sư");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(441, 10, 138, 50);
		frame.getContentPane().add(lblNewLabel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(492, 101, 522, 402);
		frame.getContentPane().add(scrollPane);

		table = new JTable();
		model = new DefaultTableModel();
		scrollPane.setViewportView(table);

		JLabel lblHoVaTen = new JLabel("Họ và tên:");
		lblHoVaTen.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblHoVaTen.setBounds(52, 116, 75, 29);
		frame.getContentPane().add(lblHoVaTen);

		JLabel lblTuoi = new JLabel("Tuổi ");
		lblTuoi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTuoi.setBounds(52, 154, 75, 29);
		frame.getContentPane().add(lblTuoi);

		JLabel lblGioiTinh = new JLabel("Giới Tính:");
		lblGioiTinh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGioiTinh.setBounds(52, 196, 75, 29);
		frame.getContentPane().add(lblGioiTinh);

		JLabel lblNewLabel_2 = new JLabel("Địa Chỉ:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(52, 235, 75, 29);
		frame.getContentPane().add(lblNewLabel_2);

		hoVaTen = new JTextField();
		hoVaTen.setBackground(SystemColor.menu);
		hoVaTen.setForeground(SystemColor.desktop);
		hoVaTen.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		hoVaTen.setBounds(206, 119, 179, 29);
		frame.getContentPane().add(hoVaTen);
		hoVaTen.setColumns(10);

		JLabel lblNewLabel_2_1 = new JLabel("Ngành đào tạo:");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_1.setBounds(52, 274, 116, 29);
		frame.getContentPane().add(lblNewLabel_2_1);

		tuoi = new JTextField();
		tuoi.setForeground(SystemColor.desktop);
		tuoi.setColumns(10);
		tuoi.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		tuoi.setBackground(SystemColor.menu);
		tuoi.setBounds(206, 157, 179, 29);
		frame.getContentPane().add(tuoi);

		gioiTinh = new JTextField();
		gioiTinh.setForeground(SystemColor.desktop);
		gioiTinh.setColumns(10);
		gioiTinh.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		gioiTinh.setBackground(SystemColor.menu);
		gioiTinh.setBounds(206, 199, 179, 29);
		frame.getContentPane().add(gioiTinh);

		diaChi = new JTextField();
		diaChi.setForeground(SystemColor.desktop);
		diaChi.setColumns(10);
		diaChi.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		diaChi.setBackground(SystemColor.menu);
		diaChi.setBounds(206, 238, 179, 29);
		frame.getContentPane().add(diaChi);

		btnThem = new JButton("Thêm");
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnThem.setBounds(52, 386, 120, 49);
		frame.getContentPane().add(btnThem);

		btnClear = new JButton("Clear");
		btnClear.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				hoVaTen.setText("");
				tuoi.setText("");
				gioiTinh.setText("");
				diaChi.setText("");
				nganhDaoTao.setText("");
				tenTimKiem.setText("");
			}
		});
		btnClear.setBounds(265, 386, 120, 49);
		frame.getContentPane().add(btnClear);

		btnDelete = new JButton("Xóa");
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnDelete.setBounds(52, 455, 120, 49);
		frame.getContentPane().add(btnDelete);

		btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnTimKiem.setBounds(265, 455, 120, 49);
		frame.getContentPane().add(btnTimKiem);

		nganhDaoTao = new JTextField();
		nganhDaoTao.setForeground(SystemColor.desktop);
		nganhDaoTao.setColumns(10);
		nganhDaoTao.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		nganhDaoTao.setBackground(SystemColor.menu);
		nganhDaoTao.setBounds(206, 277, 179, 29);
		frame.getContentPane().add(nganhDaoTao);

		JButton btnClose = new JButton("Close");
		btnClose.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnClose.setBounds(416, 566, 138, 50);
		btnClose.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				frame.dispose();
			}
		});
		frame.getContentPane().add(btnClose);

		JLabel lblNewLabel_2_1_1 = new JLabel("Tìm kiếm(bằng tên):");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_1_1.setBounds(52, 313, 138, 29);
		frame.getContentPane().add(lblNewLabel_2_1_1);

		tenTimKiem = new JTextField();
		tenTimKiem.setForeground(SystemColor.desktop);
		tenTimKiem.setColumns(10);
		tenTimKiem.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		tenTimKiem.setBackground(SystemColor.menu);
		tenTimKiem.setBounds(206, 316, 179, 29);
		frame.getContentPane().add(tenTimKiem);
		frame.setVisible(true);
	}

	// phương thức thiết lập và truyền thông tin vào bảng
	public void setDataForTable(ArrayList<Kysu> data) {
		model = new DefaultTableModel();
		model.setColumnIdentifiers(colName);
		for (Kysu i : data) {
			Object[] row = { i.getHoTen(), i.getTuoi(), i.getGioiTinh(), i.getDiaChi(), i.getNganhDaoTao() };
			model.addRow(row);
		}
		table.setModel(model);
	}

	// phương thức lấy tên tìm kiếm
	public String getTextToFind() {
		return tenTimKiem.getText();
	}

	// các phương thức đặt gắn hiệu ứng cho nút thêm, xóa, tìm kiếm
	public void setActionAddButton(ActionListener action) {
		btnThem.addActionListener(action);
	}

	public void setActionDeleteButton(ActionListener action) {
		btnDelete.addActionListener(action);
	}

	public void setActionListenerFind(ActionListener action) {
		btnTimKiem.addActionListener(action);
	}

	// phương thức hiện message
	public void showMessage(String message) {
		JOptionPane.showMessageDialog(frame, message);
	}

	// các phương thức lấy thông tin của ký sư mới từ textfieid
	public String getHoTen() throws Exception {
		String name = hoVaTen.getText();
		if (name.equals("")) {
			hoVaTen.requestFocus();
			throw new Exception("Chưa điền họ tên");
		}
		return name;

	}

	public String getTuoi() throws Exception {
		String tuoi = this.tuoi.getText();
		if (tuoi.equals("")) {
			this.tuoi.requestFocus();
			throw new Exception("Chưa điền tuổi");
		}
		return tuoi;

	}

	public String getGioiTinh() throws Exception {
		String gioiTinh = this.gioiTinh.getText();
		if (gioiTinh.equals("")) {
			this.gioiTinh.requestFocus();
			throw new Exception("Chưa điền giới tính");
		}
		return gioiTinh;

	}

	public String getDiaChi() throws Exception {
		String diaChi = this.diaChi.getText();
		if (diaChi.equals("")) {
			this.diaChi.requestFocus();
			throw new Exception("Chưa điền địa chỉ");
		}
		return diaChi;

	}

	public String getNganhDaoTao() throws Exception {
		String nganhDaoTao = this.nganhDaoTao.getText();
		if (nganhDaoTao.equals("")) {
			this.nganhDaoTao.requestFocus();
			throw new Exception("Chưa điền ngành đào tạo");
		}
		return nganhDaoTao;

	}

	public Kysu getSelectedInfo() throws Exception {
		int selectedRow = table.getSelectedRow();
		if (selectedRow == -1)
			throw new Exception("Chưa chọn thông tin");
		String[] t = { table.getValueAt(selectedRow, 0).toString(), table.getValueAt(selectedRow, 1).toString(),
				table.getValueAt(selectedRow, 2).toString(), table.getValueAt(selectedRow, 3).toString(),
				table.getValueAt(selectedRow, 4).toString() };
		Kysu ks = new Kysu(t);
		return ks;
	}
}
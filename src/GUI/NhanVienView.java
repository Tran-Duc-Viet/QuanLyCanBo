package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;
import Model.Entity.*;

public class NhanVienView {

	private JFrame frame;
	private JTextField hoVaTen;
	private JTextField tuoi;
	private JTextField gioiTinh;
	private JTextField diaChi;
	private JTable table;
	private DefaultTableModel model;
	public static final String colName[] = { "Họ và tên", "Tuổi", "Giới tính", "Địa chỉ", "Công việc" };// tên các cột
																										// của bảng
	private JTextField congViec;
	private JTextField tenTimKiem;
	private JButton btnThem, btnClear, btnXemDS, btnTimKiem;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public NhanVienView() {
		// initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1121, 676);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		JLabel lblNewLabel = new JLabel("Quản Lý Nhân Viên");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(383, 10, 197, 50);
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

		JLabel lblDiaChi = new JLabel("Địa Chỉ:");
		lblDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDiaChi.setBounds(52, 235, 75, 29);
		frame.getContentPane().add(lblDiaChi);

		hoVaTen = new JTextField();
		hoVaTen.setBackground(SystemColor.menu);
		hoVaTen.setForeground(SystemColor.desktop);
		hoVaTen.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		hoVaTen.setBounds(206, 119, 179, 29);
		frame.getContentPane().add(hoVaTen);
		hoVaTen.setColumns(10);

		JLabel lblCongViec = new JLabel("Công Việc");
		lblCongViec.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCongViec.setBounds(52, 274, 116, 29);
		frame.getContentPane().add(lblCongViec);

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
			public void actionPerformed(ActionEvent e) {
				hoVaTen.setText("");
				tuoi.setText("");
				gioiTinh.setText("");
				diaChi.setText("");
				congViec.setText("");
				tenTimKiem.setText("");
			}
		});
		btnClear.setBounds(265, 386, 120, 49);
		frame.getContentPane().add(btnClear);

		btnXemDS = new JButton("Xem danh sách");
		btnXemDS.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnXemDS.setBounds(52, 455, 120, 49);
		frame.getContentPane().add(btnXemDS);

		btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnTimKiem.setBounds(265, 455, 120, 49);
		frame.getContentPane().add(btnTimKiem);

		congViec = new JTextField();
		congViec.setForeground(SystemColor.desktop);
		congViec.setColumns(10);
		congViec.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		congViec.setBackground(SystemColor.menu);
		congViec.setBounds(206, 277, 179, 29);
		frame.getContentPane().add(congViec);

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

		JLabel lblTenTimKiem = new JLabel("Tìm kiếm(bằng tên):");
		lblTenTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTenTimKiem.setBounds(52, 313, 138, 29);
		frame.getContentPane().add(lblTenTimKiem);

		tenTimKiem = new JTextField();
		tenTimKiem.setForeground(SystemColor.desktop);
		tenTimKiem.setColumns(10);
		tenTimKiem.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		tenTimKiem.setBackground(SystemColor.menu);
		tenTimKiem.setBounds(206, 316, 179, 29);
		frame.getContentPane().add(tenTimKiem);
		frame.setVisible(true);
	}

	// phương thức chuyền thông tin vào cho bảng
	public void setDataForTable(ArrayList<Nhanvien> data) {
		model = new DefaultTableModel();
		model.setColumnIdentifiers(colName);
		for (Nhanvien i : data) {
			Object[] row = { i.getHoTen(), i.getTuoi(), i.getGioiTinh(), i.getDiaChi(), i.getCongViec() };
			model.addRow(row);
		}
		table.setModel(model);
	}

//phương thức lấy tên tìm kiếm
	public String getTextToFind() {
		return tenTimKiem.getText();
	}

//các phương thức đặt gắn hiệu ứng cho nút thêm, xem danh sách, tìm kiếm
	public void setActionAddButton(ActionListener action) {
		btnThem.addActionListener(action);
	}

	public void setActionXemDsButton(ActionListener action) {
		btnXemDS.addActionListener(action);
	}

	public void setActionListenerFind(ActionListener action) {
		btnTimKiem.addActionListener(action);
	}

	// phương thức hiện message
	public void showMessage(String message) {
		JOptionPane.showMessageDialog(frame, message);
	}

	// các phương thức lấy thông tin của nhân viên mới từ textfieid
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

	public String getCongViec() throws Exception {
		String congViec = this.congViec.getText();
		if (congViec.equals("")) {
			this.congViec.requestFocus();
			throw new Exception("Chưa điền công việc");
		}
		return congViec;

	}

}

package GUI;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
//lớp giao diện chính
public class CanBoView {

	private JFrame frame;
	private JButton btnCongNhan,btnKySu,btnNhanvien ;
	private JButton btnClose;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */
	public CanBoView() {
		//initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1142, 544);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Quản Lý Cán Bộ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(473, 10, 290, 92);
		frame.getContentPane().add(lblNewLabel);
		
		btnCongNhan = new JButton("Công Nhân");
		btnCongNhan.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCongNhan.setBounds(282, 242, 203, 81);
		frame.getContentPane().add(btnCongNhan);
		
		btnKySu = new JButton("Kỹ Sư");
		btnKySu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnKySu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnKySu.setBounds(530, 242, 203, 81);
		frame.getContentPane().add(btnKySu);
		
		btnNhanvien = new JButton("NhanVien");
		btnNhanvien.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNhanvien.setBounds(785, 242, 203, 81);
		frame.getContentPane().add(btnNhanvien);
		
		btnClose = new JButton("Close");
		btnClose.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnClose.setBounds(530, 373, 203, 81);
		frame.getContentPane().add(btnClose);
		frame.setVisible(true);
	}
//các phương thức gắn hiệu ứng cho các nút công nhân, ký sư, nhân viên, close
	public void setActionCongNhan(ActionListener action) {
		btnCongNhan.addActionListener(action);
	}
	public void setActionKySu(ActionListener action) {
		btnKySu.addActionListener(action);
	}
	public void setActionNhanVien(ActionListener action) {
		btnNhanvien.addActionListener(action);
	}
	public void setActionClose(ActionListener action) {
		btnClose.addActionListener(action);
	}

}

package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import GUI.CanBoView;

//lớp điều khiển giao diện cán bộ
public class CanBoController {
	private CanBoView canBoView = new CanBoView();

	// pương thức khởi tạo lớp CanBoController
	public CanBoController() {
		canBoView.initialize();
		canBoView.setActionCongNhan(new CongNhanBtn());
		canBoView.setActionKySu(new KySuBtn());
		canBoView.setActionNhanVien(new NhanVienBtn());
		canBoView.setActionClose(new CloseBtn());

	}

	// lớp hành động cho nút công nhân
	class CongNhanBtn implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			new CongNhanController();
		}
	}
	// lớp hành động cho nút ký sư

	class KySuBtn implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			new KySuController();
		}
	}

	// lớp hành động cho nút nhân viên
	class NhanVienBtn implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			new NhanVienController();
		}
	}

	// lớp hành động cho nút đóng chương trình
	class CloseBtn implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			System.exit(0);
		}
	}
}

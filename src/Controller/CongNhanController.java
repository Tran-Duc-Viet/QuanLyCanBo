package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import Model.Entity.Congnhan;
import Model.Model.*;
import GUI.CongNhanView;

//lớp điều khiển của giao diện công nhân
public class CongNhanController {
	private CongNhanView congNhanView = new CongNhanView();
	private CongNhanModel congNhanModel = new CongNhanModel(congNhanView);

	// phương thức khởi tạo lớp CongNhanController
	public CongNhanController() {
		congNhanView.initialize();
		// đặt hiệu ứng khi bấm nút cho các nút trong lớp congNhanView
		congNhanView.setActionAddButton(new themBtnAction());
		congNhanView.setActionDeleteButton(new deleteBtnAction());
		congNhanView.setActionListenerFind(new findAction());
		try {
			congNhanView.setDataForTable(congNhanModel.getData(""));
		} catch (Exception e) {
			congNhanView.showMessage(e.getMessage());
		}

	}

	// lớp hiệu ứng của nút tìm kiếm
	class findAction implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			try {
				congNhanModel.timKiem(congNhanView.getTextToFind());
				;
			} catch (Exception e) {
				congNhanView.showMessage(e.getMessage());
			}
		}

	}

	// lớp hiệu ứng của nút thêm
	class themBtnAction implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			try {
				String[] t = new String[5];
				t[0] = congNhanView.getHoTen();
				t[1] = congNhanView.getTuoi();
				t[2] = congNhanView.getGioiTinh();
				t[3] = congNhanView.getDiaChi();
				t[4] = congNhanView.getBac();
				Congnhan congNhan = new Congnhan(t);
				congNhanModel.them(congNhan);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				congNhanView.showMessage(e.getMessage());
			}
		}
	}

	// lớp hiệu ứng của nút xóa
	class deleteBtnAction implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			try {
				congNhanModel.delete(congNhanView.getSelectedInfo());
				congNhanView.setDataForTable(congNhanModel.getData(""));
				congNhanView.showMessage("Xóa dữ liệu thành công");
			} catch (Exception e) {
				// TODO: handle exception
				congNhanView.showMessage(e.getMessage());
			}
		}
	}

}

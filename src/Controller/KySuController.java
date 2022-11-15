package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import GUI.KySuView;
import Model.Entity.Kysu;
import Model.Model.*;

//lớp điều khiển của giao diện kỹ sư
public class KySuController {
	private KySuView kySuView = new KySuView();
	private KySuModel kySuModel = new KySuModel(kySuView);

	// Phương thức khởi tạo lớp KySuController
	public KySuController() {
		kySuView.initialize();
		// đặt hiệu ứng cho các nút trong gia diện ký sư
		kySuView.setActionAddButton(new themBtnAction());
		kySuView.setActionXemDSButton(new xemDSBtnAction());
		kySuView.setActionListenerFind(new findAction());
		try {
			kySuView.setDataForTable(kySuModel.getData(""));
			;
		} catch (Exception e) {
			kySuView.showMessage(e.getMessage());
		}

	}

	// lớp hiệu ứng của nút thêm
	class themBtnAction implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			try {
				String[] t = new String[5];
				t[0] = kySuView.getHoTen();
				t[1] = kySuView.getTuoi();
				t[2] = kySuView.getGioiTinh();
				t[3] = kySuView.getDiaChi();
				t[4] = kySuView.getNganhDaoTao();
				Kysu kySu = new Kysu(t);
				kySuModel.them(kySu);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				kySuView.showMessage(e.getMessage());
			}
		}
	}

	// lớp hiệu ứng cửa nút tìm kiếm
	class findAction implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			try {
				kySuModel.timKiem(kySuView.getTextToFind());
				;
			} catch (Exception e) {
				kySuView.showMessage(e.getMessage());
			}
		}
	}

	// lớp hiệu ứng của nút xem danh sách
	class xemDSBtnAction implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			try {
				kySuModel.xemDS();

			} catch (Exception e) {
				// TODO Auto-generated catch block
				kySuView.showMessage(e.getMessage());
			}
		}
	}
}

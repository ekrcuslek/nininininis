package hotel.service;

import java.util.List;

import hotel.dao.GongjiDAO;
import hotel.domain.Gongji;

public class GongjiService {
	GongjiDAO gd = new GongjiDAO();
	
	public List<Gongji> selectAll() {
		List<Gongji> gjList = gd.selectAll();
		return gjList;
	}
	
	public void insertNewData(Gongji gongji) {
		gd.insertNewData(gongji);
	}
	public void update(Gongji gongji) {
		gd.update(gongji);
	}
	public void delete(Gongji gongji) {
		gd.delete(gongji);
	}
	public Gongji selectOne(int no) {
		List<Gongji> gjList = gd.selectAll();
		Gongji gj = new Gongji();
		for(int i=0; i < gjList.size(); i++) {
			if(no==gjList.get(i).getNo()) {
				gj.setNo(gjList.get(i).getNo());
				gj.setTitle(gjList.get(i).getTitle());
				gj.setText(gjList.get(i).getText());
				gj.setDate(gjList.get(i).getDate());
			}
			
		}
		return gj;
	}
}

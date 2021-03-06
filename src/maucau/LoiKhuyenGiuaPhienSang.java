package maucau;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import stockmarket.BigStock;

public class LoiKhuyenGiuaPhienSang implements MauCau {
	
	private static List<String> moDau;
	private static List<String> giuaCauTang;
	private static List<String> giuaCauGiam;
	private static List<String> nhanXet;
	
	private BigStock stock;
	
	public LoiKhuyenGiuaPhienSang(BigStock stock) {
		
		this.stock = stock;
		moDau = new ArrayList<String>();
		giuaCauTang = new ArrayList<String>();
		giuaCauGiam = new ArrayList<String>();
		nhanXet = new ArrayList<String>();
		
		moDau.add("Tạm nghỉ giữa phiên sáng ");
		moDau.add("Đến giữa phiên sáng nay ");
		moDau.add("Sau mở đầu đầy biến động, đến gữa phiên sáng nay ");
		
		giuaCauTang.add(" tăng thêm ");
		giuaCauTang.add(" cộng thêm ");
		giuaCauTang.add(" tiếp tục đà tăng khi có thêm ");
		giuaCauTang.add(" tăng ");
		
		giuaCauGiam.add(" tiếp tục giảm thêm ");
		giuaCauGiam.add(" giảm ");
		giuaCauGiam.add(" mất ");
		
		nhanXet.add(", khuyến nghị mua vào ");
		nhanXet.add(", một số chuyên gia đưa ra lời khuyên nên mua cổ phiếu ");
		nhanXet.add(", phần đông các chuyên gia đều có nhận định nên mua ");
		nhanXet.add(", Theo ông Đỗ Hiệp Hòa, chuyên gia phân tích của Công ty Chứng khoán Thăng Long, khách hàng nên mua vào cổ phiếu ");
		nhanXet.add(", có một số lời khuyên nên mua ");
		
	}
	
	public String sinhCau() {
		String loiKhuyenGiuaPhienSang = null;
		StringBuffer sb = new StringBuffer();
		String dauCau = moDau.get(new Random().nextInt(moDau.size()));
		String giuaCau;
		String loiKhuyen = nhanXet.get(new Random().nextInt(nhanXet.size()));
		String symbol = stock.getSymbol();
		double giaMoCuaHomNay = stock.getGiaMoCua();
		double giaGiuaPhienSang = stock.getGiaGiuaPhienSang();
		double chenhLech = giaGiuaPhienSang - giaMoCuaHomNay;
		//Thieu ma co phieu
		
		if(chenhLech >=0) {
			giuaCau = giuaCauTang.get(new Random().nextInt(giuaCauTang.size()));
		}
		else {
			giuaCau = giuaCauGiam.get(new Random().nextInt(giuaCauGiam.size()));
			chenhLech = -chenhLech;
		}
		
		sb.append(dauCau); sb.append(symbol); sb.append(giuaCau); sb.append(chenhLech); sb.append(", dừng ở ");
		sb.append(giaGiuaPhienSang); sb.append(loiKhuyen); sb.append();
		loiKhuyenGiuaPhienSang = sb.toString();
		
		return null;
		
	}

}

package sd18301.hl_sof2041;

import models.NhanVien;

public class MainClass {
    public static void main(String[] args) {
        // Khai báo biến nv có kiểu dữ liệu là NhanVien
        NhanVien nv; // Giá trị NULL
        
        // Khởi tạo đối tượng NhanVien
        nv = new NhanVien();
        nv.setMaNV("PH30873");
        System.out.println( nv.getMaNV() );
    }
}

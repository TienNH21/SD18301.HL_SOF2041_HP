package models;

public class NhanVien {
    private String maNV;
    private String matKhau;
    private String hoTen;
    private int vaiTro;

    /*
    Hàm khởi tạo bắt buộc cùng tên class, không có kiểu trả về.
    */
    public NhanVien() {
    }

    public NhanVien(String maNV, String matKhau, String hoTen, int vaiTro) {
        this.maNV = maNV;
        this.matKhau = matKhau;
        this.hoTen = hoTen;
        this.vaiTro = vaiTro;
    }
    
    // Getter, Setter, Constructor
    public String getMaNV()
    {
        return this.maNV;
    }
    
    public void setMaNV(String ma)
    {
        this.maNV = ma;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public int getVaiTro() {
        return vaiTro;
    }

    public void setVaiTro(int vaiTro) {
        this.vaiTro = vaiTro;
    }
    
}

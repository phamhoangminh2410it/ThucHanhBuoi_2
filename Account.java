import java.text.NumberFormat;
import java.util.Scanner;
 
public class Account 
{
    private long soTK;
    private String tenTK;
    private double soTienTrongTK;
    private String trangThai;
 
    Scanner sc = new Scanner(System.in);
 
    public Account() 
    {
    }
 
    public Account(long soTK, String tenTK, double soTienTrongTK, String trangThai) 
    {
        this.soTK = soTK;
        this.tenTK = tenTK;
        this.soTienTrongTK = soTienTrongTK;
        this.trangThai = trangThai;
    }
 
    public long getSoTK() 
    {
        return this.soTK;
    }
 
    public void setSoTK(long soTK) 
    {
        this.soTK = soTK;
    }
 
    public String getTenTK() 
    {
        return this.tenTK;
    }
 
    public void setTenTK(String tenTK) 
    {
        this.tenTK = tenTK;
    }
 
    public double getSoTienTrongTK() 
    {
        return this.soTienTrongTK;
    }
 
    public void setSoTienTrongTK(double soTienTrongTK) 
    {
        this.soTienTrongTK = soTienTrongTK;
    }

    public String getTrangThai()
    {
        return this.trangThai;
    }

    public void setTrangThai(String trangThai)
    {
        this.trangThai = trangThai;
    }
 
    public String toString() 
    {
        NumberFormat currencyEN = NumberFormat.getCurrencyInstance();
        String str1 = currencyEN.format(soTienTrongTK);
        return soTK + "-" + tenTK + "-" + str1 + "-" + trangThai;
    }
 
    public double napTien() 
    {
        double nap;
        System.out.print("Nhap So Tien Can Nap: ");
        nap = sc.nextDouble();
        if (nap >= 0) 
        {
            soTienTrongTK = nap + soTienTrongTK;
            NumberFormat currencyEN = NumberFormat.getCurrencyInstance();
            String str1 = currencyEN.format(nap);
            System.out.println("Da Nap " + str1 + " Vao Tai Khoan");
        } 
        else 
        {
            System.out.println("So Tien Can Nap Khong Hop Ly!");
        }
        return nap;
    }
 
    public double rutTien() 
    {
        double rut;
        System.out.print("Nhap So Tien Can Rut Ra: ");
        rut = sc.nextDouble();
        if (rut <= soTienTrongTK) 
        {
            soTienTrongTK = soTienTrongTK - rut;
            NumberFormat currencyEN = NumberFormat.getCurrencyInstance();
            String str1 = currencyEN.format(rut);
            System.out.println("Da Rut" + str1 + "D Tu Tai Khoan");
        } 
        else 
        {
            System.out.println("So Tien Muon Rut Khong Hop Ly!");
            return rutTien();
        }
        return rut;
    }
 
    public double daoHan() 
    {
        double laiSuat = 0.035;
        soTienTrongTK = soTienTrongTK + soTienTrongTK * laiSuat;
        NumberFormat currencyEN = NumberFormat.getCurrencyInstance();
        String str1 = currencyEN.format(soTienTrongTK);
        System.out.println("Da Duoc " + str1 + " Tu Dao Han 1 Thang");
        return soTienTrongTK;
    }
 
    void inTK() 
    {
        NumberFormat currencyEN = NumberFormat.getCurrencyInstance();
        String str1 = currencyEN.format(soTienTrongTK);
        System.out.printf("%-10d %-20s %-20s \n", soTK, tenTK, str1);
    }
}
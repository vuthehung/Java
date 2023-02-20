/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package J05042;

/**
 *
 * @author Admin
 */
public class XepHang implements Comparable<XepHang>{
    private String tenSV;
    private int ac, submit;
    
    public XepHang(String tenSV, int ac, int submit) {
        this.tenSV = tenSV;
        this.ac = ac;
        this.submit = submit;
    }
    @Override
    public int compareTo(XepHang o) {
        if(this.ac != o.ac) {
            return o.ac - this.ac;
        }else if(this.ac == o.ac) {
            return this.submit - o.submit;
        }else {
            return this.tenSV.compareTo(o.tenSV);
        }
    }
    
    @Override
    public String toString() {
        return tenSV + " " + ac + " " + submit;
    }
}

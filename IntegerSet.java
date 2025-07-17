import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IntegerSet {
        private List<Integer> number;
    // Rep Invariant (RI):
    //  - num ต้องไม่มีตัวเลขซ้ำกัน
    //  - num ต้องไม่มี null
    //  - ตัวเลขใน num ต้องเรียงกันจากน้อยไปมาก
    //
    // Abstraction Function (AF):
    //  - AF(s) = เซตของจำนวนเต็มในอาร์เรย์ num


    public IntegerSet(){
        number = new ArrayList<>();
        checkRep();
    }

    private void checkRep() {
        //Array ต้องไม่ null
        assert number != null : "Rep invariant violated! : null moment.";

        //ต้องไม่มีตัวเลขที่ null
        for (Integer num : number) {
            assert num != null : "Rep invariant violated! : null moment.";
        }
        //ตรวจตัวเลขว่าเรียงและซ้ำซ้อนกันไหม
        for (int i = 0; i < number.size() - 1; i++) {
            assert number.get(i) < number.get(i + 1) :
                   "Rep invariant violated! : ตัวเลขไม่เรียงหรือซ้ำกัน";
        }
    }
    /**
     * เพิ่มตัวเลขเข้าเซต
     * @param num ตัวเลขที่ต้องการเพิ่ม
     */
    public void add(Integer num) {
        
        if (!number.contains(num)) {
            number.add(num);
            Collections.sort(number);
        }
        checkRep();
    }
    /**
     * ลบตัวเลขออกจากเซต
     * @param num ตัวเลขที่ต้องการลบ
     */
    public void remove(Integer num) {
        int index = number.indexOf(num);
        if(index != -1)    
        number.remove(num);

            checkRep();
    
    }

    /**
     * ตรวจสอบว่ามีตัวเลขนี้อยู่ในเซตหรือไม่
     * @param num ตัวเลขที่ต้องการตรวจสอบ
     * @return true หากมี num อยู่ในเซต, false หากไม่มี
     */
    public boolean contains(Integer num) {
        return number.contains(num);
    }

    /**
     * คืนจำนวนสมาชิกในเซต
     * @return ขนาดของเซต
     */
    public int size() {
        return number.size();
    }

    @Override
    public String toString() {
        return number.toString();
    }
}
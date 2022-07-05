package In.House.Q729;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class MyCalendar {

    private List<int[]> list;

    public MyCalendar() {
        this.list = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        for (int[] arr: this.list) {
            if (arr[1] <= start) {
                continue;
            }
            if (arr[0] < end) {
                return false;
            }
            break;
        }
        this.list.add(new int[] {start, end});
        Collections.sort(this.list, Comparator.comparingInt(l -> l[0]));
        return true;
    }

    public static void main(String[] args) {
        MyCalendar myCalendar = new MyCalendar();
        System.out.println(myCalendar.book(10, 20)); // return True
        System.out.println(myCalendar.book(15, 25)); // return False
        System.out.println(myCalendar.book(20, 30)); // return True
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
package In.House.Q385;

import java.util.ArrayList;
import java.util.List;

public class NestedIntegerImpl implements NestedInteger {

    private int type; // 0 -> empty, 1 -> integer, 2 -> list
    private Integer intVal;
    private List<NestedInteger> listVal;

    public NestedIntegerImpl() {
        this.type = 2;
        this.listVal = new ArrayList<>();
    }

    public NestedIntegerImpl(int value) {
        this.type = 1;
        this.intVal = value;
        this.listVal = new ArrayList<>();
    }

    public boolean isInteger() {
        return this.type == 1;
    }

    public Integer getInteger() {
        return this.type == 1 ? this.intVal : null;
    }

    public void setInteger(int value) {
        this.type = 1;
        this.intVal = value;
        this.listVal.clear();
    }

    public void add(NestedInteger ni) {
        this.type = 2;
        this.listVal.add(ni);
    }

    public List<NestedInteger> getList() {
        return this.listVal;
    }

}

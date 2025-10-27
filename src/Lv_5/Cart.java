package Lv_5;

import java.util.ArrayList;
import java.util.List;
public class Cart <T extends MenuItem>  {
    //속
    private final List<T> items = new ArrayList<>();
    //생

    //기
    public void addItem(T item){
        items.add(item);
    }

    public void remoteItem(T item){
        items.remove(item);
    }

}

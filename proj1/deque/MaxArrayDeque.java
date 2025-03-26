package deque;

import java.util.Comparator;

public class MaxArrayDeque <T> extends ArrayDeque<T>{
    private Comparator<T> comparator;
    public MaxArrayDeque(Comparator<T> c){
        super();
        comparator = c;
    }

    public T max(){
        return max(comparator);
    }

    public T max(Comparator<T> c){
        if (this.isEmpty()){
            return null;
        }
        T maxvalue = this.get(0);
        for (int i = 1 ;i <this.size();i++){
            T curcalue = this.get(i);
            if (c.compare(maxvalue,curcalue)<0){
                maxvalue = curcalue;
            }
        }
        return maxvalue;
    }
}

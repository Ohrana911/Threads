package RKSP_FIRST_EXERSIZE;

import java.util.ArrayList;
import java.util.Random;

public class InputArray {
    private int size;
    Random random = new Random();

    public InputArray(int size){
        this.size = size;
    }

    public ArrayList getArray(ArrayList arrayList){
        for (int i = 0; i < this.size; i++){
            arrayList.add(i, random.nextInt(100));
        }
        return arrayList;
    }
}

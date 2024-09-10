package RKSP_FIRST_EXERSIZE;

import java.util.ArrayList;

public class Exe1_1 {

    private int sum = 0;
    public int FunctionOne(ArrayList<Integer> arrayList) throws InterruptedException{
        for (int i = 0; i < arrayList.size(); i++) {
            sum += arrayList.get(i);
            Thread.sleep(1);
        }
        return sum;
    }
}



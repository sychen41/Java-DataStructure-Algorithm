package round2;

/**
 * Created by Shiyi on 11/2/2016.
 */
public class MyArrayListVer1Main {
    public static void main(String[] args) {
        MyArrayListVer1<Integer> arrList = new MyArrayListVer1<>(Integer.class);
        arrList.add(0);
        arrList.add(1);
        arrList.add(2);
        arrList.add(4);
        arrList.add(5);
        arrList.add(3,3);

        for(Integer num: arrList)
            System.out.print(num+" ");
        System.out.println();
        System.out.println(arrList.size());

        arrList.remove(4);
        for(Integer num: arrList)
            System.out.print(num+" ");
        System.out.println();
        System.out.println(arrList.size());

        if (arrList.contains(3))
            System.out.println("contains 3");
        if (arrList.contains(6))
            System.out.println("contains 6");

        for(Integer num: arrList)
            System.out.print(num+" ");
        System.out.println();
    }
}

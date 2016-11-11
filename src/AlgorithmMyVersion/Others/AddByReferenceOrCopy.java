package AlgorithmMyVersion.Others;

import DataStructureMyVersion.MyHashTableVer1;

import java.util.HashMap;
import java.util.HashSet;


/**
 * Created by Shiyi on 11/4/2016.
 */
public class AddByReferenceOrCopy {
    public String str;
    public AddByReferenceOrCopy(String str) {
        this.str = str;
    }
    //override equals() requires overriding hashCode() also.
    //because if a equals to b implies(=>) a.hashCode = b.hashCode.
    @Override
    public boolean equals(Object that) {
        if (!(that instanceof AddByReferenceOrCopy)) return false;
        if (that == this) return true;
        AddByReferenceOrCopy thatCast = (AddByReferenceOrCopy) that;
        if (thatCast.str.equals(str)) return true;
        return false;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime*result + str.hashCode();
        return result;
        //return new HashCodeBuilder();
    }

    public static void main(String[] args) {
        HashSet<AddByReferenceOrCopy> set = new HashSet<>();
        AddByReferenceOrCopy temp1 = new AddByReferenceOrCopy("temp");
        AddByReferenceOrCopy temp2 = new AddByReferenceOrCopy("TEMP");
        set.add(temp1);
        temp1.str = "TEMP"; // change value after being added to the set. temp1's hashcode is the old one.
        for(AddByReferenceOrCopy element: set)
            System.out.println(element.str); // shows that adding to the set by reference, so it's better to make the object immutable
                                            // simplest way: make str private

        //System.out.println(temp1.hashCode());
        //System.out.println(temp2.hashCode());
        if (temp1.equals(temp2)) {
            System.out.println("because of the override 'equals', temp1 and temp2 are now equal.");
        }
        if (set.contains(temp2))
            System.out.println("set contains temp2 (without adding temp2 to the set)");
        else
            System.out.println("set does NOT contains temp2, because even though temp2 equals temp1," +
                    "they have different hashCode. (temp1.str is changed AFTER being added to the set");

        MyHashTableVer1<AddByReferenceOrCopy, String> ht = new MyHashTableVer1<>();
        ht.put(temp1, "test");
        //ht.put(temp2, "test");
        if (ht.contains(temp2))
            System.out.println("ht contains temp2 (without adding temp2 to the hash table)");

        HashMap<AddByReferenceOrCopy, String> hm = new HashMap<>();
        hm.put(temp1, "test");
        //ht.put(temp2, "test");
        if (hm.containsKey(temp2))
            System.out.println("hm contains temp2 (without adding temp2 to the hash map)");


    }
}

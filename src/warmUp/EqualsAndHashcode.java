package warmUp;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Shiyi on 9/29/2016.
 */
class Professor {
    public long id;
    public String name;

    public Professor(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "id: " + id + "\nname: " + name;
    }
    @Override
    public boolean equals(Object that) {
        if (that == null) return false;
        if (!(that instanceof Professor)) return false;
        Professor pThat = (Professor)that;
        if (this.id != pThat.id) return false;
        //if bla bla bla ...
        return true;
    }
    @Override
    public int hashCode() {
        return (int) id;
        //return (int) id * name.hashCode();
    }
}
public class EqualsAndHashcode {
    public static void main(String[] args) {
        List<Professor> list = new ArrayList<>();
        Professor p1 = new Professor(123,"Chen");
        Professor p2 = new Professor(123, "Shiyi");
        if (p1 == p2) System.out.println("p1 p2 point to the same address");
        if (p1.equals(p2)) System.out.println("p1 and p2 are the same by equals method");
        list.add(p1);
        list.add(p2);
        for(Professor p: list) System.out.println(p.toString());
        System.out.println();
        while(list.contains(p2)) {
            list.remove(p2); // because of override equals, that can be done
            System.out.println("found and removed");
        }
        for(Professor p: list) System.out.println(p.toString());
        assertEquals(0,list.size());
        Set<Professor> set = new HashSet<>();
        set.add(p1);
        set.add(p2); // because of overriding hashCode, p2 is
                    //  considered as the same as p1, thus won't be added
        assertEquals(1,set.size());
    }
}

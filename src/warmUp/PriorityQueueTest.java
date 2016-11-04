package warmUp;
import java.util.*;

class Student1{
   private int token;
   private String fname;
   private double cgpa;
   public Student1(int id, String fname, double cgpa) {
      super();
      this.token = id;
      this.fname = fname;
      this.cgpa = cgpa;
   }
   public int getToken() {
      return token;
   }
   public String getFname() {
      return fname;
   }
   public double getCgpa() {
      return cgpa;
   }
   static class Student1Comp implements Comparator<Student1> {
		@Override
		public int compare(Student1 s1, Student1 s2) {
			int comp = -1*Double.valueOf(s1.getCgpa()).compareTo(Double.valueOf(s2.getCgpa()));
			if (comp == 0) 
				comp = s1.getFname().compareTo(s2.getFname());
			if (comp == 0)
				comp = Integer.valueOf(s1.getToken()).compareTo(Integer.valueOf(s2.getToken()));
			return comp;
		}
	}
}


public class PriorityQueueTest {

    public static void main(String[] args) {
    	Queue<Student1> stuQ = new PriorityQueue<>(new Student1.Student1Comp());
		Scanner in = new Scanner(System.in);
		int totalEvents = Integer.parseInt(in.nextLine());
		while(totalEvents>0){
			String event = in.next();
			if (event.equals("ENTER")) {
				String name = in.next();
				double cgpa = in.nextDouble();
				int id = in.nextInt();
				stuQ.add(new Student1(id, name, cgpa));
			}
			else stuQ.poll();
			   
			totalEvents--;
		}

		int size = stuQ.size();
		if (size == 0) 
			System.out.println("EMPTY");
		else {
			for(int i=0;i<size;i++)
				System.out.println(stuQ.poll().getFname());
		}
			//for (Student1 stu: stuQ) System.out.println(stu.getFname());
    }
}
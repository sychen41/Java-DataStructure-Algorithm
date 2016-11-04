package warmUp;
import java.util.*;

public class Student{
	   private int id;
	   private String fname;
	   private double cgpa;
	   public Student(int id, String fname, double cgpa) {
	      super();
	      this.id = id;
	      this.fname = fname;
	      this.cgpa = cgpa;
	   }
	   public int getId() {
	      return id;
	   }
	   public String getFname() {
	      return fname;
	   }
	   public double getCgpa() {
	      return cgpa;
	   }

	//Complete the code
   public static void main(String[] args){
	  Scanner in = new Scanner(System.in);
	  int testCases = Integer.parseInt(in.nextLine());
	  
	  List<Student> studentList = new ArrayList<Student>();
	  while(testCases>0){
		 int id = in.nextInt();
		 String fname = in.next();
		 double cgpa = in.nextDouble();
		 
		 Student st = new Student(id, fname, cgpa);
		 studentList.add(st);
		 
		 testCases--;
	  }
	 /* 
	  studentList.sort(
		  (s1,s2) -> {
			  int comp = -1*(Double.valueOf(s1.getCgpa()).compareTo(Double.valueOf(s2.getCgpa())));
			  if (comp==0) {
				  comp = s1.getFname().compareTo(s2.getFname());
				  if (comp==0) 
					  comp = Integer.valueOf(s1.getId()).compareTo(Integer.valueOf(s2.getId()));
			  } 
			  return comp;
		  }
	  );
	  */
	  studentList.sort(new Comparator<Student>() {
	         @Override
	          public int compare(Student s1, Student s2) {
	              int comp = -1*(Double.valueOf(s1.getCgpa()).compareTo(Double.valueOf(s2.getCgpa())));
	              if (comp==0) {
	                  comp = s1.getFname().compareTo(s2.getFname());
	                  if (comp==0) 
	                      comp = Integer.valueOf(s1.getId()).compareTo(Integer.valueOf(s2.getId()));
	              } 
	              return comp;
	          }
	     });	   
	 for(Student st: studentList){
		 System.out.println(st.getFname());
	  }
   }
}

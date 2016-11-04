package warmUp;
import java.io.*;
import java.util.*;
import java.security.Permission;

class Calculate {
	private Scanner sc; 
	public AllAboutVolume output;
	public Calculate() {
		sc = new Scanner(System.in);
		output = new AllAboutVolume();
	}
	public int get_int_val() throws IOException {
		int input = Integer.parseInt(sc.nextLine());
		if (input <= 0) throw new NumberFormatException("All the values must be positive");
		if (input > 100) throw new IOException("");
		return input;
	}
	public double get_double_val() throws IOException {
		double input = Double.parseDouble(sc.nextLine());
		if (input <= 0) throw new NumberFormatException("All the values must be positive");
		if (input > 100) throw new IOException("");
		return input;
	}
	
	static AllAboutVolume do_calc() {
		return new AllAboutVolume();
	}


}

class AllAboutVolume {
	double get_volume(int a) {
		return 1.0*a*a*a;
	}
	double get_volume(int l, int b, int h) {
		return l*b*h;
	}
	double get_volume(double r) {
		return Math.PI*r*r*r*2/3;
	}
	double get_volume(double r, double h) {
		return Math.PI*r*r*h;
	}
	void display(double v) {
		System.out.printf("%.3f\n",v);
	}
}

public class OverrideTest {

	 public static void main(String[] args) {
	   DoNotTerminate.forbidExit();
	   try {
	    Calculate cal = new Calculate();
	    int T = cal.get_int_val();
	    while (T--> 0) {
	     double volume = 0.0;
	     int ch = cal.get_int_val();
	     if (ch == 1) {
	      int a = cal.get_int_val();
	      volume = Calculate.do_calc().get_volume(a);
	     } else if (ch == 2) {
	      int l = cal.get_int_val();
	      int b = cal.get_int_val();
	      int h = cal.get_int_val();
	      volume = Calculate.do_calc().get_volume(l, b, h);

	     } else if (ch == 3) {
	      double r = cal.get_double_val();
	      volume = Calculate.do_calc().get_volume(r);

	     } else if (ch == 4) {
	      double r = cal.get_double_val();
	      double h = cal.get_double_val();
	      volume = Calculate.do_calc().get_volume(r, h);

	     }
	     cal.output.display(volume);
	    }

	   } catch (NumberFormatException e) {
	    System.out.print(e);
	   } catch (IOException e) {
	    e.printStackTrace();
	   } catch (DoNotTerminate.ExitTrappedException e) {
	    System.out.println("Unsuccessful Termination!!");
	   }


	  } //end of main
	} //end of Solution

	/**
	 *This class prevents the user form using System.exit(0)
	 * from terminating the program abnormally.
	 *
	 */
	class DoNotTerminate {

	 public static class ExitTrappedException extends SecurityException {}

	 public static void forbidExit() {
	  final SecurityManager securityManager = new SecurityManager() {
	   @Override
	   public void checkPermission(Permission permission) {
	    if (permission.getName().contains("exitVM")) {
	     throw new ExitTrappedException();
	    }
	   }
	  };
	  System.setSecurityManager(securityManager);
	 }
	} //end of Do_Not_Terminate
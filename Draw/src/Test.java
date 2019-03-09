import java.text.NumberFormat;
import java.math.BigDecimal;
import java.util.Locale;
public class Test {

	int hour;
	int minute;
	int second;
	
	
	public static void main(String [] args) {
		
		
		
		for (String s : System.getenv().values())
				System.out.println(s);
		
		String linsep = System.lineSeparator();
		
		System.out.println("Line sepa: " + linsep);
//		Test t = new Test();
//		
//		Test t2 = new Test();
//		
//		t.setTime(1,43,56);
//		System.out.println(t);
//		t2.steal(t);
//		System.out.println(t2);
//		
//		Locale sw = Locale.forLanguageTag("sv-SE");
//		
//		BigDecimal amount = BigDecimal.valueOf(7890000.999999);
//		System.out.println(NumberFormat.getCurrencyInstance(sw).format(amount));
	
	}
	void steal(Test t)
	{
		this.hour = t.hour;
		this.minute = t.minute;
		this.second = ++t.second;
	}
	
	public void setTime(int hour, int minute, int second) {
		
		this.hour = hour;
		this.minute = minute;
		this.second = second;
	}
	public String toString() {
		
		return String.format("%03d:%02d:%02d", 
				((hour==0 || hour==12)? 12 : hour % 12), minute,second);
	
	}
	
}

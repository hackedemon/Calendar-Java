package datentime;

import java.text.*;
import java.util.*;

public class Output {

	public static void main(String[] args) {
		
		// Input 1st date
		System.out.print("Enter Start date (DD-MM-YYYY) : ");
		Scanner in = new Scanner(System.in);
		String date1 = in.next();
		
		//Input 2nd date
		System.out.print("Enter End date (DD-MM-YYYY) : ");
		String date2 = in.next();
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		Date tempdate1 = null;
		Date tempdate2 = null;
		try {
			//Parsing the dates
			tempdate1 = dateFormat.parse(date1);
			tempdate2 = dateFormat.parse(date2);
		}
		catch (ParseException e) {
			System.out.println("Invalid date format");
		}
		
		/*if((tempdate2.getTime() - tempdate1.getTime()) > ){
			
		}*/
		System.out.println(tempdate2.getTime() - tempdate1.getTime());
		
		Calendar c = Calendar.getInstance();
		c.setTime(tempdate1);
		c.add(Calendar.MONTH, 1);  
        c.set(Calendar.DAY_OF_MONTH, 1);
		c.add(Calendar.DATE, -1);
		System.out.println("Last day(s) of month:"+dateFormat.format(c.getTime()));
		c.add(Calendar.MONTH, 3);  
        c.set(Calendar.DAY_OF_MONTH, 1);
		c.add(Calendar.DATE, -1);
		System.out.println("Last day(s) of month:"+dateFormat.format(c.getTime()));

	}

}
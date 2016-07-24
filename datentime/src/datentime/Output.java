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
		
		Calendar c1 = Calendar.getInstance();
		c1.setTime(tempdate1);
		Calendar c2 = Calendar.getInstance();
		c2.setTime(tempdate2);
		
		int monthdiff = c2.get(Calendar.MONTH) - c1.get(Calendar.MONTH);
		
		if(monthdiff > 0){
			System.out.println("Last day(s) of month:");
			c1.add(Calendar.MONTH, 1);  
	        c1.set(Calendar.DAY_OF_MONTH, 1);
			c1.add(Calendar.DATE, -1);
			System.out.println(dateFormat.format(c1.getTime()));
			//Loop to print last day of months
			for(int i = 2; i<=monthdiff; i++){
				c1.add(Calendar.MONTH, 2);  
		        c1.set(Calendar.DAY_OF_MONTH, 1);
				c1.add(Calendar.DATE, -1);
				System.out.println(dateFormat.format(c1.getTime()));
			}
		}
		
		c1.setTime(tempdate1);
		c2.setTime(tempdate2);
		
		System.out.println("Sundays between dates:");
		if(c1.get(Calendar.DAY_OF_WEEK) == 1)
			System.out.println(dateFormat.format(c1.getTime()));
		while((c2.get(Calendar.WEEK_OF_YEAR) - c1.get(Calendar.WEEK_OF_YEAR)) > 0){
			c1.add(Calendar.WEEK_OF_YEAR, 1);
			c1.add( Calendar.DAY_OF_WEEK, -(c1.get(Calendar.DAY_OF_WEEK)-1));
			System.out.println(dateFormat.format(c1.getTime()));
		}

	}

}
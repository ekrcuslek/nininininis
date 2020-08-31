package hotel.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class haha {

	public static void main(String[] args) {
		Date systemcal = Calendar.getInstance().getTime();
		String formatString = "d";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(formatString);
		String formattedDate = simpleDateFormat.format(systemcal);
		System.out.println(formattedDate);
	}

}

package core.domain;
import java.util.Calendar;
import java.util.Date;


public class DateHelper {

	public static void main(String[] args) {
		int months = DateHelper.getMonthsBetween(new Date(2016, 02, 13), new Date(2016, 04, 14));
		System.out.println(months);

	}

	public static int getMonthsBetween(Date startDate, Date endDate) {

		Calendar startCalendar = Calendar.getInstance();
		startCalendar.setTime(startDate);
		Calendar endCalendar = Calendar.getInstance();
		endCalendar.setTime(endDate);

		int diffYear = endCalendar.get(Calendar.YEAR) - startCalendar.get(Calendar.YEAR);
		int diffMonth = diffYear * 12 + endCalendar.get(Calendar.MONTH) - startCalendar.get(Calendar.MONTH);
		int diffDays = endCalendar.get(Calendar.DAY_OF_MONTH) - startCalendar.get(Calendar.DAY_OF_MONTH);
		if (diffDays > 0) {
			diffMonth = diffMonth + 1;
		}
		return diffMonth;
	}
	// TVIS-7133 ENDS

}

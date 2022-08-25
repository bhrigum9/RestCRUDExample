package com.exapmle.util;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class Utilitaries {

	/**
	 * @param creationDate
	 * @return
	 */
	public static long checkDateByMonth(Date creationDate) {
		long months = 0;
		try {
			if (creationDate != null) {
				LocalDate date = Instant.ofEpochMilli(creationDate.getTime()).atZone(ZoneId.systemDefault())
						.toLocalDate();
				months = ChronoUnit.MONTHS.between(LocalDate.now(), date);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return months;
	}

}

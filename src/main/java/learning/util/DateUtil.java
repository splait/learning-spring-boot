package learning.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import org.springframework.stereotype.Component;

@Component
public class DateUtil {

	public String formatLocalDateTimeToDatabaseStyle(LocalDateTime localDateTime) {
		return 	DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(localDateTime);
	}
}

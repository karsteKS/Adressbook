package lt.bit.data;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;
import javax.json.bind.adapter.JsonbAdapter;

public class JsonDateSerializer implements JsonbAdapter<Date, String> {

    private final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public String adaptToJson(Date date) throws Exception {
        if (date == null) {
            return null;
        }
        return sdf.format(date);
    }

    @Override
    public Date adaptFromJson(String dateStr) throws Exception {
        try {
            Date d = sdf.parse(dateStr);
            Calendar c = Calendar.getInstance();
            c.setTimeInMillis(d.getTime());
            c.set(Calendar.HOUR, 12);
            c.set(Calendar.MINUTE, 0);
            c.set(Calendar.SECOND, 0);
            c.set(Calendar.MILLISECOND, 0);
           return  c.getTime(); 
        } catch (Exception ex) {
            return null;
        }
    }

}
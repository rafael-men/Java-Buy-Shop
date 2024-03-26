package Helper;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Utils {
    static SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
    static NumberFormat nf = new DecimalFormat("R$ #,##0.00", new DecimalFormatSymbols());

    public static String DateforString(Date data) {
        return Utils.sdf.format(data);
    }

    public static String DoubleforString(Double Valor) {
        return Utils.nf.format(Valor);
    }

    public static Double StringforDouble(String Valor) {
        try {
            return (Double) Utils.nf.parse(Valor);
        } catch (ParseException e) {
            return null;
        }
    }

    public static void pausar(int Seconds) {
        try {
            TimeUnit.SECONDS.sleep(Seconds);
        } catch (InterruptedException e) {
            System.out.println("Erro ao pausar por segundos...");
        }
    }
}

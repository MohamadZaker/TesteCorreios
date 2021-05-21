package suporte;

import java.security.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Generator {
    public static String dataHoraParaArquivo(){

        Date ts = new Date();

        return new SimpleDateFormat("yyyyMMddhhmmss").format(ts);

    }
}

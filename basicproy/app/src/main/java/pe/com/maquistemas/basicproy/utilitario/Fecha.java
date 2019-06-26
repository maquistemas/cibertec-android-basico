package pe.com.maquistemas.basicproy.utilitario;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Fecha {

    public static String getFecha(){

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            String d = (sdf.format(new Date())).toString();
            return d.toString();
        }catch (Exception e){
            e.printStackTrace();
            return null;

        }


    }

}

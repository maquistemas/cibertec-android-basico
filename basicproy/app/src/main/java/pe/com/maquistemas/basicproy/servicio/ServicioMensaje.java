package pe.com.maquistemas.basicproy.servicio;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import pe.com.maquistemas.basicproy.activity.MenuLateralActivity;
import pe.com.maquistemas.basicproy.email.EmailConfig;
import pe.com.maquistemas.basicproy.email.Empresa;
import pe.com.maquistemas.basicproy.notificacion.NotificacionConfig;


public class ServicioMensaje extends Service{

    public final static String TO = "to";
    public final static String SUBJECT = "subject";
    public final static String MESSAGE = "message";

    final static String TAG = "ServicioMensaje";



    @Override
    public void onCreate() {
        Log.i(TAG,"onCreate");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG,"onStartCommand");
        Toast.makeText(this, " onStartCommand ", Toast.LENGTH_LONG).show();

        EmailConfig emailConfig = new EmailConfig();
        final String recipientEmail = Empresa.EMPRESA_EMAIL.getValue();
        final String recipientPassword = Empresa.EMPRESA_EMAIL_PASSWORD.getValue();

        String to = intent.getStringExtra(TO);
        String subject = intent.getStringExtra(SUBJECT);
        String message = intent.getStringExtra(MESSAGE);

        emailConfig.sendEmailWithGmail(recipientEmail,recipientPassword,to,subject,message);

        stopSelf(1);
        Log.i(TAG,"stopSelf");

        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Log.i(TAG,"onDestroy");
        Toast.makeText(this, "onDestroy", Toast.LENGTH_LONG).show();

        NotificacionConfig notificacionConfig = new NotificacionConfig(ServicioMensaje.this, MenuLateralActivity.class);
        notificacionConfig.showText("Mensaje Informativo","Se envió el correo");


    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }




}

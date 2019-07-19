package pe.com.maquistemas.basicproy.notificacion;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.NotificationCompat;

public class NotificacionConfig {

    public static final int NOTIFICATION_ID = 5453;
    private static final String CHANNEL_ID = "canal_ejemplo";

    Context context;
    Class clase;

    public NotificacionConfig(Context context, Class clase) {
        this.context = context;
        this.clase = clase;
    }

    public void showText(final String titulo, final String text) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            createNotificationChannel(CHANNEL_ID, "Canal de ejemplo");
        }
        //Create a notification builder
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context,CHANNEL_ID )
                .setSmallIcon(android.R.drawable.sym_def_app_icon)
                .setContentTitle(titulo)
                .setContentText(text)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setVibrate(new long[] {0, 1000})
                .setAutoCancel(true);

        //Create an action
        Intent actionIntent = new Intent(context, clase);
        PendingIntent actionPendingIntent = PendingIntent.getActivity(
                context,
                0,
                actionIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(actionPendingIntent);

        //Issue the notification
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(NOTIFICATION_ID , builder.build());
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private void createNotificationChannel(String id, String nombre) {
        NotificationManager mNotificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        if (mNotificationManager != null) {
            mNotificationManager.createNotificationChannel( new NotificationChannel(id, nombre, NotificationManager.IMPORTANCE_HIGH));
        }
    }


}

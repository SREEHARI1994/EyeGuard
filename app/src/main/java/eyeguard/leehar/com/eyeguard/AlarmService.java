package eyeguard.leehar.com.eyeguard;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.os.SystemClock;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
/**
 * Created by USER on 08-02-2018.
 */

public class AlarmService extends Service {
    //int mStartMode;
    //IBinder mBinder;
    String alarm;
    AlarmManager alarmManager;
    //AlarmManager alarm2;
    Intent myIntent,myIntent2;
    PendingIntent pendingIntent;
    PendingIntent pendingIntent2;
    //PendingIntent pendingIntent6;
    String checker="winner";

    public int onStartCommand(Intent intent, int flags, int startId) {
        // The service is starting, due to a call to startService()
       int ONGOING_NOTIFICATION_ID=1;
        if (Build.VERSION.SDK_INT>=26)

        {
            NotificationManager mNotificationManager =
                    (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            String CHANNEL_ID = "my_channel_01";
            CharSequence name = getString(R.string.channel_name);
            int importance = NotificationManager.IMPORTANCE_LOW;
            NotificationChannel mChannel = new NotificationChannel(CHANNEL_ID, name, importance);
            mNotificationManager.createNotificationChannel(mChannel);


            Intent resultIntent = new Intent(AlarmService.this, Options.class);

            // The stack builder object will contain an artificial back stack for the
// started Activity.
// This ensures that navigating backward from the Activity leads out of
// your app to the Home screen.
            TaskStackBuilder stackBuilder = TaskStackBuilder.create(AlarmService.this);
// Adds the back stack for the Intent (but not the Intent itself)
// Adds the Intent that starts the Activity to the top of the stack
            stackBuilder.addParentStack(Options.class);
            stackBuilder.addNextIntent(resultIntent);
            PendingIntent resultPendingIntent =
                    stackBuilder.getPendingIntent(
                            0,
                            PendingIntent.FLAG_UPDATE_CURRENT
                    );

            Notification notification =
                    new Notification.Builder(this,CHANNEL_ID)
                            .setContentTitle(getText(R.string.notification_title))
                            .setContentText(getText(R.string.notification_message))
                            .setSmallIcon(R.drawable.icon)
                            .setContentIntent(resultPendingIntent)
                            .setTicker(getText(R.string.ticker_text))
                            .build();
            startForeground(ONGOING_NOTIFICATION_ID, notification);
        }
        else
        {
            // The id of the channel.
            String CHANNEL_ID = "my_channel_01";
            int mNotificationId=2;

            NotificationCompat.Builder mBuilder =
                    new NotificationCompat.Builder(this, CHANNEL_ID)
                            .setSmallIcon(R.drawable.icon)
                            .setContentTitle("Eye Guard")
                            .setContentText("Eye Guard running in background.Touch to stop");
// Creates an explicit intent for an Activity in your app
            Intent resultIntent = new Intent(this, Options.class);

// The stack builder object will contain an artificial back stack for the
// started Activity.
// This ensures that navigating backward from the Activity leads out of
// your app to the Home screen.
            TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
// Adds the back stack for the Intent (but not the Intent itself)
            stackBuilder.addParentStack(Options.class);
// Adds the Intent that starts the Activity to the top of the stack
            stackBuilder.addNextIntent(resultIntent);
            PendingIntent resultPendingIntent =
                    stackBuilder.getPendingIntent(
                            0,
                            PendingIntent.FLAG_UPDATE_CURRENT
                    );
            mBuilder.setContentIntent(resultPendingIntent);
            NotificationManager mNotificationManager =
                    (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

// mNotificationId is a unique integer your app uses to identify the
// notification. For example, to cancel the notification, you can pass its ID
// number to NotificationManager.cancel().
            mNotificationManager.notify(mNotificationId, mBuilder.build());
            startForeground(mNotificationId,mBuilder.build());
        }
        pandaram(intent);
        //pandaram2(intent);

        return START_STICKY;
    }

    private void pandaram(Intent intent){
        checker = intent.getStringExtra("getlost");

        if(checker.equals("looser"))
        {
            if (alarmManager!= null) {
                //Do something when Switch is off/unchecked
             //   alarm = "alarm1";
                alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
                Intent myIntent = new Intent(AlarmService.this, AlarmReceiver.class);
             //   myIntent.putExtra("which", alarm);
                PendingIntent pendingIntent = PendingIntent.getBroadcast(AlarmService.this, 0, myIntent, PendingIntent.FLAG_UPDATE_CURRENT);

                pendingIntent.cancel();
                alarmManager.cancel(pendingIntent);
                Intent myIntent2 = new Intent(AlarmService.this, AlarmReceiver.class);
                //   myIntent.putExtra("which", alarm);
                PendingIntent pendingIntent2 = PendingIntent.getBroadcast(AlarmService.this, 0, myIntent, PendingIntent.FLAG_UPDATE_CURRENT);

                pendingIntent2.cancel();
                alarmManager.cancel(pendingIntent2);
                // pendingIntent2.cancel();
                // alarmManager.cancel(pendingIntent2);
                // Intent cancel=new Intent(AlarmService.this,AlarmReceiver.class);
                // alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
                // cancel.putExtra("which","cancel");

                // PendingIntent pendingIntent6 = PendingIntent.getBroadcast(AlarmService.this, 2, cancel,PendingIntent.FLAG_UPDATE_CURRENT);
                //alarmManager.cancel(pendingIntent2);
            }
        }

        //alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        // alarm2=(AlarmManager) getSystemService(ALARM_SERVICE);
        // final Intent myIntent = new Intent(AlarmService.this, AlarmReceiver.class);
        // Intent myIntent2 = new Intent(AlarmService.this, AlarmReceiver.class);
//        pendingIntent = PendingIntent.getBroadcast(AlarmService.this, 0, myIntent, 0);
        // pendingIntent2 = PendingIntent.getBroadcast(AlarmService.this, 1, myIntent2, 0);
        else {
            alarm = "alarm1";
            alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
            Intent myIntent = new Intent(AlarmService.this, AlarmReceiver.class);
            myIntent.putExtra("which", alarm);
            PendingIntent pendingIntent = PendingIntent.getBroadcast(AlarmService.this, 0, myIntent, PendingIntent.FLAG_UPDATE_CURRENT);

            if (Build.VERSION.SDK_INT < 23) {
                if (Build.VERSION.SDK_INT >= 19) {
                    alarmManager.setExact(AlarmManager.ELAPSED_REALTIME_WAKEUP, SystemClock.elapsedRealtime() + (2 * 60000), pendingIntent);
                } else {
                    alarmManager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, SystemClock.elapsedRealtime() + (2 * 60000), pendingIntent);
                }
            } else {
                //alarmManager.setExact(AlarmManager.ELAPSED_REALTIME_WAKEUP,System.currentTimeMillis() + (20 * 1000),pendingIntent);
                alarmManager.setExactAndAllowWhileIdle(AlarmManager.ELAPSED_REALTIME_WAKEUP, SystemClock.elapsedRealtime() + (2 * 60000), pendingIntent);
            }
            alarm = "alarm2";
            alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

            Intent myIntent2 = new Intent(AlarmService.this, AlarmReceiver.class);
            myIntent2.putExtra("which", alarm);
            PendingIntent pendingIntent2 = PendingIntent.getBroadcast(AlarmService.this, 1, myIntent2, PendingIntent.FLAG_UPDATE_CURRENT);

            if (Build.VERSION.SDK_INT < 23) {
                if (Build.VERSION.SDK_INT >= 19) {
                    alarmManager.setExact(AlarmManager.ELAPSED_REALTIME_WAKEUP, SystemClock.elapsedRealtime() + (2 * 60 * 1000) + 20000, pendingIntent2);
                } else {
                    alarmManager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, SystemClock.elapsedRealtime() + (2 * 60 * 1000) + 20000, pendingIntent2);
                }
            } else {
                alarmManager.setExactAndAllowWhileIdle(AlarmManager.ELAPSED_REALTIME_WAKEUP, SystemClock.elapsedRealtime() + (2 * 60 * 1000) + 20000, pendingIntent2);
            }
        }




    }

    public IBinder onBind(Intent intent) {
        // A client is binding to the service with bindService()
        return null;
    }

 /*public void onDestroy() {
       if (alarmManager!= null) {
            //Do something when Switch is off/unchecked
           pendingIntent.cancel();
            alarmManager.cancel(pendingIntent);
            pendingIntent2.cancel();
            alarmManager.cancel(pendingIntent2);
            //Intent cancel=new Intent(Options.this,AlarmReceiver.class);
            alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
            myIntent.putExtra("which","cancel");

            PendingIntent pendingIntent6 = PendingIntent.getBroadcast(AlarmService.this, 1, myIntent,PendingIntent.FLAG_UPDATE_CURRENT);
            //alarmManager.cancel(pendingIntent2);
        }
    }*/




}

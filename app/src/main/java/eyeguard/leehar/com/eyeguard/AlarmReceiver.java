package eyeguard.leehar.com.eyeguard;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.ToneGenerator;

public class AlarmReceiver extends BroadcastReceiver{
    AlarmManager alarmManager;

    //AlarmManager alarm2;
   Intent myIntent3,myIntent4;
   private PendingIntent pendingIntent3,pendingIntent4;



    @Override
    public void onReceive(final Context context, Intent intent) {
        //MainActivity.getTextView2().setText("Enough Rest. Do Work Now!");

        ToneGenerator toneG = new ToneGenerator(AudioManager.STREAM_ALARM, 100);
        toneG.startTone(ToneGenerator.TONE_CDMA_ALERT_CALL_GUARD, 200);
       // String number = intent.getExtras().getString("which");
  /* final String number=intent.getStringExtra("which");
   // final Intent intent2=new Intent(context,AlarmService.class);

       /*String cancel2 = intent.getStringExtra("cancel2alarm");
       if(cancel2.equals(null))
        cancel2="working";
/* final PendingResult pendingResult = goAsync();
        AsyncTask<String, Integer, String> asyncTask = new AsyncTask<String, Integer, String>() {
            @Override
            protected String doInBackground(String... params) {
                if (number.equals("alarm1")) {
                    ToneGenerator toneG = new ToneGenerator(AudioManager.STREAM_ALARM, 100);
                    toneG.startTone(ToneGenerator.TONE_CDMA_ALERT_CALL_GUARD, 200);
                    AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);

                    //
      Intent myIntent3 = new Intent(context, AlarmReceiver.class);
       myIntent3.putExtra("which","alarm1");
        PendingIntent pendingIntent3 = PendingIntent.getBroadcast(context, 100, myIntent3,PendingIntent.FLAG_UPDATE_CURRENT);

        if (Build.VERSION.SDK_INT < 23) {
            if (Build.VERSION.SDK_INT >= 19) {
                alarmManager.setExact(AlarmManager.ELAPSED_REALTIME_WAKEUP, SystemClock.elapsedRealtime() + (2 * 60000), pendingIntent3);
            } else {
                alarmManager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, SystemClock.elapsedRealtime() + (2* 60000), pendingIntent3);
            }
        } else {
            alarmManager.setExactAndAllowWhileIdle(AlarmManager.ELAPSED_REALTIME_WAKEUP, SystemClock.elapsedRealtime() + (2 * 60000), pendingIntent3);
        }
                    //intent = new Intent(context, AlarmService.class);
                   // intent2.putExtra("getlost", "winner");
                    //context.startService(intent2);
                }
                if (number.equals("alarm2"))
                {
                    ToneGenerator toneG = new ToneGenerator(AudioManager.STREAM_ALARM, 100);
                    toneG.startTone(ToneGenerator.TONE_CDMA_ALERT_CALL_GUARD, 200);
                    AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
                    Intent myIntent4=new Intent(context,AlarmReceiver.class);
                    myIntent4.putExtra("which","alarm2");
                    PendingIntent pendingIntent4 = PendingIntent.getBroadcast(context, 101, myIntent4,PendingIntent.FLAG_UPDATE_CURRENT);
                    if (Build.VERSION.SDK_INT < 23) {
                        if (Build.VERSION.SDK_INT >= 19) {
                            alarmManager.setExact(AlarmManager.ELAPSED_REALTIME_WAKEUP, SystemClock.elapsedRealtime() + (2 * 60 * 1000), pendingIntent4);
                        } else {
                            alarmManager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, SystemClock.elapsedRealtime() + (2 * 60 * 1000) , pendingIntent4);
                        }
                    } else {
                        alarmManager.setExactAndAllowWhileIdle(AlarmManager.ELAPSED_REALTIME_WAKEUP, SystemClock.elapsedRealtime() + (2 * 60 * 1000), pendingIntent4);
                    }
                   /* Activity.runOnUiThread(new Runnable() {
                        public void run() {
                            new CountDownTimer(1300, 1000) {

                                public void onTick(long millisUntilFinished) {

                                }

                                public void onFinish() {
                                    ToneGenerator toneg2=new ToneGenerator(AudioManager.STREAM_ALARM,100);
                                    toneg2.startTone(ToneGenerator.TONE_CDMA_ALERT_CALL_GUARD,200);
                                }
                            }.start();
                        }
                    });*/


                   // intent=new Intent(context,AlarmService2.class);
                  /* intent2.putExtra("getlost","winner");
                   context.startService(intent2);*/
               // }
                // Must call finish() so the BroadcastReceiver can be recycled.
               /* pendingResult.finish();
                return null;
            }
        };
        asyncTask.execute();
       //
  //  }

      // if(number.equals("alarm2")) {

          /*
       // }


      // String cancel2 = intent.getStringExtra("cancel2alarm");
    if(number.equals("cancel"))
       {
           if(alarmManager!=null) {
               pendingIntent3.cancel();
               alarmManager.cancel(pendingIntent3);
               pendingIntent4.cancel();
               alarmManager.cancel(pendingIntent4);
           }
       }*/

    }
}

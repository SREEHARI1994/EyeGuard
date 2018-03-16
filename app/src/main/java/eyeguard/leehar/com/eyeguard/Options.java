package eyeguard.leehar.com.eyeguard;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;


public class Options extends AppCompatActivity{
   public AlarmManager alarmManager;
    String alarm;
//    Intent service=new Intent(Options.this,AlarmService.class);

    //AlarmManager alarm2;
    Intent myIntent,myIntent2,cancel;
   //Intent service;
  public PendingIntent pendingIntent;
  public PendingIntent pendingIntent2;
 // private PendingIntent pendingIntent6;
    //boolean check=false;
    //boolean checker=false;
    int s=0;
  //  String alarm;
    SharedPreferences pref;
    public static final String For_switch="MyPrefsFile";

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);
        //TextView tev=findViewById(R.id.textView2);
      pref= getSharedPreferences("For_switch",0);
        //checker=pref.getBoolean("checking",false)
      s= pref.getInt("key",s);

       // boolean check=sharedPrefs.getBoolean("NameOfThingToSave", true);

        AlertDialog.Builder alertDialog = new AlertDialog.Builder(
                Options.this);

        // Setting Dialog Title
        alertDialog.setTitle("Caution!!!");

        // Setting Dialog Message
        alertDialog.setMessage("Keep the switch in off position when you are not using the app to avoid unwanted ringing..");

        // Setting Icon to Dialog

        // Setting OK Button
        alertDialog.setNeutralButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                // Write your code here to execute after dialog closed
                dialog.cancel();
            }
        });

        // Showing Alert Message
        alertDialog.show();
       alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
       // alarm2=(AlarmManager) getSystemService(ALARM_SERVICE);
        Intent myIntent = new Intent(Options.this, AlarmReceiver.class);
        Intent myIntent2 = new Intent(Options.this, AlarmReceiver.class);
        pendingIntent = PendingIntent.getBroadcast(Options.this, 0, myIntent,PendingIntent.FLAG_UPDATE_CURRENT);
        pendingIntent2 = PendingIntent.getBroadcast(Options.this, 1, myIntent2,PendingIntent.FLAG_UPDATE_CURRENT);


        Switch sButton = (Switch) findViewById(R.id.switch1);
        /*CompoundButton.OnCheckedChangeListener switchChecker=new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

            }
        };*/
        if(s==1)
        {
           // sButton.setOnCheckedChangeListener (null);
            sButton.setChecked(true);
           // sButton.setOnCheckedChangeListener (switchChecker);
        }



        //Set a CheckedChange Listener for Switch Button
        sButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
                                               public void onCheckedChanged(CompoundButton cb, boolean on){

                                                   if(on)
                                                   {

                                                     /*  if(Build.VERSION.SDK_INT>=26) {
                                                           Intent service=new Intent(Options.this,AlarmService.class);
                                                           service.putExtra("getlost","killyou");
                                                           startForegroundService(service);
                                                           Intent service2=new Intent(Options.this,AlarmService2.class);
                                                           service2.putExtra("getlost","killyou");
                                                           startForegroundService(service2);
                                                       }
                                                       else
                                                       {
                                                           Intent service=new Intent(Options.this,AlarmService.class);
                                                           service.putExtra("getlost","killyou");
                                                           startService(service);
                                                          // Intent service2=new Intent(Options.this,AlarmService2.class);
                                                           //service2.putExtra("getlost","killyou");
                                                           //startService(service2);
                                                      // }*/

                                                       //Do something when Switch button is on/checke
                                                       alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
                                                       Intent myIntent = new Intent(Options.this, AlarmReceiver.class);
                                                       PendingIntent pendingIntent = PendingIntent.getBroadcast(Options.this, 0, myIntent, PendingIntent.FLAG_UPDATE_CURRENT);
                                                       alarmManager.setRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP,
                                                               (2*60*1000), (2*60*1000), pendingIntent);

                                                       Intent myIntent2 = new Intent(Options.this, AlarmReceiver.class);
                                                       PendingIntent pendingIntent2 = PendingIntent.getBroadcast(Options.this,1, myIntent2,PendingIntent.FLAG_UPDATE_CURRENT);
                                                       alarmManager.setRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP,((2*60*1000)+2000),(2*60*1000),pendingIntent2);
                                                     /* alarm="alarm1";
                                                      alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
                                                       Intent myIntent = new Intent(Options.this, AlarmReceiver.class);
                                                       myIntent.putExtra("which",alarm);
                                                       PendingIntent pendingIntent = PendingIntent.getBroadcast(Options.this, 0, myIntent,PendingIntent.FLAG_UPDATE_CURRENT);

                                                       if(Build.VERSION.SDK_INT < 23){
                                                           if(Build.VERSION.SDK_INT >= 19) {
                                                               alarmManager.setExact(AlarmManager.ELAPSED_REALTIME_WAKEUP, SystemClock.elapsedRealtime()+(2 * 60000),pendingIntent);
                                                           } else {
                                                               alarmManager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP,SystemClock.elapsedRealtime()+(2* 60000),pendingIntent);
                                                           }
                                                       } else {
                                                           //alarmManager.setExact(AlarmManager.ELAPSED_REALTIME_WAKEUP,System.currentTimeMillis() + (20 * 1000),pendingIntent);
                                                           alarmManager.setExactAndAllowWhileIdle(AlarmManager.ELAPSED_REALTIME_WAKEUP,SystemClock.elapsedRealtime()+(2 * 60000),pendingIntent);
                                                       }

                                                       alarm="alarm2";
                                                       Intent myIntent2 = new Intent(Options.this, AlarmReceiver.class);
                                                       myIntent2.putExtra("which",alarm);
                                                       PendingIntent pendingIntent2 = PendingIntent.getBroadcast(Options.this,1, myIntent2,PendingIntent.FLAG_UPDATE_CURRENT);

                                                       if(Build.VERSION.SDK_INT < 23){
                                                           if(Build.VERSION.SDK_INT >= 19) {
                                                               alarmManager.setExact(AlarmManager.ELAPSED_REALTIME_WAKEUP, SystemClock.elapsedRealtime()+ (2 *60* 1000)+20000,pendingIntent2);
                                                           } else {
                                                               alarmManager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP,SystemClock.elapsedRealtime() + (2 *60* 1000)+20000,pendingIntent2);
                                                           }
                                                       } else {
                                                           alarmManager.setExactAndAllowWhileIdle(AlarmManager.ELAPSED_REALTIME_WAKEUP,SystemClock.elapsedRealtime() + (2*60*1000)+20000,pendingIntent2);
                                                       }*/
                                                       //alarmManager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP,(System.currentTimeMillis() + (10 * 1000)),pendingIntent);
                                                      //check=true;
                                                       s=1;
                                                       pref = getSharedPreferences("For_switch", 0);
                                                       SharedPreferences.Editor editor=pref.edit();
                                                       // editor.putBoolean("checking",check);
                                                       editor.putInt("key",s);
                                                       editor.commit();

                                                      // s=1;

                                                   }
                                                   else
                                                   {
                                                     /* Intent cancel1=new Intent(Options.this,AlarmService.class);
                                                       cancel1.putExtra("getlost","looser");
                                                     startService(cancel1);
                                                     stopService(cancel1);*/
                                                      // Intent cancel2=new Intent(Options.this,AlarmService2.class);
                                                       //cancel2.putExtra("getlost","looser");
                                                       //startService(cancel2);
                                                      // stopService(cancel2);


                                                       // stopService(service2);
                                                     if (alarmManager!= null) {
                                                           //Do something when Switch is off/unchecked

                                                        // pendingIntent.cancel();;
                                                           alarmManager.cancel(pendingIntent);
                                                          // pendingIntent2.cancel();
                                                           alarmManager.cancel(pendingIntent2);
                                                         //  alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
                                                          /* Intent cancel=new Intent(Options.this,AlarmReceiver.class);

                                                           cancel.putExtra("which","cancel");

                                                           PendingIntent pendingIntent6 = PendingIntent.getBroadcast(Options.this, 3, cancel,PendingIntent.FLAG_UPDATE_CURRENT);*/
                                                           //alarmManager.cancel(pendingIntent2);
                                                       }
                                                     //check=false;
                                                       s=2;

                                                   }
                                               }

                                           });
        //sButton.setOnCheckedChangeListener(Options.this);
            //@Override
       /* if(check)
        {
            sButton.setOnCheckedChangeListener (null);
            sButton.setChecked(true);
            sButton.setOnCheckedChangeListener (switchChecker);
        }*/

        }
    public void onButtonClick(View view)
    {
        Intent intent=new Intent(this,Adjust.class);
        startActivity(intent);
    }
       @Override
   protected void onStop()
    {
        super.onStop();
        pref = getSharedPreferences("For_switch", 0);
        SharedPreferences.Editor editor=pref.edit();
       // editor.putBoolean("checking",check);
        editor.putInt("key",s);
        editor.commit();
    }
/*@Override
    public void onResume()
{
    super.onResume();
    pref= getSharedPreferences("For_switch",MODE_PRIVATE);
    //checker=pref.getBoolean("checking",false)
    pref.getInt("key",s);
}*/

    }



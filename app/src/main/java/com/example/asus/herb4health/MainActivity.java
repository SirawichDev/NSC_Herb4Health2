package com.example.asus.herb4health;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.provider.Settings;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.fitness.request.StartBleScanRequest;

public class MainActivity extends AppCompatActivity {
    int funtion1 = 0;
    int funtion2 = 0;
    int funtion3 = 0;

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    public void GoSearch(View v) {
        Intent a = new Intent(this, Search.class);
        startActivity(a);
    }



    public void GoBodyhumen(View v) {
        Intent c = new Intent(this, bodyhumenActivity.class);
        startActivity(c);
    }
    public void GoQuiz1(View v) {
        Intent d = new Intent(this, quiz.class);
        startActivity(d);
    }
    public void GoNewlist(View v) {
        Intent e = new Intent(this, Newlist.class);
        startActivity(e);
    }
    public void GoUpload(View v) {
        Intent i = new Intent(MainActivity.this,FetchImageFirebase.class);
        startActivity(i);
    }


    //funtion1
    public void funtionclick1(View v) {
        LinearLayout d = (LinearLayout) findViewById(R.id.buttonother1);
        if (funtion1 == 0) {
            d.setVisibility(View.VISIBLE);
            funtion1 = 1;
        } else if (funtion1 == 1) {
            d.setVisibility(View.GONE);
            funtion1 = 0;
        }
    }
    //funtion2
    public void funtionclick2(View v) {
        LinearLayout e = (LinearLayout) findViewById(R.id.buttonother2);
        if (funtion2 == 0) {
            e.setVisibility(View.VISIBLE);
            funtion2 = 1;
        } else if (funtion2 == 1) {
            e.setVisibility(View.GONE);
            funtion2 = 0;
        }
    }
    //funtion3
    public void funtionclick3(View v) {
        LinearLayout c = (LinearLayout) findViewById(R.id.buttonother3);
        if (funtion3 == 0) {
            c.setVisibility(View.VISIBLE);
            funtion3 = 1;
        } else if (funtion3 == 1) {
            c.setVisibility(View.GONE);
            funtion3 = 0;
        }
    }


    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Main Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
    @Override
    public void onBackPressed() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("คุณต้องการออกออกจาก Herbs4health?");
        alertDialogBuilder
                .setMessage("กดตกลง ถ้าคุณต้องการออก!")
                .setCancelable(false)
                .setPositiveButton("ตกลง",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                moveTaskToBack(true);
                                android.os.Process.killProcess(android.os.Process.myPid());


                                System.exit(1);
                            }


                        }
                        )

                .setNegativeButton("ยกเลิก", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        dialog.cancel();
                    }
                });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }


}


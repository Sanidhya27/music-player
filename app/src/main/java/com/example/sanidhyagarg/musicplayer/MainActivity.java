package com.example.sanidhyagarg.musicplayer;

import android.graphics.drawable.Drawable;
import android.media.Image;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements MediaPlayer.OnCompletionListener{
    MediaPlayer mediaPlayer;
    int x=0;double finalTime;
    FloatingActionButton fab;

    double time;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mediaPlayer=MediaPlayer.create(this, R.raw.song);
         fab = (FloatingActionButton) findViewById(R.id.fab);
       /* mediaPlayer.OnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
            mediaPlayer.stop();
            x=0;
            fab.setImageResource(R.drawable.play);
            }

        });*/

        time=mediaPlayer.getCurrentPosition();
        finalTime= mediaPlayer.getDuration();

        fab.setImageResource(R.drawable.play);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                x=(x+1)%2;
                if(x==1)
                {fab.setImageResource(R.drawable.pause);
                    //fab.setBackgroundResource(R.drawable.play);
                    mediaPlayer.start();}
                else if (x==0)
                {   //fab.setBackgroundResource(R.drawable.ic_launcher_background);
                   fab.setImageResource((R.drawable.play));
                    mediaPlayer.pause();
            }}
        });

              }

        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            mediaPlayer.stop();
            Log.d("MyActivity", "onCompletion: ");
            x=0;
            fab.setImageResource(R.drawable.play);
        }

        /*    if(time==finalTime)
    {
        Log.d("hello","hello");
        x=0;
    }*/
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

package com.example.ram.madlabfull;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showCode(String file)
    {
        Intent intent = new Intent(this,disp.class);
        intent.putExtra("text", file);
        startActivity(intent);
    }

    public void temp(View v)
    {}
    public void spinner(View v)
    {

        Spinner sp = (Spinner) findViewById(R.id.spinner);
        ArrayList<String> al = new ArrayList<String>();
        al.add( "English");
        al.add( "Hindi");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,al);
        sp.setAdapter(adapter);
        String val = ((Spinner) findViewById(R.id.spinner)).getSelectedItem().toString();

    }

    public void spinnerCode(View v)
    {
        showCode("Spinner sp = (Spinner) findViewById(R.id.spinner);\n" +
                "        ArrayList<String> al = new ArrayList<String>();\n" +
                "        al.add( \"English\");\n" +
                "        al.add( \"Hindi\");\n" +
                "        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,al);\n" +
                "        sp.setAdapter(adapter);\n" +
                "        String val = ((Spinner) findViewById(R.id.spinner)).getSelectedItem().toString();");

    }

    public void calc(View v)
    {
        EditText sin1= (EditText) findViewById(R.id.sin);
        EditText cos1= (EditText) findViewById(R.id.cos);
        EditText log1= (EditText) findViewById(R.id.log);
        int s = Integer.valueOf(sin1.getText().toString());
        int c = Integer.valueOf(cos1.getText().toString());
        int l = Integer.valueOf(log1.getText().toString());
        sin1.setText(Math.sin(Math.toRadians(s))+"");
        cos1.setText(Math.cos(Math.toRadians(c))+"");
        log1.setText(Math.log(l)+"");
    }

    public void calcCode(View v)
    {

        showCode(" EditText sin1= (EditText) findViewById(R.id.sin);\n" +
                "        EditText cos1= (EditText) findViewById(R.id.cos);\n" +
                "        EditText log1= (EditText) findViewById(R.id.log);\n" +
                "        int s = Integer.valueOf(sin1.getText().toString());\n" +
                "        int c = Integer.valueOf(cos1.getText().toString());\n" +
                "        int l = Integer.valueOf(log1.getText().toString());\n" +
                "        sin1.setText(Math.sin(Math.toRadians(s))+\"\");\n" +
                "        cos1.setText(Math.cos(Math.toRadians(c))+\"\");\n" +
                "        log1.setText(Math.log(l)+\"\");");

    }

    Timer t = null;
    public void animation(View v)
    {
       final ImageView iv = (ImageView)findViewById(R.id.iv);
        t = new Timer();
        TimerTask tt = new TimerTask() {
            @Override
            public void run() {
                iv.setTranslationX(iv.getX()+10);
                iv.setRotation(iv.getRotation()+10);

            }
        };
        t.schedule(tt, 0,50);
    }
    public void animationPause(View v){
        t.cancel();
    }
    public void animationCode(View v){

        showCode("final ImageView iv = (ImageView)findViewById(R.id.iv);\n" +
                "       Timer t = new Timer();\n" +
                "        TimerTask tt = new TimerTask() {\n" +
                "            @Override\n" +
                "            public void run() {\n" +
                "                iv.setTranslationX(iv.getX()+10);\n" +
                "                iv.setRotation(iv.getRotation()+10);\n" +
                "            }\n" +
                "        };\n" +
                "        t.schedule(tt, 0,50);");


    }

    public void drawing(View view)
    {
        View mv = (View)findViewById(R.id.mv);
        Bitmap bm = Bitmap.createBitmap(400,400, Bitmap.Config.ARGB_8888);
        Canvas cv = new Canvas(bm);
        Rect r = new Rect();
        r.set(100,100,200,200);
        cv.translate(r.left, r.right);
        mv.draw(cv);
    }
}

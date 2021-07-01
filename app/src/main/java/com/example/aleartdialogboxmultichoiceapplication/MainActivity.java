package com.example.aleartdialogboxmultichoiceapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button button1;
    TextView textView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1=findViewById(R.id.button1);
        textView1=findViewById(R.id.textview1);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder= new AlertDialog.Builder(MainActivity.this);
                String[] colorsArray= new String[]{"Red","Green","Blue","White","Black"};
                final boolean[] checkedColorsArray=new boolean[]{
                        true,
                        false,
                        false,
                        true,
                        false,
                };
                final List<String>colorList = Arrays.asList(colorsArray);
                builder.setTitle("select colors");
                builder.setIcon(R.drawable.ico);
                builder.setMultiChoiceItems(colorsArray, checkedColorsArray, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        checkedColorsArray[which]=isChecked;
                        String currentItem=colorList.get(which);
                        Toast.makeText(MainActivity.this,currentItem+" " + isChecked,Toast.LENGTH_LONG).show();
                   
                    }
                });
                
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                       textView1.setText("Your preffered colors..\n");
                       for (int i=0; i<checkedColorsArray.length;i++);

                        int i = 0;
                        boolean checked = checkedColorsArray[i];
                        if (checked){
                            textView1.setText(textView1.getText()+colorList.get(i)+"\n");
                        }
                    }
                });
                builder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        
                    }
                });
                AlertDialog dialog=builder.create();
                dialog.show();
            }
        });

    }
}










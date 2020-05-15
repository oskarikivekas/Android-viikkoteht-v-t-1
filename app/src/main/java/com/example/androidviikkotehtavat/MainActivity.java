package com.example.androidviikkotehtavat;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.view.View;
import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    TextView progressBar;
    TextView header;
    TextView balance;
    TextView screen;
    SeekBar seekBar;
    Spinner spinner;
    int max = 20, current = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        header = findViewById(R.id.header);
        balance = findViewById(R.id.balance);
        screen = findViewById(R.id.screen);
        progressBar = findViewById(R.id.progressBar);
        seekBar = findViewById(R.id.seekBar);
        spinner = findViewById(R.id.spinner);
        seekBar.setMax(max);
        seekBar.setProgress(current);
        progressBar.setText("" + current);

        String items[] = new String[]{"Pepsi Max 0.5 1.8€","Pepsi Max 1.5 2.2€", "Cola Zero 0.5 2.0€", "Cola Zero 1.5 2.5€", "Fanta Zero 0.5 1.95€"};
        ArrayAdapter<CharSequence> adapter = new ArrayAdapter<CharSequence>(MainActivity.this, android.R.layout.simple_spinner_item, items);
        spinner.setAdapter(adapter);


        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                current = progress;
                progressBar.setText("" + current);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

    }
    BottleDispenser machine = BottleDispenser.getInstance();
    public void buyBottle(View v){
        int choise = spinner.getSelectedItemPosition() + 1;
        System.out.println(choise + " valinta koneesta");
        int i = machine.buyBottle(choise);
        if (i == 1){
            screen.setText("Add money first!");
        }else if(i == 2){
            screen.setText("That bottle has sold out! Try something else.");
        }else if(i == 3){
            screen.setText("Bottle came out of the dispenser!");
            double money = machine.getMoney();
            NumberFormat nm = NumberFormat.getNumberInstance();
            balance.setText("Balance: " + nm.format(money) + "€");

        }
    }
    public void addMoney(View v){
        double money = machine.addMoney(current);
        screen.setText("Klink! Added more money!");
        NumberFormat nm = NumberFormat.getNumberInstance();
        balance.setText("Balance: " + nm.format(money) + "€");
        seekBar.setProgress(0);
    }
    public void moneyback(View V){
        double remain = machine.returnMoney();
        balance.setText("Balance: 0.00");
        screen.setText(remain + "€ came out of the dispenser!");
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
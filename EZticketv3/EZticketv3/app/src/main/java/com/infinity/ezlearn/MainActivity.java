package com.infinity.ezlearn;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainActivity.setMatchData();

        Button bOrderTicket = (Button)findViewById(R.id.button1);
        bOrderTicket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, OrderTicketActivity.class);
                startActivity(intent);
            }
        });

        Button bOrderCall = (Button)findViewById(R.id.button2);
        bOrderCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, OrderCallActivity.class);
                startActivity(intent);
            }
        });

        Button bSchedule = (Button)findViewById(R.id.button3);
        bSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ScheduleActivity.class);
                startActivity(intent);
            }
        });

        Button bInvoice = (Button)findViewById(R.id.button4);

            bInvoice.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    if (checkOrdered()) {
                        Intent intent = new Intent(MainActivity.this, InvoiceActivity.class);
                        startActivity(intent);
                    } else {
                        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                        builder.setCancelable(false);
                        builder.setTitle("Alert!");
                        builder.setMessage("You must order your ticket first!");
                        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                //
                            }
                        });
                    builder.create().show();
                    }
                }
            });

        Button bSuggest = (Button)findViewById(R.id.button5);
        bSuggest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SuggestionActivity.class);
                startActivity(intent);
            }
        });
    }

    private boolean checkOrdered(){
        if (Customer.fullName != null && Customer.idNumber != null && Customer.address != null
                && Customer.phone != null && Customer.ticketCategory != null &&
                Customer.totalTicket != null && Customer.match != null) {
            return true;
        }else {
            return false;
        }
    }

    private static void setMatchData(){
        MatchData.addMatchData("Tottenham vs Everton", true, "Premier League", "5/12/18",0);
        MatchData.addMatchData("Manchester City vs Liverpool", true, "League Cup", "5/12/18", 1);
        MatchData.addMatchData("Watford vs West Ham", false, "Premier League", "5/12/18", 2);
        MatchData.addMatchData("Burnley vs Cardiff", false, "Premier League", "6/12/18", 3);
        MatchData.addMatchData("Huddersfield vs Newcastle", false, "Premier League", "6/12/18", 4);
        MatchData.addMatchData("Wolves vs Chelsea", false, "Premier League", "6/12/18", 5);
        MatchData.addMatchData("Manchester United vs Arsenal", true, "FA CUP", "6/12/18", 6);
        MatchData.addMatchData("Fulham vs Leicester", false, "Premier League", "6/12/18", 7);
        MatchData.addMatchData("Tottenham vs Southampton", false, "Premier League", "6/12/18", 8);
        MatchData.addMatchData("Barcelona vs Tottenham", true, "Champions League", "12/12/18", 9);
        MatchData.addMatchData("Liverpool vs Napoli", true, "Champions League", "12/12/18", 10);
        MatchData.addMatchData("Monaco vs Dortmund", true, "Champions League", "12/12/18", 11);
        MatchData.addMatchData("Ajax vs Bayern München", true, "Champions League", "13/12/18", 12);
        MatchData.addMatchData("Manchester City v Hoffenheim", false, "Champions League", "13/12/18", 13);
    }
}

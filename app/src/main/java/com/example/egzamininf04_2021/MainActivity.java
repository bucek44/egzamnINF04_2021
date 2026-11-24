package com.example.egzamininf04_2021;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button zatwierdz ;
    EditText email ;
    EditText haslo ;
    EditText powtorzenieHasla;
    TextView powiadomienie;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        zatwierdz = findViewById(R.id.btnZatwierdz);
        email = findViewById(R.id.editTextTextEmailAddress);
        haslo = findViewById(R.id.editTextTextPassword);
        powtorzenieHasla = findViewById(R.id.editTextTextPasswordPowtorz);
        powiadomienie = findViewById(R.id.textViewPowaidomienie);
        zatwierdz.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (!email.getText().toString().contains("@"))
                            powiadomienie.setText("nie poprawny email");

                        else if (!haslo.getText().toString().equals(powtorzenieHasla.getText().toString()
                                ))
                            powiadomienie.setText("hasła się różnią");
                        else if (haslo.getText().toString().equals("")) {
                            powiadomienie.setText("nie wpisałeś hasla");
                        } else
                            powiadomienie.setText("witaj " + email.getText());

                    }
                }
        );
    }
}
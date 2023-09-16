package com.example.ii112;



import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText entrer;
    TextView prix;
    RadioGroup TypeClient;
    Button clear, calculer;
    RadioButton familial, normal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        entrer = findViewById(R.id.entrer);
        prix = findViewById(R.id.prix);
        TypeClient = findViewById(R.id.TypeClient);
        clear = findViewById(R.id.clear);
        calculer = findViewById(R.id.calculer);
        familial = findViewById(R.id.familial);
        normal = findViewById(R.id.normal);

        calculer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String distanceStr = entrer.getText().toString();
                double distance = Double.parseDouble(distanceStr);

                int selectedId = TypeClient.getCheckedRadioButtonId();
                RadioButton selectedRadioButton = findViewById(selectedId);

                boolean isFamilial = selectedRadioButton.getId() == R.id.familial;

                double price = calculatePrice(distance, isFamilial);

                prix.setText(String.valueOf(price));
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                entrer.setText("");
                prix.setText("");
                TypeClient.clearCheck();
            }
        });
    }

    private double calculatePrice(double distance, boolean isFamilial) {
        double basePrice;

        if (distance <= 9) {
            if (isFamilial) {
                basePrice = 40;
            } else {
                basePrice = 25;
            }
        }

        else {
            if (isFamilial) {
                basePrice = 60;
            } else {
                basePrice = 40;
            }        }



        return basePrice;
    }
}
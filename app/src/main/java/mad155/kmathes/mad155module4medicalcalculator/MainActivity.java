package mad155.kmathes.mad155module4medicalcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    double conversionRate = 2.2;
    double weightEntered;
    double convertedWeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        final EditText txtWeight = (EditText) findViewById(R.id.txtWeight);
        final RadioButton rbLbToKilo = (RadioButton) findViewById(R.id.rbPoundToKilo);
        final RadioButton rbKiloToLb = (RadioButton) findViewById(R.id.rbKiloToPound);
        final TextView txtResult = (TextView) findViewById(R.id.txtResult);

        Button convert = (Button) findViewById(R.id.btnConvert);

        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                weightEntered = Double.parseDouble(txtWeight.getText().toString());
                DecimalFormat formattedResultTenths = new DecimalFormat("#.#");

                if (txtWeight.getText().toString().isEmpty() || txtWeight == null )
                {
                    System.out.println("USER INPUT WEIGHT MISSING");
                    Toast.makeText
                            (getApplicationContext(), "Please enter patient weight" , Toast.LENGTH_SHORT)
                            .show();
                } else {

                    if (rbLbToKilo.isChecked()) {
                        if (weightEntered <= 500) {
                            convertedWeight = weightEntered / conversionRate;
                            txtResult.setText(formattedResultTenths.format(convertedWeight) + " kilograms");
                        } else {
                            txtResult.setText(" ");
                            Toast.makeText(MainActivity.this, "Pounds must be less than or equal 500", Toast.LENGTH_LONG).show();
                        }
                    }

                    if (rbKiloToLb.isChecked()) {
                        if (weightEntered <= 225) {
                            convertedWeight = weightEntered * conversionRate;
                            txtResult.setText(formattedResultTenths.format(convertedWeight) + " pounds");
                        } else {
                            txtResult.setText(" ");
                            Toast.makeText(MainActivity.this, "Kilos must be less than or equal 225", Toast.LENGTH_LONG).show();
                        }
                    }
                }
            }
        });
    }
}

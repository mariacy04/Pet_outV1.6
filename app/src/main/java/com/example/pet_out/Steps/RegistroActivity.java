package com.example.pet_out.Steps;

import androidx.appcompat.app.AppCompatActivity;
import com.example.pet_out.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class RegistroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);



        Button botonContinuarRegistro = (Button) findViewById(R.id.ContinuarRegistro);
        botonContinuarRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            //Método botón registrar mascota
            public void onClick(View v) {
                Intent ContinuarRegistro = new Intent(RegistroActivity.this, RegistroMascotaActivity.class);
                startActivity(ContinuarRegistro);

                Toast toast1 =
                        Toast.makeText(getApplicationContext(),
                                "Te damos la bienvenidad", Toast.LENGTH_SHORT);

                toast1.show();
            }
        });


    }
}
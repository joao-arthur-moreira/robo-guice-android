package com.example.joaoarthurmoreira.roboguice;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.inject.Inject;

import roboguice.activity.RoboActivity;
import roboguice.inject.ContentView;
import roboguice.inject.InjectResource;
import roboguice.inject.InjectView;

@ContentView(R.layout.activity_main)
public class MainActivity extends RoboActivity {

    @InjectView(R.id.edtNome)
    private EditText edtNome;

    @InjectView(R.id.btnEnviar)
    private Button btnEnviar;

    @InjectView(R.id.txtEmpresa)
    private TextView txtEmpresa;

    @InjectResource(R.string.empresa)
    private String empresa;

    @Inject
    private ConnectivityManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtNome.setText("João Arthur");
                txtEmpresa.setText(empresa);

                btnEnviar.setText(isConected() ? "conectado" : "desconectado");
            }
        });
    }

    private boolean isConected(){
        NetworkInfo info = manager.getActiveNetworkInfo();
        return info.isConnected();
    }
}

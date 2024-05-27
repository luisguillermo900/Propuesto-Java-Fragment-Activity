package com.example.propuestojavafragmentlambda;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements FormularioFragment.OnUsuarioCreatedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frameLayout, FormularioFragment.newInstance())
                .commit();
    }

    @Override
    public void onUsuarioCreated(Usuario usuario) {
        Intent intent = new Intent(this, HomeActivity.class);
        intent.putExtra("usuario", usuario);
        startActivity(intent);
    }
}

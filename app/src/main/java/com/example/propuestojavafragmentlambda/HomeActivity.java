package com.example.propuestojavafragmentlambda;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Usuario usuario = getIntent().getParcelableExtra("usuario");
        if (usuario != null) {
            TextView tvNombre = findViewById(R.id.tv_nombre);
            TextView tvApellidos = findViewById(R.id.tv_apellidos);
            TextView tvCorreo = findViewById(R.id.tv_correo);
            TextView tvCelular = findViewById(R.id.tv_celular);
            TextView tvUsuario = findViewById(R.id.tv_usuario);
            TextView tvContrasena = findViewById(R.id.tv_contrasena);

            tvNombre.setText(usuario.getNombre());
            tvApellidos.setText(usuario.getApellidos());
            tvCorreo.setText(usuario.getCorreo());
            tvCelular.setText(usuario.getCelular());
            tvUsuario.setText(usuario.getUsuario());
            tvContrasena.setText(usuario.getContrasena());
        }
    }
}

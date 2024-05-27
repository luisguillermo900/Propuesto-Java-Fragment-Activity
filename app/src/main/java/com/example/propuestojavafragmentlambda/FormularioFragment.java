package com.example.propuestojavafragmentlambda;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import androidx.fragment.app.Fragment;

public class FormularioFragment extends Fragment {

    private OnUsuarioCreatedListener listener;

    public interface OnUsuarioCreatedListener {
        void onUsuarioCreated(Usuario usuario);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_formulario, container, false);

        EditText etNombre = view.findViewById(R.id.et_nombre);
        EditText etApellidos = view.findViewById(R.id.et_apellidos);
        EditText etCorreo = view.findViewById(R.id.et_correo);
        EditText etCelular = view.findViewById(R.id.et_celular);
        EditText etUsuario = view.findViewById(R.id.et_usuario);
        EditText etContrasena = view.findViewById(R.id.et_contrasena);
        Button btnAceptar = view.findViewById(R.id.btn_aceptar);

        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Usuario usuario = new Usuario(
                        etNombre.getText().toString(),
                        etApellidos.getText().toString(),
                        etCorreo.getText().toString(),
                        etCelular.getText().toString(),
                        etUsuario.getText().toString(),
                        etContrasena.getText().toString()
                );
                listener.onUsuarioCreated(usuario);
            }
        });

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnUsuarioCreatedListener) {
            listener = (OnUsuarioCreatedListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnUsuarioCreatedListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

    public static FormularioFragment newInstance() {
        return new FormularioFragment();
    }
}

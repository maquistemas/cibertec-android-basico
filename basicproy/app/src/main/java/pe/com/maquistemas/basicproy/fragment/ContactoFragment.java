package pe.com.maquistemas.basicproy.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import pe.com.maquistemas.basicproy.R;
import pe.com.maquistemas.basicproy.email.Empresa;
import pe.com.maquistemas.basicproy.servicio.ServicioMensaje;
import pe.com.maquistemas.basicproy.session.SessionUsuario;


public class ContactoFragment extends Fragment implements View.OnClickListener{

    final String TAG = "ContactoFragment";
    EditText editTextSubject, editTextMessage;
    TextView tvFrom, tvTo;
    Button buttonSendEmail;
    String EMAIL_USUARIO = "";


    public ContactoFragment() {
        // Required empty public constructor


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_contacto, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getSessionUsuario();

        buttonSendEmail = view.findViewById(R.id.buttonSendEmail);
        editTextSubject = view.findViewById(R.id.editTextSubject);
        editTextMessage = view.findViewById(R.id.editTextMessage);

        tvFrom = view.findViewById(R.id.tvFrom);
        tvTo = view.findViewById(R.id.tvTo);

        initView();

        view.findViewById(R.id.buttonSendEmail).setOnClickListener(this);
//        getActivity().findViewById(R.id.buttonSendEmail).setOnClickListener(this);

    }

    private void initView() {

        tvFrom.setText(EMAIL_USUARIO);
        tvTo.setText(Empresa.EMPRESA_EMAIL.getValue());
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonSendEmail:
                Log.i(TAG, "CLICK");
                iniciarServicio();
                editTextSubject.setText("");
                editTextMessage.setText("");
                break;
        }
    }



    void iniciarServicio(){
        try {
            Intent intent = new Intent(getActivity(), ServicioMensaje.class);

            intent.putExtra(ServicioMensaje.TO, EMAIL_USUARIO);
            intent.putExtra(ServicioMensaje.SUBJECT, editTextSubject.getText().toString());
            intent.putExtra(ServicioMensaje.MESSAGE, editTextMessage.getText().toString());
            Log.i(TAG, "iniciarServicio");
            getActivity().startService(intent);

        }catch (Exception e){
            e.printStackTrace();
        }



//        finish();
    }


    void getSessionUsuario(){
        SessionUsuario sessionUsuario = new SessionUsuario(getActivity());
        EMAIL_USUARIO = sessionUsuario.getUsuarioSession().getEmail();
    }



}

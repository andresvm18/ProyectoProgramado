package com.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    /* MÉTODO PARA REGISTRAR UN USUARIO */
    public void newUser(View newUserClicked){
        /* SI ES PRESIONADO EL TEXTO DE 'txtNewAccount' SE MUESTRA LA PANTALLA DE REGISTRO */

        /* LLAMADO A 'registerActivity' */

        //startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
    }

    /* MÉTODO PARA VALIDAR LOS DATOS DE INICIO DE SESIÓN */
    public void loginUser(View loginBtnClicked){
        /* SI ES PRESIONADO BOTÓN 'btnLogin' SE MUESTRA LA PANTALLA DEL MENÚ */
        Button btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /* SE OBTIENE EL USUARIO INGRESADO POR EL USUARIO */
                EditText usernameData =  findViewById(R.id.txtUsername);
                String username = usernameData.getText().toString();
                String userData = username;


                /* SE OBTIENE LA CONTRASEÑA INGRESADA POR EL USUARIO */
                EditText passwordData = findViewById(R.id.txtPassword);
                String password = passwordData.getText().toString();
                userData += "-" + password;

                if( (username.equals( "" )) || password.equals( "" ) ){
                    /* LLAMADO AL MÉTODO PARA MOSTRAR EL TOAST */
                    emptyDataToast();

                    /* SE BORRAN LOS DATOS INGRESADOS */
                    usernameData.setText("");
                    passwordData.setText("");

                }else{
                    if( userData.equals( "UsuarioDePrueba-1234" )){
                        /* LLAMADO A LA PANTALLA DEL MENÚ*/
                        startActivity( new Intent(LoginActivity.this, MenuActivity.class));

                        /* TERMINAMOS LA ACTIVIDAD 'Login' */
                        finish();
                    }else {
                        /* SE BORRAN LOS DATOS INGRESADOS */
                        usernameData.setText("");
                        passwordData.setText("");

                        /* LLAMADO AL MÉTODO PARA NMOSTRAR EL TOAST */
                        loginToast( );
                    }

                }

            }
        });


    }

    /* MÉTODO PARA REESTABLECER LA CONTRASEÑA DEL USUARIO */
    public void resetPassword(View forgotPasswordClicked){
        /* SI ES PRESIONADO EL TEXTO DE 'txtForgotPassword' SE MUESTRA LA PANTALLA DE REESTABLECIMIENTO */

    }

    /* CONFIGURACIÓN DEL TOAST PERSONALIZADO 'Login' */
    public void loginToast(){
        LayoutInflater layoutInflater = getLayoutInflater();
        View toastLogin = layoutInflater.inflate(R.layout.toast_wronglogin, (ViewGroup) findViewById(R.id.loginToast));

        TextView txtMensaje = toastLogin.findViewById(R.id.txtLoginToast);

        /* MENSAJE DEL TOAST */
        txtMensaje.setText("Los datos ingresados son incorrectos");

        Toast loginToast = new Toast(getApplicationContext());
        loginToast.setGravity(Gravity.CENTER_VERTICAL | Gravity.BOTTOM, 0,200);

        /* DURACIÓN DEL TOAST */
        loginToast.setDuration(Toast.LENGTH_SHORT);
        loginToast.setView(toastLogin);

        /* SE MUESTRA EL TOAST */
        loginToast.show();
    }

    /* CONFIGURACIÓN DEL TOAST PERSONALIZADO 'EmptyData */
    public void emptyDataToast(){
        LayoutInflater layoutInflater = getLayoutInflater();
        View toastEmptyData = layoutInflater.inflate(R.layout.toast_emptydata, (ViewGroup) findViewById(R.id.emptyDataToast));

        TextView txtMensaje = toastEmptyData.findViewById(R.id.txtLoginToast);

        /* MENSAJE DEL TOAST */
        txtMensaje.setText("Uno o más campos están vacíos");

        Toast emptyDataToast = new Toast(getApplicationContext());
        emptyDataToast.setGravity(Gravity.CENTER_VERTICAL | Gravity.BOTTOM, 0,200);

        /* DURACIÓN DEL TOAST */
        emptyDataToast.setDuration(Toast.LENGTH_SHORT);
        emptyDataToast.setView(toastEmptyData);

        /* SE MUESTRA EL TOAST */
        emptyDataToast.show();
    }
}
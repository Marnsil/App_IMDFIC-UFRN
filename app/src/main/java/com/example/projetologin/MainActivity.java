package com.example.projetologin;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editEmail;
    private EditText editSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editEmail = findViewById(R.id.editEmail);
        editSenha = findViewById(R.id.editSenha);

    }

    public void entrar(View view) {

        String email = editEmail.getText().toString();
        String senha = editSenha.getText().toString();

        if(email.isEmpty()){
            editEmail.setError("Campo E-mail obrigatório");
            return;
        }

        if(senha.isEmpty()){
            editSenha.setError("Campo Senha obrigatório");
            return;
        }

        if(email.equals("admin@email.com") && senha.equals("admin")){
            Intent intent = new Intent(this,PrincipalActivity.class);

            intent.putExtra("email",email);
            intent.putExtra("senha",senha);

            startActivity(intent);
            finish();

        }else{
            Toast.makeText(this,"E-mail ou Senha incorreto!",Toast.LENGTH_LONG).show();
        }

    }

    public void cadastrar(View view) {

        //Toast.makeText(this,"Tela de Cadastro",Toast.LENGTH_LONG).show();

        Intent intent = new Intent(this,CadastroActivity.class);
        startActivityForResult(intent,
                10);


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable  Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 10 && resultCode ==  RESULT_OK){

            String email = data.getStringExtra("email");
            String senha = data.getStringExtra("senha");

            editEmail.setText(email);
            editSenha.setText(senha);

        }

    }
}
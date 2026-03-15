package com.example.dosecerta;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ResourceManagerInternal;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public

class MainActivity extends AppCompatActivity implements View

        .OnClickListener {
    ImageView foto;
    Button btAddFoto, btSalvar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btAddFoto = findViewById(R.id.addfoto);
        btSalvar = findViewById(R.id.salvar);

        btAddFoto.setOnClickListener(this);
        btSalvar.setOnClickListener(this);

        foto = findViewById(R.id.foto);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.addfoto) {
            escolherImagem();
        } if (v.getId() == R.id.salvar){
            Toast.makeText(this, "Remédio salvo!",Toast.LENGTH_SHORT).show();
        }
    }

    private void escolherImagem() {
        String[] opcoes = {"Camera", "Galeria"};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setItems(opcoes, (dialog, which) -> {
            if (which == 0) {
                abrirCamera();
            }
            if (which == 1) {
                abrirGaleria();
            }
        });
        builder.show();
    }

    private void abrirCamera() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, 1);
    }

    private void abrirGaleria() {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent, 2);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == 1) {

                Bundle extras = data.getExtras();
                Bitmap fotoBitmap = (Bitmap) extras.get("data");
                foto.setImageBitmap(fotoBitmap);

            }
            }
            if (requestCode == 2) {
                Uri imagem = data.getData();
                foto.setImageURI(imagem);

            }

        }
    }

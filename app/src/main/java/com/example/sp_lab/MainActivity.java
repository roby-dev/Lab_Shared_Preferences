package com.example.sp_lab;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.preference.PreferenceManager;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    Button btnRed,btnBlue,btnGreen,btnYellow,btnAmber,btnPurple,btnBlack,btnGrey,btnBrown,btnCyan,btnIndigo,btnPink;
    private Window window;

    private static final String TAG = "MainActivity";
    private SharedPreferences mPreferences;
    private SharedPreferences.Editor mEditor;

    Toolbar toolbar;

    private Spinner spTamanio;
    TextView txtSpinner;
    TextView txtTema;
    TextView txtFuente;
    TextView texto_toolbar;
    Button btnGuardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.window=getWindow();
        setContentView(R.layout.activity_main);
        txtSpinner = (TextView) findViewById(R.id.sptext);
        spTamanio = (Spinner) findViewById(R.id.spAnimals);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.tamanio, R.layout.spinert_txt);
        adapter.setDropDownViewResource(R.layout.spinert_txt);
        spTamanio.setAdapter(adapter);
        settings();

    }

    private void settings() {

        btnRed = (Button) findViewById(R.id.btnRed);
        btnBlue = (Button) findViewById(R.id.btnBlue);
        btnGreen = (Button) findViewById(R.id.btnGreen);
        btnYellow = (Button) findViewById(R.id.btnYellow);
        btnAmber = (Button) findViewById(R.id.btnAmber);
        btnPurple = (Button) findViewById(R.id.btnPurple);
        btnBlack = (Button) findViewById(R.id.btnBlack);
        btnGrey = (Button) findViewById(R.id.btnGrey);
        btnBrown = (Button) findViewById(R.id.btnBrown);
        btnCyan = (Button) findViewById(R.id.btnCyan);
        btnIndigo = (Button) findViewById(R.id.btnIndigo);
        btnPink = (Button) findViewById(R.id.btnPink);
        txtTema = (TextView) findViewById(R.id.txtTema);
        txtFuente = (TextView) findViewById(R.id.txtFuente);
        toolbar= (Toolbar) findViewById(R.id.toolbar);
        texto_toolbar = (TextView) findViewById(R.id.texto_toolbar);
        btnGuardar = (Button) findViewById(R.id.btnGuardar);

        btnRed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cambiarColor(R.color.md_red_700,R.color.md_red_900,R.color.md_red_50);
            }
        });

        btnBlue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cambiarColor(R.color.md_blue_700,R.color.md_blue_900,R.color.md_blue_50);
            }
        });
        btnGreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cambiarColor(R.color.md_green_700,R.color.md_green_900,R.color.md_green_50);
            }
        });
        btnYellow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cambiarColor(R.color.md_yellow_700,R.color.md_yellow_900,R.color.md_yellow_50);
            }
        });
        btnAmber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cambiarColor(R.color.md_amber_700,R.color.md_amber_900,R.color.md_amber_50);
            }
        });
        btnPurple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cambiarColor(R.color.md_purple_700,R.color.md_purple_900,R.color.md_purple_50);
            }
        });
        btnBlack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cambiarColor(R.color.md_black_1000,R.color.md_grey_700,R.color.md_grey_50);
            }
        });
        btnGrey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cambiarColor(R.color.md_grey_700,R.color.md_black_1000,R.color.md_grey_50);
            }
        });
        btnBrown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cambiarColor(R.color.md_brown_700,R.color.md_brown_900,R.color.md_brown_50);
            }
        });
        btnCyan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cambiarColor(R.color.md_cyan_700,R.color.md_cyan_900,R.color.md_cyan_50);
            }
        });
        btnIndigo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cambiarColor(R.color.md_indigo_700,R.color.md_indigo_900,R.color.md_indigo_50);
            }
        });
        btnPink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cambiarColor(R.color.md_pink_700,R.color.md_pink_900,R.color.md_pink_50);
            }
        });

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("Tema y fuentes guardado");
                builder.setPositiveButton("Aceptar", null);
                AlertDialog dialog = builder.create();
                dialog.show();
                mEditor.commit();
            }
        });
        mPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        mEditor = mPreferences.edit();
        mEditor.putInt("BLANCO",R.color.md_white_1000);

        spTamanio.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                int fuente=0;
                switch (position){
                    case 0 :
                        fuente = R.style.TextAppearance_AppCompat_Medium;
                        ((TextView)parent.getChildAt(0)).setTextAppearance(fuente);
                        txtSpinner.setTextSize(15);
                        break;
                    case 1 :
                        fuente = R.style.TextAppearance_AppCompat_Large;
                        ((TextView)parent.getChildAt(0)).setTextAppearance(fuente);
                        txtSpinner.setTextSize(20);
                        break;
                    case 2 :
                        fuente = R.style.TextAppearance_AppCompat_Small;
                        ((TextView)parent.getChildAt(0)).setTextAppearance(fuente);
                        txtSpinner.setTextSize(10);
                        break;
                }
                texto_toolbar.setTextColor(getResources().getColor(R.color.md_white_1000));
                btnGuardar.setTextColor(getResources().getColor(R.color.md_white_1000));
                txtFuente.setTextAppearance(fuente);
                txtTema.setTextAppearance(fuente);
                texto_toolbar.setTextAppearance(fuente);
                btnGuardar.setTextAppearance(fuente);

                mEditor.putInt("FUENTE",fuente);
                mEditor.putInt("POSICION",position);

            } // to close the onItemSelected
            public void onNothingSelected(AdapterView<?> parent)
            {

            }
        });



        checkSharedPreferences();
    }

    private void cambiarColor(int primaryDark, int primary, int background){
        window.setStatusBarColor(getResources().getColor(primaryDark));
        toolbar.setBackgroundColor(getResources().getColor(primary));
        window.setBackgroundDrawable(new ColorDrawable(getResources().getColor(background)));
        window.setNavigationBarColor(getResources().getColor(primary));
        btnGuardar.setBackground(new ColorDrawable(getResources().getColor(primaryDark)));
        btnGuardar.setTextColor(getResources().getColor(R.color.md_white_1000));
        texto_toolbar.setTextColor(getResources().getColor(R.color.md_white_1000));
        mEditor.putInt("PRIMARYDARK",primaryDark);
        mEditor.putInt("PRIMARY",primary);
        mEditor.putInt("BACKGROUND",background);

    }





    private void checkSharedPreferences(){
        int primaryDark = mPreferences.getInt("PRIMARYDARK",R.color.md_grey_700);
        int primary = mPreferences.getInt("PRIMARY",R.color.md_black_1000);
        int background = mPreferences.getInt("BACKGROUND",R.color.md_white_1000);
        int fuente = mPreferences.getInt("FUENTE",R.style.TextAppearance_AppCompat_Medium);
        int posicion =  mPreferences.getInt("POSICION",0);
        int blanco = mPreferences.getInt("BLANCO",R.color.md_white_1000);
                
        texto_toolbar.setTextColor(getResources().getColor(blanco));
        btnGuardar.setTextColor(getResources().getColor(blanco));
        btnGuardar.setBackground(new ColorDrawable(getResources().getColor(primaryDark)));
        spTamanio.setSelection(posicion);
        txtFuente.setTextAppearance(fuente);
        btnGuardar.setTextAppearance(fuente);
        window.setStatusBarColor(getResources().getColor(primaryDark));
        toolbar.setBackgroundColor(getResources().getColor(primary));
        window.setBackgroundDrawable(new ColorDrawable(getResources().getColor(background)));
        window.setNavigationBarColor(getResources().getColor(primary));

    }
}
package com.example.darcysolarte.segundocorte1;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import java.lang.reflect.Method;
import java.net.URL;


public class CapturarRecuerdo extends ActionBarActivity {
    //como pasar la base de datos de pc a pc
    //si esta bien soap_action con namespace
    private static final String SOAP_ACTION="http://ws/addfoto";
    private static final String METHOD_NAME="addfoto";
    private static final String NAMESPACE="http://ws/";
    private static final String URL="http://192.168.1.114:8080/Recuerdos/RecuerdosWS?WSDL";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capturar_recuerdo2);


        //Button btn = (Button) findViewById(R.id.guardar1);
        //btn.setOnClickListener(new Button.OnClickListener(){

            /*public void onClick(View v){
                new Thread() {
                    public void run() {

                        //Toast.makeText(getApplicationContext(),"save",Toast.LENGTH_SHORT).show();




                        //SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);

                        EditText edit = (EditText) findViewById(R.id.edit1);
                        EditText edit2 = (EditText) findViewById(R.id.edit2);

                        edit2.setText("holajjjjjjjjjjjjjjjjj");

                        /*request.addProperty("Id", Integer.parseInt(edit2.getText().toString()));
                        request.addProperty("Nombre", edit.getText().toString());



                        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER10);
                        envelope.setOutputSoapObject(request);

                        try {
                            HttpTransportSE http = new HttpTransportSE(URL);
                            http.call(SOAP_ACTION, envelope);
                            final SoapPrimitive response = (SoapPrimitive) envelope.getResponse();
                        } catch (Exception e) {
                            e.printStackTrace();
                            ;


                        }*/
                    /*}


                }.start();
            }
        });*/


    }
    public void onClickAgregar(View v) {


        final EditText edit = (EditText) findViewById(R.id.edit1);
        final EditText edit3 = (EditText) findViewById(R.id.edit2);


        new Thread(){

            public void run(){


                SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);

                request.addProperty("Id", Integer.parseInt(edit.getText().toString()));
                request.addProperty("Nombre", edit3.getText().toString());



                        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER10);
                        envelope.setOutputSoapObject(request);

                        try {
                            HttpTransportSE http = new HttpTransportSE(URL);
                            http.call(SOAP_ACTION, envelope);
                            final SoapPrimitive response = (SoapPrimitive) envelope.getResponse();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }


            }


        }.start();

    }











   /* public void onClickAgregar(View v) {
        //esto es normal=>



        new Thread() {
            public void run() {
                SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);

                EditText e1 = (EditText) findViewById(R.id.edit1);
//esta bien el nombre?

                request.addProperty("nombrefoto", Integer.parseInt(e1.getText().toString()));


                SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER10);
                envelope.setOutputSoapObject(request);

                try {
                    HttpTransportSE http = new HttpTransportSE(URL);
                    http.call(SOAP_ACTION, envelope);
                    final SoapPrimitive response = (SoapPrimitive) envelope.getResponse();
                } catch (Exception e) {
                    e.printStackTrace();
                    ;


                }
            }


        }.start();
    }
*/
    public void onClickSiguiente1(View v) {
        Intent i = new Intent(this, Localizacion.class);
        startActivity(i);
    }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_capturar_recuerdo, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}


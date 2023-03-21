package com.miempresa.diccionario_esp_ing;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.HashMap;
import java.util.Map;

public class MainActivityViewModel extends AndroidViewModel {

    private Context context;
    private MutableLiveData<String> resultado = null;

    public Map<String,String> diccionario = new HashMap<>();





    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        this.context = application.getApplicationContext();

        diccionario.put("casa","house");
        diccionario.put("perro", "dog");
        diccionario.put("queso", "cheese");




    }
    public LiveData<String> getResultado(){
        if(resultado==null){

            this.resultado=new MutableLiveData<>();

        }
        return resultado;
    }





    public void traducir(String palabraEsp){


           if(diccionario.get(palabraEsp) != null){
               resultado.setValue(diccionario.get(palabraEsp));
           }
           else{
               resultado.setValue("No encontrada");
           }




    }

}

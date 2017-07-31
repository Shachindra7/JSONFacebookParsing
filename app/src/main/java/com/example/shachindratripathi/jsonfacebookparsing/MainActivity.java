package com.example.shachindratripathi.jsonfacebookparsing;

import android.content.res.AssetManager;
import android.content.res.ColorStateList;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.concurrent.ExecutorCompletionService;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayList arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void readJson() {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(
                    new InputStreamReader(getAssets().open("filename.txt")));
            // do reading, usually loop until end of file reading
            String mLine;
            while ((mLine = reader.readLine()) != null) {
                //process line
            }
        } catch (IOException e) {
            //log the exception
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    //log the exception
                }
            }
        }
    }
    private void parseJSON(){

        StringBuilder stringBuilder = new StringBuilder();
        JSONObject jsonObject = new  JSONObject();
        JSONArray jsonArray = new JSONArray();
        ArrayList<FacebookModel>facebookModelArrayList = new ArrayList<>();


        for(int i= 0 ; i<jsonArray.length(); i++){
            FacebookModel facebookModelobject = new FacebookModel();
            try{
            JSONObject jsonRealObject = jsonArray.getJSONObject(i);

                facebookModelobject.setId(jsonRealObject.getString("id"));
                facebookModelobject.setMessage(jsonRealObject.getString("message"));
                facebookModelobject.setType(jsonRealObject.getString("type"));
                facebookModelobject.setCreated_time(jsonRealObject.getString("created_time"));
                facebookModelobject.setUpdated_time(jsonRealObject.getString("updated_time"));
                ArrayList<FromModel>fromModel = new ArrayList<>();

                FromModel fromModel1 = new FromModel();
                ArrayList<FromModel>fromList = new ArrayList<>();

                for (int j=0; i<jsonRealObject.getJSONObject("from").length();j++ )
                    {
                        JSONObject fromObject = jsonRealObject.getJSONObject("name").getJSONObject(String.valueOf(j));
                        fromModel1.setName(jsonRealObject.getString("name"));
                        fromModel1.setId(jsonRealObject.getString("id"));
                    }
                ActionsModel actionsModel = new ActionsModel();
                ArrayList<ActionsModel>actionList = new ArrayList<>();
                for (int k=0; i<jsonRealObject.getJSONObject("from").length();k++ ){
                        JSONObject actionsObject = jsonRealObject.getJSONArray("actions").getJSONObject(k);
                        actionsModel.setName(jsonRealObject.getString("name"));
                        actionsModel.setLink(jsonRealObject.getString("link"));
                }

                facebookModelobject.setActionsModel(actionList);
                facebookModelobject.setFromModel(fromList);
                facebookModelArrayList.add(facebookModelobject);
                Log.i("Array" , facebookModelArrayList.toString());

        }
        catch (JSONException e){
            e.printStackTrace();
        }

    }
    }
}





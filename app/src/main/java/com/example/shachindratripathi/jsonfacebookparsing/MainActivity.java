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
        readJson();
        parseJSON();
    }

    public void readJson() {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(
                    new InputStreamReader(getAssets().open("FacebookJSON")));
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

        try {

            for (int i = 0; i < jsonArray.length(); i++) {
                FacebookModel facebookModelObject = new FacebookModel();

                JSONObject jsonRealObject = jsonArray.getJSONObject(i);

                facebookModelObject.setId(jsonRealObject.getString("id"));
                facebookModelObject.setMessage(jsonRealObject.getString("message"));
                facebookModelObject.setType(jsonRealObject.getString("type"));
                facebookModelObject.setCreated_time(jsonRealObject.getString("created_time"));
                facebookModelObject.setUpdated_time(jsonRealObject.getString("updated_time"));
                ArrayList<FromModel> fromModel = new ArrayList<>();
                FromModel fromModel1 = new FromModel();
                ArrayList<FromModel> fromList = new ArrayList<>();

                for (int j = 0; i < jsonRealObject.getJSONObject("from").length(); j++) {
                    JSONObject fromObject = jsonRealObject.getJSONObject("name").getJSONObject(String.valueOf(j));
                    fromModel1.setName(jsonRealObject.getString("name"));
                    fromModel1.setId(jsonRealObject.getString("id"));
                }
                ActionsModel actionsModel = new ActionsModel();
                ArrayList<ActionsModel> actionList = new ArrayList<>();
                for (int k = 0; i < jsonRealObject.getJSONObject("from").length(); k++) {
                    JSONObject actionsObject = jsonRealObject.getJSONArray("actions").getJSONObject(k);
                    actionsModel.setName(jsonRealObject.getString("name"));
                    actionsModel.setLink(jsonRealObject.getString("link"));
                }

                facebookModelObject.setActionsModel(actionList);
                facebookModelObject.setFromModel(fromList);
                facebookModelArrayList.add(facebookModelObject);
                Log.i("Array", facebookModelArrayList.toString());

            }
        }
        catch (JSONException e){
            e.printStackTrace();
        }

    }
    }






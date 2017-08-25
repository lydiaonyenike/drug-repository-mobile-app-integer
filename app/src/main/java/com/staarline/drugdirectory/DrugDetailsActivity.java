package com.staarline.drugdirectory;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DrugDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drug_details);

        Drug drg = (Drug) getIntent().getSerializableExtra("drugs");

        TextView drugName = (TextView) findViewById(R.id.drugNameTextView);
        drugName.setText(drg.drugName);

        TextView disease = (TextView) findViewById(R.id.diseasesTextView);
        disease.setText(drg.diseases);

        TextView dosage = (TextView) findViewById(R.id.doseTextView);
        dosage.setText(drg.dosage);

        TextView sideEffect = (TextView) findViewById(R.id.effectTextView);
        sideEffect.setText(drg.adverseEffect);

        TextView manufacturer1 = (TextView) findViewById(R.id.ManuName1TextView);
        manufacturer1.setText(drg.manufacturer1);

        TextView manufacturer2 = (TextView) findViewById(R.id.ManuName2TextView);
        manufacturer2.setText(drg.manufacture2);

        TextView manufacturer3 = (TextView) findViewById(R.id.ManuName3TextView);
        manufacturer3.setText(drg.manufacture3);

        ImageView drugImage = (ImageView) findViewById(R.id.drugImage);
        Drawable newDrawable = getResources().getDrawable(drg.imageResourceId);
        drugImage.setImageDrawable(newDrawable);
    }
}

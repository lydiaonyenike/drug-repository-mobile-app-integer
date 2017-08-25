package com.staarline.drugdirectory;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    DrugArrayAdapter drugArrayAdapter;
    MenuItem searchMenuItem;
    SearchView searchView;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.list_view);
        drugArrayAdapter = new DrugArrayAdapter(getdrugTypes(), this);

        listView.setAdapter(drugArrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), DrugDetailsActivity.class);
                intent.putExtra("drugs", (Serializable) drugArrayAdapter.getItem(position));
                startActivity(intent);
            }
        });

        listView.setTextFilterEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);

        SearchManager searchManager = (SearchManager)
                getSystemService(Context.SEARCH_SERVICE);
        searchMenuItem = menu.findItem(R.id.search);
        searchView = (SearchView) searchMenuItem.getActionView();

        searchView.setSearchableInfo(searchManager.
                getSearchableInfo(getComponentName()));
        searchView.setSubmitButtonEnabled(true);
        searchView.setOnQueryTextListener(this);

        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        drugArrayAdapter.getFilter().filter(newText);
        if (TextUtils.isEmpty(newText)) {
            listView.clearTextFilter();
        }
        else {
            listView.setFilterText(newText.toString());
        }

        return true;
    }

    private List<Drug> getdrugTypes(){
        Drug drugclass = new Drug();
        drugclass.drugName ="ALBUTEROL";
        drugclass.diseases = "What is this medicine for? \nALBUTEROL (al BYOO ter ole) is a bronchodilator. it helps open up the airways in your lungs to make it easier to breathe. This medicine is used to treat and to prevent bronchospasm. ";
        drugclass.dosage = "follow the directions on the prescription label.";
        drugclass.adverseEffect = "Side effects that you should report to your doctor or health care professional as soon as possible: \n\t\tallergic reactions like sin rash, \n\t\titching or hives, \n\t\tswelling of the face, lips, or tongue \n\t\tbreathing problems \n\t\tchest pain \n\t\t" +
                "feeling faint or lightheaded, falls \n\t\thigh blood pressure \n\t\tirregular heartbeat \n\t\tfever \n\t\tmuscle cramps or weakness \n\t\tpain,tingling, \n\t\tnumbness in the hands or feet \n\t\tvomiting";
        drugclass.manufacturer1 = "Adpharm Pharmceuticals Ltd";
        drugclass.manufacture2 = "Chemiron International Ltd";
        drugclass.manufacture3 = "Drugfield Pharmaceuticals Ltd";
        drugclass.imageResourceId = R.drawable.fishcapsule;

        Drug drugclass2 = new Drug();
        drugclass2.drugName ="Ampicillin";
        drugclass2.diseases = "What is this medicine for? \nAmpicillin is a bronchodilator. it helps open up the airways in your lungs to make it easier to breathe. This medicine is used to treat and to prevent bronchospasm. ";
        drugclass2.dosage = "follow the directions on the prescription label.";
        drugclass2.adverseEffect = "Side effects that you should report to your doctor or health care professional as soon as possible: \n\t\tallergic reactions like sin rash, \n\t\titching or hives, \n\t\tswelling of the face, lips, or tongue \n\t\tbreathing problems \n\t\tchest pain \n\t\t" +
                "feeling faint or lightheaded, falls \n\t\thigh blood pressure \n\t\tirregular heartbeat \n\t\tfever \n\t\tmuscle cramps or weakness \n\t\tpain,tingling, \n\t\tnumbness in the hands or feet \n\t\tvomiting";
        drugclass2.manufacturer1 = "Adpharm Pharmceuticals Ltd";
        drugclass2.manufacture2 = "Chemiron International Ltd";
        drugclass2.manufacture3 = "Drugfield Pharmaceuticals Ltd";
        drugclass2.imageResourceId = R.drawable.whitecapsule;

        Drug drugclass3 = new Drug();
        drugclass3.drugName ="PANADOL";
        drugclass3.diseases = "What is this medicine for? \nPANADOL is a bronchodilator. it helps open up the airways in your lungs to make it easier to breathe. This medicine is used to treat and to prevent bronchospasm. ";
        drugclass3.dosage = "follow the directions on the prescription label.";
        drugclass3.adverseEffect ="Side effects that you should report to your doctor or health care professional as soon as possible: \n\t\tallergic reactions like sin rash, \n\t\titching or hives, \n\t\tswelling of the face, lips, or tongue \n\t\tbreathing problems \n\t\tchest pain \n\t\t" +
                "feeling faint or lightheaded, falls \n\t\thigh blood pressure \n\t\tirregular heartbeat \n\t\tfever \n\t\tmuscle cramps or weakness \n\t\tpain,tingling, \n\t\tnumbness in the hands or feet \n\t\tvomiting";
        drugclass3.manufacturer1 = "Adpharm Pharmceuticals Ltd";
        drugclass3.manufacture2 = "Chemiron International Ltd";
        drugclass3.manufacture3 = "Drugfield Pharmaceuticals Ltd";
        drugclass3.imageResourceId = R.drawable.panadol;

        Drug drugclass4 = new Drug();
        drugclass4.drugName ="PARACETAMOL";
        drugclass4.diseases = "What is this medicine for? \nPARACETAMOL is a bronchodilator. it helps open up the airways in your lungs to make it easier to breathe. This medicine is used to treat and to prevent bronchospasm. ";
        drugclass4.dosage = "follow the directions on the prescription label.";
        drugclass4.adverseEffect = "Side effects that you should report to your doctor or health care professional as soon as possible: \n\t\tallergic reactions like sin rash, \n\t\titching or hives, \n\t\tswelling of the face, lips, or tongue \n\t\tbreathing problems \n\t\tchest pain \n\t\t" +
                "feeling faint or lightheaded, falls \n\t\thigh blood pressure \n\t\tirregular heartbeat \n\t\tfever \n\t\tmuscle cramps or weakness \n\t\tpain,tingling, \n\t\tnumbness in the hands or feet \n\t\tvomiting";
        drugclass4.manufacturer1 = "Adpharm Pharmceuticals Ltd";
        drugclass4.manufacture2 = "Chemiron International Ltd";
        drugclass4.manufacture3 = "Drugfield Pharmaceuticals Ltd";
        drugclass4.imageResourceId = R.drawable.drugimage;

        Drug drugclass5 = new Drug();
        drugclass5.drugName ="Benzocaine";
        drugclass5.diseases = "What is this medicine for? \nBenzocaine is a bronchodilator. it helps open up the airways in your lungs to make it easier to breathe. This medicine is used to treat and to prevent bronchospasm. ";
        drugclass5.dosage = "follow the directions on the prescription label.";
        drugclass5.adverseEffect = "Side effects that you should report to your doctor or health care professional as soon as possible: \n\t\tallergic reactions like sin rash, \n\t\titching or hives, \n\t\tswelling of the face, lips, or tongue \n\t\tbreathing problems \n\t\tchest pain \n\t\t" +
                "feeling faint or lightheaded, falls \n\t\thigh blood pressure \n\t\tirregular heartbeat \n\t\tfever \n\t\tmuscle cramps or weakness \n\t\tpain,tingling, \n\t\tnumbness in the hands or feet \n\t\tvomiting";
        drugclass5.manufacturer1 = "Adpharm Pharmceuticals Ltd";
        drugclass5.manufacture2 = "Chemiron International Ltd";
        drugclass5.manufacture3 = "Drugfield Pharmaceuticals Ltd";
        drugclass5.imageResourceId = R.drawable.capsule;

        Drug drugclass6 = new Drug();
        drugclass6.drugName ="Cephalexin";
        drugclass6.diseases = "What is this medicine for? \nCephalexin is a bronchodilator. it helps open up the airways in your lungs to make it easier to breathe. This medicine is used to treat and to prevent bronchospasm. ";
        drugclass6.dosage = "follow the directions on the prescription label.";
        drugclass6.adverseEffect = "Side effects that you should report to your doctor or health care professional as soon as possible: \n\t\tallergic reactions like sin rash, \n\t\titching or hives, \n\t\tswelling of the face, lips, or tongue \n\t\tbreathing problems \n\t\tchest pain \n\t\t" +
                "feeling faint or lightheaded, falls \n\t\thigh blood pressure \n\t\tirregular heartbeat \n\t\tfever \n\t\tmuscle cramps or weakness \n\t\tpain,tingling, \n\t\tnumbness in the hands or feet \n\t\tvomiting";
        drugclass6.manufacturer1 = "Adpharm Pharmceuticals Ltd";
        drugclass6.manufacture2 = "Chemiron International Ltd";
        drugclass6.manufacture3 = "Drugfield Pharmaceuticals Ltd";
        drugclass6.imageResourceId = R.drawable.drugimage;


        Drug drugclass7 = new Drug();
        drugclass7.drugName ="Dicloxacillin";
        drugclass7.diseases = "What is this medicine for? \nDicloxacillin is a bronchodilator. it helps open up the airways in your lungs to make it easier to breathe. This medicine is used to treat and to prevent bronchospasm. ";
        drugclass7.dosage = "follow the directions on the prescription label.";
        drugclass7.adverseEffect = "Side effects that you should report to your doctor or health care professional as soon as possible: \n\t\tallergic reactions like sin rash, \n\t\titching or hives, \n\t\tswelling of the face, lips, or tongue \n\t\tbreathing problems \n\t\tchest pain \n\t\t" +
                "feeling faint or lightheaded, falls \n\t\thigh blood pressure \n\t\tirregular heartbeat \n\t\tfever \n\t\tmuscle cramps or weakness \n\t\tpain,tingling, \n\t\tnumbness in the hands or feet \n\t\tvomiting";
        drugclass7.manufacturer1 = "Adpharm Pharmceuticals Ltd";
        drugclass7.manufacture2 = "Chemiron International Ltd";
        drugclass7.manufacture3 = "Drugfield Pharmaceuticals Ltd";
        drugclass7.imageResourceId = R.drawable.whitecapsule;


        Drug drugclass8 = new Drug();
        drugclass8.drugName ="Desonide";
        drugclass8.diseases = "What is this medicine for? \nDesonide is a bronchodilator. it helps open up the airways in your lungs to make it easier to breathe. This medicine is used to treat and to prevent bronchospasm. ";
        drugclass8.dosage = "follow the directions on the prescription label.";
        drugclass8.adverseEffect = "Side effects that you should report to your doctor or health care professional as soon as possible: \n\t\tallergic reactions like sin rash, \n\t\titching or hives, \n\t\tswelling of the face, lips, or tongue \n\t\tbreathing problems \n\t\tchest pain \n\t\t" +
                "feeling faint or lightheaded, falls \n\t\thigh blood pressure \n\t\tirregular heartbeat \n\t\tfever \n\t\tmuscle cramps or weakness \n\t\tpain,tingling, \n\t\tnumbness in the hands or feet \n\t\tvomiting";
        drugclass8.manufacturer1 = "Adpharm Pharmceuticals Ltd";
        drugclass8.manufacture2 = "Chemiron International Ltd";
        drugclass8.manufacture3 = "Drugfield Pharmaceuticals Ltd";
        drugclass8.imageResourceId = R.drawable.capsule;


        Drug drugclass9 = new Drug();
        drugclass9.drugName ="Metoprolol";
        drugclass9.diseases = "What is this medicine for? \nMetoprolol is a bronchodilator. it helps open up the airways in your lungs to make it easier to breathe. This medicine is used to treat and to prevent bronchospasm. ";
        drugclass9.dosage = "follow the directions on the prescription label.";
        drugclass9.adverseEffect = "Side effects that you should report to your doctor or health care professional as soon as possible: \n\t\tallergic reactions like sin rash, \n\t\titching or hives, \n\t\tswelling of the face, lips, or tongue \n\t\tbreathing problems \n\t\tchest pain \n\t\t" +
                "feeling faint or lightheaded, falls \n\t\thigh blood pressure \n\t\tirregular heartbeat \n\t\tfever \n\t\tmuscle cramps or weakness \n\t\tpain,tingling, \n\t\tnumbness in the hands or feet \n\t\tvomiting";
        drugclass9.manufacturer1 = "Adpharm Pharmceuticals Ltd";
        drugclass9.manufacture2 = "Chemiron International Ltd";
        drugclass9.manufacture3 = "Drugfield Pharmaceuticals Ltd";
        drugclass9.imageResourceId = R.drawable.fishcapsule;


        Drug drugclass10 = new Drug();
        drugclass10.drugName ="Metformin";
        drugclass10.diseases = "What is this medicine for? \nMetformin is a bronchodilator. it helps open up the airways in your lungs to make it easier to breathe. This medicine is used to treat and to prevent bronchospasm. ";
        drugclass10.dosage = "follow the directions on the prescription label.";
        drugclass10.adverseEffect = "Side effects that you should report to your doctor or health care professional as soon as possible: \n\t\tallergic reactions like sin rash, \n\t\titching or hives, \n\t\tswelling of the face, lips, or tongue \n\t\tbreathing problems \n\t\tchest pain \n\t\t" +
                "feeling faint or lightheaded, falls \n\t\thigh blood pressure \n\t\tirregular heartbeat \n\t\tfever \n\t\tmuscle cramps or weakness \n\t\tpain,tingling, \n\t\tnumbness in the hands or feet \n\t\tvomiting";
        drugclass10.manufacturer1 = "Adpharm Pharmceuticals Ltd";
        drugclass10.manufacture2 = "Chemiron International Ltd";
        drugclass10.manufacture3 = "Drugfield Pharmaceuticals Ltd";
        drugclass10.imageResourceId = R.drawable.whitecapsule;


        Drug drugclass11 = new Drug();
        drugclass11.drugName ="Simvastatin";
        drugclass11.diseases = "What is this medicine for? \nSimvastatin is a bronchodilator. it helps open up the airways in your lungs to make it easier to breathe. This medicine is used to treat and to prevent bronchospasm. ";
        drugclass11.dosage = "follow the directions on the prescription label.";
        drugclass11.adverseEffect = "Side effects that you should report to your doctor or health care professional as soon as possible: \n\t\tallergic reactions like sin rash, \n\t\titching or hives, \n\t\tswelling of the face, lips, or tongue \n\t\tbreathing problems \n\t\tchest pain \n\t\t" +
                "feeling faint or lightheaded, falls \n\t\thigh blood pressure \n\t\tirregular heartbeat \n\t\tfever \n\t\tmuscle cramps or weakness \n\t\tpain,tingling, \n\t\tnumbness in the hands or feet \n\t\tvomiting";
        drugclass11.manufacturer1 = "Adpharm Pharmceuticals Ltd";
        drugclass11.manufacture2 = "Chemiron International Ltd";
        drugclass11.manufacture3 = "Drugfield Pharmaceuticals Ltd";
        drugclass11.imageResourceId = R.drawable.drugimage;

        List<Drug> drugTypes = new ArrayList<>();
        drugTypes.add(drugclass);
        drugTypes.add(drugclass2);
        drugTypes.add(drugclass3);
        drugTypes.add(drugclass4);
        drugTypes.add(drugclass5);
        drugTypes.add(drugclass6);
        drugTypes.add(drugclass7);
        drugTypes.add(drugclass8);
        drugTypes.add(drugclass9);
        drugTypes.add(drugclass10);
        drugTypes.add(drugclass11);

        return drugTypes;
    }
}

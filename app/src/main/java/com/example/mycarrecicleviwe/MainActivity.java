package com.example.mycarrecicleviwe;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements CarAdapter.Itemvlecd {
    Button butCar, butOwnerInfo;
    ImageView ivMake;
    TextView tvModel, tvName, tvPhone;

    FragmentManager fragmentManager;

    Fragment buttonFrag, carInfoFrag, listFrag, ownirInfoFrag;

    @Override
    public void onAttachFragment(@NonNull Fragment fragment) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        butCar = findViewById(R.id.btnCarInfo);
        butOwnerInfo = findViewById(R.id.btOwnerInfo);
        ivMake = findViewById(R.id.ivmake);
        tvModel = findViewById(R.id.tvmodel);
        tvName = findViewById(R.id.tvname);
        tvPhone = findViewById(R.id.tvtel);

        fragmentManager = getSupportFragmentManager();
        buttonFrag = fragmentManager.findFragmentById(R.id.buttonfrag);
        listFrag = fragmentManager.findFragmentById(R.id.listfrage);

        carInfoFrag = fragmentManager.findFragmentById(R.id.carinfofragg);
        ownirInfoFrag = fragmentManager.findFragmentById(R.id.ownirinfofrag);
        fragmentManager.beginTransaction().show(buttonFrag).show(listFrag).show(carInfoFrag).hide(ownirInfoFrag).commit();


        butOwnerInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager.beginTransaction().hide(carInfoFrag).show(ownirInfoFrag).commit();

            }
        });

        butCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fragmentManager.beginTransaction().show(carInfoFrag).hide(ownirInfoFrag).commit();


            }
        });

    }

    @Override
    public void onClicked(int index) {

        tvName.setText(ApplicationCar.cars.get(index).getOwnerName());
        tvPhone.setText(ApplicationCar.cars.get(index).getOwnerPhone());
        tvModel.setText(ApplicationCar.cars.get(index).getModel());
        if (ApplicationCar.cars.get(index).getMake().equals("Mercedes")){

            ivMake.setImageResource(R.drawable.mercedes);
        }
        if (ApplicationCar.cars.get(index).getMake().equals("Volkswagen")){

            ivMake.setImageResource(R.drawable.volkswagen);
        }if (ApplicationCar.cars.get(index).getMake().equals("Nissan")){

            ivMake.setImageResource(R.drawable.nissan);
        }
    }
}

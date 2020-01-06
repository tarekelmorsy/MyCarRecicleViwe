package com.example.mycarrecicleviwe;

import android.app.Application;

import java.util.ArrayList;

public class ApplicationCar extends Application {

    public  static ArrayList<Car> cars;
    @Override
    public void onCreate() {
        super.onCreate();
        cars = new ArrayList<Car>();
        cars.add(new Car("Volkswagen","Amara","Sef","008495834043" ));

        cars.add(new Car("Nissan","Amara","Tarek","008495834043" ));
        cars.add(new Car("Mercedes","E3434","Mohamed","008495834043" ));
        cars.add(new Car("Volkswagen","Amara","Sef","008495834043" ));
        cars.add(new Car("Nissan","Amara","Shade","008495834043" ));
        cars.add(new Car("Nissan","Amara","Shereen","008495834043" ));
        cars.add(new Car("Volkswagen","Amara","Youmna","008495834043" ));
        cars.add(new Car("Nissan","Amara","Atef","008495834043" ));
        cars.add(new Car("Volkswagen","Amara","Hawek","008495834043" ));




    }
}

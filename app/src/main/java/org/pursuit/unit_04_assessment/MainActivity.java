package org.pursuit.unit_04_assessment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.LinearLayout;

import org.pursuit.unit_04_assessment.controller.AnimalAdapter;
import org.pursuit.unit_04_assessment.model.Animal;
import org.pursuit.unit_04_assessment.model.AnimalList;
import org.pursuit.unit_04_assessment.network.AnimalService;
import org.pursuit.unit_04_assessment.network.RetrofitSingleton;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private AnimalAdapter animalAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);

        Retrofit retrofit = RetrofitSingleton.getInstance();
        AnimalService animalService = retrofit.create(AnimalService.class);
        Call<AnimalList> animalCall = animalService.getAnimals();
        animalCall.enqueue(new Callback<AnimalList>() {
            @Override
            public void onResponse(Call<AnimalList> call, Response<AnimalList> response) {
                List<Animal> animalList = response.body().getMessage();
                Log.d("TAG", "onResponse" + animalList.get(0));

                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
                animalAdapter = new AnimalAdapter(animalList);
                recyclerView.setAdapter(animalAdapter);
                recyclerView.setLayoutManager(linearLayoutManager);
            }

            @Override
            public void onFailure(Call<AnimalList> call, Throwable t) {
                Log.d("TAG", "onFailure" + t.toString());
            }
        });
    }
}

package org.pursuit.unit_04_assessment.view;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.pursuit.unit_04_assessment.R;
import org.pursuit.unit_04_assessment.SecondActivity;
import org.pursuit.unit_04_assessment.model.Animal;

public class AnimalViewHolder extends RecyclerView.ViewHolder {

    private ImageView imageView;
    private TextView textView;

    public AnimalViewHolder(@NonNull View itemView) {
        super(itemView);

        imageView = itemView.findViewById(R.id.animal_image_image_view);
        textView = itemView.findViewById(R.id.animal_title_text_view);
    }

    public void onBind(final Animal animal) {
        textView.setText(animal.getAnimal());
        Picasso.get().load(animal.getImage()).into(imageView);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("onClick", "isWorking" + animal.getAnimal() + animal.getImage() + animal.getWiki());

                Intent intent = new Intent(v.getContext(), SecondActivity.class);
                intent.putExtra("animal", animal.getAnimal());
                intent.putExtra("image", animal.getImage());
                intent.putExtra("wiki", animal.getWiki());
                v.getContext().startActivity(intent);
            }
        });
    }
}

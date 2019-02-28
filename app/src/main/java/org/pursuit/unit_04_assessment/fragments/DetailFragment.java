package org.pursuit.unit_04_assessment.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.pursuit.unit_04_assessment.R;
import org.pursuit.unit_04_assessment.model.Animal;

public class DetailFragment extends Fragment {

    private static final String NAME_KEY = "name";
    private static final String IMAGE_KEY = "image";
    private static final String WIKI_KEY = "wiki";

    private String name;
    private String image;
    private String wiki;

    private DetailFragment.OnFragmentInteractionListener fragmentInterface;


    public DetailFragment() {
        // Required empty public constructor
    }

    public static DetailFragment newInstance(String name, String image, String wiki) {
        DetailFragment fragment = new DetailFragment();
        Bundle args = new Bundle();
        args.putString(NAME_KEY, name);
        args.putString(IMAGE_KEY, image);
        args.putString(WIKI_KEY, wiki);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof DetailFragment.OnFragmentInteractionListener) {
            fragmentInterface = (DetailFragment.OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            name = getArguments().getString(NAME_KEY);
            image = getArguments().getString(IMAGE_KEY);
            wiki = getArguments().getString(WIKI_KEY);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView nameTextView = view.findViewById(R.id.display_text_view);
        ImageView imageView = view.findViewById(R.id.display_image_view);
        Button sendButton = view.findViewById(R.id.display_button);

        nameTextView.setText(name);
        Picasso.get().load(image).into(imageView);
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentInterface.onFragmentInteraction(wiki);
            }
        });

    }

    @Override
    public void onDetach() {
        super.onDetach();
        fragmentInterface = null;
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(String website);
    }
}

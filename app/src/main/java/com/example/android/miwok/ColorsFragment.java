package com.example.android.miwok;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ColorsFragment} factory method to
 * create an instance of this fragment.
 */
public class ColorsFragment extends Fragment {

    MediaPlayer mMediaPlayer;
    MediaPlayer.OnCompletionListener mCompletionListener=new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    };
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.word_list, container, false);
        {

            final ArrayList<Word> words = new ArrayList<Word>();
            words.add(new Word("red", "weṭeṭṭi", R.drawable.color_red, R.raw.color_red));
            words.add(new Word("mustard yellow", "chiwiiṭә", R.drawable.color_mustard_yellow,
                    R.raw.color_mustard_yellow));
            words.add(new Word("dusty yellow", "ṭopiisә", R.drawable.color_dusty_yellow,
                    R.raw.color_dusty_yellow));
            words.add(new Word("green", "chokokki", R.drawable.color_green, R.raw.color_green));
            words.add(new Word("brown", "ṭakaakki", R.drawable.color_brown, R.raw.color_brown));
            words.add(new Word("gray", "ṭopoppi", R.drawable.color_gray, R.raw.color_gray));
            words.add(new Word("black", "kululli", R.drawable.color_black, R.raw.color_black));
            words.add(new Word("white", "kelelli", R.drawable.color_white, R.raw.color_white));

            wordAdapter adapter=new wordAdapter(getActivity(),words,R.color.category_colors);

            ListView listView = (ListView) rootView.findViewById(R.id.list);

            listView.setAdapter(adapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                    // Get the {@link Word} object at the given position the user clicked on
                    Word word = words.get(position);

                    // Create and setup the {@link MediaPlayer} for the audio resource associated
                    // with the current word
                    releaseMediaPlayer();
                    mMediaPlayer = MediaPlayer.create(getActivity(), word.getAudioResouceId());

                    // Start the audio file
                    mMediaPlayer.start();
                    mMediaPlayer.setOnCompletionListener(mCompletionListener);
                }
            });
        }
        return rootView;
    }
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mMediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mMediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mMediaPlayer = null;
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }
}
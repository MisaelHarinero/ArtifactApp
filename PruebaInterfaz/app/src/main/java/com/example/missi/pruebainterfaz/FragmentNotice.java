package com.example.missi.pruebainterfaz;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FragmentNotice.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FragmentNotice#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentNotice extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private ListView list;
    private ArrayList<Heroes>heroes;

    private OnFragmentInteractionListener mListener;

    public FragmentNotice() {
        // Required empty public constructor
    }


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentNotice.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentNotice newInstance(String param1, String param2) {
        FragmentNotice fragment = new FragmentNotice();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        final View view  = inflater.inflate(R.layout.fragment_fragment_notice, container, false);
        this.list = view.findViewById(R.id.listView);
        BaseAdapter adapter = new BaseAdapter() {
            @Override
            public int getCount() {
                return heroes.size();
            }

            @Override
            public Object getItem(int position) {
                return heroes.get(position);
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                LayoutInflater layoutInflater = getLayoutInflater();
                convertView = inflater.inflate(R.layout.list_view_layout,parent,false);
                Heroes hero = heroes.get(position);
                ImageView cardImage = convertView.findViewById(R.id.cardImage);
                TextView nameHeroe = convertView.findViewById(R.id.textName);
                TextView damage = convertView.findViewById(R.id.atackText);
                TextView armor = convertView.findViewById(R.id.armorText);
                TextView health = convertView.findViewById(R.id.healthText);
                TextView skill = convertView.findViewById(R.id.skillText);
                LinearLayout ly = convertView.findViewById(R.id.layoutList);
                switch (hero.getColor()){
                    case "Black":{
                        ly.setBackgroundResource(R.color.back_black);
                        break;
                    }
                    case "Red":{
                        ly.setBackgroundResource(R.color.back_red);
                        break;
                    }
                    case "Green":{
                        ly.setBackgroundResource(R.color.back_green);
                        break;
                    }
                    case "Blue":{
                        ly.setBackgroundResource(R.color.back_blue);
                        break;
                    }


                }
                cardImage.setImageResource(hero.getId_img());
                nameHeroe.setText(hero.getName());
                damage.setText(Integer.toString(hero.getDaño()));
                armor.setText(Integer.toString(hero.getArmadura()));
                health.setText(Integer.toString(hero.getVida()));
                skill.setText(skill.getText().toString()+hero.getAbility());
                return convertView;
            }
        };
        this.list.setAdapter(adapter);
        // Inflate the layout for this fragment
        return view;
    }

    public ArrayList<Heroes> getHeroes() {
        return heroes;
    }

    public void setHeroes(ArrayList<Heroes> heroes) {
        this.heroes = heroes;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}

package com.example.missi.pruebainterfaz;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FragmentData.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FragmentData#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentData extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private ImageView typeCard;
    private ImageView colorCard;
    private TextView costCard;
    private TextView nameCard;
    private ImageView imgCard;
    private TextView infoTitle;
    private TextView infoMessage;
    private TextView atkMssg;
    private TextView armorMssg;
    private TextView healthMssg;
    private TextView atkText;
    private TextView armorText;
    private TextView healthText;
    private Carta carta;
    private final static int HERO_IMG = R.drawable.hero;
    private final static int SPELL_IMG = R.drawable.spell;
    private final static int EQUIP_IMG = R.drawable.equip;
    private final static int CREEP_IMG = R.drawable.creep;
    private final static int COLOR_BLACK = R.drawable.circle_gray;
    private final static int COLOR_BLUE = R.drawable.circle_blue;
    private final static int COLOR_RED = R.drawable.circle_red;
    private final static int COLOR_GREEN = R.drawable.circle_green;


    private OnFragmentInteractionListener mListener;

    public FragmentData() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentData.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentData newInstance(String param1, String param2) {
        FragmentData fragment = new FragmentData();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment_data, container, false);
        this.imgCard = view.findViewById(R.id.imgViewCarta);
        this.nameCard = view.findViewById(R.id.nameCard);
        this.typeCard = view.findViewById(R.id.typeCard);
        this.costCard = view.findViewById(R.id.costCard);
        this.colorCard = view.findViewById(R.id.colorCard);
        this.infoTitle = view.findViewById(R.id.typeInfo);
        this.infoMessage = view.findViewById(R.id.actionInfo);
        this.atkMssg = view.findViewById(R.id.atackMssg);
        this.armorMssg = view.findViewById(R.id.armorMssg);
        this.healthMssg = view.findViewById(R.id.healthMssg);
        this.atkText = view.findViewById(R.id.atackText);
        this.armorText = view.findViewById(R.id.armorText);
        this.healthText = view.findViewById(R.id.healthText);
        cargarCarta();
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    public void cargarCarta() {

        String uses = carta.getClass().getName();
        switch (uses) {
            case "com.example.missi.pruebainterfaz.Heroe": {
                this.typeCard.setImageResource(HERO_IMG);
                this.atkMssg.setText(R.string.attack);
                this.armorMssg.setText(R.string.armor);
                this.healthMssg.setText(R.string.health);
                Heroe hr = (Heroe) carta;
                this.atkText.setText(Integer.toString(hr.getDaño()));
                this.armorText.setText(Integer.toString(hr.getArmadura()));
                this.healthText.setText(Integer.toString(hr.getVida()));
                break;
            }
            case "com.example.missi.pruebainterfaz.Spell": {
                this.typeCard.setImageResource(SPELL_IMG);
                this.infoTitle.setText("ACCION: ");
                Spell spell = (Spell) this.carta;
                this.infoMessage.setText(spell.getEffect());

                break;
            }
            case "com.example.missi.pruebainterfaz.Weapon": {
                this.typeCard.setImageResource(EQUIP_IMG);

                break;
            }
            case "com.example.missi.pruebainterfaz.Creep": {
                this.atkMssg.setText(R.string.attack);
                this.armorMssg.setText(R.string.armor);
                this.healthMssg.setText(R.string.health);
                this.typeCard.setImageResource(CREEP_IMG);
                Creep creep = (Creep)carta;
                this.atkText.setText(Integer.toString(creep.getDaño()));
                this.armorText.setText(Integer.toString(creep.getArmadura()));
                this.healthText.setText(Integer.toString(creep.getVida()));
                break;
            }
        }
        switch (carta.getColor()) {
            case "Black": {
                this.colorCard.setImageResource(COLOR_BLACK);
                this.nameCard.setBackgroundResource(R.color.back_black);
                break;
            }
            case "Red": {
                this.colorCard.setImageResource(COLOR_RED);
                this.nameCard.setBackgroundResource(R.color.back_red);
                break;
            }
            case "Blue": {
                this.colorCard.setImageResource(COLOR_BLUE);
                this.nameCard.setBackgroundResource(R.color.back_blue);
                break;
            }
            case "Green": {
                this.colorCard.setImageResource(COLOR_GREEN);
                this.nameCard.setBackgroundResource(R.color.back_green);
                break;
            }
        }
        this.imgCard.setImageResource(carta.getId_img());
        this.nameCard.setText(carta.getName());
        this.costCard.setText(Integer.toString(carta.getCost()));
    }

    public Carta getCarta() {
        return carta;
    }

    public void setCarta(Carta carta) {
        this.carta = carta;
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

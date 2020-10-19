package fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.audiolibro2020completo.IComunicaFragments;
import com.example.audiolibro2020completo.R;

import java.util.ArrayList;

import Adaptadores.AdapterPersona;
import Entidades.Libro;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link fragment_libros#newInstance} factory method to
 * create an instance of this fragment.
 */
public class fragment_libros extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public fragment_libros() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment fragment_libros.
     */
    // TODO: Rename and change types and number of parameters
    public static fragment_libros newInstance(String param1, String param2) {
        fragment_libros fragment = new fragment_libros();
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

    AdapterPersona adapterPersona;
    RecyclerView recyclerView;
    ArrayList<Libro> listaLibros;

    Activity activity;
    IComunicaFragments interfaceComunicaFragments;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_libros, container, false);
        recyclerView=view.findViewById(R.id.reciclerView);
        listaLibros=new ArrayList<>();

        cargarLista();
        mostrarLista();
        return view;
    }
    public void cargarLista(){
        listaLibros.add(new Libro("Divina Comedia","Dante Alighieri","12/12/2012","Libro de infiernos",400, R.drawable.divina_comedia,1));
        listaLibros.add(new Libro("Avecilla","Francisco Ponce","20/06/1993","Libro de infiernos",345, R.drawable.avecilla,1));
        listaLibros.add(new Libro("Kappa","Eduardo Lavarre y Ernesto Frnchu","20/12/1998","Libro de infiernos",265, R.drawable.kappa,1));
        listaLibros.add(new Libro("La Iliada","Miospan Lopez","28/02/1001","Libro de infiernos",502, R.drawable.la_iliada,1));
        listaLibros.add(new Libro("La Cancion de Rolando","Fercho Molesca","15/04/2005","Libro de infiernos",156, R.drawable.cancion_rolando,1));
        listaLibros.add(new Libro("Matrim Sabuesos","Javier Mina","20/01/1999","Libro de infiernos",120, R.drawable.matrim_sabuesos,1));
        listaLibros.add(new Libro("El Viejo Pancho","Homer Jacob y Jessica Samano","10/02/1988","Libro de infiernos",280, R.drawable.viejo_pancho,1));
    }
    public void mostrarLista(){
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapterPersona=new AdapterPersona(getContext(),listaLibros);
        recyclerView.setAdapter(adapterPersona);

        RecyclerView.LayoutManager mlayoutManager=new GridLayoutManager(getContext(),2);
        recyclerView.setLayoutManager(mlayoutManager);

        adapterPersona.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombre=listaLibros.get(recyclerView.getChildAdapterPosition(view)).getTitulo();
                Toast.makeText(getContext(),nombre,Toast.LENGTH_LONG).show();
                interfaceComunicaFragments.enviarLibro(listaLibros.get(recyclerView.getChildAdapterPosition(view)));
            }
        });
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof Activity){
            this.activity=(Activity) context;
            interfaceComunicaFragments=(IComunicaFragments) this.activity;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
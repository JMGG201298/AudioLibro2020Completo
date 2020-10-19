package fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.audiolibro2020completo.R;

import Entidades.Libro;

public class DetalleLibro extends Fragment {
    TextView txtTitulo, txtxFecha, txtPaginas, txtResena, txtAutor;
    ImageView imagenPortada;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.detalle_libro_fragment,container,false);
        txtTitulo=view.findViewById(R.id.txtTituloD);
        txtAutor=view.findViewById(R.id.txtAutorD);
        txtPaginas=view.findViewById(R.id.tctPaginasD);
        txtResena=view.findViewById(R.id.txtResena);
        txtxFecha=view.findViewById(R.id.txtFechaD);
        imagenPortada=view.findViewById(R.id.iVPortadaD);

        Bundle objetoLibro=getArguments();
        Libro libro=null;

        if(objetoLibro!=null){
            libro=(Libro) objetoLibro.getSerializable("objeto");
            txtTitulo.setText(libro.getTitulo());
            txtAutor.setText(libro.getAutor());
            txtPaginas.setText(libro.getPaginas()+"");
            txtResena.setText(libro.getResena());
            txtxFecha.setText(libro.getFecha());
            imagenPortada.setImageResource(libro.getPortada());
        }

        return view;
    }
}

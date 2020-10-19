package Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.audiolibro2020completo.R;

import java.util.ArrayList;

import Entidades.Libro;

public class AdapterPersona extends RecyclerView.Adapter<AdapterPersona.ViewHolder> implements View.OnClickListener{
    LayoutInflater layoutInflater;
    ArrayList<Libro> model;

    private View.OnClickListener listener;
    public AdapterPersona(Context context, ArrayList<Libro> model){
        layoutInflater=LayoutInflater.from(context);
        this.model=model;
    }
    public void setOnClickListener(View.OnClickListener listener){
        this.listener=listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=layoutInflater.inflate(R.layout.lista_libros, parent, false);
        view.setOnClickListener(this);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {


        String nombre=model.get(position).getTitulo();
        int imagen=model.get(position).getPortada();
        holder.txtTitulo.setText(nombre);
        holder.imagenLibro.setImageResource(imagen);
    }

    @Override
    public int getItemCount() {
        return model.size();
    }

    @Override
    public void onClick(View view) {
        if(listener!=null){
            listener.onClick(view);
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imagenLibro;
        TextView txtTitulo;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imagenLibro=itemView.findViewById(R.id.imageLibro);
            txtTitulo=itemView.findViewById(R.id.txtTitulo);
        }
    }
}

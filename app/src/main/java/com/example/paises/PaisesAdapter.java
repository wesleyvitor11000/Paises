package com.example.paises;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class PaisesAdapter extends RecyclerView.Adapter<PaisesAdapter.ViewHolderPais> {

    private ArrayList<Pais> paises;

    public PaisesAdapter(ArrayList<Pais> paises){
        this.paises = paises;
    }

    @NonNull
    @Override
    public PaisesAdapter.ViewHolderPais onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.paises_card, parent, false);

        ViewHolderPais viewHolderPais = new ViewHolderPais(view, parent.getContext());

        return viewHolderPais;
    }

    @Override
    public void onBindViewHolder(@NonNull PaisesAdapter.ViewHolderPais holder, int position) {


        if(paises != null && paises.size() > 0){

            Pais pais = paises.get(position);

            String area = NumberFormat.getInstance(Locale.ITALY).format(pais.getArea());
            area = area.concat(" km²");
            holder.area_text.setText(area);
            holder.capital_text.setText(pais.getCapital());
            holder.continent_text.setText(pais.getContinent());
            holder.currency_text.setText(pais.getCurrency());
            holder.language_text.setText(pais.getLanguage());
            holder.name_text.setText(pais.getName());

            String population = NumberFormat.getInstance(Locale.FRANCE).format(pais.getPopulation());
            holder.population_text.setText(population);

            holder.icon_image.setImageBitmap(pais.getIcon());

        }

    }

    @Override
    public int getItemCount() {
        return paises.size();
    }

    public class ViewHolderPais extends RecyclerView.ViewHolder{

        TextView area_text;
        TextView capital_text;
        TextView continent_text;
        TextView currency_text;
        TextView language_text;
        TextView name_text;
        TextView population_text;

        ImageView icon_image;


        public ViewHolderPais(@NonNull View itemView, @NonNull Context c) {
            super(itemView);

            area_text = itemView.findViewById(R.id.area_text);
            capital_text = itemView.findViewById(R.id.capital_text);
            continent_text = itemView.findViewById(R.id.continent_text);
            currency_text = itemView.findViewById(R.id.currency_text);
            language_text = itemView.findViewById(R.id.language_text);
            name_text = itemView.findViewById(R.id.name_text);
            population_text = itemView.findViewById(R.id.population_text);

            icon_image = itemView.findViewById(R.id.icon_image);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(c, DetalhesActivity.class);
                    intent.putExtra("PAIS", paises.get(getLayoutPosition()));
                    c.startActivity(intent);
                }
            });

        }
    }
}

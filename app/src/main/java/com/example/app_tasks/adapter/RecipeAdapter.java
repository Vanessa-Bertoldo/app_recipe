package com.example.app_tasks.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.app_tasks.R;
import com.example.app_tasks.model.Recipe;

import java.util.List;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.MyViewHolder> {
    private List<Recipe> listRecipe;

    public RecipeAdapter(List<Recipe> list){
        this.listRecipe = list;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itensList = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_recipe, parent, false);
        return new MyViewHolder(itensList);
    }

    @Override
    public int getItemCount() {
        return listRecipe.size();
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Recipe recipe = listRecipe.get(position);

        holder.txtTitle.setText(recipe.getTitle());
        holder.txtDesc.setText(recipe.getDescription());
        holder.imageRecipe.setImageResource(recipe.getImage());
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView txtTitle;
        private TextView txtDesc;
        private ImageView imageRecipe;

        public MyViewHolder(View itemView){
            super(itemView);
            txtTitle         = itemView.findViewById(R.id.txtTitle);
            txtDesc          = itemView.findViewById(R.id.txtDes);
            imageRecipe      = itemView.findViewById(R.id.imageRecipe);
        }
    }

}

package com.pfa.cameraupload;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class AbsEtudFacAdapter extends RecyclerView.Adapter<AbsEtudHolder> {

    Context ct;
    List<SeanceEtudsFac> etudiants;
    ArrayList<Long> idEtudiants = new ArrayList<>();

    public AbsEtudFacAdapter(Context ct, List<SeanceEtudsFac> etudiants) {
        this.ct = ct;
        this.etudiants = etudiants;
    }

    @NonNull
    @Override
    public AbsEtudHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_row_etudab,null);
        return new AbsEtudHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AbsEtudHolder holder, int position) {
        holder.Nom.setText(etudiants.get(position).getNomComplets());
        if(etudiants.get(position).getAbs()==1){
            holder.chk.setChecked(true);
            idEtudiants.add(etudiants.get(position).getIdEtudiants());
        }
        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClickListener(View v, int position) {
                CheckBox chk = (CheckBox) v;
                if(chk.isChecked()) {
                    idEtudiants.add(etudiants.get(position).getIdEtudiants());
                }else if(!chk.isChecked()){
                    idEtudiants.remove(etudiants.get(position).getIdEtudiants());
                }

            }
        });
    }
    @Override
    public int getItemCount() {
        return etudiants.size();
    }
}
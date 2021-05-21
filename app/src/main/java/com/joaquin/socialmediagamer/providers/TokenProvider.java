package com.joaquin.socialmediagamer.providers;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.messaging.FirebaseMessaging;
import com.joaquin.socialmediagamer.models.Token;

public class TokenProvider {

    CollectionReference mCollection;

    public TokenProvider() {
        mCollection = FirebaseFirestore.getInstance().collection("Tokens");
    }

    public void create(String idUser) {
        if (idUser == null) {
            return;
        }
        FirebaseMessaging.getInstance().getToken().addOnCompleteListener(new OnCompleteListener<String>() {
            @Override
            public void onComplete(@NonNull Task<String> task) {
                if (task.isComplete()) {
                    Token token = new Token(task.getResult());
                    mCollection.document(idUser).set(token);
                }
            }
        });
    }

    public Task<DocumentSnapshot> getToken(String idUser) {
        return mCollection.document(idUser).get();
    }

}

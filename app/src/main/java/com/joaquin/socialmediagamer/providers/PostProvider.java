package com.joaquin.socialmediagamer.providers;

import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.joaquin.socialmediagamer.models.Post;

public class PostProvider {

    private CollectionReference mColletion;

    public PostProvider() {
        mColletion = FirebaseFirestore.getInstance().collection("Posts");
    }

    public Task<Void> save(Post post) {
        return mColletion.document().set(post);
    }

    public Query getAll() {
        return mColletion.orderBy("timestamp", Query.Direction.DESCENDING);
    }

    public Query getPostByCategoryAndTimestamp(String category) {
        return mColletion.whereEqualTo("category", category).orderBy("timestamp", Query.Direction.DESCENDING);
    }

    public Query getPostByTitle(String title) {
        return mColletion.orderBy("title").startAt(title).endAt(title + '\uf8ff');

    }

    public Query getPostByUser(String id) {
        return mColletion.whereEqualTo("idUser", id);
    }

    public Task<DocumentSnapshot> getPostById(String id) {
        return mColletion.document(id).get();
    }

    public Task<Void> delete(String id) {
        return mColletion.document(id).delete();
    }

}

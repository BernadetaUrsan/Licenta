package com.example.licenta.Activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Canvas;
import android.icu.text.RelativeDateTimeFormatter;
import android.os.Bundle;
import android.view.View;

import com.example.licenta.Adapters.YearPostsAdapter;
import com.example.licenta.Helpers.FirebaseHelper;
import com.example.licenta.Helpers.UserHelper;
import com.example.licenta.Models.PostModel;
import com.example.licenta.Models.StudentModel;
import com.example.licenta.R;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.internal.DescendantOffsetUtils;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.gson.Gson;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import it.xabaras.android.recyclerview.swipedecorator.RecyclerViewSwipeDecorator;

public class YearGroupActivity extends BaseActivity {

    private YearPostsAdapter yearPostsAdapter;
    private List<PostModel> postsList;
    private RecyclerView recyclerView;
    private PostModel deletedPost;
    private PostModel editedPost;
    private StudentModel student;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_year_group);
        super.setToolbarTitle("Postări studenți");
        initializeViews();
        getData();

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleCallback);
        itemTouchHelper.attachToRecyclerView(recyclerView);

    }

    ItemTouchHelper.SimpleCallback simpleCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
            return false;
        }

        @Override
        public int getSwipeDirs(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
            int position = viewHolder.getAdapterPosition();
            editedPost = postsList.get(position);
            student =  UserHelper.Instance().getStudent();
            String userId = student.getUserId();
            if(editedPost.getAuthorId().equals(userId)){
                return ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT;
            }
            return 0;
        }

        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
            final int position = viewHolder.getAdapterPosition();

            switch(direction){
                case ItemTouchHelper.LEFT:

                    MaterialAlertDialogBuilder dialog = new MaterialAlertDialogBuilder(YearGroupActivity.this);
                            dialog.setTitle("Doriți să ștergeti postarea?");
                            dialog.setBackground(getResources().getDrawable(R.drawable.alert_dialog_bg,null));
                            dialog.setPositiveButton("Da", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    deletedPost = postsList.get(position);
                                    postsList.remove(position);
                                    yearPostsAdapter.notifyItemRemoved(position);
                                    FirebaseHelper.getInstance().yearGroupPostsDatabase.child(deletedPost.getId()).removeValue();
                                }
                            });
                            dialog.setNegativeButton("Nu", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    getData();
                                }
                            });

                    dialog.show();
                    break;
                case ItemTouchHelper.RIGHT:
                    editedPost = postsList.get(position);
                    Gson gson = new Gson();
                    String postString = gson.toJson(editedPost);
                    Intent intent = new Intent(YearGroupActivity.this,AddPostActivity.class);
                    intent.putExtra("post", postString);
                    startActivity(intent);
                    getData();
                    break;
    }
}

        @Override
        public void onChildDraw(@NonNull Canvas c, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {

            new RecyclerViewSwipeDecorator.Builder(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)
                    .addSwipeLeftBackgroundColor(ContextCompat.getColor(YearGroupActivity.this, R.color.colorDelete))
                    .addSwipeLeftActionIcon(R.drawable.ic_delete_white_24dp)
                    .addSwipeRightBackgroundColor(ContextCompat.getColor(YearGroupActivity.this, R.color.colorEdit))
                    .addSwipeRightActionIcon(R.drawable.ic_edit_white_24dp)
                    .create()
                    .decorate();

            super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
        }
    };

    public void OnAddPost(View view) {
        Intent myInt2= new Intent(YearGroupActivity.this,AddPostActivity.class);
        startActivity(myInt2);
    }

    private void getData(){
        FirebaseHelper.getInstance().yearGroupPostsDatabase.orderByChild("date/time").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        postsList = new ArrayList<>();
                        for (DataSnapshot data: dataSnapshot.getChildren()) {
                            PostModel post = data.getValue(PostModel.class);
                            postsList.add(post);
                }
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
                linearLayoutManager.setReverseLayout(true);
                linearLayoutManager.setStackFromEnd(true);
                recyclerView.setLayoutManager(linearLayoutManager);
                yearPostsAdapter = new YearPostsAdapter(postsList, getApplicationContext());
                recyclerView.setAdapter(yearPostsAdapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }

        });

    }

    private void initializeViews(){
        recyclerView = findViewById(R.id.rv_listed_yeargroup);
    }
}

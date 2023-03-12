package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class FoodUpload extends AppCompatActivity {



    TextInputEditText foodName, foodPrice, foodType;
    Button foodEnter;
    ImageView uploadImage;
    Uri imageUri;
    StorageReference reference = FirebaseStorage.getInstance().getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_upload);

        foodName = findViewById(R.id.foodName);
        foodPrice = findViewById(R.id.foodPrice);
        foodType = findViewById(R.id.foodType);
        foodEnter = findViewById(R.id.foodEnter);
        uploadImage = findViewById(R.id.uploadImage);


        uploadImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent galleryIntent = new Intent();
                galleryIntent.setAction(Intent.ACTION_GET_CONTENT);
                galleryIntent.setType("image/*");
                startActivityForResult(galleryIntent,2);

            }
        });


        foodEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = foodName.getText().toString();
                String date = foodPrice.getText().toString();
                int price = Integer.parseInt(date);
                String type = foodType.getText().toString();



                //Uploading to realtime firebase
                if(imageUri!=null){

                    StorageReference fileRef = reference.child(System.currentTimeMillis()+"."+getFileExtension(imageUri));
                    fileRef.putFile(imageUri).addOnCompleteListener(new OnCompleteListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<UploadTask.TaskSnapshot> task) {
                            fileRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                                @Override
                                public void onSuccess(Uri uri) {
                                    FoodInfo info = new FoodInfo(name, price, type, imageUri.toString());


                                    DatabaseReference infoRef = FirebaseDatabase.getInstance().getReference("Food Info");
                                    String parentKey = name;
                                    infoRef.child(parentKey).setValue(info).addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            if(task.isSuccessful()){
                                                Toast.makeText(FoodUpload.this, "Successfully Uploaded in database", Toast.LENGTH_SHORT).show();
//                                                finish();
                                            }
                                        }
                                    }).addOnFailureListener(new OnFailureListener() {
                                        @Override
                                        public void onFailure(@NonNull Exception e) {
                                            Toast.makeText(FoodUpload.this, e.getMessage().toString(), Toast.LENGTH_SHORT).show();
                                        }
                                    });
                                }
                            });
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(FoodUpload.this, "Uploading Failed", Toast.LENGTH_SHORT).show();
                        }
                    });
                }else{
                    Toast.makeText(FoodUpload.this, "Please upload an image", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

    private void uploadToFirebase(Uri uri) {

    }

    private String getFileExtension(Uri mUri) {
        ContentResolver cr = getContentResolver();
        MimeTypeMap mime = MimeTypeMap.getSingleton();
        return mime.getExtensionFromMimeType(cr.getType(mUri));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 2 && resultCode == RESULT_OK && data != null){
            imageUri = data.getData();
            uploadImage.setImageURI(imageUri);
        }
    }
}







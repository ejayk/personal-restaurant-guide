package ca.gbc.comp3074.personalrestaurantguide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class AddRestaurantActivity extends AppCompatActivity {

    private TextView nameLabel;
    private EditText nameInput;
    private TextView addressLabel;
    private EditText addressInput;
    private TextView phoneLabel;
    private EditText phoneInput;
    private TextView descriptionLabel;
    private EditText descriptionInput;
    private TextView ratingLabel;
    private RatingBar ratingBar;
    private CheckBox indianTag;
    private CheckBox chineseTag;
    private CheckBox japaneseTag;
    private CheckBox greekTag;
    private CheckBox italianTag;
    private CheckBox canadianTag;
    private Button addButton;
    DatabaseHelper ourdb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_restaurant);

        nameLabel = (TextView) findViewById(R.id.nameLabel);
        nameInput = (EditText) findViewById(R.id.nameInput);
        addressLabel = (TextView) findViewById(R.id.addressLabel);
        addressInput = (EditText) findViewById(R.id.addressInput);
        phoneLabel = (TextView) findViewById(R.id.phoneLabel);
        phoneInput = (EditText) findViewById(R.id.phoneInput);
        descriptionLabel = (TextView) findViewById(R.id.descriptionLabel);
        descriptionInput = (EditText) findViewById(R.id.descriptionInput);
        ratingLabel = (TextView) findViewById(R.id.ratingLabel);
        ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        indianTag = (CheckBox) findViewById(R.id.indianTag);
        chineseTag = (CheckBox) findViewById(R.id.chineseTag);
        japaneseTag = (CheckBox) findViewById(R.id.japaneseTag);
        greekTag = (CheckBox) findViewById(R.id.greekTag);
        italianTag = (CheckBox) findViewById(R.id.italianTag);
        canadianTag = (CheckBox) findViewById(R.id.canadianTag);
        addButton = (Button) findViewById(R.id.addButton);
        ourdb = new DatabaseHelper(this);
        insertdata();


        //back arrow button
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    public void insertdata() {
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int numStars = ratingBar.getNumStars();
                String rating = Integer.toString(numStars);
                String tags = "";
                if (indianTag.isChecked()) {
                    tags = tags + "," + indianTag.getText();
                }
                if (chineseTag.isChecked()) {
                    tags = tags + "," + chineseTag.getText();
                }
                if (japaneseTag.isChecked()) {
                    tags = tags + "," + japaneseTag.getText();
                }
                if (greekTag.isChecked()) {
                    tags = tags + "," + greekTag.getText();
                }
                if (italianTag.isChecked()) {
                    tags = tags + "," + italianTag.getText();
                }
                if (canadianTag.isChecked()) {
                    tags = tags + "," + canadianTag.getText();
                }

                Boolean inserted = ourdb.insertData(nameInput.getText().toString(), addressInput.getText().toString(),
                        phoneInput.getText().toString(), descriptionInput.getText().toString(), rating, tags);
                if (inserted) {
                    Toast.makeText(AddRestaurantActivity.this, "Entry added", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(AddRestaurantActivity.this, "Error adding entry", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }




        /*addButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String name=nameInput.getText().toString();
                String address=addressInput.getText().toString();
                String phone=phoneInput.getText().toString();
                String description=descriptionInput.getText().toString();
                //getting the number of stars and storing it as an integer
                int numStars=ratingBar.getNumStars();
                //converting the numStars from integer to string
                String rating=Integer.toString(numStars);
                //getting the tags that are selected and storing them
                String tags="";
                //checking which tags are clicked and storing them in tags variable
                if(indianTag.isChecked()){
                    tags=tags+","+indianTag.getText();
                }
                if(chineseTag.isChecked()){
                    tags=tags+","+chineseTag.getText();
                }
                if(japaneseTag.isChecked()){
                    tags=tags+","+japaneseTag.getText();
                }
                if(greekTag.isChecked()){
                    tags=tags+","+greekTag.getText();
                }
                if(italianTag.isChecked()){
                    tags=tags+","+italianTag.getText();
                }
                if(canadianTag.isChecked()){
                    tags=tags+","+canadianTag.getText();
                }
            }*/

        /*
        )*/

        /*
        addButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                File restaurantData=null;
                String name=nameInput.getText().toString();
                String address=addressInput.getText().toString();
                String phone=phoneInput.getText().toString();
                String description=descriptionInput.getText().toString();
                //getting the number of stars and storing it as an integer
                int numStars=ratingBar.getNumStars();
                //converting the numStars from integer to string
                String rating=Integer.toString(numStars);
                //getting the tags that are selected and storing them
                String tags="";
                //checking which tags are clicked and storing them in tags variable
                if(indianTag.isChecked()){
                    tags=tags+","+indianTag.getText();
                }
                if(chineseTag.isChecked()){
                    tags=tags+","+chineseTag.getText();
                }
                if(japaneseTag.isChecked()){
                    tags=tags+","+japaneseTag.getText();
                }
                if(greekTag.isChecked()){
                    tags=tags+","+greekTag.getText();
                }
                if(italianTag.isChecked()){
                    tags=tags+","+italianTag.getText();
                }
                if(canadianTag.isChecked()){
                    tags=tags+","+canadianTag.getText();
                }

                FileOutputStream fileOutputStream=null;
                try{
                    name=name+",";
                    address=address+",";
                    phone=phone+",";
                    description=description+",";
                    rating=rating+",";
                    tags=tags+",";
                    restaurantData=getFilesDir();
                    fileOutputStream=openFileOutput("Restaurant-Data.txt", Context.MODE_APPEND);
                    fileOutputStream.write(name.getBytes());
                    fileOutputStream.write(address.getBytes());
                    fileOutputStream.write(phone.getBytes());
                    fileOutputStream.write(description.getBytes());
                    fileOutputStream.write(rating.getBytes());
                    fileOutputStream.write(tags.getBytes());
                    //10 signifies new line
                    fileOutputStream.write(10);
                    return;

                }catch(Exception ex){
                    ex.printStackTrace();
                }finally{
                    try{
                        fileOutputStream.flush();
                        fileOutputStream.close();
                    }catch(IOException e){
                        e.printStackTrace();
                    }
                }
            }
        });
         */






    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.addRestaurant:
                Intent intent = new Intent(this, AddRestaurantActivity.class);
                this.startActivity(intent);
                break;
        }
        switch (item.getItemId()) {
            case R.id.about:
                Intent intent = new Intent(this, AboutActivity.class);
                this.startActivity(intent);
                break;
        }
        switch (item.getItemId()) {
            case R.id.restaurants:
                Intent intent = new Intent(this, RestaurantsActivity.class);
                this.startActivity(intent);
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }


}
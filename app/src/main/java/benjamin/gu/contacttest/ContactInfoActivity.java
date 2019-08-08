package benjamin.gu.contacttest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ContactInfoActivity extends AppCompatActivity {

    TextView ID;
    TextView name;
    TextView email;
    TextView address;
    TextView gender;
    TextView phoneNumbers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_info);
        TextView ID = findViewById(R.id.contactID);
        TextView name = findViewById(R.id.cv_name);
        TextView email = findViewById(R.id.cv_email);
        TextView address = findViewById(R.id.cv_address);
        TextView gender = findViewById(R.id.cv_gender);
        TextView phoneNumbers = findViewById(R.id.cv_phone_numbers);

        ID.setText("ID: " + getIntent().getStringExtra("id"));
        name.setText("Name: " + getIntent().getStringExtra("name"));
        email.setText("Email: " + getIntent().getStringExtra("email"));
        address.setText("Address" + getIntent().getStringExtra("address"));
        gender.setText("Gender: " + getIntent().getStringExtra("gender"));
        phoneNumbers.setText("Phone:\n" + "Home: " + getIntent().getStringExtra("home phone") +
                "\n" + "Mobile: " + getIntent().getStringExtra("mobile phone") + "\n" + "Office; "
        + getIntent().getStringExtra("office phone"));
    }
}

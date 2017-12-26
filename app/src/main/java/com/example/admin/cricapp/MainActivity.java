package com.example.admin.cricapp;

import android.content.Intent;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.example.admin.cricapp.database.matches;
import com.example.admin.cricapp.database.player;
import com.example.admin.cricapp.database.team;

import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private DatabaseHandler mydb;
    private ArrayList<String> data;
    private Spinner MySpinner1;
    private Spinner MySpinner2;
    private Spinner MySpinner3;
    private ArrayList<String> add_team;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        add_team = new ArrayList<String>();

        mydb = new DatabaseHandler(this);
        insertdata();
        data = new ArrayList<>();
        ArrayList<team> teams = mydb.Read_all_team();
        for(int i =0;i<teams.size();i++)
            data.add(teams.get(i).getTeam_name());


        MySpinner1 = (Spinner)findViewById(R.id.spinner);
        ArrayAdapter<String> myAdapter1 = new
                ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,data );
        myAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        MySpinner1.setAdapter(myAdapter1);


        MySpinner2 = (Spinner) findViewById(R.id.spinner2);
        ArrayAdapter<String> myAdapter2 = new
                ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, data);
        myAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        MySpinner2.setAdapter(myAdapter2);


        Button done = (Button)findViewById(R.id.button);
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<matches> x = mydb.Read_all_matches();
                Integer match_no = null;
                String team1 = MySpinner1.getSelectedItem().toString();
                String team2 = MySpinner2.getSelectedItem().toString();
                String team = team1 + " vs " + team2;
                if(x.size()==0){
                    match_no = 1;
                    mydb.Insert_matches(new matches("1","1","none",team,new Date().toString(),10),1);
                }else{
                    match_no = x.size()+1;
                    mydb.Insert_matches(new matches("1",match_no.toString(),"none",team,new Date().toString(),10),match_no);

                }
                Log.e("Hi1","team is "+ team);
                Intent i = new Intent(MainActivity.this,innings_select.class);
                i.putExtra("team1",team1);
                i.putExtra("team2",team2);
                i.putExtra("match",match_no.toString());
                i.putExtra("tournament",team2);

                startActivity(i);

            }
        });




    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent i = new Intent(this,final_tabs.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.new_match) {
            Intent i = new Intent(this,match_select.class);
            startActivity(i);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */

    private void insertdata(){
        mydb.Insert_team(new team("NKPL_2018","Nikhil Kapasi,Ramesh Chheda,Bunty Rohira","1","TAKSHASHILA TITANS","GREY","RAHUL MAJITHIA","TAPAN SANGHAVI","VISHAL D PANDYA","NILESH VIRA","NEERAJ KABRA","RAJA BHANUSHALI","TUSHAR MANGE","ANIL SHETH","PARTH DAMA","VINOD T. JAIN","DIVEN JAIN","DHIREN JHONSA"));
        mydb.Insert_team(new team("NKPL_2018","Ashwin Mehta,Mitul Vora,Parag Shah","2","KALINGA STALLIONS","RED","SANKET VASANI","SAYAM JAIN","BHAVESH JAIN","SAMIR KOTHARI","KARAN BHANUSHALI","KAVISH JAIN","AMIT SANGHVI","KAMAL VYAS","VIKAS DHAKAD","RAKESH JAIN","AASHIK P. MEHTA","VINOD H. JAIN"));
        mydb.Insert_team(new team("NKPL_2018","Arjun Katarmal,Ketan Negandhi,Pravin Mange","3","AVADH STRIKERS","BLACK","SHALEEN GUPTA ","VISHAL .V. PANDYA","BHUMIK KOTHARI","RAJESH KOTHARI","ANKIT BHANUSHALI","DHAVAL PANDYA","SHRIPAL SEMLANI","PARIMAL MODI","BHARAT THAKKAR","KAPIL THAKKAR","HITESH JAIN","VIVEK LAKHANI"));
        mydb.Insert_team(new team("NKPL_2018","Dhiren Jhonsa","4","AVANTI ROYALS","PARROT GREEN","RAKESH JAIN","PARTH SANGHVI","DARSHAN KOTHARI","PRINCE GURJAR","AMISH SHAH","JIGAR BHANUSHALI","JIMIT SHAH","JAYESH ANJARIA","ASHISH DHAKAD ","VIKESH JAIN ","RAJ JAIN","ANKUR K. SHAH"));
        mydb.Insert_team(new team("NKPL_2018","Kirit Sanghvi,Ramesh Jain,Jagdish Patolia","5","NALANDA SUPER KINGS","SKY BLUE","DARSHAN MAJITHIA","MIHIR GANDHI","ANIL BHANUSHALI","NIRAV SHAH","SHYAM DAVE","RUSHABH KATARMAL","PRABHU PATEL","NARENDRA J. BHADRA","DHAIRYA KAMDAR","SHAILESH K JAIN","VIKRAM H. PATNI","SANJAY K. JAIN"));
        mydb.Insert_team(new team("NKPL_2018","Uttam Jain,Ashok Kothari,Jayesh Anjaria","6","MITHILA MAHARATHIS","ORANGE","BHARAT G. CHOUDHARY","SMIT ANAM","PRAVIN MANGE","PANKAJ JAIN","ASHWIN PATEL","BHARAT FAGANIYA","KARAN BHADRA","MUKESH CHHADVA","KAMLESH KHANDELWAL","VIKRAM DANGI","PANKAJ KOTHARI","SUKHLAL MEHTA"));
        mydb.Insert_team(new team("NKPL_2018","Sanjay Muchhala,Vinod H. Jain,Shaleen Gupta","7","NK VIKINGS","LEMON YELLOW","RUCHAK VIRA","NIKET SHAH","HARSH SHETH ","SURAJ BHANUSHALI ","AAKASH BHANUSHALI","VICKY MEHTA","CHINTAN PAREKH","HEMANT H MEHTA ","ROHIN N. SANGHVI","VICKY S. JAIN","RUSHABH BHALANI","NIMESH GONDALIA"));
        mydb.Insert_team(new team("NKPL_2018","Vinod T. Jain,Sonu Jain,Kamlesh Jain","8","MAGADH MANIACS","ROYAL BLUE","HARSHIK M. MEHTA","KUNJAN NANDALA","PARTH KAMDAR","SAUMIYA SANGHVI","CHINTAN VORA","JINESH JHONSA","HRITHIK JAIN","HARESH BHANUSHALI","RAJESH K. BHANUSHALI","PRANJAL JAIN","BHAVESH PATNI","RITESH JAIN"));
        mydb.Insert_player(new player("RAHUL MAJITHIA","TAKSHASHILA TITANS","none","none",0,0,0.0,0,0,0,0,0,0.0,0,0.0,0,0,0,0));
        mydb.Insert_player(new player("TAPAN SANGHAVI","TAKSHASHILA TITANS","none","none",0,0,0.0,0,0,0,0,0,0.0,0,0.0,0,0,0,0));
        mydb.Insert_player(new player("VISHAL D PANDYA","TAKSHASHILA TITANS","none","none",0,0,0.0,0,0,0,0,0,0.0,0,0.0,0,0,0,0));
        mydb.Insert_player(new player("NILESH VIRA","TAKSHASHILA TITANS","none","none",0,0,0.0,0,0,0,0,0,0.0,0,0.0,0,0,0,0));
        mydb.Insert_player(new player("NEERAJ KABRA","TAKSHASHILA TITANS","none","none",0,0,0.0,0,0,0,0,0,0.0,0,0.0,0,0,0,0));
        mydb.Insert_player(new player("RAJA BHANUSHALI","TAKSHASHILA TITANS","none","none",0,0,0.0,0,0,0,0,0,0.0,0,0.0,0,0,0,0));
        mydb.Insert_player(new player("TUSHAR MANGE","TAKSHASHILA TITANS","none","none",0,0,0.0,0,0,0,0,0,0.0,0,0.0,0,0,0,0));
        mydb.Insert_player(new player("ANIL SHETH","TAKSHASHILA TITANS","none","none",0,0,0.0,0,0,0,0,0,0.0,0,0.0,0,0,0,0));
        mydb.Insert_player(new player("PARTH DAMA","TAKSHASHILA TITANS","none","none",0,0,0.0,0,0,0,0,0,0.0,0,0.0,0,0,0,0));
        mydb.Insert_player(new player("VINOD T. JAIN","TAKSHASHILA TITANS","none","none",0,0,0.0,0,0,0,0,0,0.0,0,0.0,0,0,0,0));
        mydb.Insert_player(new player("DIVEN JAIN","TAKSHASHILA TITANS","none","none",0,0,0.0,0,0,0,0,0,0.0,0,0.0,0,0,0,0));
        mydb.Insert_player(new player("DHIREN JHONSA","TAKSHASHILA TITANS","none","none",0,0,0.0,0,0,0,0,0,0.0,0,0.0,0,0,0,0));
        mydb.Insert_player(new player("SANKET VASANI","KALINGA STALLIONS","none","none",0,0,0.0,0,0,0,0,0,0.0,0,0.0,0,0,0,0));
        mydb.Insert_player(new player("SAYAM JAIN","KALINGA STALLIONS","none","none",0,0,0.0,0,0,0,0,0,0.0,0,0.0,0,0,0,0));
        mydb.Insert_player(new player("BHAVESH JAIN","KALINGA STALLIONS","none","none",0,0,0.0,0,0,0,0,0,0.0,0,0.0,0,0,0,0));
        mydb.Insert_player(new player("SAMIR KOTHARI","KALINGA STALLIONS","none","none",0,0,0.0,0,0,0,0,0,0.0,0,0.0,0,0,0,0));
        mydb.Insert_player(new player("KARAN BHANUSHALI","KALINGA STALLIONS","none","none",0,0,0.0,0,0,0,0,0,0.0,0,0.0,0,0,0,0));
        mydb.Insert_player(new player("KAVISH JAIN","KALINGA STALLIONS","none","none",0,0,0.0,0,0,0,0,0,0.0,0,0.0,0,0,0,0));
        mydb.Insert_player(new player("AMIT SANGHVI","KALINGA STALLIONS","none","none",0,0,0.0,0,0,0,0,0,0.0,0,0.0,0,0,0,0));
        mydb.Insert_player(new player("KAMAL VYAS","KALINGA STALLIONS","none","none",0,0,0.0,0,0,0,0,0,0.0,0,0.0,0,0,0,0));
        mydb.Insert_player(new player("VIKAS DHAKAD","KALINGA STALLIONS","none","none",0,0,0.0,0,0,0,0,0,0.0,0,0.0,0,0,0,0));
        mydb.Insert_player(new player("RAKESH JAIN","KALINGA STALLIONS","none","none",0,0,0.0,0,0,0,0,0,0.0,0,0.0,0,0,0,0));
        mydb.Insert_player(new player("AASHIK P. MEHTA","KALINGA STALLIONS","none","none",0,0,0.0,0,0,0,0,0,0.0,0,0.0,0,0,0,0));
        mydb.Insert_player(new player("VINOD H. JAIN","KALINGA STALLIONS","none","none",0,0,0.0,0,0,0,0,0,0.0,0,0.0,0,0,0,0));
        mydb.Insert_player(new player("SHALEEN GUPTA ","AVADH STRIKERS","none","none",0,0,0.0,0,0,0,0,0,0.0,0,0.0,0,0,0,0));
        mydb.Insert_player(new player("VISHAL .V. PANDYA","AVADH STRIKERS","none","none",0,0,0.0,0,0,0,0,0,0.0,0,0.0,0,0,0,0));
        mydb.Insert_player(new player("BHUMIK KOTHARI","AVADH STRIKERS","none","none",0,0,0.0,0,0,0,0,0,0.0,0,0.0,0,0,0,0));
        mydb.Insert_player(new player("RAJESH KOTHARI","AVADH STRIKERS","none","none",0,0,0.0,0,0,0,0,0,0.0,0,0.0,0,0,0,0));
        mydb.Insert_player(new player("ANKIT BHANUSHALI","AVADH STRIKERS","none","none",0,0,0.0,0,0,0,0,0,0.0,0,0.0,0,0,0,0));
        mydb.Insert_player(new player("DHAVAL PANDYA","AVADH STRIKERS","none","none",0,0,0.0,0,0,0,0,0,0.0,0,0.0,0,0,0,0));
        mydb.Insert_player(new player("SHRIPAL SEMLANI","AVADH STRIKERS","none","none",0,0,0.0,0,0,0,0,0,0.0,0,0.0,0,0,0,0));
        mydb.Insert_player(new player("PARIMAL MODI","AVADH STRIKERS","none","none",0,0,0.0,0,0,0,0,0,0.0,0,0.0,0,0,0,0));
        mydb.Insert_player(new player("BHARAT THAKKAR","AVADH STRIKERS","none","none",0,0,0.0,0,0,0,0,0,0.0,0,0.0,0,0,0,0));
        mydb.Insert_player(new player("KAPIL THAKKAR","AVADH STRIKERS","none","none",0,0,0.0,0,0,0,0,0,0.0,0,0.0,0,0,0,0));
        mydb.Insert_player(new player("HITESH JAIN","AVADH STRIKERS","none","none",0,0,0.0,0,0,0,0,0,0.0,0,0.0,0,0,0,0));
        mydb.Insert_player(new player("VIVEK LAKHANI","AVADH STRIKERS","none","none",0,0,0.0,0,0,0,0,0,0.0,0,0.0,0,0,0,0));
        mydb.Insert_player(new player("RAKESH JAIN","AVANTI ROYALS","none","none",0,0,0.0,0,0,0,0,0,0.0,0,0.0,0,0,0,0));
        mydb.Insert_player(new player("PARTH SANGHVI","AVANTI ROYALS","none","none",0,0,0.0,0,0,0,0,0,0.0,0,0.0,0,0,0,0));
        mydb.Insert_player(new player("DARSHAN KOTHARI","AVANTI ROYALS","none","none",0,0,0.0,0,0,0,0,0,0.0,0,0.0,0,0,0,0));
        mydb.Insert_player(new player("PRINCE GURJAR","AVANTI ROYALS","none","none",0,0,0.0,0,0,0,0,0,0.0,0,0.0,0,0,0,0));
        mydb.Insert_player(new player("AMISH SHAH","AVANTI ROYALS","none","none",0,0,0.0,0,0,0,0,0,0.0,0,0.0,0,0,0,0));
        mydb.Insert_player(new player("JIGAR BHANUSHALI","AVANTI ROYALS","none","none",0,0,0.0,0,0,0,0,0,0.0,0,0.0,0,0,0,0));
        mydb.Insert_player(new player("JIMIT SHAH","AVANTI ROYALS","none","none",0,0,0.0,0,0,0,0,0,0.0,0,0.0,0,0,0,0));
        mydb.Insert_player(new player("JAYESH ANJARIA","AVANTI ROYALS","none","none",0,0,0.0,0,0,0,0,0,0.0,0,0.0,0,0,0,0));
        mydb.Insert_player(new player("ASHISH DHAKAD ","AVANTI ROYALS","none","none",0,0,0.0,0,0,0,0,0,0.0,0,0.0,0,0,0,0));
        mydb.Insert_player(new player("VIKESH JAIN ","AVANTI ROYALS","none","none",0,0,0.0,0,0,0,0,0,0.0,0,0.0,0,0,0,0));
        mydb.Insert_player(new player("RAJ JAIN","AVANTI ROYALS","none","none",0,0,0.0,0,0,0,0,0,0.0,0,0.0,0,0,0,0));
        mydb.Insert_player(new player("ANKUR K. SHAH","AVANTI ROYALS","none","none",0,0,0.0,0,0,0,0,0,0.0,0,0.0,0,0,0,0));
        mydb.Insert_player(new player("DARSHAN MAJITHIA","NALANDA SUPER KINGS","none","none",0,0,0.0,0,0,0,0,0,0.0,0,0.0,0,0,0,0));
        mydb.Insert_player(new player("MIHIR GANDHI","NALANDA SUPER KINGS","none","none",0,0,0.0,0,0,0,0,0,0.0,0,0.0,0,0,0,0));
        mydb.Insert_player(new player("ANIL BHANUSHALI","NALANDA SUPER KINGS","none","none",0,0,0.0,0,0,0,0,0,0.0,0,0.0,0,0,0,0));
        mydb.Insert_player(new player("NIRAV SHAH","NALANDA SUPER KINGS","none","none",0,0,0.0,0,0,0,0,0,0.0,0,0.0,0,0,0,0));
        mydb.Insert_player(new player("SHYAM DAVE","NALANDA SUPER KINGS","none","none",0,0,0.0,0,0,0,0,0,0.0,0,0.0,0,0,0,0));
        mydb.Insert_player(new player("RUSHABH KATARMAL","NALANDA SUPER KINGS","none","none",0,0,0.0,0,0,0,0,0,0.0,0,0.0,0,0,0,0));
        mydb.Insert_player(new player("PRABHU PATEL","NALANDA SUPER KINGS","none","none",0,0,0.0,0,0,0,0,0,0.0,0,0.0,0,0,0,0));
        mydb.Insert_player(new player("NARENDRA J. BHADRA","NALANDA SUPER KINGS","none","none",0,0,0.0,0,0,0,0,0,0.0,0,0.0,0,0,0,0));
        mydb.Insert_player(new player("DHAIRYA KAMDAR","NALANDA SUPER KINGS","none","none",0,0,0.0,0,0,0,0,0,0.0,0,0.0,0,0,0,0));
        mydb.Insert_player(new player("SHAILESH K JAIN","NALANDA SUPER KINGS","none","none",0,0,0.0,0,0,0,0,0,0.0,0,0.0,0,0,0,0));
        mydb.Insert_player(new player("VIKRAM H. PATNI","NALANDA SUPER KINGS","none","none",0,0,0.0,0,0,0,0,0,0.0,0,0.0,0,0,0,0));
        mydb.Insert_player(new player("SANJAY K. JAIN","NALANDA SUPER KINGS","none","none",0,0,0.0,0,0,0,0,0,0.0,0,0.0,0,0,0,0));
        mydb.Insert_player(new player("BHARAT G. CHOUDHARY","MITHILA MAHARATHIS","none","none",0,0,0.0,0,0,0,0,0,0.0,0,0.0,0,0,0,0));
        mydb.Insert_player(new player("SMIT ANAM","MITHILA MAHARATHIS","none","none",0,0,0.0,0,0,0,0,0,0.0,0,0.0,0,0,0,0));
        mydb.Insert_player(new player("PRAVIN MANGE","MITHILA MAHARATHIS","none","none",0,0,0.0,0,0,0,0,0,0.0,0,0.0,0,0,0,0));
        mydb.Insert_player(new player("PANKAJ JAIN","MITHILA MAHARATHIS","none","none",0,0,0.0,0,0,0,0,0,0.0,0,0.0,0,0,0,0));
        mydb.Insert_player(new player("ASHWIN PATEL","MITHILA MAHARATHIS","none","none",0,0,0.0,0,0,0,0,0,0.0,0,0.0,0,0,0,0));
        mydb.Insert_player(new player("BHARAT FAGANIYA","MITHILA MAHARATHIS","none","none",0,0,0.0,0,0,0,0,0,0.0,0,0.0,0,0,0,0));
        mydb.Insert_player(new player("KARAN BHADRA","MITHILA MAHARATHIS","none","none",0,0,0.0,0,0,0,0,0,0.0,0,0.0,0,0,0,0));
        mydb.Insert_player(new player("MUKESH CHHADVA","MITHILA MAHARATHIS","none","none",0,0,0.0,0,0,0,0,0,0.0,0,0.0,0,0,0,0));
        mydb.Insert_player(new player("KAMLESH KHANDELWAL","MITHILA MAHARATHIS","none","none",0,0,0.0,0,0,0,0,0,0.0,0,0.0,0,0,0,0));
        mydb.Insert_player(new player("VIKRAM DANGI","MITHILA MAHARATHIS","none","none",0,0,0.0,0,0,0,0,0,0.0,0,0.0,0,0,0,0));
        mydb.Insert_player(new player("PANKAJ KOTHARI","MITHILA MAHARATHIS","none","none",0,0,0.0,0,0,0,0,0,0.0,0,0.0,0,0,0,0));
        mydb.Insert_player(new player("SUKHLAL MEHTA","MITHILA MAHARATHIS","none","none",0,0,0.0,0,0,0,0,0,0.0,0,0.0,0,0,0,0));
        mydb.Insert_player(new player("RUCHAK VIRA","NK VIKINGS","none","none",0,0,0.0,0,0,0,0,0,0.0,0,0.0,0,0,0,0));
        mydb.Insert_player(new player("NIKET SHAH","NK VIKINGS","none","none",0,0,0.0,0,0,0,0,0,0.0,0,0.0,0,0,0,0));
        mydb.Insert_player(new player("HARSH SHETH ","NK VIKINGS","none","none",0,0,0.0,0,0,0,0,0,0.0,0,0.0,0,0,0,0));
        mydb.Insert_player(new player("SURAJ BHANUSHALI ","NK VIKINGS","none","none",0,0,0.0,0,0,0,0,0,0.0,0,0.0,0,0,0,0));
        mydb.Insert_player(new player("AAKASH BHANUSHALI","NK VIKINGS","none","none",0,0,0.0,0,0,0,0,0,0.0,0,0.0,0,0,0,0));
        mydb.Insert_player(new player("VICKY MEHTA","NK VIKINGS","none","none",0,0,0.0,0,0,0,0,0,0.0,0,0.0,0,0,0,0));
        mydb.Insert_player(new player("CHINTAN PAREKH","NK VIKINGS","none","none",0,0,0.0,0,0,0,0,0,0.0,0,0.0,0,0,0,0));
        mydb.Insert_player(new player("HEMANT H MEHTA ","NK VIKINGS","none","none",0,0,0.0,0,0,0,0,0,0.0,0,0.0,0,0,0,0));
        mydb.Insert_player(new player("ROHIN N. SANGHVI","NK VIKINGS","none","none",0,0,0.0,0,0,0,0,0,0.0,0,0.0,0,0,0,0));
        mydb.Insert_player(new player("VICKY S. JAIN","NK VIKINGS","none","none",0,0,0.0,0,0,0,0,0,0.0,0,0.0,0,0,0,0));
        mydb.Insert_player(new player("RUSHABH BHALANI","NK VIKINGS","none","none",0,0,0.0,0,0,0,0,0,0.0,0,0.0,0,0,0,0));
        mydb.Insert_player(new player("NIMESH GONDALIA","NK VIKINGS","none","none",0,0,0.0,0,0,0,0,0,0.0,0,0.0,0,0,0,0));
        mydb.Insert_player(new player("HARSHIK M. MEHTA","MAGADH MANIACS","none","none",0,0,0.0,0,0,0,0,0,0.0,0,0.0,0,0,0,0));
        mydb.Insert_player(new player("KUNJAN NANDALA","MAGADH MANIACS","none","none",0,0,0.0,0,0,0,0,0,0.0,0,0.0,0,0,0,0));
        mydb.Insert_player(new player("PARTH KAMDAR","MAGADH MANIACS","none","none",0,0,0.0,0,0,0,0,0,0.0,0,0.0,0,0,0,0));
        mydb.Insert_player(new player("SAUMIYA SANGHVI","MAGADH MANIACS","none","none",0,0,0.0,0,0,0,0,0,0.0,0,0.0,0,0,0,0));
        mydb.Insert_player(new player("CHINTAN VORA","MAGADH MANIACS","none","none",0,0,0.0,0,0,0,0,0,0.0,0,0.0,0,0,0,0));
        mydb.Insert_player(new player("JINESH JHONSA","MAGADH MANIACS","none","none",0,0,0.0,0,0,0,0,0,0.0,0,0.0,0,0,0,0));
        mydb.Insert_player(new player("HRITHIK JAIN","MAGADH MANIACS","none","none",0,0,0.0,0,0,0,0,0,0.0,0,0.0,0,0,0,0));
        mydb.Insert_player(new player("HARESH BHANUSHALI","MAGADH MANIACS","none","none",0,0,0.0,0,0,0,0,0,0.0,0,0.0,0,0,0,0));
        mydb.Insert_player(new player("RAJESH K. BHANUSHALI","MAGADH MANIACS","none","none",0,0,0.0,0,0,0,0,0,0.0,0,0.0,0,0,0,0));
        mydb.Insert_player(new player("PRANJAL JAIN","MAGADH MANIACS","none","none",0,0,0.0,0,0,0,0,0,0.0,0,0.0,0,0,0,0));
        mydb.Insert_player(new player("BHAVESH PATNI","MAGADH MANIACS","none","none",0,0,0.0,0,0,0,0,0,0.0,0,0.0,0,0,0,0));
        mydb.Insert_player(new player("RITESH JAIN","MAGADH MANIACS","none","none",0,0,0.0,0,0,0,0,0,0.0,0,0.0,0,0,0,0));
    }

}


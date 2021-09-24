package com.example.gram_portal;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.VerticalPositionMark;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class DeathRegister extends AppCompatActivity {
    SQLiteDatabase db;
    SQLiteOpenHelper openHelper;
    Button Send;
    EditText fname, lname, Date, time, Add, phone, hosp;
    Cursor cursor;
    final Calendar myCalendar = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_death_register);


        openHelper = new DataBHelper(this);
        Send = (Button) findViewById(R.id.Send);
        lname = (EditText) findViewById(R.id.lname);
        fname = (EditText) findViewById(R.id.fname);
        Date = (EditText) findViewById(R.id.Date);

        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }

        };

        Date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(DeathRegister.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
        time = (EditText) findViewById(R.id.Time);
        time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar mcurrentTime = Calendar.getInstance();
                int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                int minute = mcurrentTime.get(Calendar.MINUTE);
                TimePickerDialog mTimePicker;
                mTimePicker = new TimePickerDialog(DeathRegister.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        time.setText( selectedHour + ":" + selectedMinute);
                    }
                }, hour, minute, true);//Yes 24 hour time
                mTimePicker.setTitle("Select Time");
                mTimePicker.show();
            }
        });
        Add = (EditText) findViewById(R.id.Add);
        phone = (EditText) findViewById(R.id.phone);
        hosp = (EditText) findViewById(R.id.hosp);
        Send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db = openHelper.getWritableDatabase();
                String Lname = lname.getText().toString();
                String Fname = fname.getText().toString();
                String DATE = Date.getText().toString();
                String Time = time.getText().toString();
                String ADD = Add.getText().toString();
                String PHONE = phone.getText().toString();
                String Hosp = hosp.getText().toString();
                insertdata(Lname, Fname, DATE, Time, ADD, PHONE, Hosp);
                Toast.makeText(getApplicationContext(), "Request Sent Successfully", Toast.LENGTH_LONG).show();

            }
        });


    }

    public void insertdata(String lname, String fname, String Date, String time, String Add, String phone, String hosp) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DataBHelper.COL_2, lname);
        contentValues.put(DataBHelper.COL_3, fname);
        contentValues.put(DataBHelper.COL_4, Date);
        contentValues.put(DataBHelper.COL_5, time);
        contentValues.put(DataBHelper.COL_6, Add);
        contentValues.put(DataBHelper.COL_7, phone);
        contentValues.put(DataBHelper.COL_4, hosp);

        long id = db.insert(DataBHelper.TABLE_NAME, null, contentValues);


        Document mDoc = new Document(PageSize.A4.rotate());
        String fileName = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(System.currentTimeMillis());
        //String filepath = Environment.getExternalStorageDirectory()+"/"+fileName+".pdf";
        String filepath = Environment.getExternalStorageDirectory()
                .getAbsolutePath() + "/Gram_Portal/" + "Deatj_Certificate_" + fileName + ".pdf";
        //String filepath = Environment.getExternalStorageDirectory()+ File.separator+"Gram_Portal"+"/"+fileName+".pdf";
        try {
            PdfWriter pdfWriter = PdfWriter.getInstance(mDoc, new FileOutputStream(filepath));
            mDoc.open();
            //PDF creation


            PdfContentByte canvas = pdfWriter.getDirectContent();
            Rectangle rect = mDoc.getPageSize();
            rect.setBorder(Rectangle.BOX); // left, right, top, bottom border
            rect.setBorderWidth(20); // a width of 5 user units
            rect.setBorderColor(BaseColor.RED); // a red border
            rect.setUseVariableBorders(true); // the full width will be visible
            canvas.rectangle(rect);


            mDoc.add(new Paragraph(""));
            mDoc.add(Chunk.NEWLINE);
            mDoc.add(Chunk.NEWLINE);


            Font font = new Font();
            font.setStyle(Font.ITALIC);
            font.setSize(60);
            Paragraph p = new Paragraph();
            p.setFont(font);
            p.add("Certificate of Death");
            p.setAlignment(Element.ALIGN_CENTER);
            mDoc.add(p);
            mDoc.add(Chunk.NEWLINE);
            mDoc.add(Chunk.NEWLINE);
            mDoc.add(Chunk.NEWLINE);


            Font f21 = new Font();
            f21.setStyle(Font.BOLDITALIC);
            f21.setSize(40);
            String name1 = "This is acknowledge the death of";
            Paragraph p21 = new Paragraph();
            p21.setAlignment(Element.ALIGN_CENTER);
            p21.setFont(f21);
            p21.add(name1);
            mDoc.add(p21);
            mDoc.add(Chunk.NEWLINE);
            mDoc.add(Chunk.NEWLINE);
            mDoc.add(Chunk.NEWLINE);


            Font f2 = new Font();
            f2.setStyle(Font.BOLDITALIC);
            f2.setSize(40);
            String name = fname + " " + lname;
            Paragraph p2 = new Paragraph();
            p2.setAlignment(Element.ALIGN_CENTER);
            p2.setFont(f2);
            p2.add(name);
            mDoc.add(p2);
            mDoc.add(Chunk.NEWLINE);
            mDoc.add(Chunk.NEWLINE);
            mDoc.add(Chunk.NEWLINE);




            Font f3 = new Font();
            f3.setStyle(Font.NORMAL);
            f3.setSize(40);
            String hosipital = "At " + hosp;
            Paragraph p3 = new Paragraph();
            p3.setAlignment(Element.ALIGN_CENTER);
            p3.setFont(f3);
            p3.add(hosipital);
            mDoc.add(p3);
            mDoc.add(Chunk.NEWLINE);
            mDoc.add(Chunk.NEWLINE);
            mDoc.add(Chunk.NEWLINE);


            Font f4 = new Font();
            f4.setSize(40);
            String combo = "On the " + Date + " at " + time;
            Paragraph p4 = new Paragraph();
            p4.setAlignment(Element.ALIGN_CENTER);
            p4.setFont(f4);
            p4.add(combo);
            mDoc.add(p4);
            mDoc.add(Chunk.NEWLINE);
            mDoc.add(Chunk.NEWLINE);
            mDoc.add(Chunk.NEWLINE);
            mDoc.add(Chunk.NEWLINE);
            mDoc.add(Chunk.NEWLINE);
            mDoc.add(Chunk.NEWLINE);
            mDoc.add(Chunk.NEWLINE);
            mDoc.add(Chunk.NEWLINE);
            mDoc.add(Chunk.NEWLINE);
            mDoc.add(Chunk.NEWLINE);
            mDoc.add(Chunk.NEWLINE);


            Chunk glue = new Chunk(new VerticalPositionMark());
            Paragraph p5 = new Paragraph();
            p5.setPaddingTop(20);
            p5.setFont(f4);
            p5.add(Date);
            p5.add(glue);
            p5.add("Signature");
            mDoc.add(p5);

            mDoc.close();
            Toast.makeText(DeathRegister.this, fileName + ".pdf\n is saved to\n" + filepath, Toast.LENGTH_LONG).show();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    private void updateLabel() {
        String myFormat = "MM/dd/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        Date.setText(sdf.format(myCalendar.getTime()));
    }

}
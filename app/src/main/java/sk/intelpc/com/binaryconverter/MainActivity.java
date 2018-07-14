package sk.intelpc.com.binaryconverter;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;


public class MainActivity extends Activity {

    RadioButton Bin, Dec, Oct, Hex ;
    TextView input;
    AlertDialog.Builder alert;
    String  Tag = "Binary Converter";
    TextView DecText , HexText ,BinText, OctText, OctTag;
    Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnA, btnB, btnC, btnD, btnE, btnF;
    Button btnCls, btnClsAll;

    boolean IsLarge = false;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bin = (RadioButton) findViewById(R.id.BtnBin);
        Dec = (RadioButton) findViewById(R.id.BtnDec);
        Oct = (RadioButton) findViewById(R.id.BtnOct);
        Hex = (RadioButton) findViewById(R.id.BtnHex);

        input = (TextView) findViewById(R.id.InputText);

        DecText = (TextView) findViewById(R.id.DecText);
        HexText = (TextView) findViewById(R.id.HexText);
        BinText = (TextView) findViewById(R.id.OctText);
        OctText = (TextView) findViewById(R.id.BinText);
        OctTag = (TextView) findViewById(R.id.Oct);

        btn0 = (Button) findViewById(R.id.btn0);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn6 = (Button) findViewById(R.id.btn6);
        btn7 = (Button) findViewById(R.id.btn7);
        btn8 = (Button) findViewById(R.id.btn8);
        btn9 = (Button) findViewById(R.id.btn9);
        btnA = (Button) findViewById(R.id.btnA);
        btnB = (Button) findViewById(R.id.btnB);
        btnC = (Button) findViewById(R.id.btnC);
        btnD = (Button) findViewById(R.id.btnD);
        btnE = (Button) findViewById(R.id.btnE);
        btnF = (Button) findViewById(R.id.btnF);
        btnCls = (Button) findViewById(R.id.btnCls);
        btnClsAll = (Button) findViewById(R.id.btnClsAll);

        alert = new AlertDialog.Builder(this);



    }


    @Override
    protected void onStart()
    {
        super.onStart();

        if(isNoBtnIsChecked())
        {
            Dec.setChecked(true);
        }

        input.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s)
            {
                Log.d(Tag, "In afterTextChanged");

                String inputStr = input.getText().toString();


                if (Dec.isChecked())
                {
                    Log.d(Tag, "In Dec.isChecked()");


                    if (inputStr.length() == 0)
                    {
                        HexText.setText("");
                        BinText.setText("");
                        DecText.setText("");
                        OctText.setText("");
                        return;
                    }

                    if (!isProperDec())
                    {
                        Log.d(Tag, "In if(!isProperBin())");

                        alert.setTitle(" Format Error !!!!");
                        alert.setMessage("Wrong Decimal Sequence");
                        alert.setNeutralButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });

                        alert.show();
                        bck();

                    }
                    else
                    {

                        try
                        {
                            int i = Integer.parseInt(inputStr);
                            String hex = Integer.toHexString(i);

                            DecText.setText(input.getText());
                            HexText.setText(hex);
                            BinText.setText(Integer.toBinaryString(i));
                            OctText.setText(decToOct(input.getText().toString()));
                        }
                        catch(NumberFormatException e)
                        {
                            alert.setTitle(" ERROR ");
                            alert.setMessage(" You can't input more value ");
                            alert.setNeutralButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                }
                            });
                            alert.show();
                            bck();


                        }

                    }


                }

                if(Bin.isChecked())
                {
                    Log.d(Tag, "In Dec.isChecked()");


                    if (inputStr.length() == 0)
                    {
                        HexText.setText("");
                        BinText.setText("");
                        DecText.setText("");
                        OctText.setText("");
                        return;
                    }

                    if (!isProperBin())
                    {
                        Log.d(Tag, "In if(!isProperBin())");

                        alert.setTitle(" Format Error !!!!");
                        alert.setMessage("Wrong Binary Sequence");
                        alert.setNeutralButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });

                        alert.show();
                        bck();

                    }
                    else
                    {

                        try
                        {
                            long bin = Long.parseLong(inputStr);
                            String DecStr = binToDec(bin);
                            int i = Integer.parseInt(DecStr);


                            DecText.setText(DecStr);
                            HexText.setText(Integer.toHexString(i));
                            BinText.setText(input.getText());
                            OctText.setText(decToOct(DecStr));
                        }
                        catch(NumberFormatException e)
                        {
                            alert.setTitle(" ERROR ");
                            alert.setMessage(" You can't input more value ");
                            alert.setNeutralButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                }
                            });
                            alert.show();
                            bck();
                        }

                    }
                }


                if(Oct.isChecked())
                {
                    Log.d(Tag, "In Oct.isChecked()");


                    if (inputStr.length() == 0)
                    {
                        HexText.setText("");
                        BinText.setText("");
                        DecText.setText("");
                        OctText.setText("");
                        return;
                    }

                    if (!isProperOct())
                    {
                        Log.d(Tag, "In if(!isProperOct())");

                        alert.setTitle(" Format Error !!!!");
                        alert.setMessage("Wrong Octal Sequence");
                        alert.setNeutralButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });

                        alert.show();
                        bck();
                    }
                    else
                    {

                        try
                        {
                            long Oct = Long.parseLong(inputStr);
                            String DecStr = octToDec(Oct);
                            int i = Integer.parseInt(DecStr);


                            DecText.setText(DecStr);
                            HexText.setText(Integer.toHexString(i));
                            BinText.setText(Integer.toBinaryString(i));
                            OctText.setText(input.getText());
                        }
                        catch(NumberFormatException e)
                        {
                            alert.setTitle(" ERROR ");
                            alert.setMessage(" You can't input more value ");
                            alert.setNeutralButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                }
                            });
                            alert.show();
                            bck();


                        }

                    }
                }


                if(Hex.isChecked())
                {
                    Log.d(Tag, "In Hex.isChecked()");


                    if (inputStr.length() == 0)
                    {
                        HexText.setText("");
                        BinText.setText("");
                        DecText.setText("");
                        OctText.setText("");
                        return;
                    }

                    if (!isProperHex())
                    {
                        Log.d(Tag, "In if(!isProperOct())");

                        alert.setTitle(" Format Error !!!!");
                        alert.setMessage("Wrong Hexdecimal Sequence");
                        alert.setNeutralButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });

                        alert.show();
                        bck();
                    }
                    else
                    {

                        try
                        {

                            String DecStr = hexToDec(input.getText().toString());
                            int i = Integer.parseInt(DecStr);


                            DecText.setText(DecStr);
                            HexText.setText(Integer.toHexString(i));
                            BinText.setText(Integer.toBinaryString(i));
                            OctText.setText(decToOct(DecStr));
                        }
                        catch(NumberFormatException e)
                        {
                            alert.setTitle(" ERROR ");
                            alert.setMessage(" You can't input more value ");
                            alert.setNeutralButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                }
                            });
                            alert.show();
                            bck();


                        }

                    }
                }


            }
        });
    }

     String hexToDec(String hex)
    {
        char ch;
        long dec=0;
        String StrDec = "" ;
        int i,n,j;
        for(i=hex.length()-1, j=0; i >=0 ; ++j,--i)
        {
            ch = hex.charAt(i);

            if(ch >= '0' && ch <= '9')
            {
                n=(int)ch-48;

            }
            else
            {
                n = (int)ch-55;
            }

            dec +=  (n*Math.pow(16,j));

        }

        StrDec += dec;

        return StrDec;
    }


    String octToDec(Long bin)
    {
        long Dec=0,i,r;
        String DecStr ="";

        for(i=0;bin>0;i++)
        {
            r = bin%10;
            bin = bin/10;

            Dec += r * Math.pow(8,i);
        }

        DecStr += Dec;

        return DecStr;
    }


    String binToDec(Long bin)
    {
        long Dec=0,i,r;
        String DecStr ="";

        for(i=0;bin>0;i++)
        {
            r = bin%10;
            bin = bin/10;

            Dec += r * Math.pow(2,i);
        }

        DecStr += Dec;

        return DecStr;
    }

    String decToOct(String input )
    {
        int dec = Integer.parseInt(input);
        String oct = new String();
        int r;

        while(dec>0)
        {
            r=dec%8;
            dec=dec/8;
            oct+=r;
        }

        StringBuffer octStr = new StringBuffer(oct);

        return (octStr.reverse().toString());
    }

    public void bck()
    {

        String inputStr = input.getText().toString();
        if(inputStr.length()==0)
        {
            return;
        }

        String tmp = "";
        tmp = inputStr.substring(0,inputStr.length()-1);
        input.setText(tmp);

    }

    public void cls(View v)
    {

       bck();

    }

    public void bckFull()
    {
        String inputStr = input.getText().toString();
        if(inputStr.length()==0)
        {
            return;
        }

        input.setText("");
        HexText.setText("");
        BinText.setText("");
        DecText.setText("");
        OctText.setText("");
    }

    public void clsAll(View v)
    {
        bckFull();

    }


    public void add0(View v)
    {
        input.setText(input.getText().toString()+"0");
    }

    public void add1(View v) { input.setText(input.getText().toString()+"1"); }

    public void add2(View v)
    {
        input.setText(input.getText().toString()+"2");
    }


    public void add3(View v)
    {
        input.setText(input.getText().toString()+"3");
    }


    public void add4(View v)
    {
        input.setText(input.getText().toString()+"4");
    }


    public void add5(View v)
    {
        input.setText(input.getText().toString()+"5");
    }


    public void add6(View v)
    {
        input.setText(input.getText().toString()+"6");
    }


    public void add7(View v)
    {
        input.setText(input.getText().toString()+"7");
    }


    public void add8(View v)
    {
        input.setText(input.getText().toString()+"8");
    }


    public void add9(View v)
    {
        input.setText(input.getText().toString()+"9");
    }


    public void addA(View v)
    {
        input.setText(input.getText().toString()+"A");
    }


    public void addB(View v)
    {
        input.setText(input.getText().toString()+"B");
    }


    public void addC(View v)
    {
        input.setText(input.getText().toString()+"C");
    }


    public void addD(View v)
    {
        input.setText(input.getText().toString()+"D");
    }


    public void addE(View v)
    {
        input.setText(input.getText().toString()+"E");
    }


    public void addF(View v)
    {
        input.setText(input.getText().toString()+"F");
    }


    public boolean isProperBin()
    {
        String inputStr = input.getText().toString();
        char ch;
        int l = inputStr.length();

        ch = inputStr.charAt(l-1);

        if(ch!='1' && ch!='0')
        {
            return false;
        }

        return true;

    }

    public boolean isProperOct()
    {
        String inputStr = input.getText().toString();
        if(inputStr.length()==0)
        {
            return false;
        }

        char ch;
        int l = inputStr.length();

        ch = inputStr.charAt(l-1);

        if((ch>='0') && (ch<='7'))
        {
            return true;
        }
        else
        {
            return false;
        }

    }

    public boolean isProperHex()
    {
        String inputStr = input.getText().toString();
        if(inputStr.length()==0)
        {
            return false;
        }

        char ch;
        int l = inputStr.length();

        ch = inputStr.charAt(l-1);

        if (  (ch>='0' && ch<='9') || (ch>='A' && ch<='F')  )
        {
            return true;
        }
        else
        {
            return false;
        }

    }


    public boolean isProperDec()
    {
        String inputStr = input.getText().toString();

        if(inputStr.length()==0)
        {
            return false;
        }

        char ch;
        int l = inputStr.length();

        ch = inputStr.charAt(l-1);

        if((ch>='0') && (ch<='9'))
        {
            return true;
        }
        else
        {
            return false;
        }

    }


    public void BinFun(View view)
    {
        setBtnFalse(view);
        Bin.setChecked(true);
    }

    public void HexFun(View view)
    {
        setBtnFalse(view);
        Hex.setChecked(true);
    }

    public void OctFun(View view)
    {
        setBtnFalse(view);
        Oct.setChecked(true);
    }

    public void DecFun(View view)
    {
        setBtnFalse(view);
        Dec.setChecked(true);
    }

    public void setBtnFalse (View view)
    {
        if(Dec.isChecked())
        {
            Dec.setChecked(false);
        }

        if(Oct.isChecked())
        {
            Oct.setChecked(false);
        }

        if(Hex.isChecked())
        {
            Hex.setChecked(false);
        }

        if(Bin.isChecked())
        {
            Bin.setChecked(false);
        }

        bckFull();


    }



    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case R.id.about:
               funAbout();
                return true;
            case R.id.exit:
                System.exit(0);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    public void funAbout()
    {
        Intent intent = new Intent(this,ActivityAbout.class);
        startActivity(intent);

    }

    public boolean isNoBtnIsChecked()
    {
        if(Dec.isChecked() || Oct.isChecked() || Hex.isChecked() || Bin.isChecked() )
        {
            return false;
        }
        else
        {
            return true;
        }



    }

}

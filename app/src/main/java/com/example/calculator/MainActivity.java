package com.example.calculator;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.Stack;



public class MainActivity extends AppCompatActivity {

    Button button_c , button_mod , button_div ,button_mul , button_sub , button_add , button_dot ,  button_equal ,
            open_arc , close_arc , power , Ans  ;
    Button button_0 , button_00 , button_1 , button_2 ,
            button_3 , button_4 , button_5 , button_6 , button_7 , button_8 , button_9 ;
    static TextView show_result ;
    static String str = "" ;
    String last_value_file ;   // cary the last value in save file
    public final static String space = " " ;
    boolean flag_infinity = false ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        show_result = findViewById(R.id.tv_result) ;

        button_c = findViewById(R.id.btn_c) ;
        button_mod = findViewById(R.id.btn_mod) ;
        button_div = findViewById(R.id.btn_dividing) ;
        button_mul = findViewById(R.id.btn_mul) ;
        button_sub = findViewById(R.id.btn_sub) ;
        button_add = findViewById(R.id.btn_add) ;
        button_equal = findViewById(R.id.btn_equal) ;
        button_dot = findViewById(R.id.btn_dot) ;
        open_arc = findViewById(R.id.btn_open_arc) ;
        close_arc = findViewById(R.id.btn_close_arc) ;
        power = findViewById(R.id.btn_power) ;
        Ans = findViewById(R.id.btn_ans) ;

        button_0 = findViewById(R.id.btn_0) ;
        button_00 = findViewById(R.id.btn_00) ;
        button_1 = findViewById(R.id.btn_1) ;
        button_2 = findViewById(R.id.btn_2) ;
        button_3 = findViewById(R.id.btn_3) ;
        button_4 = findViewById(R.id.btn_4) ;
        button_5 = findViewById(R.id.btn_5) ;
        button_6 = findViewById(R.id.btn_6) ;
        button_7 = findViewById(R.id.btn_7) ;
        button_8 = findViewById(R.id.btn_8) ;
        button_9 = findViewById(R.id.btn_9) ;


        button_c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                show_result.setTextColor(getResources().getColor(R.color.tv_color));
                String s = show_result.getText().toString() ;
                if(s.length()>=1)
                {
                    str = "" ;
                    show_result.setText("");
                }
            }
        });


        open_arc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                show_result.setTextColor(getResources().getColor(R.color.tv_color));
                str +="(" ;
                show_result.setText(str) ;
            }
        });


        close_arc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                show_result.setTextColor(getResources().getColor(R.color.tv_color));
                str +=")" ;
                show_result.setText(str) ;
            }
        });


        Ans.setOnClickListener(new View.OnClickListener() {  // old value
            @Override
            public void onClick(View view) {
                show_result.setTextColor(getResources().getColor(R.color.tv_color));


                SharedPreferences shard = getSharedPreferences("saveFile",Context.MODE_PRIVATE) ;
                last_value_file = shard.getString("result","ON_DATA" );

                if(str.length()==0)
                {
                    str +=  last_value_file ;
                    show_result.setText("Ans");
                }
                else
                {
                    show_result.setText(str+"Ans");
                    str +=  last_value_file ;
                }

            }
        });



        power.setOnClickListener(new View.OnClickListener() {  //   ^
            @Override
            public void onClick(View view) {
                show_result.setTextColor(getResources().getColor(R.color.tv_color));
                String s = show_result.getText().toString() ;
                boolean isFound = s.indexOf("%") !=-1? true: false;
                if(isFound){}
                else if(s.length()==0){}
                else if(s.length()==1 && s.charAt(0)=='-') {}
                else
                {
                    int size_1 = s.length()-1 ;
                    int size_2 = s.length()-2 ;
                    if(s.charAt(size_1)=='/' || s.charAt(size_1)=='x' || s.charAt(size_1)=='+')
                    {
                        str = str.substring(0,size_1)+"^" ;
                    }
                    else if( (s.charAt(size_1)=='-' && s.charAt(size_2)=='x') || (s.charAt(size_1)=='-' && s.charAt(size_2)=='/') )
                    {
                        str = str.substring(0,size_2)+"^" ;
                    }
                    else if( s.charAt(size_1)=='-' && (s.charAt(size_2)!='x' || s.charAt(size_2)!='/') )
                    {
                        str = str.substring(0,size_1)+"^" ;
                    }
                    else
                    {
                        str +="^" ;
                    }
                    show_result.setText(str) ;
                }
            }
        });

        button_div.setOnClickListener(new View.OnClickListener() {  //  /
            @Override
            public void onClick(View view) {
                show_result.setTextColor(getResources().getColor(R.color.tv_color));
                String s = show_result.getText().toString() ;
                boolean isFound = s.indexOf("%") !=-1? true: false;
                if(isFound){}
                else if(s.length()==0){}
                else if(s.length()==1 && s.charAt(0)=='-') {}
                else
                {
                    int size_1 = s.length()-1 ;
                    int size_2 = s.length()-2 ;
                    if(s.charAt(size_1)=='/' || s.charAt(size_1)=='x' || s.charAt(size_1)=='+')
                    {
                        str = str.substring(0,size_1)+"/" ;
                    }
                    else if( (s.charAt(size_1)=='-' && s.charAt(size_2)=='x') || (s.charAt(size_1)=='-' && s.charAt(size_2)=='/') )
                    {
                        str = str.substring(0,size_2)+"/" ;
                    }
                    else if( s.charAt(size_1)=='-' && (s.charAt(size_2)!='x' || s.charAt(size_2)!='/') )
                    {
                        str = str.substring(0,size_1)+"/" ;
                    }
                    else
                    {
                        str +="/" ;
                    }
                    show_result.setText(str) ;
                }
            }
        });

        button_mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                show_result.setTextColor(getResources().getColor(R.color.tv_color));
                String s = show_result.getText().toString() ;
                boolean isFound = s.indexOf("%") !=-1? true: false;
                if(isFound){}
                else if(s.length()==0){}
                else if(s.length()==1 && s.charAt(0)=='-') {}
                else
                {
                    int size_1 = s.length()-1 ;
                    int size_2 = s.length()-2 ;
                    if(s.charAt(size_1)=='/' || s.charAt(size_1)=='x' || s.charAt(size_1)=='+')
                    {
                        str = str.substring(0,size_1)+"x" ;
                    }
                    else if( (s.charAt(size_1)=='-' && s.charAt(size_2)=='x') || (s.charAt(size_1)=='-' && s.charAt(size_2)=='/') )
                    {
                        str = str.substring(0,size_2)+"x" ;
                    }
                    else if( s.charAt(size_1)=='-' && (s.charAt(size_2)!='x' || s.charAt(size_2)!='/') )
                    {
                        str = str.substring(0,size_1)+"x" ;
                    }
                    else
                    {
                        str +="x" ;
                    }
                    show_result.setText(str) ;
                }
            }
        });

        button_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                show_result.setTextColor(getResources().getColor(R.color.tv_color));
                String s = show_result.getText().toString() ;
                boolean isFound = s.indexOf("%") !=-1? true: false;
                if(isFound){}
                else if(s.length()==0) {}
                else if(s.length()==1 && s.charAt(0)=='-') {}
                else
                {
                    int size_1 = s.length()-1 ;
                    int size_2 = s.length()-2 ;
                    if(s.charAt(size_1)=='/' || s.charAt(size_1)=='x' || s.charAt(size_1)=='+')
                    {
                        str = str.substring(0,size_1)+"+" ;
                    }
                    else if( (s.charAt(size_1)=='-' && s.charAt(size_2)=='x') || (s.charAt(size_1)=='-' && s.charAt(size_2)=='/') )
                    {
                        str = str.substring(0,size_2)+"+" ;
                    }
                    else if( s.charAt(size_1)=='-' && (s.charAt(size_2)!='x' || s.charAt(size_2)!='/') )
                    {
                        str = str.substring(0,size_1)+"+" ;
                    }
                    else
                    {
                        str +="+" ;
                    }
                    show_result.setText(str) ;
                }

            }
        });

        button_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                show_result.setTextColor(getResources().getColor(R.color.tv_color));
                String s = show_result.getText().toString() ;
                boolean isFound = s.indexOf("%") !=-1? true: false;
                if(isFound){}
                else if(s.length()==0)
                {
                    str +="-" ;
                    show_result.setText(str) ;
                }
                else if(s.length()==1 && s.charAt(0)=='-') {}
                else
                {
                    int size_1 = s.length()-1 ;
                    int size_2 = s.length()-2 ;
                    if(s.charAt(size_1)=='/' || s.charAt(size_1)=='x')
                    {
                        str += "-" ;
                        show_result.setText(str) ;
                    }
                    else if(s.charAt(size_1)=='+' || s.charAt(size_1)=='-')
                    {
                        str = str.substring(0,size_1)+"-" ;
                        show_result.setText(str) ;
                    }
                    else
                    {
                        str +="-" ;
                        show_result.setText(str) ;
                    }
                }

            }
        });



        button_dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                show_result.setTextColor(getResources().getColor(R.color.tv_color));
                str +="." ;
                show_result.setText(str) ;
            }
        });



        button_mod.setOnClickListener(new View.OnClickListener() {  // start from here
            @Override
            public void onClick(View view) {
                show_result.setTextColor(getResources().getColor(R.color.tv_color));
                String s = show_result.getText().toString() ;
                if(s.length()==0){}
                else
                {
                    str += " mod " ;
                    show_result.setText(str);
                }

            }
        });



        button_equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                show_result.setTextColor(getResources().getColor(R.color.tv_color));
                String s = show_result.getText().toString() ;

                if(s.length()==0){}
                else if(s.length()==1 && s.charAt(0)=='-')
                    show_result.setText("-Ans = "+"\n"+last_value_file);
                else if(s.length()==3 && s=="Ans" )
                {
                    show_result.setText("Ans = "+"\n"+str);
                }
                else if(s.contains("mod"))
                {
                    String before_mod = str.substring(0,str.indexOf('m')-1) ;
                    String after_mod = str.substring(str.indexOf('d')+2 , str.length()) ;

                    String before_cal = main(before_mod) ;
                    String after_cal = main(after_mod) ;

                    if(before_cal=="error" || after_cal=="error"){}
                    else if(before_cal!="error" && after_cal!="error")
                    {
                        double num1 = Double.parseDouble(before_cal) ;
                        double num2 = Double.parseDouble(after_cal) ;

                        double remainder = remainder_division(num1 , num2) ;
                        if(remainder==-1)
                        {
                            String error = "Math ERROR !\n"+" [AC]  :Cancel\n"+" [Any Button]  :Goto" ;
                            show_result.setTextColor(getResources().getColor(R.color.red));
                            show_result.setText(error);
                        }
                        else
                        {
                            show_result.setText(str+" =\n"+remainder);


                            // it is to save last value to return when click on button Ans
                            SharedPreferences shard = getSharedPreferences("saveFile", Context.MODE_PRIVATE) ;
                            SharedPreferences.Editor editor = shard.edit() ;
                            editor.putString("result", remainder+"") ;
                            editor.apply();
                        }
                    }

                }
                else
                {
                    String calculation = str.replaceAll("x","*") ;
                    String final_value =  main(calculation) ;
                    if(final_value=="error"){}
                    else if(flag_infinity==true)
                    {
                        String error = "Math ERROR !\n"+" [AC]  :Cancel\n"+" [Any Button]  :Goto" ;
                        show_result.setTextColor(getResources().getColor(R.color.red));
                        show_result.setText(error);
                        flag_infinity = false ;
                    }
                    else
                        show_result.setText(str+" =\n"+final_value);
                }
            }
        });




        button_00.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                show_result.setTextColor(getResources().getColor(R.color.tv_color));
                String s = show_result.getText().toString() ;
                if(s=="")
                {
                    show_result.setText(0+"");
                    str += "0" ;
                }
                else if(s.length()==1 && s.charAt(0)=='0') {}
                else if(s.length()==1 && s.charAt(0)=='-')
                {
                    str += "0" ;
                    show_result.setText(str);
                }
                else if(s.length()>1 && s.charAt(s.length()-1)=='0' &&
                        (s.charAt(s.length()-2)=='/' || s.charAt(s.length()-2)=='x' || s.charAt(s.length()-2)=='+' || s.charAt(s.length()-2)=='-') ) {}
                else if(s.length()>1 &&
                        (s.charAt(s.length()-1)=='/' || s.charAt(s.length()-1)=='x' || s.charAt(s.length()-1)=='+' || s.charAt(s.length()-1)=='-') )
                {
                    str = str.substring(0,str.length())+"0" ;
                    show_result.setText(str);
                }
                else
                {
                    str += "00" ;
                    show_result.setText(str);
                }

            }
        });

        button_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                show_result.setTextColor(getResources().getColor(R.color.tv_color));
                String s = show_result.getText().toString() ;
                if(s=="")
                {
                    show_result.setText(0+"");
                    str += "0" ;
                }
                else if(s.length()==1 && s.charAt(0)=='0') {}
                else if(s.length()==1 && s.charAt(0)=='-')
                {
                    str += "0" ;
                    show_result.setText(str);
                }
                else if(s.length()>1 && s.charAt(s.length()-1)=='0' &&
                        (s.charAt(s.length()-2)=='/' || s.charAt(s.length()-2)=='x' || s.charAt(s.length()-2)=='+' || s.charAt(s.length()-2)=='-') ) {}
                else if(s.length()>1 &&
                        (s.charAt(s.length()-1)=='/' || s.charAt(s.length()-1)=='x' || s.charAt(s.length()-1)=='+' || s.charAt(s.length()-1)=='-') )
                {
                    str = str.substring(0,str.length())+"0" ;
                    show_result.setText(str);
                }
                else
                {
                    str += "0" ;
                    show_result.setText(str);
                }
            }
        });

        button_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                show_result.setTextColor(getResources().getColor(R.color.tv_color));
                String s = show_result.getText().toString() ;
                if(s=="")
                {
                    show_result.setText(1+"");
                    str += "1" ;
                }
                else if(s.length()==1 && s.charAt(0)=='0')
                {
                    str = "1" ;
                    show_result.setText(str);
                }
                else if(s.length()>1 && s.charAt(s.length()-1)=='0' &&
                        (s.charAt(s.length()-2)=='/' || s.charAt(s.length()-2)=='x' || s.charAt(s.length()-2)=='+' || s.charAt(s.length()-2)=='-') )
                {
                    str = str.substring(0,str.length()-1)+"1" ;
                    show_result.setText(str);
                }
                else
                {
                    str += "1" ;
                    show_result.setText(str);
                }
            }
        });

        button_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                show_result.setTextColor(getResources().getColor(R.color.tv_color));
                String s = show_result.getText().toString() ;
                if(s=="")
                {
                    show_result.setText(2+"");
                    str += "2" ;
                }
                else if(s.length()==1 && s.charAt(0)=='0')
                {
                    str = "2" ;
                    show_result.setText(str);
                }
                else if(s.length()>1 && s.charAt(s.length()-1)=='0' &&
                        (s.charAt(s.length()-2)=='/' || s.charAt(s.length()-2)=='x' || s.charAt(s.length()-2)=='+' || s.charAt(s.length()-2)=='-') )
                {
                    str = str.substring(0,str.length()-1)+"2" ;
                    show_result.setText(str);
                }
                else
                {
                    str += "2" ;
                    show_result.setText(str);
                }
            }
        });

        button_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                show_result.setTextColor(getResources().getColor(R.color.tv_color));
                String s = show_result.getText().toString() ;
                if(s=="")
                {
                    show_result.setText(3+"");
                    str += "3" ;
                }
                else if(s.length()==1 && s.charAt(0)=='0')
                {
                    str = "3" ;
                    show_result.setText(str);
                }
                else if(s.length()>1 && s.charAt(s.length()-1)=='0' &&
                        (s.charAt(s.length()-2)=='/' || s.charAt(s.length()-2)=='x' || s.charAt(s.length()-2)=='+' || s.charAt(s.length()-2)=='-') )
                {
                    str = str.substring(0,str.length()-1)+"3" ;
                    show_result.setText(str);
                }
                else
                {
                    str += "3" ;
                    show_result.setText(str);
                }
            }
        });

        button_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                show_result.setTextColor(getResources().getColor(R.color.tv_color));
                String s = show_result.getText().toString() ;
                if(s=="")
                {
                    show_result.setText(4+"");
                    str += "4" ;
                }
                else if(s.length()==1 && s.charAt(0)=='0')
                {
                    str = "4" ;
                    show_result.setText(str);
                }
                else if(s.length()>1 && s.charAt(s.length()-1)=='0' &&
                        (s.charAt(s.length()-2)=='/' || s.charAt(s.length()-2)=='x' || s.charAt(s.length()-2)=='+' || s.charAt(s.length()-2)=='-') )
                {
                    str = str.substring(0,str.length()-1)+"4" ;
                    show_result.setText(str);
                }
                else
                {
                    str += "4" ;
                    show_result.setText(str);
                }
            }
        });

        button_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                show_result.setTextColor(getResources().getColor(R.color.tv_color));
                String s = show_result.getText().toString() ;
                if(s=="")
                {
                    show_result.setText(5+"");
                    str += "5" ;
                }
                else if(s.length()==1 && s.charAt(0)=='0')
                {
                    str = "5" ;
                    show_result.setText(str);
                }
                else if(s.length()>1 && s.charAt(s.length()-1)=='0' &&
                        (s.charAt(s.length()-2)=='/' || s.charAt(s.length()-2)=='x' || s.charAt(s.length()-2)=='+' || s.charAt(s.length()-2)=='-') )
                {
                    str = str.substring(0,str.length()-1)+"5" ;
                    show_result.setText(str);
                }
                else
                {
                    str += "5" ;
                    show_result.setText(str);
                }
            }
        });

        button_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                show_result.setTextColor(getResources().getColor(R.color.tv_color));
                String s = show_result.getText().toString() ;
                if(s=="")
                {
                    show_result.setText(6+"");
                    str += "6" ;
                }
                else if(s.length()==1 && s.charAt(0)=='0')
                {
                    str = "6" ;
                    show_result.setText(str);
                }
                else if(s.length()>1 && s.charAt(s.length()-1)=='0' &&
                        (s.charAt(s.length()-2)=='/' || s.charAt(s.length()-2)=='x' || s.charAt(s.length()-2)=='+' || s.charAt(s.length()-2)=='-') )
                {
                    str = str.substring(0,str.length()-1)+"6" ;
                    show_result.setText(str);
                }
                else
                {
                    str += "6" ;
                    show_result.setText(str);
                }
            }
        });

        button_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                show_result.setTextColor(getResources().getColor(R.color.tv_color));
                String s = show_result.getText().toString() ;
                if(s=="")
                {
                    show_result.setText(7+"");
                    str += "7" ;
                }
                else if(s.length()==1 && s.charAt(0)=='0')
                {
                    str = "7" ;
                    show_result.setText(str);
                }
                else if(s.length()>1 && s.charAt(s.length()-1)=='0' &&
                        (s.charAt(s.length()-2)=='/' || s.charAt(s.length()-2)=='x' || s.charAt(s.length()-2)=='+' || s.charAt(s.length()-2)=='-') )
                {
                    str = str.substring(0,str.length()-1)+"7" ;
                    show_result.setText(str);
                }
                else
                {
                    str += "7" ;
                    show_result.setText(str);
                }
            }
        });

        button_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                show_result.setTextColor(getResources().getColor(R.color.tv_color));
                String s = show_result.getText().toString() ;
                if(s=="")
                {
                    show_result.setText(8+"");
                    str += "8" ;
                }
                else if(s.length()==1 && s.charAt(0)=='0')
                {
                    str = "8" ;
                    show_result.setText(str);
                }
                else if(s.length()>1 && s.charAt(s.length()-1)=='0' &&
                        (s.charAt(s.length()-2)=='/' || s.charAt(s.length()-2)=='x' || s.charAt(s.length()-2)=='+' || s.charAt(s.length()-2)=='-') )
                {
                    str = str.substring(0,str.length()-1)+"8" ;
                    show_result.setText(str);
                }
                else
                {
                    str += "8" ;
                    show_result.setText(str);
                }
            }
        });

        button_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                show_result.setTextColor(getResources().getColor(R.color.tv_color));
                String s = show_result.getText().toString() ;
                if(s=="")
                {
                    show_result.setText(9+"");
                    str += "9" ;
                }
                else if(s.length()==1 && s.charAt(0)=='0')
                {
                    str = "9" ;
                    show_result.setText(str);
                }
                else if(s.length()>1 && s.charAt(s.length()-1)=='0' &&
                        (s.charAt(s.length()-2)=='/' || s.charAt(s.length()-2)=='x' || s.charAt(s.length()-2)=='+' || s.charAt(s.length()-2)=='-') )
                {
                    str = str.substring(0,str.length()-1)+"9" ;
                    show_result.setText(str);
                }
                else
                {
                    str += "9" ;
                    show_result.setText(str);
                }
            }
        });




    }

    public void backspace(View view) {
        String s = show_result.getText().toString() ;
        if(s.length()>=1)
        {
            show_result.setTextColor(getResources().getColor(R.color.tv_color));
            str = s.substring(0,s.length()-1) ;
            show_result.setText(str);
        }
    }


    //  Start To Convert The String calculation to number


    public String main(String expression) {

        try
        {
            for(int i=0 ; i<expression.length()-1 ; i++)
            {
                if(i==0 && expression.charAt(i)=='-' && expression.charAt(i+1)=='(')
                    expression = "-1" + expression.substring(i+1,expression.length());

                if(i!=0 && (expression.charAt(i-1)=='*' || expression.charAt(i-1)=='/' || expression.charAt(i-1)=='^' || expression.charAt(i-1)=='(') && expression.charAt(i)=='-' && expression.charAt(i+1)=='(')
                    expression = expression.substring(0, i) + "-1" + expression.substring(i+1,expression.length());
            }

            for(int i=0 ; i<expression.length()-1 ; i++) ///
            {
                if(Character.isDigit(expression.charAt(i)) && expression.charAt(i+1)=='(')
                    expression = expression.substring(0, i+1) + "*" + expression.substring(i+1,expression.length());
            }


            String last_result = "" ;
            String postfix = infix_to_postfix(expression);

            String postfix_result = postfix.substring(0, postfix.length()-1);

            double result_cal =  convert_Postfix_To_Result(postfix_result) ;  // the result

            last_result += result_cal+"" ;


            // it is to save last value to return when click on button Ans
            SharedPreferences shard = getSharedPreferences("saveFile", Context.MODE_PRIVATE) ;
            SharedPreferences.Editor editor = shard.edit() ;
            editor.putString("result", last_result) ;
            editor.apply();

            return last_result ;    // result

        }
        catch (Exception e)
        {
            String error = "Syntax ERROR !\n"+" [AC]  :Cancel\n"+" [Any Button]  :Goto" ;
            show_result.setTextColor(getResources().getColor(R.color.red));
            show_result.setText(error);
            return "error" ;
        }

    }  // End The calling Method





    // convert from Infix to postfix
    public int Priority(char c){   // Check the Operator + - * / ^
        if (c == '-' || c == '+')
            return 1;
        else if (c == '*' || c == '/')
            return 2;
        else if (c == '^')
            return 3;
        else
            return 0;
    }
    public String infix_to_postfix(String exp){  // To convert the Infix to postfix
        Stack<Character> stk= new Stack<>();
        String output = "";
        for (int i = 0; i < exp.length(); i++)
        {
            if (exp.charAt(i) == ' ') continue;

            if (Character.isDigit(exp.charAt(i)) || Character.isAlphabetic(exp.charAt(i)) || exp.charAt(i)=='.')
            {
                int cnt = 0 ;
                String v = "" ;
                String num = exp.charAt(i)+v ;
                for(int j=i+1 ; j<exp.length() ; j++)
                {
                    if( Character.isDigit(exp.charAt(j)) || Character.isAlphabetic(exp.charAt(j)) || exp.charAt(j)=='.')
                    {
                        num += exp.charAt(j) ;
                        cnt++ ;
                    }
                    else
                        break ;
                }

                i = i+cnt ;
                output += num+space ;
            }
            else if (exp.charAt(i) == '(')
                stk.push('(');
            else if (exp.charAt(i) == ')')
            {
                while (stk.peek() != '(')
                {
                    output += stk.peek()+space;
                    stk.pop();
                }
                stk.pop();
            }
            else      // it is operator
            {
                if(i==0 && exp.charAt(i)=='-')
                {
                    int cnt = 0 ;
                    String v = "" ;
                    String num = exp.charAt(i)+v ;
                    for(int j=i+1 ; j<exp.length() ; j++)
                    {
                        if( Character.isDigit(exp.charAt(j)) || Character.isAlphabetic(exp.charAt(j)) || exp.charAt(j)=='.')
                        {
                            num += exp.charAt(j) ;
                            cnt++ ;
                        }
                        else
                            break ;
                    }

                    i = i+cnt ;
                    output += num+space ;
                }
                else if(exp.charAt(i)=='-' && exp.charAt(i-1)=='(')
                {
                    int cnt = 0 ;
                    String v = "" ;
                    String num = exp.charAt(i)+v ;
                    for(int j=i+1 ; j<exp.length() ; j++)
                    {
                        if( Character.isDigit(exp.charAt(j)) || Character.isAlphabetic(exp.charAt(j)) || exp.charAt(j)=='.')
                        {
                            num += exp.charAt(j) ;
                            cnt++ ;
                        }
                        else
                            break ;
                    }

                    i = i+cnt ;
                    output += num+space ;
                }
                else if(exp.charAt(i)=='-' && exp.charAt(i-1)=='*')
                {
                    int cnt = 0 ;
                    String v = "" ;
                    String num = exp.charAt(i)+v ;
                    for(int j=i+1 ; j<exp.length() ; j++)
                    {
                        if( Character.isDigit(exp.charAt(j)) || Character.isAlphabetic(exp.charAt(j)) || exp.charAt(j)=='.')
                        {
                            num += exp.charAt(j) ;
                            cnt++ ;
                        }
                        else
                            break ;
                    }

                    i = i+cnt ;
                    output += num+space ;
                }
                else if(exp.charAt(i)=='-' && exp.charAt(i-1)=='/')
                {
                    int cnt = 0 ;
                    String v = "" ;
                    String num = exp.charAt(i)+v ;
                    for(int j=i+1 ; j<exp.length() ; j++)
                    {
                        if( Character.isDigit(exp.charAt(j)) || Character.isAlphabetic(exp.charAt(j)) || exp.charAt(j)=='.')
                        {
                            num += exp.charAt(j) ;
                            cnt++ ;
                        }
                        else
                            break ;
                    }

                    i = i+cnt ;
                    output += num+space ;
                }
                else if(exp.charAt(i)=='-' && exp.charAt(i-1)=='^') {
                    int cnt = 0;
                    String v = "";
                    String num = exp.charAt(i) + v;
                    for (int j = i + 1; j < exp.length(); j++) {
                        if (Character.isDigit(exp.charAt(j)) || Character.isAlphabetic(exp.charAt(j)) || exp.charAt(j) == '.') {
                            num += exp.charAt(j);
                            cnt++;
                        } else
                            break;
                    }

                    i = i + cnt;
                    output += num + space;
                }
                else {
                    while (!stk.empty() && Priority(exp.charAt(i)) <= Priority(stk.peek()))
                    {
                        output += stk.peek()+space;
                        stk.pop();
                    }
                    stk.push(exp.charAt(i));
                }
            }
        }

        while (!stk.empty())
        {
            output += stk.peek()+space;
            stk.pop();
        }

        return output;

    }  /// End the Method Convert from Infix to postfix



    public boolean isOperator(char ch) // Is it a Operator or not ?
    {
        if (ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^')
            return true;
        else
            return false;
    }

    public double performOperation(double op1, double op2, char op) // Executing the calculation
    {
        double ans = 0;
        switch (op) {
            case '+':
                ans = op2 + op1;
                break;
            case '-':
                ans = op2 - op1;
                break;
            case '*':
                ans = op2 * op1;
                break;
            case '/':
                ans = op2 / op1;
                break;
            case '^':
                ans = Math.pow(op2,op1)  ;
                break;
        }
        return ans;
    }


    @SuppressWarnings("empty-statement")
    public double convert_Postfix_To_Result(String exp)  // Convert the Postfix To Result
    {

        int sz_exp = exp.length();
        if (exp.charAt(0) == '-')
        {
            String value = exp.substring(1, sz_exp);
            if (value.contains("+")==false && value.contains("-")==false && value.contains("*")==false && value.contains("/")==false && value.contains("^")==false && exp.contains("(")==false && exp.contains(")")==false ) {
                double v = Double.parseDouble(exp) ;
                return v ;
            }
        } else {
            if(exp.contains("+")==false && exp.contains("-")==false && exp.contains("*")==false && exp.contains("/")==false && exp.contains("^")==false && exp.contains("(")==false && exp.contains(")")==false ) {
                double v = Double.parseDouble(exp) ;
                return v ;
            }
        }

        char[] buffer = new char[300] ;
        int i , len , j ;
        double op1, op2 , x ;
        Stack <Double> s = new Stack<>();
        j = 0;
        len = exp.length() ;
        for (i = 0; i < len; i++)
        {
            if (exp.charAt(i) >= '0' && exp.charAt(i) <= '9')
            {
                buffer[j++] = exp.charAt(i);
            }
            else if(exp.charAt(i) == '.')
                buffer[j++] = exp.charAt(i) ;
            else if(i<len-1 && exp.charAt(i)=='-' && (Character.isDigit(exp.charAt(i+1)) || Character.isAlphabetic(exp.charAt(i+1)) || exp.charAt(i+1)=='.' ) )
            {
                buffer[j++] = exp.charAt(i);
            }
            else if (exp.charAt(i) == ' ')
            {
                if (j > 0)
                {
                    for(int k=j ; k<buffer.length ; k++)
                        buffer[k] = '\0';
                    String str = String.valueOf(buffer);
                    x = Double.parseDouble(str);
                    s.push(x) ;
                    j = 0;
                }
            }
            else if (isOperator(exp.charAt(i)))
            {
                op1 = s.peek();

                if(exp.charAt(i)=='/' && op1==0.0) // TO check the infinity    number/zero
                    flag_infinity = true  ;

                s.pop();
                op2 = s.peek();
                s.pop();
                s.push(performOperation(op1, op2, exp.charAt(i)) );
            }
        }

        return s.peek() ;   // the Result calculation
    }




    // this the method to calculate the remainder of the division
    public double remainder_division(double n1 , double n2)
    {

        if(n2<0)
            n2 = n2*-1 ;

        if(n2==0)
        {
            return -1 ;
        }
        else if(n1==n2 || n1==0 || (n1%n2==0 && n1!=0 && n2!=0))
            return 0 ;
        else if(n1<n2 && n1>0 && n2>0)
        {
            return n1 ;
        }
        else if(n1>n2 && n1>0 && n2>0)
        {

            int x = 0 , y=0 ;
            double z=0 ;
            while(true)
            {
                x = (int)(n1/n2) ;
                y = (int)(n2*x) ;
                z = n1-y ;
                if(z<n2)
                    break;
                else
                {
                    System.out.println("yes");
                    n1 = z ;
                }
            }

            return z ;
        }
        else if(n1<0 && n2>0)
        {
            int x = 0 , y=0 ;
            double z=0 ;

            while(true)
            {
                x = (int)(n1/n2)-1 ;
                y = (int)(n2*x) ;
                z = n1-y ;
                if(z<n2)
                    break;
                else
                {
                    System.out.println("yes");
                    n1 = z ;
                }
            }

            return z ;
        }
        else
            return -1 ;
    }




} // End the Class Application
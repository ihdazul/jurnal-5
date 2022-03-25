package com.company;
import java.util.Stack;


public class Inpos {
    private String iS; //Untuk Infix String
    private Stack s; // untuk Stack

    public Inpos(String iString){ //method untuk operasi
        iS = iString;
        s = new Stack();
        String output = "";//Hasil dari operasi
        boolean fI = false;//Untuk kondisi dibawah
        for(int i = 0; i < iS.length();i++){
            char curChar = iS.charAt(i);
            if(!isOperator(curChar)){//Penjelasan method kebawah
                output += Character.toString(curChar);//output adalah char yang tersedia
                if(i == (iS.length()-1)){
                    while(!s.empty()){//Ketika Stack tidak kosong
                        output += s.pop();//hilangkan dari stack
                        //A+B-C Kita akan menghilangkan operasi dan memunculkannya kembali di akhir
                    }
                }
            }else{//jika true
                if(fI){
                    if(pMin(curChar) && pMin((Character)s.peek())){//kita akan melihat pada current character puncak
                        output += s.pop();
                        s.push(curChar);
                        if(i == (iS.length()-1)){ //jika i sama dengan panjang dari string infix -1
                            while(!s.empty()){
                                output +=s.pop();
                            }
                        }
                    }//tambah kurang dan puncaknya tambah kurang
                    else if(mDiv(curChar) && mDiv((Character)s.peek())){
                        output += s.pop();
                        s.push(curChar);
                        if(i == (iS.length()-1)){ //jika i sama dengan panjang dari string infix-1
                            while(!s.empty()){
                                output +=s.pop();
                            }
                        }
                    }//perkalian pembagian dan puncaknya kali bagi
                    else if(pMin(curChar) && mDiv((Character)s.peek())){
                        output += s.pop();
                        s.push(curChar);
                        if(i == (iS.length()-1)){ //jika i sama dengan panjang dari string infix-1
                            while(!s.empty()){
                                output +=s.pop();
                            }
                        }
                    }//tambah kurang dan puncaknya kali bagi
                    else if(mDiv(curChar) && pMin((Character)s.peek())){
                        s.push(curChar);
                        if(i == (iS.length()-1)){ //jika i sama dengan panjang dari string infix-1
                            while(!s.empty()){
                                output +=s.pop();
                            }
                        }
                    }//pada bagian ini memasukan input kedalam stack dan berhenti melakukan loop
                    else{
                        output += Character.toString(curChar);
                        if(i == (iS.length()-1)){ //jika i sama dengan panjang dari string infix-1
                            while(!s.empty()){
                                output = output + s.pop();
                            }
                        }
                    }
                }
                else{
                    s.push(curChar);
                    fI = true;
                }
            }
        }
        System.out.println(output);
    }

    public boolean isOperator(char op){ //untuk +,-,x,/ 
        return switch (op) {
            case '+', '*', '-', '/', '^' -> true;
            default -> false;
            //Ini adalah operator nyala matinya sistem

        };
    }

    public boolean pMin(char op){
        return switch (op) {
            case '+', '-' -> true;
            default -> false;
        };
    }
    
    public boolean mDiv(char op){
        return switch (op) {
            case '*', '/' -> true;
            default -> false;
        };
    }

}


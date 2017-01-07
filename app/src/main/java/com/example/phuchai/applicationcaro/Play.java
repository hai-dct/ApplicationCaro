package com.example.phuchai.applicationcaro;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Random;

public class Play extends AppCompatActivity {
    private GridLayout gridLayout;
    private Button button[][];
    private RelativeLayout main;
    private TextView textView;
    private int luotdi = 1;
    private int data[][];
    private boolean gameOver = false;
    private int n = 9;
    private int mI, mJ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        addControl();
        createLayout(n);
    }

    private void addControl() {
        main = (RelativeLayout) findViewById(R.id.activity_play);
        textView = (TextView) findViewById(R.id.welcome);
    }

    private void createLayout(int n) {
        gridLayout = new GridLayout(getApplicationContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(20, 100, 0, 0);
        layoutParams.addRule(RelativeLayout.BELOW, textView.getId());
        gridLayout.setId(R.id.gl);
        gridLayout.setLayoutParams(layoutParams);
        gridLayout.setColumnCount(n);
        button = new Button[n][n];
        //---
        data = new int[n][n];
        //---
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                button[i][j] = new Button(this);
                button[i][j].setTextSize(14);
                ActionBar.LayoutParams layout2 = new ActionBar.LayoutParams(50, 50);
                button[i][j].setLayoutParams(new ActionBar.LayoutParams(50, 50));
                button[i][j].setBackground(getResources().getDrawable(R.drawable.dinhdang_button));
                button[i][j].setOnClickListener(new Click(i, j));
                gridLayout.addView(button[i][j]);
                //---
                data[i][j] = 0;
            }
        main.addView(gridLayout);
    }

    public void checkWin() {
        checkRow();
        checkCol();
        checkUp();
        checkDown();
    }

    //----------
    public void checkRow() {//kiem tra tat ca cac ham xem co hang nao du 5x lien tuc
        int dem = 0;
        //kiem tra quan X
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (data[i][j] == 1) {
                    dem++;
                    if (dem == 5) {
                        gameOver = true;
                        button[i][j].setTextColor(getResources().getColor(R.color.colorAccent));
                        button[i][j].setTextColor(getResources().getColor(R.color.colorAccent));
                        button[i][j - 1].setTextColor(getResources().getColor(R.color.colorAccent));
                        button[i][j - 2].setTextColor(getResources().getColor(R.color.colorAccent));
                        button[i][j - 3].setTextColor(getResources().getColor(R.color.colorAccent));
                        button[i][j - 4].setTextColor(getResources().getColor(R.color.colorAccent));
                        break;
                    }
                } else {
                    dem = 0;
                }
            }
        }
        dem = 0;
        //kiem tra quan 0
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (data[i][j] == 2) {
                    dem++;
                    if (dem == 5) {
                        gameOver = true;
                        button[i][j].setTextColor(getResources().getColor(R.color.colorAccent));
                        button[i][j - 1].setTextColor(getResources().getColor(R.color.colorAccent));
                        button[i][j - 2].setTextColor(getResources().getColor(R.color.colorAccent));
                        button[i][j - 3].setTextColor(getResources().getColor(R.color.colorAccent));
                        button[i][j - 4].setTextColor(getResources().getColor(R.color.colorAccent));
                        break;
                    }
                } else {
                    dem = 0;
                }
            }
        }
    }

    //----------
    public void checkCol() {
        int dem = 0;
        //kiem tra x theo cot
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n; i++) {
                if (data[i][j] == 1) {
                    dem++;
                    if (dem == 5) {
                        gameOver = true;
                        button[i][j].setTextColor(getResources().getColor(R.color.colorAccent));
                        button[i - 1][j].setTextColor(getResources().getColor(R.color.colorAccent));
                        button[i - 2][j].setTextColor(getResources().getColor(R.color.colorAccent));
                        button[i - 3][j].setTextColor(getResources().getColor(R.color.colorAccent));
                        button[i - 4][j].setTextColor(getResources().getColor(R.color.colorAccent));
                        break;
                    }
                } else {
                    dem = 0;
                }
            }
        }
        dem = 0;
        //kiem tra x theo cot
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n; i++) {
                if (data[i][j] == 2) {
                    dem++;
                    if (dem == 5) {
                        gameOver = true;
                        button[i][j].setTextColor(getResources().getColor(R.color.colorAccent));
                        button[i - 1][j].setTextColor(getResources().getColor(R.color.colorAccent));
                        button[i - 2][j].setTextColor(getResources().getColor(R.color.colorAccent));
                        button[i - 3][j].setTextColor(getResources().getColor(R.color.colorAccent));
                        button[i - 4][j].setTextColor(getResources().getColor(R.color.colorAccent));
                        break;
                    }
                } else {
                    dem = 0;
                }
            }
        }
    }

    //----------
    public void checkUp() {//kiem tra duong cheo len
        int dem = 0;
        //kiem tra quan X
        for (int k = 4; k < 2 * n - 1; k++) {//k=4 cho den 2*n-5
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if ((i + j) == k) {//dung duong cheo len
                        if (data[i][j] == 1) {
                            dem++;
                            if (dem == 5) {
                                gameOver = true;
                                button[i][j].setTextColor(getResources().getColor(R.color.colorAccent));
                                button[i - 1][j + 1].setTextColor(getResources().getColor(R.color.colorAccent));
                                button[i - 2][j + 2].setTextColor(getResources().getColor(R.color.colorAccent));
                                button[i - 3][j + 3].setTextColor(getResources().getColor(R.color.colorAccent));
                                button[i - 4][j + 4].setTextColor(getResources().getColor(R.color.colorAccent));
                                break;
                            }
                        } else {
                            dem = 0;
                        }
                    }
                }
            }
        }
        dem = 0;
        //kiem tra quan O
        for (int k = 4; k < 2 * n - 1; k++) {//k=4 cho den 2*n-5
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if ((i + j) == k) {//dung duong cheo len
                        if (data[i][j] == 2) {
                            dem++;
                            if (dem == 5) {
                                gameOver = true;
                                button[i][j].setTextColor(getResources().getColor(R.color.colorAccent));
                                button[i - 1][j + 1].setTextColor(getResources().getColor(R.color.colorAccent));
                                button[i - 2][j + 2].setTextColor(getResources().getColor(R.color.colorAccent));
                                button[i - 3][j + 3].setTextColor(getResources().getColor(R.color.colorAccent));
                                button[i - 4][j + 4].setTextColor(getResources().getColor(R.color.colorAccent));
                                break;
                            }
                        } else {
                            dem = 0;
                        }
                    }
                }
            }
        }
    }

    //----------
    public void checkDown() {
        int dem = 0;
        //dem quan X
        for (int k = (1 - n); k < (n - 1); k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if ((i - j) == k) {
                        if (data[i][j] == 1) {
                            dem++;
                            if (dem == 5) {
                                gameOver = true;
                                button[i][j].setTextColor(getResources().getColor(R.color.colorAccent));
                                button[i - 1][j - 1].setTextColor(getResources().getColor(R.color.colorAccent));
                                button[i - 2][j - 2].setTextColor(getResources().getColor(R.color.colorAccent));
                                button[i - 3][j - 3].setTextColor(getResources().getColor(R.color.colorAccent));
                                button[i - 4][j - 4].setTextColor(getResources().getColor(R.color.colorAccent));
                                break;
                            }
                        } else {
                            dem = 0;
                        }
                    }
                }
            }
        }
        //dem quan O
        dem = 0;
        for (int k = (1 - n); k < (n - 1); k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if ((i - j) == k) {
                        if (data[i][j] == 2) {
                            dem++;
                            if (dem == 5) {
                                gameOver = true;
                                button[i][j].setTextColor(getResources().getColor(R.color.colorAccent));
                                button[i - 1][j - 1].setTextColor(getResources().getColor(R.color.colorAccent));
                                button[i - 2][j - 2].setTextColor(getResources().getColor(R.color.colorAccent));
                                button[i - 3][j - 3].setTextColor(getResources().getColor(R.color.colorAccent));
                                button[i - 4][j - 4].setTextColor(getResources().getColor(R.color.colorAccent));
                                break;
                            }
                        } else {
                            dem = 0;
                        }
                    }
                }
            }
        }
    }

    public void eval() {//danh gia chon nuoc di cho may(mI,mJ)
        int e[][] = new int[n][n];//diem danh gia tu 0-99
        //1.cho 0 o co cho 1 o trong
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (data[i][j] != 0) {
                    e[i][j] = 0;
                } else {
                    e[i][j] = 1;
                }
            }
        }
        //2.danh gia theo hang
        {
            //danh gia theo quan x
            int dT = 0, dP = 0;//dem ben trai o (i,j) trong,dem ben phai o (i,j) trong
            int jT, jP;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (data[i][j] == 0) {
                        jT = j - 1;//o ben trai ij
                        dT = 0;//dem ben trai cac X lien tuc
                        while (jT >= 0 && data[i][jT] == 1) {
                            dT++;
                            jT--;
                        }
                        dP = 0;
                        jP = j + 1;
                        while (jP < n && data[i][jP] == 1) { // dem ben phai khac x lien tuc
                            dP++;
                            jP++;
                        }
                        //dem xong cho diem
                        if ((dT + dP) >= 4) {
                            e[i][j] = 90;
                        }
                        if ((dT + dP == 3)) {
                            //du 3 x neu trong 2 dau thi cho 50
                            if (jT >= 0 && data[i][jT] == 0 && jP < n && data[i][jP] == 0) {
                                e[i][j] += 50;
                            }
                            //neu dung bien trai hoac ben trai bi chan cho 10
                            if (jT < 0 || (jT >= 0 && data[i][jT] == 2)) {
                                e[i][j] += 10;
                            }
                            //neu dung bien phai hoac ben phai bi chan cho 10
                            if (jP >= n || (jP < n && data[i][jP] == 2)) {
                                e[i][j] += 10;
                            }
                        }
                    }
                }
            }
            dT = 0;
            dP = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (data[i][j] == 0) {
                        jT = j - 1;//o ben trai ij
                        dT = 0;//dem ben trai cac X lien tuc
                        while (jT >= 0 && data[i][jT] == 2) {
                            dT++;
                            jT--;
                        }
                        dP = 0;
                        jP = j + 1;
                        while (jP < n && data[i][jP] == 2) { // dem ben phai khac x lien tuc
                            dP++;
                            jP++;
                        }
                        //dem xong cho diem
                        if ((dT + dP) >= 4) {
                            e[i][j] = 95;
                        }
                        if ((dT + dP == 3)) {
                            //du 3 x neu trong 2 dau thi cho 50
                            if (jT >= 0 && data[i][jT] == 0 && jP < n && data[i][jP] == 0) {
                                e[i][j] += 55;
                            }
                            //neu dung bien trai hoac ben trai bi chan cho 10
                            if (jT < 0 || (jT >= 0 && data[i][jT] == 2)) {
                                e[i][j] += 15;
                            }
                            //neu dung bien phai hoac ben phai bi chan cho 10
                            if (jP >= n || (jP < n && data[i][jP] == 2)) {
                                e[i][j] += 15;
                            }
                        }
                        if ((dT + dP == 2)) {
                            e[i][j] += 5;
                        }
                        if ((dT + dP == 1)) {
                            e[i][j] += 1;
                        }
                    }
                }
            }
        }
        //3.danh gia theo cot
        //quan X
        {
            int demT, demD, iT, iD;//tren va duoi
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (data[i][j] == 0) {//danh gia o trong
                        demT = 0;
                        iT = i - 1;
                        while (iT >= 0 && data[iT][j] == 1) {
                            demT++;
                            iT--;//di len
                        }
                        demD = 0;
                        iD = i + 1;
                        while (iD < n && data[iD][j] == 1) {
                            demD++;
                            iD++;//di len
                        }
                        //dem xong cho diem
                        if ((demD + demT) >= 4) {
                            e[i][j] = 90;
                        }
                        if ((demD + demT) >= 3) {
                            //dung bien tren hay bi chan tren, cho 10
                            if (iT < 0 || (iT >= 0 && data[iT][j] == 2)) {
                                e[i][j] += 10;
                            }
                            //dung bien duoi hay bi chan duoi, cho 10
                            if (iD >= n || (iD < n && data[iD][j] == 2)) {
                                e[i][j] += 10;
                            }
                            //neu trong 2 dau cho diem cho 50
                            if (iD < n && data[iD][j] == 0 && iT >= 0 && data[iT][j] == 0) {
                                e[i][j] += 50;
                            }
                        }
                    }
                }
            }//het quan X
            //quan O
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (data[i][j] == 0) {//danh gia o trong
                        demT = 0;
                        iT = i - 1;
                        while (iT >= 0 && data[iT][j] == 2) {
                            demT++;
                            iT--;//di len
                        }
                        demD = 0;
                        iD = i + 1;
                        while (iD < n && data[iD][j] == 2) {
                            demD++;
                            iD++;//di len
                        }
                        //dem xong cho diem
                        if ((demD + demT) >= 4) {
                            e[i][j] = 90;
                        }
                        if ((demD + demT) >= 3) {
                            //dung bien tren hay bi chan tren, cho 10
                            if (iT < 0 || (iT >= 0 && data[iT][j] == 1)) {
                                e[i][j] += 15;
                            }
                            //dung bien duoi hay bi chan duoi, cho 10
                            if (iD >= n || (iD < n && data[iD][j] == 1)) {
                                e[i][j] += 15;
                            }
                            //neu trong 2 dau cho diem cho 50
                            if (iD < n && data[iD][j] == 0 && iT >= 0 && data[iT][j] == 0) {
                                e[i][j] += 55;
                            }
                        }
                        if ((demD + demT) == 2) {
                            e[i][j] += 5;
                        }
                        if ((demD + demT) == 1) {
                            e[i][j] += 1;
                        }
                    }
                }
            }//het quan O
        }
        //4.danh gia theo cheo len
        {
            //quan X
            int demL, demX, iL, iX, jL, jX;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (data[i][j] == 0) {
                        //dem len
                        demL = 0;
                        iL = i - 1;
                        jL = j + 1;
                        while (iL >= 0 && jL < n && data[iL][jL] == 1) {
                            demL++;
                            iL--;
                            jL++;
                        }
                        demX = 0;
                        iX = i + 1;
                        jX = j - 1;
                        while (iX < n && jX >= 0 && data[iX][jX] == 1) {
                            demX++;
                            iX++;
                            jX--;
                        }
                        //dem xong cho diem
                        if ((demX + demL) >= 4) {
                            e[i][j] = 90;
                        }
                        if ((demX + demL) == 3) {
                            //dung bien tren hoac chan tren cho 10
                            if (iL < 0 || jL >= n || (iL >= 0 && jL < n && data[iL][jL] == 2)) {
                                e[i][j] += 10;
                            }
                            //dung bien duoi hoac chan duoi cho 10
                            if (iX >= n || jX < 0 || (iX < n && jX >= 0 && data[iX][jX] == 2)) {
                                e[i][j] += 10;
                            }
                            //hai dau trong cho 50
                            if (iL >= 0 && jL < n && data[iL][jL] == 0 && iX < n && jX >= 0 && data[iX][jX] == 0) {
                                e[i][j] += 50;
                            }
                        }
                    }
                }
            }
            //quan O
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (data[i][j] == 0) {
                        //dem len
                        demL = 0;
                        iL = i - 1;
                        jL = j + 1;
                        while (iL >= 0 && jL < n && data[iL][jL] == 2) {
                            demL++;
                            iL--;
                            jL++;
                        }
                        demX = 0;
                        iX = i + 1;
                        jX = j - 1;
                        while (iX < n && jX >= 0 && data[iX][jX] == 2) {
                            demX++;
                            iX++;
                            jX--;
                        }
                        //dem xong cho diem
                        if ((demX + demL) >= 4) {
                            e[i][j] = 90;
                        }
                        if ((demX + demL) == 3) {
                            //dung bien tren hoac chan tren cho 10
                            if (iL < 0 || jL >= n || (iL >= 0 && jL < n && data[iL][jL] == 1)) {
                                e[i][j] += 15;
                            }
                            //dung bien duoi hoac chan duoi cho 10
                            if (iX >= n || jX < 0 || (iX < n && jX >= 0 && data[iX][jX] == 1)) {
                                e[i][j] += 15;
                            }
                            //hai dau trong cho 50
                            if (iL >= 0 && jL < n && data[iL][jL] == 0 && iX < n && jX >= 0 && data[iX][jX] == 0) {
                                e[i][j] += 55;
                            }
                        }
                    }
                }
            }
        }
        //5.danh gia theo cheo xuong
        //sau khi danh gia, tim cho di
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (max < e[i][j]) {
                    max = e[i][j];//max la diem cao nhat
                }
            }
        }

        Random r = new Random();
        do {
            mI = r.nextInt(n);
            mJ = r.nextInt(n);
        } while (e[mI][mJ] != max);//may se chon o nay (mI,mJ)
    }

    class Click implements View.OnClickListener {
        int i, j;

        public Click(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public void onClick(View view) {
            if (!gameOver && luotdi == 1) {
                if (data[i][j] == 0) {
                    button[i][j].setText("X");
                    luotdi = 2;
                    //---
                    data[i][j] = 1;
                    checkWin();
                }
            }
            if (!gameOver) {
                eval();
                button[mI][mJ].setText("O");
                luotdi = 1;
                //---
                data[mI][mJ] = 2;
                checkWin();
            }
        }
    }
}

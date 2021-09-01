package com.company;

import java.util.ArrayList;
import java.util.List;

/*
    Списки, стеки или очереди T(1..n) и U(1..n) содержат результаты n-измерений
    тока и напряжения на неизвестном сопротивлении R.
    Найти приближенное число R методом наименьших квадратов.
*/

public class Main {

    public static List<Double> table_I() {
        ArrayList<Double> list = new ArrayList<>();
        double number = 0.1;
        for(int i = 0; i < 20; i++) {
            number += 0.1;
            list.add(number);
        }
        return list;
    }

    public static List<Double> table_U() {
        ArrayList<Double> list = new ArrayList<>();
        double number = 0.27;
        for(int i = 0; i < 20; i++) {
            number += 0.27;
            list.add(number);
        }
        return list;
    }

    public static double find_R(List<Double> T, List<Double> U) {
        double R = 0.0;
        if(T.size() == U.size())
        {
            double temp_I = 0.0;
            double temp_U_I = 0.0;
            for (int i = 0; i < T.size(); i++) {
                temp_U_I = temp_U_I + (T.get(i) * U.get(i));
                temp_I = temp_I + Math.pow(T.get(i), 2);
            }
            R = temp_U_I / temp_I;
        }
        return R;
    }

    public static void main(String[] args) {
      System.out.println("Приближенное значение сопротивления: " + find_R(table_I(), table_U()));
    }
}

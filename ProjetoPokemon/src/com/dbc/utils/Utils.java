package com.dbc.utils;

import java.text.DecimalFormat;
import java.util.Random;
import java.util.Scanner;

public class Utils {
    final static DecimalFormat DECIMAL_FORMAT_MONETARIO = new DecimalFormat("#,##0.00");
    final static Random random = new Random();
    final static DecimalFormat DECIMAL_FORMAT_2CASAS = new DecimalFormat("#0.00");

    public static Integer sortearNumero(Integer range) {
        return random.nextInt(range);
    }

    public static Double sortearNumeroDouble(Double range) {
        return random.nextDouble(range);
    }

    public static String formatarDouble(Double valor){
        return "R$" + DECIMAL_FORMAT_MONETARIO.format(valor);
    }

    public static String formatarDouble2casas(Double valor) {
        return DECIMAL_FORMAT_2CASAS.format(valor);
    }
}
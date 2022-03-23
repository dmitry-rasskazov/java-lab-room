package com.company.laba6;

import java.util.Arrays;

public class AggregateFunctions {
     public static int max(int ... series) {
          int result = series[0];

          for(int current: series) {
               result = Math.max(current, result);
          }

          return result;
     }

     public static int min(int ... series) {
          int result = series[0];

          for(int current: series) {
               result = Math.min(current, result);
          }

          return result;
     }

     public static int median(int ... series) {
          Arrays.sort(series);

          int medianIndex = series.length / 2;

          return series[medianIndex];
     }
}

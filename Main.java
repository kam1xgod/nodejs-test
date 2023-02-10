import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
  public static void main(String[] args) {
    String[] testCities = {"Москва", "Санкт-Петербург", "Воронеж"};
    Integer[] testArrOne = {1, 3, 4, 6, 123, 45, 32, 64};
    Integer[] testArrTwo = {463, 32, 64, 21, 65, 12, 12, 23};
    System.out.println(firstTask(testCities));
    System.out.println(secondTask(2.5f));
    System.out.println(thirdTask(30));
    System.out.println(fourthTask(30));
    System.out.println(Arrays.toString(fifthTask(testArrOne, testArrTwo)));
    sixthTask(5);
  }

  public static String firstTask(String[] cities) { // 1 минута на написание кода и проверку.
    StringBuilder result = new StringBuilder();

    for (int i = 0; i < cities.length; i++) {
      if (i == cities.length - 1) {
        result.append(cities[i] + ".");
      } else {
        result.append(cities[i] + ", ");
      }
    }

    return result.toString();
  }

  public static float secondTask(float num) { // 2 минуты.
    float lowNum = (float) Math.floor((double) num + 2.5);

    for (int i = 0; i < 5; i++) {
      if (lowNum % 5 == 0) {
        return lowNum;
      }
      lowNum--;
    }
    return 0;
  }

  public static String thirdTask(int amount) { // 4 минуты.
    int lastDigit = amount % 100 / 10;

    if (lastDigit == 1) {
      return amount + " компьютеров";
    }

    switch (amount % 10) {
      case 1:
        return amount + " компьютер";
      case 2:
      case 3:
      case 4:
        return amount + " компьютера";
      default:
        return amount + " компьютеров";
    }
  }

  public static boolean fourthTask(int num) { // 1 минута.
    if (num < 4 || num == 5) {
      return true;
    }
    return num % 2 != 0 || num % 3 != 0 || num % 5 != 0;
  }

  public static Integer[] fifthTask(Integer[] firstArr, Integer[] secondArr) { // 7 минут.
    Map<Integer, Integer> map = new HashMap<>();

    Stream.of(firstArr).forEach(x -> map.put(x, map.merge(x, 1, Integer::sum)));
    Stream.of(secondArr).forEach(x -> map.put(x, map.merge(x, 1, Integer::sum)));

    return map.entrySet().stream()
        .filter(entry -> entry.getValue() > 1)
        .map(Map.Entry::getKey)
        .collect(Collectors.toList())
        .toArray(new Integer[0]);
  }

  public static void sixthTask(int num) { // 5 минут. правда, работает код до 9х9.
    StringBuilder sb = new StringBuilder();
    sb.append("  ");
    int digits = String.valueOf(num * num).length();
    for (int i = 0; i <= num; i++) {
      if (i != 0) {
        sb.append(i).append(" ");
      }
      for (int j = 1; j <= num; j++) {
        if (j != 1) {
          int curDigits = String.valueOf(i * j).length();
          for (int k = 0; k <= digits - curDigits; k++) {
            sb.append(" ");
          }
        }
        if (i == 0) {
          sb.append((j));
        } else {
          sb.append(i * j);
        }
        if (j == num) {
          sb.append("\n");
        }
      }
    }
    System.out.println(sb.toString());
  }
}

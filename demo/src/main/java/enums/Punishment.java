package enums;

import java.util.ArrayList;

public class Punishment {
  private static ArrayList<String> punishmentList;

  {
    punishmentList = new ArrayList<>();
    punishmentList.add("Phạt tiền");
    punishmentList.add("Khóa thẻ 1 tháng");
    punishmentList.add("Khóa thẻ 2 tháng");
    punishmentList.add("Khóa thẻ 6 tháng");
  }

  public static ArrayList<String> getPunishment(){
    return punishmentList;
  }
}

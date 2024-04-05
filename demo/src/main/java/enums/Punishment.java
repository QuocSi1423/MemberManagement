package enums;

import java.util.ArrayList;

public class Punishment {
  private static ArrayList<String> punishmentList;

  {
    punishmentList = new ArrayList<>();
    punishmentList.add("Bồi thường");
    punishmentList.add("Khóa thẻ 1 tháng");
    punishmentList.add("Khóa thẻ 2 tháng");
    punishmentList.add("Khóa thẻ 1 tháng + bồi thường");
    punishmentList.add("Khóa thẻ 2 tháng + bồi thường");
    punishmentList.add("Khóa thẻ vĩnh viễn");
  }

  public static ArrayList<String> getPunishment(){
    return punishmentList;
  }
}

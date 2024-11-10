package store.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String welcomeMessage = "안녕하세요. W편의점입니다.";
    private static final String enterProduct = "\n구매하실 상품명과 수량을 입력해 주세요. (예: [사이다-2],[감자칩-1])";
    private static final String enterMembership = "멤버십 할인을 받으시겠습니까? (Y/N)";
    private static final String enterOtherProducts = "감사합니다. 구매하고 싶은 다른 상품이 있나요? (Y/N)";

    public void displayWelcomeMessage() {
        System.out.println(welcomeMessage);
    }

    public String getProduct(){
        System.out.println(enterProduct);
        return Console.readLine();
    }

    public String getMembership(){
        System.out.println(enterMembership);
        return Console.readLine();
    }

    public String getOtherProduct(){
        System.out.println(enterOtherProducts);
        return Console.readLine();
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel;


/**
 *
 * @author me
 */
public class Food {

    private String FoodCategory; // 음식 카테고리
    private String FoodName; // 음식명
    private int FoodPrice; // 음식가격
    public static int OrderNumber = 0; // 주문번호 ..처음은 0번

    public Food(String FoodCategory, String FoodName, int FoodPrice) {// 생성자 초기화
        this.FoodCategory = FoodCategory;
        this.FoodName = FoodName;
        this.FoodPrice = FoodPrice;
    }

   

  

    public String getFoodCategory() { // 음식 카테코리 리턴
        return FoodCategory;
    }

    public void setFoodCategory(String FoodCategory) {// 음식 카테코리 설정
        this.FoodCategory = FoodCategory;
    }

    public String getFoodName() { // 음식 이름 리턴
        return FoodName;
    }

    public void setFoodName(String FoodName) {// 음식 이름 설정
        this.FoodName = FoodName;
    }

    public int getFoodPrice() {// 음식 가격 리턴
        return FoodPrice;
    }

    public void setFoodPrice(int FoodPrice) {// 음식 가격 설정
        this.FoodPrice = FoodPrice;
    }

    public static int getOrderNumber() {//주문번호
        return ++OrderNumber; // 1, 2, 3, 4....
    }

}

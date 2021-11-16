/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel;


import java.util.Scanner;

/**
 *
 * @author me
 */
public class Menu {

    int num, count; // num: 선택, count: 음식수량
    int sum; // 총 매출액

    Scanner sc = new Scanner(System.in);

    Food[][] food = {{new Food("음료", "콜라", 1000), new Food("음료", "사이다", 900), new Food("음료", "밀키스", 700), new Food("음료", "마운틴듀", 700), new Food("음료", "부산우유", 1500)},
    {new Food("면류", "신라면", 3000), new Food("면류", "매운우동", 3500), new Food("면류", "스파게티", 4000), new Food("면류", "막국수", 4500), new Food("면류", "칼국수", 5000)},
    {new Food("밥류", "돼지국밥", 5500), new Food("밥류", "카레밥", 6000), new Food("밥류", "돈까스덮밥", 6500), new Food("밥류", "카레밥", 6000), new Food("밥류", "참치김밥", 3000)},
    {new Food("주류", "카스", 4000), new Food("주류", "칭따오", 3500), new Food("주류", "대선", 4500), new Food("주류", "참이슬", 4300), new Food("주류", "진로", 3900)},
    {new Food("치킨류", "후라이드치킨", 15000), new Food("치킨류", "양념치킨", 17000), new Food("치킨류", "깐풍치킨", 19000), new Food("치킨류", "간장치킨", 20000), new Food("치킨류", "양파치킨", 18000)}
    };//행이 5고 열이 5인 고정된 크기가됨

    // 직원 메뉴
    public void staffMenu() {
        while (true) {
            System.out.println("1. 메뉴 주문");
            System.out.println("2. 이전으로 돌아가기");
            System.out.println("3. 종료");
            System.out.print(">> ");
            num = sc.nextInt();
            if (num == 1) {// 1. 메뉴 주문
                System.out.println("1. 음료");
                System.out.println("2. 면류");
                System.out.println("3. 밥류");
                System.out.println("4. 주류");
                System.out.println("5. 치킨류");
                System.out.print(">> ");
                num = sc.nextInt();
                if (num < 1 || num > 5) {
                    System.out.println("잘못 입력하였습니다. 다시입력해주세요!!!");
                    continue;// 반복문 처음으로
                }
                food(num); // 음식 주문받기 함수 불러옴
                break;
            } else if (num == 2) {// 2. 이전으로 돌아가기
                //이전 화면 함수()
                break;
            } else if (num == 3) {// 3. 종료
                System.out.println("종료합니다.");
                System.exit(0);//프로그램 종료
            } else {
                System.out.println("잘못 입력하였습니다. 다시입력해주세요!!!");
                continue;// 반복문 처음으로
            }
        }//while
    }

    // 매니져 메뉴
    public void manageMenu() {
        while (true) {
            System.out.println("----------------메뉴----------------");
            System.out.println("1. 메뉴 목록~~");
            System.out.println("2. 메뉴 추가(등록)");
            System.out.println("3. 메뉴 변경");
            System.out.println("4. 메뉴 삭제");
            System.out.println("5. 총 매출액");
            System.out.println("6. 매니저 직원 선택 메뉴로..");
            System.out.println("7. 종료");
            System.out.println("-----------------------------------");
            System.out.print(">> ");
            num = sc.nextInt();
            if (num == 1) {//1. 메뉴 목록
                String[] foodname = {"음료", "면류", "밥류", "주류", "치킨류"};
                for (int i = 0; i < 5; i++) {
                    int k = 1;
                    System.out.printf("------------%s 메뉴판----------------------%n", foodname[i]);
                    for (int j = 0; j < 5; j++) {//food[num-1].length -> 해당 열의 갯수  ==>  즉, 음식 목록을 출력하죠.
                        System.out.printf("%d. %s %5d원\n", k++, food[i][j].getFoodName(), food[i][j].getFoodPrice());
                    }
                }
                continue;// 반복문 처음으로
            } else if (num == 2) {// 2. 메뉴 추가(등록) 
                System.out.println("-----------------------------------");
                System.out.println("카테고리를 선택하세요.");
                System.out.println("1. 음료");
                System.out.println("2. 면류");
                System.out.println("3. 밥류");
                System.out.println("4. 주류");
                System.out.println("5. 치킨류");
                System.out.print(">> ");
                num = sc.nextInt();
                if (num < 1 || num > 5) {
                    System.out.println("잘못 입력하였습니다. 다시입력해주세요!!!");
                    continue;// 반복문 처음으로
                }
                add(num);// 메뉴 추가(등록) 함수()
                break;
            } else if (num == 3) {//3. 메뉴 변경
                System.out.println("-----------------------------------");
                System.out.println("변경할 카테고리를 선택하세요.");
                System.out.println("1. 음료");
                System.out.println("2. 면류");
                System.out.println("3. 밥류");
                System.out.println("4. 주류");
                System.out.println("5. 치킨류");
                System.out.print(">> ");
                num = sc.nextInt();
                change(num);
                continue;// 반복문 처음으로
            } else if (num == 4) {//4. 메뉴 삭제
                System.out.println("-----------------------------------");
                System.out.println("삭제할 카테고리를 선택하세요.");
                System.out.println("1. 음료");
                System.out.println("2. 면류");
                System.out.println("3. 밥류");
                System.out.println("4. 주류");
                System.out.println("5. 치킨류");
                System.out.print(">> ");
                num = sc.nextInt();
                if (num < 1 || num > 5) {
                    System.out.println("잘못 입력하였습니다. 다시입력해주세요!!!");
                    continue;// 반복문 처음으로
                }
                delete(num);
                continue;// 반복문 처음으로
            } else if (num == 5) {// 5. 총 매출액
                System.out.println("총 매출액 : " + sum + "원");
                //5. 매니저 직원 선택 메뉴로..가는 함수()
                break;
            } else if (num == 6) {//6. 매니저 직원 선택 메뉴로..
                //5. 매니저 직원 선택 메뉴로..가는 함수()
                break;
            } else if (num == 7) {//7.종료
                System.out.println("종료합니다.");
                System.exit(0);// 프로그램 종료
            } else {
                System.out.println("잘못 입력하였습니다. 다시입력해주세요!!!");
                continue;//반복문 처음으로
            }
        }
    }

// 음식 주문받기 
    public void food(int number) {
        String foodname = null;
        if (number == 1) {
            foodname = "음료";
        } else if (number == 2) {
            foodname = "면류";
        } else if (number == 3) {
            foodname = "밥류";
        } else if (number == 4) {
            foodname = "주류";
        } else if (number == 5) {
            foodname = "치킨류";
        }
        System.out.printf("---------------%s 메뉴----------------%n", foodname);

        for (int i = 0; i < food[number - 1].length; i++) { //food[num-1].length -> 해당 열의 갯수  ==>  즉, 음식 목록을 출력하죠.
            System.out.printf("%d. %s %5d원\n", i + 1, food[number - 1][i].getFoodName(), food[number - 1][i].getFoodPrice());
        }

        System.out.println("음식을 선택하세요. ");
        System.out.print(">> ");
        num = sc.nextInt();

        System.out.println("수량을 적어주세요. ");
        System.out.print(">> ");
        count = sc.nextInt();

        System.out.println("-----------------------------------");
        bill(num, count, number - 1); //nums는 행이죠? 
    }

    //음식 추가하는 함수..
    public void add(int num) {
        String foodname = null;
        if (num == 1) {
            foodname = "음료";
        } else if (num == 2) {
            foodname = "면류";
        } else if (num == 3) {
            foodname = "밥류";
        } else if (num == 4) {
            foodname = "주류";
        } else if (num == 5) {
            foodname = "치킨류";
        }
        System.out.printf("--------------%s 메뉴 추가--------------%n", foodname);
        System.out.println("음식명과 가격을 순서대로 적어주세요.");
        for (int i = 0; i < 5; i++) {
            System.out.print("[" + (i + 1) + "] >> ");
            food[num - 1][i] = new Food(foodname, sc.next(), sc.nextInt());
        }
        System.out.println("추가완료!");
        //매니저 직원 메뉴로..가는 함수()
    }

    //음식 변경하는 함수..
    public void change(int num) {
        String foodname = null;
        if (num == 1) {
            foodname = "음료";
        } else if (num == 2) {
            foodname = "면류";
        } else if (num == 3) {
            foodname = "밥류";
        } else if (num == 4) {
            foodname = "주류";
        } else if (num == 5) {
            foodname = "치킨류";
        }
        System.out.printf("--------------%s 현재 메뉴--------------%n", foodname);
        for (int i = 0; i < food[num - 1].length; i++) { //food[num-1].length -> 해당 열의 갯수  ==>  즉, 음식 목록을 출력하죠.
            System.out.printf("%d. %s %5d원\n", i + 1, food[num - 1][i].getFoodName(), food[num - 1][i].getFoodPrice());
        }
        System.out.println("변경할 메뉴를 선택하세요");
        System.out.print(">>");
        int number = sc.nextInt();
        System.out.println("변경할 이름을 입력하세요");
        System.out.print(">>");
        String fname = sc.next();
        System.out.println("변경할 가격을 입력하세요");
        System.out.print(">>");
        int fprice = sc.nextInt();
        food[num - 1][number-1] = new Food(foodname, fname, fprice);
        System.out.println("변경완료!");
        //매니저 직원 메뉴로..가는 함수()
    }

    //음식 삭제하는 함수..
    public void delete(int num) {
        String foodname = null;
        if (num == 1) {
            foodname = "음료";
        } else if (num == 2) {
            foodname = "면류";
        } else if (num == 3) {
            foodname = "밥류";
        } else if (num == 4) {
            foodname = "주류";
        } else if (num == 5) {
            foodname = "치킨류";
        }
        System.out.printf("--------------%s 현재 메뉴--------------%n", foodname);
        for (int i = 0; i < food[num - 1].length; i++) { //food[num-1].length -> 해당 열의 갯수  ==>  즉, 음식 목록을 출력하죠.
            System.out.printf("%d. %s %5d원\n", i + 1, food[num - 1][i].getFoodName(), food[num - 1][i].getFoodPrice());
        }
        System.out.println("삭제할 음식 번호");
        System.out.print(">>");
        int number = sc.nextInt();
        food[num - 1][number - 1] = new Food(foodname, "---", 0);
        System.out.println("삭제 완료!");
        //매니저 직원 메뉴로..가는 함수()
    }

    // 영수증 빌지
    public void bill(int num, int count, int number) {
        int apay = food[number][num].getFoodPrice() * count ;
        num = num - 1;
        System.out.println("----------------주문내역-----------------");
        System.out.println("카테고리 : " + food[number][num].getFoodCategory());
        System.out.println("음식명 : " + food[number][num].getFoodName());
        System.out.println("수량 : " + count);
        System.out.println("가격 : " + apay + "원");

        sum = sum + food[number][num].getFoodPrice() * count;//비용합산
        if (Food.OrderNumber >= 999) { // 주문번호가 999 이상일 경우 0으로 초기화 
            Food.OrderNumber = 0;
        }
        System.out.println("주문번호 : " + Food.getOrderNumber());
        System.out.println("이용해 주셔서 감사합니다.");
        System.out.println("------------------------------------");
        //손님 관리자 메뉴로...함수()
    }

    public int getCount() { // 수량 리턴
        return count;
    }

}

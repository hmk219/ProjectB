
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class BookPlay implements Book {

	final String SUCCESS = "일치하는도서를 출력합니다.";
	final String FAIL = "일치하는 도서가 없습니다. 다시 입력해주세요.";
	final String EMPTY = "등록된 도서가 없습니다.";
	final String MENU = "\n<<<도서검색 메뉴입니다.>>>"; 

	BookVo bookVo = new BookVo();
	Scanner sc = new Scanner(System.in);
	int num = 0;		//도서 번호
	
	ArrayList<BookVo> booklist = new ArrayList<>(); 

	// 도서검색 메뉴
	@Override
	public void searchMenu() {	
			System.out.println(MENU + "\n1.제목검색 2.저자검색 3.번호검색 4.출판사검색 5.전체조회");
			int menu = sc.nextInt();
			switch(menu) {
				case 1:
					searchForName();
					break;
				case 2:
					searchForAuthor();
					break;
				case 3:
					searchForNum();
					break;
				case 4:
					searchForPublisher();
					break;
				case 5:
					showBookInfo();
					break;
				default:
					System.out.println("메뉴에 있는 번호 입력해주세요");
			}
	}
	
	// 도서제목으로 검색
	@Override
	public void searchForName() {
		System.out.print("도서제목으로 검색합니다.\n제목 입력 : ");
		String BookTitle = sc.next();	
		for(int i = 0; i < booklist.size(); i++) {
				BookVo a = booklist.get(i);
				String num = a.getbTitle(); 
				if(BookTitle.equalsIgnoreCase(num)) {
					System.out.println(SUCCESS);
					System.out.println("제목 : " + a.getbTitle());
					System.out.println("저자 : " + a.getbAuthor());
					System.out.println("출판사 : " + a.getbPublisher());
					System.out.println("번호 : " + a.getbNum());
					System.out.println("재고 : " + a.getbStock());
					break;
				} else if(i == booklist.size()-1) {
					System.out.println(FAIL);
				} else if(booklist.equals(null)) {
					System.out.println(EMPTY);
				}
			}
	}
	
	// 도서번호로 검색
	@Override
	public void searchForNum() {
		System.out.print("도서번호로 검색합니다.\n번호 입력 : ");
		int BookNum = sc.nextInt();	
		for(int i = 0; i < booklist.size(); i++) {
				BookVo a = booklist.get(i);
				if(BookNum == num) {
					System.out.println(SUCCESS);
					System.out.println("제목 : " + a.getbTitle());
					System.out.println("저자 : " + a.getbAuthor());
					System.out.println("출판사 : " + a.getbPublisher());
					System.out.println("번호 : " + a.getbNum());
					System.out.println("재고 : " + a.getbStock());
					break;
				} else if(i == booklist.size()-1) {
					System.out.println(FAIL);
				}
		}
	}
	
	// 도서저자로 검색
	@Override
	public void searchForAuthor() {
		System.out.print("도서저자로 검색합니다.\n저자 입력 : ");
		String BookAuthor = sc.next();	
		for(int i = 0; i < booklist.size(); i++) {
				BookVo a = booklist.get(i);
				String num = a.getbAuthor(); 
				if(BookAuthor.equalsIgnoreCase(num)) {
					System.out.println(SUCCESS);
					System.out.println("제목 : " + a.getbTitle());
					System.out.println("저자 : " + a.getbAuthor());
					System.out.println("출판사 : " + a.getbPublisher());
					System.out.println("번호 : " + a.getbNum());
					System.out.println("재고 : " + a.getbStock());
					break;
				} else if(i == booklist.size()-1) {
					System.out.println(FAIL);
				} 
		}

	}
	
	// 도서출판사로 검색	
	@Override
	public void searchForPublisher() {

		System.out.print("도서출판사로 검색합니다.\n출판사 입력 : ");
		String BookPublisher = sc.next();	
		for(int i = 0; i < booklist.size(); i++) {
				BookVo a = booklist.get(i);
				String num = a.getbPublisher(); 
				if(BookPublisher.equalsIgnoreCase(num)) {
					System.out.println(SUCCESS);
					System.out.println("제목 : " + a.getbTitle());
					System.out.println("저자 : " + a.getbAuthor());
					System.out.println("출판사 : " + a.getbPublisher());
					System.out.println("번호 : " + a.getbNum());
					System.out.println("재고 : " + a.getbStock());
					break;
				} else if(i == booklist.size()-1) {
					System.out.println(FAIL);
				}
		}
	}
	
	//도서전체목록 조회
	@Override
	public void showBookInfo() {
    	for(int i = 0; i < booklist.size(); i++) {
    		System.out.printf("======== %d번째 도서 ========%n", i+1);
        	BookVo a = booklist.get(i);
        	System.out.println("제목 : " + a.getbTitle());
        	System.out.println("출판사 : " + a.getbPublisher());
        	System.out.println("저자 : " + a.getbAuthor());
        	System.out.println("번호 : " + a.getbNum());
        	System.out.println("재고 : " + a.getbStock());
    	}
	}

	//도서 등록
	@Override
	public void addBook() {
		while (true) {
            System.out.println("책 제목 :");
            bookVo.setbTitle(sc.nextLine());
            System.out.println("작가: ");
            bookVo.setbAuthor(sc.nextLine());
            System.out.println("출판사 :");
            bookVo.setbPublisher(sc.nextLine());
            System.out.println("수량 :");
            bookVo.setbStock(sc.nextInt());
 
            /**확인하기*/
            System.out.println(bookVo.getbTitle() + "/" + bookVo.getbAuthor() + "/" + bookVo.getbPublisher() + "/" +bookVo.getbStock());            
            System.out.println("입력하신 사항이 모두 맞습니까?");           
            System.out.println("[YES] 1/ [NO] 2");
            int check = sc.nextInt();
            
            if (check == 1) {
            	booklist.add(bookVo);
                num++;						//도서번호에 1씩 증가하는 번호 부여
                bookVo.setbNum(num);
                System.out.println(bookVo.getbNum() + "/" + bookVo.getbTitle() + "/" + bookVo.getbAuthor() + "/" + bookVo.getbPublisher() + "/" +
                		bookVo.getbStock());
                System.out.println("등록 완료");
                sc.nextLine();
                break;
            } else if (check == 2) {
                System.out.println("다시 입력해주세요");
            } else {
                System.out.println("잘못 누르셨습니다. 메인 화면으로 이동합니다");
                break; 
            } //end if-else
            }// end while
       } 
	
	//도서 삭제(제목 이용)
	@Override
	public void deleteBook() {
		String name;
		 while (true) {
	            System.out.println("삭제 할 도서 제목을 입력해주세요");
	            name = sc.nextLine();
	            int cnt = 0;
	            for (int i = 0; i < booklist.size(); i++) {
	                if (name.equals(booklist.get(i).getbTitle())) {
	                	System.out.println(booklist.get(i).getbTitle() + "를 정말 삭제하겠습니까?");
	                	System.out.println("[YES]1 / [NO]2 / [돌아가기]0");
	                	int select = sc.nextInt();
	                	if(select == 1) {
	                		booklist.remove(i);
		                    cnt++;
		                    System.out.println("도서 삭제 완료");
		                    sc.nextLine();
		                    break;
	                	}else if(select == 2) {
	                		System.out.println("다시 입력하세요");
	                		break;
	                	}else {
	                		System.out.println("잘못 누르셨습니다. 메인 화면으로 이동합니다");
	                        break;
	                	}	                		
	                }
	            } // end for
	            if (cnt == 0) {
	                System.out.println("해당 도서가 존재하지 않습니다. 다시 입력하세요.");
	            } else {
	                break;// 메인으로
	            }
	        } // end while
	}
	
	@Override
	public void rendBook() {
		 Scanner sc = new Scanner(System.in);
			Calendar cal =Calendar.getInstance();
		     SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		     
	  System.out.println("대여할 책 번호를 입력하세요 : ");
	  String bNum = sc.nextLine();
	  int idx = findListIndex(bNum);
	  if (idx == -1)
	   System.out.println("등록되지 않은 번호입니다.");
	  else {
	   if (booklist.get(idx).isLoaned()) {
	    System.out.println("대여중입니다.");}
	   
	   else {
	    System.out.println("대여완료");
	    System.out.println("대여일 : "+df.format(cal.getTime()));
	    cal.add(Calendar.DATE,7);
	    System.out.println("반납일 : "+df.format(cal.getTime()));
	    booklist.get(idx).setLoaned(true);
	   }
	  }
	 }

	@Override
	public void backBook() {

		 Scanner sc = new Scanner(System.in);
			Calendar cal =Calendar.getInstance();
		     SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	  System.out.println("반납할 책의 번호를 입력하세요");
	  String bNum = sc.nextLine();
	  int idx = findListIndex(bNum);
	  if (idx == -1)
	   System.out.println("등록되지 않은 번호입니다.");
	  else {
	   if (booklist.get(idx).isLoaned()) {
	    System.out.println("반납 완료.");
	    cal.add(Calendar.DATE,7);
	    System.out.println("반납일 : "+df.format(cal.getTime()));
	   } else
	    System.out.println("대여중인 도서가 아닙니다.");
	  }
	 }

	public int findListIndex(String id) {
	  for (int i = 0; i < booklist.size(); i++) {
	   if (booklist.get(i).equals(id))
	    return i;
	  }
	  return -1;
	 }

	public boolean findId(String id) {
	  for (int i = 0; i < booklist.size() - 1; i++) {
	   if (booklist.get(i).equals(id))
	    return true;
	  }
	  return false;
	}

}
	 

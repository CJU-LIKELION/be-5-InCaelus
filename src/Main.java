import java.util.Scanner;

public class Main {
    public static void main(String[] academylion) {
        Scanner scanner = new Scanner(System.in);
        MemberRepository repository = null;

        // 1. 저장소 선택 화면 (Step 2 핵심 기능)
        System.out.println("🔨 저장소를 선택하세요:");
        System.out.println("1. MemoryMemberRepository (실제 저장)");
        System.out.println("2. MockMemberRepository (더미 데이터)");
        System.out.print("선택: ");
        int repoChoice = scanner.nextInt();
        scanner.nextLine();
        if (repoChoice == 1) {
            repository = new MemoryMemberRepository();
            System.out.println("-> MemoryMemberRepository가 주입되었습니다.\n");
        } else if (repoChoice == 2) {
            repository = new MockMemberRepository();
            System.out.println("-> MockMemberRepository가 주입되었습니다.\n");
        } else {
            System.out.println("잘못된 선택입니다. 기본적으로 Memory 저장소를 사용합니다.");
            repository = new MemoryMemberRepository();
        }

        // 의존성 주입 (DI) 실행
        MemberService memberService = new MemberService(repository);

        while (true) {
            System.out.println("\n🐯 ===== 멋사 멤버 관리 시스템 (Step 2: DI 적용) ===== 🐯");
            System.out.println("1. ➕ 멤버 등록");
            System.out.println("2. 📋 전체 멤버 조회");
            System.out.println("3. 🔍 이름으로 검색");
            System.out.println("4. 🚪 종료");
            System.out.print("선택: ");

            int menuChoice = scanner.nextInt();
            scanner.nextLine();

            if (menuChoice == 1) {
                // 멤버 등록 화면
                System.out.print("\n👤 역할 선택 (1: 아기사자, 2: 운영진): ");
                int roleChoice = scanner.nextInt();
                scanner.nextLine();

                System.out.println("\n📝 정보 입력");
                System.out.print("이름: ");
                String name = scanner.nextLine();
                System.out.print("전공: ");
                String major = scanner.nextLine();
                System.out.print("기수: ");
                int gen = scanner.nextInt();
                scanner.nextLine();
                System.out.print("파트: ");
                String part = scanner.nextLine();

                if (roleChoice == 1) {
                    System.out.print("학번: ");
                    String studentId = scanner.nextLine();
                    memberService.registerMember(new BabyLion(name, major, gen, part, studentId));
                } else if (roleChoice == 2) {
                    System.out.print("직책 (예: 회장/파트장): ");
                    String role = scanner.nextLine();
                    memberService.registerMember(new Staff(name, major, gen, part, role));
                } else {
                    System.out.println("잘못된 역할 선택입니다.");
                }

            } else if (menuChoice == 2) {
                // 전체 조회
                memberService.showAllMembers();

            } else if (menuChoice == 3) {
                // 이름 검색
                System.out.print("\n🔍 검색할 이름: ");
                String searchName = scanner.nextLine();
                memberService.searchMember(searchName);

            } else if (menuChoice == 4) {
                System.out.println("프로그램을 종료합니다.");
                break;
            } else {
                System.out.println("올바른 번호를 입력해 주세요.");
            }
        }
        scanner.close();
    }
}
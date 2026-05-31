import java.util.List;

public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public boolean registerMember(Member member) {
        if (memberRepository.existsByName(member.getName())) {
            System.out.println("❌ 등록 실패: 이미 존재하는 이름입니다. (" + member.getName() + ")");
            return false;
        }
        memberRepository.save(member);
        System.out.println("\n✅ 등록 완료: " + member.getName());
        return true;
    }

    public void showAllMembers() {
        List<Member> members = memberRepository.findAll();
        if (members.isEmpty()) {
            System.out.println("등록된 멤버가 없습니다.");
            return;
        }
        System.out.println("\n===== 전체 멤버 조회 =====");
        for (Member m : members) {
            m.printDetail();
            System.out.println("-------------------------");
        }
    }

    public void searchMember(String name) {
        Member member = memberRepository.findByName(name);
        if (member == null) {
            System.out.println("❌ 해당 이름의 멤버를 찾을 수 없습니다.");
            return;
        }
        System.out.println("\n===== 검색 결과 =====");
        member.printDetail();
    }
}
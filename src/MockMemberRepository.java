import java.util.ArrayList;
import java.util.List;

public class MockMemberRepository implements MemberRepository {
    private final List<Member> dummyMembers = new ArrayList<>();

    public MockMemberRepository() {
        dummyMembers.add(new BabyLion("김사자", "컴퓨터공학과", 14, "백엔드", "202020202"));
        dummyMembers.add(new Staff("이운영", "소프트웨어학과", 13, "프론트엔드", "회장"));
    }

    @Override
    public void save(Member member) {
        System.out.println("[Mock] 더미 저장소이므로 실제 저장이 되지 않습니다.");
    }

    @Override
    public Member findByName(String name) {
        for (Member m : dummyMembers) {
            if (m.getName().equals(name)) {
                return m;
            }
        }
        return null;
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(dummyMembers);
    }

    @Override
    public boolean existsByName(String name) {
        return findByName(name) != null;
    }
}
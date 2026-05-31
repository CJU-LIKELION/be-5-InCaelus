import java.util.ArrayList;
import java.util.List;

public class MemoryMemberRepository implements MemberRepository {
    private final List<List<Member>> store = new ArrayList<>();
    private final List<Member> members = new ArrayList<>();

    @Override
    public void save(Member member) {
        members.add(member);
    }

    @Override
    public Member findByName(String name) {
        for (Member m : members) {
            if (m.getName().equals(name)) {
                return m;
            }
        }
        return null;
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(members);
    }

    @Override
    public boolean existsByName(String name) {
        return findByName(name) != null;
    }
}
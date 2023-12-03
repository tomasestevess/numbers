import com.aor.numbers.GenericListSorter
import com.aor.numbers.ListDeduplicator
import spock.lang.Specification

class ListDeduplicatorSpockTest extends Specification{

    private def list
    private def expected

    def helper(){
        list = Arrays.asList(1,2,4,2,5)
        expected = Arrays.asList(1,2,4,5)
    }
    def 'Testing deduplicate'() {
        given:
            GenericListSorter sorter = Mock(GenericListSorter.class)
            def deduplicator = new ListDeduplicator(sorter)
            sorter.sort(_) >> Arrays.asList(1, 2, 2, 4, 5)
        when:
            def distinct = deduplicator.deduplicate(list)
        then:
            expected == distinct;
    }

    def 'Testing deduplicate_bug_8726'() {
        given:
            def sorter = Mock(GenericListSorter.class)
            def deduplicator = new ListDeduplicator(sorter)
            sorter.sort(_) >> Arrays.asList(1, 2, 2, 4)
        when:
            def distinct = deduplicator.deduplicate(Arrays.asList(1, 2, 4, 2))
        then:
            Arrays.asList(1, 2, 4) == distinct
    }
}
